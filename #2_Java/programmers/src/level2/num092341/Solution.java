package level2.num092341;

// 필요한 패키지 불러오기
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Solution 클래스 정의
public class Solution {
	
	// solution() 메서드 정의
	public static int[] solution(int[] fees, String[] records) {

		// 각 차량별 마지막 기록 시간, 총 주차 시간을 저장할 각 Map 객체 초기화
		Map<String, Integer> lastRecords = new HashMap<>();
		Map<String, Integer> totalTime = new HashMap<>();
		
		// 차 번호 순서대로 정렬할 PriorityQueue 객체 carSorter 초기화
		PriorityQueue<String> carSorter = new PriorityQueue<>();
		
		// for 반복문을 사용해 각 입, 출차 기록을 순회
		for (int idx = 0; idx < records.length; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(records[idx]);
			
			// nextToken() 메서드를 사용해 기록의 각 정보를 각 변수에 할당
			String timeStr = st.nextToken();
			String carNum = st.nextToken();
			String category = st.nextToken();
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(timeStr, ":");
			
			// parseInt() 및 nextToken() 메서드를 사용해 시간을 분으로 환산하고 변수 time에 저장
			int time = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
			
			// 입차인 경우 마지막 기록 시간을 갱신
			if (category.equals("IN")) {
				lastRecords.put(carNum, time);
				
			// 출차인 경우
			} else {
				
				// get() 메서드를 사용해 마지막 입차 시간을 변수 inTime에 할당
				int inTime = lastRecords.get(carNum);
				
				// getOrDefault() 및 put() 메서드를 사용해 총 주차 시간을 갱신
				totalTime.put(carNum, totalTime.getOrDefault(carNum, 0) + time - inTime);
				
				// put() 메서드를 사용해 입차 시간을 0으로 초기화
				lastRecords.put(carNum, 0);
			}
		}
		
		// for 반복문을 사용해 각 차량을 순회
		for (String carNum : lastRecords.keySet()) {
			
			// offer() 메서드를 사용해 해당 차량 번호를 carSorter에 추가
			carSorter.offer(carNum);
			
			// get() 메서드를 사용해 마지막 입차 시간을 변수 inTime에 할당
			int inTime = lastRecords.get(carNum);
			
			// 해당 차량이 마지막으로 출차되지 않은 경우 총 주차 시간을 갱신
			if (inTime != 0)
				totalTime.put(carNum, totalTime.getOrDefault(carNum, 0) + 1439 - inTime);
		}
		
		// 주차 요금을 저장할 배열의 인덱스를 나타낼 변수 index 초기화
		int index = 0;
		
		// size() 메서드를 사용해 차량별 주차 요금을 저장할 배열 costs 초기화
		int[] costs = new int[carSorter.size()];
		
		// while 반복문을 사용해 carSorter가 빌 때까지 순회
		while (!carSorter.isEmpty()) {
			
			// 해당 차량의 주차 요금을 저장할 변수 totalCost 초기화
			int totalCost = fees[1];
			
			// poll() 메서드를 사용해 해당 차량 번호를 변수 carNum에 할당
			String carNum = carSorter.poll();
			
			// get() 메서드를 사용해 해당 차량의 이용 시간을 변수 time에 할당
			int time = totalTime.get(carNum);
			
			// 기본 시간을 초과한 경우
			if (time > fees[0]) {
				
				// 기본 시간을 제외 처리
				time -= fees[0];
				
				// 단위 시간의 청구 횟수를 계산해 변수 unitCount에 할당
				int unitCount = (time % fees[2] == 0) ? time / fees[2] : time / fees[2] + 1;
				
				// 해당 차량의 주차 요금을 최종 갱신
				totalCost += unitCount * fees[3];
			}
			
			// 해당 차량의 주차 요금을 저장 후 인덱스 갱신
			costs[index] = totalCost;
			index++;
		}

        // 차량별 주차 요금의 배열을 반환
        return costs;
    }
}