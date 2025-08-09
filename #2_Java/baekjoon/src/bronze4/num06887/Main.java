package bronze4.num06887;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 타일의 개수를 변수 tileNum에 할당
		int tileNum = Integer.parseInt(in.readLine());

		// sqrt() 및 write() 메서드를 사용해 타일로 만들 수 있는 정사각형 한 변의 최대 길이를 출력
		out.write("The largest square has side length " + (int) Math.sqrt(tileNum) + ".");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}