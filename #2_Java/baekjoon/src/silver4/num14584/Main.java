package silver4.num14584;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 암호문과 사전에 있는 단어의 수를 각 변수에 할당
		String cryptogram = in.readLine();
		int wordNum = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 단어를 순회
		outer: for (int w = 0; w < wordNum; w++) {
			
			// readLine() 메서드를 사용해 해당 단어를 변수 word에 할당
			String word = in.readLine();
			
			// for 반복문을 사용해 가능한 각 알파벳을 순회
			for (int code = 0; code < 26; code++) {
				
				// 암호화한 단어를 저장할 StringBuilder 객체 sb 초기화
				StringBuilder sb = new StringBuilder();
				
				// for 반복문을 사용해 암호화된 단어를 sb에 저장
				for (int idx = 0; idx < word.length(); idx++)
					sb.append((char) ('a' + (word.charAt(idx) - 'a' + code) % 26));
				
				// 암호문이 해당 암호화된 단어를 포함하고 있는 경우
				if (cryptogram.contains(sb.toString())) {
					
					// for 반복문을 사용해 암호문을 해독한 원문을 출력
					for (int idx = 0; idx < cryptogram.length(); idx++)
						out.write((char) ('a' + (cryptogram.charAt(idx) - 'a' - code + 26) % 26));
					
					// 반복문 탈출
					break outer;
				}
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}