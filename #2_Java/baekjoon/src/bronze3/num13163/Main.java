package bronze3.num13163;

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

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 닉네임의 수를 변수 nicknameNum에 할당
		int nicknameNum = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 닉네임을 순회
		while (nicknameNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// write() 메서드를 사용해 'god'을 출력
			out.write("god");
			
			// nextToken() 메서드를 사용해 첫 음절을 제거
			st.nextToken();
			
			// while 반복문을 사용해 나머지 음절을 출력
			while (st.hasMoreTokens())
				out.write(st.nextToken());
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}