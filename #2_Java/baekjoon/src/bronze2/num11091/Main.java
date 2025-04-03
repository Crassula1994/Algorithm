package bronze2.num11091;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 문장의 수를 변수 sentenceNum에 할당
		int sentenceNum = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 문장을 순회
		while (sentenceNum-- > 0) {
			
			/* readLine(), toLowerCase(), toCharArray() 메서드를 사용해
			입력 받은 문장의 대문자를 모두 소문자로 바꾸어 배열 sentence에 저장 */
			char[] sentence = in.readLine().toLowerCase().toCharArray();
			
			// 해당 문장에 나타난 알파벳의 개수를 저장할 변수 count 초기화
			int count = 0;
			
			// 각 알파벳의 해당 문장 등장 여부를 저장할 배열 alphabets 초기화
			boolean[] alphabets = new boolean[26];
			
			// for 반복문을 사용해 문장의 각 글자를 순회
			for (char character : sentence) {
				
				// 해당 문자가 알파벳이 아닌 경우 다음 글자를 순회
				if (character < 'a' || character > 'z')
					continue;
				
				// 해당 알파벳의 순서를 변수 order에 할당
				int order = character - 'a';
				
				// 해당 알파벳이 처음 등장하는 경우 해당 알파벳의 등장 여부 및 해당 문장에 나타난 알파벳의 개수를 갱신
				if (!alphabets[order]) {
					alphabets[order] = true;
					count++;
				}
			}
			
			// 해당 문장이 팬그램인 경우 'pangram'을 출력
			if (count == 26) {
				out.write("pangram");
				
			// 해당 문장이 팬그램이 아닌 경우
			} else {
				
				// write() 메서드를 사용해 'missing '을 출력
				out.write("missing ");
				
				// for 반복문을 사용해 각 알파벳을 순회
				for (int idx = 0; idx < 26; idx++) {
					
					// 해당 문장에 존재하지 않는 알파벳인 경우 해당 알파벳을 출력
					if (!alphabets[idx])
						out.write((char) (idx + 'a'));
				}
			}
		
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}