package silver3.num27920;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 카드의 개수를 변수 cardNum에 할당
		int cardNum = Integer.parseInt(in.readLine());
		
		// 각 카드를 저장할 위치를 나타낼 변수 loc 초기화
		int loc = (cardNum % 2 == 0) ? cardNum / 2 - 1 : cardNum / 2;
		
		// 카드의 배열과 그 뒤집는 순서를 저장할 각 배열 초기화
		int[] cards = new int[cardNum];
		int[] orders = new int[cardNum];
		
		// for 반복문을 사용해 각 카드 번호를 순회
		for (int number = 1; number <= cardNum; number++) {
			
			// 각 카드의 위치와 그 뒤집는 순서를 갱신
			cards[loc] = number;
			orders[number - 1] = loc + 1;
			
			// 다음 카드를 저장할 위치를 갱신
			loc = (number % 2 == 0) ? loc - number : loc + number;
		}
		
		// write() 메서드를 사용해 모든 카드를 뒤집을 수 있도록 배열할 수 있으므로 'YES' 출력
		out.write("YES\n");
		
		// for 반복문을 사용해 각 카드의 배열을 출력
		for (int idx = 0; idx < cards.length; idx++)
			out.write(cards[idx] + " ");
		
		// newLine() 메서드를 사용해 줄바꿈 출력
		out.newLine();
		
		// for 반복문을 사용해 각 카드의 뒤집는 순서를 출력
		for (int idx = 0; idx < cards.length; idx++)
			out.write(orders[idx] + " ");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}