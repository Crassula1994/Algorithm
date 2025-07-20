package bronze1.num27930;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 각 학교의 문자열을 각 상수에 할당
	static final String STRING_KOREA = "KOREA";
	static final String STRING_YONSEI = "YONSEI";
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 메서드를 사용해 입력 받은 점괘를 변수 fortuneString에 할당
		String fortuneString = in.readLine();
		
		// 각 학교의 찾고자 하는 글자의 위치를 저장할 각 변수 초기화
		int curIndexK = 0;
		int curIndexY = 0;
		
		// for 반복문을 사용해 각 글자를 순회
		for (int idx = 0; idx < fortuneString.length(); idx++) {
			
			// charAt() 메서드를 사용해 해당 점괘의 글자를 변수 alphabet에 할당
			char alphabet = fortuneString.charAt(idx);
			
			// 'KOREA'의 글자를 찾은 경우 찾고자 하는 글자의 위치를 갱신
			if (alphabet == STRING_KOREA.charAt(curIndexK))
				curIndexK++;
			
			// 'KOREA'의 글자를 먼저 찾은 경우 'KOREA'를 출력 후 반복문 탈출
			if (curIndexK == 5) {
				out.write("KOREA");
				break;
			}
			
			// 'YONSEI'의 글자를 찾은 경우 찾고자 하는 글자의 위치를 갱신
			if (alphabet == STRING_YONSEI.charAt(curIndexY))
				curIndexY++;
			
			// 'YONSEI'의 글자를 먼저 찾은 경우 'YONSEI'를 출력 후 반복문 탈출
			if (curIndexY == 6) {
				out.write("YONSEI");
				break;
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}