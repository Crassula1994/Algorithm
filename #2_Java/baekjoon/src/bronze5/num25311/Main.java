package bronze5.num25311;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 UCPC 개최 연도를 변수 year에 할당
		@SuppressWarnings("unused")
		int year = Integer.parseInt(in.readLine());
		
		// write() 메서드를 사용해 UCPC 예선의 가장 쉬운 문제 번호를 출력
		out.write("A");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}