package bronze2.num05598;

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
		
		// readLine() 메서드를 사용해 입력 받은 카이사르 단어를 변수 wordCaesar에 할당
		String wordCaesar = in.readLine();
		
		// for 반복문을 사용해 카이사르 단어의 각 알파벳을 순회
		for (int idx = 0; idx < wordCaesar.length(); idx++) {
			
			// charAt() 메서드를 사용해 입력 받은 알파벳을 변수 alphabet에 할당
			char alphabet = wordCaesar.charAt(idx);
			
			// 해당 알파벳이 'D' 이상인 경우 3문자 앞의 알파벳을 출력
			if (alphabet >= 'D') {
				out.write((char) alphabet - 3);
			
			// 해당 알파벳이 'D' 미만인 경우 23문자 뒤의 알파벳을 출력
			} else {
				out.write((char) alphabet + 23);
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}