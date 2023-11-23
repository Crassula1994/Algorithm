package silver1.num16194;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 구매하려는 카드의 개수를 변수 cardNum에 할당
		int cardNum = Integer.parseInt(in.readLine());
		
		// 각 카드팩의 가격, 각 카드의 개수마다 지불해야 하는 금액의 최솟값을 저장할 각 배열 초기화
		int[] prices = new int[cardNum + 1];
		int[] minPrices = new int[cardNum + 1];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 각 카드팩의 가격을 순회
		for (int idx = 1; idx <= cardNum; idx++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 카드팩의 가격을 변수 price에 할당
			int price = Integer.parseInt(st.nextToken());
			
			// 카드팩의 가격을 배열 prices와 minPrices에 저장
			prices[idx] = price;
			minPrices[idx] = price;
		}
		
		// for 반복문을 사용해 각 카드의 개수마다 지불해야 하는 금액의 최솟값을 갱신
		for (int i = 1; i <= cardNum; i++) {
			for (int j = 1; j <= i; j++)
				minPrices[i] = Math.min(minPrices[i], minPrices[i - j] + prices[j]);
		}
		
		// valueOf() 및 write() 메서드를 사용해 지불해야 하는 금액의 최솟값을 출력
		out.write(String.valueOf(minPrices[cardNum]));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}