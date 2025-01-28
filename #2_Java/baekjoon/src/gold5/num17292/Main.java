package gold5.num17292;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// Pair 클래스 정의
	static class Pair implements Comparable<Pair> {
		
		// 해당 카드쌍, 카드쌍에 속한 카드의 번호와 색을 저장할 각 변수 초기화
		String name;
		int maxNumber;
		int minNumber;
		char maxColor;
		char minColor;
		
		// 매개변수를 입력 받는 생성자 정의
		public Pair(String name) {
			
			// 해당 카드쌍의 이름을 갱신
			this.name = name;
			
			// charAt(), valueOf(), parseInt() 메서드를 사용해 카드쌍에 속한 카드의 번호와 색을 각 변수에 할당
			int number1 = Integer.parseInt(String.valueOf(name.charAt(0)), 16);
			int number2 = Integer.parseInt(String.valueOf(name.charAt(2)), 16);
			char color1 = name.charAt(1);
			char color2 = name.charAt(3);
			
			// 카드쌍에 속한 카드의 번호와 색을 갱신
			maxNumber = (number1 >= number2) ? number1 : number2;
			minNumber = (number1 >= number2) ? number2 : number1;
			maxColor = (number1 >= number2) ? color1 : color2;
			minColor = (number1 >= number2) ? color2 : color1;
		}

		// compareTo() 메서드 정의
		@Override
		public int compareTo(Pair anotherPair) {
			
			// 한쪽만 색이 같은 경우가 존재하는 경우 이를 우선으로 정렬
			if (maxColor == minColor && anotherPair.maxColor != anotherPair.minColor) {
				return -1;
			} else if (maxColor != minColor && anotherPair.maxColor == anotherPair.minColor) {
				return 1;
			}
			
			// 큰 수가 다른 경우 큰 쪽을 우선으로 정렬
			if (this.maxNumber != anotherPair.maxNumber)
				return anotherPair.maxNumber - this.maxNumber;
			
			// 작은 수가 다른 경우 작은 쪽을 우선으로 정렬
			if (this.minNumber != anotherPair.minNumber)
				return anotherPair.minNumber - this.minNumber;
			
			// compare() 메서드를 사용해 큰 수가 검은색인 경우를 우선으로 정렬
			return Character.compare(this.maxColor, anotherPair.maxColor);
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 입력 받은 카드를 저장할 배열 cards 초기화
		String[] cards = new String[6];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine(), ",");
		
		// 각 카드 서열별로 저장할 각 List 객체 초기화
		List<Pair> sequentialPairs = new ArrayList<>();
		List<Pair> samePairs = new ArrayList<>();
		List<Pair> otherPairs = new ArrayList<>();
		
		// for 반복문을 사용해 입력 받은 카드를 배열 cards에 저장
		for (int idx = 0; idx < cards.length; idx++)
			cards[idx] = st.nextToken();
		
		// for 반복문을 사용해 각 카드쌍을 순회
		for (int card1 = 0; card1 < cards.length - 1; card1++) {
			for (int card2 = card1 + 1; card2 < cards.length; card2++) {
				
				// 해당 카드쌍을 변수 pair에 할당
				Pair pair = new Pair(cards[card1] + cards[card2]);
				
				// 해당 카드쌍의 숫자가 연속적인 경우 sequentialPairs에 해당 카드쌍을 추가
				if (pair.maxNumber - pair.minNumber == 1 || pair.maxNumber - pair.minNumber == 14) {
					sequentialPairs.add(pair);
					
				// 해당 카드쌍의 숫자가 같을 경우 samePairs에 해당 카드쌍을 추가
				} else if (pair.maxNumber == pair.minNumber) {
					samePairs.add(pair);
					
				// 해당 카드쌍의 숫자가 연속적이거나 같지 않을 경우 otherPairs에 해당 카드쌍을 추가
				} else  {
					otherPairs.add(pair);
				}
			}
		}
		
		// sort() 메서드를 사용해 각 카드 서열별로 저장한 List 객체를 정렬
		Collections.sort(sequentialPairs);
		Collections.sort(samePairs);
		Collections.sort(otherPairs);
		
		// for 반복문을 사용해 해당 카드쌍의 숫자가 연속적인 경우의 카드쌍을 출력
		for (Pair pair : sequentialPairs)
			out.write(pair.name + "\n");
		
		// for 반복문을 사용해 해당 카드쌍의 숫자가 같을 경우의 카드쌍을 출력
		for (Pair pair : samePairs)
			out.write(pair.name + "\n");
		
		// for 반복문을 사용해 해당 카드쌍의 숫자가 연속적이거나 같지 않을 경우의 카드쌍을 출력
		for (Pair pair : otherPairs)
			out.write(pair.name + "\n");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}