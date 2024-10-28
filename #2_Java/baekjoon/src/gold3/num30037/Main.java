package gold3.num30037;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 문장의 개수를 변수 sentenceNum에 할당
		int sentenceNum = Integer.parseInt(in.readLine());
		
		// 규칙에 맞게 요약된 보고서를 출력할 StringBuilder 객체 sb 초기화
		StringBuilder sb = new StringBuilder();
		
		// while 반복문을 사용해 각 문장을 순회
		while (sentenceNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// 각 문장의 단어를 저장할 List 객체 words 초기화
			List<String> words = new ArrayList<>();
			
			// while 반복문을 사용해 각 단어를 순회
			while (st.hasMoreTokens()) {
				
				// nextToken() 메서드를 사용해 해당 단어를 변수 word에 할당
				String word = st.nextToken();
				
				// 해당 단어에 문장부호가 포함되어 있는 경우
				if (isPunctuation(word.charAt(word.length() - 1))) {
					
					// length(), substring(), add() 메서드를 사용해 문장부호와 단어를 구분하여 word에 저장
					words.add(word.substring(0, word.length() - 1));
					words.add(word.substring(word.length() - 1));
					
				// 해단 단어에 분장부호가 포함되어 있지 않은 경우 해당 단어를 words에 저장
				} else {
					words.add(word);
				}
			}
			
			// for 반복문을 사용해 각 단어를 순회
			for (int idx = 1; idx < words.size() - 1; idx++) {
				
				// 2번 규칙을 적용할 수 있는 경우
				if (words.get(idx).equals("of") && words.get(idx + 1).equals("Korea")
						&& !isPunctuation(words.get(idx - 1).charAt(words.get(idx - 1).length() - 1))) {
					
					// remove(), wordCapitalizer(), set() 메서드를 사용해 K-단어로 변환한 결과를 words에 추가
					words.set(idx - 1, "K-" + wordCapitalizer(words.remove(idx - 1)));
					
					// remove() 메서드를 사용해 'Korea' 단어 제거
					words.remove(idx--);
				}
			}
			
			// for 반복문을 사용해 각 단어를 거꾸로 순회
			for (int idx = words.size() - 2; idx >= 0; idx--) {
				
				// 1번 규칙을 적용할 수 있는 경우 K-단어로 변환한 결과를 words에 추가
				if (words.get(idx).equals("Korea") && !isPunctuation(words.get(idx + 1).charAt(0)))
					words.set(idx, "K-" + wordCapitalizer(words.remove(idx + 1)));
			}
			
			// for 반복문을 사용해 각 단어를 순회
			for (int idx = 0; idx < words.size(); idx++) {
				
				// get() 및 append() 메서드를 사용해 해당 단어를 sb에 추가
				sb.append(words.get(idx));
				
				// 다음 글자가 문장부호가 아닌 경우 띄어쓰기를 sb에 추가
				if (idx + 1 < words.size() && !isPunctuation(words.get(idx + 1).charAt(0)))
					sb.append(" ");
			}
			
			// append() 메서드를 사용해 줄바꿈을 sb에 추가
			sb.append("\n");
		}
		
		// toString() 및 write() 메서드를 사용해 규칙에 맞게 요약된 보고서를 출력
		out.write(sb.toString());
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// isPunctuation() 메서드 정의
	public static boolean isPunctuation(char character) {
		
		// 해당 문자가 문장부호인지 여부를 반환
		return character == '!' || character == '?' || character == ',' || character == '.';
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// wordCapitalizer() 메서드 정의
	public static String wordCapitalizer(String word) {
		
		// charAt(), toUpperCase(), substring() 메서드를 사용해 첫 글자를 대문자로 바꿔 반환
		return Character.toUpperCase(word.charAt(0)) + word.substring(1);
	}
}