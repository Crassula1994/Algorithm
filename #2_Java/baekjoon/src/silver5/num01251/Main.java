package silver5.num01251;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// readLine() 메서드를 사용해 입력 받은 단어를 변수 word에 할당
		String word = in.readLine();
		
		// 각 단어를 나누고 뒤집은 결과를 저장할 PriorityQueue 객체 wordList 초기화
		PriorityQueue<String> wordList = new PriorityQueue<>();
		
		// for 반복문을 사용해 각각 단어를 나눌 위치를 순회
		for (int i = 1; i < word.length() - 1; i++) {
			for (int j = i + 1; j < word.length(); j++) {
				
				// substring(), reverse(), toString() 메서드를 사용해 해당 단어를 세 부분으로 나누고 뒤집은 결과를 각 변수에 저장
				String firstWord = new StringBuilder(word.substring(0, i)).reverse().toString();
				String secondWord = new StringBuilder(word.substring(i, j)).reverse().toString();
				String thirdWord = new StringBuilder(word.substring(j, word.length())).reverse().toString();
				
				// offer() 메서드를 사용해 각 단어를 결합한 결과를 wordList에 저장
				wordList.offer(firstWord + secondWord + thirdWord);
			}
		}
		
		// poll() 및 write() 메서드를 사용해 사전순으로 가장 앞서는 단어를 출력
		out.write(wordList.poll());

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}