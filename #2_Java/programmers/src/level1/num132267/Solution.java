package level1.num132267;

// Solution 클래스 정의
public class Solution {

	// solution() 메서드 정의
	public static int solution(int a, int b, int n) {
		
		// 빈 병으로 받을 수 있는 콜라의 수를 저장할 변수 totalCnt 초기화
		int totalCnt = 0;
		
		// while 반복문을 사용해 가진 빈 병이 a개 미만이 될 때까지 순회
		while (n >= a) {
			
			// 빈 병으로 받을 수 있는 콜라의 수를 갱신
			totalCnt += (n / a) * b;
			
			// 가지고 있는 빈 병의 개수를 갱신
			n = (n / a) * b + n % a; 
		}
		
		// 빈 병으로 받을 수 있는 콜라의 수를 반환
		return totalCnt;
    }
}