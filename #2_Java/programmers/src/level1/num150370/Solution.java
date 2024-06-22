package level1.num150370;

// 필요한 패키지 불러오기
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

// Solution 클래스 정의
public class Solution {
	
	// solution() 메서드 정의
	public static int[] solution(String today, String[] terms, String[] privacies) {
		
		// dayCalculator() 메서드를 호출해 오늘의 날짜를 일자로 바꾸어 변수 todayCount에 저장
		int todayCount = dayCalculator(today);
		
		// 파기해야 할 개인정보의 번호를 저장할 List 객체 destructions 초기화
		List<Integer> destructions = new ArrayList<>();
		
		// 약관에 따른 보관 가능 일수를 저장할 Map 객체 policies 초기화
		Map<String, Integer> policies = new HashMap<>();
		
		// for 반복문을 사용해 각 약관을 순회
		for (int idx = 0; idx < terms.length; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(terms[idx]);
			
			// nextToken() 및 parseInt() 메서드를 사용해 약관의 종류 및 유효기간을 각 변수에 할당
			String category = st.nextToken();
			int expiryDate = Integer.parseInt(st.nextToken()) * 28;
			
			// put() 메서드를 사용해 해당 약관의 정보를 policies에 저장
			policies.put(category, expiryDate);
		}
		
		// for 반복문을 사용해 각 개인정보를 순회
		for (int idx = 0; idx < privacies.length; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(privacies[idx]);
			
			// nextToken() 메서드를 사용해 개인정보 수집 일자 및 약관의 종류를 각 변수에 할당
			String collectionDate = st.nextToken();
			String category = st.nextToken();
			
			// 해당 개인정보의 유효기간이 지나지 않은 경우 다음 개인정보를 순회
			if (dayCalculator(collectionDate) + policies.get(category) > todayCount)
				continue;
			
			// add() 메서드를 사용해 파기해야 할 개인정보를 destructions에 추가
			destructions.add(idx + 1);
		}
		
		// stream(), mapToInt(), toArray() 메서드를 사용해 파기해야 할 개인정보를 저장한 배열을 반환
        return destructions.stream().mapToInt(i -> i).toArray();
    }
	
	// ----------------------------------------------------------------------------------------------------

	// dayCalculator() 메서드 정의
	public static int dayCalculator(String dayString) {
		
		// 해당 날짜를 일수로 변환해 저장할 변수 dayCount 초기화
		int dayCount = 0;

		// split() 메서드를 사용해 연월일을 배열 dayStrings에 저장
		String[] dayStrings = dayString.split("\\.");
		
		// 연, 월, 일을 일수로 변환해 변수 dayCount에 저장
		dayCount += (Integer.parseInt(dayStrings[0]) - 2000) * 336;
		dayCount += Integer.parseInt(dayStrings[1]) * 28;
		dayCount += Integer.parseInt(dayStrings[2]);
		
		// 해당 날짜를 일수로 변환한 결과를 반환
		return dayCount;
	}
}