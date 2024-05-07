package bronze1.num31800;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 물건의 개수를 변수 goodsNum에 할당
		int goodsNum = Integer.parseInt(in.readLine());
		
		// 첫 번째로 큰 이익, 두 번째로 큰 이익을 저장할 각 변수 초기화
		int firstMax = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;
		
		// 각 물건의 이익과 가격을 저장할 각 배열 초기화
		int[] profits = new int[goodsNum];
		int[] prices = new int[goodsNum];
		
		// StringTokenizer 객체를 불러와 각 변수에 할당
		StringTokenizer profitStr = new StringTokenizer(in.readLine());
		StringTokenizer priceStr = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 물건을 순회
		for (int idx = 0; idx < goodsNum; idx++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 각 물건의 이익과 가격을 각 배열에 저장
			profits[idx] = Integer.parseInt(profitStr.nextToken());
			prices[idx] = Integer.parseInt(priceStr.nextToken());
			
			// 해당 이익이 저장된 첫 번째로 큰 이익보다 크거나 같은 경우 첫 번째로 큰 이익, 두 번째로 큰 이익을 갱신
			if (profits[idx] >= firstMax) {
				secondMax = firstMax;
				firstMax = profits[idx];
				
			// 해당 이익이 저장된 첫 번째 이익보다 작고 두 번째 이익보다 큰 경우 두 번째로 큰 이익을 갱신
			} else if (profits[idx] > secondMax) {
				secondMax = profits[idx];
			}
		}
		
		// for 반복문을 사용해 각 물건을 순회
		for (int idx = 0; idx < goodsNum; idx++) {
			
			// 해당 물건의 기회비용과 순수익을 계산해 각 변수에 할당
			int cost = (profits[idx] == firstMax) ? secondMax - prices[idx] : firstMax - prices[idx];
			int gain = profits[idx] - cost - prices[idx];
			
			// write() 메서드를 사용해 해당 물건의 순수익을 출력
			out.write(gain + " ");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}