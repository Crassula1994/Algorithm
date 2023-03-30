package gold5.num01759;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 비밀번호의 길이를 저장할 변수 targetLen 초기화
	static int targetLen;
	
	// 문자의 종류 및 가능한 비밀번호를 저장할 각 배열 초기화
	static char[] characters;
	static char[] password;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 비밀번호의 길이 및 이를 구성하는 문자의 종류 수를 각 변수에 할당
		targetLen = Integer.parseInt(st.nextToken());
		int charType = Integer.parseInt(st.nextToken());
		
		// 문자의 종류 및 가능한 비밀번호를 저장할 각 배열 초기화
		characters = new char[charType];
		password = new char[targetLen];
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 배열 characters에 입력 받은 알파벳 소문자를 저장
		for (int idx = 0; idx < characters.length; idx++)
			characters[idx] = st.nextToken().charAt(0);
		
		// sort() 메서드를 사용해 배열 characters를 사전 순으로 정렬
		Arrays.sort(characters);

		// passwordMaker() 메서드를 호출해 사전식으로 가능성 있는 암호를 모두 출력
		passwordMaker(0, 0, 0, 0, out);

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// passwordMaker() 메서드 정의
	public static void passwordMaker(int startIdx, int length, int vowCnt, int conCnt, BufferedWriter out) throws IOException {
		
		// 비밀번호를 모두 완성한 경우
		if (length == targetLen) {
			
			// 모음이 1개 이상이고 자음이 2개 이상일 경우
			if (vowCnt >= 1 && conCnt >= 2) {
				
				// for 반복문을 사용해 해당 비밀번호 출력
				for (int idx = 0; idx < targetLen; idx++)
					out.write(password[idx]);
				
				// newLine() 메서드를 사용해 줄바꿈을 출력
				out.newLine();
			}
			
			// 메서드 종료
			return;
		}
		
		
		
	}
}