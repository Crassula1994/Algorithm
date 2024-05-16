package bronze4.num13985;

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
		
		// readLine() 메서드를 사용해 입력 받은 등식 문자열을 변수 equation에 할당
		String equation = in.readLine();
		
		// charAt() 메서드를 사용해 등식의 각 숫자를 각 변수에 할당
		int numberA = equation.charAt(0) - '0';
		int numberB = equation.charAt(4) - '0';
		int answer = equation.charAt(8) - '0';
		
		// 등식이 성립하는 경우 'YES' 출력
		if (numberA + numberB == answer) {
			out.write("YES");
			
		// 등식이 성립하지 않는 경우 'NO' 출력
		} else {
			out.write("NO");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}