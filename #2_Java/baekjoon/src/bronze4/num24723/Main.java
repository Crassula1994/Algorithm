package bronze4.num24723;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 녹색거탑의 높이를 변수 height에 할당
		int height = Integer.parseInt(in.readLine());
		
		// pow() 메서드를 사용해 녹색거탑의 정상에서 바닥으로 내려오는 경우의 수를 변수 cases에 할당
		int cases = (int) Math.pow(2, height);
		
		// valueOf() 및 write() 메서드를 사용해 녹색거탑의 정상에서 바닥으로 내려오는 경우의 수를 출력
		out.write(String.valueOf(cases));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}