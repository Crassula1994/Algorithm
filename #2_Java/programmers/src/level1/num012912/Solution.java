package level1.num012912;

// Solution 클래스 정의
public class Solution {
	
	// solution() 메서드 정의
	public static long solution(int a, int b) {
		
		// 두 정수 사이의 모든 정수의 합을 저장할 변수 sum 초기화
		long sum = 0;
		
		// for 반복문을 사용해 두 정수 사이의 모든 정수의 합을 갱신
		for (int number = Math.min(a, b); number <= Math.max(a, b); number++)
			sum += number;
		
		// // 두 정수 사이의 모든 정수의 합을 반환
		return sum;
    }
}