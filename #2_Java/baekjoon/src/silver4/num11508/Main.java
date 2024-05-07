package silver4.num11508;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 유제품의 수를 변수 productNum에 할당
		int productNum = Integer.parseInt(in.readLine());
		
		// 유제품을 모두 살 때 필요한 최소 비용을 저장할 변수 minCost 초기화
		int minCost = 0;
		
		// 각 유제품의 가격을 저장할 배열 prices 초기화
		Integer[] prices = new Integer[productNum];
		
		// for 반복문을 사용해 입력 받은 각 유제품의 가격을 배열 prices에 저장
		for (int idx = 0; idx < productNum; idx++)
			prices[idx] = Integer.parseInt(in.readLine());
		
		// sort() 메서드를 사용해 유제품의 가격을 내림차순으로 정렬
		Arrays.sort(prices, Collections.reverseOrder());
		
		// for 반복문을 사용해 각 유제품의 가격을 순회
		for (int idx = 0; idx < prices.length; idx++) {
			
			// '2+1 세일'에 해당하는 유제품인 경우 다음 유제품을 순회
			if (idx % 3 == 2)
				continue;
			
			// 유제품을 모두 살 때 필요한 최소 비용을 갱신
			minCost += prices[idx];
		}
		
		// valueOf() 및 write() 메서드를 사용해 유제품을 모두 살 때 필요한 최소 비용을 출력
		out.write(String.valueOf(minCost));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}