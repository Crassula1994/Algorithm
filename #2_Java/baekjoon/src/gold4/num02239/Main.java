package gold4.num02239;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 스도쿠 판의 상태를 저장할 2차원 배열 sudokuBoard 초기화
	static int[][] sudokuBoard = new int[9][9];
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// for 반복문을 사용해 스도쿠 판의 행을 순회
		for (int r = 0; r < 9; r++) {
			
			// readLine() 메서드를 사용해 입력 받은 스도쿠 판의 행을 변수 line에 할당
			String line = in.readLine();
			
			// for 반복문을 사용해 스도쿠 판의 상태를 2차원 배열 sudokuBoard에 저장
			for (int c = 0; c < 9; c++)
				sudokuBoard[r][c] = line.charAt(c) - '0';
		}
		
		// blankFiller() 메서드를 호출해 스도쿠의 빈 칸을 채우기
		blankFiller(0, 0, out);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// blankFiller() 메서드 정의
	public static void blankFiller(int row, int column, BufferedWriter out) throws IOException {
		
		// 스도쿠의 열 범위를 벗어난 경우 
		if (column == 9) {
			
			// 다음 행의 칸에 대해 blankFiller() 메서드 재귀 호출 후 메서드 종료
			blankFiller(row + 1, 0, out);
			return;
		}
		
		// 스도쿠의 행 범위를 벗어난 경우
		if (row == 9) {
			
			// for 반복문을 사용해 각 칸의 숫자를 출력
			for (int r = 0; r < 9; r++) {
				for (int c = 0; c < 9; c++)
					out.write(String.valueOf(sudokuBoard[r][c]));
				
				// newLine() 메서드를 사용해 줄바꿈 출력
				out.newLine();
			}
			
			// flush() 메서드를 사용해 스도쿠 판의 내용을 출력
			out.flush();
			
			// exit() 메서드를 사용해 JVM을 정상 종료
			System.exit(0);
		}
		
		// 해당 칸이 빈 칸인 경우
		if (sudokuBoard[row][column] == 0) {
			
			// for 반복문을 사용해 1부터 9까지의 숫자를 순회
			for (int n = 1; n < 10; n++) {
				
				// 해당 숫자가 들어갈 수 있는 경우 해당 숫자를 저장 후 blankFiller() 메서드 재귀 호출
				if (numberChecker(row, column, n)) {
					sudokuBoard[row][column] = n;
					blankFiller(row, column + 1, out);
				}
			}
			
			// 어떠한 숫자도 넣을 수 없는 경우 해당 칸을 빈 칸으로 초기화 후 메서드 종료
			sudokuBoard[row][column] = 0;
			return;
		}
		
		// 다음 칸에 대하여 blankFiller() 메서드 재귀 호출
		blankFiller(row, column + 1, out);
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// numberChecker() 메서드 정의
	public static boolean numberChecker(int row, int column, int number) {
		
		// for 반복문을 사용해 해당 빈 칸이 있는 행을 순회
		for (int c = 0; c < 9; c++) {
			
			// 해당 칸에 숫자가 이미 존재하는 경우 false 반환
			if (sudokuBoard[row][c] == number)
				return false;
		}
		
		// for 반복문을 사용해 해당 빈 칸이 있는 열을 순회
		for (int r = 0; r < 9; r++) {
			
			// 해당 칸에 숫자가 이미 존재하는 경우 false 반환
			if (sudokuBoard[r][column] == number)
				return false;
		}
		
		// 해당 빈 칸이 존재하는 3 × 3 크기의 보드의 왼쪽 상단 칸 위치를 각 변수에 할당
		int startRow = row / 3 * 3;
		int startCol = column / 3 * 3;
		
		// for 반복문을 사용해 해당 빈 칸이 존재하는 3 × 3 크기의 보드의 각 칸을 순회
		for (int r = startRow; r < startRow + 3; r++) {
			for (int c = startCol; c < startCol + 3; c++) {
				
				// 해당 칸에 숫자가 이미 존재하는 경우 false 반환
				if (sudokuBoard[r][c] == number)
					return false;
			}
		}
		
		// 해당 숫자를 해당 칸에 넣을 수 있는 경우 true 반환
		return true;
	}
}