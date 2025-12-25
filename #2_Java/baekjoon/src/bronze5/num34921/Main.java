package bronze5.num34921;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 나이와 solved.ac 티어를 각 변수에 할당
		int age = Integer.parseInt(st.nextToken());
		int tier = Integer.parseInt(st.nextToken());
		
		// max(), valueOf(), write() 메서드를 사용해 친구의 덕후력을 출력
		out.write(String.valueOf(Math.max(0, 60 - 2 * (age - tier))));
				
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}