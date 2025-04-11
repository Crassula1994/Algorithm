package silver3.num33094;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 식단 계획의 일 수, 우유의 양과 비스킷의 개수를 각 변수에 할당
		int dayNum = Integer.parseInt(st.nextToken());
		int milkAmount = Integer.parseInt(st.nextToken());
		int biscuitNum = Integer.parseInt(st.nextToken());
		
		// 식단 계획을 유지할 수 있는 최대 일수를 저장할 변수 maxDay 초기화
		int maxDay = 0;
		
		// reverseOrder() 메서드를 사용해 우유를 사용한 날의 우유량을 저장할 PriorityQueue 객체 milkIntake 초기화
		PriorityQueue<Integer> milkIntake = new PriorityQueue<>(Collections.reverseOrder());
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		st = new StringTokenizer(in.readLine());
		
		// while 반복문을 사용해 각 날짜를 순회
		while (dayNum-- > 0) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 해당 날짜에 필요한 우유의 양을 변수 amount에 할당
			int amount = Integer.parseInt(st.nextToken());
			
			// 우유가 부족한 경우
			if (milkAmount < amount) {
				
				// 비스킷이 없는 경우 반복문 탈출
				if (biscuitNum == 0)
					break;
				
				// 이전에 우유를 먹은 적이 있는 경우 우유 대신 비스킷을 먹은 것으로 처리
				if (!milkIntake.isEmpty()) {
					milkIntake.offer(amount);
					milkAmount += milkIntake.poll() - amount;
				}
				
				// 여전히 우유가 부족한 경우 반복문 탈출
				if (milkAmount < 0)
					break;
				
				// 현재 비스킷의 개수, 식단 계획을 유지할 수 있는 최대 일수를 갱신
				biscuitNum--;
				maxDay++;
				
				// 다음 날짜를 순회
				continue;
			}
			
			// offer() 메서드를 사용해 사용한 우유의 양을 milkIntake에 저장
			milkIntake.offer(amount);
			
			// 현재 우유의 양 및 식단 계획을 유지할 수 있는 최대 일수를 갱신
			milkAmount -= amount;
			maxDay++;
		}
		
		// valueOf() 및 write() 메서드를 사용해 식단 계획을 유지할 수 있는 최대 일수를 출력
		out.write(String.valueOf(maxDay));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}