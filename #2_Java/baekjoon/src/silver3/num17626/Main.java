package silver3.num17626;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 제곱 수들의 개수를 저장할 배열 fourSquares 초기화
	static int[] fourSquares = new int[50001];

	// ----------------------------------------------------------------------------------------------------

	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
		int number = Integer.parseInt(in.readLine());
		
		// 1인 경우의 최소 개수 초기화
		fourSquares[1] = 1;
		
		// squareCounter() 메서드를 호출해 제곱 수들의 최소 개수를 변수 result에 할당
		int result = squareCounter(number);
		
		// valueOf() 및 write() 메서드를 사용해 제곱 수들의 최소 개수를 출력
		out.write(String.valueOf(result));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// squareCounter() 메서드 정의
	public static int squareCounter(int number) {
		
		// 제곱 수들의 최소 개수가 저장되어 있는 경우 해당 값 반환
		if (number == 0 || fourSquares[number] != 0) {
			return fourSquares[number];
		
		// 제곱 수들의 최소 개수가 저장되어 있지 않은 경우
		} else {
			
			// 최소 개수를 저장할 변수 minCnt 초기화
			int minCnt = Integer.MAX_VALUE;
			
			// for 반복문을 사용해 해당 숫자의 각 제곱수를 순회
			for (int n = (int) Math.sqrt(number); n > 0; n--) {
				
				// 해당 숫자에서 가장 큰 제곱수를 뺀 나머지를 변수 remains에 할당
				int remains = number - n * n;
				
				// 완전제곱수인 경우 1을 반환
				if (remains == 0)
					return fourSquares[number] = 1;
				
				// squareCounter() 메서드 재귀 호출 및 min() 메서드를 사용해 최소 개수 갱신
				minCnt = Math.min(minCnt, squareCounter(remains));
			}
			
			// 제곱 수들의 최소 개수를 계산해 반환
			return fourSquares[number] = minCnt + 1;
		}
	}
}