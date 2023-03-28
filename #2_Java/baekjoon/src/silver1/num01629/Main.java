package silver1.num01629;

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
		
		// nextToken() 및 parseLong() 메서드를 사용해 입력 받은 각 숫자를 각 변수에 할당
		long base = Long.parseLong(st.nextToken());
		long exponent = Long.parseLong(st.nextToken());
		long divisor = Long.parseLong(st.nextToken());
		
		// powerCalculator() 메서드를 호출해 거듭제곱을 계산해 자연수로 나눈 나머지를 변수 result에 할당
		long result = powerCalculator(base, exponent, divisor);
		
		// valueOf() 및 write() 메서드를 사용해 계산 결과를 출력
		out.write(String.valueOf(result));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// powerCalculator() 메서드 정의 
	public static long powerCalculator(long base, long exponent, long divisor) {
		
		// 거듭제곱의 지수가 0인 경우 1 반환
		if (exponent == 0)
			return 1;
		
		// 거듭제곱의 지수가 짝수인 경우
		if (exponent % 2 == 0) {
			
			// 지수를 2로 나눈 값으로 powerCalculator() 메서드를 재귀 호출한 결과를 변수 half에 할당
			long half = powerCalculator(base, exponent / 2, divisor) % divisor;
			
			// 거듭제곱의 결과를 반환
			return (half * half) % divisor;
			
		// 거듭제곱의 지수가 홀수인 경우
		} else {
			
			// 지수에서 1을 뺀 값으로 powerCalculator() 메서드를 재귀 호출한 결과를 변수 even에 할당
			long even = powerCalculator(base, exponent - 1, divisor) % divisor;
			
			// 거듭제곱의 결과를 반환
			return (even * (base % divisor)) % divisor;
		}
	}
}