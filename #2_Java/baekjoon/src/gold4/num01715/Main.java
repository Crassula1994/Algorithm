package gold4.num01715;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 카드 묶음의 수를 변수 cardDecks에 할당
		int cardDecks = Integer.parseInt(in.readLine());
		
		// 각 카드 묶음의 수를 저장할 PriorityQueue 객체 minHeap 초기화
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		
		// for 반복문을 사용해 각 카드 묶음을 순회하며 minHeap에 저장
		for (int c = 0; c < cardDecks; c++)
			minHeap.offer(Integer.parseInt(in.readLine()));
		
		// 최소 비교 횟수를 저장할 변수 minCnt 초기화
		int minCnt = 0;
		
		// 카드 묶음이 두 개 이상인 경우
		if (cardDecks > 1) {
			
			// poll() 메서드를 사용해 카드 묶음 첫 두 개를 합친 값을 갱신
			minCnt += minHeap.poll() + minHeap.poll();
		
			// while() 반복문을 사용해 minHeap이 빌 때까지 순회
			while (!minHeap.isEmpty())
				
				// 최소 비교 횟수를 갱신
				minCnt += minCnt + minHeap.poll();
		}
		
		// valueOf() 및 write() 메서드를 사용해 최소 비교 횟수을 출력
		out.write(String.valueOf(minCnt));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}