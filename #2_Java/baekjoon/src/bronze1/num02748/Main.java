package bronze1.num02748;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 피보나치 수열의 값을 저장할 배열 sequence 초기화
	static long[] sequence = new long[91];
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
		int number = Integer.parseInt(in.readLine());
		
		// fibonacci() 메서드를 호출해 해당 위치의 피보나치 수를 변수 result에 할당
		long result = fibonacci(number);
		
		// valueOf() 및 write() 메서드를 사용해 해당 피보나치 수를 출력
		out.write(String.valueOf(result));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// fibonacci() 메서드 정의
	public static long fibonacci(int number) {
		
		// 1 이하가 입력되는 경우 해당 값 그대로 반환
		if (number < 2) {
			return sequence[number] = number;
		
		// 이미 저장된 값이 있는 경우 해당 값 그대로 반환
		} else if (sequence[number] != 0) {
			return sequence[number];
		
		// 이미 저장된 값이 없는 경우 fibonacci() 메서드를 재귀 호출해 해당 값을 계산 후 반환
		} else {
			return sequence[number] = fibonacci(number - 1) + fibonacci(number - 2);
		}
	}
}