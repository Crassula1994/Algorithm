package silver4.num17550;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자의 개수를 변수 numberCount에 할당
		int numberCount = Integer.parseInt(in.readLine());
		
		// 주어진 수식의 최댓값을 저장할 변수 maxValue 초기화
		long maxValue = 0;
		
		// 각 숫자의 누적 합 및 제곱의 누적 합을 저장할 각 배열 초기화
		long[] numberSum = new long[numberCount + 1];
		long[] squareSum = new long[numberCount + 1];
		
		// for 반복문을 사용해 각 숫자를 순회
		for (int idx = 1; idx <= numberCount; idx++) {
			
			// readLine() 및 parseLong() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
			long number = Long.parseLong(in.readLine());
			
			// 숫자의 누적 합 및 제곱의 누적 합을 갱신
			numberSum[idx] = numberSum[idx - 1] + number;
			squareSum[idx] = squareSum[idx - 1] + number * number;
		}
		
		// for 반복문을 사용해 주어진 수식을 만족하는 각 위치를 순회
		for (int idx = 1; idx < numberCount; idx++) {
			
			// 해당 위치에서 수식의 값을 계산해 변수 value에 할당
			long value = squareSum[idx] * (numberSum[numberCount] - numberSum[idx]);
			
			// max() 메서드를 사용해 주어진 수식의 최댓값을 갱신
			maxValue = Math.max(value, maxValue);
		}
		
		// valueOf() 및 write() 메서드를 사용해 주어진 수식의 최댓값을 출력
		out.write(String.valueOf(maxValue));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}