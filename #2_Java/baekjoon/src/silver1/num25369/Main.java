package silver1.num25369;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 선택할 카드 개수, 내가 선택한 카드 집합의 곱, 가장 작은 카드의 곱을 저장할 각 변수 초기화
	static int cardNum;
	static int targetProduct = 1;
	static int minProduct = -1;
	
	// 선택한 카드를 저장할 배열 cards 초기화
	static int[] cards;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 선택할 카드 개수를 변수 cardNum에 할당
		cardNum = Integer.parseInt(in.readLine());
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 내가 선택한 카드 집합의 곱을 갱신
		for (int card = 0; card < cardNum; card++)
			targetProduct *= Integer.parseInt(st.nextToken());
		
		// 정답이 존재하지 않는 경우 -1을 출력
		if (targetProduct == Math.pow(9, cardNum)) {
			out.write(String.valueOf(minProduct));
		
		// 정답이 존재하는 경우
		} else {
			
			// 선택한 카드를 저장할 배열 cards 초기화
			cards = new int[cardNum];
			
			// minProductFinder() 메서드를 호출해 친구가 선택한 집합 B의 원소를 출력
			minProductFinder(0, 1, out);
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// minProductFinder() 메서드 정의
	public static void minProductFinder(int depth, int product, BufferedWriter out) throws IOException {
		
		// 이미 가장 작은 카드의 곱을 찾은 경우 메서드 종료
		if (minProduct != -1)
			return;
		
		// 모든 카드를 선택한 경우
		if (depth == cardNum) {
			
			// 해당 카드 집합의 곱이 내가 선택한 카드 집합의 곱보다 큰 경우
			if (product > targetProduct) {
				
				// 가장 작은 카드의 곱을 갱신
				minProduct = product;
			
				// for 반복문을 사용해 선택한 카드 집합을 출력
				for (int card : cards)
					out.write(card + " ");
			}
			
			// 메서드 종료
			return;
		}
		
		// for 반복문을 사용해 가능한 숫자를 모두 순회
		for (int number = 1; number < 10; number++) {
			
			// 해당 숫자가 이전에 선택한 숫자보다 작은 경우 다음 숫자를 순회
			if (depth > 0 && cards[depth - 1] > number)
				continue;
			
			// 해당 숫자를 선택 처리
			cards[depth] = number;
			
			// minProductFinder() 메서드 재귀호출
			minProductFinder(depth + 1, product * number, out);
		}
	}
}