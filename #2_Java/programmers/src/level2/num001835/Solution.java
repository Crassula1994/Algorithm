package level2.num001835;

// 필요한 패키지 불러오기
import java.util.HashMap;
import java.util.Map;

// Solution 클래스 정의
public class Solution {

	// 경우의 수를 저장할 변수 count 초기화
	static int count;
	
	// 각 프렌즈를 저장할 배열 members 초기화
	static char[] members = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
	
	// 각 프렌즈가 배치되었는지, 배치된 위치는 무엇인지를 나타내는 각 Map 객체 초기화
    static Map<Character, Boolean> isLocated = new HashMap<>();
    static Map<Character, Integer> location = new HashMap<>();
	
	// ----------------------------------------------------------------------------------------------------
	
	// solution() 메서드 정의
	public static int solution(int n, String[] data) {

		// 경우의 수를 저장할 변수 count 초기화
		count = 0;
        
		// for 반복문을 사용해 각 프렌즈의 정보를 초기화
        for (int idx = 0; idx < members.length; idx++) {
            isLocated.put(members[idx], false);
            location.put(members[idx], -1);
        }
        
        // lineMaker() 메서드를 호출해 조건을 만족하는 경우의 수를 갱신
        lineMaker(0, data);

        // 경우의 수를 반환
        return count;
    }
	
	// ----------------------------------------------------------------------------------------------------
	
	// lineMaker() 메서드 정의
	public static void lineMaker(int startIdx, String[] data) {
		
		// 모든 멤버를 배치한 경우
		if (startIdx == members.length) {
			
			// conditionChecker() 메서드를 호출해 모든 조건을 만족하는지를 변수 isSatisfied에 저장
            boolean isSatisfied = conditionChecker(data);
            
            // 모든 조건을 만족하는 경우 경우의 수를 갱신
            if (isSatisfied)
                count++;
            
            // 메서드 종료
            return;
        }
        
		// for 반복문을 사용해 모든 프렌즈를 순회
        for (int idx = 0; idx < members.length; idx++) {
            
        	// 현재 확인 중인 프렌즈를 변수 member에 할당
            char member = members[idx];
            
            // 해당 프렌즈가 배치된 경우 다음 프렌즈를 순회
            if (isLocated.get(member))
            	continue;
            
            // 해당 프렌즈를 배치하고 배치 처리
            isLocated.put(member, true);
            location.put(member, startIdx);
            
            // lineMaker() 메서드 재귀 호출
            lineMaker(startIdx + 1, data);
            
            // 해당 프렌즈를 배치하지 않은 것으로 원상 복구
            isLocated.put(member, false);
            location.put(member, -1);
        }
    }
	
	// ----------------------------------------------------------------------------------------------------
	
	// conditionChecker() 메서드 정의
    public static boolean conditionChecker(String[] data) {
        
    	// for 반복문을 사용해 모든 조건을 순회
        for (int idx = 0; idx < data.length; idx++) {
            
        	// 해당 조건을 변수 conditon에 할당
            String condition = data[idx];
            
            // charAt() 메서드를 사용해 각 조건의 정보를 각 변수에 할당
            char person1 = condition.charAt(0);
            char person2 = condition.charAt(2);
            char sign = condition.charAt(3);
            int targetDist = condition.charAt(4) - '0';
            
            // abs() 메서드를 사용해 조건의 두 사람의 거리를 변수 distance에 할당
            int distance = Math.abs(location.get(person1) - location.get(person2)) - 1;
            
            // 등호 조건을 만족하지 않는 경우 false 반환
            if (sign == '=' && distance != targetDist)
                return false;
            
            // '<' 부등호 조건을 만족하지 않는 경우 false 반환
            if (sign == '<' && distance >= targetDist)
                return false;
            
            // '>' 부등호 조건을 만족하지 않는 경우 false 반환
            if (sign == '>' && distance <= targetDist)
                return false;
        }
        
        // 모든 조건을 만족하는 경우 true 반환
        return true;
    }
}