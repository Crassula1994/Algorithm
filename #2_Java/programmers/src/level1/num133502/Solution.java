package level1.num133502;

// 필요한 패키지 불러오기
import java.util.Stack;

// Solution 클래스 정의
public class Solution {
	
	// solution() 메서드 정의
	public static int solution(int[] ingredients) {
		
		// 상수가 포장하는 햄버거의 개수를 저장할 변수 burgerNum 초기화
		int burgerNum = 0;
		
		// 햄버거가 완성되었는지 판별할 Stack 객체 burgerWrapper 초기화
		Stack<Integer> burgerWrapper = new Stack<>();
		
		// for 반복문을 사용해 각 재료를 순회
		for (int idx = 0; idx < ingredients.length; idx++) {
			
			// 해당 재료를 변수 ingredient에 할당
			int ingredient = ingredients[idx];
			
			// 앞선 재료가 3개 이상이고 현재 재료가 빵이고 이전 재료가 고기인 경우
			if (burgerWrapper.size() >= 3 && ingredient == 1 && burgerWrapper.peek() == 3) {
				
				// pop() 메서드를 사용해 앞선 재료를 각 변수에 할당
				int patty = burgerWrapper.pop();
				int veggie = burgerWrapper.pop();
				int bun = burgerWrapper.pop();
				
				// 앞의 재료가 야채와 빵인 경우 상수가 포장하는 햄버거의 개수를 갱신 후 다음 재료를 순회
				if (veggie == 2 && bun == 1) {
					burgerNum++;
					continue;
				}
				
				// push() 메서드를 사용해 앞선 재료를 burgerWrapper에 원상 복귀
				burgerWrapper.push(bun);
				burgerWrapper.push(veggie);
				burgerWrapper.push(patty);
			}
			
			// push() 메서드를 사용해 해당 재료를 burgerWrapper에 추가
			burgerWrapper.push(ingredient);
		}
		
		// 상수가 포장하는 햄버거의 개수를 반환
        return burgerNum;
    }
}