package bronze2.num11816;

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
		
		// readLine() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
		String number = in.readLine();
		
		// 해당 숫자가 10진수인 경우 해당 숫자를 출력
		if (number.length() < 2 || number.charAt(0) != '0') {
			out.write(number);
			
		// 해당 숫자가 16진수인 경우 16진수를 10진수로 변환한 결과를 출력
		} else if (number.charAt(1) == 'x') {
			out.write(String.valueOf(Integer.parseInt(number.substring(2), 16)));
			
		// 해당 숫자가 8진수인 경우 8진수를 10진수로 변환한 결과를 출력
		} else {
			out.write(String.valueOf(Integer.parseInt(number.substring(1), 8)));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}