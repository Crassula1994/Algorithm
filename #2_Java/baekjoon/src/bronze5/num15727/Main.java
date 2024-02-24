package bronze5.num15727;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 민건이 집까지의 거리를 변수 distance에 할당
		int distance = Integer.parseInt(in.readLine());
		
		// 성우가 민건이를 찾을 때까지 걸리는 최소 시간을 계산해 변수 minTime에 할당
		int minTime = (distance % 5 == 0) ? distance / 5 : distance / 5 + 1;
		
		// valueOf() 및 write() 메서드를 사용해 성우가 민건이를 찾을 때까지 걸리는 최소 시간을 출력
		out.write(String.valueOf(minTime));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}