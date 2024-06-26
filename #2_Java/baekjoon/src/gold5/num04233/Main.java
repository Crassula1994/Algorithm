package gold5.num04233;

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
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (true) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 밑과 지수를 각 변수에 할당
			int exponent = Integer.parseInt(st.nextToken());
			int base = Integer.parseInt(st.nextToken());
			
			// 0이 두 개 주어진 경우 반복문 탈출
			if (exponent == 0 && base == 0)
				break;
						
			// write() 메서드를 사용해 주어진 지수가 가짜 소수인지 여부를 출력
			out.write(!primeNumberChecker(exponent)
					&& powerCalculator(base, exponent, exponent) == base ? "yes" : "no");
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// primeNumberChecker() 메서드 정의
	public static boolean primeNumberChecker(int number) {
		
		// for 반복문을 사용해 가능한 인수를 순회
		for (int factor = 2; factor * factor <= number; factor++) {
			
			// 해당 숫자가 나누어 떨어지는 경우 소수가 아니므로 false 반환
			if (number % factor == 0)
				return false;
		}
		
		// 해당 숫자가 소수인 경우 true 반환
		return true;
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// powerCalculator() 메서드 정의
	public static long powerCalculator(long base, long exponent, long divisor) {
		
		// 지수가 1인 경우 밑을 반환
		if (exponent == 1)
			return base % divisor;
		
		// powerCalculator() 메서드를 재귀 호출해 해당 지수 절반의 값을 계산 후 변수 half에 할당
		long half = powerCalculator(base, exponent / 2, divisor);
		
		// 지수가 짝수인지 홀수인지에 따라 계산한 값을 반환
		return (exponent % 2 == 0) ? half * half % divisor : (half * half % divisor) * base % divisor;
	}
}