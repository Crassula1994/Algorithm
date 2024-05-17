package level1.num086051;

// Solution 클래스 정의
public class Solution {

	// solution() 메서드 정의
	public static int solution(int[] numbers) {
		
		// 찾을 수 없는 숫자를 더한 수를 저장할 변수 sum 초기화
		int sum = 45;
		
		// for 반복문을 사용해 찾을 수 없는 숫자를 더한 수를 갱신
		for (int idx = 0; idx < numbers.length; idx++)
			sum -= numbers[idx];
		
		// 찾을 수 없는 숫자를 더한 수를 반환
		return sum;
	}
}