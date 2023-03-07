package silver3.num04375;

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
		
		// while 반복문을 사용해 모든 테스트 케이스를 순회
		while (true) {
			
			// 입력 받은 숫자를 저장할 변수 number 초기화
			int number = 0;
			
			// 예외가 발생하지 않을 경우
			try {
				
				// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
				number = Integer.parseInt(in.readLine());
			
			// 예외가 발생할 경우 반복문 탈출
			} catch (NumberFormatException e) {
				break;
			}
			
			// 자릿수 및 1로 이루어진 배수를 저장할 각 변수 초기화
			int cipher = 1;
			int dividend = 1;
			
			// while 반복문을 사용해 1로 이루어진 배수를 찾을 때까지 탐색
			while ((dividend = dividend % number) != 0) {
				
				// 자릿수 및 1로 이루어진 배수를 갱신
				dividend = dividend * 10 + 1;
				cipher++;
			}
			
			// write() 메서드를 사용해 자릿수를 출력
			out.write(cipher + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}