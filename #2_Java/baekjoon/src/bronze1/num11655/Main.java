package bronze1.num11655;

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
		
		// readLine() 메서드를 사용해 입력 받은 문자열를 변수 string에 할당
		String string = in.readLine();
		
		// ROT13으로 암호화한 문자열을 저장할 StringBuilder 객체 sb 초기화
		StringBuilder sb = new StringBuilder();
		
		// for 반복문을 사용해 문자열의 각 글자를 순회
		for (int idx = 0; idx < string.length(); idx++) {
			
			// charAt() 메서드를 사용해 해당 글자를 변수 character에 할당
			char character = string.charAt(idx);
			
			// 대문자 또는 소문자를 ROT13으로 암호화한 결과를 저장할 변수 result 초기화
			char result;
			
			// 해당 글자가 빈 칸 또는 숫자인 경우 그대로 추가
			if (character == ' ' || (character - '0' >= 0 && character - '0' <= 9)) {
				sb.append(character);
				continue;
			
			// 해당 글자가 알파벳 대문자인 경우
			} else if (character - 'a' < 0) {
				
				// 해당 대문자를 ROT13으로 암호화한 중간 결과를 변수 code에 할당
				int code = character - 'A' + 13;
				
				// 해당 대문자를 ROT13으로 암호화한 최종 결과를 변수 result에 할당
				result = (code > 25) ? (char) (code - 26 + 65) : (char) (code + 65);
				
			// 해당 글자가 알파벳 소문자인 경우
			} else {
				
				// 해당 소문자를 ROT13으로 암호화한 중간 결과를 변수 code에 할당
				int code = character - 'a' + 13;
				
				// 해당 소문자를 ROT13으로 암호화한 최종 결과를 변수 result에 할당
				result = (code > 25) ? (char) (code - 26 + 97) : (char) (code + 97);
			}

			// append() 메서드를 사용해 ROT13으로 암호화한 최종 결과를 StringBuilder 객체 sb에 추가
			sb.append(result);
		}
		
		// toString() 및 write() 메서드를 사용해 ROT13으로 암호화한 문자열을 출력
		out.write(sb.toString());
	
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}