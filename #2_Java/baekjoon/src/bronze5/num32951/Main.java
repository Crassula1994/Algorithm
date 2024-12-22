package bronze5.num32951;

//필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 연도를 변수 currentYear에 할당
		int currentYear = Integer.parseInt(in.readLine());
		
		// valueOf() 및 write() 메서드를 사용해 2024년으로부터 몇 년이나 지났는지 출력
		out.write(String.valueOf(currentYear - 2024));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}