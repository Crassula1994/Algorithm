package bronze1.num2999;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 메서드를 사용해 입력 받은 상근이가 받은 메시지를 변수 message에 할당
		String message = in.readLine();
		
		// 행렬의 크기를 나타낼 각 변수 초기화
		int row = 0;
		int column = 0;
		
		// for 반복문을 사용해 행렬의 크기를 순회
		for (int r = 1; r <= Math.sqrt(message.length()); r++) {
			
			// 행의 길이로 나누어 떨어지고 저장된 행의 크기보다 큰 경우 행렬의 크기 갱신
			if (message.length() % r == 0 && r > row) {
				row = r;
				column = message.length() / r;
			}
		}
		
		// 입력 받은 메시지를 옮길 2차원 행렬 matrix를 초기화
		char[][] matrix = new char[row][column];
		
		// for 반복문을 통해 배열 matrix의 각 열을 순회
		for (int c = 0, idx = 0; c < column; c++) {
			
			// for 반복문을 통해 배열 matrix의 각 행을 순회
			for (int r = 0; r < row; r++)

				// charAt() 메서드를 사용해 메시지를 matrix에 저장
				matrix[r][c] = message.charAt(idx++);
		}
		
		// for 반복문을 통해 배열 matrix의 각 행을 순회
		for (int r = 0; r < row; r++) {
			
			// for 반복문을 통해 배열 matrix의 각 열을 순회하며 메시지 출력
			for (int c = 0; c < column; c++)
				out.write(matrix[r][c]);
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}