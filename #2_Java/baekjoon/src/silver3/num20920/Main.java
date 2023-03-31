package silver3.num20920;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 단어의 개수 및 외울 단어의 길이 기준을 각 변수에 할당
		int wordNum = Integer.parseInt(st.nextToken());
		int lenLimit = Integer.parseInt(st.nextToken());		
		
		// 해당 단어의 개수를 저장할 Map 객체 wordCounter 초기화
		Map<String, Integer> wordCounter = new HashMap<>();
		
		// for 반복문을 사용해 각 단어를 순회
		for (int w = 0; w < wordNum; w++) {
			
			// readLine() 메서드를 사용해 입력 받은 단어를 변수 word에 할당
			String word = in.readLine();
			
			// 해당 단어의 길이가 길이 기준을 넘지 못하는 경우 다음 단어 순회
			if (word.length() < lenLimit)
				continue;

			// getOrDefault() 및 put() 메서드를 사용해 해당 단어의 개수를 wordCounter에 저장
			wordCounter.put(word, wordCounter.getOrDefault(word, 1));
		}
		
		// entrySet() 메서드를 사용해 wordCounter를 List 객체 wordList로 변환
		List<Entry<String, Integer>> wordList = new ArrayList<>(wordCounter.entrySet());

		//
		Collections.sort(wordList, (w1, w2) -> {
			return (w1.getValue() == w2.getValue()) ? w2.getValue() - w1.getValue();
		});
		
		// valueOf() 및 write() 메서드를 사용해 곰곰티콘이 사용된 횟수를 출력
		out.write(String.valueOf(emoticonCnt));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}