package bronze5.num34297;

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
		
		/* readLine() 및 parseInt() 메서드를 사용해 입력 받은 한나가 주차장을 한 바퀴 도는 데 걸리는 시간
		및 주차 자리를 찾기 전까지 주차장을 도는 횟수를 각 변수에 할당 */
		int time = Integer.parseInt(in.readLine());
		in.readLine();
		int count = Integer.parseInt(in.readLine());
		
		// valueOf() 및 write() 메서드를 사용해 한나가 주차 자리를 찾는 데 걸린 총 시간을 출력
		out.write(String.valueOf(time * count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}