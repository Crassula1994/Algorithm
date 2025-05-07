package bronze2.num01357;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());

		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 각 변수에 할당
		int number1 = Integer.parseInt(st.nextToken());
		int number2 = Integer.parseInt(st.nextToken());

		// reverse() 메서드를 호출해 원하는 결과를 계산하고 그 결과를 변수 result에 할당
		int result = reverse(reverse(number1) + reverse(number2));

		// valueOf() 및 write() 메서드를 사용해 계산 결과를 출력
		out.write(String.valueOf(result));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------

	// reverse() 메서드 정의
	public static int reverse(int number) {
		
		// 뒤집힌 숫자를 저장할 변수 reversedNumber 초기화
		int reversedNumber = 0;
		
		// while 반복문을 사용해 각 자리 숫자를 반대로 저장
		while (number != 0) {

			// 뒤집힌 숫자를 갱신
			reversedNumber *= 10;

			// 뒤집힌 숫자에 해당 숫자를 갱신
			reversedNumber += number % 10;

			// 해당 숫자를 갱신
			number /= 10;
		}

		// 뒤집힌 숫자를 반환
		return reversedNumber;
	}
}