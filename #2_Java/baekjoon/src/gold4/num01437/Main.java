package gold4.num01437;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 분해 곱의 최댓값을 나눌 제수를 나타낼 상수 DIVISOR 초기화
	static final int DIVISOR = 10007;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
		int number = Integer.parseInt(in.readLine());
		
		// 5 미만의 정수가 입력된 경우 해당 숫자를 그대로 출력
		if (number < 5) {
			out.write(String.valueOf(number));
		
		// 5 이상의 정수가 입력된 경우
		} else {
			
			// 분해 곱의 최댓값을 저장할 변수 maxValue 초기화
			int maxValue = (number % 3 != 0) ? (number % 3 == 2) ? 2 : 4 : 1;
			
			// 주어진 숫자를 3으로 나눈 나머지가 1인 경우 주어진 숫자를 갱신
			if (number % 3 == 1)
				number -= 4;

			// for 반복문을 사용해 각 숫자를 순회
			for (int count = 0; count < number / 3; count++)
				maxValue = (maxValue * 3) % DIVISOR;
			
			// valueOf() 및 write() 메서드를 사용해 분해 곱의 최댓값을 출력
			out.write(String.valueOf(maxValue));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}