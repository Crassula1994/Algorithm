package silver5.num13241;

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
		
		// nextToken() 및 parseLong() 메서드를 사용해 입력 받은 정수를 각 변수에 할당
		long numA = Long.parseLong(st.nextToken());
		long numB = Long.parseLong(st.nextToken());
		
		// gcdCalculator() 메서드를 호출해 두 수의 최대공약수를 변수 gcd에 할당
		long gcd = gcdCalculator(numA, numB);
		
		// 두 수의 최소공배수를 계산해 변수 lcm에 할당
		long lcm = gcd * (numA / gcd) * (numB / gcd);
		
		// valueOf() 및 write() 메서드를 사용해 두 수의 최소공배수를 출력
		out.write(String.valueOf(lcm));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// gcdCalculator() 메서드 정의
	public static long gcdCalculator(long numA, long numB) {
		
		// 두 숫자가 같은 경우 해당 숫자를 최대공약수로 반환
		if (numA == numB) {
			return numA;
			
		// 두 숫자가 같지 않은 경우
		} else {
			
			// max() 및 min() 메서드를 사용해 두 수 중 큰 수와 작은 수를 각 변수에 할당
			long bigNum = Math.max(numA, numB);
			long smallNum = Math.min(numA, numB);
			
			// 큰 수가 작은 수로 나누어 떨어지는 경우 작은 수를 최대공약수로 반환
			if (bigNum % smallNum == 0) {
				return smallNum;
			
			// 큰 수가 작은 수로 나누어 떨어지지 않는 경우 gcdCalculator() 메서드 재귀 호출
			} else {
				return gcdCalculator(smallNum, bigNum % smallNum);
			}
		}
	}
}