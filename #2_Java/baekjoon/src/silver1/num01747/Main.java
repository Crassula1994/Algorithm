package silver1.num01747;

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
		
		// 해당 숫자가 소수가 아닌지를 나타내는 배열 isNotPrime 초기화
		boolean[] isNotPrime = new boolean[1003002];
		
		// 0과 1은 소수가 아니므로 해당 값을 갱신
		isNotPrime[0] = true;
		isNotPrime[1] = true;
		
		// for 반복문을 사용해 1003001까지의 숫자를 순회
		for (int n = 2; n < Math.sqrt(1003002); n++) {
			
			// 해당 숫자가 소수인 경우
			if (!isNotPrime[n]) {
				
				// for 반복문을 사용해 해당 수의 배수를 모두 소수가 아닌 것으로 처리
				for (int m = n * n; m < 1003002; m += n)
					isNotPrime[m] = true;
			}
		}
		
		// for 반복문을 사용해 입력 받은 숫자보다 큰 숫자를 순회
		for (int n = number; n < 1003002; n++) {
			
			// 해당 숫자가 소수인 경우
			if (!isNotPrime[n]) {
				
				// 해당 숫자가 팰린드롬인 경우 해당 숫자 출력 후 반복문 탈출
				if (palindromeChecker(n)) {
					out.write(String.valueOf(n));
					break;
				}
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// palindromeChecker() 메서드 정의
	public static boolean palindromeChecker(int number) {
		
		// valueOf() 메서드를 사용해 입력 받은 숫자를 문자열로 변환해 변수 numStr에 할당
		String numStr = String.valueOf(number);
		
		// 각 자리의 위치를 저장할 변수 index 초기화
		int index = 0;
		
		// while 반복문을 사용해 각 자리 숫자를 순회
		while (index < numStr.length() / 2) {
			
			// charAt() 및 length() 메서드를 사용해 각 자리의 숫자를 각 변수에 할당
			int start = numStr.charAt(index) - '0';
			int end = numStr.charAt(numStr.length() - index - 1) - '0';
			
			// 해당 위치의 숫자가 같지 않을 경우 false 반환
			if (start != end)
				return false;
			
			// 다음에 확인할 위치를 갱신
			index++;
		}

		// 해당 숫자가 팰린드롬인 경우 true 반환
		return true;
	}
}