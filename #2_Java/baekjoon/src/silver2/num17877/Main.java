package silver2.num17877;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 요소의 수와 제수를 각 변수에 할당
		int elementNum = Integer.parseInt(st.nextToken());
		int divisor = Integer.parseInt(st.nextToken());
		
		// 같은 몫을 가지는 원소 쌍의 개수를 저장할 변수 pairCount 초기화
		long pairCount = 0;
		
		// 같은 몫을 가지는 원소의 개수를 저장할 Map 객체 quotients 초기화
		Map<Integer, Long> quotients = new HashMap<>();
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// while 반복문을 사용해 각 요소를 순회
		while (elementNum-- > 0) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 해당 요소를 제수로 나누었을 때의 몫을 변수 quotient에 할당
			int quotient = Integer.parseInt(st.nextToken()) / divisor;
			
			// getOrDefault() 및 put() 메서드를 사용해 같은 몫을 가지는 원소의 개수를 quotients에 저장
			quotients.put(quotient, quotients.getOrDefault(quotient, 0L) + 1);
		}
		
		// for 반복문을 사용해 같은 몫을 가지는 원소 쌍의 개수를 갱신
		for (long count : quotients.values())
			pairCount += count * (count - 1) / 2;
		
		// valueOf() 및 write() 메서드를 사용해 같은 몫을 가지는 원소 쌍의 개수를 출력
		out.write(String.valueOf(pairCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}