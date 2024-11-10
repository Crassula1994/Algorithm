package silver5.num20546;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 준현이와 성민이에게 주어진 현금을 변수 initialMoney에 할당
		int initialMoney = Integer.parseInt(in.readLine());
		
		// 준현이와 성민가 가진 돈과 주식의 수를 저장할 각 변수 초기화
		int moneyJH = initialMoney;
		int stockJH = 0;
		int moneySM = initialMoney;
		int stockSM = 0;
		
		// 입력 받은 각 날짜의 주가를 저장할 배열 stockPrices 초기화
		int[] stockPrices = new int[14];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 각 날짜의 주가를 배열 stockPrices에 추가
		for (int idx = 0; idx < stockPrices.length; idx++)
			stockPrices[idx] = Integer.parseInt(st.nextToken());
		
		// for 반복문을 사용해 각 날짜의 주가를 순회
		for (int idx = 0; idx < stockPrices.length; idx++) {
			
			// 준현이가 가진 돈과 주식의 수를 갱신
			stockJH += moneyJH / stockPrices[idx];
			moneyJH %= stockPrices[idx];
			
			// 4일 차 미만인 경우 다음 날짜를 순회
			if (idx < 3)
				continue;
			
			// 3일 연속 주가가 상승한 경우 성민이가 가진 돈과 주식의 수를 갱신
			if (stockPrices[idx - 3] < stockPrices[idx - 2] && stockPrices[idx - 2] < stockPrices[idx - 1]
					&& stockPrices[idx - 1] < stockPrices[idx]) {
				moneySM += stockPrices[idx] * stockSM;
				stockSM = 0;
				
			// 3일 연속 주가가 하락한 경우 성민이가 가진 돈과 주식의 수를 갱신
			} else if (stockPrices[idx - 3] > stockPrices[idx - 2] && stockPrices[idx - 2] > stockPrices[idx - 1]
					&& stockPrices[idx - 1] > stockPrices[idx]) {
				stockSM += moneySM / stockPrices[idx];
				moneySM %= stockPrices[idx];
			}
		}
		
		// 준현이와 성민이의 자산을 계산해 각 변수에 할당
		int assetJH = moneyJH + stockPrices[13] * stockJH;
		int assetSM = moneySM + stockPrices[13] * stockSM;
				
		// 준현이의 자산이 더 큰 경우 'BNP' 출력
		if (assetJH > assetSM) {
			out.write("BNP");
			
		// 성민이의 자산이 더 큰 경우 'TIMING' 출력
		} else if (assetJH < assetSM) {
			out.write("TIMING");
			
		// 둘의 자산이 같은 경우 'SAMESAME' 출력
		} else {
			out.write("SAMESAME");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}