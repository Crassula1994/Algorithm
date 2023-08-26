package level2.num138476;

// 필요한 패키지 불러오기
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// Solution 클래스 정의
public class Solution {
	
	// solution() 메서드 정의
	public static int solution(int k, int[] tangerine) {
		
		// 크기가 서로 다른 종류의 귤의 개수 최솟값을 저장할 변수 minCnt 초기화
		int minCnt = 0;

		// 크기별 귤의 개수를 저장할 Map 객체 counter 초기화
		Map<Integer, Integer> counter = new HashMap<>();
		
		// 크기별 귤의 개수를 내림차순으로 반환할 PriorityQueue 객체 sorter 초기화
		PriorityQueue<Integer> sorter = new PriorityQueue<>((n1, n2) -> {
            return n2 - n1;
        });

		// for 반복문을 사용해 수확한 귤의 정보를 순회
        for (int idx = 0; idx < tangerine.length; idx++) {
            
        	// 해당 귤의 크기를 변수 size에 할당
            int size = tangerine[idx];

            // getOrDefault() 및 put() 메서드를 사용해 귤의 개수를 갱신
            counter.put(size, counter.getOrDefault(size, 0) + 1); 
        }
        
        // for 반복문을 사용해 귤의 크기별 개수를 sorter에 추가
        for (int key : counter.keySet())
        	sorter.offer(counter.get(key));
        
        // while 반복문을 사용해 필요한 귤의 개수가 남지 않을 때까지 순회
        while (k > 0) {
        	
        	// poll() 메서드를 사용해 가장 많은 귤의 개수를 필요한 귤의 개수에서 제거
            k -= sorter.poll();
            
            // 크기가 서로 다른 종류의 귤의 개수 최솟값을 갱신
            minCnt++;
        }
        
        // 크기가 서로 다른 종류의 귤의 개수 최솟값을 반환
        return minCnt;
    }
}