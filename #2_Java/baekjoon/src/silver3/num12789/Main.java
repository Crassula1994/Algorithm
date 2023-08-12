package silver3.num12789;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {

	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 학생들의 수를 변수 studentNum에 할당
		int studentNum = Integer.parseInt(in.readLine());
		
		// 현재 대기열의 학생을 저장할 Queue 객체 originalLine 초기화
		Queue<Integer> originalLine = new LinkedList<>();
		
		// 이동할 수 있는 공간에 학생을 저장할 Stack 객체 newLine 초기화
		Stack<Integer> newLine = new Stack<>();
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 현재 대기열의 학생을 originalLine에 추가
		for (int idx = 0; idx < studentNum; idx++)
			originalLine.add(Integer.parseInt(st.nextToken()));
		
		// 현재 간식을 받아야 하는 번호표의 번호를 저장할 변수 number 초기화
		int number = 1;
		
		// while 반복문을 사용해 현재 대기열의 학생이 없어질 때까지 순회
		while (!originalLine.isEmpty()) {
			
			// 현재 대기열의 가장 앞에 서 있는 사람이 해당 번호표의 학생인 경우
			if (originalLine.peek() == number) {
				
				// poll() 메서드를 사용해 해당 학생을 제거 후 현재 간식을 받아야 하는 번호표의 번호를 갱신
				originalLine.poll();
				number++;
			
			// 이동할 수 있는 공간의 가장 앞에 서 있는 사람이 해당 번호표의 학생인 경우
			} else if (!newLine.isEmpty() && newLine.peek() == number) {
				
				// pop() 메서드를 사용해 해당 학생을 제거 후 현재 간식을 받아야 하는 번호표의 번호를 갱신
				newLine.pop();
				number++;

			// 현재 대기열과 이동할 수 있는 공간에서 해당 번호표를 찾지 못한 경우
			} else {
				
				// push() 및 poll() 메서드를 사용해 현재 대기열의 학생을 이동할 수 있는 공간으로 이동
				newLine.push(originalLine.poll());
			}
		}
		
		// while 반복문을 사용해 이동할 수 있는 공간의 모든 사람이 없어질 때까지 순회
		while (!newLine.isEmpty()) {
			
			// 이동할 수 있는 공간의 가장 앞에 서 있는 사람이 해당 번호표의 학생인 경우
			if (newLine.peek() == number) {
				
				// pop() 메서드를 사용해 해당 학생을 제거 후 현재 간식을 받아야 하는 번호표의 번호를 갱신
				newLine.pop();
				number++;
				
			// 이동할 수 있는 공간의 가장 앞에 서 있는 사람이 해당 번호표의 학생인 경우 반복문 탈출
			} else {
				break;
			}
		}
		
		// 승환이가 무사히 간식을 받을 수 있는 경우 'Nice' 출력
		if (newLine.isEmpty()) {
			out.write("Nice");
			
		// 승환이가 무사히 간식을 받을 수 없는 경우 'Sad' 출력
		} else {
			out.write("Sad");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}