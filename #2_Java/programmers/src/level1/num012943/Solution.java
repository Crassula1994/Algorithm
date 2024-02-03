package level1.num012943;

// Solution 클래스 정의
public class Solution {
	
	// solution() 메서드 정의
	public static int solution(int num) {
		
		// 현재의 숫자, 작업의 횟수를 저장할 각 변수 초기화
		long number = num;
		int count = 0;
		
		// while 반복문을 사용해 작업을 500번 반복할 때까지 순회
		while (count <= 500) {
			
			// 해당 숫자가 1인 경우 반복문 탈출
			if (number == 1)
				break;
			
			// 해당 숫자가 짝수인 경우 2로 나누어 갱신
			if (number % 2 == 0) {
				number /= 2;
			
			// 해당 숫자가 홀수인 경우 3을 곱하고 1을 더하여 갱신
			} else {
				number = number * 3 + 1;
			}
			
			// 작업의 횟수를 갱신
			count++;
		}
		
		// 주어진 수를 1로 만들기 위해 반복해야 하는 작업의 수를 저장할 변수 result 초기화
		int result = (number == 1) ? count : -1;
		
		// 주어진 수를 1로 만들기 위해 반복해야 하는 작업의 수를 반환
		return result;
    }
}