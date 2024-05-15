package level1.num161989;

// Solution 클래스 정의
public class Solution {

	// solution() 메서드 정의
	public static int solution(int n, int m, int[] section) {
		
		// 롤러로 페인트칠해야 하는 최소 횟수와 롤러로 칠한 마지막 구역을 저장할 각 변수 초기화
		int minCount = 0;
		int lastSection = 0;
		
		// while 반복문을 사용해 각 페인트칠을 해야 하는 곳을 순회
		for (int idx = 0; idx < section.length; idx++) {
			
			// 롤러로 페인트칠해야 하는 구역이 롤러로 칠한 마지막 구역을 벗어난 경우
			if (section[idx] > lastSection) {
				
				// 롤러로 페인트칠해야 하는 최소 횟수 갱신
				minCount++;
				
				// 롤러로 칠한 마지막 구역 갱신
				lastSection = section[idx] + m - 1;
			}
		}
		
		// 롤러로 페인트칠해야 하는 최소 횟수를 반환
		return minCount;
    }
}