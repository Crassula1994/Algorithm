package gold4.num14500;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 입력 받은 종이의 크기를 저장할 각 변수 초기화
	static int height;
	static int width;
	
	// 인접한 칸의 좌표를 저장할 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// 종이에 쓰여 있는 숫자 및 선택 여부를 저장할 각 2차원 배열 초기화
	static int[][] paper;
	static boolean[][] selected;
	
	// 테트로미노가 놓인 칸에 쓰인 수들의 합의 최댓값을 저장할 변수 maxSum 초기화
	static int maxSum = 0;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 종이의 크기를 각 변수에 할당
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		
		// 종이에 쓰여 있는 숫자를 저장할 2차원 배열 paper 초기화
		paper = new int[height][width];
		
		// 해당 숫자를 선택했는지 여부를 저장할 2차원 배열 selected 초기화
		selected = new boolean[height][width];
		
		// for 반복문을 사용해 배열 paper의 각 행을 순회
		for (int r = 0; r < height; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 배열 paper의 각 열에 입력 받은 숫자를 저장
			for (int c = 0; c < width; c++)
				paper[r][c] = Integer.parseInt(st.nextToken());
		}
		
		// for 반복문을 사용해 배열 paper의 각 행과 열을 순회
		for (int r = 0; r < height; r++) {
			for (int c = 0; c < width; c++) {
				
				// 해당 위치 선택 처리
				selected[r][c] = true;
				
				// maxSumFinder() 메서드를 호출해 각 테트로미노가 놓인 칸에 쓰인 수들의 합의 최댓값을 갱신
				maxSumFinder(r, c, 1, paper[r][c]);
				
				// 해당 위치의 선택 여부를 다시 원상 복구
				selected[r][c] = false;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 테트로미노가 놓인 칸에 쓰인 수들의 합의 최댓값를 출력
		out.write(String.valueOf(maxSum));
	
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// maxSumFinder() 메서드 정의
	public static void maxSumFinder(int currentRow, int currentCol, int selectedCnt, int sum) {
		
		// 숫자 네 개를 모두 선택한 경우
		if (selectedCnt == 4) {
			
			// max() 메서드를 사용해 테트로미노가 놓인 칸에 쓰인 수들의 합의 최댓값을 갱신
			maxSum = Math.max(sum, maxSum);

		// 숫자 네 개를 모두 선택하지 못한 경우
		} else {
			
			// for 반복문을 사용해 인접한 위치를 차례로 순회
			for (int d = 0; d < 4; d++) {
				
				// 인접한 위치를 각 변수에 할당
				int nr = currentRow + dr[d];
				int nc = currentCol + dc[d];
				
				// 해당 위치가 종이를 벗어나지 않고 선택하지 않은 경우
				if (nr >= 0 && nr < height && nc >= 0 && nc < width && !selected[nr][nc]) {
					
					// 해당 위치 선택 처리
					selected[nr][nc] = true;
					
					// maxSumFinder() 메서드를 호출해 각 테트로미노가 놓인 칸에 쓰인 수들의 합의 최댓값을 갱신
					maxSumFinder(nr, nc, selectedCnt + 1, sum + paper[nr][nc]);
					
					// 해당 위치의 선택 여부를 다시 원상 복구
					selected[nr][nc] = false;
					
					// 숫자 두 개를 선택한 경우
					if (selectedCnt == 2) {
						
						// 해당 위치 선택 처리
						selected[nr][nc] = true;
						
						// maxSumFinder() 메서드를 호출해 요철 모양(凸) 테트로미노가 놓인 칸에 쓰인 수들의 합의 최댓값을 갱신
						maxSumFinder(currentRow, currentCol, selectedCnt + 1, sum + paper[nr][nc]);
						
						// 해당 위치의 선택 여부를 다시 원상 복구
						selected[nr][nc] = false;
					}
				}
			}
		}
	}
}