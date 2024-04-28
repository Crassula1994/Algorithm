package level1.num159994;

// Solution 클래스 정의
public class Solution {

	// solution() 메서드 정의
	public static String solution(String[] cards1, String[] cards2, String[] goal) {
		
		// 각 문자열로 목표 문자열을 만들 수 있는지 여부를 저장할 변수 isPossible 초기화
		boolean isPossible = true;
		
		// 확인할 두 문자열 카드 뭉치의 인덱스를 저장할 각 변수 초기화
		int index1 = 0;
		int index2 = 0;
		
		// for 반복문을 사용해 목표 문자열의 각 단어를 순회
		for (int idx = 0; idx < goal.length; idx++) {
			
			// 목표 문자열의 단어와 각 문자열 카드의 단어를 각 변수에 할당
			String goalWord = goal[idx];
			String word1 = (index1 < cards1.length) ? cards1[index1] : "";
			String word2 = (index2 < cards2.length) ? cards2[index2] : "";
			
			// 첫 번째 카드 뭉치에 목표 문자열의 단어가 있는 경우 첫 번째 카드 뭉치의 인덱스를 갱신
			if (goalWord.equals(word1)) {
				index1++;
			
			// 두 번째 카드 뭉치에 목표 문자열의 단어가 있는 경우 두 번째 카드 뭉치의 인덱스를 갱신
			} else if (goalWord.equals(word2)) {
				index2++;
			
			// 어느 카드 뭉치에도 목표 문자열의 단어가 없는 경우 목표 문자열을 만들 수 있는지 여부를 갱신 후 반복문 탈출
			} else {
				isPossible = false;
				break;
			}
		}
		
		// 각 문자열로 목표 문자열을 만들 수 있는지에 따라 'Yes' 또는 'No'를 반환
		return (isPossible) ? "Yes" : "No";
    }
}