package level1.num012948;

// Solution 클래스 정의
public class Solution {

	// solution() 메서드 정의
	public static String solution(String phone_number) {
		
		// StringBuilder 객체를 불러와 변수 sb에 할당
		StringBuilder sb = new StringBuilder();
		
		// for 반복문을 사용해 전화번호를 가릴 길이만큼의 '*'을 sb에 추가
		for (int len = 0; len < phone_number.length() - 4; len++)
			sb.append("*");
		
		// length(), substring(), append() 메서드를 사용해 전화번호 뒷 네 자리를 sb에 추가
		sb.append(phone_number.substring(phone_number.length() - 4));
		
		// toString() 메서드를 사용해 전화번호의 일부를 가린 문자열을 반환
		return sb.toString();
    }
}