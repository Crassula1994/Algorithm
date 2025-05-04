package bronze4.num05357;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// readLine() 및 toCharArray() 메서드를 사용해 입력 받은 문자열을 배열 string에 저장
			char[] string = in.readLine().toCharArray();
			
			// for 반복문을 사용해 각 글자를 순회
			for (int idx = 0; idx < string.length; idx++) {
				
				// 해당 글자가 연속된 동일한 문자가 아닌 경우 해당 글자를 출력
				if (idx == 0 || string[idx - 1] != string[idx])
					out.write(string[idx]);
			}
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}