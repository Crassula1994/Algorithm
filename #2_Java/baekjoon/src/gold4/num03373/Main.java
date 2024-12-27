package gold4.num03373;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 카드의 수를 변수 cardNum에 할당
		int cardNum = Integer.parseInt(in.readLine());
		
		// 카드 배열을 통해 얻을 수 있는 최솟값을 저장할 변수 minValue 초기화
		int minValue = 0;
		
		// 각 카드에 적힌 수를 저장할 2차원 배열 cards 초기화
		int[][] cards = new int[cardNum][2];
		
		// for 반복문을 사용해 각 카드를 순회
		for (int idx = 0; idx < cardNum; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 카드의 양면에 적힌 각 숫자를 각 변수에 할당
			int numberFront = Integer.parseInt(st.nextToken());
			int numberBack = Integer.parseInt(st.nextToken());
			
			// min() 및 max() 메서드를 사용해 카드의 양면에 적힌 각 숫자를 정렬하여 2차원 배열 cards에 저장
			cards[idx][0] = Math.min(numberFront, numberBack);
			cards[idx][1] = Math.max(numberFront, numberBack);
		}
		
		// sort() 메서드를 사용해 양면에 적힌 숫자의 합이 작은 순서대로 오름차순 정렬
		Arrays.sort(cards, (c1, c2) -> {
			return (c1[0] + c1[1]) - (c2[0] + c2[1]);
		});
		
		// for 반복문을 사용해 음수에 더 가까운 절반의 값을 + 위치에 배치해 카드 배열을 통해 얻을 수 있는 최솟값을 갱신
		for (int idx = 0; idx < cardNum / 2; idx++)
			minValue += cards[idx][0];
		
		// for 반복문을 사용해 양수에 더 가까운 절반의 값을 - 위치에 배치해 카드 배열을 통해 얻을 수 있는 최솟값을 갱신
		for (int idx = cardNum / 2; idx < cardNum; idx++)
			minValue -= cards[idx][1];
		
		// valueOf() 및 write() 메서드를 사용해 카드 배열을 통해 얻을 수 있는 최솟값을 출력
		out.write(String.valueOf(minValue));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}