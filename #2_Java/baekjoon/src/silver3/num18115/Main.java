package silver3.num18115;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 카드의 번호를 변수 cardNum에 할당
		int cardNum = Integer.parseInt(in.readLine());
		
		// 각 카드를 내려놓을 때 쓴 기술을 저장할 배열 techniques 초기화
		int[] techniques = new int[cardNum + 1];
		
		// 처음에 배치된 카드 상태를 저장할 Deque 객체 cards 초기화
		Deque<Integer> cards = new ArrayDeque<>();
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 카드를 내려놓을 때 쓴 기술을 배열 techniques에 저장
		for (int card = cardNum; card > 0; card--)
			techniques[card] = Integer.parseInt(st.nextToken());
			
		// for 반복문을 사용해 각 카드를 순회
		for (int card = 1; card <= cardNum; card++) {
			
			// switch 조건문을 사용해 각 기술에 따라 카드를 cards에 추가
			switch (techniques[card]) {
				case 1:
					cards.addFirst(card);
					break;
				case 2:
					cards.addLast(cards.pollFirst());
					cards.addFirst(card);
					cards.addFirst(cards.pollLast());
					break;
				default:
					cards.addLast(card);
			}
		}
		
		// while 반복문을 사용해 초기 카드의 상태를 위에서부터 순서대로 출력
		while (!cards.isEmpty())
			out.write(cards.pollFirst() + " ");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}