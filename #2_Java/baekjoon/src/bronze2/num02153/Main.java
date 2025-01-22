package bronze2.num02153;

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
		
		// readLine() 메서드를 사용해 입력 받은 단어를 변수 word에 할당
		String word = in.readLine();
		
		// 해당 단어를 숫자로 변환한 결과를 저장할 변수 sum 초기화
		int sum = 0;
		
		// for 반복문을 사용해 각 알파벳을 순회
		for (int idx = 0; idx < word.length(); idx++) {
			
			// charAt() 메서드를 사용해 해당 알파벳을 변수 alphabet에 할당
			char alphabet = word.charAt(idx);
			
			// 해당 알파벳이 알파벳 대문자인 경우 해당 단어를 숫자로 변환한 결과를 갱신
			if (alphabet - 'a' < 0) {
				sum += alphabet - 'A' + 27;
				
			// 해당 알파벳이 알파벳 소문자인 경우 해당 단어를 숫자로 변환한 결과를 갱신
			} else {
				sum += alphabet - 'a' + 1;
			}
		}
		
		// primeChecker() 및 write() 메서드를 사용해 해당 단어가 소수 단어인지 여부를 출력
		out.write((primeChecker(sum)) ? "It is a prime word." : "It is not a prime word.");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// primeChecker() 메서드 정의
	public static boolean primeChecker(int sum) {
		
		// for 반복문을 사용해 각 인수를 순회
		for (int factor = 2; factor * factor <= sum; factor++) {
			
			// 해당 인수로 나누어 떨어지는 경우 소수가 아니므로 false 반환
			if (sum % factor == 0)
				return false;
		}
		
		// 해당 숫자가 소수인 경우 true 반환
		return true;
	}
}