package level1.num140108;

// Solution 클래스 정의
public class Solution {

	// solution() 메서드 정의
	public static int solution(String s) {
		
		// 첫 글자, 분해한 문자열의 수, 첫 글자와 같은 글자 및 다른 글자의 수를 저장할 각 변수 초기화
		char firstLetter = ' ';
		int substringCnt = 0;
		int sameCnt = 0;
		int diffCnt = 0;
		
		// for 반복문을 사용해 각 글자를 순회
		for (int idx = 0; idx < s.length(); idx++) {
			
			// charAt() 메서드를 사용해 해당 글자를 변수 letter에 할당
			char letter = s.charAt(idx);
			
			// 문자열을 분해한 직후인 경우 첫 글자를 갱신
			if (sameCnt == 0 && diffCnt == 0)
				firstLetter = letter;
			
			// 해당 글자가 첫 글자와 같은 경우 첫 글자와 같은 글자의 수를 갱신
			if (letter == firstLetter) {
				sameCnt++;
			
			// 해당 글자가 첫 글자와 다른 경우 첫 글자와 다른 글자의 수를 갱신
			} else {
				diffCnt++;
			}
			
			// 첫 글자와 같은 글자의 수와 다른 글자의 수가 같은 경우
			if (sameCnt == diffCnt) {
				
				// 첫 글자와 같은 글자의 수와 다른 글자의 수를 초기화
				sameCnt = 0;
				diffCnt = 0;
				
				// 분해한 문자열의 수를 갱신
				substringCnt++;
			}
		}
		
		// 첫 글자와 같은 글자의 수와 다른 글자의 수가 다른 상태에서 더 읽은 글자가 없는 경우 분해한 문자열의 수를 갱신
		if (sameCnt > 0 || diffCnt > 0)
			substringCnt++;
		
		// 분해한 문자열의 수를 반환
		return substringCnt;
	}
}