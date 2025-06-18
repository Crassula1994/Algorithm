package bronze2.num16917;

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
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		/* nextToken() 및 parseInt() 메서드를 사용해 입력 받은 양념 치킨, 후라이드 치킨, 반반 치킨의 가격,
		필요한 양념 치킨과 후라이드 치킨의 개수를 각 변수에 할당 */
		int priceSC = Integer.parseInt(st.nextToken());
		int priceFC = Integer.parseInt(st.nextToken());
		int priceHC = Integer.parseInt(st.nextToken());
		int minCountSC = Integer.parseInt(st.nextToken());
		int minCountFC = Integer.parseInt(st.nextToken());
		
		// min() 메서드를 사용해 필요한 양념 치킨과 후라이드 치킨 세트의 수, 상도가 치킨을 구매하는 금액의 최솟값을 저장할 각 변수 초기화
		int minCount = Math.min(minCountSC, minCountFC);
		int minCost = 0;
		
		// 반반 치킨을 사는 것이 더 유리한 경우 상도가 치킨을 구매하는 금액의 최솟값을 갱신
		if (priceHC * 2 < priceSC + priceFC) {
			minCost = priceHC * 2 * minCount;
			
		// 반반 치킨을 사는 것보다 따로 구매하는 것이 더 유리한 경우 상도가 치킨을 구매하는 금액의 최솟값을 갱신
		} else {
			minCost = priceSC * minCount + priceFC * minCount;
		}
		
		// 양념 치킨을 더 구매해야 하는 경우 
		if (minCount == minCountFC) {
			
			// 더 구매해야 하는 양념 치킨의 양을 변수 remains에 할당
			int remains = minCountSC - minCount;
			
			// min() 메서드를 사용해 상도가 치킨을 구매하는 금액의 최솟값을 갱신
			minCost += Math.min(priceSC * remains, priceHC * 2 * remains);
		
		// 후라이드 치킨을 더 구매해야 하는 경우
		} else {
			
			// 더 구매해야 하는 후라이드 치킨의 양을 변수 remains에 할당
			int remains = minCountFC - minCount;
			
			// min() 메서드를 사용해 상도가 치킨을 구매하는 금액의 최솟값을 갱신
			minCost += Math.min(priceFC * remains, priceHC * 2 * remains);
		}
		
		// valueOf() 및 write() 메서드를 사용해 상도가 치킨을 구매하는 금액의 최솟값을 출력
		out.write(String.valueOf(minCost));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}