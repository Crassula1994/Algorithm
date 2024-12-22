package silver1.num30047;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 메서드를 사용해 입력 받은 함수 문자열을 변수 functionString에 할당
		String functionString = in.readLine();
		
		// stringChecker(), valueOf(), write() 메서드를 사용해 주어진 함수 문자열의 값을 출력
		out.write(String.valueOf(stringChecker(functionString)));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// stringChecker() 메서드 정의
	private static int stringChecker(String functionString) {
		
		// 함수 문자열의 값을 저장할 Stack 객체 valueCalculator 초기화
		Stack<Integer> valueCalculator = new Stack<>();
		
		// for 반복문을 사용해 함수 문자열의 각 글자를 거꾸로 순회
		for (int idx = functionString.length() - 1; idx >= 0; idx--) {
			
			// charAt() 메서드를 사용해 해당 함수 문자열의 글자를 변수 character에 할당
			char character = functionString.charAt(idx);
			
			// switch 조건문을 사용해 각 문자열의 글자를 확인
			switch (character) {
			
				// 해당 글자가 'x'인 경우 valueCalculator에 0을 추가
				case 'x':
					valueCalculator.push(0);
					break;
					
				// 해당 글자가 'g'인 경우
				case 'g':
					
					// valueCalculator가 비어 있는 경우 함수 문자열이 아니므로 -1을 반환
					if (valueCalculator.isEmpty())
						return -1;
					
					// pop() 및 push() 메서드를 사용해 저장된 값에 1을 더한 값을 valueCalculator에 추가
					valueCalculator.push(valueCalculator.pop() + 1);
					break;
					
				// 해당 글자가 'f'인 경우
				default:
					
					// valueCalculator에 2개 이상의 값이 존재하지 않는 경우 함수 문자열이 아니므로 -1을 반환
					if (valueCalculator.size() < 2)
						return -1;
					
					// pop(), min(), push() 메서드를 사용해 두 값 중 더 작은 값을 valueCalculator에 저장
					valueCalculator.push(Math.min(valueCalculator.pop(), valueCalculator.pop()));
			}
		}
		
		// valueCalculator에 2개 이상의 값이 있는 경우 함수 문자열이 아니므로 -1을 반환
		if (valueCalculator.size() >= 2)
			return -1;
		
		// peek() 메서드를 사용해 valueCalculator에 남아 있는 값을 반환
		return valueCalculator.peek();
	}
}