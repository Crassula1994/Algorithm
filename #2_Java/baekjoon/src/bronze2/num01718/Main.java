package bronze2.num01718;

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
		
		// readLine() 메서드를 사용해 입력 받은 평문과 암호화 키를 각 변수에 할당
		String clearText = in.readLine();
		String encryptionKey = in.readLine();
		
		// length() 메서드를 사용해 평문과 암호화 키의 길이를 각 변수에 할당
		int textLength = clearText.length();
		int keyLength = encryptionKey.length();
		
		// for 반복문을 사용해 각 평문의 글자를 순회
		for (int idx = 0; idx < textLength; idx++) {
			
			// charAt() 메서드를 사용해 해당 평문의 글자와 대응되는 암호화 키의 글자를 각 변수에 할당
			char textLetter = clearText.charAt(idx);
			char keyLetter = encryptionKey.charAt(idx % keyLength);
			
			// 평문의 글자가 공백문자인 경우 공백문자를 출력
			if (textLetter == ' ') {
				out.write(textLetter);
				
			// 평문의 글자가 알파벳 소문자인 경우 암호문을 출력
			} else {
				
				// 비즈네르 암호 방식으로 바꾼 알파벳 순서를 변수 cipherTextIdx에 할당
				int cipherTextIdx = (textLetter - keyLetter + 26) % 26;
				cipherTextIdx = (cipherTextIdx == 0) ? 26 : cipherTextIdx;
				
				// write() 메서드를 사용해 암호문을 출력
				out.write((char) (cipherTextIdx + 'a' - 1));
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}