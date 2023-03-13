package bronze4.num15680;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
		int number = Integer.parseInt(in.readLine());

		// 0이 입력된 경우 연세대학교의 영문명을 출력
		if (number == 0) {
			out.write("YONSEI");
			
		// 1이 입력된 경우 연세대학교의 슬로건을 출력
		} else {
			out.write("Leading the Way to the Future");
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}