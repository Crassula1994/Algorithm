package bronze4.num31821;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 메뉴의 개수를 변수 menuNum에 할당
		int menuNum = Integer.parseInt(in.readLine());
		
		// 결제해야 하는 금액의 총액을 저장할 변수 totalCost 초기화
		int totalCost = 0;
		
		// 각 메뉴의 가격을 저장할 배열 prices 초기화
		int[] prices = new int[menuNum + 1];
		
		// for 반복문을 사용해 입력 받은 각 메뉴의 가격을 배열 prices에 저장
		for (int idx = 1; idx < prices.length; idx++)
			prices[idx] = Integer.parseInt(in.readLine());
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 새내기의 인원 수를 변수 freshmanNum에 할당
		int freshmanNum = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 결제해야 하는 금액의 총액을 갱신
		while (freshmanNum-- > 0)
			totalCost += prices[Integer.parseInt(in.readLine())];
		
		// valueOf() 및 write() 메서드를 사용해 결제해야 하는 금액의 총액을 출력
		out.write(String.valueOf(totalCost));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}