package level1.num012916;

// Solution 클래스 정의
public class Solution {

	// solution() 메서드 정의
	public static boolean solution(String s) {
		
		// 'p'와 'y'의 개수를 저장할 각 변수 초기화
		int countP = 0;
		int countY = 0;
		
		// for 반복문을 사용해 입력 받은 문자열의 각 문자를 순회
		for (int idx = 0; idx < s.length(); idx++) {
			
			// charAt() 메서드를 사용해 해당 문자를 변수 character에 할당
			char character = s.charAt(idx);
			
			// 해당 문자가 'p'인 경우 'p'의 개수 갱신
			if (character == 'p' || character == 'P') {
				countP++;
				
			// 해당 문자가 'y'인 경우 'y'의 개수 갱신
			} else if (character == 'y' || character == 'Y') {
				countY++;
			}
		}
		
		// 'p'와 'y'의 개수가 같은지 여부를 반환
		return countP == countY;
    }
}