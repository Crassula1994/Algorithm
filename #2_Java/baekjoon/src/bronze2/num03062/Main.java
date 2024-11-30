package bronze2.num03062;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// readLine() 메서드를 사용해 입력 받은 원래 숫자를 변수 originNumStr에 할당
			String originNumStr = in.readLine();
			
			// reverse() 및 toString() 메서드를 사용해 원래 숫자를 뒤집은 결과를 변수 reversedNumStr에 할당
			String reversedNumStr = new StringBuilder(originNumStr).reverse().toString();
			
			// parseInt() 및 valueOf() 메서드를 사용해 원래 수와 뒤집은 수를 합한 수를 변수 sumStr에 할당
			String sumStr = String.valueOf(Integer.parseInt(originNumStr) + Integer.parseInt(reversedNumStr));
			
			// numStrChecker() 및 write() 메서드를 사용해 뒤집은 수를 합한 수가 좌우 대칭인지 여부를 출력
			out.write((numStrChecker(sumStr)) ? "YES" : "NO");
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// numStrChecker() 메서드 정의
	public static boolean numStrChecker(String sumStr) {
		
		// for 반복문을 사용해 각 숫자의 자릿수를 순회
		for (int idx = 0; idx < sumStr.length() / 2; idx++) {
			
			// 해당 자릿수의 숫자가 좌우 대칭이 아닌 경우 false 반환
			if (sumStr.charAt(idx) != sumStr.charAt(sumStr.length() - idx - 1))
				return false;
		}
		
		// 해당 숫자가 좌우 대칭인 경우 true 반환
		return true;
	}
}