package level1.num042576;

// 필요한 패키지 불러오기
import java.util.HashMap;
import java.util.Map;

// Solution 클래스 정의
public class Solution {

	// solution() 메서드 정의
	public static String solution(String[] participant, String[] completion) {
		
		// 완주하지 못한 선수의 이름을 저장할 변수 targetName 초기화
		String targetName = "";
		
		// 참가자 명단의 선수 명단을 저장할 Map 객체 nameCounts 초기화
		Map<String, Integer> nameCounts = new HashMap<>();
		
		// for 반복문을 사용해 각 참가자 명단을 nameCounts에 저장
		for (String partName : participant)
			nameCounts.put(partName, nameCounts.getOrDefault(partName, 0) + 1);
			
		// for 반복문을 사용해 각 완주한 사람들의 수를 nameCounts에서 제거
		for (String compName : completion)
			nameCounts.put(compName, nameCounts.get(compName) - 1);
		
		// for 반복문을 사용해 각 참가자 명단을 순회
		for (String name : nameCounts.keySet()) {
			
			// 해당 참가자가 완주하지 못한 경우 완주하지 못한 선수의 이름을 갱신 후 반복문 탈출
			if (nameCounts.get(name) == 1) {
				targetName = name;
				break;
			}
		}
		
		// 완주하지 못한 선수의 이름을 반환
		return targetName;
	}
}