package silver3.num15276;

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
		
		// readLine() 메서드를 사용해 입력 받은 입력 받은 여섯 자리 숫자의 개수를 저장할 변수 numberCnt 초기화
		int numberCnt = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 여섯 자리 숫자를 순회
		while (numberCnt-- > 0) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
			int number = Integer.parseInt(in.readLine());
			
			// 해당 숫자와의 차이를 저장할 변수 difference 초기화
			int difference = 0;
			
			// while 반복문을 사용해 각 숫자를 순회
			while (true) {
				
				// 해당 숫자보다 차이만큼 더 작은 숫자가 회문인 경우 해당 숫자를 출력 후 반복문 탈출
				if (palindromeChecker(number - difference)) {
					out.write((number - difference) + "\n");
					break;
				}
			
				// 해당 숫자보다 차이만큼 더 큰 숫자가 회문인 경우 해당 숫자를 출력 후 반복문 탈출
				if (palindromeChecker(number + difference)) {
					out.write((number + difference) + "\n");
					break;
				}
				
				// 해당 숫자와의 차이를 갱신
				difference++;
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// palindromeChecker() 메서드 정의
	public static boolean palindromeChecker(int number) {
		
		// 해당 숫자가 여섯 자리 숫자가 아닌 경우 false 반환
		if (number < 100000 || number > 999999)
			return false;
		
		// valueOf() 메서드를 사용해 해당 숫자를 문자열로 변환한 결과를 변수 numberString에 할당
		String numberString = String.valueOf(number);
		
		// for 반복문을 사용해 각 숫자의 자릿수를 순회
		for (int idx = 0; idx < numberString.length() / 2; idx++) {
			
			// 해당 자릿수가 일치하지 않는 경우 false 반환
			if (numberString.charAt(idx) != numberString.charAt(numberString.length() - idx - 1))
				return false;
		}
		
		// 해당 숫자가 회문인 경우 true 반환
		return true;
	}
}