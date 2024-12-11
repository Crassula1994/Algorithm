package silver5.num08892;

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
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 공책에 적혀 있는 단어의 수를 변수 wordNum에 할당
			int wordNum = Integer.parseInt(in.readLine());
			
			// 공책에 적혀 있는 단어들로 팰린드롬을 만들 수 있는지 여부를 저장할 변수 hasPalindrome 초기화
			boolean hasPalindrome = false;
			
			// 공책에 적혀 있는 단어를 저장할 배열 words 초기화
			String[] words = new String[wordNum];
			
			// for 반복문을 사용해 입력 받은 공책에 적혀 있는 단어를 배열 words에 저장
			for (int idx = 0; idx < words.length; idx++)
				words[idx] = in.readLine();
			
			// for 반복문을 사용해 두 단어의 조합을 순회
			outer: for (int idx1 = 0; idx1 < words.length - 1; idx1++) {
				for (int idx2 = idx1 + 1; idx2 < words.length; idx2++) {
					
					// 두 단어를 순서대로 합친 비밀번호가 팰린드롬인 경우
					if (palindromeChecker(words[idx1] + words[idx2])) {
						
						// write() 메서드를 사용해 해당 비밀번호를 출력
						out.write(words[idx1] + words[idx2]);
						
						// 공책에 적혀 있는 단어들로 팰린드롬을 만들 수 있는지 여부를 갱신 후 반복문 탈출
						hasPalindrome = true;
						break outer;
					}
					
					// 두 단어를 거꾸로 합친 비밀번호가 팰린드롬인 경우
					if (palindromeChecker(words[idx2] + words[idx1])) {
						
						// write() 메서드를 사용해 해당 비밀번호를 출력
						out.write(words[idx2] + words[idx1]);
						
						// 공책에 적혀 있는 단어들로 팰린드롬을 만들 수 있는지 여부를 갱신 후 반복문 탈출
						hasPalindrome = true;
						break outer;
					}
				}
			}
			
			// 공책에 적혀 있는 단어들로 팰린드롬을 만들 수 없는 경우 0을 출력
			if (!hasPalindrome)
				out.write(String.valueOf(0));
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// palindromeChecker() 메서드 정의
	public static boolean palindromeChecker(String word) {
		
		// for 반복문을 사용해 각 글자를 순회
		for (int idx = 0; idx < word.length() / 2; idx++) {
			
			// 해당 글자와 대칭인 글자가 일치하지 않는 경우 false 반환
			if (word.charAt(idx) != word.charAt(word.length() - idx - 1))
				return false;
		}
		
		// 해당 단어가 팰린드롬인 경우 true 반환
		return true;
	}
}