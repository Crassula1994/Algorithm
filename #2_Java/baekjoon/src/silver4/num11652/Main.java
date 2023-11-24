package silver4.num11652;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 가장 많은 숫자 카드의 개수 및 그 번호를 저장할 각 변수 초기화
		int maxCount = 0;
		long maxNumber = Long.MAX_VALUE;
		
		// 해당 숫자 카드의 개수를 저장할 Map 객체 cardCounter 초기화
		Map<Long, Integer> cardCounter = new HashMap<>();
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자 카드의 개수를 변수 cardNum에 할당
		int cardNum = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 숫자 카드를 순회
		for (int card = 0; card < cardNum; card++) {
			
			// readLine() 및 parseLong() 메서드를 사용해 입력 받은 숫자 카드의 숫자를 변수 number에 할당
			long number = Long.parseLong(in.readLine());
			
			// put() 메서드를 사용해 숫자 카드의 개수를 갱신
			cardCounter.put(number, cardCounter.getOrDefault(number, 0) + 1);
		}
		
		// for 반복문을 사용해 각 숫자 카드의 숫자를 순회
		for (long number : cardCounter.keySet()) {
			
			// get() 메서드를 사용해 해당 숫자 카드의 개수를 변수 count에 할당
			int count = cardCounter.get(number);
			
			// 해당 카드의 개수가 현재까지 저장된 가장 많은 숫자 카드의 개수보다 많은 경우
			if (count > maxCount) {
				
				// 가장 많은 숫자 카드의 개수 및 그 번호를 갱신
				maxCount = count;
				maxNumber = number;
				
			// 해당 카드의 개수가 현재까지 저장된 가장 많은 숫자 카드의 개수와 같고 더 적은 숫자인 경우
			} else if (count == maxCount && number < maxNumber) {
				
				// 가장 많은 숫자 카드의 번호를 갱신
				maxNumber = number;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 가장 많은 숫자 카드의 번호를 출력
		out.write(String.valueOf(maxNumber));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}