package silver3.num01463;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 1을 만들기 위한 최소 연산의 횟수를 저장할 배열 calculation 초기화
	static int[] calculation = new int[1000001];
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
		int number = Integer.parseInt(in.readLine());
		
		// calculator() 메서드를 호출해 그 결과를 변수 result에 할당
		int result = calculator(number);
			
		// valueOf() 및 write() 메서드를 사용해 파도반 수열의 결과를 출력
		out.write(String.valueOf(result));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// calculator() 메서드 정의
	public static int calculator(int number) {
		
		// 최소 연산의 횟수가 저장되어 있는 경우 해당 횟수 반환
		if (number < 2 || calculation[number] != 0) {
			return calculation[number];
		
		// 최소 연산의 횟수가 저장되어 있지 않은 경우
		} else {
			
			// 6으로 나누어 떨어지는 경우 
			if (number % 6 == 0) {
				
				// min() 메서드를 사용해 3으로 나누는 경우와 2로 나누는 경우, 1을 뺀 경우의 수 중 작은 값을 배열에 저장
				calculation[number] = Math.min(calculator(number - 1), Math.min(calculator(number / 3), calculator(number / 2))) + 1;
			
			// 3으로 나누어 떨어지는 경우
			} else if (number % 3 == 0) {
				
				// min() 메서드를 사용해 3으로 나누는 경우와 1을 뺀 경우의 수 중 작은 값을 배열에 저장
				calculation[number] = Math.min(calculator(number / 3), calculator(number - 1)) + 1;
				
			// 2로 나누어 떨어지는 경우
			} else if (number % 2 == 0) {
				
				// min() 메서드를 사용해 2로 나누는 경우와 1을 뺀 경우의 수 중 작은 값을 배열에 저장
				calculation[number] = Math.min(calculator(number / 2), calculator(number - 1)) + 1;
			
			// 3과 2 모두 나누어 떨어지지 않는 경우 1을 빼고 calculator() 메서드를 재귀 호출해 결과를 배열에 저장
			} else {
				calculation[number] = calculator(number - 1) + 1;
			}

			// 결과 값 반환
			return calculation[number];
		}
	}
}