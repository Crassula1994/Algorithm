package level1.num012940;

// Solution 클래스 정의
public class Solution {
	
	// solution() 메서드 정의
	public static int[] solution(int n, int m) {
		
		// 최대공약수를 저장할 변수 gcd 초기화
		int gcd = 0;
		
		// for 반복문을 사용해 각 숫자를 순회
		for (int number = Math.min(n, m); number > 0; number--) {
			
			// 해당 숫자가 공약수인 경우 최대공약수 갱신 후 반복문 탈출
			if (n % number == 0 && m % number == 0) {
				gcd = number;
				break;
			}
		}
		
		// 최소공배수를 계산해 변수 lcm에 할당
		int lcm = gcd * (n / gcd) * (m / gcd);
		
		// 최대공약수와 최소공배수를 저장한 배열을 반환
		return new int[] {gcd, lcm};
    }
}