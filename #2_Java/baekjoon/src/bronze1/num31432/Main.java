package bronze1.num31432;

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
		
		// readLine() 메서드를 사용해 불필요한 사용할 수 있는 숫자의 개수를 입력 처리
		in.readLine();
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// write() 메서드를 사용해 소수가 아닌 수는 언제나 만들 수 있으므로 'YES'를 출력
		out.write("YES");
		
		// newLine() 메서드를 사용해 줄바꿈을 출력
		out.newLine();
		
		// nextToken(), parseInt(), valueOf(), write() 메서드를 사용해 소수가 아닌 수를 출력
		out.write(String.valueOf(Integer.parseInt(st.nextToken()) * 111));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}