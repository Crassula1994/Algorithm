package silver5.num31291;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 올바른 색상과 물건의 조합을 저장할 배열 rightAnswers 초기화
		String[] rightAnswers = {"white Barabashka", "blue book", "red chair", "gray mouse", "green bottle"};
		
		// for 반복문을 사용해 각 다섯 개 문장을 순회
		outer: for (int line = 0; line < 5; line++) {
			
			// readLine() 메서드를 사용해 입력 받은 문장을 변수 sentence에 할당
			String sentence = in.readLine();
			
			// replace() 메서드를 사용해 문장 부호를 빈 칸으로 대체
			sentence = sentence.replace('\'', ' ').replace(',', ' ').replace('.', ' ').replace('-', ' ');
			
			// for 반복문을 사용해 각 올바른 색상과 물건의 조합을 순회
			for (String answer : rightAnswers) {
				
				// 올바른 색상과 물건의 조합이 존재하는 경우 해당 조합을 출력 후 다음 문장을 순회
				if (sentence.contains(answer)) {
					out.write(answer + "\n");
					continue outer;
				}
			}
			
			// split() 및 asList() 메서드를 사용해 문장의 각 단어를 저장한 List 객체 words 초기화
			List<String> words = Arrays.asList(sentence.split("\\s+"));
			
			// for 반복문을 사용해 각 올바른 색상과 물건의 조합을 순회
			for (String answer : rightAnswers) {
				
				// StringTokenizer 객체를 불러와 변수 st에 할당
				StringTokenizer st = new StringTokenizer(answer);
				
				// nextToken() 메서드를 사용해 해당 조합의 색상과 물건을 각 변수에 할당
				String color = st.nextToken();
				String item = st.nextToken();
				
				// 문장에 각 색상과 물건이 모두 존재하지 않는 경우 해당 조합을 출력 후 다음 문장을 순회
				if (!words.contains(color) && !words.contains(item)) {
					out.write(answer + "\n");
					continue outer;
				}
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}