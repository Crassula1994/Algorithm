package bronze1.num02204;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// while 반복문을 사용해 모든 테스트 케이스를 순회
		while (true) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 단어의 개수를 변수 wordNum에 할당
			int wordNum = Integer.parseInt(in.readLine());
			
			// 단어의 개수가 0인 경우 반복문 탈출
			if (wordNum == 0)
				break;
			
			// 각 단어를 저장할 배열 words 초기화
			String[] words = new String[wordNum];
			
			// 각 단어를 소문자로 변환해 저장할 PriorityQueue 객체 dictionary 초기화
			PriorityQueue<String[]> dictionary = new PriorityQueue<>(Comparator.comparing(w -> w[1]));
			
			// for 반복문을 사용해 입력 받은 각 단어를 순회
			for (int idx = 0; idx < wordNum; idx++) {
				
				// readLine() 메서드를 사용해 입력 받은 단어를 배열 words에 저장
				words[idx] = in.readLine();
				
				// valueOf(), toLowerCase(), offer() 메서드를 사용해 소문자로 변환한 결과를 인덱스와 함께 dictionary에 추가
				dictionary.offer(new String[] {String.valueOf(idx), words[idx].toLowerCase()});
			}
			
			// poll() 메서드를 사용해 사전 순으로 가장 앞서는 단어를 배열 headword에 할당
			String[] headword = dictionary.poll();
			
			// parseInt() 및 write() 메서드를 사용해 사전 순으로 가장 앞서는 단어를 출력
			if (headword != null)
				out.write(words[Integer.parseInt(headword[0])]);

			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}