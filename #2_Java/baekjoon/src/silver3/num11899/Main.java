package silver3.num11899;

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
		
		// readLine() 및 toCharArray() 메서드를 사용해 입력 받은 올바르지 않은 괄호열을 배열 brackets에 할당
		char[] brackets = in.readLine().toCharArray();
		
		// 올바른 괄호열이 되기 위해 필요한 괄호의 최소 개수를 세기 위한 Stack 객체 bracketCounter 초기화
		Stack<Character> bracketCounter = new Stack<>();
		
		// for 반복문을 사용해 각 괄호를 순회
		for (int idx = 0; idx < brackets.length; idx++) {
			
			// 해당 괄호가 현재 올바르지 않은 괄호열인 경우 bracketCounter에 이를 추가
			if (brackets[idx] == '(' || bracketCounter.isEmpty() || bracketCounter.peek() == ')') {
				bracketCounter.push(brackets[idx]);
				
			// 해당 괄호열이 올바른 괄호열인 경우 bracketCounter에서 제거
			} else {
				bracketCounter.pop();
			}
		}
			
		// size(), valueOf(), write() 메서드를 사용해 올바른 괄호열이 되기 위해 필요한 괄호의 최소 개수를 출력
		out.write(String.valueOf(bracketCounter.size()));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}