package silver5.num25644;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 날짜의 수를 변수 dayNum에 할당
		int dayNum = Integer.parseInt(in.readLine());
		
		// ANA 주식 한 주를 사고 팔아서 얻을 수 있는 최대 이득을 저장할 변수 maxProfit 초기화
		int maxProfit = 0;
		
		// 각 날짜의 ANA 회사의 주가를 저장할 배열 stockPrices 초기화
		int[] stockPrices = new int[dayNum];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 각 날짜의 ANA 회사의 주가를 배열 stockPrices에 저장
		for (int idx = 0; idx < stockPrices.length; idx++)
			stockPrices[idx] = Integer.parseInt(st.nextToken());
		
		// for 반복문을 사용해 각 날짜를 거꾸로 순회
		for (int idx = dayNum - 1, maxPrice = 0; idx >= 0; idx--) {
			
			// max() 메서드를 사용해 현재 날짜까지 최대 주가 및 얻을 수 있는 최대 이득을 갱신
			maxPrice = Math.max(stockPrices[idx], maxPrice);
			maxProfit = Math.max(maxPrice - stockPrices[idx], maxProfit);
		}
		
		// valueOf() 및 write() 메서드를 사용해 ANA 주식 한 주를 사고 팔아서 얻을 수 있는 최대 이득을 출력
		out.write(String.valueOf(maxProfit));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}