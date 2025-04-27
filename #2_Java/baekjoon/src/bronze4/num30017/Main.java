package bronze4.num30017;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 패티의 개수와 치즈의 개수를 각 변수에 할당
		int pattyNum = Integer.parseInt(st.nextToken());
		int cheeseNum = Integer.parseInt(st.nextToken());
		
		// min(), valueOf(), write() 메서드를 사용해 승현이가 만들 수 있는 치즈버거의 최대 크기를 출력
		out.write(String.valueOf(2 * Math.min(pattyNum - 1, cheeseNum) + 1));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}