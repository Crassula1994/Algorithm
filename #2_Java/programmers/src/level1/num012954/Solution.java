package level1.num012954;

// Solution 클래스 정의
public class Solution {
	
	// solution() 메서드 정의
	public static long[] solution(int x, int n) {

		// 숫자를 저장할 배열 numbers 초기화
		long[] numbers = new long[n];
		
		// 첫 번째 값을 갱신
		numbers[0] = x;
		
		// for 반복문을 사용해 각 숫자를 차례로 저장
		for (int idx = 1; idx < numbers.length; idx++)
			numbers[idx] = numbers[idx - 1] + x;
		
        // 숫자를 저장한 배열 반환
        return numbers;
    }
}