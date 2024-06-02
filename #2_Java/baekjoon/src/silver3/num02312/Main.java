package silver3.num02312;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.TreeMap;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// 각 숫자가 소수가 아닌지 여부를 저장할 배열 isNotPrime 초기화
		boolean[] isNotPrime = new boolean[100001];
		
		// 0과 1은 소수가 아니므로 소수가 아닌 것으로 처리
		isNotPrime[0] = true;
		isNotPrime[1] = true;
		
		// for 반복문을 사용해 각 숫자를 순회
		for (int n = 2; n <= Math.sqrt(100000); n++) {
			
			// 해당 숫자가 소수가 아닌 경우 다음 숫자를 순회
			if (isNotPrime[n])
				continue;
			
			// for 반복문을 사용해 각 숫자의 배수를 소수가 아닌 숫자로 갱신
			for (int m = n * 2; m <= 100000; m += n)
				isNotPrime[m] = true;
		}
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 양의 정수를 변수 number에 할당
			int number = Integer.parseInt(in.readLine());
			
			// 소인수분해 후 결과를 저장할 변수 dividend 초기화
			int dividend = number;
			
			// 소인수의 개수를 저장할 Map 객체 factorization 초기화
			Map<Integer, Integer> factorization = new TreeMap<>();
			
			// for 반복문을 사용해 각 인수를 순회
			for (int divisor = 2; divisor <= number; divisor++) {
			
				// 해당 인수가 소수가 아닌 경우 다음 인수를 순회
				if (isNotPrime[divisor])
					continue;
				
				// while 반복문을 사용해 더 이상 나누어 떨어지지 않을 때까지 순회
				while (dividend % divisor == 0) {
					
					// 소인수분해의 결과를 갱신
					dividend /= divisor;
					
					// getOrDefault() 및 put() 메서드를 사용해 소인수의 개수를 갱신
					factorization.put(divisor, factorization.getOrDefault(divisor, 0) + 1);
				}
				
				// 소인수분해가 끝난 경우 반복문 탈출
				if (dividend == 1)
					break;
			}
			
			// for 반복문을 사용해 각 인수와 그 인수가 곱해진 횟수를 출력
			for (int factor : factorization.keySet())
				out.write(factor + " " + factorization.get(factor) + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}