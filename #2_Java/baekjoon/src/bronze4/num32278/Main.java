package bronze4.num32278;

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
		
		// readLine() 및 parseLong() 메서드를 사용해 입력 받은 정수를 변수 number에 할당
		long number = Long.parseLong(in.readLine());
		
		// 해당 정수를 'short' 자료형으로 표현할 수 있는 경우 'short' 출력
		if (number >= Short.MIN_VALUE && number <= Short.MAX_VALUE) {
			out.write("short");
			
		// 해당 정수를 'int' 자료형으로 표현할 수 있는 경우 'int' 출력
		} else if (number >= Integer.MIN_VALUE && number <= Integer.MAX_VALUE) {
			out.write("int");
			
		// 해당 정수를 'long long' 자료형으로 표현할 수 있는 경우 'long long' 출력
		} else {
			out.write("long long");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}