package silver3.num01935;

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

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 피연산자의 개수를 변수 operandNum에 할당
		int operandNum = Integer.parseInt(in.readLine());
		
		// 각 피연산자의 값을 저장할 배열 operands 초기화
		int[] operands = new int[operandNum];
		
		// readLine() 메서드를 사용해 입력 받은 후위 표기식을 변수 postfix에 할당
		String postfix = in.readLine();
		
		// for 반복문을 사용해 입력 받은 각 피연산자의 값을 배열 operands에 저장
		for (int idx = 0; idx < operandNum; idx++)
			operands[idx] = Integer.parseInt(in.readLine());
		
		// 연산 결과를 저장할 Stack 객체 results 초기화
		Stack<Double> results = new Stack<>();
		
		// for 반복문을 사용해 후위 표기식의 각 요소를 순회
		for (int e = 0; e < postfix.length(); e++) {
			
			// charAt() 메서드를 사용해 해당 요소를 변수 element에 할당
			char element = postfix.charAt(e);
			
			// 해당 요소가 피연산자인 경우 그 값을 찾아 results에 추가
			if (element - 'A' >= 0) {
				results.add((double) operands[element - 'A']);
				
			// 해당 요소가 연산자인 경우
			} else {
				
				// pop() 메서드를 사용해 계산할 두 숫자를 각 변수에 할당
				double result2 = results.pop();
				double result1 = results.pop();
				
				// 해당 요소가 '+' 연산자인 경우 덧셈 연산 후 그 결과를 resulsts에 추가
				if (element == '+') {
					results.add(result1 + result2);
			
				// 해당 요소가 '-' 연산자인 경우 뺄셈 연산 후 그 결과를 results에 추가
				} else if (element == '-') {
					results.add(result1 - result2);
				
				// 해당 요소가 '*' 연산자인 경우 곱셈 연산 후 그 결과를 results에 추가
				} else if (element == '*') {
					results.add(result1 * result2);
					
				// 해당 요소가 '/' 연산자인 경우 나눗셈 연산 후 그 결과를 results에 추가
				} else {
					results.add(result1 / result2);
				}
			}
		}
		
		// format() 및 write() 메서드를 사용해 계산 결과를 소수점 둘째 자리까지 출력
		out.write(String.format("%.2f", results.pop()));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}