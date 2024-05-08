package silver3.num01788;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 피보나치 수의 절댓값을 나누어 저장할 상수 DIVISOR 초기화
	public static final int DIVISOR = 1000000000;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
		int number = Integer.parseInt(in.readLine());
		
		// 0이 입력된 경우 해당 피보나치 수의 부호와 값을 출력
		if (number == 0) {
			out.write(0 + "\n" + 0);
			
		// 양수 혹은 음수가 입력된 경우
		} else {
			
			// abs() 메서드를 사용해 피보나치 수를 저장할 배열 fibanocci 초기화
			int[] fibonacci = new int[Math.abs(number) + 1];
			
			// 1 또는 -1인 경우 피보나치 수를 갱신
			fibonacci[1] = 1;
			
			// for 반복문을 사용해 각 피보나치 수를 순회
			for (int idx = 2; idx < fibonacci.length; idx++) {
				
				// 양수가 입력된 경우 피보나치 수를 갱신
				if (number > 0) {
					fibonacci[idx] = (fibonacci[idx - 1] + fibonacci[idx - 2]) % DIVISOR;
					
				// 음수가 입력된 경우 피보나치 수를 갱신
				} else {
					fibonacci[idx] = (fibonacci[idx - 2] - fibonacci[idx - 1]) % DIVISOR;
				}
			}
			
			// 해당 피보나치 수가 양수인 경우 해당 피보나치 수의 부호와 값을 출력
			if (fibonacci[Math.abs(number)] > 0) {
				out.write(1 + "\n" + fibonacci[Math.abs(number)]);
			
			// 해당 피보나치 수가 음수인 경우 해당 피보나치 수의 부호와 값을 출력
			} else {
				out.write(-1 + "\n" + Math.abs(fibonacci[Math.abs(number)]));
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}