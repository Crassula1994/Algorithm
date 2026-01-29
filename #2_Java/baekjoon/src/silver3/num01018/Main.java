package silver3.num01018;

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
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 보드판의 크기를 각 변수에 할당
		int row = Integer.parseInt(st.nextToken());
		int column = Integer.parseInt(st.nextToken());
		
		// 보드판을 저장할 2차원 배열 board 초기화
		char[][] board = new char[row][column];
		
		// 다시 칠해야 하는 정사각형의 최소 개수를 저장할 변수 minSquare 초기화
		int minSquare = Integer.MAX_VALUE;
		
		// 다시 칠해야 하는 정사각형의 개수를 저장할 변수 count 초기화
		int count = 0;
		
		// for 반복문을 사용해 보드판의 각 행을 순회
		for (int r = 0; r < row; r++) {
			
			// readLine() 메서드를 사용해 입력 받은 보드판의 행을 변수 line에 할당
			String line = in.readLine();
			
			// for 반복문을 사용해 보드판의 각 열을 순회
			for (int c = 0; c < column; c++)
				
				// charAt() 메서드를 사용해 입력받은 행을 배열 board의 각 열에 저장
				board[r][c] = line.charAt(c);
		}
		
		// for 반복문을 사용해 8 × 8 크기를 차례로 순회
		for (int r = 0; r < row - 7; r++) {
			for (int c = 0; c < column - 7; c++) {
				
				// colorChecker() 메서드를 호출해 다시 칠해야 하는 정사각형의 개수를 반환
				count = colorChecker(r, c, board);
				
				// 현재 저장된 정사각형의 최소 개수보다 적은 경우 개수 갱신
				minSquare = (count < minSquare) ? count : minSquare;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 다시 칠해야 하는 정사각형의 최소 개수 출력
		out.write(String.valueOf(minSquare));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// colorChecker() 메서드 정의
	public static int colorChecker(int row, int column, char[][] board) {
		
		// 다시 칠해야 하는 정사각형의 개수를 저장할 변수 cnt 초기화
		int cnt = 0;
		
		// 왼쪽 상단의 색깔을 변수 firstColor에 할당
		char firstColor = board[row][column];
		
		// for 반복문을 사용해 8 × 8 크기를 차례로 순회
		for (int r = row; r < row + 8; r++) {
			for (int c = column; c < column + 8; c++) {
				
				// 해당 위치의 색깔이 체스판의 색깔과 다른 경우 개수 갱신
				if (board[r][c] != firstColor) cnt++;
				
				// 열이 바뀔 때마다 비교하는 색상을 변경
				firstColor = (firstColor == 'B') ? 'W' : 'B';
			}
			
			// 행이 바뀔 때마다 비교하는 색상을 변경
			firstColor = (firstColor == 'B') ? 'W' : 'B';
		}
		
		// 값이 32보다 큰 경우 바꿔야 하는 정사각형의 개수를 변경
		cnt = (cnt > 32) ? 64 - cnt : cnt;
		
		// 다시 칠해야 하는 정사각형의 개수를 반환
		return cnt;
	}
}