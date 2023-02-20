package bronze1.num1934;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 두 숫자를 각 변수에 할당
			int num1 = Integer.parseInt(st.nextToken()); 
			int num2 = Integer.parseInt(st.nextToken());
			
			// 두 번째 숫자가 더 큰 경우 첫 번째 숫자와 순서 변경
			if (num2 > num1) {
				int temp = num1;
				num1 = num2;
				num2 = temp;
			}
			
			// 두 숫자가 같은 경우 최소공배수를 출력
			if (num1 == num2) {
				out.write(num1 + "\n");
				
			// 두 숫자가 다른 경우
			} else {
				
				// 최대공약수로 나눌 수 및 최대공약수를 저장할 변수 gcd 초기화
				int num = num1;
				int gcd = num2;
				
				// while 반복문을 사용해 최대공약수를 구할 때까지 순회
				while (true) {
					
					// 나누어 떨어지는 경우 최소공배수를 출력 후 반복문 탈출
					if (num % gcd == 0) {
						out.write(gcd * (num1 / gcd) * (num2 / gcd) + "\n");
						break;
					
					// 나누어 떨어지지 않는 경우 각 변수를 갱신
					} else {
						int temp = num;
						num = gcd;
						gcd = temp % gcd;
					}
				}
			}
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}