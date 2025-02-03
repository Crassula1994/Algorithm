package gold5.num30693;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 디마의 괄호열 길이를 변수 length에 할당
		int length = Integer.parseInt(in.readLine());
		
		// readLine() 및 toCharArray() 메서드를 사용해 입력 받은 디마의 괄호열을 배열 sequence에 저장
		char[] sequence = in.readLine().toCharArray();
		
		// 괄호열의 길이가 홀수인 경우 -1을 출력
		if ((length & 1) == 1) {
			out.write(String.valueOf(-1));
			
		// 괄호열의 길이가 짝수인 경우
		} else {
			
			// 각 괄호의 개수를 저장할 각 변수 초기화
			int openCount = 0;
			int closeCount = 0;
			
			// for 반복문을 사용해 각 괄호를 순회
			for (int idx = 0; idx < sequence.length; idx++) {
				
				// 해당 괄호가 여는 괄호인 경우 여는 괄호의 개수를 갱신
				if (sequence[idx] == '(') {
					openCount++;
					
				// 해당 괄호가 닫는 괄호인 경우 닫는 괄호의 개수를 갱신
				} else {
					closeCount++;
				}
			}
			
			// 여는 괄호와 닫는 괄호의 개수가 일치하지 않는 경우 -1을 출력
			if (openCount != closeCount) {
				out.write(String.valueOf(-1));
			
			// 여는 괄호와 닫는 괄호의 개수가 일치하는 경우
			} else {
				
				// 올바른 괄호열을 만들기 위한 최소 시간을 저장할 변수 minTime 초기화
				int minTime = 0;
				
				// 해당 괄호까지 필요한 닫는 괄호의 개수를 저장할 배열 counts 초기화
				int[] counts = new int[length + 1];
				
				// for 반복문을 사용해 각 괄호를 순회
				for (int idx = 1; idx < counts.length; idx++) {
					
					// 해당 괄호에서 필요한 닫는 괄호의 개수를 갱신
					counts[idx] = (sequence[idx - 1] == '(') ? counts[idx - 1] + 1 : counts[idx - 1] - 1;
					
					// 잘못된 괄호열인 경우 올바른 괄호열을 만들기 위한 최소 시간을 갱신
					if (counts[idx] < 0 || (counts[idx] == 0 && counts[idx - 1] < 0))
						minTime++;
				}
				
				// valueOf() 및 write() 메서드를 사용해 올바른 괄호열을 만들기 위한 최소 시간을 출력
				out.write(String.valueOf(minTime));
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}