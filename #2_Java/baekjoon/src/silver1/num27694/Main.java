package silver1.num27694;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 계단을 오르내릴 수 있는 방법의 수를 나눌 제수, 최대 계단 수를 저장할 각 상수 초기화
	static final int DIVISOR = 1000000009;
	static final int MAX_STEP = 100000;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// 각 계단의 개수별 오르내릴 수 있는 방법의 수를 저장할 각 배열 초기화
		long[] upstairs = new long[MAX_STEP + 1];
		long[] downstairs = new long[MAX_STEP + 1];
		
		// for 반복문을 사용해 각 계단의 수를 순회
		for (int step = 0; step <= MAX_STEP; step++) {
			
			// switch 조건문을 사용해 각 계단의 개수별 오르내릴 수 있는 방법의 수를 갱신
			switch (step) {
				case 0:
				case 1:
					upstairs[step] = 1;
					downstairs[step] = 1;
					break;
				case 2:
					upstairs[step] = 2;
					downstairs[step] = 2;
					break;
				case 3:
					upstairs[step] = 3;
					downstairs[step] = 4;
					break;
				default:
					upstairs[step] = (upstairs[step - 1] + upstairs[step - 2]) % DIVISOR;
					downstairs[step]
							= (downstairs[step - 1] + downstairs[step - 2] + downstairs[step - 3] + downstairs[step - 4])
							% DIVISOR;
			}
		}
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// readLine() 메서드를 사용해 빈 줄을 제거
			in.readLine();
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 계단의 수를 변수 stepNum에 할당
			int stepNum = Integer.parseInt(in.readLine());
			
			// write() 메서드를 사용해 해당 계단의 수에서 오르내릴 수 있는 방법의 수를 출력
			out.write(((upstairs[stepNum] * downstairs[stepNum]) % DIVISOR) + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}