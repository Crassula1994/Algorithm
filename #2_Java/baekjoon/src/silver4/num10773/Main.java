package silver4.num10773;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 정수의 개수를 변수 length에 할당
		int length = Integer.parseInt(in.readLine());
		
		// 각 정수를 저장할 Stack 객체 numbers 초기화
		Stack<Integer> numbers = new Stack<>();
		
		// 정수의 합을 저장할 변수 sum 초기화
		int sum = 0;
		
		// for 반복문을 사용해 각 정수를 순회
		for (int i = 0; i < length; i++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 정수를 변수 num에 할당
			int num = Integer.parseInt(in.readLine());
			
			// 0이 입력된 경우
			if (num == 0) {
				
				// pop() 메서드를 사용해 numbers에서 가장 마지막에 입력된 정수를 제거하고 총합 갱신
				sum -= numbers.pop();
				
			// 0이 아닌 정수가 입력된 경우
			} else {
				
				// push() 메서드를 사용해 numbers에 정수 추가
				numbers.push(num);
				
				// 총합을 갱신
				sum += num;
			}
		}
			
		// valueOf() 및 write() 메서드를 사용해 정수의 총합을 출력
		out.write(String.valueOf(sum));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}