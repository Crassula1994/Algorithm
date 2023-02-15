package silver2.num1874;

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
		
		// StringBuilder 객체를 불러와 변수 sb에 할당
		StringBuilder sb = new StringBuilder();
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 수열의 길이를 변수 length에 할당
		int length = Integer.parseInt(in.readLine());
		
		// 수열을 저장할 Stack 객체 stack 초기화
		Stack<Integer> stack = new Stack<>();
		
		// 입력 받은 가장 큰 값을 저장할 변수 maxNum 초기화
		int maxNum = 0;
		
		// 해당 수열을 만들 수 있는지를 나타내는 변수 isPossible 초기화
		boolean isPossible = true;
		
		// for 반복문을 사용해 각 수열의 숫자를 순회
		for (int line = 0; line < length; line++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
			int number = Integer.parseInt(in.readLine());
			
			// 입력 받은 가장 큰 값보다 더 큰 값이 입력된 경우
			if (number > maxNum) {
				
				// for 반복문을 사용해 stack에 해당 숫자까지의 숫자를 순회
				for (int num = maxNum + 1; num < number + 1; num++) {
					
					// push() 메서드를 사용해 숫자를 stack에 추가
					stack.push(num); 
					
					// append() 메서드를 사용해 '+'를 sb에 추가
					sb.append("+\n");
				}
				
				// 가장 큰 값을 갱신
				maxNum = number;
				
			// 입력 받은 숫자가 stack의 마지막 값과 다른 경우
			} else if (stack.peek() != number) {
				
				// write() 메서드를 사용해 'NO'를 출력
				out.write("NO");
				
				// isPossible 변수 갱신
				isPossible = false;
				
				// 반복문 탈출
				break;
			}
			
			// pop() 메서드를 사용해 숫자를 stack에서 제거
			stack.pop();
			
			// append() 메서드를 사용해 '-'를 sb에 추가
			sb.append("-\n");
		}

		// 해당 수열을 만들 수 있는 경우
		if (isPossible)
		
			// toString() 및 write() 메서드를 사용해 기호를 출력
			out.write(sb.toString());
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}