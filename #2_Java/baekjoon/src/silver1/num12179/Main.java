package silver1.num12179;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// 멀티팩토리얼(Multifactorial)의 자릿수를 저장할 배열 digits 초기화
		int[] digits = new int[9001];
		
		// for 반복문을 사용해 각 멀티팩토리얼을 순회
		for (int idx = 1; idx < digits.length; idx++) {
			
			// 해당 멀티팩토리얼의 상용로그 값을 저장할 변수 commonLogValue 초기화
			double commonLogValue = 0;
			
			// for 반복문을 사용해 해당 멀티팩토리얼의 상용로그 값을 갱신
			for (int number = 9000; number > 0; number -= idx)
				commonLogValue += Math.log10(number);
			
			// 해당 멀티팩토리얼의 자릿수를 배열 digits에 저장
			digits[idx] = (int) commonLogValue + 1;
		}
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 1; tc <= testCase; tc++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 상대의 파워 레벨의 자릿수를 변수 targetDigit에 할당
			int targetDigit = Integer.parseInt(in.readLine());
			
			// 아니마가 외칠 말을 저장할 변수 speech 초기화
			String speech = "...";
			
			// for 반복문을 사용해 각 멀티팩토리얼의 자릿수를 순회
			for (int idx = 1; idx < digits.length; idx++) {
				
				// 상대의 파워 레벨의 자릿수가 해당 멀티팩토리얼의 자릿수보다 큰 경우
				if (targetDigit > digits[idx]) {
					
					// StringBuilder 객체를 불러와 변수 sb에 할당
					StringBuilder sb = new StringBuilder("IT'S OVER 9000");
					
					// for 반복문을 사용해 해당 멀티팩토리얼만큼 '!'를 sb에 추가
					for (int count = 0; count < idx; count++)
						sb.append("!");
					
					// toString() 메서드를 사용해 아니마가 외칠 말을 갱신
					speech = sb.toString();
					
					// 반복문 탈출
					break;
				}
			}
			
			// format() 및 write() 메서드를 사용해 테스트 케이스 번호 및 아니마가 외칠 말을 출력
			out.write(String.format("Case #%d: %s\n", tc, speech));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}