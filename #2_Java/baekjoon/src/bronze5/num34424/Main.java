package bronze5.num34424;

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

		// readLine() 및 parseInt() 메서드를 사용해 가장 멀리 떨어진 두 사람의 거리를 변수 maxDistance에 할당
		int maxDistance = (Integer.parseInt(in.readLine()) - 1) * Integer.parseInt(in.readLine());
		
		// valueOf() 및 write() 메서드를 사용해 가장 멀리 떨어진 두 사람의 거리를 출력
		out.write(String.valueOf(maxDistance));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}