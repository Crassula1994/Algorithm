package silver5.num13241;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// readLine() 및 parseLong() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
			long number = Long.parseLong(in.readLine());
			
			// 주어진 숫자보다 크거나 같은 소수를 저장할 변수 primeNum 초기화
			long primeNum = (number > 1) ? number : 2;
			
			// while 반복문을 사용해 주어진 숫자보다 크거나 같은 소수를 찾을 때까지 순회
			while (true) {
				
				// 소수인지 나타내는 변수 isPrimeNum 초기화
				boolean isPrimeNum = true;
				
				// for 반복문을 사용해 소수인지 검사
				for (int divisor = 2; divisor <= Math.sqrt(primeNum); divisor++) {
					
					// 소수가 아닌 경우 isPrimeNum 갱신 후 반복문 탈출
					if (primeNum % divisor == 0) {
						isPrimeNum = false;
						break;
					}
				}
				
				// 소수인 경우 해당 숫자 출력 후 반복문 탈출
				if (isPrimeNum) {
					out.write(primeNum + "\n");
					break;
				
				// 소수가 아닌 경우 다음 숫자 검사
				} else {
					primeNum = (primeNum % 2 == 0) ? primeNum + 1 : primeNum + 2;
				}
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}