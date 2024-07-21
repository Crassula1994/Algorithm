package bronze3.num04504;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 정수를 변수 divisor에 할당
		int divisor = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 목록에 있는 수를 순회
		while (true) {
			
			// readLine() 및 parseInt() 메서드를 사용해 목록에 들어있는 수를 변수 dividend에 할당
			int dividend = Integer.parseInt(in.readLine());
			
			// 목록이 끝난 경우 반복문 탈출
			if (dividend == 0)
				break;
			
			// 목록에 있는 수가 주어진 정수의 배수인 경우 정해진 문구를 출력
			if (dividend % divisor == 0) {
				out.write(dividend + " is a multiple of " + divisor + ".");
				
			// 목록에 있는 수가 주어진 정수의 배수가 아닌 경우 정해진 문구를 출력
			} else {
				out.write(dividend + " is NOT a multiple of " + divisor + ".");
			}
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}