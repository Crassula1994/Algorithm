package silver2.num11123;

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
	
	// 그리드의 높이와 넓이를 나타낼 각 변수 초기화
	static int height;
	static int width;
	
	// 인접한 위치를 나타낼 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// 그리드의 상태를 저장할 2차원 배열 grid 초기화
	static char[][] grid;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 그리드의 높이와 넓이를 각 변수에 할당
			height = Integer.parseInt(st.nextToken());
			width = Integer.parseInt(st.nextToken());
			
			// 양이 이룬 무리의 수를 저장할 변수 groupNum 초기화
			int groupNum = 0;
			
			// 그리드의 상태를 저장할 2차원 배열 grid 초기화
			grid = new char[height][width];
			
			// for 반복문을 사용해 입력 받은 그리드의 상태를 2차원 배열 grid에 저장
			for (int r = 0; r < height; r++)
				grid[r] = in.readLine().toCharArray();
			
			// for 반복문을 사용해 각 그리드의 칸을 순회
			for (int r = 0; r < height; r++) {
				for (int c = 0; c < width; c++) {
				
					// 해당 그리드의 칸이 풀인 경우 다음 칸을 순회
					if (grid[r][c] == '.')
						continue;
					
					// groupChecker() 메서드를 호출해 양의 무리를 확인
					groupChecker(r, c);
					
					// 양이 이룬 무리의 수를 갱신
					groupNum++;
				}
			}
			
			// write() 메서드를 사용해 양이 이룬 무리의 수를 출력
			out.write(groupNum + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// groupChecker() 메서드 정의
	public static void groupChecker(int startRow, int startCol) {
		
		// 다음에 확인할 위치를 저장할 Queue 객체 checkList 초기화
		Queue<int[]> checkList = new LinkedList<>();
		
		// offer() 메서드를 사용해 시작 양의 위치를 checkList에 추가 및 확인 처리
		checkList.offer(new int[] {startRow, startCol});
		grid[startRow][startCol] = '.';
		
		// while 반복문을 사용해 checkList가 빌 때까지 순회
		while (!checkList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 위치를 배열 curLocation에 할당
			int[] curLoc = checkList.poll();
			
			// for 반복문을 사용해 인접한 위치를 순회
			for (int d = 0; d < 4; d++) {
				
				// 인접한 위치를 각 변수에 할당
				int nr = curLoc[0] + dr[d];
				int nc = curLoc[1] + dc[d];
				
				// 해당 위치가 그리드의 범위를 벗어나거나 풀인 경우 다음 위치를 순회
				if (nr < 0 || nr >= height || nc < 0 || nc >= width || grid[nr][nc] == '.')
					continue;
				
				// offer() 메서드를 사용해 해당 양의 위치를 checkList에 추가 및 확인 처리
				checkList.offer(new int[] {nr, nc});
				grid[nr][nc] = '.';
			}
		}
	}
}