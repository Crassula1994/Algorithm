package bronze3.num03053;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 반지름을 변수 radius에 할당
		int radius = Integer.parseInt(in.readLine());
		
		// 유클리드 기하학에서의 원의 넓이, 택시 기하학에서의 원의 넓이를 계산해 각 변수에 할당
		double euclidian = Math.pow(radius, 2) * Math.PI;
		double taxicab = Math.pow(radius, 2) * 2;
		
		// format() 및 write() 메서드를 사용해 각 기하학에서의 원의 넓이를 출력
		out.write(String.format("%.6f", euclidian) + "\n" + String.format("%.6f", taxicab));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}