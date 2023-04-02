package silver1.num10844;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 계단 수의 길이를 변수 length에 할당
		int length = Integer.parseInt(in.readLine());
		
		// 계단 수의 개수를 저장할 2차원 배열 stairNum 초기화
		long[][] stairNum = new long[length + 1][10];
		
		// for 반복문을 사용해 첫 번째 자릿수의 계단 수 개수를 초기화
		for (int idx = 1; idx < 10; idx++)
			stairNum[1][idx] = 1;
		
		// for 반복문을 사용해 각 자릿수를 차례로 순회
		for (int r = 2; r < stairNum.length; r++) {
			
			// for 반복문을 사용해 각 자릿수의 숫자를 차례로 순회
			for (int c = 0; c < 10; c++) {
				
				// 해당 자릿수가 0인 경우 이전 자릿수가 1인 경우만 가능
				if (c == 0) {
					stairNum[r][c] = stairNum[r - 1][c + 1] % 1000000000;
				
				// 해당 자릿수가 9인 경우 이전 자릿수가 8인 경우만 가능
				} else if (c == 9) {
					stairNum[r][c] = stairNum[r - 1][c - 1] % 1000000000;
				
				// 해당 자릿수가 1부터 8인 경우 이전 자릿수가 1 작거나 1 큰 경우 가능
				} else {
					stairNum[r][c] = (stairNum[r - 1][c - 1] + stairNum[r - 1][c + 1]) % 1000000000;
				}
			}
		}
		
		// 결과를 저장할 result 변수 초기화
		long result = 0;
		
		// for 반복문을 사용해 계단 수의 개수를 갱신
		for (int idx = 0; idx < 10; idx++)
			result += stairNum[length][idx];
		
		// valueOf() 및 write() 메서드를 사용해 계단 수의 개수를 출력
		out.write(String.valueOf(result % 1000000000));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}