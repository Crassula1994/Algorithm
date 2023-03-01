package gold4.num02580;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 입력 받은 스도쿠 판을 저장할 2차원 배열 sudoku 초기화
	static int[][] sudoku = new int[9][9];
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// for 반복문을 사용해 스도쿠 판의 각 행을 순회
		for (int r = 0; r < 9; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 스도쿠 판의 각 열을 순회하며 스도쿠 판에 값을 저장
			for (int c = 0; c < 9; c++)
				sudoku[r][c] = Integer.parseInt(st.nextToken());
		}

		// sudokuMaker() 메서드를 호출해 가능한 정답을 출력
		sudokuMaker(0, 0, out);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// sudokuMaker() 메서드 정의
	public static void sudokuMaker(int row, int column, BufferedWriter out) throws IOException {
		
		// 해당 행을 완성한 경우 다음 행을 검사할 수 있도록 sudokuMaker() 메서드 재귀 호출 후 함수 종료
		if (column == 9) {
			sudokuMaker(row + 1, 0, out);
			return;
		}
		
		// 스도쿠를 모두 완성한 경우
		if (row == 9) {
			
			// for 반복문을 사용해 스도쿠 판의 각 행을 순회
			for (int r = 0; r < 9; r++) {
				
				// for 반복문을 사용해 스도쿠 판의 각 열을 순회하며 값을 출력
				for (int c = 0; c < 9; c++)
					out.write(sudoku[r][c] + " ");
				
				// newLine() 메서드를 사용해 줄바꿈을 출력
				out.newLine();
			}
			
			// flush() 메서드를 사용해 지금까지의 내용을 출력
			out.flush();
			
			// exit() 메서드를 사용해 JVM 정상 종료
			System.exit(0);
		}
		
		// 해당 칸이 0인 경우
		if (sudoku[row][column] == 0) {
			
			// for 반복문을 사용해 1부터 9까지의 숫자 중 가능한 숫자를 순회
			for (int num = 1; num <= 9; num++) {
				
				// 해당 숫자를 넣을 수 있는 경우
				if (rowChecker(row, column, num) && colChecker(row, column, num) && boxChecker(row, column, num)) {
					
					// 해당 숫자를 빈 칸에 갱신 후 sudokuMaker() 메서드 재귀 호출
					sudoku[row][column] = num;
					sudokuMaker(row, column + 1, out);
				}
			}
			
			// 1부터 9까지 넣어보아도 답을 구성할 수 없는 경우 값 초기화 후 함수 종료
			sudoku[row][column] = 0;
			return;
			
		// 해당 칸이 0이 아닌 경우 다음 칸을 검사하도록 sudokuMaker() 메서드 재귀 호출
		} else {
			sudokuMaker(row, column + 1, out);
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// rowChecker() 메서드 정의
	public static boolean rowChecker(int row, int column, int possibleNum) {
		
		// for 반복문을 사용해 해당 행을 차례로 순회
		for (int c = 0; c < 9; c++) {
			
			// 해당 행에 또 다른 possibleNum이 있을 경우 false 반환
			if (sudoku[row][c] == possibleNum)
				return false;
		}
		
		// possibleNum을 넣을 수 있는 경우 true 반환
		return true;
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// colChecker() 메서드 정의
	public static boolean colChecker(int row, int column, int possibleNum) {
		
		// for 반복문을 사용해 해당 열을 차례로 순회
		for (int r = 0; r < 9; r++) {
			
			// 해당 열에 또 다른 possibleNum이 있을 경우 false 반환
			if (sudoku[r][column] == possibleNum)
				return false;
		}
		
		// possibleNum을 넣을 수 있는 경우 true 반환
		return true;
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// boxChecker() 메서드 정의
	public static boolean boxChecker(int row, int column, int possibleNum) {
		
		// 박스의 시작점의 각 좌표를 계산해 각 변수에 할당
		int startRow = 3 * (row / 3);
		int startCol = 3 * (column / 3);
		
		// for 반복문을 사용해 박스의 각 행과 열을 차례로 순회
		for (int r = startRow; r < startRow + 3; r++) {
			for (int c = startCol; c < startCol + 3; c++) {
				
				// 해당 박스에 또 다른 possibleNum이 있을 경우 false 반환
				if (sudoku[r][c] == possibleNum)
					return false;
			}
		}
		
		// possibleNum을 넣을 수 있는 경우 true 반환
		return true;
	}
}