package level1.num134240;

// Solution 클래스 정의
public class Solution {

	// solution() 메서드 정의
	public static String solution(int[] food) {
		
		// 음식의 배치를 차례로 저장할 StringBuilder 객체 sb 초기화
		StringBuilder sb = new StringBuilder();
		
		// for 반복문을 사용해 수용이가 준비한 각 음식을 순회
		for (int idx = 1; idx < food.length; idx++) {
			
			// for 반복문을 사용해 음식을 물을 기준으로 둘로 나눈 배치를 sb에 추가
			for (int count = 0; count < food[idx] / 2; count++)
				sb.append(idx);
		}
		
		// toString() 및 reverse() 메서드를 사용해 대회를 위한 음식 배치를 변수 foodPlan에 할당
		String foodPlan = sb.toString() + "0" + sb.reverse().toString();
		
		// 대회를 위한 음식 배치를 반환
		return foodPlan;
    }
}