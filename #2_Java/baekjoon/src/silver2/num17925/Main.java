package silver2.num17925;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

// Main 클래스 정의
public class Main {

	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 범주의 수를 변수 categoryNum에 할당
		int categoryNum = Integer.parseInt(in.readLine());
		
		// 가장 많은 단어 일치 횟수를 저장할 변수 maxMatchCount 초기화
		int maxMatchCount = 0;
		
		// 각 범주별 단어 일치 횟수, 각 단어가 속해 있는 범주를 저장할 각 Map 객체 초기화
		Map<String, Integer> matchCounts = new TreeMap<>();
		Map<String, List<String>> keywords = new HashMap<>();
		
		// while 반복문을 사용해 각 범주를 순회
		while (categoryNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 범주와 그에 속한 단어의 개수를 각 변수에 할당
			String category = st.nextToken();
			int wordNum = Integer.parseInt(st.nextToken());
			
			// put() 메서드를 사용해 해당 범주의 단어 일치 횟수를 초기화
			matchCounts.put(category, 0);
			
			// while 반복문을 사용해 해당 범주에 속한 각 단어를 순회
			while (wordNum-- > 0) {
				
				// nextToken() 메서드를 사용해 입력 받은 단어를 변수 word에 할당
				String word = st.nextToken();
				
				// 해당 단어가 keywords에 존재하지 않는 경우 해당 단어를 keywords에 추가
				if (!keywords.containsKey(word))
					keywords.put(word, new ArrayList<>());
				
				// get() 및 add() 메서드를 사용해 해당 단어가 속한 범주를 keywords에 추가
				keywords.get(word).add(category);
			}
		}
		
		// 각 문제의 서술을 저장할 변수 statement 초기화
		String statement;
		
		// while 반복문을 사용해 각 문제의 서술을 순회
		while ((statement = in.readLine()) != null) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(statement);
			
			// while 반복문을 사용해 해당 서술의 각 단어를 순회
			while (st.hasMoreTokens()) {
				
				// nextToken() 메서드를 사용해 해당 단어를 변수 word에 할당
				String word = st.nextToken();
				
				// 해당 단어가 keywords에 존재하지 않는 경우 다음 단어를 순회
				if (!keywords.containsKey(word))
					continue;
				
				// for 반복문을 사용해 해당 단어가 속한 각 범주의 단어 일치 횟수를 갱신
				for (String category : keywords.get(word))
					matchCounts.put(category, matchCounts.get(category) + 1);
			}
		}
		
		// for 반복문을 사용해 가장 많은 단어 일치 횟수를 갱신
		for (String category : matchCounts.keySet())
			maxMatchCount = Math.max(matchCounts.get(category), maxMatchCount);
		
		// for 반복문을 사용해 각 범주를 순회
		for (String category : matchCounts.keySet()) {
			
			// 해당 범주의 단어 일치 횟수가 가장 많은 단어 일치 횟수와 같은 경우 해당 범주를 출력
			if (matchCounts.get(category) == maxMatchCount)
				out.write(category + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}