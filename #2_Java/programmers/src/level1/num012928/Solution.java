package level1.num012928;

// Solution 클래스 정의
public class Solution {

	// solution() 메서드 정의
	public static int solution(int n) {

		// 약수의 합을 저장할 변수 sum 초기화
		int sum = 0;
		
		// for 반복문을 사용해 각 자연수를 순회
		for (int number = 1; number <= n; number++) {
			
			// 해당 숫자가 약수인 경우 약수의 합을 갱신
			if (n % number == 0)
				sum += number;
		}
		
		// 약수의 합을 반환
		return sum;
    }
}