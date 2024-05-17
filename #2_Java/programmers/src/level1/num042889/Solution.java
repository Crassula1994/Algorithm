package level1.num042889;

// 필요한 패키지 불러오기
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Solution 클래스 정의
public class Solution {
	
	// Stage 클래스 정의
	public static class Stage implements Comparable<Stage> {
		
		// 스테이지의 번호와 실패율을 저장할 각 변수 초기화
		int number;
		double failureRate;
		
		// 매개변수를 입력 받는 생성자 정의
		public Stage(int number, double failureRate) {
			this.number = number;
			this.failureRate = failureRate;
		}

		// compareTo() 메서드 정의
		@Override
		public int compareTo(Stage anotherStage) {
			
			// 현재 스테이지의 실패율이 다른 스테이지의 실패율보다 작은 경우 -1 반환
			if (failureRate < anotherStage.failureRate)
				return 1;
			
			// 현재 스테이지의 실패율이 다른 스테이지의 실패율보다 큰 경우 1 반환 
			if (failureRate > anotherStage.failureRate)
				return -1;

			// 현재 스테이지의 실패율이 다른 스테이지의 실패율과 같은 경우 숫자가 작은 순서대로 정렬
			return number - anotherStage.number;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------

	// solution() 메서드 정의
	public static int[] solution(int n, int[] stages) {
		
		// 각 스테이지를 도전 중인 사용자 수, 도달한 사용자 수를 저장할 각 배열 초기화
		int[] counts = new int[n + 2];
		double[] totalCounts = new double[n + 2];
		
		// 스테이지에 대한 정보를 저장할 List 객체 stageInfo 초기화
		List<Stage> stageInfo = new ArrayList<>();
		
		// for 반복문을 사용해 각 스테이지를 도전 중인 사람 수를 갱신
		for (int idx = 0; idx < stages.length; idx++)
			counts[stages[idx]]++;
		
		// 가장 높은 단계에 도달한 사용자 수를 갱신
		totalCounts[n + 1] = counts[n + 1];
		
		// for 반복문을 사용해 각 스테이지를 거꾸로 순회
		for (int stage = n; stage > 0; stage--) {
			
			// 해당 스테이지에 도달한 플레이어 수를 계산해 배열 totalCounts에 저장
			totalCounts[stage] = counts[stage] + totalCounts[stage + 1];
			
			// 실패율을 계산해 변수 failureRate에 할당
			double failureRate = (totalCounts[stage] == 0) ? 0 : counts[stage] / totalCounts[stage];
			
			// add() 메서드를 사용해 해당 스테이지에 대한 정보를 stageInfo에 저장
			stageInfo.add(new Stage(stage, failureRate));
		}
		
		// sort() 메서드를 사용해 실패율이 높은 스테이지부터 내림차순으로 정렬
		Collections.sort(stageInfo);
		
		// stream(), mapToInt(), toArray() 메서드를 사용해 실패율이 높은 스테이지부터 내림차순으로 정렬한 배열을 반환
		return stageInfo.stream().mapToInt(stage -> stage.number).toArray();
    }
}