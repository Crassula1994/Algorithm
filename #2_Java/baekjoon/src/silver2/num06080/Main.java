package silver2.num06080;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 지도의 크기를 저장할 각 변수 초기화
	static int rowNum;
	static int columnNum;
	
	// 인접한 위치를 저장할 각 델타 배열 초기화
	static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
	static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};
	
	// 지도에 위치한 풀의 높이를 저장할 2차원 배열 map 초기화
	static int[][] map;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 지도의 크기를 각 변수에 할당
		rowNum = Integer.parseInt(st.nextToken());
		columnNum = Integer.parseInt(st.nextToken());
		
		// 나쁜 풀로 이루어진 섬의 수를 저장할 변수 islandNum 초기화
		int islandNum = 0;
		
		// 지도에 위치한 풀의 높이를 저장할 2차원 배열 map 초기화
		map = new int[rowNum][columnNum];
		
		// for 반복문을 사용해 지도의 각 행을 순회
		for (int r = 0; r < rowNum; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 입력 받은 풀의
			for (int c = 0; c < columnNum; c++)
				map[r][c] = Integer.parseInt(st.nextToken());
		}
		
		// for 반복문을 사용해 지도의 각 칸을 순회
		for (int r = 0; r < rowNum; r++) {
			for (int c = 0; c < columnNum; c++) {
				
				// 해당 지도의 칸에 좋은 풀이 있는 경우 다음 칸을 순회
				if (map[r][c] == 0)
					continue;
				
				// 나쁜 풀로 이루어진 섬의 수를 갱신
				islandNum++;
				
				// islandFinder() 메서드를 사용해 나쁜 풀로 이루어진 섬을 확인 처리
				islandFinder(r, c);
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 나쁜 풀로 이루어진 섬의 수를 출력
		out.write(String.valueOf(islandNum));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// islandFinder() 메서드 정의
	public static void islandFinder(int startRow, int startColumn) {
		
		// 다음에 확인할 칸의 위치를 저장할 Queue 객체 cellList 초기화
		Queue<int[]> cellList = new LinkedList<>();
		
		// offer() 메서드를 사용해 cellList에 시작 위치를 추가 및 확인 처리
		cellList.offer(new int[] {startRow, startColumn});
		map[startRow][startColumn] = 0;
		
		// while 반복문을 사용해 cellList가 빌 때까지 순회
		while (!cellList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 위치를 배열 curLocation에 할당
			int[] curLocation = cellList.poll();
			
			// for 반복문을 사용해 현재 위치와 인접한 위치를 순회
			for (int d = 0; d < 8; d++) {
				
				// 인접한 위치의 행과 열을 각 변수에 할당
				int nr = curLocation[0] + dr[d];
				int nc = curLocation[1] + dc[d];
				
				// 해당 위치가 지도의 범위를 벗어나는 경우 다음 위치를 순회
				if (nr < 0 || nr >= rowNum || nc < 0 || nc >= columnNum)
					continue;
				
				// 해당 위치에 좋은 풀이 있거나 이미 확인한 곳인 경우 다음 위치를 순회
				if (map[nr][nc] == 0)
					continue;
				
				// offer() 메서드를 사용해 cellList에 해당 위치를 추가 및 확인 처리
				cellList.offer(new int[] {nr, nc});
				map[nr][nc] = 0;
			}
		}
	}
}