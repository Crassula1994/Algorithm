package level2.num042583;

// 필요한 패키지 불러오기
import java.util.LinkedList;
import java.util.Queue;

// Solution 클래스 정의
public class Solution {
	
	// solution() 메서드 정의
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		
		// 모든 트럭이 통과하는 데 필요한 시간, 다리에 진입한 트럭의 수, 현재 다리의 무게를 저장할 각 변수 초기화
		int time = 0;
        int truckNum = 0;
        int totalWeight = 0;
        
        // 현재 다리의 상태를 저장할 Queue 객체 bridge 초기화
        Queue<Integer> bridge = new LinkedList<>();
        
        // for 반복문을 사용해 현재 다리의 상태를 초기화
        for (int idx = 0; idx < bridge_length; idx++)
            bridge.offer(0);
        
        // while 반복문을 사용해 모든 트럭이 다리에 진입할 때까지 순회
        while (truckNum < truck_weights.length) {
        	
        	// 다음에 진입할 트럭을 변수 nextTruck에 할당
            int nextTruck = truck_weights[truckNum];
        	
        	// 트럭이 지나기 위한 시간을 갱신
            time++;
        	
        	// poll() 메서드를 사용해 다리에서 빠져 나온 트럭의 무게를 현재 다리의 무게에서 제거
            totalWeight -= bridge.poll();

            // 다음에 진입할 트럭이 무게 때문에 진입하지 못하는 경우
            if (totalWeight + nextTruck > weight) {
            	
            	// offer() 메서드를 사용해 트럭이 진입하지 않은 것으로 처리
                bridge.offer(0);
            
            // 다음에 진입할 트럭이 진입할 수 있는 경우
            } else {
            	
            	// offer() 메서드를 사용해 다리에 진입한 것으로 처리
            	bridge.offer(nextTruck);
            	
            	// 현재 다리의 무게 및 다리에 진입한 트럭의 수 갱신
            	totalWeight += nextTruck;
                truckNum++;
            }
        }
        
        // 마지막에 진입한 트럭이 다리를 통과할 때까지 필요한 시간을 갱신
        time += bridge_length;
        
        // 모든 트럭이 통과하는 데 필요한 시간을 반환
        return time;
    }
}