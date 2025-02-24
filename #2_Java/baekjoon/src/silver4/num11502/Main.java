package silver4.num11502;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// 각 숫자가 소수가 아닌지 여부를 나타낼 배열 isNotPrime 초기화
		boolean[] isNotPrime = new boolean[1000];
		
		// 소수를 저장할 List 객체 primeNumbers 초기화
		List<Integer> primeNumbers = new ArrayList<>();
		
		// 0과 1은 소수가 아니므로 소수가 아닌지 여부를 갱신
		isNotPrime[0] = isNotPrime[1] = true;
		
		// for 반복문을 사용해 각 인수를 순회
		for (int factor = 2; factor * factor < 1000; factor++) {
			
			// 해당 인수가 소수가 아닌 경우 다음 인수를 순회
			if (isNotPrime[factor])
				continue;
			
			// for 반복문을 사용해 해당 인수의 배수를 소수가 아닌 것으로 처리
			for (int multiplier = factor * factor; multiplier < 1000; multiplier += factor)
				isNotPrime[multiplier] = true;
		}
		
		// for 반복문을 사용해 각 숫자를 순회
		for (int factor = 0; factor < 1000; factor++) {
			
			// 해당 숫자가 소수인 경우 primeNumbers에 추가
			if (!isNotPrime[factor])
				primeNumbers.add(factor);
		}
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 홀수를 변수 targetNumber에 할당
			int targetNumber = Integer.parseInt(in.readLine());
			
			// for 반복문을 사용해 각 세 소수를 순회
			outer: for (int p1 = 0; p1 < primeNumbers.size(); p1++) {
				for (int p2 = p1; p2 < primeNumbers.size(); p2++) {
					for (int p3 = p2; p3 < primeNumbers.size(); p3++) {
						
						// get() 메서드를 사용해 해당 소수를 각 변수에 할당
						int prime1 = primeNumbers.get(p1);
						int prime2 = primeNumbers.get(p2);
						int prime3 = primeNumbers.get(p3);
						
						// 세 소수의 합이 목표로 하는 홀수와 같은 경우 해당 소수를 출력 후 반복문 탈출
						if (prime1 + prime2 + prime3 == targetNumber) {
							out.write(prime1 + " " + prime2 + " " + prime3 + "\n");
							break outer;
						}
					}
				}
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}