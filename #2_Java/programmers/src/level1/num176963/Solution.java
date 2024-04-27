package level1.num176963;

// 필요한 패키지 불러오기
import java.util.HashMap;
import java.util.Map;

// Solution 클래스 정의
public class Solution {

	// solution() 메서드 정의
	public static int[] solution(String[] name, int[] yearning, String[][] photo) {
		
		// 사진들의 추억 점수를 저장할 배열 scores 초기화
		int[] scores = new int[photo.length];
		
		// 각 인물의 그리움 점수를 저장할 Map 객체 personScores 초기화
		Map<String, Integer> personScores = new HashMap<>();
		
		// for 반복문을 사용해 각 인물의 그리움 점수를 personScores에 저장
		for (int idx = 0; idx < name.length; idx++)
			personScores.put(name[idx], yearning[idx]);
		
		// for 반복문을 사용해 각 사진을 순회
		for (int idx = 0; idx < photo.length; idx++) {
			
			// 해당 사진을 배열 picture에 할당
			String[] picture = photo[idx];
			
			// for 반복문을 사용해 해당 사진의 추억 점수를 갱신
			for (int person = 0; person < picture.length; person++)
				scores[idx] += personScores.getOrDefault(picture[person], 0);
		}
		
		// 사진들의 추억 점수를 저장한 배열 반환
		return scores;
    }
}