package d4.num1218;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// Solution 클래스 정의
public class Solution {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < 10; tc++) {
			
			// 영수증의 액수를 저장할 Stack 객체 brackets 초기화
			Stack<Character> brackets = new Stack<>();
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 괄호 문자열의 길이를 변수 length에 할당
			int length = Integer.parseInt(in.readLine());
			
			// readLine() 메서드를 사용해 입력 받은 괄호 문자열을 변수 bracketStr에 할당
			String bracketStr = in.readLine();
			
			// for 반복문을 사용해 문자의 각 글자를 순회
			for (int idx = 0; idx < length; idx++) {
				
				// charAt() 메서드를 사용해 괄호 글자를 변수 bracket에 할당
				char bracket = bracketStr.charAt(idx);
				
				// Stack 객체가 비지 않은 경우
				if (!brackets.isEmpty()) {
					
					// ')' 문자열이 '('를 만난 경우 pop() 메서드를 사용해 제거
					if (bracket == ')' && brackets.peek() == '(') {
						brackets.pop();
						continue;
	
					// ']' 문자열이 '['를 만난 경우 pop() 메서드를 사용해 제거
					} else if (bracket == ']' && brackets.peek() == '[') {
						brackets.pop();
						continue;
					
					// '}' 문자열이 '{'를 만난 경우 pop() 메서드를 사용해 제거
					} else if (bracket == '}' && brackets.peek() == '{') {
						brackets.pop();
						continue;
					
					// '>' 문자열이 '<'를 만난 경우 pop() 메서드를 사용해 제거
					} else if (bracket == '>' && brackets.peek() == '<') {
						brackets.pop();
						continue;
					}
				}
				
				// push() 메서드를 사용해 brackets에 추가
				brackets.push(bracket);
			}
			
			// isEmpty() 메서드를 사용해 괄호의 짝이 맞는지를 나타내는 변수 isCorrect 초기화
			int isCorrect = (brackets.isEmpty()) ? 1 : 0;

			// write() 메서드를 사용해 괄호의 짝이 맞는지를 출력
			out.write("#" + (tc + 1) + " " + isCorrect + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}