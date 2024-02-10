package level1.num012922;

// Solution 클래스 정의
public class Solution {

	// solution() 메서드 정의
	public static String solution(int n) {
		
		// StringBuilder 객체를 불러와 변수 sb에 할당
		StringBuilder sb = new StringBuilder();
		
		// for 반복문을 사용해 각 글자 수를 순회
		for (int idx = 0; idx < n; idx++) {
			
			// 홀수 번째 글자인 경우 '수'를 추가 
			if (idx % 2 == 0) {
				sb.append("수");
				
			// 짝수 번째 글자인 경우 '박'을 추가
			} else {
				sb.append("박");
			}
		}
		
		// toString() 메서드를 사용해 정해진 길이의 패턴을 유지한 문자열을 반환
		return sb.toString();
    }
}