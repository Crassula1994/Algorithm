package silver5.num04659;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

// Main 클래스 정의
public class Main {
	
	// 모음 알파벳을 저장할 Set 객체 vowels 초기화
	static Set<Character> vowels = new HashSet<>();
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// add() 메서드를 사용해 모음 알파벳을 vowels에 추가
		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');
		
		// while 반복문을 사용해 각 패스워드를 순회
		while (true) {
			
			// readLine() 메서드를 사용해 입력 받은 패스워드를 변수 password에 할당
			String password = in.readLine();
			
			// 패스워드로 'end'가 입력된 경우 반복문 탈출
			if (password.equals("end"))
				break;
			
			// passwordChecker() 메서드를 호출해 해당 패스워드의 품질을 변수 isAcceptable에 할당
			boolean isAcceptable = passwordChecker(password);
			
			// 패스워드의 품질이 좋은 경우 해당 패스워드의 품질을 출력
			if (isAcceptable) {
				out.write("<" + password + "> is acceptable.");
				
			// 패스워드의 품질이 나쁜 경우 해당 패스워드의 품질을 출력
			} else {
				out.write("<" + password + "> is not acceptable.");
			}
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// passwordChecker() 메서드 정의
	public static boolean passwordChecker(String password) {
		
		// 모음의 총 개수, 연속된 모음과 자음의 개수를 저장할 각 변수 초기화
		int vowelSum = 0;
		int vowelCnt = 0;
		int consonantCnt = 0;
		
		// for 반복문을 사용해 패스워드의 각 알파벳을 순회
		for (int idx = 0; idx < password.length(); idx++) {
			
			// charAt() 메서드를 사용해 해당 알파벳을 변수 alphabet에 할당
			char alphabet = password.charAt(idx);
			
			// 해당 알파벳이 모음인 경우 모음의 총 개수, 연속된 모음과 자음의 개수를 갱신
			if (vowels.contains(alphabet)) {
				vowelSum++;
				vowelCnt++;
				consonantCnt = 0;
				
			// 해당 알파벳이 자음인 경우 연속된 모음과 자음의 개수를 갱신
			} else {
				vowelCnt = 0;
				consonantCnt++;
			}
			
			// 모음 또는 자음이 3개 연속으로 오는 경우 false 반환
			if (vowelCnt == 3 || consonantCnt == 3)
				return false;
			
			// 두 번째 알파벳 이상이고, 이전 알파벳과 연속으로 같은 알파벳이 오는 경우
			if (idx > 0 && alphabet == password.charAt(idx - 1)) {
				
				// 해당 알파벳이 'e'나 'o'인 경우 다음 알파벳을 순회
				if (alphabet == 'e' || alphabet == 'o')
					continue;
				
				// false 반환
				return false;
			}
		}
		
		// 모음이 한 글자도 포함되지 않은 경우 false 반환
		if (vowelSum == 0)
			return false;
		
		// 모든 규칙을 만족하는 경우 true를 반환
		return true;
	}
}