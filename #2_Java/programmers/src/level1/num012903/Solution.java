package level1.num012903;

// Solution 클래스 정의
public class Solution {

	// solution() 메서드 정의
	public static String solution(String s) {
		
		// 단어의 길이가 홀수인 경우 가운데 한 글자를 반환
		if (s.length() % 2 == 1) {
			return String.valueOf(s.charAt(s.length() / 2));
	
		// 단어의 길이가 짝수인 경우 가운데 두 글자를 반환
		} else {
			return s.substring(s.length() / 2 - 1, s.length() / 2 + 1);
		}
    }
}