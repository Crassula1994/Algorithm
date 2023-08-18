package bronze3.num11719;

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
		
		// while 반복문을 사용해 각 입력 받은 줄을 모두 순회
		while (true) {
			
			// readLine() 메서드를 사용해 입력 받은 내용을 변수 line에 할당
			String line = in.readLine();
			
			// 입력 받은 내용이 없는 경우 반복문 탈출
			if (line == null)
				break;
			
			// write() 메서드를 사용해 입력 받은 내용을 그대로 출력
			out.write(line + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}