package silver3.num02621;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 각 카드의 정보를 저장할 배열 cards 초기화
	static Card[] cards = new Card[5];
	
	// ----------------------------------------------------------------------------------------------------
	
	// Card 클래스 정의
	static class Card implements Comparable<Card> {
		
		// 카드의 색깔과 숫자를 저장할 각 변수 초기화
		char color;
		int number;
		
		// 매개변수를 입력 받는 생성자 정의
		public Card(char color, int number) {
			this.color = color;
			this.number = number;
		}
		
		// compareTo() 메서드 정의 
		@Override
		public int compareTo(Card anotherCard) {
			
			// 카드에 적힌 숫자를 기준으로 오름차순 정렬
			return this.number - anotherCard.number;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// for 반복문을 사용해 각 카드의 정보를 순회
		for (int idx = 0; idx < cards.length; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken(), charAt(), parseInt() 메서드를 사용해 카드의 색깔과 번호를 각 변수에 할당
			char color = st.nextToken().charAt(0);
			int number = Integer.parseInt(st.nextToken());
			
			// 해당 카드의 정보를 배열 cards에 저장
			cards[idx] = new Card(color, number);
		}
		
		// sort() 메서드를 사용해 배열 cards를 정렬
		Arrays.sort(cards);
		
		// pointCalculator(), valueOf(), write() 메서드를 사용해 카드의 점수를 출력
		out.write(String.valueOf(pointCalculator()));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// pointCalculator() 메서드 정의
	public static int pointCalculator() {
		
		// colorChecker() 메서드를 호출해 모든 카드의 색깔이 같은지 여부를 변수 isColorSame에 할당
		boolean isColorSame = colorChecker();
		
		// sequenceChecker() 메서드를 호출해 해당 카드가 연속적인지 여부를 변수 isSequential에 할당
		boolean isSequential = sequenceChecker();
		
		// 카드 5장이 모두 같은 색이면서 숫자가 연속적인 경우 카드의 점수를 반환
		if (isColorSame && isSequential)
			return cards[4].number + 900;
		
		// 카드 5장이 모두 같은 색인 경우 카드의 점수를 반환
		if (isColorSame)
			return cards[4].number + 600;
		
		// 카드 5장의 숫자가 연속적일 경우 카드의 점수를 반환
		if (isSequential)
			return cards[4].number + 500;
		
		// numberCounter() 메서드를 호출해 같은 숫자를 가진 카드의 정보를 List 객체 counts에 저장
		List<int[]> counts = numberCounter();
		
		// 같은 숫자가 1개 존재하는 경우
		if (counts.size() == 1) {
			
			// 4개의 숫자가 같은 경우 카드의 점수를 반환
			if (counts.get(0)[0] == 4)
				return counts.get(0)[1] + 800;
			
			// 3개의 숫자가 같은 경우 카드의 점수를 반환
			if (counts.get(0)[0] == 3)
				return counts.get(0)[1] + 400;
			
			// 2개의 숫자가 같은 경우 카드의 점수를 반환
			return counts.get(0)[1] + 200;
			
		// 같은 숫자가 2개 존재하는 경우
		} else if (counts.size() == 2) {
		
			// sort() 메서드를 사용해 같은 숫자를 가진 카드의 정보를 정렬
			Collections.sort(counts, (c1, c2) -> {
				return (c1[0] == c2[0]) ? c2[1] - c1[1] : c2[0] - c1[0];
			});
			
			// 3개의 숫자가 같고 2개의 숫자가 같은 경우 카드의 점수를 반환
			if (counts.get(0)[0] == 3)
				return counts.get(0)[1] * 10 + counts.get(1)[1] + 700;
			
			// 2개의 숫자가 각각 같은 경우 카드의 점수를 반환
			return counts.get(0)[1] * 10 + counts.get(1)[1] + 300;
		}
		
		// 어떤 경우에도 해당하지 않는 경우 카드의 점수를 반환
		return cards[4].number + 100;
	}
	
	// ----------------------------------------------------------------------------------------------------

	// colorChecker() 메서드 정의
	private static boolean colorChecker() {
		
		// 기준이 될 색깔을 변수 targetColor에 할당
		char targetColor = cards[0].color;
		
		// for 반복문을 사용해 각 카드를 순회
		for (int idx = 1; idx < cards.length; idx++) {
			
			// 카드의 색이 다른 경우 false 반환
			if (cards[idx].color != targetColor)
				return false;
		}
		
		// 카드의 색이 모두 같은 경우 true 반환
		return true;
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// sequenceChecker() 메서드 정의
	public static boolean sequenceChecker() {
		
		// for 반복문을 사용해 각 카드를 순회
		for (int idx = 1; idx < cards.length; idx++) {
			
			// 카드가 연속적이지 않은 경우 false 반환
			if (cards[idx].number != cards[idx - 1].number + 1)
				return false;
		}
		
		// 카드가 연속적인 경우 true 반환
		return true;
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// numberCounter() 메서드 정의
	private static List<int[]> numberCounter() {
		
		// 각 번호를 지닌 카드의 개수를 저장할 배열 numberCounts 초기화
		int[] numberCounts = new int[10];
		
		// 같은 숫자를 가진 카드의 정보를 저장할 List 객체 counts 초기화
		List<int[]> counts = new ArrayList<>();
		
		// for 반복문을 사용해 각 번호를 지닌 카드의 개수를 갱신
		for (int idx = 0; idx < cards.length; idx++)
			numberCounts[cards[idx].number]++;
		
		// for 반복문을 사용해 카드의 번호를 순회
		for (int number = 1; number < 10; number++) {
			
			// 해당 번호의 카드가 2개 이상인 경우 해당 번호와 그 개수를 counts에 저장
			if (numberCounts[number] >= 2)
				counts.add(new int[] {numberCounts[number], number});
		}
		
		// 같은 숫자를 가진 카드의 정보를 저장한 List 객체 반환
		return counts;
	}
}