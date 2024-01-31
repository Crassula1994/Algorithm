package bronze4.num10987;

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
		
		// 모음의 개수를 저장할 변수 vowelCnt 초기화
		int vowelCnt = 0;
		
		// for 반복문을 사용해 입력 받은 단어의 각 알파벳을 순회
		for (int idx = 0; idx < word.length(); idx++) {
			
			// charAt() 메서드를 사용해 각 알파벳을 변수 alphabet에 할당
			char alphabet = word.charAt(idx);
			
			// 해당 알파벳이 모음인 경우 모음의 개수 갱신
			if (alphabet == 'a' || alphabet == 'e' || alphabet == 'i' || alphabet == 'o' || alphabet == 'u')
				vowelCnt++;
		}
		
		// valueOf() 및 write() 메서드를 사용해 모음의 개수를 출력
		out.write(String.valueOf(vowelCnt));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}