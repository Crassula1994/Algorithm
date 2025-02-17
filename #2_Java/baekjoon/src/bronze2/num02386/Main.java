package bronze2.num02386;

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
		
		// while 반복문을 사용해 각 문장을 순회
		while (true) {
			
			// readLine() 메서드를 사용해 입력 받은 문장을 변수 sentence에 할당
			String sentence = in.readLine();
			
			// 모든 문장을 확인한 경우 반복문 탈출
			if (sentence.equals("#"))
				break;
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(sentence);
			
			// nextToken() 및 charAt() 메서드를 사용해 입력 받은 목표 알파벳을 변수 targetAlphabet에 할당
			char targetAlphabet = st.nextToken().charAt(0);
			
			// 목표 알파벳이 나타난 횟수를 저장할 변수 count 초기화
			int count = 0;
			
			// while 반복문을 사용해 각 문장을 순회
			while (st.hasMoreTokens()) {
				
				// nextToken(), toLowerCase(), toCharArray() 메서드를 사용해 해당 문장의 단어를 변수 word에 할당
				char[] word = st.nextToken().toLowerCase().toCharArray();
				
				// for 반복문을 사용해 해당 단어의 각 알파벳을 순회
				for (char alphabet : word) {
					
					// 해당 알파벳이 목표 알파벳인 경우 목표 알파벳이 나타난 횟수를 갱신
					if (alphabet == targetAlphabet)
						count++;
				}
			}
			
			// write() 메서드를 사용해 목표 알파벳이 나타난 횟수를 출력
			out.write(targetAlphabet + " " + count + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}