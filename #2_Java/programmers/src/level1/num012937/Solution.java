package level1.num012937;

// Solution 클래스 정의
public class Solution {
	
	// solution() 메서드 정의
	public static String solution(int num) {

		// 입력 받은 정수가 짝수인지 홀수인지를 나타내는 문자열을 변수 answer에 할당
		String answer = (num % 2 == 0) ? "Even" : "Odd";
		
		// 입력 받은 정수가 짝수인지 홀수인지를 나타내는 문자열을 반환
        return answer;
    }
}