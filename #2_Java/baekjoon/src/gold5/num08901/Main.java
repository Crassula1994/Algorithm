package gold5.num08901;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// 최대 이익을 저장할 변수 maxProfit 초기화
			int maxProfit = 0;
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 상근이가 가지고 있는 A, B, C의 양을 각 변수에 할당
			int countA = Integer.parseInt(st.nextToken());
			int countB = Integer.parseInt(st.nextToken());
			int countC = Integer.parseInt(st.nextToken());
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 AB, BC, CA의 가격을 각 변수에 할당
			int priceAB = Integer.parseInt(st.nextToken());
			int priceBC = Integer.parseInt(st.nextToken());
			int priceCA = Integer.parseInt(st.nextToken());
			
			// for 반복문을 사용해 만들 수 있는 화학 제품 AB의 개수를 순회
			for (int countAB = 0; countAB <= Math.min(countA, countB); countAB++) {
				
				// 현재 화학 제품 AB 생산량에서의 이익을 저장할 변수 profit 초기화
				int profit = priceAB * countAB;
				
				// BC의 가격이 CA의 가격 이상인 경우 현재 화학 제품 AB 생산량에서의 이익을 갱신
				if (priceBC >= priceCA) {
					int countBC = Math.min(countB - countAB, countC);
					int countCA = Math.min(countC - countBC, countA - countAB);
					profit += priceBC * countBC + priceCA * countCA;
					
				// BC의 가격이 CA의 가격 미만인 경우 현재 화학 제품 AB 생산량에서의 이익을 갱신
				} else {
					int countCA = Math.min(countC, countA - countAB);
					int countBC = Math.min(countB - countAB, countC - countCA);
					profit += priceBC * countBC + priceCA * countCA;
				}
				
				// max() 메서드를 사용해 최대 이익을 갱신
				maxProfit = Math.max(profit, maxProfit);
			}
			
			// write() 메서드를 사용해 최대 이익을 출력
			out.write(maxProfit + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}