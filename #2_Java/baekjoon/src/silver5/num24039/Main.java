package silver5.num24039;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 lowerLimit에 할당
		int lowerLimit = Integer.parseInt(in.readLine());
		
		// 각 숫자가 소수인지 여부를 저장할 배열 isNotPrime 초기화
		boolean[] isNotPrime = new boolean[104];
		
		// 소수를 저장할 List 객체 primeNumbers 초기화
		List<Integer> primeNumbers = new ArrayList<>();
		
		// 0과 1은 소수가 아니므로 값을 갱신
		isNotPrime[0] = true;
		isNotPrime[1] = true;
		
		// for 반복문을 사용해 각 인수를 순회
		for (int factor = 2; factor < isNotPrime.length; factor++) {
			
			// 해당 인수가 소수가 아닌 경우 다음 인수를 순회
			if (isNotPrime[factor])
				continue;
			
			// for 반복문을 사용해 해당 인수의 배수를 소수가 아닌 것으로 갱신
			for (int multiplier = 2; multiplier * factor < isNotPrime.length; multiplier++)
				isNotPrime[multiplier * factor] = true;
		}
		
		// for 반복문을 사용해 각 인수를 순회
		for (int factor = 2; factor < isNotPrime.length; factor++) {
			
			// 해당 인수가 소수인 경우 primeNumbers에 추가
			if (!isNotPrime[factor])
				primeNumbers.add(factor);
		}
		
		// for 반복문을 사용해 연속된 각 소수의 곱을 순회
		for (int idx = 0; idx < primeNumbers.size() - 1; idx++) {
			
			// get() 메서드를 사용해 소수의 곱을 변수 product에 할당
			int product = primeNumbers.get(idx) * primeNumbers.get(idx + 1);
			
			// 소수의 곱이 입력 받은 숫자보다 큰 경우 해당 곱을 출력 후 반복문 탈출
			if (product > lowerLimit) {
				out.write(String.valueOf(product));
				break;
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}