package level1.num012919;

// Solution 클래스 정의
public class Solution {
	
	// solution() 메서드 정의
	public static String solution(String[] seoul) {
		
		// 김서방이 있는 위치를 저장할 변수 location 초기화
		int location = -1;
		
		// for 반복문을 사용해 배열의 각 원소를 순회
		for (int idx = 0; idx < seoul.length; idx++) {
			
			// 해당 원소의 이름이 'Kim'인 경우 김서방이 있는 위치를 갱신 후 반복문 탈출
			if (seoul[idx].equals("Kim")) {
				location = idx;
				break;
			}
		}
		
		// 김서방이 있는 위치를 나타내는 문자열을 반환
		return "김서방은 " + location + "에 있다";
    }
}