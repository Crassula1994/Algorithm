package silver1.num18290;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 격자판의 크기, 선택할 칸의 수, 선택한 칸에 있는 수를 모두 더한 값의 최댓값을 저장할 각 변수 초기화
	static int height;
	static int width;
	static int targetCount;
	static int maxSum = Integer.MIN_VALUE;
	
	// 인접한 칸을 나타낼 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// 격자판에 들어있는 수 및 해당 숫자의 선택 여부를 저장할 각 2차원 배열 초기화
	static int[][] grid;
	static boolean[][] selected;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 격자판의 크기 및 선택할 칸의 수를 각 변수에 할당
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		maxSum = Integer.parseInt(st.nextToken());
		
		// 격자판에 들어있는 수 및 해당 숫자의 선택 여부를 저장할 각 2차원 배열 초기화
		grid = new int[height][width];
		selected = new boolean[height][width];
		
		// for 반복문을 사용해 격자판의 각 행을 순회
		for (int r = 0; r < height; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 입력 받은 격자판에 들어있는 수를 2차원 배열 grid에 저장
			for (int c = 0; c < width; c++)
				grid[r][c] = Integer.parseInt(in.readLine());
		}
		
		// maxSumFinder() 메서드를 호출해 선택한 칸에 있는 수를 모두 더한 값의 최댓값을 갱신
		maxSumFinder(0, 0, 0, 0);
		
		// valueOf() 및 write() 메서드를 사용해 선택한 칸에 있는 수를 모두 더한 값의 최댓값을 출력
		out.write(String.valueOf(maxSum));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// maxSumFinder() 메서드 정의
	public static void maxSumFinder(int count, int sum, int curRow, int curColumn) {
		
		// 모든 칸을 선택한 경우 선택한 칸에 있는 수를 모두 더한 값의 최댓값을 갱신 후 메서드 종료
		if (count == targetCount) {
			maxSum = Math.max(sum, maxSum);
			return;
		}
		
		// 현재 칸이 
		
		// for 반복문을 사용해 시작 행부터 각 행을 순회
//		for (int r = startRow; r < height; r++) {
//			
//			// 시작 칸의 위치를 행별로 계산해 변수 sc에 할당
//			int sc = (r == startRow) ? startColumn : 0;
//			
//			// for 반복문을 사용해 각 칸을 순회
//			for (int c = sc; c < width; c++) {
//				
//				//
//				
//				
//			}
//		}
	}
}