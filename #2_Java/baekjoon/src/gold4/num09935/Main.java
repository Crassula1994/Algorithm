package gold4.num09935;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// Main 클래스 정의
public class Main {

	// 폭발 문자열이 있는지를 확인하기 위한 Stack 객체 stringChecker 초기화
	static Stack<Character> stringChecker = new Stack<>();
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 메서드를 사용해 입력 받은 문자열과 폭발 문자열을 각 변수에 할당
		String originalStr = in.readLine();
		String explosive = in.readLine();
		
		// length() 및 charAt() 메서드를 사용해 입력 받은 폭발 문자열의 마지막 문자를 변수 checkChar에 할당
		char checkChar = explosive.charAt(explosive.length() - 1);

		// for 반복문을 사용해 입력 받은 문자열의 각 문자를 순회
		for (int idx = 0; idx < originalStr.length(); idx++) {
			
			// charAt() 및 push() 메서드를 사용해 입력 받은 문자를 stringChecker에 저장
			stringChecker.push(originalStr.charAt(idx));
			
			// 입력 받은 문자가 폭발 문자열의 마지막 문자열과 같고 폭발 문자열인 경우
			if (stringChecker.peek() == checkChar && explosiveChecker(explosive)) {
				
				// for 반복문을 사용해 폭발 문자열을 제거
				for (int len = 0; len < explosive.length(); len++)
					stringChecker.pop();
			}
		}
		
		// 남아 있는 문자가 없는 경우 'FRULA' 출력
		if (stringChecker.isEmpty()) {
			out.write("FRULA");
			
		// 남아 있는 문자가 있는 경우
		} else {
			
			// 남은 문자열을 저장할 StringBuilder 객체 remainStr 초기화
			StringBuilder remainStr = new StringBuilder();
			
			// while 반복문을 사용해 남은 문자열을 뒤집힌 채로 remainStr에 저장
			while (!stringChecker.isEmpty())
				remainStr.append(stringChecker.pop());
			
			// reverse(), toString(), write() 메서드를 사용해 남은 문자열을 출력
			out.write(remainStr.reverse().toString());
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// explosiveChecker() 메서드 정의
	public static boolean explosiveChecker(String explosive) {
		
		// 폭발 문자열의 길이보다 저장된 문자열의 길이가 작은 경우 false 반환
		if (stringChecker.size() < explosive.length())
			return false;
		
		// for 반복문을 사용해 폭발 문자열의 길이만큼의 문자열을 순회
		for (int idx = 0; idx < explosive.length(); idx++) {
			
			// 해당 문자가 폭발 문자열의 문자와 일치하지 않는 경우 false 반환
			if (stringChecker.get(stringChecker.size() - explosive.length() + idx) != explosive.charAt(idx))
				return false;
		}
		
		// 해당 문자열이 폭발 문자열인 경우 true 반환
		return true;
	}
}