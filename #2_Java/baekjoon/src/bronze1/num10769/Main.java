package bronze1.num10769;

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
		
		// readLine() 메서드를 사용해 입력 받은 승엽이의 문자를 변수 textMessage에 할당
		String textMessage = in.readLine();
		
		// 행복한 이모티콘과 슬픈 이모티콘의 개수를 나타낼 각 변수 초기화
		int happyEmoji = 0;
		int sadEmoji = 0;
		
		// for 반복문을 사용해 각 문자를 차례로 순회
		for (int idx = 0; idx < textMessage.length() - 2; idx++) {
			
			// charAt() 메서드를 사용해 해당 문자를 변수 startChar에 할당
			char startChar = textMessage.charAt(idx);
			
			// 해당 문자가 ':'인 경우
			if (startChar == ':') {
				
				// charAt() 메서드를 사용해 그 다음 두 글자를 각 변수에 할당
				char middleChar = textMessage.charAt(idx + 1);
				char endChar = textMessage.charAt(idx + 2);
				
				// 행복한 이모티콘인 경우 행복한 이모티콘의 개수를 갱신
				if (middleChar == '-' && endChar == ')')
					happyEmoji++;
					
				// 슬픈 이모티콘인 경우 슬픈 이모티콘의 개수를 갱신
				if (middleChar == '-' && endChar == '(')
					sadEmoji++;
			}
		}
		
		// 어떤 이모티콘도 포함되어 있지 않은 경우 'none' 출력
		if (happyEmoji == 0 && sadEmoji == 0) {
			out.write("none");
			
		// 행복한 이모티콘과 슬픈 이모티콘의 개수가 동일한 경우 'unsure' 출력
		} else if (happyEmoji == sadEmoji) {
			out.write("unsure");
			
		// 행복한 이모티콘이 슬픈 이모티콘보다 많은 경우 'happy' 출력
		} else if (happyEmoji > sadEmoji) {
			out.write("happy");
			
		// 슬픈 이모티콘이 행복한 이모티콘보다 많은 경우 'sad' 출력
		} else {
			out.write("sad");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}