package silver1.num30572;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 괄호 문자열의 길이 및 해당 문자열을 각 변수에 할당
		int length = Integer.parseInt(in.readLine());
		String brackets = in.readLine();
		
		// 각 괄호 문자열의 수식을 계산한 결과를 저장할 Stack 객체 bracketCalculator 초기화
		Stack<Integer> bracketCalculator = new Stack<>();
		
		// push() 메서드를 사용해 초기 수식의 값을 bracketCalculator에 추가
		bracketCalculator.push(0);
		
		// for 반복문을 사용해 각 괄호 문자열을 순회
		for (int idx = 0; idx < length; idx++) {
			
			// 해당 괄호 문자열이 여는 괄호인 경우 해당 괄호의 초기 값을 bracketCalculator에 추가
			if (brackets.charAt(idx) == '(') {
				bracketCalculator.push(0);
				
			// 해당 괄호 문자열이 닫는 괄호인 경우
			} else {
				
				// pop() 메서드를 사용해 현재 값 및 이전 값을 각 변수에 할당
				int curValue = bracketCalculator.pop() + 1;
				int prevValue = bracketCalculator.pop();
				
				// max() 메서드를 사용해 닫힌 괄호에 해당하는 값을 이전 값에 반영 후 이를 제거
				prevValue = Math.max(prevValue, 1) * curValue;
				
				// push() 메서드를 사용해 갱신된 값을 bracketCalculator에 추가
				bracketCalculator.push(prevValue);
			}
		}
		
		// peek(), valueOf(), write() 메서드를 사용해 괄호 문자열의 수식을 계산한 결과를 출력
		out.write(String.valueOf(bracketCalculator.peek()));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}