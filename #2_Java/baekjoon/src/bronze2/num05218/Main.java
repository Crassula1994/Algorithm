package bronze2.num05218;

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
		for (int tc = 0; tc < testCase; tc++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 메서드를 사용해 입력 받은 각 단어를 각 변수에 할당
			String wordX = st.nextToken();
			String wordY = st.nextToken();
			
			// write() 메서드를 사용해 알파벳 거리 출력 형식을 출력
			out.write("Distances:");
			
			// for 반복문을 사용해 각 알파벳을 순회
			for (int idx = 0; idx < wordX.length(); idx++) {
				
				// charAt() 메서드를 사용해 입력 받은 알파벳의 숫자를 각 변수에 할당
				int alphabetX = wordX.charAt(idx) - 'A' + 1;
				int alphabetY = wordY.charAt(idx) - 'A' + 1;
				
				// 두 번째 단어의 알파벳 숫자가 더 작은 경우 알파벳 거리를 출력
				if (alphabetX > alphabetY) {
					out.write(" " + (alphabetY + 26 - alphabetX));
				
				// 두 번째 단어의 알파벳 숫자가 더 크거나 같은 경우 알파벳 거리를 출력
				} else {
					out.write(" " + (alphabetY - alphabetX));
				}
			}
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}