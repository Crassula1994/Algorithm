package silver1.num01124;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 두 정수를 각 변수에 할당
		int startNumber = Integer.parseInt(st.nextToken());
		int endNumber = Integer.parseInt(st.nextToken());
		
		// 주어진 정수 범위 내에 존재하는 언더프라임 개수를 저장할 변수 count 초기화
		int count = 0;
		
		// 각 숫자가 소수가 아닌지 여부를 저장할 배열 isNotPrime 초기화
		boolean[] isNotPrime = new boolean[endNumber + 1];
		
		// 0과 1은 소수가 아니므로 소수가 아닌지 여부를 갱신
		isNotPrime[0] = isNotPrime[1] = true;
		
		// for 반복문을 사용해 각 인수를 순회
		for (int factor = 2; factor * factor <= endNumber; factor++) {
			
			// 해당 숫자가 소수가 아닌 경우 다음 인수를 순회
			if (isNotPrime[factor])
				continue;
			
			// for 반복문을 사용해 해당 인수의 배수를 소수가 아닌 것으로 처리
			for (int multiplier = factor * factor; multiplier <= endNumber; multiplier += factor)
				isNotPrime[multiplier] = true;
		}
		
		// for 반복문을 사용해 각 숫자를 순회
		for (int number = startNumber; number <= endNumber; number++) {
			
			// 해당 숫자가 소수인 경우 다음 숫자를 순회
			if (!isNotPrime[number])
				continue;
			
			// 해당 숫자의 소인수의 개수 및 소인수분해 후 나머지를 저장할 각 변수 초기화
			int factorCount = 0;
			int remains = number;
			
			// for 반복문을 사용해 가능한 인수를 순회
			for (int factor = 2; factor * factor <= number; factor++) {
				
				// 해당 인수가 소수가 아닌 경우 다음 인수를 순회
				if (isNotPrime[factor])
					continue;
				
				// while 반복문을 사용해 해당 인수로 나누어 떨어질 때까지 해당 숫자의 소인수 개수 및 소인수분해 후 나머지를 갱신
				while (remains % factor == 0) {
					factorCount++;
					remains /= factor;
				}
			}
			
			// 소인수분해 후 나머지가 존재하는 경우 소인수의 개수를 갱신
			if (remains > 1)
				factorCount++;
			
			// 해당 숫자가 언더프라임인 경우 정수 범위 내에 존재하는 언더프라임 개수를 갱신
			if (!isNotPrime[factorCount])
				count++;
		}
		
		// valueOf() 및 write() 메서드를 사용해 주어진 정수 범위 내에 존재하는 언더프라임 개수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}