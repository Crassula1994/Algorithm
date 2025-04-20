package gold2.num12889;

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
		
		// readLine() 및 toCharArray() 메서드를 사용해 입력 받은 특별한 문자열을 배열 specialStirng에 할당
		char[] specialString = in.readLine().toCharArray();
		
		// nextStringFinder() 및 write() 메서드를 사용해 해당 특별한 문자열 다음에 오는 특별한 문자열을 출력
		out.write(nextStringFinder(specialString));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// nextStringFinder() 메서드 정의
	public static String nextStringFinder(char[] specialString) {
		
		// 해당 특별한 문자열의 길이를 변수 length에 할당
		int length = specialString.length;
		
		// for 반복문을 사용해 각 문자열의 문자를 거꾸로 순회
		for (int idx = length - 1; idx >= 0; idx--) {
			
			// 해당 문자열의 문자가 1인 경우 다음 문자를 순회
			if (specialString[idx] == '1')
				continue;
			
			// clone() 메서드를 사용해 주어진 문자열의 다음 특별한 문자열을 저장할 배열 nextString 초기화
			char[] nextString = specialString.clone();
			
			// for 반복문을 사용해 이후의 문자를 모두 1로 변경
			for (int nextIdx = idx; nextIdx < length; nextIdx++)
				nextString[nextIdx] = '1';
			
			// 해당 문자열이 특별하지 않은 경우 다음 문자를 순회
			if (!specialChecker(nextString))
				continue;
			
			// for 반복문을 사용해 현재 인덱스 이후의 문자를 순회
			for (int nextIdx = idx + 1; nextIdx < length; nextIdx++) {
				
				// 해당 인덱스의 문자를 0으로 설정
				nextString[nextIdx] = '0';
				
				// 해당 문자열이 특별하지 않은 경우 1으로 다시 변경
				if (!specialChecker(nextString))
					nextString[nextIdx] = '1';
			}
			
			// 주어진 문자열의 다음 특별한 문자열을 반환
			return new String(nextString);
		}
		
		// 해당 문자열이 해당 길이를 가진 특별한 문자열 중 마지막 문자열인 경우 '-1'을 반환
		return "-1";
	}
	
	// ----------------------------------------------------------------------------------------------------

	// specialChecker() 메서드 정의
	public static boolean specialChecker(char[] string) {
		
		// for 반복문을 사용해 각 부분 문자열 쌍의 구분 위치를 순회
		for (int idx = 1; idx < string.length; idx++) {
			
			// 각 부분 문자열을 각 변수에 할당
			String leftString = new String(string, 0, idx);
			String rightString = new String(string, idx, string.length - idx);
			
			// 왼쪽 문자열이 사전순으로 앞서지 않는 경우 false 반환
			if (leftString.compareTo(rightString) >= 0)
				return false;
		}
		
		// 주어진 문자열이 특별한 문자열인 경우 true 반환
		return true;
	}
}