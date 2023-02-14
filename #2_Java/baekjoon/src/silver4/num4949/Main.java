package silver4.num4949;

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
		
		// while 반복문을 사용해 각 문자열을 순회
		while (true) {
			
			// readLine() 메서드를 사용해 입력 받은 문장을 변수 sentence에 할당
			String sentence = in.readLine();
			
			// 종료 조건이 입력된 경우 반복문 탈출
			if (sentence.equals("."))
				break;
			
			// 각 괄호를 저장할 Stack 객체 balance 초기화
			Stack<Character> balance = new Stack<>();
			
			// for 반복문을 사용해 문자열의 각 문자를 순회
			for (int idx = 0; idx < sentence.length(); idx++) {
	
				// charAt() 메서드를 사용해 해당 문자를 변수 character에 할당
				char character = sentence.charAt(idx);
				
				// 해당 문자가 괄호인 경우 balance에 추가
				if (character == '(' || character == ')' || character == '[' || character == ']') {
					balance.push(character);
					
					// 소괄호가 짝을 이루는 경우 소괄호를 balance에서 제거
					if (character == ')' && balance.size() > 1 && balance.get(balance.size() - 2) == '(') {
						balance.pop();
						balance.pop();
					}
					
					// 대괄호가 짝을 이루는 경우 소괄호를 balance에서 제거
					if (character == ']' && balance.size() > 1 && balance.get(balance.size() - 2) == '[') {
						balance.pop();
						balance.pop();
					}
				}
			}
			
			// 해당 문자열이 균형 잡힌 문자열인지 알려주는 문자열을 isBalanced 변수에 할당
			String isBalanced = (balance.size() == 0) ? "yes" : "no";
			
			// write() 메서드를 사용해 균형 잡힌 문자열인지 알려주는 문자열을 출력
			out.write(isBalanced + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}