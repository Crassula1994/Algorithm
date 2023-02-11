package silver4.num2164;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 카드의 번호를 변수 card에 할당
		int card = Integer.parseInt(in.readLine());
		
		// 카드의 배열을 담을 Queue 객체 cardQueue 초기화
		Queue<Integer> cardQueue = new LinkedList<>();

		// for 반복문을 사용해 입력 받은 카드를 cardQueue에 추가
		for (int num = 1; num < card + 1; num++)
			cardQueue.add(num);
		
		// while 반복문을 사용해 cardQueue에 카드 1장이 남을 때까지 순회
		while (true) {
			
			// cardQueue에 카드 1장이 남은 경우 반복문 탈출
			if (cardQueue.size() == 1)
				break;
			
			// remove() 메서드를 사용해 가장 앞의 카드 제거
			cardQueue.remove();
		
			// poll() 메서드 및 offer() 메서드를 사용해 가장 앞의 카드를 뽑아 다시 cardQueue에 삽입
			cardQueue.offer(cardQueue.poll());
		}

		// poll(), valueOf(), write() 메서드를 사용해 마지막 남은 카드를 출력
		out.write(String.valueOf(cardQueue.poll()));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}