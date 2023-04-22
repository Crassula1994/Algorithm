package gold2.num01918;

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

		// readLine() 메서드를 사용해 입력 받은 중위 표기식을 변수 infix에 할당
		String infix = in.readLine();
		
		// 연산자를 저장할 Stack 객체 operators 초기화
		Stack<Character> operators = new Stack<>();
		
		// 변환한 후위 표기식을 저장할 변수 postfix 초기화
		String postfix = "";
		
		// for 반복문을 사용해 중위 표기식의 각 요소를 순회
		for (int e = 0; e < infix.length(); e++) {
			
			// charAt() 메서드를 사용해 해당 요소를 변수 element에 할당
			char element = infix.charAt(e);
			
			// 해당 요소가 연산자가 아닌 경우 후위 표기식에 그대로 추가
			if (element - 'A' >= 0) {
				postfix += element;
				
			// 해당 요소가 '+' 또는 '-' 연산자인 경우
			} else if (element == '+' || element == '-') {
				
				// 가장 마지막으로 저장된 연산자가 없는 경우 operators에 추가
				if (operators.isEmpty()) {
					operators.add(element);

				// 가장 마지막으로 저장된 연산자가 여는 괄호인 경우 operators에 추가
				} else if (operators.peek() == '(') {
					operators.add(element);
				
				// 가장 마지막으로 저장된 연산자가 사칙연산자인 경우
				} else {
					
					// while 반복문을 사용해 operators가 빌 때까지 순회
					while (!operators.isEmpty()) {
						
						// pop() 메서드를 사용해 연산자를 후위 표기식에 추가
						postfix += operators.pop();
						
						// 가장 마지막으로 저장된 연산자가 여는 괄호인 경우 반복문 탈출
						if (!operators.isEmpty() && operators.peek() == '(')
							break;
					}
					
					// add() 메서드를 사용해 해당 연산자를 operators에 추가
					operators.add(element);
				}
				
			// 해당 요소가 '*' 또는 '/' 연산자인 경우
			} else if (element == '*' || element == '/') {
				
				// 가장 마지막으로 저장된 연산자가 없는 경우 operators에 추가
				if (operators.isEmpty()) {
					operators.add(element);
					
				// 가장 마지막으로 저장된 연산자가 여는 괄호 또는 '+' 또는 '-'인 경우 operators에 추가
				} else if (operators.peek() == '(' || operators.peek() == '+' || operators.peek() == '-') {
					operators.add(element);
				
				// 가장 마지막으로 저장된 연산자가 '*' 또는 '/'인 경우
				} else {
					
					// while 반복문을 사용해 operators가 빌 때까지 순회
					while (!operators.isEmpty()) {
						
						// pop() 메서드를 사용해 연산자를 후위 표기식에 추가
						postfix += operators.pop();
						
						// 가장 마지막으로 저장된 연산자가 여는 괄호 또는 '+' 또는 '-'인 경우 반복문 탈출
						if (!operators.isEmpty() && (operators.peek() == '(' || operators.peek() == '+' || operators.peek() == '-'))
							break;
					}
					
					// add() 메서드를 사용해 해당 연산자를 operators에 추가
					operators.add(element);
				}
					
			// 해당 요소가 여는 괄호인 경우 operators에 추가
			} else if (element == '(') {
				operators.add(element);
			
			// 해당 요소가 닫는 괄호인 경우
			} else {
				
				// while 반복문을 사용해 여는 괄호가 나올 때까지 연산자를 후위 표기식에 추가
				while (operators.peek() != '(')
					postfix += operators.pop();
				
				// pop() 메서드를 사용해 여는 괄호를 제거
				operators.pop();
			}
		}
		
		// while 반복문을 사용해 operators가 빌 때까지 연산자를 후위 표기식에 추가
		while (!operators.isEmpty())
			postfix += operators.pop();
		
		// write() 메서드를 사용해 변환한 후위 표기식를 출력
		out.write(postfix);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}