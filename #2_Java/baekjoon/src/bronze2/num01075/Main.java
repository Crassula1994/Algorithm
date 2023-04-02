package bronze2.num01075;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 나누는 정수와 나누는 정수를 각 변수에 할당
		int dividend = Integer.parseInt(in.readLine()) / 100 * 100;
		int divisor = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 가장 작은 나누어 떨어지는 수를 탐색
		for (int num = dividend; num < dividend + 100; num++) {
			
			// 해당 숫자가 나누는 정수로 나누어 떨어지는 경우
			if (num % divisor == 0) {
				
				// format() 및 write() 메서드를 사용해 해당 숫자의 뒤 두 자리를 정해진 형식으로 출력
				out.write(String.format("%02d", num % 100));
				
				// 반복문 탈출
				break;
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}