package bronze5.num32775;

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
		
		// readLine(), parseInt(), write() 메서드를 사용해 사람들이 어떤 교통수단을 더 많이 사용하는지를 출력
		out.write((Integer.parseInt(in.readLine()) > Integer.parseInt(in.readLine())) ? "flight" : "high speed rail");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}