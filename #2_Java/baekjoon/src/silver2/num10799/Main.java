package silver2.num10799;

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
		
		// readLine() 메서드를 사용해 입력 받은 괄호 표현을 변수 bracketString에 할당
		String bracketString = in.readLine();
		
		// 잘려진 쇠막대기의 수를 저장할 변수 totalCnt 초기화
		int totalCnt = 0;
		
		// 현재 쌓인 쇠막대기의 수를 저장할 변수 fagot 초기화
		int fagot = 0;
		
		// 괄호 문자를 차례로 저장할 Stack 객체 bracketStack 초기화
		Stack<Character> bracketStack = new Stack<>();
		
		// for 반복문을 사용해 각 괄호 문자를 순회
		for (int idx = 0; idx < bracketString.length(); idx++) {
			
			// charAt() 메서드를 사용해 괄호 문자를 변수 bracket에 할당
			char bracket = bracketString.charAt(idx);
			
			// '(' 문자가 입력되는 경우
			if (bracket == '(') {
				
				// 쌓인 쇠막대기의 수 갱신
				fagot++;
			
			// 레이저가 입력되는 경우
			} else if (bracket == ')' && bracketStack.peek() == '(') {
				
				// 쌓인 쇠막대기의 수 갱신
				fagot--;
			
				// 쌓인 쇠막대기의 수만큼 잘린 쇠막대기 수 갱신
				totalCnt += fagot;
				
			// ')' 문자가 입력되는 경우
			} else {
				
				// 쌓인 쇠막대기의 수 갱신
				fagot--;
				
				// 잘린 쇠막대기 수 갱신
				totalCnt++;
			}
			
			// add() 메서드를 사용해 bracketStack에 괄호 문자 추가
			bracketStack.add(bracket);
		}

		// valueOf() 및 write() 메서드를 사용해 잘린 쇠막대기 수를 출력
		out.write(String.valueOf(totalCnt));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}