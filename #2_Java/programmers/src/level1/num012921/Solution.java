package level1.num012921;

// Solution 클래스 정의
public class Solution {

	// solution() 메서드 정의
	public static int solution(int n) {
		
		// 소수의 개수를 저장할 변수 totalCount 초기화
		int totalCount = 0;
		
		// 각 숫자가 소수가 아닌지 여부를 저장할 배열 isNotPrime 초기화
		boolean[] isNotPrime = new boolean[n + 1];
		
		// 1은 소수가 아닌 것으로 처리
		isNotPrime[1] = true;
		
		// for 반복문을 사용해 각 숫자를 순회
		for (int number = 2; number <= Math.sqrt(n); number++) {
			
			// 해당 숫자가 소수가 아닌 경우 다음 숫자를 순회
			if (isNotPrime[number])
				continue;
			
			// for 반복문을 사용해 해당 숫자를 약수로 갖는 수를 소수가 아닌 것으로 처리
			for (int idx = number * 2; idx < isNotPrime.length; idx += number)
				isNotPrime[idx] = true;
		}
		
		// for 반복문을 사용해 소수의 개수를 갱신
		for (int idx = 1; idx < isNotPrime.length; idx++)
			totalCount = (isNotPrime[idx]) ? totalCount : totalCount + 1;
		
		// 소수의 개수를 반환
		return totalCount;
    }
}