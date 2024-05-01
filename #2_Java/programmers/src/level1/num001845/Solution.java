package level1.num001845;

// 필요한 패키지 불러오기
import java.util.HashSet;
import java.util.Set;

// Solution 클래스 정의
public class Solution {

	// solution() 메서드 정의
	public static int solution(int[] nums) {
		
		// 폰켓몬의 종류를 저장할 Set 객체 ponkemons 초기화
		Set<Integer> ponkemons = new HashSet<>();
		
		// for 반복문을 사용해 각 폰켓몬을 ponkemons에 추가
		for (int idx = 0; idx < nums.length; idx++)
			ponkemons.add(nums[idx]);
		
		// size() 및 min() 메서드를 사용해 선택할 수 있는 가장 많은 종류의 폰켓몬의 수를 변수 maxCount에 할당
		int maxCount = Math.min(ponkemons.size(), nums.length / 2);
		
		// 선택할 수 있는 가장 많은 종류의 폰켓몬의 수를 반환
		return maxCount;
    }
}