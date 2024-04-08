package level1.num012930;

// Solution 클래스 정의
public class Solution {
	
	// solution() 메서드 정의
	public static String solution(String s) {
		
		// 바꾼 문자열을 저장할 StringBuilder 객체 sb 초기화
		StringBuilder sb = new StringBuilder();
		
		// 각 단어의 인덱스를 저장할 변수 index 초기화
		int index = 0;
		
		// for 반복문을 사용해 각 문자를 순회
		for (int idx = 0; idx < s.length(); idx++) {
			
			// charAt() 메서드를 사용해 해당 문자를 변수 character에 할당
			char character = s.charAt(idx);
			
			// 해당 문자가 빈 칸인 경우 sb에 추가 및 단어 인덱스 초기화
			if (character == ' ') {
				sb.append(character);
				index = 0;
				
			// 해당 문자가 알파벳인 경우
			} else {
				
				// valueOf() 메서드를 사용해 해당 알파벳을 변수 alphabet에 할당
				String alphabet = String.valueOf(character);
				
				// 짝수 인덱스인 경우 알파벳을 대문자로 sb에 추가
				if (index % 2 == 0) {
					sb.append(alphabet.toUpperCase());
					
				// 홀수 인덱스인 경우 알파벳을 소문자로 sb에 추가
				} else {
					sb.append(alphabet.toLowerCase());
				}
				
				// 단어의 인덱스 갱신
				index++;
			}
		}
		
		// toString() 메서드를 사용해 바꾼 문자열을 반환
		return sb.toString();
    }
}