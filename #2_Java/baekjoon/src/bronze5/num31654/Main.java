package bronze5.num31654;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 실제 정답과 밥이 작성한 답을 각 변수에 할당
		int answer = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
		int output = Integer.parseInt(st.nextToken());
		
		// write() 메서드를 사용해 밥이 작성한 답이 맞는지 여부를 출력
		out.write((answer == output) ? "correct!" : "wrong!");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}