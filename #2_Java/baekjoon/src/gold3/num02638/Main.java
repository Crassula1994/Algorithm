package gold3.num02638;

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
	
	// 모눈종이의 크기, 치즈가 녹아 없어지는 데 걸리는 시간을 저장할 각 변수 초기화
	static int height;
	static int width;
	static int totalTime = 0;
	
	// 인접한 위치를 탐색할 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// 현재 모눈종이의 상태를 저장할 2차원 배열 graphPaper 초기화
	static int[][] graphPaper;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 모눈종이의 크기를 각 변수에 할당
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		
		// 현재 모눈종이의 상태를 저장할 2차원 배열 graphPaper 초기화
		graphPaper = new int[height][width];
		
		// for 반복문을 사용해 모눈종이의 각 행을 순회
		for (int r = 0; r < height; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 모눈종이의 상태를 2차원 배열 graphPaper에 저장
			for (int c = 0; c < width; c++)
				graphPaper[r][c] = Integer.parseInt(st.nextToken());
		}
		
		// timeCalculator() 메서드를 호출해 치즈가 녹아 없어지는 데 걸리는 시간을 갱신
		timeCalculator(0);
		
		// valueOf() 및 write() 메서드를 사용해 치즈가 녹아 없어지는 데 걸리는 시간를 출력
		out.write(String.valueOf(totalTime));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// timeCalculator() 메서드 정의
	public static void timeCalculator(int curTime) {
		
		// 외부 공기와 접한 모눈종이의 위치를 저장할 Queue 객체 checkList 초기화
		Queue<int[]> checkList = new LinkedList<>();
		
		// offer() 메서드를 사용해 왼쪽 모서리 끝의 위치를 checkList에 추가 및 확인 처리
		checkList.offer(new int[] {0, 0});
		graphPaper[0][0] = -(curTime + 1);
		
		// while 반복문을 사용해 checkList가 빌 때까지 순회
		while (!checkList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 위치를 배열 curLoc에 할당
			int[] curLoc = checkList.poll();
			
			// for 반복문을 사용해 인접한 위치를 순회
			for (int d = 0; d < 4; d++) {
				
				// 인접한 위치를 각 변수에 할당
				int nr = curLoc[0] + dr[d];
				int nc = curLoc[1] + dc[d];
				
				// 인접한 위치가 모눈종이의 범위를 벗어난 경우 다음 위치를 순회
				if (nr < 0 || nr >= height || nc < 0 || nc >= width)
					continue;
				
				// 인접한 위치를 이미 확인했거나 치즈인 경우 다음 위치를 순회
				if (graphPaper[nr][nc] == -(curTime + 1) || graphPaper[nr][nc] == 1)
					continue;
				
				// offer() 메서드를 사용해 인접한 위치를 checkList에 추가 및 확인 처리
				checkList.offer(new int[] {nr, nc});
				graphPaper[nr][nc] = -(curTime + 1);
			}
		}
		
		// 치즈가 모두 녹은 경우 치즈가 녹아 없어지는 데 걸리는 시간을 갱신 후 메서드 종료
		if (cheeseChecker(curTime)) {
			totalTime = curTime;
			return;
		}
		
		// timeCalculator() 메서드 재귀 호출
		timeCalculator(curTime + 1);
	}
	
	// ----------------------------------------------------------------------------------------------------

	// cheeseChecker() 메서드 정의
	public static boolean cheeseChecker(int curTime) {
		
		// 치즈가 모두 녹았는지를 나타내는 변수 isEmpty 초기화
		boolean isEmpty = true;
		
		// for 반복문을 사용해 모눈종이의 각 칸을 순회
		for (int r = 0; r < height; r++) {
			for (int c = 0; c < width; c++) {
				
				// 치즈가 존재하는 경우
				if (graphPaper[r][c] == 1) {
					
					// 치즈가 모두 녹았는지를 나타내는 변수 갱신
					isEmpty = false;
					
					// 외부 공기와 접촉한 면의 개수를 저장할 변수 count 초기화
					int count = 0;
					
					// for 반복문을 사용해 인접한 위치를 순회
					for (int d = 0; d < 4; d++) {
						
						// 인접한 위치를 각 변수에 할당
						int nr = r + dr[d];
						int nc = c + dc[d];
						
						// 인접한 위치가 모눈종이의 범위를 벗어난 경우 다음 위치를 순회
						if (nr < 0 || nr >= height || nc < 0 || nc >= width)
							continue;
						
						// 인접한 위치가 외부 공기인 경우 외부 공기와 접촉한 면의 개수를 갱신
						if (graphPaper[nr][nc] == -(curTime + 1))
							count++;
					}
					
					// 외부 공기와 접촉한 면의 개수가 두 개 이상이나 경우 치즈가 녹은 것으로 처리
					if (count >= 2)
						graphPaper[r][c] = 0;
				}
			}
		}
		
		// 치즈가 모두 녹았는지 여부를 반환
		return isEmpty;
	}
}