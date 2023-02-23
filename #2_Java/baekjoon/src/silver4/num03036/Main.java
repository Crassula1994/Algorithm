package silver4.num03036;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 링의 개수를 변수 lingNum에 할당
		int lingNum = Integer.parseInt(in.readLine());
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 첫 번째 링의 숫자를 변수 firstLing에 할당
		int firstLing = Integer.parseInt(st.nextToken());
		
		// for 반복문을 사용해 입력 받은 각 링의 반지름을 순회
		for (int r = 0; r < lingNum - 1; r++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 다음 링의 숫자를 변수 nextLing에 할당
			int nextLing = Integer.parseInt(st.nextToken());
			
			// gcdFinder() 메서드를 호출해 두 수의 최대공약수를 계산하고 이를 변수 gcd에 할당
			int gcd = gcdFinder(firstLing, nextLing);
			
			// write() 메서드를 사용해 링이 도는 횟수를 기약 분수 형태로 출력
			out.write((firstLing / gcd) + "/" + (nextLing / gcd) + "\n");
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// gcdFinder() 메서드 정의
	public static int gcdFinder(int number1, int number2) {

		// max() 및 min() 함수를 사용해 최대공약수로 나눌 수 및 최대공약수를 저장할 변수 초기화
		int multiple = Math.max(number1, number2);
		int divisor = Math.min(number1, number2);
		
		// while 반복문을 사용해 최대공약수를 구할 때까지 순회
		while (true) {
			
			// 나누어 떨어지는 경우 최대공약수를 반환
			if (multiple % divisor == 0) {
				return divisor;
			
			// 나누어 떨어지지 않는 경우 각 변수를 갱신
			} else {
				int temp = multiple;
				multiple = divisor;
				divisor = temp % divisor;
			}
		}
	}
}