package level2.num042626;

// 필요한 패키지 불러오기
import java.util.PriorityQueue;

// Solution 클래스 정의
public class Solution {
	
	// solution() 메서드 정의
	public static int solution(int[] scoville, int K) {

		// 스코빌 지수를 오름차순으로 정렬할 PriorityQueue 객체 scovilleList 초기화
		PriorityQueue<Integer> scovilleList = new PriorityQueue<>();
        
		// for 반복문을 사용해 입력 받은 스코빌 지수를 scovilleList에 저장
        for (int idx = 0; idx < scoville.length; idx++)
            scovilleList.offer(scoville[idx]);
        
        // 모든 음식의 스코빌 지수를 일정 값 이상으로 올릴 수 있는지 여부, 섞어야 하는 최소 횟수를 저장할 각 변수 초기화
        boolean canIncrease = false;
        int minCnt = 0;
        
        // while 반복문을 사용해 1개의 음식이 남을 때까지 순회
        while (scovilleList.size() > 1) {
            
        	// 가장 맵지 않은 음식이 원하는 스코빌 지수 이상인 경우
            if (scovilleList.peek() >= K) {
            	
            	// 모든 음식의 스코빌 지수를 일정 값 이상으로 올릴 수 있는지 여부를 갱신 후 반복문 탈출
                canIncrease = true;
                break;
            }
            
            // poll() 및 offer() 메서드를 사용해 음식을 섞어 새로운 음식을 scovilleList에 추가
            scovilleList.offer(scovilleList.poll() + scovilleList.poll() * 2);
            
            // 섞어야 하는 최소 횟수를 갱신
            minCnt++;
        }
        
        // 마지막 남은 1개의 음식이 원하는 스코빌 지수 이상인 경우 모든 음식의 스코빌 지수를 일정 값 이상으로 올릴 수 있는지 여부를 갱신
        if (scovilleList.peek() >= K)
            canIncrease = true;
        
        // 모든 음식의 스코빌 지수를 일정 값 이상으로 올릴 수 없는 경우 섞어야 하는 최소 횟수를 -1로 변경
        if (!canIncrease)
        	minCnt = -1;
        
        // 섞어야 하는 최소 횟수를 출력
        return minCnt;
	}
}