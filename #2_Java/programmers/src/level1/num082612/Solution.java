package level1.num082612;

// Solution 클래스 정의
public class Solution {

	// solution() 메서드 정의
	public static long solution(int price, int money, int count) {
		
		// 부족한 금액을 저장할 변수 deficiency 초기화
		long deficiency = 0;
		
		// for 반복문을 사용해 이용 횟수에 따른 배수를 갱신
		for (int n = 1; n <= count; n++)
			deficiency += n;
		
		// 부족한 금액을 갱신
		deficiency = deficiency * price - money;
		
		// 금액이 부족하지 않은 경우 0을 반환
		if (deficiency < 0)
			return 0;
		
		// 부족한 금액을 반환
		return deficiency;
    }
}