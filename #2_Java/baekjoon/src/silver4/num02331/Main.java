package silver4.num02331;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 수열의 첫 숫자와 곱한 횟수를 각 변수에 할당
		int startValue = Integer.parseInt(st.nextToken());
		int exponent = Integer.parseInt(st.nextToken());
		
		// 수열의 각 항과 수열에 등장하는 순서를 나타낼 변수 order 초기화
		int term = startValue;
		int order = 0;
		
		// 각 수열 숫자의 등장 여부와 그 위치를 저장할 Map 객체 sequence 초기화
		Map<Integer, Integer> sequence = new HashMap<>();
		
		// while 반복문을 사용해 똑같은 숫자가 나타날 때까지 순회
		while (true) {
			
			// 해당 항이 이미 수열에 등장한 경우
			if (sequence.containsKey(term)) {
				
				// get(), valueOf(), write() 메서드를 사용해 수열에 남게되는 수들의 개수를 출력
				out.write(String.valueOf(sequence.get(term)));
				
				// 반복문 탈출
				break;
			}
			
			// put() 메서드를 사용해 해당 수열의 항을 sequence에 추가
			sequence.put(term, order++);
			
			// 다음 항을 저장할 변수 nextTerm 초기화
			int nextTerm = 0;
			
			// while 반복문을 사용해 현재 항의 각 자릿수를 순회
			while (term > 0) {
				
				// pow() 메서드를 사용해 해당 자릿 수를 곱한 횟수만큼 곱한 수를 nextTerm에 더해 갱신
				nextTerm += Math.pow(term % 10, exponent);
				
				// 다음 자릿수를 위해 현재 항을 갱신
				term /= 10;
			}
			
			// 현재 항을 다음 항으로 갱신
			term = nextTerm;
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}