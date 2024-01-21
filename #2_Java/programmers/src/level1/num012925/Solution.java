package level1.num012925;

// Solution 클래스 정의
public class Solution {

	// solution() 메서드 정의
	public static int solution(String s) {
		
		// 해당 숫자가 양수인지 여부, 숫자로 변환한 결과를 저장할 각 변수 초기화
		boolean isPositive = true;
		int result = 0;
		
		// for 반복문을 사용해 문자열의 각 자리를 순회
		for (int idx = 0; idx < s.length(); idx++) {
			
			// charAt() 메서드를 사용해 해당 자리를 변수 digit에 할당
			char digit = s.charAt(idx);
			
			// 음수 부호인 경우 해당 정수가 양수인지 여부를 갱신
			if (digit == '-') {
				isPositive = false;
			
			// 양수 부호인 경우 다음 자리를 순회
			} else if (digit == '+') {
				continue;
			
			// 숫자인 경우 숫자로 변환한 결과를 갱신
			} else {
				result *= 10;
				result += digit - '0';
			}
		}
		
		// 해당 숫자가 음수인 경우 숫자로 변환한 결과를 음수로 갱신
		if (!isPositive)
			result = -result;
		
		// 숫자로 변환한 결과를 반환
		return result;
    }
}