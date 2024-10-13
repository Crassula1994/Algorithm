package gold5.num01394;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

// Main 클래스 정의
public class Main {
	
	// 암호를 풀기 위해 필요한 횟수를 나눌 제수를 저장할 상수 DIVISOR 초기화
	static final int DIVISOR = 900528;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// readLine() 메서드를 사용해 입력 받은 암호로 사용할 수 있는 문자 및 컴퓨터 암호를 각 변수에 할당
		String passwordCharset = in.readLine();
		String password = in.readLine();
		
		// 암호를 풀기 위한 시도 횟수를 저장할 변수 totalCount 초기화
		int totalCount = 0;
		
		// 각 문자의 위치를 저장할 Map 객체 charsetIdx 초기화
		Map<Character, Integer> charsetIdx = new HashMap<>();
		
		// for 반복문을 사용해 각 암호로 사용할 수 있는 문자의 위치를 charsetIdx에 저장
		for (int idx = 0; idx < passwordCharset.length(); idx++)
			charsetIdx.put(passwordCharset.charAt(idx), idx + 1);
		
		// for 반복문을 사용해 컴퓨터 암호의 각 글자를 순회
		for (char character : password.toCharArray()) {
			
			// length() 및 get() 메서드를 사용해 암호의 각 글자를 만들기 위해 필요한 시도 횟수를 갱신
			totalCount *= passwordCharset.length();
			totalCount += charsetIdx.get(character);
			totalCount %= DIVISOR;
		}
		
		// valueOf() 및 write() 메서드를 사용해 암호를 풀기 위한 시도 횟수를 출력
		out.write(String.valueOf(totalCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}