package silver2.num01411;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 단어의 개수를 변수 wordNum에 할당
		int wordNum = Integer.parseInt(in.readLine());
		
		// 단어 중 비슷한 쌍의 개수를 저장할 변수 pairCount 초기화
		int pairCount = 0;
		
		// 입력 받은 단어를 알파벳이 출현한 순서대로 바꿔 저장할 배열 words 초기화
		String[] words = new String[wordNum];
		
		// for 반복문을 사용해 각 단어를 순회
		for (int idx = 0; idx < words.length; idx++) {
			
			// readLine() 및 toCharArray() 메서드를 사용해 해당 단어를 배열 word에 저장
			char[] word = in.readLine().toCharArray();
			
			// 치환할 알파벳을 저장할 변수 count 초기화
			int count = 0;
			
			// 각 알파벳을 등장한 순서에 따라 치환할 배열 alphabets 초기화
			Integer[] alphabets = new Integer[26];
			
			// for 반복문을 사용해 해당 단어의 각 알파벳을 순회
			for (int wordIdx = 0; wordIdx < word.length; wordIdx++) {
				
				// 해당 알파벳의 순서를 변수 order에 할당
				int order = word[wordIdx] - 'a';
				
				// 처음 등장한 알파벳인 경우 치환할 알파벳을 배열 alphabets에 저장
				if (alphabets[order] == null)
					alphabets[order] = count++;
				
				// 해당 알파벳을 치환해 배열 word에 저장
				word[wordIdx] = (char) ('a' + alphabets[order]);
			}
			
			// 각 알파벳을 등장한 순서에 따라 치환한 단어를 배열 words에 저장
			words[idx] = new String(word);
		}
		
		// for 반복문을 사용해 각 단어의 쌍을 순회
		for (int w1 = 0; w1 < words.length - 1; w1++) {
			for (int w2 = w1 + 1; w2 < words.length; w2++) {
			
				// 두 단어가 같은 경우 단어 중 비슷한 쌍의 개수를 갱신
				if (words[w1].equals(words[w2]))
					pairCount++;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 단어 중 비슷한 쌍의 개수를 출력
		out.write(String.valueOf(pairCount));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}