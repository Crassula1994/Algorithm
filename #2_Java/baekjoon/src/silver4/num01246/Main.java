package silver4.num01246;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 달걀의 개수 및 고객의 수를 각 변수에 할당
		int eggNum = Integer.parseInt(st.nextToken());
		int customerNum = Integer.parseInt(st.nextToken());
		
		// 경래가 책정한 가격 및 경래가 올릴 수 있는 최대 수익을 저장할 각 변수 초기화
		int minPrice = Integer.MAX_VALUE;
		int maxProfit = 0;
		
		// 각 고객이 달걀을 살 수 있는 가격을 저장할 배열 prices 초기화
		Integer[] prices = new Integer[customerNum];
		
		// for 반복문을 사용해 각 고객이 달걀을 살 수 있는 가격을 배열 prices에 저장
		for (int idx = 0; idx < prices.length; idx++)
			prices[idx] = Integer.parseInt(in.readLine());
		
		// reverseOrder() 및 sort() 메서드를 사용해 고객이 달걀을 살 수 있는 가격을 내림차순으로 정렬
		Arrays.sort(prices, Collections.reverseOrder());
		
		// for 반복문을 사용해 판매 가능한 각 수량을 순회
		for (int idx = 0; idx < Math.min(eggNum, customerNum); idx++) {
			
			// 현재 고객까지 달걀을 판매했을 때 얻을 수 있는 수익을 변수 profit에 할당
			int profit = (idx + 1) * prices[idx];
			
			// 해당 수익이 현재까지 경래가 올릴 수 있는 최대 수익인 경우 경래가 책정한 가격 및 경래가 올릴 수 있는 최대 수익 갱신
			if (profit >= maxProfit) {
				minPrice = prices[idx];
				maxProfit = profit;
			}
		}
		
		// write() 메서드를 사용해 경래가 책정한 가격 및 경래가 올릴 수 있는 최대 수익을 출력
		out.write(minPrice + " " + maxProfit);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}