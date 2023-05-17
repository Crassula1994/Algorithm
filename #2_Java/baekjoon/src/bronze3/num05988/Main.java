package bronze3.num05988;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 숫자를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// readLine() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
			String number = in.readLine();
			
			// length() 및 charAt() 메서드를 사용해 해당 숫자가 홀수인지 짝수인지 여부를 변수 result에 저장
			String result = ((number.charAt(number.length() - 1) - '0') % 2 != 0) ? "odd" : "even";
			
			// write() 메서드를 사용해 해당 숫자가 홀수인지 짝수인지 여부를 출력
			out.write(result + "\n");
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}