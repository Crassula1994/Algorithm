package level1.num012934;

// Solution 클래스 정의
public class Solution {

	// solution() 메서드 정의
	public static long solution(long n) {
		
		// for 반복문을 사용해 각 정수를 순회
		for (long number = 1; number * number <= n; number++) {
			
			// 주어진 정수가 해당 정수의 제곱인 경우 해당 정수에 1을 더한 값의 제곱을 반환
			if (n == number * number)
				return (number + 1) * (number + 1);
		}
		
		// 주어진 정수가 어떤 정수의 제곱도 아닌 경우 -1 반환
		return -1;
    }
}