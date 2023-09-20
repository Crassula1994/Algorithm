package level2.num42584;

// 필요한 패키지 불러오기
import java.util.Stack;

// Solution 클래스 정의
public class Solution {
	
	// solution() 메서드 정의
	public static int[] solution(int[] prices) {

		// 가격이 떨어지지 않은 기간을 저장할 배열 periods 초기화
		int[] periods = new int[prices.length];
        
		// 주식 가격이 하락했는지 여부에 따라 기간을 계산할 Stack 객체 calculator 초기화 
        Stack<int[]> calculator = new Stack<>();
        
        // for 반복문을 사용해 각 초의 주식 가격을 순회
        for (int idx = 0; idx < prices.length; idx++) {
        	
        	// 현재 주식 가격을 변수 curPrice에 할당
        	int curPrice = prices[idx];
            
        	// calculator에 저장된 가장 최근의 주식의 가격보다 현재 주식 가격이 하락한 경우
            if (!calculator.isEmpty() && calculator.peek()[1] > curPrice) {
            	
            	// while 반복문을 사용해 주식 가격이 하락하지 않을 때까지 순회
                while (!calculator.isEmpty() && calculator.peek()[1] > curPrice) {
                	
                	// poll() 메서드를 사용해 이전의 주식 가격을 배열 prevPrice에 할당
                    int[] prevPrice = calculator.pop();
                    
                    // 주식 가격이 떨어지지 않은 기간을 계산해 갱신
                    periods[prevPrice[0]] = idx - prevPrice[0];
                }                
            }
            
            // push() 메서드를 사용해 현재 주식의 가격을 calculator에 추가
            calculator.push(new int[] {idx, curPrice});
        }
        
        // while 반복문을 사용해 calculator가 빌 때까지 순회
        while (!calculator.isEmpty()) {
        	
        	// poll() 메서드를 사용해 한 번도 떨어지지 않은 주식 가격을 배열 price에 할당
            int[] price = calculator.pop();
            
            // 주식 가격이 떨어지지 않은 기간을 계산해 갱신
            periods[price[0]] = prices.length - price[0] - 1;
        }
        
        // 가격이 떨어지지 않은 기간을 저장한 배열 반환
        return periods;
	}
}