package bronze4.num17362;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 자연수를 변수 number에 할당
		int number = Integer.parseInt(in.readLine());
		
		// 엄지와 새끼손가락인 경우 해당 번호를 출력
		if (number % 8 == 1 || number % 8 == 5) {
			out.write(String.valueOf(number % 8));		
			
		// 검지인 경우 해당 번호를 출력
		} else if (number % 8 == 0 || number % 8 == 2) {
			out.write(String.valueOf(2));

		// 중지인 경우 해당 번호를 출력
		} else if (number % 4 == 3) {
			out.write(String.valueOf(3));
			
		// 약지인 경우 해당 번호를 출력
		} else {
			out.write(String.valueOf(4));
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}