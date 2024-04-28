package gold3.num01644;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
		int number = Integer.parseInt(in.readLine());
		
		// 연속된 소수의 합으로 나타낼 수 있는 경우의 수를 저장할 변수 count 초기화
		int count = 0;
		
		// 소수가 아닌 수를 저장할 배열 isNotPrime 초기화
		boolean[] isNotPrime = new boolean[number + 1];
		
		// 숫자 0과 1은 소수가 아니므로 소수가 아닌 것으로 갱신
		isNotPrime[0] = true;
		isNotPrime[1] = true;
		
		// for 반복문을 사용해 각 숫자를 순회
		for (int n = 2; n * n <= number; n++) {
			
			// 소수가 아닌 경우 다음 수를 순회
			if (isNotPrime[n])
				continue;
			
			// for 반복문을 사용해 해당 수의 배수는 소수가 아니므로 소수가 아닌 것으로 갱신
			for (int m = n * 2; m <= number; m += n)
				isNotPrime[m] = true;
		}
		
		// 소수 연속합의 시작과 끝, 그 연속합을 나타낼 각 변수 초기화
		int start = 0;
		int end = 0;
		int sum = 0;
		
		// while 반복문을 사용해 가능한 소수의 조합의 끝에 도달할 때까지 순회
		while (start <= end) {
			
			// 소수 연속합의 끝이 마지막 숫자에 도달했거나 연속합이 입력 받은 숫자보다 크거나 같은 경우
			if (end == number || sum >= number) {
				
				// 제외할 소수 연속합의 시작이 소수인 경우
				if (!isNotPrime[start]) {
					
					// 소수 연속합을 갱신
					sum -= start;
					
					// 갱신한 소수 연속합이 주어진 숫자와 같은 경우 경우의 수를 갱신
					if (sum == number)
						count++;
				}
				
				// 소수 연속합의 시작을 갱신
				++start;
			
			// 소수 연속합의 끝이 마지막 숫자에 도달하지 않았고 연속합이 입력 받은 숫자보다 작은 경우
			} else {
				
				// 소수 연속합의 끝을 갱신
				++end;
				
				// 새로운 소수 연속합의 끝이 소수인 경우
				if (!isNotPrime[end]) {
					
					// 소수 연속합을 갱신
					sum += end;
					
					// 갱신한 소수 연속합이 주어진 숫자와 같은 경우 경우의 수를 갱신
					if (sum == number)
						count++;
				}
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 연속된 소수의 합으로 나타낼 수 있는 경우의 수를 출력
		out.write(String.valueOf(count));
		 
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}