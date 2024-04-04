package level1.num012982;

// 필요한 패키지 불러오기
import java.util.Arrays;

// Solution 클래스 정의
public class Solution {
	
	// solution() 메서드 정의
	public static int solution(int[] d, int budget) {

		// 최대로 지원할 수 있는 부서의 수와 총 신청금액을 저장할 각 변수 초기화
		int maxCount = 0;
		int totalSum = 0;
		
		// sort() 메서드를 사용해 입력 받은 부서의 신청 금액을 오름차순으로 정렬
		Arrays.sort(d);
		
		// for 반복문을 사용해 각 부서의 신청 금액을 순회
		for (int idx = 0; idx < d.length; idx++) {
			
			// 해당 부서의 신청 금액을 신청할 수 없는 경우 반복문 탈출
			if (totalSum + d[idx] > budget)
				break;
			
			// 최대로 지원할 수 있는 부서의 수 및 총 신청금액을 갱신
			maxCount++;
			totalSum += d[idx];
		}
		
		// 최대로 지원할 수 있는 부서의 수를 반환
		return maxCount;
    }
}