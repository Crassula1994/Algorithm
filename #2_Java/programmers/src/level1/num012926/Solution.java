package level1.num012926;

// Solution 클래스 정의
public class Solution {
	
	// solution() 메서드 정의
	public static String solution(String s, int n) {
		
		// 암호문을 저장할 StringBuilder 객체 sb 초기화
		StringBuilder sb = new StringBuilder();
		
		// for 반복문을 사용해 문장의 각 글자를 순회
		for (int idx = 0; idx < s.length(); idx++) {
			
			// charAt() 메서드를 사용해 해당 글자를 변수 character에 할당
			char character = s.charAt(idx);
			
			// 해당 글자가 빈 칸인 경우 빈 칸을 sb에 추가
			if (character == ' ') {
				sb.append(character);
				
			// 해당 글자가 대문자인 경우
			} else if (character - 'a' < 0) {
				
				// 암호화된 알파벳의 순서를 계산해 변수 alphabet에 할당
				int alphabet = (character - 'A' + n) % 26;
				
				// append() 메서드를 사용해 암호화된 알파벳을 sb에 추가
				sb.append((char) (alphabet + 65));
			
			// 해당 글자가 소문자인 경우
			} else {
				
				// 암호화된 알파벳의 순서를 계산해 변수 alphabet에 할당
				int alphabet = (character - 'a' + n) % 26;
				
				// append() 메서드를 사용해 암호화된 알파벳을 sb에 추가
				sb.append((char) (alphabet + 97));
			}
		}
		
		// toString() 메서드를 사용해 암호문을 반환
		return sb.toString();
    }
}