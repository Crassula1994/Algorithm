package bronze4.num11282;

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

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 글자의 순서를 변수 order에 할당
		int order = Integer.parseInt(in.readLine()) + 44031;
		
		// 해당 순서를 한글로 변환한 결과를 변수 character에 할당
		char character = (char) order;
				
		// write() 메서드를 사용해 해당 한글을 출력
		out.write(character);

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}