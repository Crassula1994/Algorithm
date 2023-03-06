package silver1.num02667;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// Main 클래스 정의
public class Main {
	
	// 집의 지도를 저장할 2차원 배열 map 초기화
	static int[][] map;
	
	// 각 집의 방문 여부를 저장할 2차원 배열 visited 초기화
	static boolean[][] visited;
	
	// 인접한 집을 탐색할 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// 지도의 크기를 저장할 변수 size 초기화
	static int size;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 지도의 크기를 변수 size에 할당
		size = Integer.parseInt(in.readLine());
		
		// 집의 지도를 저장할 2차원 배열 map 초기화
		map = new int[size][size];
		
		// 각 집의 방문 여부를 저장할 2차원 배열 visited 초기화
		visited = new boolean[size][size];
		
		// for 반복문을 사용해 배열 map의 각 행을 순회
		for (int r = 0; r < map.length; r++) {
			
			// readLine() 메서드를 통해 입력 받은 지도의 각 행을 변수 line에 할당
			String line = in.readLine();
			
			// for 반복문을 사용해 배열 map의 각 열을 순회하며 입력 받은 지도를 배열 map에 할당
			for (int c = 0; c < map.length; c++)
				map[r][c] = line.charAt(c) - '0';
		}

		// 단지 번호를 저장할 변수 complexNum 초기화
		int complexNum = 0;
		
		// for 반복문을 사용해 배열 map의 각 행과 열을 순회
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map.length; c++) {
				
				// 만약 집이고, 방문한 적이 없는 곳인 경우 complexFinder() 메서드를 호출해 각 단지별 방문 횟수를 갱신
				if (map[r][c] == 1 && !visited[r][c])
					complexFinder(r, c, ++complexNum);
			}
		}
		
		// 각 단지별 개수를 저장할 배열 complexCnt 초기화
		int[] complexCnt = new int[complexNum + 1];
		
		// for 반복문을 사용해 각 단지의 개수를 배열 complexCnt에 갱신
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				
				// 집이 있는 곳인 경우 단지번호에 해당하는 집의 개수를 갱신
				if (map[r][c] != 0)
					complexCnt[map[r][c]]++;
			}
		}
		
		// sort() 메서드를 사용해 배열 complexCnt를 오름차순으로 정렬
		Arrays.sort(complexCnt);
		
		// write() 메서드를 사용해 총 단지 수를 출력
		out.write(complexNum + "\n");
		
		// for 반복문을 사용해 단지 내 집의 수를 출력
		for (int idx = 1; idx < complexCnt.length; idx++)
			out.write(complexCnt[idx] + "\n");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// complexFinder() 메서드 정의
	public static void complexFinder(int startRow, int startCol, int complexNum) {
		
		// 시작 위치를 방문 처리 및 단지 번호 갱신
		visited[startRow][startCol] = true;
		map[startRow][startCol] = complexNum;
		
		// for 반복문을 사용해 각 델타 배열을 순회
		for (int d = 0; d < 4; d++) {
			
			// 새로운 위치를 각 변수에 할당
			int nr = startRow + dr[d];
			int nc = startCol + dc[d];
			
			// 새로운 위치가 범위를 벗어나지 않고 해당 위치에 집이 위치해 있으며 방문한 적이 없는 경우
			if (nr >= 0 && nr < size && nc >= 0 && nc < size && map[nr][nc] == 1 && !visited[nr][nc])
				
				// complexFinder() 메서드 재귀 호출
				complexFinder(nr, nc, complexNum);
		}
	}
}