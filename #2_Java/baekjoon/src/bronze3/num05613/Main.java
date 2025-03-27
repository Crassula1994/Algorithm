package bronze3.num05613;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 계산 결과를 저장할 변수 result 초기화
		int result = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 연산을 순회
		while (true) {
			
			// readLine() 및 charAt() 메서드를 사용해 입력 받은 연산자를 변수 operator에 할당
			char operator = in.readLine().charAt(0);
			
			// '='이 주어진 경우 반복문을 탈출
			if (operator == '=')
				break;
			
			// readLine() 및 parseInt() 메서드를 사용해 연산에 사용할 숫자를 변수 number에 할당
			int number = Integer.parseInt(in.readLine());
			
			// switch 조건문을 사용해 계산 결과를 갱신
			switch (operator) {
				case '+':
					result += number;
					break;
				case '-':
					result -= number;
					break;
				case '*':
					result *= number;
					break;
				default:
					result /= number;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 계산 결과를 출력
		out.write(String.valueOf(result));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}