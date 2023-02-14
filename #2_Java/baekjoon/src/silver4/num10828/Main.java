package silver4.num10828;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 명령어의 수를 변수 commands에 할당
		int commands = Integer.parseInt(in.readLine());
		
		// 정수를 저장할 Stack 객체 stack 초기화
		Stack<Integer> stack = new Stack<>();
		
		// for 반복문을 사용해 각 명령어를 순회
		for (int c = 0; c < commands; c++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 메서드를 사용해 입력 받은 명령어를 command에 할당
			String command = st.nextToken();
			
			// switch 조건문을 사용해 명령어에 따라 명령 수행
			switch (command) {
			
			// 'push'를 입력받은 경우
			case "push":
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
				int number = Integer.parseInt(st.nextToken());
				
				// push() 메서드를 사용해 Stack 객체에 숫자 추가
				stack.push(number);
				
				// 조건문 탈출
				break;
			
			// 'pop'을 입력받은 경우
			case "pop" :
				
				// Stack 객체가 빈 경우 -1 출력
				if (stack.isEmpty()) {
					out.write(-1 + "\n");
				
				// Stack 객체가 비지 않은 경우 가장 앞에 있는 정수 출력
				} else {
					out.write(stack.pop() + "\n");
				}
				
				// 조건문 탈출
				break;
			
			// 'size'를 입력받은 경우
			case "size":
				
				// size() 및 write() 메서드를 사용해 정수의 개수 출력 후 조건문 탈출
				out.write(stack.size() + "\n");
				break;
				
			// 'empty'를 입력받은 경우
			case "empty":
				
				// isEmpty() 메서드를 사용해 Stack 객체가 비어있는 경우 1, 그렇지 않은 경우 0을 변수 empty에 저장
				int empty = (stack.isEmpty()) ? 1 : 0;
				
				// write() 메서드를 사용해 Stack 객체가 비어있는지 여부를 출력 후 조건문 탈출
				out.write(empty  + "\n");
				break;
				
			// 'top'을 입력받은 경우
			case "top":
				
				// Stack 객체가 빈 경우 -1 출력
				if (stack.isEmpty()) {
					out.write(-1 + "\n");
					
				// Stack 객체가 비지 않은 경우 가장 마지막에 있는 정수 출력
				} else {
					out.write(stack.peek() + "\n");
				}
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}