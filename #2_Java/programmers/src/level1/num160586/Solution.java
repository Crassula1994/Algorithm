package level1.num160586;

// 필요한 패키지 불러오기
import java.util.Arrays;

// Solution 클래스 정의
public class Solution {

	// solution() 메서드 정의
	public static int[] solution(String[] keymap, String[] targets) {
		
		// 각 알파벳 및 주어진 문자열을 입력하기 위해 키를 최소로 눌러야 하는 횟수를 저장할 각 배열 초기화
		int[] alphabets = new int[26];
		int[] minCounts = new int[targets.length];
		
		// fill() 메서드를 사용해 각 알파벳을 입력하기 위해 키를 최소로 눌러야 하는 횟수를 초기화
		Arrays.fill(alphabets, Integer.MAX_VALUE);
		
		// for 반복문을 사용해 각 키의 배열을 순회
		for (String keys : keymap) {
			
			// for 반복문을 사용해 해당 키에 할당된 문자를 순회
			for (int idx = 0; idx < keys.length(); idx++) {
				
				// charAt() 메서드를 사용해 해당 알파벳을 변수 alphabet에 할당
				int alphabet = keys.charAt(idx) - 'A';
				
				// min() 메서드를 사용해 해당 알파벳을 입력하기 위해 키를 최소로 눌러야 하는 횟수를 갱신
				alphabets[alphabet] = Math.min(idx + 1, alphabets[alphabet]);
			}
		}
		
		// for 반복문을 사용해 주어진 문자열을 순회
		for (int i = 0; i < targets.length; i++) {
			
			// 해당 문자열을 변수 target에 할당
			String target = targets[i];
			
			// for 반복문을 사용해 각 알파벳을 순회
			for (int j = 0; j < target.length(); j++) {
				
				// charAt() 메서드를 사용해 해당 알파벳을 변수 alphabet에 할당
				int alphabet = target.charAt(j) - 'A';
				
				// 해당 알파벳을 입력할 수 없는 경우 -1을 저장 후 반복문 탈출
				if (alphabets[alphabet] == Integer.MAX_VALUE) {
					minCounts[i] = -1;
					break;
				}
				
				// 해당 문자열을 입력하기 위해 키를 최소로 눌러야 하는 횟수를 갱신
				minCounts[i] += alphabets[alphabet];
			}
		}
		
		// 주어진 문자열을 입력하기 위해 키를 최소로 눌러야 하는 횟수를 저장한 배열 반환
		return minCounts;
	}
}