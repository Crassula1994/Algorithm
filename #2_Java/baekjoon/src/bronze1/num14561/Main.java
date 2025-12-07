package bronze1.num14561;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken(), parseLong(), parseInt() 메서드를 사용해 입력 받은 숫자와 바꿀 진수를 각 변수에 할당
			long number = Long.parseLong(st.nextToken());
			int radix = Integer.parseInt(st.nextToken());
			
			/* toString(), palindromeChecker(), write() 메서드를 사용해 해당 숫자를 주어진 진수로 바꾸었을 때
			회문인지 여부를 출력 */
			out.write(palindromeChecker(Long.toString(number, radix)) ? "1" : "0");
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// palindromeChecker() 메서드 정의
	public static boolean palindromeChecker(String numberString) {
		
		// length() 메서드를 사용해 해당 진수의 자릿수를 변수 length에 할당
		int length = numberString.length();
		
		// for 반복문을 사용해 각 자릿수를 순회
		for (int idx = 0; idx < length / 2; idx++) {
			
			// 해당 자릿수와 대칭인 자릿수의 값이 같지 않은 경우 회문이 아니므로 false 반환
			if (numberString.charAt(idx) != numberString.charAt(length - idx - 1))
				return false;
		}
		
		// 해당 진수가 회문인 경우 true 반환
		return true;
	}
}