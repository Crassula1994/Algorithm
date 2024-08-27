package gold2.num02749;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 피보나치 수를 나눌 제수를 저장할 상수 DIVISOR 초기화
	static final int DIVISOR = 1000000;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseLong() 메서드를 사용해 입력 받은 숫자를 피사노 주기로 나눈 값을 변수 number에 할당
		long number = Long.parseLong(in.readLine()) % 1500000;
		
		// 피보나치 수를 저장할 배열 fibonacci 초기화
		long[] fibonacci = new long[(int) number + 1];
		
		// 첫 번째 피보나치 수를 갱신
		fibonacci[1] = 1;
		
		// for 반복문을 사용해 각 피보나치 수를 갱신
		for (int idx = 2; idx < fibonacci.length; idx++)
			fibonacci[idx] = (fibonacci[idx - 1] + fibonacci[idx - 2]) % DIVISOR;
		
		// valueOf() 및 write() 메서드를 사용해 입력 받은 숫자의 순서에 해당하는 피보나치 수를 출력
		out.write(String.valueOf(fibonacci[(int) number]));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}