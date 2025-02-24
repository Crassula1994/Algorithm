package silver3.num02659;

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
		
		// 입력 받은 카드의 시계수의 순서를 저장할 변수 targetOrder 초기화
		int targetOrder = 1;
		
		// 입력 받은 카드의 자릿수를 저장할 배열 targetDigits 초기화
		int[] targetDigits = new int[4];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 카드의 자릿수를 배열 targetDigits에 저장
		for (int idx = 0; idx < targetDigits.length; idx++)
			targetDigits[idx] = Integer.parseInt(st.nextToken());
		
		// clockNumberFinder() 메서드를 호출해 입력 받은 카드의 시계수를 변수 targetNumber에 할당
		int targetNumber = clockNumberFinder(targetDigits);
		
		// for 반복문을 사용해 입력 받은 카드의 시계수보다 작은 시계수일 수 있는 숫자를 순회
		for (int number = 1111; number < targetNumber; number++) {
			
			// 해당 숫자의 각 자릿수를 저장한 배열 digits 초기화
			int[] digits = new int[] {number / 1000, (number / 100) % 10, (number / 10) % 10, number % 10};
			
			// 해당 숫자가 시계수인 경우 입력 받은 카드의 시계수의 순서를 갱신
			if (clockNumberFinder(digits) == number)
				targetOrder++;
		}
		
		// valueOf() 및 write() 메서드를 사용해 입력 받은 카드의 시계수의 순서를 출력
		out.write(String.valueOf(targetOrder));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// clockNumberFinder() 메서드 정의
	public static int clockNumberFinder(int[] digits) {
		
		// 해당 카드의 시계수를 저장할 변수 targetNumber 초기화
		int targetNumber = Integer.MAX_VALUE;
		
		// for 반복문을 사용해 가능한 각 시작 위치를 순회
		for (int start = 0; start < 4; start++) {
			
			// 해당 위치에서 만들 수 있는 숫자를 저장할 변수 number 초기화
			int number = 0;
			
			// for 반복문을 사용해 해당 위치에서 만들 수 있는 숫자를 갱신
			for (int idx = 0; idx < 4; idx++)
				number = number * 10 + digits[(start + idx) % 4];
			
			// min() 메서드를 사용해 해당 카드의 시계수를 갱신
			targetNumber = Math.min(number, targetNumber);
		}
		
		// 해당 카드의 시계수를 반환
		return targetNumber;
	}
}