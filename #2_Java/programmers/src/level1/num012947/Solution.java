package level1.num012947;

// Solution 클래스 정의
public class Solution {
	
	// solution() 메서드 정의
	public static boolean solution(int x) {
		
		// 입력 받은 양의 정수와, 양의 정수의 각 자릿수의 합을 저장할 각 변수 초기화
		int number = x;
		int sum = 0;
		
		// while 반복문을 사용해 숫자가 0이 될 때까지 순회
		while (number > 0) {
			
			// 해당 자릿수를 자릿수의 합에 갱신
			sum += number % 10;
			
			// 숫자를 갱신
			number /= 10;
		}
		
        // 해당 수가 하샤드 수인지를 반환
        return x % sum == 0;
    }
}