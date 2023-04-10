package unrated.num01952;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// Solution 클래스 정의
public class Solution {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());

		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 1; tc <= testCase; tc++) {

			// 이용권의 가격 및 이용 계획을 저장할 각 배열 초기화
			int[] price = new int[4];
			int[] plan = new int[13];
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());

			// for 반복문을 사용해 입력 받은 이용권의 가격을 배열 price에 저장
			for (int idx = 0; idx < price.length; idx++)
				price[idx] = Integer.parseInt(st.nextToken());

			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 입력 받은 이용 계획을 배열 plan에 저장
			for (int idx = 1; idx <= 12; idx++)
				plan[idx] = Integer.parseInt(st.nextToken());
			
			// 해당 월까지의 최소 요금을 저장할 배열 minCost 초기화
			int[] minCost = new int[13];
			
			// fill() 메서드를 사용해 해당 월의 최소 요금을 갱신
			Arrays.fill(minCost, Integer.MAX_VALUE);
			minCost[0] = 0;
			
			// for 반복문을 사용해 각 달의 최소 요금을 순회
			for (int idx = 1; idx <= 12; idx++) {
				
				// min() 메서드를 사용해 1일 이용권을 이용했을 때의 가격과 비교해 최소 요금 갱신
				minCost[idx] = Math.min(plan[idx] * price[0] + minCost[idx - 1], minCost[idx]);
				
				// min() 메서드를 사용해 1달 이용권을 이용했을 때의 가격과 비교해 최소 요금 갱신
				minCost[idx] = Math.min(price[1] + minCost[idx - 1], minCost[idx]);
				
				// 3개월 이상인 경우 3달 이용권을 이용했을 때의 가격과 비교해 최소 요금 갱신
				if (idx >= 3)
					minCost[idx] = Math.min(price[2] + minCost[idx - 3], minCost[idx]);
				
				// 1년인 경우 1년 이용권을 이용했을 때의 가격과 비교해 최소 요금 갱신
				if (idx == 12)
					minCost[idx] = Math.min(price[3], minCost[idx]);
			}
			
			// write() 메서드를 사용해 12개월간의 최소 요금을 출력
			out.write("#" + tc + " " + minCost[12] + "\n");
		}	

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}