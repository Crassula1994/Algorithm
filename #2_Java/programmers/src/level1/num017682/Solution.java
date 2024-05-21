package level1.num017682;

// Solution 클래스 정의
public class Solution {

	// solution() 메서드 정의
	public static int solution(String dartResult) {
		
		// 각 기회에 얻은 점수를 저장할 배열 scores 초기화
		int[] scores = new int[4];
		
		// for 반복문을 사용해 각 기회를 순회
		for (int chance = 1, index = 0; chance <= 3; chance++) {
			
			// charAt() 메서드를 사용해 점수와 보너스를 각 변수에 할당
			int score = (dartResult.charAt(index + 1) == '0') ? 10 : dartResult.charAt(index) - '0';
			char bonus = (score == 10) ? dartResult.charAt(index + 2) : dartResult.charAt(index + 1);
			
			// switch 조건문을 사용해 보너스에 따라 해당 기회의 점수를 배열 scores에 저장
			switch (bonus) {
				case 'S':
					scores[chance] = score;
					break;
				case 'D':
					scores[chance] = score * score;
					break;
				default:
					scores[chance] = score * score * score;
			}
			
			// 옵션이 존재할 수 있는 인덱스의 위치를 계산해 변수 optionIndex에 할당
			int optionIndex = (score == 10) ? index + 3 : index + 2;
			
			// 옵션이 존재하는 경우
			if (optionIndex < dartResult.length() && dartResult.charAt(optionIndex) - '0' < 0) {
				
				// charAt() 메서드를 사용해 옵션을 변수 option에 할당
				char option = dartResult.charAt(optionIndex);
				
				// 스타상인 경우 점수를 갱신
				if (option == '*') {
					scores[chance - 1] *= 2;
					scores[chance] *= 2;
					
				// 아차상인 경우 점수를 갱신
				} else {
					scores[chance] *= -1;
				}
				
				// 다음에 확인할 인덱스를 갱신
				index++;
			}
			
			// 다음에 확인할 인덱스를 갱신
			index = (score == 10) ? index + 3 : index + 2;
		}
		
		// 다트 점수 합계를 계산해 변수 totalScore에 할당
		int totalScore = scores[1] + scores[2] + scores[3];
		
		// 다트 점수 합계를 반환
		return totalScore;
	}
}