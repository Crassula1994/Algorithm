package silver4.num1018;

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
				
				// 왼쪽 상단 끝이 'W'인 경우
				if (board[r][c] == 'W') {
					
					if 
					
				}
				
			}
			
		}
		
		// valueOf() 및 write() 메서드를 사용해 다시 칠해야 하는 정사각형의 최소 개수 출력
		out.write(String.valueOf(minSquare));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}