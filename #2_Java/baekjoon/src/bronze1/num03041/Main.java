package bronze1.num03041;

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
		
		// 퍼즐의 흩어짐 정도를 저장할 변수 degree 초기화
		int degree = 0;
		
		// for 반복문을 사용해 각 퍼즐의 행을 순회
		for (int r = 0; r < 4; r++) {
			
			// readLine() 메서드를 사용해 해당 퍼즐의 행을 변수 row에 할당
			String row = in.readLine();
			
			// for 반복문을 사용해 각 퍼즐의 열을 순회
			for (int c = 0; c < 4; c++) {
				
				// charAt() 메서드를 사용해 현재 위치한 퍼즐의 정사각형을 변수 square에 할당
				int square = row.charAt(c);
				
				// 빠져있는 정사각형인 경우 다음 정사각형을 순회
				if (square == '.')
					continue;
			
				// 해당 정사각형이 위치해야 하는 순서를 변수 order에 할당
				int order = square - 'A';
				
				// abs() 메서드를 사용해 퍼즐의 흩어짐 정도를 갱신
				degree += Math.abs(r - order / 4) + Math.abs(c - order % 4);
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 퍼즐의 흩어짐 정도를 출력
		out.write(String.valueOf(degree));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}