package silver1.num02504;

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
		
		// readLine() 메서드를 사용해 입력 받은 괄호열 문자열를 변수 bracketString에 할당
		String bracketString = in.readLine();
		
		// 각 괄호열 문자열을 계산할 Stack 객체 calculator 초기화
		Stack<Character> calculator = new Stack<>();
		
		// 현재 계산 중인 값 및 계산 결과를 저장할 각 변수 초기화
		int multiplier = 1;
		int result = 0;
		
		// for 반복문을 사용해 각 괄호열 문자열의 괄호를 차례로 순회
		outer: for (int idx = 0; idx < bracketString.length(); idx++) {
			
			// charAt() 메서드를 사용하여 해당 괄호를 변수 bracket에 할당
			char bracket = bracketString.charAt(idx);
			
			// switch 조건문을 사용해 각 괄호의 종류에 따라 계산 처리
			switch (bracket) {
				
				// 해당 괄호가 '('인 경우
				case '(':
					
					// push() 메서드를 사용해 calculator에 추가
					calculator.push(bracket);
					
					// 계산 중인 값을 갱신 후 조건문 탈출
					multiplier *= 2;
					break;
			
				// 해당 괄호가 '['인 경우
				case '[':
					
					// push() 메서드를 사용해 calculator에 추가
					calculator.push(bracket);
					
					// 계산 중인 값을 갱신 후 조건문 탈출
					multiplier *= 3;
					break;
					
				// 해당 괄호가 ')'인 경우
				case ')':
					
					// 올바른 괄호열이 아닌 경우
					if (calculator.isEmpty() || calculator.peek() != '(') {
						
						// 괄호열을 계산한 결과를 0으로 초기화 후 반복문 탈출
						result = 0;
						break outer;
					}
						
					// '()'인 경우 괄호열 계산 결과를 갱신
					if (bracketString.charAt(idx - 1) == '(')
						result += multiplier;
					
					// pop() 메서드를 사용해 '(' 기호를 calcualtor에서 제거
					calculator.pop();
					
					// 계산 중인 값을 갱신 후 조건문 탈출
					multiplier /= 2;
					break;
					
				// 해당 괄호가 ']'인 경우
				case ']':
					
					// 올바른 괄호열이 아닌 경우
					if (calculator.isEmpty() || calculator.peek() != '[') {
						
						// 괄호열을 계산한 결과를 0으로 초기화 후 반복문 탈출
						result = 0;
						break outer;
					}
					
					// '[]'인 경우 괄호열 계산 결과를 갱신
					if (bracketString.charAt(idx - 1) == '[')
						result += multiplier;
					
					// pop() 메서드를 사용해 '[' 기호를 calcualtor에서 제거
					calculator.pop();
					
					// 계산 중인 값을 갱신
					multiplier /= 3;
			}
		}
		
		// 올바른 괄호열이 아닌 경우 0을 출력
		if (!calculator.isEmpty()) {
			out.write(String.valueOf(0));
		
		// 올바른 괄호열인 경우 괄호열을 계산한 결과를 출력
		} else {
			out.write(String.valueOf(result));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}