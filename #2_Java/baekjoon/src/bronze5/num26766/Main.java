package bronze5.num26766;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 하트의 개수를 변수 heartNum에 할당
		int heartNum = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 하트를 입력 받은 개수만큼 출력
		while (heartNum-- > 0) {
			out.write(" @@@   @@@ \n");
			out.write("@   @ @   @\n");
			out.write("@    @    @\n");
			out.write("@         @\n");
			out.write(" @       @ \n");
			out.write("  @     @  \n");
			out.write("   @   @   \n");
			out.write("    @ @    \n");
			out.write("     @     \n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}