package bronze1.num05046;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 참가자의 수, 예산, 호텔의 수, 고를 수 있는 주의 개수를 각 변수에 할당
		int numberLimit = Integer.parseInt(st.nextToken());
		int budgetLimit = Integer.parseInt(st.nextToken());
		int hotelNum = Integer.parseInt(st.nextToken());
		int weekNum = Integer.parseInt(st.nextToken());
		
		// 대회를 개최할 수 있는 최소 비용을 저장할 변수 minCost 초기화
		int minCost = Integer.MAX_VALUE;
		
		// while 반복문을 사용해 각 호텔을 순회
		while (hotelNum-- > 0) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 호텔의 일인당 숙박 비용을 변수 cost에 할당
			int cost = Integer.parseInt(in.readLine());
			
			// 호텔에서 모든 참가자가 묵었을 때의 숙박비용이 예산을 초과한 경우 다음 호텔을 순회
			if (cost * numberLimit > budgetLimit) {
				in.readLine();
				continue;
			}
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 각 주를 순회
			for (int week = 0; week < weekNum; week++) {
				
				// 해당 주의 투숙 가능한 인원이 참가자 수보다 적은 경우 다음 주를 순회
				if (Integer.parseInt(st.nextToken()) < numberLimit)
					continue;
				
				// min() 메서드를 사용해 대회를 개최할 수 있는 최소 비용을 갱신 후 반복문 탈출
				minCost = Math.min(cost * numberLimit, minCost);
				break;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 대회를 개최할 수 있으면 최소비용을, 없으면 'stay home'을 출력
		out.write((minCost == Integer.MAX_VALUE) ? "stay home" : String.valueOf(minCost));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}