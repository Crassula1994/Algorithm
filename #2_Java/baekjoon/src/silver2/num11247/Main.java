package silver2.num11247;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 각 숫자를 비트 수에 따라 저장하는 방법의 수를 저장할 2차원 배열 counts 초기화
	static Integer[][] counts = new Integer[1 << 20][21];
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 메모리에 저장할 숫자와 컴퓨터의 비트 수를 각 변수에 할당
			int targetNumber = Integer.parseInt(st.nextToken());
			int bitLimit = Integer.parseInt(st.nextToken());
			
			// abs(), storageCounter(), abs() 메서드를 사용해 목표 숫자를 컴퓨터의 비트 수로 저장하는 방법의 수를 출력
			out.write(storageCounter(Math.abs(targetNumber), bitLimit) + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// storageCounter() 메서드 정의
	public static int storageCounter(int targetNumber, int bitLimit) {
		
		// 목표 숫자가 가능한 수의 범위를 벗어나는 경우 0을 반환
		if (targetNumber > (1 << (bitLimit - 1)))
			return 0;
		
		// 이미 계산한 방법의 수가 존재하는 경우 해당 방법의 수를 반환
		if (counts[targetNumber][bitLimit] != null)
			return counts[targetNumber][bitLimit];
		
		// 목표 숫자가 0이거나 컴퓨터의 비트 수가 1인 경우 1을 반환
		if (targetNumber == 0 || bitLimit == 1)
			return counts[targetNumber][bitLimit] = 1;
		
		// 목표 숫자가 홀수인 경우
		if ((targetNumber & 1) == 1) {
			counts[targetNumber][bitLimit]
					= storageCounter((targetNumber + 1) >> 1, bitLimit - 1)
					+ storageCounter((targetNumber - 1) >> 1, bitLimit - 1);
		} else {
			counts[targetNumber][bitLimit] = storageCounter(targetNumber >> 1, bitLimit - 1);
		}
		
		// 목표 숫자를 컴퓨터의 비트 수로 저장하는 방법의 수를 반환
		return counts[targetNumber][bitLimit];
	}
}