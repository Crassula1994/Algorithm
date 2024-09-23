package bronze1.num32357;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 문자열의 개수를 변수 stringNum에 할당
		int stringNum = Integer.parseInt(in.readLine());
		
		// 팰린드롬인 문자열의 개수를 저장할 변수 count 초기화
		int count = 0;
		
		// while 반복문을 사용해 각 문자열을 순회
		while (stringNum-- > 0) {
			
			// readLine() 메서드를 사용해 입력 받은 문자열을 변수 string에 할당
			String string = in.readLine();
			
			// 해당 문자열이 팰린드롬인 경우 팰린드롬인 문자열의 개수를 갱신
			if (palindromeChecker(string))
				count++;
		}
		
		// valueOf() 및 write() 메서드를 사용해 더블팰린드롬 현상을 일으킬 수 있는 쌍의 개수를 출력
		out.write(String.valueOf(count * (count - 1)));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// palindromeChecker() 메서드 정의
	public static boolean palindromeChecker(String string) {
		
		// for 반복문을 사용해 문자열의 절반을 순회
		for (int idx = 0; idx < string.length() / 2; idx++) {
			
			// 해당 문자열이 팰린드롬이 아닌 경우 false 반환
			if (string.charAt(idx) != string.charAt(string.length() - idx - 1))
				return false;
		}
		
		// 해당 문자열이 팰린드롬인 경우 true 반환
		return true;
	}
}