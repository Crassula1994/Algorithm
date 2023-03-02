package d3.num08741;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Solution 클래스 정의
public class Solution {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// write() 메서드를 사용해 테스트 케이스 번호를 출력
			out.write("#" + (tc + 1) + " ");
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 각 문자열을 순회
			for (int str = 0; str < 3; str++) {
				
				// nextToken() 메서드를 사용해 입력 받은 단어를 변수 word에 할당
				String word = st.nextToken();
				
				// charAt() 및 write() 메서드를 사용해 두문자를 대문자로 변환해 출력
				out.write(word.charAt(0) - 32);
			}
			
			// write() 메서드를 사용해 줄바꿈 출력
			out.write("\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}