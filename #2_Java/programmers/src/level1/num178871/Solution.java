package level1.num178871;

// 필요한 패키지 불러오기
import java.util.HashMap;
import java.util.Map;

// Solution 클래스 정의
public class Solution {
	
	// solution() 메서드 정의
	public static String[] solution(String[] players, String[] callings) {
		
		// 각 선수의 현재 등수를 저장할 Map 객체 ranking 초기화
		Map<String, Integer> ranking = new HashMap<>();
		
		// for 반복문을 사용해 각 선수의 등수를 ranking에 저장
		for (int idx = 0; idx < players.length; idx++)
			ranking.put(players[idx], idx);
		
		// for 반복문을 사용해 각 해설진이 부른 이름을 순회
		for (String curPlayer : callings) {
			
			// get() 메서드를 사용해 해당 선수의 현재 등수를 변수 curRank에 할당
			int curRank = ranking.get(curPlayer);
			
			// 해당 선수 바로 앞의 선수명을 변수 prePlayer에 할당
			String prePlayer = players[curRank - 1];
			
			// 현재 선수가 앞의 선수를 앞질렀으므로 현재 등수를 갱신
			players[curRank - 1] = curPlayer;
			players[curRank] = prePlayer;
			
			// replace() 메서드를 사용해 각 선수의 등수를 갱신
			ranking.replace(curPlayer, curRank - 1);
			ranking.replace(prePlayer, curRank);
		}
		
		// 해설진의 호명이 끝난 후 현재의 등수를 저장한 배열 반환
        return players;
    }
}