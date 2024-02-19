package level1.num012917;

// Solution 클래스 정의
public class Solution {

	// solution() 메서드 정의
	public static String solution(String s) {
		
		// StringBuilder 객체를 불러와 변수 sb에 할당
		StringBuilder sb = new StringBuilder();
		
		// 각 소문자와 대문자의 개수를 저장할 2차원 배열 alphabets 초기화
		int[][] alphabets = new int[2][26];
		
		// for 반복문을 사용해 문자열의 각 글자를 순회
		for (int idx = 0; idx < s.length(); idx++) {
			
			// charAt() 메서드를 사용해 해당 알파벳을 변수 alphabet에 할당
			char alphabet = s.charAt(idx);
			
			// 해당 알파벳이 대문자인 경우 해당 알파벳의 개수를 갱신
			if (alphabet < 97) {
				alphabets[1][alphabet - 'A']++;
			
			// 해당 알파벳이 소문자인 경우 해당 알파벳의 개수를 갱신
			} else {
				alphabets[0][alphabet - 'a']++;
			}
		}
		
		// for 반복문을 사용해 각 소문자 알파벳을 순회
		for (int idx = 25; idx >= 0; idx--) {
			
			// 해당 알파벳과 알파벳의 개수를 각 변수에 할당
			char alphabet = (char) (idx + 97);
			int count = alphabets[0][idx];
			
			// for 반복문을 사용해 해당 알파벳을 sb에 추가
			for (int c = 0; c < count; c++)
				sb.append(alphabet);
		}
		
		// for 반복문을 사용해 각 대문자 알파벳을 순회
		for (int idx = 25; idx >= 0; idx--) {
			
			// 해당 알파벳과 알파벳의 개수를 각 변수에 할당
			char alphabet = (char) (idx + 65);
			int count = alphabets[1][idx];
			
			// for 반복문을 사용해 해당 알파벳을 sb에 추가
			for (int c = 0; c < count; c++)
				sb.append(alphabet);
		}
		
		// toString() 메서드를 사용해 문자열을 내림차순으로 정렬한 문자열을 반환
		return sb.toString();
    }
}