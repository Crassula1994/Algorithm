package gold5.num10460;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 순환소수의 순환마디와 비순환마디를 저장할 각 변수 초기화
	static String cycle;
	static String nonCycle;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (true) {
			
			// readLine() 메서드를 사용해 입력 받은 순환소수를 변수 decimal에 할당
			String decimal = in.readLine();
			
			// 모든 테스트 케이스를 확인한 경우 반복문 탈출
			if (decimal.equals("0"))
				break;
			
			// length() 및 substring() 메서드를 사용해 소수부만을 변수 decimal에 재할당
			decimal = decimal.substring(2, decimal.length() - 3);
			
			// length() 메서드를 사용해 주어진 소수부의 길이를 변수 totalLength에 할당
			int totalLength = decimal.length();
			
			// 가장 분모가 작은 경우의 분모와 분자를 저장할 각 변수 초기화
			long minDenominator = Long.MAX_VALUE;
			long bestNumerator = 0;
			
			// for 반복문을 사용해 가능한 순환마디의 길이를 순회
			for (int length = 1; length <= totalLength; length++) {
				
				// substring() 메서드를 사용해 순환마디와 비순환마디를 갱신
				cycle = decimal.substring(totalLength - length);
				nonCycle = decimal.substring(0, totalLength - length);
				
				// denominatorCalculator() 및 numeratorCalculator() 메서드를 호출해 순환소수의 분모와 분자를 각 변수에 할당
				long denominator = denominatorCalculator();
				long numerator = numeratorCalculator();
				
				// gcdCalculator() 메서드를 호출해 분자와 분모의 최대공약수를 변수 gcd에 할당
				long gcd = gcdCalculator(denominator, numerator);
				
				// 순환소수의 분모와 분자를 기약분수 형태로 변환
				denominator /= gcd;
				numerator /= gcd;
				
				// 해당 분모가 저장된 가장 작은 분모보다 작은 경우 가장 분모가 작은 경우의 분모와 분자를 갱신
				if (denominator < minDenominator) {
					minDenominator = denominator;
					bestNumerator = numerator;
				}
			}
			
			// format() 및 write() 메서드를 사용해 분모가 가장 작은 해당 순환소수의 분수 꼴을 출력
			out.write(String.format("%d/%d\n", bestNumerator, minDenominator));
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// numeratorCalculator() 메서드 정의
	public static long numeratorCalculator() {
		
		// 비순환마디가 존재하지 않는 경우 순환소수의 분자를 계산해 반환
		if (nonCycle.length() == 0)
			return Long.parseLong(cycle);
		
		// parseLong() 메서드를 사용해 순환소수의 분자를 계산해 반환
		return Long.parseLong(nonCycle + cycle) - Long.parseLong(nonCycle);
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// denominatorCalculator() 메서드 정의
	public static long denominatorCalculator() {
		
		// StringBuilder 객체를 불러와 변수 sb에 할당
		StringBuilder sb = new StringBuilder();
		
		// 순환마디와 비순환마디의 길이를 각 변수에 할당
		int cycleLength = cycle.length();
		int nonCycleLength = nonCycle.length();
		
		// while 반복문을 사용해 순환마디의 길이만큼 sb에 '9'를 추가
		while (cycleLength-- > 0)
			sb.append("9");
		
		// while 반복문을 사용해 비순환마디의 길이만큼 sb에 '0'을 추가
		while (nonCycleLength-- > 0)
			sb.append("0");
		
		// toString() 및 parseLong() 메서드를 사용해 순환마디의 분모를 반환
		return Long.parseLong(sb.toString());
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// gcdCalculator() 메서드 정의
	public static long gcdCalculator(long numberA, long numberB) {
		
		// 한 숫자가 다른 숫자로 나누어 떨어지는 경우 나눈 숫자가 최대공약수이므로 이를 반환
		if (numberA % numberB == 0)
			return numberB;
		
		// gcdCalculator() 메서드를 재귀 호출해 최대공약수를 반환
		return gcdCalculator(numberB, numberA % numberB);
	}
}