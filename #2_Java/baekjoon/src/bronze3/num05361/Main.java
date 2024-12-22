package bronze3.num05361;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 각 부품의 가격을 저장할 배열 prices 초기화
	static double[] prices = {350.34, 230.90, 190.55, 125.30, 180.90};
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// 필요한 부품을 구매하는데 필요한 비용을 저장할 변수 totalCost 초기화
			double totalCost = 0;
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 필요한 부품을 구매하는데 필요한 비용을 갱신
			for (int idx = 0; idx < prices.length; idx++)
				totalCost += Integer.parseInt(st.nextToken()) * prices[idx];
			
			// format() 및 write() 메서드를 사용해 필요한 부품을 구매하는데 필요한 비용을 출력
			out.write(String.format("$%.2f", totalCost));
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}