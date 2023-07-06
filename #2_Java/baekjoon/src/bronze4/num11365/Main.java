package bronze4.num11365;

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
			
			// readLine() 메서드를 사용해 입력 받은 암호를 변수 password에 할당
			String password = in.readLine();
			
			// 해당 단어가 'END'인 경우 반복문 탈출
			if (password.equals("END"))
				break;
			
			// 해독한 암호를 저장할 변수 reversedPassword 초기화
			StringBuilder reversedPassword = new StringBuilder();
			
			// for 반복문을 사용해 각 단어를 거꾸로 reversedPassword에 추가
			for (int idx = password.length() - 1; idx >= 0; idx--)
				reversedPassword.append(password.charAt(idx));
			
			// write() 메서드를 사용해 해독한 암호를 출력
			out.write(reversedPassword + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}