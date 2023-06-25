package bronze1.num28255;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// readLine() 메서드를 사용해 입력 받은 문자열을 변수 string에 할당
			String string = in.readLine();
			
			// length() 메서드를 사용해 접두사의 길이를 변수 length에 할당
			int length = (string.length() % 3 == 0) ? string.length() / 3 : string.length() / 3 + 1;
			
			// substring() 및 reverse() 메서드를 사용해 접두사와 그 변형 형태를 각 변수에 할당
			String prefix = string.substring(0, length);
			String revPrefix = reverse(prefix);
			String tailRevPrefix = revPrefix.substring(1);
			String tailPrefix = prefix.substring(1);
			
			// 3단 아이스크림 문자열인 경우를 각 변수에 할당
			String case1 = prefix + revPrefix + prefix;
			String case2 = prefix + tailRevPrefix + prefix;
			String case3 = prefix + revPrefix + tailPrefix;
			String case4 = prefix + tailRevPrefix + tailPrefix;
			
			// 해당 문자열이 3단 아이스크림 문자열인 경우 1 출력
			if (string.equals(case1) || string.equals(case2) || string.equals(case3) || string.equals(case4)) {
				out.write(String.valueOf(1));
				
			// 해당 문자열이 3단 아이스크림 문자열이 아닌 경우 0 출력
			} else {
				out.write(String.valueOf(0));
			}
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// reverse() 메서드 정의
	public static String reverse(String string) {
		
		// StringBuilder 객체를 불러와 변수 sb에 할당
		StringBuilder sb = new StringBuilder(string);
		
		// 입력 받은 문자열을 뒤집은 결과를 반환
		return sb.reverse().toString();
	}
}