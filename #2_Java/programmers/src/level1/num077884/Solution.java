package level1.num077884;

// Solution 클래스 정의
public class Solution {

	// solution() 메서드 정의
	public static int solution(int left, int right) {
		
		// 각 숫자의 약수의 개수를 저장할 배열 counter 초기화
		int[] counter = new int[1001];
		
		// for 반복문을 사용해 1부터 1000까지의 숫자를 순회
		for (int number = 1; number <= 1000; number++) {
			
			// for 반복문을 사용해 각 숫자의 배수를 순회하며 약수의 개수를 갱신
			for (int multiple = number; multiple <= 1000; multiple += number)
				counter[multiple]++;
		}
		
		// 약수의 개수를 더하고 뺀 결과를 저장할 변수 result 초기화
		int result = 0;
		
		// for 반복문을 사용해 주어진 범위의 각 숫자를 순회
		for (int number = left; number <= right; number++) {
			
			// 약수의 개수가 짝수인 경우 더한 것으로 처리
			if (counter[number] % 2 == 0) {
				result += number;
				
			// 약수의 개수가 홀수인 경우 뺀 것으로 처리
			} else {
				result -= number;
			}
		}
		
		// 약수의 개수를 더하고 뺀 결과를 반환
		return result;
    }
}