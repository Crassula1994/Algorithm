package bronze2.num10820;

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
		
		// while 반복문을 사용해 각 줄을 순회
		while (true) {
			
			// 해당 문자열의 소문자, 대문자, 숫자, 공백의 개수를 저장할 각 변수 초기화
			int lowerCaseCnt = 0;
			int upperCaseCnt = 0;
			int numberCnt = 0;
			int blankCnt = 0;
			
			// readLine() 메서드를 사용해 입력 받은 문자열을 변수 string에 할당
			String string = in.readLine();
			
			// 더 이상 줄이 없는 경우 반복문 탈출
			if (string == null)
				break;
			
			// for 반복문을 사용해 문자열의 각 문자를 순회
			for (int idx = 0; idx < string.length(); idx++) {
				
				// charAt() 메서드를 사용해 해당 문자를 변수 character에 할당
				char character = string.charAt(idx);
				
				// 해당 글자가 공백 문자인 경우 공백의 개수 갱신
				if (character < 48) {
					blankCnt++;
				
				// 해당 글자가 숫자인 경우 숫자의 개수 갱신
				} else if (character < 65) {
					numberCnt++;
					
				// 해당 글자가 대문자인 경우 대문자의 개수 갱신
				} else if (character < 97) {
					upperCaseCnt++;
					
				// 해당 글자가 소문자인 경우 소문자의 개수 갱신
				} else {
					lowerCaseCnt++;
				}
			}
			
			// write() 메서드를 사용해 소문자, 대문자, 숫자, 공백의 개수를 출력
			out.write(lowerCaseCnt + " " + upperCaseCnt + " " + numberCnt + " " + blankCnt + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}