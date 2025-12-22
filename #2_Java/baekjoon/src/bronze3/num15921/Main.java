package bronze3.num15921;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 수찬이의 연습 기록 개수를 변수 recordNum에 할당
		int recordNum = Integer.parseInt(in.readLine());
		
		// write() 메서드를 사용해 수찬이가 대회에서 연습과 비슷하게 꾸준한 기량을 뽐낼 수 있는 확률을 출력
		out.write((recordNum > 0) ? "1.00" : "divide by zero");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}