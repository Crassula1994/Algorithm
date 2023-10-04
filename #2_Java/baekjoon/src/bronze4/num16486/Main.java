package bronze4.num16486;

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

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 가로의 길이 및 반지름의 길이를 각 변수에 할당
		int width = Integer.parseInt(in.readLine());
		int radius = Integer.parseInt(in.readLine());
		
		// 운동장 한 바퀴의 둘레를 계산해 변수 perimeter에 할당
		double perimeter = 2 * (width + radius * 3.141592);
		
		// valueOf() 및 write() 메서드를 사용해 운동장 한 바퀴의 둘레를 출력
		out.write(String.valueOf(perimeter));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}