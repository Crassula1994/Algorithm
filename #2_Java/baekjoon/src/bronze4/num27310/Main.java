package bronze4.num27310;

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
		
		// readLine() 메서드를 사용해 입력 받은 이모지를 변수 emoji에 할당
		String emoji = in.readLine();
		
		// 언더바의 개수를 저장할 변수 underscore 초기화
		int underscore = 0;
		
		// for 반복문을 사용해 이모지의 각 문자를 순회
		for (int idx = 6; idx < emoji.length() - 1; idx++) {
			
			// charAt() 메서드를 사용해 해당 이모지의 문자를 변수 character에 할당
			char character = emoji.charAt(idx);
			
			// 해당 문자가 언더바인 경우 언더바의 개수를 갱신
			if (character == '_')
				underscore++;
		}
		
		// length() 메서드를 사용해 이모지의 입력 난이도를 계산하고 변수 difficulty에 할당
		int difficulty = emoji.length() + 2 + underscore * 5;
		
		// valueOf() 및 write() 메서드를 사용해 이모지의 입력 난이도를 출력
		out.write(String.valueOf(difficulty));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}