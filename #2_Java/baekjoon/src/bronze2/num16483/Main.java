package bronze2.num16483;

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
		
		/* readLine() 및 parseDouble() 메서드를 사용해
		입력 받은 작은 원의 접점에서 큰 원까지의 거리를 변수 distance에 할당 */
		double distance = Double.parseDouble(in.readLine()) / 2;
		
		// format() 및 write() 메서드를 사용해 큰 원의 반지름 제곱에서 작은 원의 반지름 제곱을 뺀 값을 정수로 출력
		out.write(String.format("%.0f", distance * distance));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}