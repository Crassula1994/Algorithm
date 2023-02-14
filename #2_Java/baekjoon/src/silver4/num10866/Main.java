package silver4.num10866;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
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
		
		// 정수를 저장할 Deque 객체 deque 초기화
		Deque<Integer> deque = new ArrayDeque<>();
		
		// for 반복문을 사용해 각 명령어를 순회
		for (int c = 0; c < commands; c++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 메서드를 사용해 입력 받은 명령어를 command에 할당
			String command = st.nextToken();
			
			// 입력 받은 숫자를 저장할 변수 number 초기화
			int number = 0;
			
			// switch 조건문을 사용해 명령어에 따라 명령 수행
			switch (command) {
			
			// 'push_front'를 입력받은 경우
			case "push_front":
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
				number = Integer.parseInt(st.nextToken());
				
				// addFirst() 메서드를 사용해 Deque 객체에 숫자 추가
				deque.addFirst(number);
				
				// 조건문 탈출
				break;
				
			// 'push_back'을 입력받은 경우
			case "push_back":
					
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
				number = Integer.parseInt(st.nextToken());
				
				// addLast() 메서드를 사용해 Deque 객체에 숫자 추가
				deque.addLast(number);
				
				// 조건문 탈출
				break;
			
			// 'pop_front'를 입력받은 경우
			case "pop_front" :
				
				// Deque 객체가 빈 경우 -1 출력
				if (deque.isEmpty()) {
					out.write(-1 + "\n");
				
				// Deque 객체가 비지 않은 경우 가장 앞에 있는 정수 출력
				} else {
					out.write(deque.pollFirst() + "\n");
				}
				
				// 조건문 탈출
				break;
				
			// 'pop_back'을 입력받은 경우
			case "pop_back" :
				
				// Deque 객체가 빈 경우 -1 출력
				if (deque.isEmpty()) {
					out.write(-1 + "\n");
				
				// Deque 객체가 비지 않은 경우 가장 뒤에 있는 정수 출력
				} else {
					out.write(deque.pollLast() + "\n");
				}
				
				// 조건문 탈출
				break;
			
			// 'size'를 입력받은 경우
			case "size":
				
				// size() 및 write() 메서드를 사용해 정수의 개수 출력 후 조건문 탈출
				out.write(deque.size() + "\n");
				break;
				
			// 'empty'를 입력받은 경우
			case "empty":
				
				// isEmpty() 메서드를 사용해 Deque 객체가 비어있는 경우 1, 그렇지 않은 경우 0을 변수 empty에 저장
				int empty = (deque.isEmpty()) ? 1 : 0;
				
				// write() 메서드를 사용해 Stack 객체가 비어있는지 여부를 출력 후 조건문 탈출
				out.write(empty  + "\n");
				break;
				
			// 'front'를 입력받은 경우
			case "front" :
				
				// Deque 객체가 빈 경우 -1 출력
				if (deque.isEmpty()) {
					out.write(-1 + "\n");
				
				// Deque 객체가 비지 않은 경우 가장 앞에 있는 정수 출력
				} else {
					out.write(deque.peekFirst() + "\n");
				}
				
				// 조건문 탈출
				break;
				
			// 'back'을 입력받은 경우
			case "back" :
				
				// Deque 객체가 빈 경우 -1 출력
				if (deque.isEmpty()) {
					out.write(-1 + "\n");
				
				// Deque 객체가 비지 않은 경우 가장 뒤에 있는 정수 출력
				} else {
					out.write(deque.peekLast() + "\n");
				}
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}