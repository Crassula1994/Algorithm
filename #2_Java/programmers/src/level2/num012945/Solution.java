package level2.num012945;

// Solution 클래스 정의
public class Solution {
	
	// solution() 메서드 정의
	public static int solution(int n) {

		// 각 피보나치 수를 저장할 배열 fibonacci 초기화
		int[] fibonacci = new int[n + 1];
		
		// 첫 번째 피보나치 수를 초기화
        fibonacci[1] = 1;
        
        // for 반복문을 사용해 각 피보나치 수를 계산해 배열 fibonacci에 저장
        for (int idx = 2; idx < fibonacci.length; idx++)
            fibonacci[idx] = (fibonacci[idx - 1] + fibonacci[idx - 2]) % 1234567;

        // n번째 피보나치 수를 반환
        return fibonacci[n];
    }
}