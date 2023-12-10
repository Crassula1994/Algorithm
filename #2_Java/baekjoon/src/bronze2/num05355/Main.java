package bronze2.num05355;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 차례로 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseDouble() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
			double number = Double.parseDouble(st.nextToken());
			
			// while 반복문을 사용해 각 연산자를 순회
			while (st.hasMoreTokens()) {
				
				// nextToken() 및 charAt() 메서드를 사용해 입력 받은 연산자를 변수 operator에 할당
				char operator = st.nextToken().charAt(0);
				
				// switch 조건문을 사용해 각 연산자에 따라 연산을 수행
				switch (operator) {
					case '@':
						number *= 3;
						break;
					case '%':
						number += 5;
						break;
					default:
						number -= 7;
				}
			}
			
			// format() 및 write() 메서드를 사용해 결과를 계산해 소수점 둘째 자리까지 출력
			out.write(String.format("%.2f", number) + "\n");
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}