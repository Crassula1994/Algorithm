package bronze5.num24082;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 정육면체의 한 변의 길이를 변수 length에 할당
		int length = Integer.parseInt(in.readLine());
		
		// valueOf() 및 write() 메서드를 사용해 정육면체의 부피를 출력
		out.write(String.valueOf(length * length * length));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}