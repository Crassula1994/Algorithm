package bronze1.num19654;

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
		
		// readLine() 메서드를 사용해 입력 받은 muse가 입력하고자 하는 글을 변수 text에 할당
		String text = in.readLine();
		
		// 'abcdefghijklmnopqrstuvwxyz'를 반복해서 입력해야 하는 횟수를 저장할 변수 count 초기화
		int count = 1;
		
		// charAt() 메서드를 사용해 확인한 알파벳을 저장할 변수 prevAlphabet 초기화
		char prevAlphabet = text.charAt(0);
		
		// for 반복문을 사용해 각 텍스트의 알파벳을 순회
		for (int idx = 1; idx < text.length(); idx++) {
			
			// charAt() 메서드를 사용해 현재 알파벳을 변수 curAlphabet에 할당
			char curAlphabet = text.charAt(idx);
			
			// 현재 알파벳이 이전 알파벳과 같거나 앞에 위치한 알파벳인 경우 문자열을 반복해서 입력해야 하는 횟수를 갱신
			if (prevAlphabet >= curAlphabet)
				count++;
			
			// 확인한 알파벳을 갱신
			prevAlphabet = curAlphabet;
		}
		
		// valueOf() 및 write() 메서드를 사용해 'abcdefghijklmnopqrstuvwxyz'를 반복해서 입력해야 하는 횟수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}