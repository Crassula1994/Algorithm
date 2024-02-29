package level1.num012918;

// Solution 클래스 정의
public class Solution {
	
	// solution() 메서드 정의
	public static boolean solution(String s) {
		
		// 문자열의 길이가 4 또는 6이 아닌 경우 false를 반환
		if (s.length() != 4 && s.length() != 6)
			return false;
		
		// for 반복문을 사용해 문자열의 각 문자를 순회
		for (int idx = 0; idx < s.length(); idx++) {
			
			// charAt() 메서드를 사용해 문자열의 문자를 변수 character에 할당
			char character = s.charAt(idx);
			
			// 해당 문자가 숫자가 아닌 경우 false를 반환
			if (character < '0' || character > '9')
				return false;
		}
		
		// 주어진 문자열의 길이가 4 또는 6이고, 숫자로만 구성되어 있는 경우 true를 반환
		return true;
    }
}