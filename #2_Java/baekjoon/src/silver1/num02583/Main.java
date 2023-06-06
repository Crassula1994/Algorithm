package silver1.num02583;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 모눈종이의 크기 및 분리되는 영역의 개수를 저장할 각 변수 초기화
	static int height;
	static int width;
	static int areaNum = 0;
	
	// 각 영역의 넓이를 저장할 PriorityQueue 객체 areas 초기화
	static PriorityQueue<Integer> areas = new PriorityQueue<>();
	
	// 인접한 위치를 나타낼 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// 모눈종이의 상태를 저장할 2차원 배열 graphPaper 초기화
	static int[][] graphPaper;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 모눈종이의 크기 및 직사각형의 개수를 각 변수에 할당
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		int squareNum = Integer.parseInt(st.nextToken());		
		
		// 모눈종이의 상태를 저장할 2차원 배열 graphPaper 초기화
		graphPaper = new int[height][width];
		
		// for 반복문을 사용해 각 직사각형을 순회
		for (int square = 0; square < squareNum; square++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 직사각형의 좌표를 각 변수에 할당
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			// for 반복문을 사용해 각 직사각형의 행과 열을 순회하며 직사각형을 표시
			for (int r = y1; r < y2; r++) {
				for (int c = x1; c < x2; c++)
					graphPaper[r][c]++;
			}
		}
		
		// for 반복문을 사용해 모눈종이의 행과 열을 순회
		for (int r = 0; r < height; r++) {
			for (int c = 0; c < width; c++) {
				
				// 해당 모눈종이가 직사각형이 아닌 경우 areaChecker() 메서드 호출
				if (graphPaper[r][c] == 0)
					areaChecker(r, c);
			}
		}
		
		// write() 메서드를 사용해 분리되는 영역의 개수를 출력
		out.write(areaNum + "\n");
		
		// while 반복문을 사용해 각 영역의 넓이를 오름차순으로 출력
		while (!areas.isEmpty())
			out.write(areas.poll() + " ");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// areaChecker() 메서드 정의
	public static void areaChecker(int startRow, int startCol) {
		
		// 해당 영역의 면적을 저장할 변수 area 초기화
		int area = 1;
		
		// 분리되는 영역의 개수를 갱신
		areaNum++;
		
		// 다음에 확인할 위치를 저장할 Queue 객체 checkList 초기화
		Queue<int[]> checkList = new LinkedList<>();
		
		// offer() 메서드를 사용해 가장 처음 확인할 위치를 checkList에 추가 및 확인 처리
		checkList.offer(new int[] {startRow, startCol});
		graphPaper[startRow][startCol]++;
		
		// while 반복문을 사용해 checkList가 빌 때까지 순회
		while (!checkList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 확인 중인 위치를 변수 currentLoc에 할당
			int[] currentLoc = checkList.poll();
			
			// for 반복문을 사용해 인접한 각 위치를 순회
			for (int d = 0; d < 4; d++) {
				
				// 인접한 위치의 좌표를 각 변수에 할당
				int nr = currentLoc[0] + dr[d];
				int nc = currentLoc[1] + dc[d];
				
				// 해당 위치가 범위를 벗어나는 경우 다음 위치를 순회
				if (nr < 0 || nr >= height || nc < 0 || nc >= width)
					continue;
				
				// 해당 위치가 직사각형 또는 이미 확인 처리한 곳인 경우 다음 위치를 순회
				if (graphPaper[nr][nc] != 0)
					continue;
				
				// offer() 메서드를 사용해 해당 위치를 checkList에 추가 및 확인 처리, 영역의 면적 갱신
				checkList.offer(new int[] {nr, nc});
				graphPaper[nr][nc]++;
				area++;
			}
		}
		
		// offer() 메서드를 사용해 해당 영역의 면적을 추가
		areas.offer(area);
	}
}