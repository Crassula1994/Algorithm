package bronze2.num10174;

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

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// readLine() 및 toLowerCase() 메서드를 사용해 알파벳 대문자를 소문자로 변환한 텍스트를 변수 text에 할당
			String text = in.readLine().toLowerCase();
			
			// length() 메서드를 사용해 해당 텍스트의 길이를 변수 length에 할당
			int length = text.length();
			
			// 해당 텍스트가 팰린드롬인지 여부를 저장할 변수 isPalindrome 초기화
			boolean isPalindrome = true;
			
			// for 반복문을 사용해 각 텍스트의 각 글자를 순회
			for (int idx = 0; idx < length / 2; idx++) {
				
				// 해당 글자가 일치하지 않는 경우 해당 텍스트가 팰린드롬인지 여부를 갱신 후 반복문 탈출
				if (text.charAt(idx) != text.charAt(length - idx - 1)) {
					isPalindrome = false;
					break;
				}
			}
			
			// write() 메서드를 사용해 해당 텍스트가 팰린드롬인지 여부를 출력
			out.write((isPalindrome) ? "Yes" : "No");
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}