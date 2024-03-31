package bronze2.num02702;

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
		for (int tc = 1; tc <= testCase; tc++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 두 정수를 각 변수에 할당
			int numberA = Integer.parseInt(st.nextToken());
			int numberB = Integer.parseInt(st.nextToken());
			
			// 최대공약수를 저장할 변수 gcd 초기화
			int gcd = 0;
			
			// for 반복문을 사용해 최대공약수가 될 수 있는 각 숫자를 순회
			for (int n = Math.min(numberA, numberB); n > 0; n--) {
				
				// 해당 숫자가 공약수인 경우 최대공약수 갱신 후 반복문 탈출
				if (numberA % n == 0 && numberB % n == 0) {
					gcd = n;
					break;
				}
			}
			
			// 최소공배수를 계산해 변수 lcm에 할당
			int lcm = gcd * (numberA / gcd) * (numberB / gcd);
			
			// write() 메서드를 사용해 최소공배수와 최대공약수를 출력
			out.write(lcm + " " + gcd + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}