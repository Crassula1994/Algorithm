package silver5.num1181;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 단어의 개수를 변수 wordNum에 저장
		int wordNum = Integer.parseInt(in.readLine());
		
		// 각 단어를 저장할 배열 words 초기화
		String[] words = new String[wordNum];
		
		// for 반복문을 사용해 각 단어를 순회
		for (int idx = 0; idx < wordNum; idx++) {
			
			// readLine() 메서드를 사용해 입력 받은 단어를 배열 words에 저장
			words[idx] = in.readLine();
		}
		
		// sort() 메서드를 사용해 배열을 정렬
		Arrays.sort(words, (word1, word2) -> {
			return word1.length() != word2.length() ? word1.length() - word2.length() : word1.compareTo(word2);
		});
		
		// for 반복문을 사용해 배열 words의 각 단어를 순회
		for (int idx = 0; idx < wordNum; idx++) {
			
			// 해당 단어가 중복될 경우 다음 단어로 넘기기
			if (idx > 0 && words[idx].equals(words[idx - 1]))
				continue;
			
			// write() 메서드를 사용해 단어를 출력
			out.write(words[idx] + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}