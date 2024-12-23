package bronze1.num17294;

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
		
		// readLine() 메서드를 사용해 입력 받은 숫자를 변수 numberString에 할당
		String numberString = in.readLine();
		
		// length() 메서드를 사용해 해당 숫자의 자릿수 길이를 변수 numberLength에 할당
		int numberLength = numberString.length();
		
		// 해당 숫자가 귀여운 수인지 여부를 저장할 변수 isCute 초기화
		boolean isCute = true;
		
		// 자릿수 길이가 두 자리 이상인 경우
		if (numberLength >= 2) {
			
			// 각 자릿수를 저장할 배열 digits 초기화
			int[] digits = new int[numberLength];
			
			// for 반복문을 사용해 각 자릿수를 배열 digits에 저장
			for (int idx = 0; idx < numberLength; idx++)
				digits[idx] = numberString.charAt(idx) - '0';
			
			// for 반복문을 사용해 각 자릿수를 순회
			for (int idx = 1, diff = digits[1] - digits[0]; idx < digits.length; idx++) {
				
				// 해당 자릿수가 등차수열을 이루지 않는 경우 해당 숫자가 귀여운 수인지 여부를 갱신 후 반복문 탈출
				if (digits[idx - 1] + diff != digits[idx]) {
					isCute = false;
					break;
				}
			} 
		}
		
		// write() 메서드를 사용해 해당 숫자가 귀여운 수인지 여부를 출력
		out.write((isCute) ? "◝(⑅•ᴗ•⑅)◜..°♡ 뀌요미!!" : "흥칫뿡!! <(￣ ﹌ ￣)>");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}