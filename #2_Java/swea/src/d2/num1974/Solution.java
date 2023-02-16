package d2.num1974;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Solution 클래스 정의
public class Solution {
	
	// 해당 스도쿠가 정답인지 검증하는 변수 isComplete 변수 초기화
	static boolean isComplete = true;
	
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
			
			// isComplete 변수 초기화
			isComplete = true;
			
			// 스도쿠 퍼즐을 저장할 2차원 배열 puzzle 초기화
			int[][] puzzle = new int[9][9];
			
			// for 반복문을 사용해 배열 puzzle의 각 행을 순회
			for (int r = 0; r < 9; r++) {
				
				// StringTokenizer 객체를 불러와 변수 st에 할당
				StringTokenizer st = new StringTokenizer(in.readLine());
				
				// for 반복문을 사용해 배열 puzzle의 각 열을 순회
				for (int c = 0; c < 9; c++)
					
					// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 배열 puzzle에 저장
					puzzle[r][c] = Integer.parseInt(st.nextToken());	
			}
			
			// 스도쿠 검증이 끝나지 않은 경우 rowChecker() 메서드 실행
			if (isComplete)
				rowChecker(puzzle);
			
			// 스도쿠 검증이 끝나지 않은 경우 colChecker() 메서드 실행
			if (isComplete)
				colChecker(puzzle);
			
			// 스도쿠 검증이 끝나지 않은 경우 boxChecker() 메서드 실행
			if (isComplete)
				boxChecker(puzzle);
			
			// 스도쿠 검증 결과에 따라 정해진 문자열을 변수 answer에 할당
			if (isComplete) {
				out.write("#" + (tc + 1) + " " + 1 + "\n");
			} else {
				out.write("#" + (tc + 1) + " " + 0 + "\n");
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// rowChecker() 메서드 정의
	public static void rowChecker(int[][] puzzle) {
		
		// for 반복문을 사용해 2차원 배열의 행을 차례로 순회
		for (int r = 0; r < puzzle.length; r++) {
			
			// 각 숫자의 제곱합을 저장할 변수 sum 초기화
			int sum = 0;
			
			// for 반복문을 사용해 2차원 배열의 열을 차례로 순회하며 제곱합을 계산
			for (int c = 0; c < puzzle.length; c++)
				sum += puzzle[r][c] * puzzle[r][c];
		
			// 제곱합이 일치하지 않는 경우 스도쿠 검증 변수 갱신 후 반복문 탈출
			if (sum != 285) {
				isComplete = false;
				break;
			}	
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// colChecker() 메서드 정의
	public static void colChecker(int[][] puzzle) {
		
		// for 반복문을 사용해 2차원 배열의 열을 차례로 순회
		for (int c = 0; c < puzzle.length; c++) {
			
			// 각 숫자의 제곱합을 저장할 변수 sum 초기화
			int sum = 0;
			
			// for 반복문을 사용해 2차원 배열의 열을 차례로 순회하며 제곱합을 계산
			for (int r = 0; r < puzzle.length; r++)
				sum += puzzle[r][c] * puzzle[r][c];
		
			// 제곱합이 일치하지 않는 경우 스도쿠 검증 변수 갱신 후 반복문 탈출
			if (sum != 285) {
				isComplete = false;
				break;
			}	
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// boxChecker() 메서드 정의
	public static void boxChecker(int[][] puzzle) {
		
		// for 반복문을 사용해 2차원 배열의 행 박스를 차례로 순회
		for (int r = 0; r < 2; r++) {
			
			// for 반복문을 사용해 2차원 배열의 열 박스를 차례로 순회
			for (int c = 0; c < 2; c++) {
				
				// 각 박스의 시작 인덱스를 각 변수에 할당
				int startRowIdx = 3 * r;
				int startColIdx = 3 * c;
				
				// 각 숫자의 제곱합을 저장할 변수 sum 초기화
				int sum = 0;
				
				// for 반복문을 사용해 각 행과 열을 차례로 순회하며 제곱합을 계산
				for (int x = startRowIdx; x < startRowIdx + 3; x++) {
					for (int y = startColIdx; y < startColIdx + 3; y++)
						sum += puzzle[x][y] * puzzle[x][y];
				}
				
				// 제곱합이 일치하지 않는 경우 스도쿠 검증 변수 갱신 후 반복문 탈출
				if (sum != 285) {
					isComplete = false;
					break;
				}
			}	
		}
	}
}