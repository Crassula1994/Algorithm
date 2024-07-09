package bronze4.num17863;

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

		// readLine() 및 substring() 메서드를 사용해 전화번호의 앞 자리 번호를 변수 prefixNumber에 할당
		String prefixNumber = in.readLine().substring(0, 3);
		
		// equals() 및 write() 메서드를 사용해 해당 번호가 상담원에게 연결되어야 하는지 여부를 출력
		out.write((prefixNumber.equals("555")) ? "YES" : "NO");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}