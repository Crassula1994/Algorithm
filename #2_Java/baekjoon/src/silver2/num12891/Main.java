package silver2.num12891;

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

		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 DNA 문자열 및 비밀번호로 사용할 부분 문자열의 길이를 각 변수에 할당
		int stringLen = Integer.parseInt(st.nextToken());
		int passwordLen = Integer.parseInt(st.nextToken());
		
		// 'A', 'C', 'G', 'T'의 등장횟수를 저장할 배열 dnaCounter 초기화
		int[] dnaCounter = new int[4];
		
		// readLine() 메서드를 사용해 입력 받은 DNA 문자열을 변수 dnaString에 할당
		String dnaString = in.readLine();
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 각 문자의 최소 개수를 각 변수에 할당
		int minA = Integer.parseInt(st.nextToken());
		int minC = Integer.parseInt(st.nextToken());
		int minG = Integer.parseInt(st.nextToken());
		int minT = Integer.parseInt(st.nextToken());
		
		// 만들 수 있는 비밀번호의 개수를 저장할 변수 passwordCnt 초기화
		int passwordCnt = 0;
		
		// for 반복문을 사용해 DNA 문자열의 첫 부분 문자열을 순회
		for (int idx = 0; idx < passwordLen; idx++) {
			
			// charAt() 메서드를 사용해 해당 문자를 변수 character에 할당
			char character = dnaString.charAt(idx);
			
			// switch 조건문을 사용해 각 알파벳의 등장 횟수를 갱신
			switch (character) {
				case 'A':
					dnaCounter[0]++;
					break;
				case 'C':
					dnaCounter[1]++;
					break;
				case 'G':
					dnaCounter[2]++;
					break;
				default:
					dnaCounter[3]++;
			}
		}
		
		// 첫 부분 문자열이 비밀번호의 조건을 만족하는 경우 만들 수 있는 비밀번호의 개수를 갱신
		if (dnaCounter[0] >= minA && dnaCounter[1] >= minC && dnaCounter[2] >= minG && dnaCounter[3] >= minT)
			passwordCnt++;
			
		// 부분 문자열의 시작과 끝을 나타내는 각 변수 초기화
		int start = 0;
		int end = passwordLen - 1;
		
		// while 반복문을 사용해 마지막 부분 문자열까지 순회
		while (end < stringLen - 1) {
			
			// charAt() 메서드를 사용해 새로 추가된 문자를 변수 endCharacter에 할당
			char endCharacter = dnaString.charAt(++end);
			
			// switch 조건문을 사용해 각 알파벳의 등장 횟수를 갱신
			switch (endCharacter) {
				case 'A':
					dnaCounter[0]++;
					break;
				case 'C':
					dnaCounter[1]++;
					break;
				case 'G':
					dnaCounter[2]++;
					break;
				default:
					dnaCounter[3]++;
			}
			
			// charAt() 메서드를 사용해 빠지는 문자를 변수 startCharacter에 할당
			char startCharacter = dnaString.charAt(start++);
			
			// switch 조건문을 사용해 각 알파벳의 등장 횟수를 갱신
			switch (startCharacter) {
				case 'A':
					dnaCounter[0]--;
					break;
				case 'C':
					dnaCounter[1]--;
					break;
				case 'G':
					dnaCounter[2]--;
					break;
				default:
					dnaCounter[3]--;
			}
			
			// 해당 부분 문자열이 비밀번호의 조건을 만족하는 경우 만들 수 있는 비밀번호의 개수를 갱신
			if (dnaCounter[0] >= minA && dnaCounter[1] >= minC && dnaCounter[2] >= minG && dnaCounter[3] >= minT)
				passwordCnt++;
		}
		
		// valueOf() 및 write() 메서드를 사용해 만들 수 있는 비밀번호의 개수를 출력
		out.write(String.valueOf(passwordCnt));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}