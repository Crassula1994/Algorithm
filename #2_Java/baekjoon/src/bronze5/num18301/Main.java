package bronze5.num18301;

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
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 각 쥐의 수를 각 변수에 할당
		int firstCaptured = Integer.parseInt(st.nextToken());
		int secondCaptured = Integer.parseInt(st.nextToken());
		int recaptured = Integer.parseInt(st.nextToken());
		
		// 쥐의 수에 대한 추정치를 계산해 변수 estimator에 할당
		int estimator = (firstCaptured + 1) * (secondCaptured + 1) / (recaptured + 1) - 1;
		
		// valueOf() 및 write() 메서드를 사용해 쥐의 수에 대한 추정치를 출력
		out.write(String.valueOf(estimator));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}