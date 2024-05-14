package silver2.num01254;

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
		
		// readLine() 메서드를 사용해 입력 받은 문자열을 변수 string에 할당
		String string = in.readLine();
		
		// length() 메서드를 사용해 동호가 만들 수 있는 가장 짧은 팰린드롬의 길이를 저장할 변수 minLength 초기화
		int minLength = string.length();
		
		// for 반복문을 사용해 각 부분 문자열을 순회
		for (int idx = 0; idx < string.length(); idx++) {
			
			// substring() 메서드를 사용해 각 부분 문자열을 변수 subString에 할당
			String subString = string.substring(idx);
			
			// 해당 부분 문자열이 팰린드롬인 경우 동호가 만들 수 있는 가장 짧은 팰린드롬의 길이를 갱신 후 반복문 탈출
			if (palindromeChecker(subString)) {
				minLength += string.length() - subString.length();
				break;
			}
		}

		// valueOf() 및 write() 메서드를 사용해 동호가 만들 수 있는 가장 짧은 팰린드롬의 길이를 출력
		out.write(String.valueOf(minLength));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// palindromeChecker() 메서드 정의
	public static boolean palindromeChecker(String subString) {
		
		// length() 메서드를 사용해 비교할 각 부분 문자열의 인덱스를 저장할 각 변수 초기화
		int left = 0;
		int right = subString.length() - 1;
		
		// while 반복문을 사용해 각 부분 문자열을 모두 확인할 때까지 순회
		while (left < right) {
			
			// 두 문자가 다른 경우 팰린드롬이 아니므로 false 반환
			if (subString.charAt(left++) != subString.charAt(right--))
				return false;
		}
		
		// 해당 부분 문자열이 팰린드롬인 경우 true 반환
		return true;
	}
}