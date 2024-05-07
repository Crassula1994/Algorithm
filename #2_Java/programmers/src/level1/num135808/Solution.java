package level1.num135808;

// 필요한 패키지 불러오기
import java.util.PriorityQueue;

// Solution 클래스 정의
public class Solution {

	// solution() 메서드 정의
	public static int solution(int k, int m, int[] score) {
		
		// 과일 장수가 얻을 수 있는 최대 이익을 저장할 변수 maxProfit 초기화
		int maxProfit = 0;
		
		// 사과를 점수 순으로 정렬할 PriorityQueue 객체 appleSorter 초기화
		PriorityQueue<Integer> appleSorter = new PriorityQueue<>((a1, a2) -> {
			return a2 - a1;
		});
		
		// for 반복문을 사용해 각 사과의 점수를 appleSorter에 추가
		for (int idx = 0; idx < score.length; idx++)
			appleSorter.offer(score[idx]);
		
		// while 반복문을 사용해 사과가 한 상자에 들어가지 않을 때까지 순회
		while (appleSorter.size() >= m) {
			
			// 상자에 들어가는 가장 작은 사과의 점수를 저장할 변수 minScore 초기화
			int minScore = 0;
			
			// for 반복문을 사용해 상자에 들어가는 가장 작은 점수를 갱신
			for (int apple = 0; apple < m; apple++)
				minScore = appleSorter.poll();
			
			// 과일 장수가 얻을 수 있는 최대 이익을 갱신
			maxProfit += minScore * m;
		}
		
		// 과일 장수가 얻을 수 있는 최대 이익을 반환
		return maxProfit;
    }
}