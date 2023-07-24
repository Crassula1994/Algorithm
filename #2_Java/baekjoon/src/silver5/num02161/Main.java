package silver5.num02161;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 카드의 수를 변수 cardNum에 할당
		int cardNum = Integer.parseInt(in.readLine());
		
		// 카드의 순서를 저장할 Queue 객체 order 초기화
		Queue<Integer> order = new LinkedList<>();
		
		// for 반복문을 사용해 각 카드를 차례로 order에 추가
		for (int card = 1; card <= cardNum; card++)
			order.offer(card);
		
		// while 반복문을 사용해 order가 빌 때까지 순회
		while (!order.isEmpty()) {
			
			// poll() 및 write() 메서드를 사용해 가장 위의 카드를 버리고, 이를 출력
			out.write(order.poll() + " ");
			
			// 카드가 남아 있는 경우 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 이동
			if (!order.isEmpty())
				order.offer(order.poll());
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}