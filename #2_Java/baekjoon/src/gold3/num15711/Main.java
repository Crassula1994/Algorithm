package gold3.num15711;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 각 숫자가 소수가 아닌지 여부를 저장할 배열 isNotPrime 초기화
	static boolean[] isNotPrime = new boolean[2000001];
	
	// 각 소수를 저장할 List 객체 primeNumbers 초기화
	static List<Integer> primeNumbers = new ArrayList<>();
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// primeCalculator() 메서드를 호출해 각 숫자가 소수가 아닌지 여부를 갱신
		primeCalculator();
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseLong() 메서드를 사용해 입력 받은 두 정수의 합을 변수 sum에 할당
			long sum = Long.parseLong(st.nextToken()) + Long.parseLong(st.nextToken());
			
			// 두 정수의 합이 4 미만인 경우 'NO' 출력
			if (sum < 4) {
				out.write("NO");
				
			// 두 정수의 합이 짝수인 경우 골트바흐의 추측에 따라 'YES' 출력
			} else if ((sum & 1) != 1) {
				out.write("YES");
				
			// 두 정수의 합이 홀수인 경우 2와 다른 홀수로 나누었을 때 다른 홀수가 소수인지 여부를 출력
			} else {
				out.write(primeChecker(sum - 2) ? "YES" : "NO");
			}
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// primeCalculator() 메서드 정의
	public static void primeCalculator() {
		
		// 0, 1은 소수가 아니므로 소수가 아닌 것으로 갱신
		isNotPrime[0] = isNotPrime[1] = true;
		
		// for 반복문을 사용해 가능한 인수를 순회
		for (int factor = 2; factor * factor < isNotPrime.length; factor++) {
			
			// 해당 인수가 소수가 아닌 경우 다음 인수를 순회
			if (isNotPrime[factor])
				continue;
			
			// for 반복문을 사용해 해당 소수의 배수를 소수가 아닌 것으로 처리
			for (int multiplier = factor * factor; multiplier < isNotPrime.length; multiplier += factor)
				isNotPrime[multiplier] = true;
		}
		
		// for 반복문을 사용해 가능한 인수를 순회
		for (int factor = 0; factor < isNotPrime.length; factor++) {
			
			// 해당 숫자가 소수인 경우 primeNumbers에 추가
			if (!isNotPrime[factor])
				primeNumbers.add(factor);
		}
	}
	
	// ----------------------------------------------------------------------------------------------------

	// primeChecker() 메서드 정의
	public static boolean primeChecker(long targetNumber) {
		
		// 해당 숫자가 소수가 아닌지 여부를 바로 확인할 수 있는 경우 이를 반환
		if (targetNumber < isNotPrime.length)
			return !isNotPrime[(int) targetNumber];
		
		// for 반복문을 사용해 각 소수를 순회
		for (int primeNumber : primeNumbers) {
			
			// 해당 소수가 주어진 숫자의 가능한 소인수 범위를 벗어난 경우 반복문 탈출
			if ((long) primeNumber * primeNumber > targetNumber)
				break;
			
			// 해당 소수로 나누어 떨어지는 경우 소수가 아니므로 false 반환
			if (targetNumber % primeNumber == 0)
				return false;
		}
		
		// 해당 숫자가 소수인 경우 true 반환
		return true;
	}
}