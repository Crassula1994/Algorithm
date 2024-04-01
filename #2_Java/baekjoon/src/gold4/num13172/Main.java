package gold4.num13172;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 분모와 분자를 나눌 제수를 저장할 변수 divisor 초기화
	static long divisor = 1000000007;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 주사위의 수를 변수 diceNum에 할당
		int diceNum = Integer.parseInt(in.readLine());
		
		// 모든 주사위를 한 번씩 던졌을 때 나온 숫자들의 합의 기댓값을 저장할 변수 expectation 초기화
		long expectation = 0;
		
		// for 반복문을 사용해 각 주사위의 정보를 순회
		for (int dice = 0; dice < diceNum; dice++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 주사위의 면의 수와 모든 면의 숫자를 더한 값을 각 변수에 할당
			int denominator = Integer.parseInt(st.nextToken());
			int numerator = Integer.parseInt(st.nextToken());
			
			// max(), min(), gcdCalculator() 메서드를 호출해 분모와 분자의 최대공약수를 변수 gcd에 할당
			long gcd = gcdCalculator(Math.max(denominator, numerator), Math.min(denominator, numerator));
			
			// 분모와 분자를 기약분수 형태로 갱신
			denominator /= gcd;
			numerator /= gcd;
			
			// power() 메서드를 호출해 기약분수를 모듈러 곱셈에 대한 역원 형태로 구한 결과를 기댓값에 합산
			expectation += numerator * power(denominator, divisor - 2) % divisor;
			
			// 나머지 연산으로 기댓값을 갱신
			expectation %= divisor;
		}
		
		// valueOf() 및 write() 메서드를 사용해 모든 주사위를 한 번씩 던졌을 때 나온 숫자들의 합의 기댓값을 출력
		out.write(String.valueOf(expectation));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// gcdCalculator() 메서드 정의
	public static long gcdCalculator(long numA, long numB) {
		
		// 한쪽 숫자가 나누어 떨어졌던 경우 최대공약수를 반환
		if (numB == 0)
			return numA;
		
		// 한쪽 숫자가 나누어 떨어질 때까지 gcdCalculator() 메서드 재귀 호출
		return gcdCalculator(numB, numA % numB);
	}
	
	// ----------------------------------------------------------------------------------------------------

	// power() 메서드 정의
	public static long power(long base, long exponent) {
		
		// 지수가 0인 경우 1 반환
		if (exponent == 0)
			return 1;
		
		// 지수가 1인 경우 밑을 반환
		if (exponent == 1)
			return base;
		
		// power() 메서드를 재귀 호출해 해당 지수의 절반의 값을 계산해 변수 half에 할당
		long half = power(base, exponent / 2);
		
		// 지수가 짝수인지 홀수인지에 따라 계산한 값을 반환
		return (exponent % 2 == 0) ? half * half % divisor : (half * half % divisor) * base % divisor;
	}
}