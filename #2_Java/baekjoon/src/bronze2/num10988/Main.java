package bronze2.num10988;

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
		
		// readLine() 메서드를 사용해 입력 받은 단어를 변수 word에 할당
		String word = in.readLine();

		// 한 글자인 경우 '1' 출력
		if (word.length() == 1) {
			out.write(String.valueOf(1));
		
		// 한 글자가 아닌 경우
		} else {
			
			// for 반복문을 사용해 각 자리의 단어를 순회
			for (int idx = 0; idx < word.length() / 2; idx++) {
				
				// 팰린드롬이 아닌 경우 '0' 출력 후 반복문 탈출
				if (word.charAt(idx) != word.charAt(word.length() - idx - 1)) {
					out.write(String.valueOf(0));
					break;
				} 
				
				// 팰린드롬인 경우 '1' 출력
				if (idx == word.length() / 2 - 1)
					out.write(String.valueOf(1));
			}
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}