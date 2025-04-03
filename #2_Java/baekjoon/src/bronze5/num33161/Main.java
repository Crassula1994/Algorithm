package bronze5.num33161;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 JOI 군의 소지금을 변수 money에 할당
		int money = Integer.parseInt(in.readLine());
		
		// valueOf() 및 write() 메서드를 사용해 JOI 군이 최대 구매할 수 있는 연필의 개수를 출력
		out.write(String.valueOf(money / 5));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}