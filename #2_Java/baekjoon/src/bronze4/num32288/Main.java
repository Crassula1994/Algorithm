package bronze4.num32288;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 바코드 닉네임의 길이 및 닉네임을 각 변수에 할당
		int length = Integer.parseInt(in.readLine());
		String nickname = in.readLine();
		
		// for 반복문을 사용해 닉네임의 각 글자를 순회
		for (int idx = 0; idx < length; idx++) {
			
			// 해당 글자가 'l'인 경우 'L'을 출력
			if (nickname.charAt(idx) == 'l') {
				out.write("L");
				
			// 해당 글자가 'I'인 경우 'i'를 출력
			} else {
				out.write("i");
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}