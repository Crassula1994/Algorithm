package silver5.num04673;

// 필요한 패키지 불러오기
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedWriter 객체를 불러와 변수 out에 할당
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 10000까지 숫자에 대해 생성자의 숫자를 저장할 배열 numbers 초기화
		int[] numbers = new int[10000];
		
		// for 반복문을 사용해 10000까지의 수를 순회
		for (int number = 1; number < 10001; number++) {
			
			// 해당 숫자와 각 자릿수를 더한 결과를 저장할 인덱스를 변수 resultIndex에 할당
			int resultIndex = calculate(number) - 1;
			
			// resultIndex가 배열의 범위에 있는 경우 생성자의 숫자를 갱신
			if (resultIndex < 10000)
				numbers[resultIndex]++;
		}
		
		// for 반복문을 사용해 배열 numbers의 각 원소를 순회
		for (int i = 0; i < numbers.length; i++) {
			
			// 생성자가 없는 셀프 넘버인 경우 write() 메서드를 사용해 출력
			if (numbers[i] == 0)
				out.write((i + 1) + "\n");
		}
		
		// close() 메서드를 사용해 BufferedWriter 객체 종료
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// calculate() 메서드 정의
	public static int calculate(int number) {
		
		// 입력 받은 숫자를 변수 result에 할당
		int result = number;
		
		// while 반복문을 사용해 각 자릿수를 result에 합산
		while (number != 0) {
			result += number % 10;
			number = number / 10;
		}
		
		// 연산 결과를 반환
		return result;
	}
}