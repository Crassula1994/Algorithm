package silver3.num14235;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 아이들과 거점지를 방문한 횟수를 변수 visitCount에 할당
		int visitCount = Integer.parseInt(in.readLine());
		
		// 현재 산타가 가지고 있는 선물의 가치를 저장할 PriorityQueue 객체 gifts 초기화
		PriorityQueue<Integer> gifts = new PriorityQueue<>((g1, g2) -> {
			return g2 - g1;
		});
		
		// while 반복문을 사용해 각 방문지를 순회
		while (visitCount-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 거점지에서 충전한 선물의 수를 변수 giftNum에 할당
			int giftNum = Integer.parseInt(st.nextToken());
			
			// 아이들을 만난 경우 산타가 아이들에게 준 선물의 가치를 출력 후 다음 방문지를 순회
			if (giftNum == 0) {
				out.write((gifts.isEmpty()) ? -1 + "\n" : gifts.poll() + "\n");
				continue;
			}
			
			// while 반복문을 사용해 거점지에서 충전한 선물을 gifts에 추가
			while (giftNum-- > 0)
				gifts.offer(Integer.parseInt(st.nextToken()));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}