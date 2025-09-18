package bronze3.num02902;

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
		
		// readLine() 메서드를 사용해 입력 받은 긴 형태의 알고리즘 이름을 변수 name에 할당
		String name = in.readLine();
		
		// for 반복문을 사용해 긴 이름의 각 글자를 순회
		for (int idx = 0; idx < name.length(); idx++) {
			
			// charAt() 메서드를 사용해 해당 글자를 변수 character에 할당
			char character = name.charAt(idx);
			
			// 해당 글자가 대문자인 경우 해당 글자를 출력
			if (character < 97 && character != '-')
				out.write(character);
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}