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
		targetCount = Integer.parseInt(st.nextToken());
		
		// 격자판에 들어있는 수 및 해당 숫자의 선택 여부를 저장할 각 2차원 배열 초기화
		grid = new int[height][width];
		selected = new boolean[height][width];
		
		// for 반복문을 사용해 격자판의 각 행을 순회
		for (int r = 0; r < height; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 입력 받은 격자판에 들어있는 수를 2차원 배열 grid에 저장
			for (int c = 0; c < width; c++)
				grid[r][c] = Integer.parseInt(st.nextToken());
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
		
		// 현재 칸이 격자판의 열을 벗어난 경우 다음 줄의 첫 번째 칸으로 조정
		if (curColumn >= width) {
			curRow++;
			curColumn = 0;
		}
		
		// 현재 칸이 격자판의 행을 벗어난 경우 메서드 종료
		if (curRow >= height)
			return;
		
		// for 반복문을 사용해 시작 행부터 각 행을 순회
		for (int r = curRow; r < height; r++) {
			
			// 시작 칸의 위치를 행별로 계산해 변수 sc에 할당
			int sc = (r == curRow) ? curColumn : 0;
			
			// for 반복문을 사용해 각 칸을 순회
			for (int c = sc; c < width; c++) {
				
				// 위쪽 칸을 이미 선택한 경우 다음 칸을 순회
				if (r >= 1 && selected[r - 1][c])
					continue;
				
				// 해당 칸을 선택한 것으로 처리
				selected[r][c] = true;
				
				// maxSumFinder() 메서드 재귀 호출
				maxSumFinder(count + 1, sum + grid[r][c], r, c + 2);
				
				// 해당 칸을 선택하지 않은 것으로 원상 복구
				selected[r][c] = false;
			}
		}
	}
}