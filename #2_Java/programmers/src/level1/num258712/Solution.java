package level1.num258712;

// 필요한 패키지 불러오기
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// Solution 클래스 정의
public class Solution {
	
	// solution() 메서드 정의
	public static int solution(String[] friends, String[] gifts) {
		
		// 다음 달에 가장 많은 선물을 받는 친구가 받을 선물의 수를 저장할 변수 maxCount 초기화
		int maxCount = 0;
		
		// 각 사람이 다음 달에 받을 선물의 수 및 선물지수를 저장할 각 배열 초기화
		int[] counts = new int[friends.length];
		int[] giftIndex = new int[friends.length];
		
		// 각 사람이 서로 선물을 주고 받은 횟수를 저장할 2차원 배열 giftMatrix 초기화
		int[][] giftMatrix = new int[friends.length][friends.length];
		
		// 각 사람을 나타낼 번호를 저장할 Map 객체 friendNumbers 초기화
		Map<String, Integer> friendNumbers = new HashMap<>();
		
		// for 반복문을 사용해 각 친구의 이름을 번호를 부여하여 friendNumbers에 추가
		for (int idx = 0; idx < friends.length; idx++)
			friendNumbers.put(friends[idx], idx);
		
		// for 반복문을 사용해 선물을 주고 받은 기록을 순회
		for (String gift : gifts) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(gift);
			
			// nextToken() 및 get() 메서드를 사용해 입력 받은 선물을 준 사람과 받은 사람을 각 변수에 할당
			int giver = friendNumbers.get(st.nextToken());
			int receiver = friendNumbers.get(st.nextToken());
			
			// 선물을 주고 받은 횟수를 갱신
			giftMatrix[giver][receiver]++;
			
			// 두 사람의 선물지수를 갱신
			giftIndex[giver]++;
			giftIndex[receiver]--;
		}
		
		// for 반복문을 사용해 두 사람 간의 선물을 주고 받은 횟수를 순회
		for (int f1 = 0; f1 < friends.length - 1; f1++) {
			for (int f2 = f1 + 1; f2 < friends.length; f2++) {
				
				// 첫 번째 사람이 더 많은 선물을 준 경우 첫 번째 사람의 다음 달에 받을 선물의 수를 갱신
				if (giftMatrix[f1][f2] > giftMatrix[f2][f1]) {
					counts[f1]++;
				
				// 두 번째 사람이 더 많은 선물을 준 경우 두 번째 사람의 다음 달에 받을 선물의 수를 갱신
				} else if (giftMatrix[f1][f2] < giftMatrix[f2][f1]) {
					counts[f2]++;
					
				// 서로 선물을 주고 받지 않았거나 주고 받은 수가 같은 경우
				} else {
					
					// 첫 번째 사람의 선물지수가 더 큰 경우 첫 번째 사람의 다음 달에 받을 선물의 수를 갱신
					if (giftIndex[f1] > giftIndex[f2]) {
						counts[f1]++;
						
					// 두 번째 사람의 선물지수가 더 큰 경우 두 번째 사람의 다음 달에 받을 선물의 수를 갱신
					} else if (giftIndex[f1] < giftIndex[f2]) {
						counts[f2]++;
					}
				}
			}
		}
		
		// for 반복문을 사용해 다음 달에 가장 많은 선물을 받는 친구가 받을 선물의 수를 갱신
		for (int count : counts)
			maxCount = Math.max(count, maxCount);
		
		// 다음 달에 가장 많은 선물을 받는 친구가 받을 선물의 수를 반환
		return maxCount;
    }
}