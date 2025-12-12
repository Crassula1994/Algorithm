package bronze5.num34849;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 반복 횟수를 변수 count에 할당
		int count = Integer.parseInt(in.readLine());
		
		// write() 메서드를 사용해 로하가 실행한 코드가 1초 이하의 시간 내에 연산을 모두 끝낼 수 있는지 여부를 출력
		out.write((count <= 10000) ? "Accepted" : "Time limit exceeded");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}