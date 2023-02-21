package silver5.num1676;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 팩토리얼의 수를 변수 factorial에 할당
		int factorial = Integer.parseInt(in.readLine());
		
		// 0의 개수를 셀 변수 count 초기화
		int count = 0;
		
		// for 반복문을 사용해 입력받은 수까지 차례로 순회
		for (int n = 0; n < factorial; n++) {
			
			// 검사할 숫자를 변수 number에 할당
			int number = n + 1;
			
			// while 반복문을 사용해 5로 나누어 떨어지는 횟수를 계산
			while (number % 5 == 0) {
				count++;
				number /= 5;
			}			
		}
		
		// valueOf() 및 write() 메서드를 사용해 0의 개수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}