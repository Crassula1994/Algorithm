package silver2.num11501;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 날의 수를 변수 period에 할당
			int period = Integer.parseInt(in.readLine());
			
			// 각 날의 주가를 저장할 배열 stockPrice 초기화
			int[] stockPrice = new int[period];
			
			// 주식의 최고 가격 및 최대 이익을 저장할 각 변수 초기화
			int maxPrice = 0;
			long maxProfit = 0;
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 입력 받은 각 날의 주가를 배열 stockPrice에 저장
			for (int idx = 0; idx < stockPrice.length; idx++)
				stockPrice[idx] = Integer.parseInt(st.nextToken());
			
			// for 반복문을 사용해 입력 받은 각 날의 주가를 거꾸로 순회
			for (int idx = period - 1; idx >= 0; idx--) {
				
				// 해당 날의 주가가 저장된 주식의 최고 가격보다 높은 경우 주식의 최고 가격 갱신
				if (stockPrice[idx] > maxPrice) {
					maxPrice = stockPrice[idx];
				
				// 해당 날의 주가가 저장된 주식의 최고 가격보다 높지 않은 경우 최대 이익 갱신
				} else {
					maxProfit += maxPrice - stockPrice[idx];
				}
			}
			
			// write() 메서드를 사용해 최대 이익을 출력
			out.write(maxProfit + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}