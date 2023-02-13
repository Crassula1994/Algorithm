package silver4.num2578;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 빙고판을 저장할 2차원 배열 bingo 초기화
		int[][] bingo = new int[5][5];
		
		// 사회자가 부른 수를 저장할 배열 call 초기화
		int[] call = new int[25];
		
		// 빙고의 개수를 셀 변수 count 초기화
		int count = 0;
		
		// for 반복문을 사용해 빙고판의 각 행을 순회
		for (int r = 0, idx = 0; r < 10; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// 빙고판의 수를 입력 받는 경우 
			if (r < 5) {
			
			// for 반복문을 사용해 빙고판의 각 열을 순회
			for (int c = 0; c < 5; c++)
			
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 빙고판의 수를 배열 bingo에 저장
				bingo[r][c] = Integer.parseInt(st.nextToken());
			
			// 사회자가 부른 수를 입력 받는 경우
			} else {
			
				// for 반복문을 사용해 배열 call의 각 원소를 순회
				for (int i = 0; i < 5; i++)
					
					// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 사회자가 부른 수를 배열 call에 저장
					call[idx++] = Integer.parseInt(st.nextToken());
			}
		}
		
		// for 반복문을 사용해 배열 call의 각 원소를 순회
		for (int idx = 0; idx < call.length; idx++) {
			
			// for 반복문을 사용해 빙고판의 각 행을 순회
			outer: for (int r = 0; r < 5; r++) {
				
				// for 반복문을 사용해 빙고판의 각 열을 순회
				for (int c = 0; c < 5; c++) {
					
					// 해당 값을 찾은 경우 해당 값 0으로 변경 후 반복문 탈출
					if (call[idx] == bingo[r][c]) {
						bingo[r][c] = 0;
						break outer;
					}
				}
			}
		
			// 12번 이상 사회자가 숫자를 부른 경우
			if (idx > 10) {
				
				// bingoChecker() 메서드를 호출해 빙고의 개수를 변수 count에 할당
				count = bingoChecker(bingo);
				
				// 빙고가 세 개 이상인 경우 사회자가 부른 숫자의 개수를 출력 후 반복문 탈출
				if (count >= 3) {
					out.write(String.valueOf(idx + 1));
					break;
				}
			}
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// bingoChecker() 메서드 정의
	public static int bingoChecker(int[][] bingo) {
		
		// 빙고의 개수를 저장할 변수 cnt 초기화
		int cnt = 0;
		
		// for 반복문을 사용해 각 행을 순회
		for (int r = 0; r < 5; r++) {
			
			// for 반복문을 사용해 각 열을 순회
			for (int c = 0; c < 5; c++) {
				
				// 0이 아닌 경우 반복문 탈출
				if (bingo[r][c] != 0) break;
				
				// 모든 값이 0인 경우 빙고의 개수 갱신
				if (c == 4) cnt++;
			}
		}
		
		// for 반복문을 사용해 각 열을 순회
		for (int c = 0; c < 5; c++) {
			
			// for 반복문을 사용해 각 행을 순회
			for (int r = 0; r < 5; r++) {
				
				// 0이 아닌 경우 반복문 탈출
				if (bingo[r][c] != 0) break;
				
				// 모든 값이 0인 경우 빙고의 개수 갱신
				if (r == 4) cnt++;
			}
		}
		
		// for 반복문을 사용해 대각선을 순회
		for (int d = 0; d < 5; d++) {
			
			// 0이 아닌 경우 반복문 탈출
			if (bingo[d][d] != 0) break;
			
			// 모든 값이 0인 경우 빙고의 개수 갱신
			if (d == 4) cnt++;
		}
		
		// for 반복문을 사용해 다른 쪽 대각선을 순회
		for (int d = 0; d < 5; d++) {
			
			// 0이 아닌 경우 반복문 탈출
			if (bingo[d][4 - d] != 0) break;
			
			// 모든 값이 0인 경우 빙고의 개수 갱신
			if (d == 4) cnt++;
		}
		
		// 빙고의 개수 반환
		return cnt;
	}
}