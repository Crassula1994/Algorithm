package level1.num012977;

// Solution 클래스 정의
public class Solution {

	// solution() 메서드 정의
	public static int solution(int[] nums) {
		
		// 소수가 되는 경우의 개수를 저장할 변수 totalCount 초기화
		int totalCount = 0;
		
		// 각 숫자가 소수가 아닌지 여부를 저장할 배열 isNotPrime 초기화
		boolean[] isNotPrime = new boolean[50001];
		
		// 1은 소수가 아닌 것으로 처리
		isNotPrime[1] = true;
		
		// for 반복문을 사용해 각 숫자를 순회
		for (int number = 2; number <= Math.sqrt(50000); number++) {
			
			// 해당 숫자가 소수가 아닌 경우 다음 숫자를 순회
			if (isNotPrime[number])
				continue;
			
			// for 반복문을 사용해 해당 숫자를 약수로 갖는 수를 소수가 아닌 것으로 처리
			for (int idx = number * 2; idx < isNotPrime.length; idx += number)
				isNotPrime[idx] = true;
		}
		
		// for 반복문을 사용해 각 숫자의 조합을 순회
		for (int n1 = 0; n1 < nums.length - 2; n1++) {
			for (int n2 = n1 + 1; n2 < nums.length - 1; n2++) {
				for (int n3 = n2 + 1; n3 < nums.length; n3++) {
					
					// 세 숫자의 합이 소수가 아닌 경우 다음 숫자 조합을 순회
					if (isNotPrime[nums[n1] + nums[n2] + nums[n3]])
						continue;
					
					// 소수가 되는 경우의 개수를 갱신
					totalCount++;
				}
			}
		}
		
		// 소수가 되는 경우의 개수를 반환
		return totalCount;
    }
}