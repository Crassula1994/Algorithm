package bronze5.num29863;

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

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 아르노가 자러 간 시간 및 일어난 시간을 각 변수에 할당
		int startTime = Integer.parseInt(in.readLine());
		int endTime = Integer.parseInt(in.readLine());
		
		// valueOf() 및 write() 메서드를 사용해 아르노가 잠을 잔 시간을 출력
		out.write((startTime > endTime) ? String.valueOf(endTime - startTime + 24) : String.valueOf(endTime - startTime));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}