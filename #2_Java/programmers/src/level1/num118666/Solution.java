package level1.num118666;

// 필요한 패키지 불러오기
import java.util.HashMap;
import java.util.Map;

// Solution 클래스 정의
public class Solution {
	
	// 각 성격 유형을 저장할 배열 categories 초기화
	static char[] categories = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
	
	// 각 성격 유형에 해당하는 점수를 저장할 Map 객체 scores 초기화
	static Map<Character, Integer> scores = new HashMap<>();
	
	// ----------------------------------------------------------------------------------------------------
	
	// solution() 메서드 정의
	public static String solution(String[] survey, int[] choices) {
		
		// 검사자의 성격 유형을 저장할 StringBuilder 객체 result 초기화
		StringBuilder result = new StringBuilder();
		
		// for 반복문을 사용해 각 성격 유형의 점수를 초기화해 scores에 저장
		for (char category : categories)
			scores.put(category, 0);
		
		// for 반복문을 사용해 각 사용자의 선택을 순회
		for (int idx = 0; idx < choices.length; idx++) {
			
			// charAt() 메서드를 사용해 해당 질문지의 비동의와 동의 선택지의 성격 유형을 각 변수에 할당
			char nonConsent = survey[idx].charAt(0);
			char consent = survey[idx].charAt(1);
			
			// 해당 점수가 4점 미만인 경우 비동의에 해당하는 성격 유형의 점수를 갱신
			if (choices[idx] < 4) {
				scores.put(nonConsent, scores.get(nonConsent) + 4 - choices[idx]);
			
			// 해당 점수가 4점 초과인 경우 동의에 해당하는 성격 유형의 점수를 갱신
			} else if (choices[idx] > 4) {
				scores.put(consent, scores.get(consent) + choices[idx] - 4);
			}
		}
		
		// for 반복문을 사용해 검사자의 성격 유형을 갱신
		for (int idx = 0; idx < categories.length; idx += 2)
			result.append(scoreCalculator(categories[idx], categories[idx + 1]));
		
		// toString() 메서드를 사용해 검사자의 성격 유형을 반환
        return result.toString();
    }
	
	// ----------------------------------------------------------------------------------------------------

	// scoreCalculator() 메서드 정의
	public static char scoreCalculator(char categoryA, char categoryB) {
		
		// get() 메서드를 사용해 각 성격 유형의 점수를 각 변수에 할당
		int scoreA = scores.get(categoryA);
		int scoreB = scores.get(categoryB);
		
		// 두 성격 유형 중 점수가 높은 성격 유형을 반환
		return (scoreA >= scoreB) ? categoryA : categoryB;
	}
}