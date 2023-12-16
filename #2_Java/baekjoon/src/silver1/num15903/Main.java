package silver1.num15903;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 카드의 개수 및 카드 합체의 횟수를 각 변수에 할당
		int cardNum = Integer.parseInt(st.nextToken());
		int unionCnt = Integer.parseInt(st.nextToken());
		
		// 현재 카드의 상태를 저장할 PriorityQueue 객체 cards 초기화
		PriorityQueue<Long> cards = new PriorityQueue<>();
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 카드를 cards에 저장
		for (int card = 0; card < cardNum; card++)
			cards.offer(Long.parseLong(st.nextToken()));
		
		// for 반복문을 사용해 각 카드 합체를 순회
		for (int union = 0; union < unionCnt; union++) {
			
			// poll() 메서드를 사용해 가장 작은 카드 두 개를 뽑아 더한 값을 변수 sum에 할당
			long sum = cards.poll() + cards.poll();
			
			// offer() 메서드를 사용해 카드 합체 후의 결과를 cards에 추가
			cards.offer(sum);
			cards.offer(sum);
		}
		
		// 모든 카드의 합을 저장할 변수 totalSum 초기화
		long totalSum = 0;
		
		// while 반복문을 사용해 모든 카드의 합을 갱신
		while (!cards.isEmpty())
			totalSum += cards.poll();
		
		// valueOf() 및 write() 메서드를 사용해 만들 수 있는 가장 작은 점수를 출력
		out.write(String.valueOf(totalSum));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}