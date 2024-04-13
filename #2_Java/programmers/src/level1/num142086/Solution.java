package level1.num142086;

// Solution 클래스 정의
public class Solution {
	
	// solution() 메서드 정의
	public static int[] solution(String s) {
		
		// length() 메서드를 사용해 각 알파벳이 등장한 마지막 위치, 가장 가까운 글자의 위치를 저장할 각 배열 초기화
		int[] alphabets = new int[26];
		int[] proximations = new int[s.length()];
		
		// for 반복문을 사용해 문자열의 각 글자를 순회
		for (int idx = 0; idx < s.length(); idx++) {
			
			// charAt() 메서드를 사용해 입력 받은 알파벳을 변수 alphabet에 할당
			int alphabet = s.charAt(idx) - 'a';
			
			// 해당 알파벳이 등장한 적 없는 경우 가장 가까운 글자의 위치를 갱신
			if (alphabets[alphabet] == 0) {
				proximations[idx] = -1;
			
			// 해당 알파벳이 등장한 적 있는 경우 가장 가까운 글자의 위치를 갱신
			} else {
				proximations[idx] = idx - alphabets[alphabet] + 1;
			}
			
			// 해당 알파벳이 등장한 마지막 위치를 갱신
			alphabets[alphabet] = idx + 1;
		}
		
		// 가장 가까운 글자의 위치를 저장한 배열 반환
		return proximations;
    }
}