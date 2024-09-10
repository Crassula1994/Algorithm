package silver5.num26593;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// Item 클래스 정의
	static class Item implements Comparable<Item> {

		// 상품의 이름, 판매 횟수, 총 이윤을 저장할 각 변수 초기화
		String name;
		int salesCount;
		double totalProfit;
		
		// 매개변수를 입력 받는 생성자 정의
		public Item(String name, int salesCount, double totalProfit) {
			this.name = name;
			this.salesCount = salesCount;
			this.totalProfit = totalProfit;
		}
		
		// compareTo() 메서드 정의
		@Override
		public int compareTo(Item anotherItem) {
			
			// compare() 메서드를 사용해 총 이윤이 같지 않은 경우 총 이윤에 대하여 내림차순을 반환
			if (this.totalProfit != anotherItem.totalProfit)
				return -Double.compare(this.totalProfit, anotherItem.totalProfit);
			
			// 판매 횟수가 같지 않은 경우 판매 횟수에 대하여 내림차순을 반환
			if (this.salesCount != anotherItem.salesCount)
				return anotherItem.salesCount - this.salesCount;
			
			// compareTo() 메서드를 사용해 이름에 대하여 사전 순을 반환
			return this.name.compareTo(anotherItem.name);
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 각 상품의 정보를 입력 받을 변수 line 초기화
		String line;
		
		// 상품의 목록을 저장할 List 객체 items 초기화
		List<Item> items = new ArrayList<>();
		
		// while 반복문을 사용해 각 상품을 순회
		while ((line = in.readLine()) != null) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(line);
			
			/* nextToken(), parseInt(), parseDouble() 메서드를 사용해 입력 받은 상품의 이름, 판매 횟수,
			판매 횟수당 이윤을 각 변수에 할당 */
			String name = st.nextToken();
			int salesCount = Integer.parseInt(st.nextToken());
			double profit = Double.parseDouble(st.nextToken());
			
			// add() 메서드를 사용해 해당 상품의 정보를 items에 저장
			items.add(new Item(name, salesCount, salesCount * profit));
		}
		
		// sort() 메서드를 사용해 상품 목록을 정렬
		Collections.sort(items);
		
		// for 반복문을 사용해 각 상품의 정보를 출력
		for (Item item : items) {
			out.write("$" + String.format("%.2f", item.totalProfit));
			out.write(" - " + item.name + "/" + item.salesCount + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}