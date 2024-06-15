package gold1.num01562;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 계단수의 개수를 나눌 상수 divisor 초기화
	static final long DIVISOR = 1000000000;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자의 길이를 변수 length에 할당
		int length = Integer.parseInt(in.readLine());
		
		// 입력 받은 길이의 계단 수의 개수를 저장할 변수 totalCount 초기화
		long totalCount = 0;
		
		// 각 길이에 따라 각 마지막 숫자를 사용한 계단 수의 개수를 저장할 3차원 배열 stairNumbers 초기화
		long[][][] stairNumbers = new long[length + 1][10][1 << 10];
		
		// for 반복문을 사용해 길이가 1인 계단 수의 개수를 갱신
		for (int number = 1; number < 10; number++)
			stairNumbers[1][number][1 << number] = 1;
		
		// for 반복문을 사용해 각 계단 수의 길이를 순회
		for (int len = 1; len < length; len++) {
			
			// for 반복문을 사용해 각 계단 수의 마지막 숫자를 순회
			for (int number = 0; number < 10; number++) {
				
				// for 반복문을 사용해 각 사용한 숫자 조합을 순회
				for (int comb = 0; comb < (1 << 10); comb++) {
					
					// 해당 조합을 사용한 계단 수가 존재하지 않는 경우 다음 조합을 순회
					if (stairNumbers[len][number][comb] == 0)
						continue;
					
					// 마지막 숫자가 1 이상인 경우 다음 숫자가 1 작은 조합의 계단 수를 갱신
					if (number > 0) {
						stairNumbers[len + 1][number - 1][comb | (1 << (number - 1))] += stairNumbers[len][number][comb];
						stairNumbers[len + 1][number - 1][comb | (1 << (number - 1))] %= DIVISOR;
					}
					
					// 마지막 숫자가 9 미만인 경우 다음 숫자가 1 큰 조합의 계단 수를 갱신
					if (number < 9) {
						stairNumbers[len + 1][number + 1][comb | (1 << (number + 1))] += stairNumbers[len][number][comb];
						stairNumbers[len + 1][number + 1][comb | (1 << (number + 1))] %= DIVISOR;
					}
				}
			}
		}
		
		// for 반복문을 사용해 입력 받은 길이의 계단 수의 개수를 갱신
		for (int number = 0; number < 10; number++) {
			totalCount += stairNumbers[length][number][(1 << 10) - 1];
			totalCount %= DIVISOR;
		}
		
		// valueOf() 및 write() 메서드를 사용해 입력 받은 길이의 계단 수의 개수를 출력
		out.write(String.valueOf(totalCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}