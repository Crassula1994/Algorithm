package level1.num012906;

// 필요한 패키지 불러오기
import java.util.Stack;

// Solution 클래스 정의
public class Solution {
	
	// solution() 메서드 정의
	public static int[] solution(int[] arr) {
		
		// 중복된 원소를 확인할 Stack 객체 stack 초기화
		Stack<Integer> stack = new Stack<>();
		
		// for 반복문을 사용해 주어진 배열의 각 원소를 순회
		for (int idx = 0; idx < arr.length; idx++) {
			
			// 해당 원소를 변수 element에 할당
			int element = arr[idx];
			
			// stack이 비었거나 저장된 원소의 값과 다른 경우 해당 원소를 stack에 추가
			if (stack.isEmpty() || stack.peek() != element)
				stack.push(element);
		}
		
		// size() 메서드를 사용해 제거된 남은 수를 저장할 배열 result 초기화
		int[] result = new int[stack.size()];
		
		// for 반복문을 사용해 배열 result에 각 원소를 저장
		for (int idx = result.length - 1; idx >= 0; idx--)
			result[idx] = stack.pop();
		
		// 제거된 남은 수를 저장한 배열을 반환
		return result;
    }
}