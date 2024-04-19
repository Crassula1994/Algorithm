package silver5.num15904;

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
		
		// 'UCPC'의 각 알파벳이 존재하는지 여부를 나타낼 배열 satisfied 초기화
		boolean[] satisfied = new boolean[4];
		
		// for 반복문을 사용해 문자열의 각 글자를 순회
		for (int idx = 0; idx < string.length(); idx++) {
			
			// charAt() 메서드를 사용해 해당 글자를 변수 character에 할당
			char character = string.charAt(idx);
			
			// 'U'가 아직 나오지 않은 경우
			if (!satisfied[0]) {
				
				// 해당 글자가 'U'인 경우 'U' 알파벳이 존재하는지 여부를 갱신
				if (character == 'U')
					satisfied[0] = true;
				
				// 다음 글자를 순회
				continue;
			}
			
			// 'C'가 아직 나오지 않은 경우
			if (!satisfied[1]) {
				
				// 해당 글자가 'C'인 경우 'C' 알파벳이 존재하는지 여부를 갱신
				if (character == 'C')
					satisfied[1] = true;
				
				// 다음 글자를 순회
				continue;
			}
			
			// 'P'가 아직 나오지 않은 경우
			if (!satisfied[2]) {
				
				// 해당 글자가 'P'인 경우 'P' 알파벳이 존재하는지 여부를 갱신
				if (character == 'P')
					satisfied[2] = true;
				
				// 다음 글자를 순회
				continue;
			}
			
			// 'C'가 아직 나오지 않은 경우
			if (!satisfied[3]) {
				
				// 해당 글자가 'C'인 경우 'C' 알파벳이 존재하는지 여부를 갱신 후 반복문 탈출
				if (character == 'C') {
					satisfied[3] = true;
					break;
				}
			}
		}
		
		// 문자열을 축약해 UCPC로 만들 수 있는 경우 'I love UCPC' 출력
		if (satisfied[0] && satisfied[1] && satisfied[2] && satisfied[3]) {
			out.write("I love UCPC");
			
		// 문자열을 축약해 UCPC로 만들 수 없는 경우 'I hate UCPC' 출력
		} else {
			out.write("I hate UCPC");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}