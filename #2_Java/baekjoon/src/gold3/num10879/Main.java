package gold3.num10879;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// 각 정수를 만들기 위해 필요한 단어의 최소 개수를 저장할 배열 minCounts 초기화
		int[] minCounts = new int[1 << 16 + 1];
		
		// 0과 1일 때 필요한 단어의 최소 개수를 갱신
		minCounts[0] = 6;
		minCounts[1] = 1;
		
		// for 반복문을 사용해 정수가 2의 거듭제곱일 때 필요한 단어의 최소 개수를 갱신
		for (int idx = 2, count = 1; idx < minCounts.length; idx *= 2)
			minCounts[idx] = ++count;
		
		// for 반복문을 사용해 각 정수를 순회
		for (int idx = 3; idx <= 50000; idx++) {
			
			// 이미 해당 정수를 만들기 위해 필요한 단어의 최소 개수를 계산한 경우 다음 정수를 순회
			if (minCounts[idx] != 0)
				continue;
			
			// 해당 정수보다 큰 2의 거듭제곱을 저장할 변수 baseIndex 초기화
			int baseIndex = 1;
			
			// while 반복문을 사용해 해당 정수보다 큰 2의 거듭제곱을 갱신
			while (baseIndex <= idx)
				baseIndex *= 2;
			
			/* 해당 정수보다 큰 2의 거듭제곱에서 차이를 뺀 경우와 해당 정수보다 작은 2의 거듭제곱에서 차이를 더한 경우를 상정하고
			각 경우에 필요한 단어의 개수를 각 변수에 할당 */
			int topCount = minCounts[baseIndex] + minCounts[baseIndex - idx] + 4;
			int downCount = minCounts[baseIndex / 2] + minCounts[idx - baseIndex / 2] + 4;
			
			// min() 메서드를 사용해 해당 정수를 만들기 위해 필요한 단어의 최소 개수를 갱신
			minCounts[idx] = Math.min(topCount, downCount);
		}
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// readLine(), parseInt(), abs() 메서드를 사용해 입력 받은 정수를 변수 targetNumber에 할당
			int targetNumber = Math.abs(Integer.parseInt(in.readLine()));
			
			// write() 메서드를 사용해 해당 정수를 만들기 위해 필요한 단어의 최소 개수를 출력
			out.write(minCounts[targetNumber] + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}