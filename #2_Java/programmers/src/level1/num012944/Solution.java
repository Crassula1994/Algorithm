package level1.num012944;

// Solution 클래스 정의
public class Solution {
	
	// solution() 메서드 정의
	public static double solution(int[] arr) {

		// 배열의 평균값을 저장할 변수 average 초기화
		double average = 0;
        
		// for 반복문을 사용해 배열의 원소의 총합을 average에 저장
        for (int idx = 0; idx < arr.length; idx++)
            average += arr[idx];
        
        // 총합을 원소의 개수로 나눈 평균값을 계산해 변수 average에 저장
        average /= arr.length;
        
        // 배열의 평균값을 반환
        return average;
    }
}