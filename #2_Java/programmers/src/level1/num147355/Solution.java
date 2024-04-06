package level1.num147355;

// Solution 클래스 정의
public class Solution {
	
	// solution() 메서드 정의
	public static int solution(String t, String p) {

		// 부분문자열이 p가 나타내는 수보다 작거나 같은 경우의 개수를 저장할 변수 totalCnt 초기화
		int totalCnt = 0;
		
		// parseLong() 메서드를 사용해 문자열 p를 숫자로 바꾸어 변수 pNum에 저장
		long pNum = Long.parseLong(p);
		
		// for 반복문을 사용해 문자열 t의 각 부분문자열을 순회
		for (int idx = 0; idx <= t.length() - p.length(); idx++) {
			
			// length() 및 substring() 메서드를 사용해 부분문자열을 변수 subStr에 할당
			String subStr = t.substring(idx, idx + p.length());
			
			// 해당 부분문자열이 문자열 p보다 작거나 같은 경우 해당 경우의 개수를 갱신
			if (Long.parseLong(subStr) <= pNum)
				totalCnt++;
		}
		
		// 부분문자열이 p가 나타내는 수보다 작은 경우의 개수를 반환
		return totalCnt;
    }
}