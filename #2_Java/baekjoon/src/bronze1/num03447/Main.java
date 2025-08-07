package bronze1.num03447;

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
		
		// 입력 받은 줄의 소스 코드를 저장할 변수 sourceCode 초기화
		String sourceCode;
		
		// while 반복문을 사용해 파일이 끝날 때까지 순회
		while ((sourceCode = in.readLine()) != null) {

			// while 반복문을 사용해 소스 코드의 'BUG'를 모두 제거
			while (sourceCode.contains("BUG"))
				sourceCode = sourceCode.replace("BUG", "");
			
			// write() 메서드를 사용해 소스 코드의 'BUG'를 모두 제거한 결과를 출력
			out.write(sourceCode);
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}