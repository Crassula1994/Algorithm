package bronze4.num20215;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 모서리의 너비와 높이를 각 변수에 할당
		double width = Integer.parseInt(st.nextToken());
		double height = Integer.parseInt(st.nextToken());
		
		// sqrt() 메서드를 사용해 대각선 대신 직사각형으로 모서리를 자를 때 더 잘라야 하는 길이를 계산하고 변수 difference에 할당 
		double difference = width + height - Math.sqrt(height * height + width * width);
		
		// valueOf() 및 write() 메서드를 사용해 대각선 대신 직사각형으로 모서리를 자를 때 더 잘라야 하는 길이를 출력
		out.write(String.valueOf(difference));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}