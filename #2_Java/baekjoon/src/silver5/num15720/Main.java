package silver5.num15720;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 세트 할인이 적용되기 전 가격 및 세트 할인이 적용된 후의 최소 가격을 저장할 각 변수 초기화
	static int totalPrice = 0;
	static int minPrice = 0;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 버거, 사이드 메뉴, 음료의 개수를 각 변수에 할당
		int burgerNum = Integer.parseInt(st.nextToken());
		int sideNum = Integer.parseInt(st.nextToken());
		int drinkNum = Integer.parseInt(st.nextToken());
		
		// min() 메서드를 사용해 만들 수 있는 세트의 개수를 변수 setNum에 할당
		int setNum = Math.min(burgerNum, Math.min(sideNum, drinkNum));
		
		// 각 버거, 사이드 메뉴, 음료의 가격을 저장할 배열 초기화
		Integer[] burgers = new Integer[burgerNum];
		Integer[] sides = new Integer[sideNum];
		Integer[] drinks = new Integer[drinkNum];
		
		/* menuPriceCalculator() 메서드를 호출해 각 메뉴의 가격을 각 배열에 저장하고, 세트 할인이 적용되기 전 가격
		및 세트 할인이 적용된 후의 최소 가격을 갱신 후, 각 메뉴의 가격을 내림차순으로 정렬 */
		menuPriceCalculator(in.readLine(), burgers);
		menuPriceCalculator(in.readLine(), sides);
		menuPriceCalculator(in.readLine(), drinks);
		
		// write() 메서드를 사용해 세트 할인이 적용되기 전 가격 및 세트 할인이 적용된 후의 최소 가격을 출력
		out.write(totalPrice + "\n" + minPrice);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// menuPriceCalculator() 메서드 정의
	public static void menuPriceCalculator(String priceString, Integer[] menuPrices) {
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(priceString);
		
		// for 반복문을 사용해 각 메뉴의 가격을 순회
		for (int idx = 0; idx < menuPrices.length; idx++) {
			
		}
	}
}