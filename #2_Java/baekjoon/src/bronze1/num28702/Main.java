package bronze1.num28702;

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
		
		// readLine() 메서드를 사용해 각 문자열을 각 변수에 할당
		String numberA = in.readLine();
		String numberB = in.readLine();
		String numberC = in.readLine();
		
		// 다음에 올 숫자를 저장할 변수 nextNumber 초기화
		int nextNumber = 0;
		
		// 첫 번째 문자열이 숫자인 경우 해당 숫자에 3을 더한 수를 다음에 올 숫자로 갱신
		if (numberA.charAt(0) != 'F' && numberA.charAt(0) != 'B') {
			nextNumber = Integer.parseInt(numberA) + 3;
			
		// 두 번째 문자열이 숫자인 경우 해당 숫자에 2를 더한 수를 다음에 올 숫자로 갱신
		} else if (numberB.charAt(0) != 'F' && numberB.charAt(0) != 'B') {
			nextNumber = Integer.parseInt(numberB) + 2;
			
		// 세 번째 문자열이 숫자인 경우 해당 숫자에 1을 더한 수를 다음에 올 숫자로 갱신
		} else {
			nextNumber = Integer.parseInt(numberC) + 1;
		}
		
		// 해당 숫자가 3의 배수이면서 5의 배수인 경우 'FizzBuzz'를 출력
		if (nextNumber % 3 == 0 && nextNumber % 5 == 0) {
			out.write("FizzBuzz");
		
		// 해당 숫자가 3의 배수이지만 5의 배수가 아닌 경우 'Fizz'를 출력
		} else if (nextNumber % 3 == 0 && nextNumber % 5 != 0) {
			out.write("Fizz");
			
		// 해당 숫자가 3의 배수가 아니지만 5의 배수인 경우 'Buzz'를 출력
		} else if (nextNumber % 3 != 0 && nextNumber % 5 == 0) {
			out.write("Buzz");
			
		// 해당 숫자가 3의 배수도 아니고 5의 배수도 아닌 경우 해당 숫자를 출력
		} else {
			out.write(String.valueOf(nextNumber));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}