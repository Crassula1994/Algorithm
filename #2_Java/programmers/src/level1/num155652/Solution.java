package level1.num155652;

// Solution 클래스 정의
public class Solution {

	// solution() 메서드 정의
	public static String solution(String s, String skip, int index) {
		
		// StringBuilder 객체를 불러와 변수 sb에 할당
		StringBuilder sb = new StringBuilder();
		
		// 각 알파벳을 암호에 사용할 수 있는지 여부 및 각 알파벳을 변환한 결과를 저장할 각 배열 초기화
		boolean[] alphabets = new boolean[26];
		char[] codes = new char[26];
		
		// for 반복문을 사용해 암호에 사용할 수 없는 알파벳을 배열 alphabets에 갱신
		for (int idx = 0; idx < skip.length(); idx++)
			alphabets[skip.charAt(idx) - 'a'] = true;
		
		// for 반복문을 사용해 각 알파벳을 순회
		for (int idx = 0; idx < 26; idx++) {
			
			// 해당 알파벳이 암호에 사용할 수 없는 알파벳인 경우 다음 알파벳을 순회
			if (alphabets[idx])
				continue;
			
			// 현재 확인 중인 알파벳의 위치와 해당 알파벳으로부터 떨어진 거리를 저장할 각 변수 초기화
			int curIndex = idx;
			int distance = 0;
			
			// while 반복문을 사용해 원하는 거리의 알파벳을 찾을 때까지 순회
			while (distance < index) {
				
				// 현재 확인 중인 알파벳의 위치를 갱신
				curIndex++;
				curIndex %= 26;
				
				// 현재 확인 중인 알파벳이 암호에 사용할 수 없는 알파벳인 경우 다음 알파벳을 순회
				if (alphabets[curIndex])
					continue;
				
				// 해당 알파벳으로부터 떨어진 거리를 갱신
				distance++;
			}
			
			// 해당 알파벳을 변환한 결과를 배열 codes에 저장
			codes[idx] = (char) (curIndex + 97);
		}
		
		// for 반복문을 사용해 문자열의 각 알파벳을 변환한 결과를 sb에 저장
		for (int idx = 0; idx < s.length(); idx++)
			sb.append(codes[s.charAt(idx) - 'a']);
		
		// toString() 메서드를 사용해 문자열을 변환한 결과를 반환
		return sb.toString();
	}
}