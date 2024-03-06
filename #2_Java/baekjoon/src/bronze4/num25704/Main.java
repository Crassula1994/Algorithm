package bronze4.num25704;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 경태가 모은 출석 도장의 개수 및 구매할 물건의 가격을 각 변수에 할당
		int stampNum = Integer.parseInt(in.readLine());
		int price = Integer.parseInt(in.readLine());
		
		// 할인된 가격을 저장할 변수 discount 초기화
		int discount = 0;
		
		// 출석 도장을 5개 미만으로 모은 경우 구매할 가격을 변수 discount에 할당
		if (stampNum < 5) {
			discount = price;;
		
		// 출석 도장을 5개 이상 10개 미만으로 모은 경우 할인한 가격을 변수 discount에 할당
		} else if (stampNum < 10) {
			discount = Math.max(0, price - 500);
			
		// 출석 도장을 10개 이상 15개 미만으로 모은 경우 할인한 가격을 변수 discount에 할당
		} else if (stampNum < 15) {
			discount = Math.max(0, Math.min(price - 500, price / 10 * 9));

		// 출석 도장을 15개 이상 20개 미만으로 모은 경우 할인한 가격을 변수 discount에 할당
		} else if (stampNum < 20) {
			discount = Math.max(0, Math.min(price - 2000, price / 10 * 9));
			
		// 출석 도장을 20개 이상으로 모은 경우 할인한 가격을 변수 discount에 할당
		} else {
			discount = Math.max(0, Math.min(price - 2000, price / 4 * 3));
		}
		
		// valueOf() 및 write() 메서드를 사용해 할인된 가격을 출력
		out.write(String.valueOf(discount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}