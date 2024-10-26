package bronze3.num11966;

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

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
		int number = Integer.parseInt(in.readLine());
		
		// 해당 숫자가 2의 제곱수인지 여부를 나타낼 변수 isSquare 초기화
		boolean isSquare = true;
		
		// while 반복문을 사용해 해당 숫자가 2의 제곱수인지 여부를 알 수 있을 때까지 순회
		while (number > 1) {
			
			// 해당 숫자가 2의 제곱수가 아닌 경우 2의 제곱수인지 여부를 갱신 후 반복문 탈출
			if (number % 2 != 0) {
				isSquare = false;
				break;
			}
			
			// 해당 숫자를 2로 나누어 갱신
			number /= 2;
		}
		
		// valueOf() 및 write() 메서드를 사용해 해당 숫자가 2의 제곱수인지 여부를 출력
		out.write((isSquare) ? String.valueOf(1) : String.valueOf(0));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}