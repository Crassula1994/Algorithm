package level1.num138477;

// 필요한 패키지 불러오기
import java.util.PriorityQueue;

// Solution 클래스 정의
public class Solution {

	// solution() 메서드 정의
	public static int[] solution(int k, int[] score) {
		
		// 명예의 전당의 최하위 점수를 저장할 배열 lowestScores 초기화
		int[] lowestScores = new int[score.length];
		
		// 점수를 오름차순으로 정렬할 PriorityQueue 객체 rankingMaker 초기화
		PriorityQueue<Integer> rankingMaker = new PriorityQueue<>();
		
		// for 반복문을 사용해 각 날짜를 순회
		for (int idx = 0; idx < score.length; idx++) {
			
			// offer() 메서드를 사용해 해당 점수를 rankingMaker에 추가
			rankingMaker.offer(score[idx]);
			
			// 명예의 전당의 목록이 정해진 순위보다 많아진 경우 최하위 점수를 제거
			if (rankingMaker.size() > k)
				rankingMaker.poll();
			
			// peek() 메서드를 사용해 현재 명예의 전당의 최하위 점수를 배열 lowestScores에 저장
			lowestScores[idx] = rankingMaker.peek();
		}
		
		// 명예의 전당의 최하위 점수를 저장한 배열 반환
		return lowestScores;
    }
}