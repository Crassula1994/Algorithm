package bronze3.num02935;

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
		
		// readLine(), length(), charAt() 메서드를 사용해 입력 받은 각 정수 및 연산자를 각 변수에 할당
		int numberA = in.readLine().length();
		char operator = in.readLine().charAt(0);
		int numberB = in.readLine().length();
		
		// 더하기 연산자인 경우
		if (operator == '+') {
			
			// 두 수의 길이가 같은 경우
			if (numberA == numberB) {
				
				// write() 메서드를 사용해 '2'를 출력
				out.write("2");
				
				// for 반복문을 사용해 '0'을 출력
				for (int len = 0; len < numberA - 1; len++)
					out.write("0");
			
			// 두 수의 길이가 다른 경우
			} else {
				
				// write() 메서드를 사용해 '1'을 출력
				out.write("1");
				
				// for 반복문을 사용해 각 자리를 순회
				for (int len = Math.max(numberA, numberB) - 1; len > 0; len--) {
					
					// 더 작은 숫자의 '1'의 자릿수인 경우 '1'을 출력
					if (len == Math.min(numberA, numberB)) {
						out.write("1");
						
					// 더 작은 숫자의 '1'의 자릿수가 아닌 경우 '0'을 출력
					} else {
						out.write("0");
					}
				}
			}
			
		// 곱하기 연산자인 경우
		} else {
			
			// write() 메서드를 사용해 '1'을 출력
			out.write("1");
			
			// for 반복문을 사용해 '0'을 출력
			for (int len = 0; len < numberA + numberB - 2; len++)
				out.write("0");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}