package level1.num012931;

// Solution 클래스 정의
public class Solution {
	
	// solution() 메서드 정의
	public static int solution(int n) {
		
		// 자연수의 각 자릿수의 합을 저장할 변수 sum 초기화
		int sum = 0;
		
		// while 반복문을 사용해 숫자가 0이 될 때까지 순회
		while (n > 0) {
			
			// 해당 자릿수를 자릿수의 합에 갱신
			sum += n % 10;
			
			// 숫자를 갱신
			n /= 10;
		}
		
        // 자연수의 각 자릿수의 합을 반환
        return sum;
    }
}