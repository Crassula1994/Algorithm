package silver4.num28279;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
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
		
		// 명령을 처리하기 위해 필요한 Deque 객체 deque 초기화
		Deque<Integer> deque = new LinkedList<>();
		
		// for 반복문을 사용해 입력 받은 각 명령을 순회
		for (int c = 0; c < commandNum; c++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 해당 명령을 변수 command에 할당
			int command = Integer.parseInt(st.nextToken());
			
			// switch 조건문을 사용해 각 명령을 처리
			switch (command) {
			
				// 1이 입력된 경우 숫자를 deque의 앞에 삽입 후 조건문 탈출
				case 1:
					deque.addFirst(Integer.parseInt(st.nextToken()));
					break;
					
				// 2가 입력된 경우 숫자를 deque의 뒤에 삽입 후 조건문 탈출
				case 2:
					deque.addLast(Integer.parseInt(st.nextToken()));
					break;
					
				// 3이 입력된 경우 숫자를 deque의 앞에서 제거, 출력 후 조건문 탈출
				case 3:
					if (deque.isEmpty()) {
						out.write(-1 + "\n");
					} else {
						out.write(deque.pollFirst() + "\n");
					}
					break;
					
				// 4가 입력된 경우 숫자를 deque의 뒤에서 제거, 출력 후 조건문 탈출
				case 4:
					if (deque.isEmpty()) {
						out.write(-1 + "\n");
					} else {
						out.write(deque.pollLast() + "\n");
					}
					break;
					
				// 5가 입력된 경우 Deque 객체에 들어 있는 정수의 개수를 출력 후 조건문 탈출
				case 5:
					out.write(deque.size() + "\n");
					break;
					
				// 6이 입력된 경우 비어 있으면 1, 아니면 0을 출력 후 조건문 탈출
				case 6:
					if (deque.isEmpty()) {
						out.write(1 + "\n");
					} else {
						out.write(0 + "\n");
					}
					break;
					
				// 7이 입력된 경우 맨 앞의 정수를 출력 후 조건문 탈출
				case 7:
					if (deque.isEmpty()) {
						out.write(-1 + "\n");
					} else {
						out.write(deque.peekFirst() + "\n");
					}
					break;
				
				// 8이 입력된 경우 맨 뒤의 정수를 출력
				default:
					if (deque.isEmpty()) {
						out.write(-1 + "\n");
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