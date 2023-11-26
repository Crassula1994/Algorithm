package bronze1.num02526;

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
		
		// 계산 과정에 따라 나오는 결과를 저장할 Map 객체 results 초기화
		Map<Integer, Integer> results = new HashMap<>();
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 두 숫자를 각 변수에 할당
		int dividend = Integer.parseInt(st.nextToken());
		int divisor = Integer.parseInt(st.nextToken());
		
		// 결과 값과 그 순서를 저장할 각 변수 초기화
		int result = dividend;
		int order = 1;

		// put() 메서드를 사용해 처음 출력하는 수를 results에 추가
		results.put(result, order);
		
		// while 반복문을 사용해 사이클을 확인할 때까지 순회
		while (true) {
			
			// 결과 값을 갱신
			result = (result * dividend) % divisor;
			
			// 해당 값이 이미 존재하는 경우
			if (results.containsKey(result)) {
				
				// size() 및 get() 메서드를 사용해 반복되는 부분에 포함된 서로 다른 수의 개수를 계산하고, 변수 count에 할당
				int count = results.size() - results.get(result) + 1;
				
				// valueOf() 및 write() 메서드를 사용해 반복되는 부분에 포함된 서로 다른 수의 개수를 출력
				out.write(String.valueOf(count));
				
				// 반복문 탈출
				break;
			}
			
			// put() 메서드를 사용해 해당 결과 값을 results에 추가
			results.put(result, ++order);
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}