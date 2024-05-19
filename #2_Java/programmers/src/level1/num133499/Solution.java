package level1.num133499;

// 필요한 패키지 불러오기
import java.util.Stack;

// Solution 클래스 정의
public class Solution {

	// solution() 메서드 정의
	public static int solution(String[] babbling) {
		
		// 머쓱이의 조카가 발음할 수 있는 단어의 개수를 저장할 변수 count 초기화
		int count = 0;
		
		// for 반복문을 사용해 머쓱이의 조카가 발음할 수 있는 단어의 개수를 갱신
		for (int idx = 0; idx < babbling.length; idx++)
			count = (wordChecker(babbling[idx])) ? count + 1 : count;
		
		// 머쓱이의 조카가 발음할 수 있는 단어의 개수를 반환
		return count;
	}

	// ----------------------------------------------------------------------------------------------------
	
	// wordChecker() 메서드 정의
	public static boolean wordChecker(String word) {
		
		// 이전에 나온 단어를 저장할 Stack 객체 prevWord 초기화
		Stack<Character> prevWord = new Stack<>();
		
		// 현재 확인하고 있는 단어의 인덱스를 나타낼 변수 index 초기화
		int index = 0;
		
		// while 반복문을 사용해 단어의 모든 글자를 확인할 때까지 순회
		while (index < word.length()) {
			
			// charAt() 메서드를 사용해 해당 단어의 글자를 변수 alphabet에 할당
			char alphabet = word.charAt(index);
			
			// switch 조건문을 사용해 각 알파벳에 따라 단어를 검사
			switch (alphabet) {
			
				// 'aya'일 가능성이 있는 경우
				case 'a':
					
					// 단어의 길이가 부족한 경우 false 반환
					if (index > word.length() - 3)
						return false;
					
					// 'aya'가 아닌 경우 false 반환
					if (word.charAt(index + 1) != 'y' || word.charAt(index + 2) != 'a')
						return false;
					
					// 확인할 인덱스 갱신 후 조건문 탈출
					index += 3;
					break;
					
				// 'ma'일 가능성이 있는 경우
				case 'm':
					
					// 단어의 길이가 부족한 경우 false 반환
					if (index > word.length() - 2)
						return false;
					
					// 'ma'가 아닌 경우 false 반환
					if (word.charAt(index + 1) != 'a')
						return false;
					
					// 확인할 인덱스 갱신 후 조건문 탈출
					index += 2;
					break;
					
				// 'ye'일 가능성이 있는 경우
				case 'y':
					
					// 단어의 길이가 부족한 경우 false 반환
					if (index > word.length() - 2)
						return false;
					
					// 'ye'가 아닌 경우 false 반환
					if (word.charAt(index + 1) != 'e')
						return false;
					
					// 확인할 인덱스 갱신 후 조건문 탈출
					index += 2;
					break;
					
				// 'woo'일 가능성이 있는 경우
				case 'w':
					
					// 단어의 길이가 부족한 경우 false 반환
					if (index > word.length() - 3)
						return false;
					
					// 'woo'가 아닌 경우 false 반환
					if (word.charAt(index + 1) != 'o' || word.charAt(index + 2) != 'o')
						return false;
					
					// 확인할 인덱스 갱신 후 조건문 탈출
					index += 3;
					break;
					
				// 발음할 수 없는 단어인 경우 false 반환
				default:
					return false;
			}
			
			// 이전에 같은 단어가 나온 경우 false 반환
			if (!prevWord.isEmpty() && prevWord.peek() == alphabet)
				return false;
			
			// push() 메서드를 사용해 해당 단어를 prevWord에 추가
			prevWord.push(alphabet);
		}
		
		// 머쓱이의 조카가 해당 단어를 발음할 수 있는 경우 true 반환
		return true;
	}
}