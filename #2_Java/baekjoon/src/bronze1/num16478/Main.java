package bronze1.num16478;

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
		
		// nextToken() 및 parseDouble() 메서드를 사용해 각 선분의 길이를 각 변수에 할당
		double segmentAB = Double.parseDouble(st.nextToken());
		double segmentBC = Double.parseDouble(st.nextToken());
		double segmentCD = Double.parseDouble(st.nextToken());
		
		// valueOf() 및 write() 메서드를 사용해 영역 d와 a를 구분하는 선분의 길이를 출력
		out.write(String.valueOf(segmentAB * segmentCD / segmentBC));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}