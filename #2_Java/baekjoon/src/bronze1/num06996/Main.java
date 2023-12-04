package bronze1.num06996;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

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
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 toLowerCase() 메서드를 사용해 두 단어를 각 변수에 할당
			String wordA = st.nextToken().toLowerCase();
			String wordB = st.nextToken().toLowerCase();
			
			// 각 단어의 알파벳 개수를 저장할 각 배열 초기화
			int[] alphabetsA = new int[26];
			int[] alphabetsB = new int[26];
			
			// 두 단어의 길이가 다른 경우 애너그램이 아니라고 출력
			if (wordA.length() != wordB.length()) {
				out.write(wordA + " & " + wordB + " are NOT anagrams.\n");
				
			// 두 단어의 길이가 같은 경우
			} else {
				
				// for 반복문을 사용해 단어 A의 각 알파벳의 개수를 갱신
				for (int idx = 0; idx < wordA.length(); idx++)
					alphabetsA[wordA.charAt(idx) - 'a']++;
				
				// for 반복문을 사용해 단어 B의 각 알파벳의 개수를 갱신
				for (int idx = 0; idx < wordB.length(); idx++)
					alphabetsB[wordB.charAt(idx) - 'a']++;
				
				// anagramChecker() 메서드를 호출해 두 단어가 애너그램인지를 변수 isAnagram에 할당
				boolean isAnagram = anagramChecker(alphabetsA, alphabetsB);
				
				// 두 단어가 애너그램인 경우 애너그램이라고 출력
				if (isAnagram) {
					out.write(wordA + " & " + wordB + " are anagrams.\n");
					
				// 두 단어가 애너그램이 아닌 경우 애너그램이 아니라고 출력
				} else {
					out.write(wordA + " & " + wordB + " are NOT anagrams.\n");
				}
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// anagramChecker() 메서드 정의
	public static boolean anagramChecker(int[] alphabetsA, int[] alphabetsB) {
		
		// for 반복문을 사용해 각 알파벳을 순회
		for (int idx = 0; idx < 26; idx++) {
			
			// 두 알파벳의 개수가 다른 경우 애너그램이 아니므로 false 반환
			if (alphabetsA[idx] != alphabetsB[idx])
				return false;
		}
		
		// 두 단어가 애너그램인 경우 true 반환
		return true;
	}
}