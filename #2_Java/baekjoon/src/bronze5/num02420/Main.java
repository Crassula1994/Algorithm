package bronze5.num02420;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st= new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseLong() 메서드를 사용해 입력 받은 각 유명도를 각 변수에 할당
		long fameN = Long.parseLong(st.nextToken());
		long fameM = Long.parseLong(st.nextToken());
		
		// abs() 메서드를 사용해 두 유명도의 차이를 변수 gap에 할당
		long gap = Math.abs(fameN - fameM);
		
		// valueOf() 및 write() 메서드를 사용해 세 수의 합을 출력
		out.write(String.valueOf(gap));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}