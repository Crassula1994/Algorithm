package bronze3.num17614;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 정수를 변수 number에 할당
		int number = Integer.parseInt(in.readLine());
		
		// 박수의 총 횟수를 저장할 변수 count 초기화
		int count = 0;
		
		// for 반복문을 사용해 각 숫자를 순회
		for (int n = 1; n <= number; n++) {
			
			// 현재 369게임에서의 숫자를 저장할 변수 curNumber 초기화
			int curNumber = n;
			
			// while 반복문을 사용해 현재 369게임에서의 숫자가 0이 될 때까지 순회
			while (curNumber > 0) {
				
				// 해당 자릿수를 변수 digit에 할당
				int digit = curNumber % 10;
				
				// 해당 자릿수가 3, 6, 9 중 하나인 경우 박수의 총 횟수를 갱신
				if (digit == 3 || digit == 6 || digit == 9)
					count++;
				
				// 현재 369게임에서의 숫자를 갱신
				curNumber /= 10;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 박수의 총 횟수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}