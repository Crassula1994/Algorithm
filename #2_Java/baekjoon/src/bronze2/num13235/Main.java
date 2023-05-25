package bronze2.num13235;

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
		
		// 해당 단어가 팰린드롬인지 나타내는 변수 isPalindrome 초기화
		boolean isPalindrome = true;
		
		// for 반복문을 사용해 각 글자와 반대편 글자를 순회
		for (int idx = 0; idx < word.length() / 2; idx++) {
			
			// 두 글자가 일치하지 않는 경우
			if (word.charAt(idx) != word.charAt(word.length() - idx - 1)) {
				
				// 해당 단어가 팰린드롬이 아님을 갱신 후 반복문 탈출
				isPalindrome = false;
				break;
			}	
		}
		
		// 해당 단어가 팰린드롬인지 그 결과를 변수 result에 할당
		String result = (isPalindrome) ? "true" : "false";

		// write() 메서드를 사용해 해당 단어가 팰린드롬인지 그 결과를 출력
		out.write(result);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}