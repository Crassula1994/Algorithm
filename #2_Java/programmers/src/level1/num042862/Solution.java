package level1.num042862;

// 필요한 패키지 불러오기
import java.util.Arrays;

// Solution 클래스 정의
public class Solution {

	// solution() 메서드 정의
	public static int solution(int n, int[] lost, int[] reserve) {
		
		// 체육 수업을 들을 수 있는 학생 수의 최댓값을 저장할 변수 maxCount 초기화
		int maxCount = 0;
		
		// 각 학생의 체육복 보유 현황을 저장할 배열 uniforms 초기화
		int[] uniforms = new int[n + 2];
		
		// fill() 메서드를 사용해 각 학생의 체육복 보유 현황을 초기화
		Arrays.fill(uniforms, 1);
		
		// for 반복문을 사용해 체육복을 도난 당한 학생의 체육복 보유 현황을 갱신
		for (int idx = 0; idx < lost.length; idx++)
			uniforms[lost[idx]]--;
		
		// for 반복문을 사용해 여벌 체육복이 있는 학생의 체육복 보유 현황을 갱신
		for (int idx = 0; idx < reserve.length; idx++)
			uniforms[reserve[idx]]++;
		
		// for 반복문을 사용해 각 체육복 보유 현황을 순회
		for (int idx = 1; idx <= n; idx++) {
			
			// 여벌의 체육복을 보유하지 않은 경우 다음 학생을 순회
			if (uniforms[idx] < 2)
				continue;
			
			// 왼쪽 학생이 체육복을 보유하지 않은 경우 왼쪽 학생에게 빌려준 것으로 처리
			if (uniforms[idx - 1] == 0) {
				uniforms[idx - 1]++;
				uniforms[idx]--;
				
			// 왼쪽 학생은 체육복을 보유했지만 오른쪽 학생이 보유하지 않은 경우 오른쪽 학생에게 빌려준 것으로 처리
			} else if (uniforms[idx + 1] == 0) {
				uniforms[idx + 1]++;
				uniforms[idx]--;
			}
		}
		
		// for 반복문을 사용해 체육 수업을 들을 수 있는 학생 수의 최댓값을 갱신
		for (int idx = 1; idx <= n; idx++)
			maxCount = (uniforms[idx] > 0) ? maxCount + 1 : maxCount;
		
		// 체육 수업을 들을 수 있는 학생 수의 최댓값을 반환
		return maxCount;
	}
}