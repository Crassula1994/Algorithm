package gold1.num11401;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 이항계수를 나눌 제수를 저장할 변수 divisor 초기화
	static long divisor = 1000000007;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 두 숫자를 각 변수에 할당
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		// factorial() 메서드를 호출해 이항계수의 분자와 분모를 각각 계산하고 이를 각 변수에 할당
		long numerator = factorial(n);
		long denominator = factorial(k) * factorial(n - k) % divisor;
		
		// power() 메서드를 호출해 이항계수를 계산하고 변수 binoCoeff에 할당
		long binoCoeff = numerator * power(denominator, divisor - 2) % divisor;
		
		// valueOf() 및 write() 메서드를 사용해 이항계수를 1000000007로 나눈 나머지를 출력
		out.write(String.valueOf(binoCoeff));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// factorial() 메서드 정의
	public static long factorial(int number) {
		
		// 팩토리얼의 값을 저장할 변수 result 초기화 
		long result = 1;
		
		// for 반복문을 사용해 팩토리얼의 값을 계산
		for (int n = 2; n <= number; n++)
			result = result * n % divisor;
		
		// 팩토리얼의 값을 반환
		return result;
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