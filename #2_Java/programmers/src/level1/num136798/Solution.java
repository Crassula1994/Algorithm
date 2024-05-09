package level1.num136798;

// Solution 클래스 정의
public class Solution {

	// solution() 메서드 정의
	public static int solution(int number, int limit, int power) {
		
		// 무기를 모두 만들기 위해 필요한 철의 무게를 저장할 변수 totalWeight 초기화
		int totalWeight = 0;
		
		// 각 기사의 공격력을 저장할 배열 knights 초기화
		int[] knights = new int[number + 1];
		
		// for 반복문을 사용해 각 기사의 번호를 순회
		for (int n = 1; n < knights.length; n++) {
			
			// for 반복문을 사용해 해당 숫자의 배수에 해당하는 기사의 공격력을 갱신
			for (int idx = n; idx < knights.length; idx += n)
				knights[idx]++;
		}
		
		// for 반복문을 사용해 무기를 모두 만들기 위해 필요한 철의 무게를 갱신
		for (int idx = 1; idx < knights.length; idx++)
			totalWeight = (knights[idx] > limit) ? totalWeight + power : totalWeight + knights[idx];
		
		// 무기를 모두 만들기 위해 필요한 철의 무게를 반환
		return totalWeight;
    }
}