package level1.num072410;

// Solution 클래스 정의
public class Solution {
	
	// solution() 메서드 정의
	public static String solution(String newId) {
		
		// toLowerCase() 메서드를 사용해 모든 대문자를 소문자로 변환한 결과를 변수 resultId에 할당
		String resultId = newId.toLowerCase();
		
		// replaceAll() 메서드를 사용해 알파벳 소문자, 숫자, 빼기, 밑줄, 마침표를 제외한 모든 문자를 제거
		resultId = resultId.replaceAll("[^a-z0-9\\-_\\.]", "");
		
		// replaceAll() 메서드를 사용해 마침표가 2번 이상 연속된 부분을 하나의 마침표로 치환
		resultId = resultId.replaceAll("\\.{2,}", ".");
		
		// replaceAll() 메서드를 사용해 처음이나 끝에 위치한 마침표를 제거
		resultId = resultId.replaceAll("^\\.|\\.$", "");
		
		// 빈 문자열인 경우 'a'를 대입
		if (resultId.isEmpty())
			resultId = "a";
		
		// 길이가 16자 이상인 경우
		if (resultId.length() >= 16) {
			
			// subString() 메서드를 사용해 첫 15글자의 문자 외의 나머지 문자를 제거
			resultId = resultId.substring(0, 15);
			
			// replaceAll() 메서드를 사용해 끝에 위치한 마침표를 제거
			resultId = resultId.replaceAll("\\.$", "");
		}
		
		// 길이가 2자 이하인 경우 마지막 문자를 길이가 3이 될 때까지 반복해서 끝에 추가
		while (resultId.length() < 3)
			resultId += resultId.charAt(resultId.length() - 1);
		
		// 7단계의 처리 과정을 거친 추천 아이디를 반환
        return resultId;
    }
}