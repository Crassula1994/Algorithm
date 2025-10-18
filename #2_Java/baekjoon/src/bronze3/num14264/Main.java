package bronze3.num14264;

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
		
		// readLine() 및 parseDouble() 메서드를 사용해 입력 받은 정육각형 한 변의 길이를 변수 length에 할당
		double length = Double.parseDouble(in.readLine());
		
		/* toRadians(), sin(), valueOf(), write() 메서드를 사용해 육각형을 4개의 삼각형으로 나누었을 때
		면적이 제일 작은 삼각형의 면적을 출력 */
		out.write(String.valueOf(0.5 * length * length * Math.sin(Math.toRadians(120))));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}