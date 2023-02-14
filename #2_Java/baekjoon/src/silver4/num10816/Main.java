package silver4.num10816;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자 카드의 개수를 변수 inLength에 할당
		int inLength = Integer.parseInt(in.readLine());
		
		// 숫자 카드를 저장할 Map 객체 cardDict 초기화
		Map<Integer, Integer> cardDict = new HashMap<>();
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 숫자 카드를 순회
		for (int i = 0; i < inLength; i++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 숫자 카드를 변수 card에 할당
			int card = Integer.parseInt(st.nextToken());
			
			// cardDict에 해당 카드가 존재하는 경우
			if (cardDict.containsKey(card)) {
				
				// get() 및 replace() 메서드를 사용해 개수를 갱신
				int cnt = cardDict.get(card) + 1;
				cardDict.replace(card, cnt);
				
			// cardDict에 해당 카드가 존재하지 않는 경우
			} else {
				
				// put() 메서드를 사용해 해당 카드를 추가
				cardDict.put(card, 1);
			}
		}

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 조회해야 할 숫자 카드의 개수를 변수 outLength에 할당
		int outLength = Integer.parseInt(in.readLine());
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 숫자 카드를 조회
		for (int j = 0; j < outLength; j++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 숫자 카드를 변수 card에 할당
			int card = Integer.parseInt(st.nextToken());
			
			// cardDict에 해당 카드가 존재하는 경우
			if (cardDict.containsKey(card)) {
				
				// get() 및 write() 메서드를 사용해 카드의 개수를 출력
				out.write(cardDict.get(card) + " ");
			
			// cardDict에 해당 카드가 존재하지 않는 경우 0을 출력
			} else {
				out.write(0 + " ");
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}