package bronze1.num12085;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 1; tc <= testCase; tc++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 카드의 개수를 변수 cardNum에 할당
			int cardNum = Integer.parseInt(in.readLine());
			
			// 로봇이 카드를 정렬하는 데 필요한 금액을 저장할 변수 totalCost 초기화
			int totalCost = 0;
			
			// 피겨 스케이터 카드에 적힌 이름을 저장할 배열 cards 초기화
			String[] cards = new String[cardNum];
			
			// for 반복문을 사용해 입력 받은 카드에 적힌 이름을 배열 cards에 저장
			for (int idx = 0; idx < cards.length; idx++)
				cards[idx] = in.readLine();
			
			// for 반복문을 사용해 각 카드를 순회
			for (int idx = 1, cur = 0; idx < cards.length; idx++) {
				
				// 현재 정렬 중인 카드보다 사전 순으로 앞선 카드인 경우 로봇이 카드를 정렬하는 데 필요한 금액을 갱신
				if (cards[cur].compareTo(cards[idx]) > 0) {
					totalCost++;
				
				// 현재 정렬 중인 카드보다 사전 순으로 뒤쪽 카드인 경우 현재 정렬 중인 카드를 갱신
				} else {
					cur = idx;
				}
			}
			
			// write() 메서드를 사용해 로봇이 카드를 정렬하는 데 필요한 금액을 출력
			out.write("Case #" + tc + ": " + totalCost);
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}