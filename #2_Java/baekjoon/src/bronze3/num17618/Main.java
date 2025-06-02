package bronze3.num17618;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 정수를 변수 numberLimit에 할당
		int numberLimit = Integer.parseInt(in.readLine());
		
		// 신기한 수의 개수를 저장할 변수 count 초기화
		int count = 0;
		
		// for 반복문을 사용해 각 정수를 순회
		for (int number = 1; number <= numberLimit; number++) {
			
			// 해당 정수가 신기한 수인 경우 신기한 수의 개수를 갱신
			if (novelNumberFinder(number))
				count++;
		}
		
		// valueOf() 및 write() 메서드를 사용해 신기한 수의 개수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// novelNumberFinder() 메서드 정의
	public static boolean novelNumberFinder(int number) {
		
		// 피제수 및 제수를 저장할 각 변수 초기화
		int dividend = number;
		int divisor = 0;
		
		// while 반복문을 사용해 해당 숫자를 나눌 제수를 갱신
		while (number > 0) {
			divisor += number % 10;
			number /= 10;
		}
		
		// 해당 숫자가 신기한 수인지 여부를 반환
		return dividend % divisor == 0;
	}
}