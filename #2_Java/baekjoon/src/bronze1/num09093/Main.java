package bronze1.num09093;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++ ) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// countTokens() 메서드를 사용해 단어의 개수를 변수 wordNum에 할당
			int wordNum = st.countTokens();
			
			// for 반복문을 사용해 각 단어를 순회
			for (int w = 0; w < wordNum; w++) {
			
				// nextToken() 메서드를 사용해 단어를 변수 word에 할당
				String word = st.nextToken();
				
				// for 반복문을 사용해 단어의 각 문자를 거꾸로 출력
				for (int idx = word.length() - 1; idx >= 0; idx--)
					out.write(word.charAt(idx));
				
				// write() 메서드를 사용해 띄어쓰기 출력
				out.write(" ");
			}
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}