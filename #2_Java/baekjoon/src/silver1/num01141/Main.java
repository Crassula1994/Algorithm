package silver1.num01141;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 단어의 개수를 변수 wordNum에 할당
		int wordNum = Integer.parseInt(in.readLine());
		
		// 입력 받은 단어를 저장할 PriorityQueue 객체 words 초기화
		PriorityQueue<String> words = new PriorityQueue<>((w1, w2) -> {
			return w2.length() - w1.length();
		});
		
		// for 반복문을 사용해 입력 받은 단어를 words에 저장
		for (int word = 0; word < wordNum; word++)
			words.offer(in.readLine());
		
		// 접두사X 집합을 저장할 Set 객체 prefixX 초기화
		Set<String> prefixX = new HashSet<>();

		// while 반복문을 사용해 words가 빌 때까지 순회
		while (!words.isEmpty()) {
			
			// poll() 메서드를 사용해 단어를 변수 word에 할당
			String word = words.poll();
			
			// 해당 단어를 추가할 수 있는지 여부를 나타내는 변수 isPrefixX 초기화
			boolean isPrefixX = true;
			
			// for 반복문을 사용해 prefixX의 원소를 순회
			for (String element: prefixX) {
				
				// 해당 원소가 해당 단어를 접두사로 지닌 경우 isPrefixX 갱신 및 반복문 탈출
				if (element.substring(0, word.length()).equals(word)) {
					isPrefixX = false;
					break;
				}
			}
			
			// 해당 단어를 추가할 수 있는 경우 prefixX에 추가
			if (isPrefixX)
				prefixX.add(word);
		}
		
		// size(), valueOf(), write() 메서드를 사용해 접두사X 집합인 부분집합의 최대 크기를 출력
		out.write(String.valueOf(prefixX.size()));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}