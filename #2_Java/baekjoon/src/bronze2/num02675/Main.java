package bronze2.num02675;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int i = 0; i < testCase; i++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());

			// nextToken() 및 parseInt() 메서드를 사용해 반복 횟수를 변수 loopNum에 할당
			int loopNum = Integer.parseInt(st.nextToken());
			
			// nextToken() 및 toCharArray() 메서드를 사용해 입력 받은 문자를 배열 characterArray에 할당
			char[] characterArray = st.nextToken().toCharArray();
			
			// for 반복문을 사용해 배열 characterArray의 각 원소를 순회
			for (char character : characterArray) {
				
				// for 반복문을 사용해 각 원소를 반복 횟수만큼 출력
				for (int j = 0; j < loopNum; j++)
					out.write(character);
			}
			
			// write() 메서드를 사용해 줄바꿈 출력
			out.write("\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}