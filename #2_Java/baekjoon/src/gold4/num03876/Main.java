package gold4.num03876;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 문자열을 바꾸는 규칙의 쌍을 저장할 Map 객체 rules 초기화
	static Map<String, String> rules;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (true) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 문자열을 바꾸는 규칙의 쌍의 개수를 변수 pairNum에 할당
			int pairNum = Integer.parseInt(in.readLine());
			
			// 모든 테스트 케이스를 확인한 경우 반복문 탈출
			if (pairNum == 0)
				break;
			
			// 문자열을 바꾸는 규칙의 쌍을 저장할 Map 객체 rules 초기화
			rules = new HashMap<>();
			
			// while 반복문을 사용해 각 문자열을 바꾸는 규칙의 쌍을 순회
			while (pairNum-- > 0) {
				
				// StringTokenizer 객체를 불러와 변수 st에 할당
				StringTokenizer st = new StringTokenizer(in.readLine());
				
				// nextToken() 및 put() 메서드를 사용해 해당 문자열을 바꾸는 규칙의 쌍을 rules에 저장
				rules.put(st.nextToken(), st.nextToken());
			}
			
			// readLine() 메서드를 사용해 입력 받은 초기 문자열 및 최종 문자열을 각 변수에 할당
			String startString = in.readLine();
			String endString = in.readLine();
			
			// stringChanger() 및 write() 메서드를 사용해 필요한 문자열로 바꾸는 횟수의 최솟값을 출력
			out.write(stringChanger(startString, endString) + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// stringChanger() 메서드 정의
	public static int stringChanger(String startString, String endString) {
		
		// 각 문자열의 확인 여부를 저장할 Map 객체 changed 초기화
		Map<String, Integer> changed = new HashMap<>();
		
		// 다음에 확인할 문자열을 저장할 Queue 객체 changeList 초기화
		Queue<String> changeList = new LinkedList<>();
		
		// put() 메서드를 사용해 시작 문자열의 확인 여부를 changed에 저장
		changed.put(startString, 0);
		
		// offer() 메서드를 사용해 시작 문자열을 changeList에 추가
		changeList.offer(startString);
		
		// while 반복문을 사용해 changeList가 빌 때까지 순회
		while (!changeList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 확인 중인 문자열을 변수 curString에 할당
			String curString = changeList.poll();
			
			// 해당 문자열이 최종 문자열과 일치하는 경우 문자열을 바꾼 횟수를 반환
			if (curString.equals(endString))
				return changed.get(curString);
			
			// for 반복문을 사용해 각 문자열을 바꾸는 규칙의 쌍을 순회
			for (String subString : rules.keySet()) {
				
				// get() 및 replace() 메서드를 사용해 해당 규칙을 사용했을 때 바뀐 문자열을 변수 nextString에 할당
				String nextString = curString.replace(subString, rules.get(subString));
				
				// 해당 문자열을 이미 확인했거나 해당 문자열이 10글자 초과인 경우 다음 규칙을 순회
				if (changed.containsKey(nextString) || nextString.length() > 10)
					continue;
				
				// get() 및 put() 메서드를 사용해 해당 문자열의 확인 여부를 changed에 저장
				changed.put(nextString, changed.get(curString) + 1);
				
				// offer() 메서드를 사용해 해당 문자열을 changeList에 추가
				changeList.offer(nextString);
			}
		}
		
		// 최종 문자열을 만들 수 없는 경우 -1 반환
		return -1;
	}
}