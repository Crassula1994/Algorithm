package gold5.num02023;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 소수를 만들 수 있는 수를 저장할 배열 primeNums 초기화
	static int[] primeNums = {1, 3, 5, 7, 9};
	
	// 만들어야 하는 소수의 자릿수를 저장할 변수 ciphers 초기화
	static int ciphers;

	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 소수의 자릿수를 변수 ciphers에 할당
		ciphers = Integer.parseInt(in.readLine());
		
		// 첫 자리가 각각 2, 3, 5, 7일 때 primeNumFinder() 메서드를 호출해 각 소수를 출력
		primeNumFinder(2, 1, out);
		primeNumFinder(3, 1, out);
		primeNumFinder(5, 1, out);
		primeNumFinder(7, 1, out);

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// primeNumFinder() 메서드 정의
	public static void primeNumFinder(int number, int length, BufferedWriter out) throws IOException {
		
		// 해당 숫자가 한 자리 숫자가 아닌 경우
		if (number / 10 != 0) {
			
			// 해당 숫자가 소수인지 저장할 변수 isPrimeNum 초기화
			boolean isPrimeNum = true;
			
			// for 반복문을 사용해 해당 숫자가 소수인지 검사
			for (int divisor = 2; divisor <= Math.sqrt(number); divisor++) {
				
				// 다른 수로 나누어 떨어지는 경우 소수인지 여부를 갱신 후 반복문 탈출
				if (number % divisor == 0) {
					isPrimeNum = false;
					break;
				}
			}
			
			// 해당 숫자가 소수가 아니라면 메서드 종료
			if (!isPrimeNum)
				return;
		}

		// 해당하는 자릿수를 모두 만든 경우 해당 숫자 출력 후 메서드 종료
		if (length == ciphers) {
			out.write(number + "\n");
			return;
			
		// 해당하는 자릿수를 모두 만들지 못한 경우
		} else {
			
			// for 반복문을 사용해 배열 primeNums의 각 원소를 순회
			for (int idx = 0; idx < 5; idx++) {
				
				// 새로운 수를 만들어 변수 nextNum에 할당
				int nextNum = number * 10 + primeNums[idx];
				
				// 해당 숫자를 입력해 primeNumFinder() 메서드 재귀 호출
				primeNumFinder(nextNum, length + 1, out);
			}
		}
	}
}