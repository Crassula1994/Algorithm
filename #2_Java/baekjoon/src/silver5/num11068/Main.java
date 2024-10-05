package silver5.num11068;

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
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 정수를 변수 number에 할당
			int number = Integer.parseInt(in.readLine());
			
			// 입력 받은 정수가 회문인 수인지 여부를 나타낼 변수 isPalindrome 초기화
			boolean isPalindrome = false;
			
			// for 반복문을 사용해 각 진법을 순회
			for (int radix = 2; radix <= 64; radix++) {
				
				// 해당 진법으로 바꾼 문자열이 회문인 경우 입력 받은 정수가 회문인 수인지 여부를 갱신 후 반복문 탈출
				if (palindromeChecker(number, radix)) {
					isPalindrome = true;
					break;
				}
			}
			
			// write() 메서드를 사용해 해당 정수가 회문인 수인지 여부를 출력
			out.write((isPalindrome) ? 1 + "\n" : 0 + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// palindromeChecker() 메서드 정의
	public static boolean palindromeChecker(int number, int radix) {
		
		// 진법 변환을 통한 각 자릿수를 저장할 List 객체 digits 초기화
		List<Integer> digits = new ArrayList<>();
		
		// while 반복문을 사용해 진법 변환을 통한 각 자릿수를 digits에 저장
		while (number > 0) {
			digits.add(number % radix);
			number /= radix;
		}
		
		// for 반복문을 사용해 각 자릿수를 순회
		for (int idx = 0; idx < digits.size() / 2; idx++) {
			
			// 해당 숫자가 회문인 수가 아닌 경우 false 반환
			if (digits.get(idx) != digits.get(digits.size() - idx - 1))
				return false;
		}
		
		// 해당 숫자가 회문인 수인 경우 true 반환
		return true;
	}
}