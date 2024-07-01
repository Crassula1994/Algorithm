package level1.num092334;

// 필요한 패키지 불러오기
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

// Solution 클래스 정의
public class Solution {
	
	// solution() 메서드 정의
	public static int[] solution(String[] idList, String[] reports, int k) {
		
		// 각 유저가 받은 결과 메일 수를 저장할 배열 mailCounts 초기화
		int[] mailCounts = new int[idList.length];
		
		// 유일한 신고 기록을 저장할 Set 객체 reportList 초기화
		Set<String> reportList = new HashSet<>();
		
		// 신고 결과와 각 유저가 받은 메일 수를 저장할 각 Map 객체 초기화
		Map<String, List<String>> resultList = new HashMap<>();
		Map<String, Integer> mailList = new HashMap<>();
		
		// for 반복문을 사용해 신고 결과의 내용을 reportList에 저장
		for (String report : reports)
			reportList.add(report);
		
		// for 반복문을 사용해 신고 결과를 저장할 List 객체 초기화
		for (int idx = 0; idx < idList.length; idx++) {
			resultList.put(idList[idx], new ArrayList<>());
			mailList.put(idList[idx], 0);
		}
			
		// for 반복문을 사용해 각 신고 결과를 순회
		for (String report : reportList) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(report);
			
			// nextToken() 메서드를 사용해 이용자 아이디와 신고한 아이디를 각 변수에 할당
			String reporter = st.nextToken();
			String reported = st.nextToken();
			
			// get() 및 add() 메서드를 사용해 신고 결과를 갱신
			resultList.get(reported).add(reporter);
		}
		
		// for 반복문을 사용해 각 신고 결과를 순회
		for (String id : resultList.keySet()) {
			
			// 신고 당한 횟수가 정지 기준 횟수 미만인 경우 다음 신고 결과를 순회
			if (resultList.get(id).size() < k)
				continue;
			
			// for 반복문을 사용해 각 신고자가 받을 메일 횟수를 갱신
			for (String reporter : resultList.get(id))
				mailList.put(reporter, mailList.get(reporter) + 1);
		}
		
		// for 반복문을 사용해 각 유저가 받은 결과 메일 수를 배열에 저장
		for (int idx = 0; idx < mailCounts.length; idx++)
			mailCounts[idx] = mailList.get(idList[idx]);
		
		// 각 유저가 받은 결과 메일 수를 저장한 배열 반환
		return mailCounts;
    }
}