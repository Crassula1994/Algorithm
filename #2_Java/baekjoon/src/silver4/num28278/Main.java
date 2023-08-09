package silver4.num28278;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 명령의 수를 변수 commandNum에 할당
		int commandNum = Integer.parseInt(in.readLine());
		
		// 명령을 처리하기 위해 필요한 Stack 객체 stack 초기화
		Stack<Integer> stack = new Stack<>();
		
		// for 반복문을 사용해 입력 받은 각 명령을 순회
		for (int c = 0; c < commandNum; c++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 해당 명령을 변수 command에 할당
			int command = Integer.parseInt(st.nextToken());
			
			// switch 조건문을 사용해 각 명령을 처리
			switch (command) {
			
				// 1이 입력된 경우 숫자를 삽입 후 조건문 탈출
				case 1:
					stack.push(Integer.parseInt(st.nextToken()));
					break;
					
				// 2가 입력된 경우 숫자를 제거, 출력 후 조건문 탈출
				case 2:
					if (stack.isEmpty()) {
						out.write(-1 + "\n");
					} else {
						out.write(stack.pop() + "\n");
					}
					break;
					
				// 3이 입력된 경우 Stack 객체에 들어 있는 정수의 개수를 출력 후 조건문 탈출
				case 3:
					out.write(stack.size() + "\n");
					break;
					
				// 4가 입력된 경우 비어 있으면 1, 아니면 0을 출력 후 조건문 탈출
				case 4:
					if (stack.isEmpty()) {
						out.write(1 + "\n");
					} else {
						out.write(0 + "\n");
					}
					break;
					
				// 5가 입력된 경우 맨 위의 정수를 출력
				default:
					if (stack.isEmpty()) {
						out.write(-1 + "\n");
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