package bronze2.num10801;

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
		
		// A와 B의 승리 횟수를 저장할 각 변수 초기화
		int countA = 0;
		int countB = 0;
		
		// StringTokenizer 객체를 불러와 각 변수에 할당
		StringTokenizer cardsA = new StringTokenizer(in.readLine());
		StringTokenizer cardsB = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 라운드를 순회
		for (int round = 0; round < 10; round++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 해당 라운드에 두 사람이 제시한 카드의 숫자를 각 변수에 할당
			int cardA = Integer.parseInt(cardsA.nextToken());
			int cardB = Integer.parseInt(cardsB.nextToken());
			
			// A가 승리한 경우 A의 승리 횟수를 갱신
			if (cardA > cardB) {
				countA++;
				
			// B가 승리한 경우 B의 승리 횟수를 갱신
			} else if (cardA < cardB) {
				countB++;
			}
		}
		
		// A가 게임의 승자인 경우 'A'를 출력
		if (countA > countB) {
			out.write("A");
		
		// B가 게임의 승자인 경우 'B'를 출력
		} else if (countA < countB) {
			out.write("B");
			
		// A와 B가 비기는 경우 'D'를 출력
		} else {
			out.write("D");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}