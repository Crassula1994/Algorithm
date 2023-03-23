package gold5.num05430;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		outer: for (int tc = 0; tc < testCase; tc++) {
			
			// 입력 받은 숫자를 저장할 Deque 객체 integers 초기화
			Deque<Integer> integers = new LinkedList<>();
			
			// 삭제의 방향을 저장할 변수 isLeft 초기화
			boolean isLeft = true;
			
			// readLine() 및 toCharArray() 메서드를 사용해 입력 받은 함수를 배열 functions에 저장
			char[] functions = in.readLine().toCharArray();
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 배열에 들어있는 수의 개수를 변수 size에 할당
			int size = Integer.parseInt(in.readLine());
			
			// readLine() 메서드를 사용해 입력 받은 배열을 변수 arrayString에 할당
			String arrayString = in.readLine();
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(arrayString.substring(1, arrayString.length() - 1), ",");
			
			// for 반복문을 사용해 입력 받은 숫자를 integers에 추가
			for (int n = 0; n < size; n++)
				integers.offerLast(Integer.parseInt(st.nextToken()));
			
			// for 반복문을 사용해 각 함수를 순회
			for (int idx = 0; idx < functions.length; idx++) {
				
				// 해당 함수를 변수 function에 할당
				char function = functions[idx];
				
				// 'R' 함수인 경우 삭제의 방향을 갱신
				if (function == 'R') {
					isLeft = !isLeft;
				
				// 'D' 함수인 경우
				} else {
					
					// 배열이 비어 있는 경우
					if (integers.isEmpty()) {
						
						// write() 메서드를 사용해 오류 출력
						out.write("error\n");
						
						// 다음 테스트 케이스를 순회
						continue outer;
					
					// 배열이 비어 있지 않고, 왼쪽부터 삭제하는 경우 가장 왼쪽의 값을 삭제
					} else if (isLeft) {
						integers.pollFirst();

					// 배열이 비어 있지 않고, 오른쪽부터 삭제하는 경우 가장 오른쪽의 값을 삭제
					} else {
						integers.pollLast();
					}
				}
			}
			
			// write() 메서드를 사용해 여는 괄호를 출력
			out.write("[");
			
			// 왼쪽부터 출력해야 하는 경우
			if (isLeft) {
				
				// while 반복문을 사용해 값이 하나 이하로 남을 때까지 순회
				while (integers.size() > 1) {
					
					// pollFirst() 및 write() 메서드를 사용해 각 숫자를 차례로 출력
					out.write(integers.pollFirst() + ",");
				}
				
			// 오른쪽부터 출력해야 하는 경우
			} else {
				
				// while 반복문을 사용해 값이 하나 이하로 남을 때까지 순회
				while (integers.size() > 1) {
					
					// pollFirst() 및 write() 메서드를 사용해 각 숫자를 차례로 출력
					out.write(integers.pollLast() + ",");
				}
			}
			
			// 마지막 하나의 값이 있는 경우 출력
			if (!integers.isEmpty())
				out.write(String.valueOf(integers.poll()));
			
			// write() 메서드를 사용해 닫는 괄호를 출력
			out.write("]\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}