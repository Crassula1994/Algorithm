package silver1.num12656;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 단어의 글자, 단어, 테스트 케이스의 개수를 각 변수에 할당
		int letterNum = Integer.parseInt(st.nextToken());
		int wordNum = Integer.parseInt(st.nextToken());
		int testCase = Integer.parseInt(st.nextToken());
		
		// 외계인의 단어를 저장할 배열 words 초기화
		String[] words = new String[wordNum];
		
		// for 반복문을 사용해 입력 받은 외계인의 단어를 배열 words에 저장
		for (int idx = 0; idx < words.length; idx++)
			words[idx] = in.readLine();
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 1; tc <= testCase; tc++) {
			
			// readLine() 메서드를 사용해 입력 받은 패턴을 변수 pattern에 할당
			String pattern = in.readLine();
			
			// 입력 받은 패턴과 일치하는 단어의 수를 저장할 변수 count 초기화
			int count = 0;
			
			// letterFinder() 메서드를 사용해 각 패턴의 가능한 글자를 저장한 배열 letters 초기화
			Set<Character>[] letters = letterFinder(pattern, letterNum);
			
			// for 반복문을 사용해 각 외계인의 단어를 순회
			for (String word : words) {
				
				// 해당 단어가 패턴과 일치하는지 여부를 저장할 변수 isMatched 초기화
				boolean isMatched = true;
				
				// for 반복문을 사용해 단어의 각 글자를 순회
				for (int idx = 0; idx < letterNum; idx++) {
					
					// 해당 글자가 패턴에 포함되어 있지 않은 경우 해당 단어가 패턴과 일치하는지 여부를 갱신 후 반복문 탈출
					if (!letters[idx].contains(word.charAt(idx))) {
						isMatched = false;
						break;
					}
				}
				
				// 해당 단어가 패턴과 일치하는 경우 패턴과 일치하는 단어의 수를 갱신
				if (isMatched)
					count++;
			}
			
			// write() 메서드를 사용해 입력 받은 패턴과 일치하는 단어의 수를 출력
			out.write("Case #" + tc + ": " + count + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// letterFinder() 메서드 정의
	@SuppressWarnings("unchecked")
	public static Set<Character>[] letterFinder(String pattern, int letterNum) {
		
		// 각 패턴의 가능한 글자를 저장할 배열 letters 초기화
		Set<Character>[] letters = new HashSet[letterNum];
		
		// for 반복문을 사용해 각 패턴의 글자를 순회
		for (int letter = 0, idx = 0; letter < letters.length; letter++) {
			
			// 해당 글자의 패턴을 저장할 Set 객체 초기화
			letters[letter] = new HashSet<>();
			
			// 괄호가 존재하는 경우
			if (pattern.charAt(idx) == '(') {
				
				// while 반복문을 사용해 닫는 괄호를 찾을 때까지 순회
				while (pattern.charAt(++idx) != ')')
					letters[letter].add(pattern.charAt(idx));
				
				// 현재 확인 중인 글자를 갱신
				idx++;
				
			// 괄호가 존재하지 않는 경우 해당 글자를 letters에 저장
			} else {
				letters[letter].add(pattern.charAt(idx++));
			}
		}
		
		// 각 패턴의 가능한 글자를 저장한 배열 반환
		return letters;
	}
}