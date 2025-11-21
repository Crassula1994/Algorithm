package bronze5.num34665;

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
		
		// readLine(), equals(), write() 메서드를 사용해 부과된 승차 요금을 출력
		out.write((in.readLine().equals(in.readLine())) ? "0" : "1550");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}