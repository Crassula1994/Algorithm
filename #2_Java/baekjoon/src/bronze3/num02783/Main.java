package bronze3.num02783;

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
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseDouble() 메서드를 사용해 입력 받은 세븐25의 삼각 김밥 가격 정보를 각 변수에 할당
		double basePrice = Double.parseDouble(st.nextToken());
		double baseQuantity = Double.parseDouble(st.nextToken());
		
		// 삼각 김밥 1000그램 가격의 최저가를 저장할 변수 minPrice 초기화
		double minPrice = basePrice / baseQuantity * 1000;
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 편의점의 개수를 변수 storeNum에 할당
		int storeNum = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 ㅊ의 삼각 김밥 가격 정보를 순회
		while (storeNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseDouble() 메서드를 사용해 입력 받은 해당 편의점의 삼각 김밥 가격 정보를 각 변수에 할당
			double price = Double.parseDouble(st.nextToken());
			double quantity = Double.parseDouble(st.nextToken());
			
			// min() 메서드를 사용해 삼각 김밥 1000그램 가격의 최저가를 갱신
			minPrice = Math.min(price / quantity * 1000, minPrice);
		}
		
		// format() 및 write() 메서드를 사용해 삼각 김밥 1000그램 가격의 최저가를 출력
		out.write(String.format("%.2f", minPrice));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}