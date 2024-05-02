package gold5.num01038;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Set;
import java.util.TreeSet;

// Main 클래스 정의
public class Main {
	
	// 감소하는 숫자를 저장할 Set 객체 decreasingNumbers 초기화
	static Set<Long> decreasingNumbers;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
		int number = Integer.parseInt(in.readLine());
		
		// 입력 받은 숫자가 10 이하인 경우 입력 받은 숫자를 그대로 출력
		if (number <= 10) {
			out.write(String.valueOf(number));
		
		// 입력 받은 숫자가 1022를 초과하는 경우 감소하는 수가 존재하지 않으므로 -1을 출력
		} else if (number > 1022) {
			out.write(String.valueOf(-1));
			
		// 입력 받은 숫자가 10 초과 1022 이하인 경우
		} else {
			
			// 감소하는 숫자를 저장할 Set 객체 decreasingNumbers 초기화
			decreasingNumbers = new TreeSet<>();
			
			// for 반복문을 사용해 numberGenerator() 메서드를 호출하고, 감소하는 숫자를 저장
			for (int digit = 0; digit < 10; digit++)
				numberGenerator(digit);
			
			// 감소하는 숫자의 순서를 저장할 변수 count 초기화
			int count = 0;
			
			// for 반복문을 사용해 감소하는 숫자를 순회
			for (long decreasingNumber : decreasingNumbers) {
				
				// 감소하는 숫자의 순서가 입력 받은 숫자와 같은 경우 해당 감소하는 숫자를 출력 후 반복문 탈출
				if (count++ == number) {
					out.write(String.valueOf(decreasingNumber));
					break;
				}
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// numberGenerator() 메서드 정의
	public static void numberGenerator(long number) {
		
		// add() 메서드를 사용해 해당 감소하는 수를 decreasingNumbers에 추가
		decreasingNumbers.add(number);
		
		// 가장 마지막에 온 숫자가 0인 경우 메서드 종료
		if (number % 10 == 0)
			return;
		
		// for 반복문을 사용해 다음에 올 수 있는 숫자를 상정해 numberGenerator() 메서드 재귀 호출
		for (long digit = number % 10 - 1; digit >= 0; digit--)
			numberGenerator(number * 10 + digit);
	}
}