package level1.num068935;

// Solution 클래스 정의
public class Solution {
	
	// solution() 메서드 정의
	public static int solution(int n) {

		// toString() 메서드를 사용해 주어진 숫자를 3진법으로 변환해 변수 ternary에 할당
		String ternary = Integer.toString(n, 3);
		
		// StringBuilder 객체를 불러와 변수 sb에 할당
		StringBuilder sb = new StringBuilder(ternary);
		
		// reverse(), toString(), parseInt() 메서드를 사용해 3진법을 뒤집고, 이를 다시 10진법으로 변환한 숫자를 반환
		return Integer.parseInt(sb.reverse().toString(), 3);
    }
}