package level1.num077484;

// 필요한 패키지 불러오기
import java.util.HashSet;
import java.util.Set;

// Solution 클래스 정의
public class Solution {

	// solution() 메서드 정의
	public static int[] solution(int[] lottos, int[] winNums) {
		
		// 당첨 가능한 번호의 최고 개수와 최저 개수를 저장할 각 변수 초기화
		int maxCount = 0;
		int minCount = 0;
		
		// 당첨 번호를 저장할 Set 객체 winNumbers 초기화
		Set<Integer> winNumbers = new HashSet<>();
		
		// for 반복문을 사용해 당첨 번호를 winNumbers에 저장
		for (int number : winNums)
			winNumbers.add(number);
		
		// for 반복문을 사용해 민우가 구매한 로또 번호를 순회
		for (int number : lottos) {
			
			// 해당 숫자를 알아볼 수 없는 경우 당첨 가능한 번호의 최고 개수를 갱신 후 다음 번호를 순회
			if (number == 0) {
				maxCount++;
				continue;
			}
			
			// 해당 숫자가 당첨 번호인 경우 당첨 가능한 번호의 최고 개수와 최저 개수를 모두 갱신
			if (winNumbers.contains(number)) {
				maxCount++;
				minCount++;
			}
		}
		
		// 당첨 가능한 최고 순위와 최저 순위를 계산해 각 변수에 할당
		int maxRank = (maxCount == 0) ? 6 : 7 - maxCount;
		int minRank = (minCount == 0) ? 6 : 7 - minCount;
		
		// 당첨 가능한 최고 순위와 최저 순위를 담은 배열을 반환
		return new int[] {maxRank, minRank};
	}
}