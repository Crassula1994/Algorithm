package level1.num076501;

// Solution 클래스 정의
public class Solution {
	
	// solution() 메서드 정의
	public static int solution(int[] absolutes, boolean[] signs) {
		
		// 정수들의 합을 저장할 변수 sum 초기화
		int sum = 0;
		
		// for 반복문을 사용해 각 정수를 순회
		for (int idx = 0; idx < absolutes.length; idx++) {
			
			// 해당 정수가 양수인 경우 정수들의 합 갱신
			if (signs[idx]) {
				sum += absolutes[idx];
			
			// 해당 정수가 음수인 경우 정수들의 합 갱신
			} else {
				sum -= absolutes[idx];
			}
		}
		
		// 정수들의 합을 반환
		return sum;
    }
}