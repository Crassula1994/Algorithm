package silver1.num32057;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 각 힌트 및 가능한 문자열을 저장할 각 배열 초기화
	static Hint[] hints;
	static char[] string;
	
	// 가능한 문자열을 저장할 Set 객체 possibleString 초기화
	static Set<String> possibleString = new HashSet<>();
	
	// ----------------------------------------------------------------------------------------------------
	
	// Hint 클래스 정의
	static class Hint {
		
		// 해당 힌트의 부분 문자열이 시작하는 인덱스, 힌트로 주어진 부분 문자열을 저장할 각 변수 초기화
		int startIdx;
		String subString;
		
		// 매개변수를 입력 받는 생성자 정의
		public Hint(int startIdx, String subString) {
			this.startIdx = startIdx;
			this.subString = subString;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 힌트의 개수 및 문자열의 길이를 각 변수에 할당
		int hintNum = Integer.parseInt(st.nextToken());
		int stringLength = Integer.parseInt(st.nextToken());
		
		// 각 힌트를 저장할 배열 hints 초기화
		hints = new Hint[hintNum];
		
		// for 반복문을 사용해 입력 받은 각 힌트의 정보를 순회
		for (int idx = 0; idx < hintNum; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			/* nextToken() 및 parseInt() 메서드를 사용해 해당 힌트의 부분 문자열이 시작하는 인덱스,
			힌트로 주어진 부분 문자열을 각 변수에 할당 */
			int startIdx = Integer.parseInt(st.nextToken()) - 1;
			String subString = st.nextToken();
			
			// 입력 받은 힌트의 정보를 배열 hints에 저장
			hints[idx] = new Hint(startIdx, subString);
		}
		
		// for 반복문을 사용해 틀린 것으로 가정할 각 힌트를 순회
		for (int falseHint = -1; falseHint < hints.length; falseHint++) {
			
			// 가능한 문자열을 저장할 배열 string 초기화
			string = new char[stringLength];
			
			// fill() 메서드를 사용해 해당 문자열을 빈 문자열로 초기화
			Arrays.fill(string, ' ');
			
			// 가능한 문자열을 만들 수 없는 경우 다음 가정을 순회
			if (!hintChecker(falseHint))
				continue;
			
			// add() 메서드를 사용해 가능한 문자열을 possibleString에 추가
			possibleString.add(new String(string));
			
			// 가능한 문자열이 두 개 이상인 경우 반복문 탈출
			if (possibleString.size() >= 2)
				break;
		}
		
		// 가능한 문자열이 존재하지 않는 경우 -1을 출력
		if (possibleString.isEmpty()) {
			out.write(String.valueOf(-1));
			
		// 가능한 문자열이 2개 이상인 경우 -2를 출력
		} else if (possibleString.size() >= 2) {
			out.write(String.valueOf(-2));
			
		// 가능한 문자열이 유일하게 존재하는 경우 해당 문자열을 출력
		} else {
			out.write(possibleString.iterator().next());
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// hintChecker() 메서드 정의
	public static boolean hintChecker(int falseHint) {
		
		// for 반복문을 사용해 각 힌트를 순회
		for (int idx = 0; idx < hints.length; idx++) {
			
			// 해당 힌트를 거짓이라고 상정한 경우 다음 힌트를 순회
			if (idx == falseHint)
				continue;
			
			// 해당 힌트를 변수 hint에 할당
			Hint hint = hints[idx];
			
			// for 반복문을 사용해 해당 부분 문자열의 각 인덱스를 순회
			for (int strIdx = 0; strIdx < hint.subString.length(); strIdx++) {
				
				// charAt() 메서드를 사용해 해당 부분 문자열의 알파벳을 변수 alphabet에 할당
				char alphabet = hint.subString.charAt(strIdx);
				
				// 해당 알파벳을 저장할 인덱스를 계산해 변수 targetIdx에 할당
				int targetIdx = hint.startIdx + strIdx;
				
				// 해당 위치에 해당 알파벳과 다른 알파벳이 이미 존재하는 경우 false 반환
				if (string[targetIdx] != ' ' && string[targetIdx] != alphabet)
					return false;
				
				// 해당 알파벳을 배열 string에 저장
				string[targetIdx] = alphabet;
			}
		}
		
		// for 반복문을 사용해 만들어진 문자열의 각 글자를 순회
		for (char alphabet : string) {
			
			// 빈 문자열이 존재하는 경우 false 반환
			if (alphabet == ' ')
				return false;
		}
		
		// 가능한 문자열이 존재하는 경우 true 반환
		return true;
	}
}