package silver1.num11057;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 수의 길이를 변수 numberLen에 할당
		int numberLen = Integer.parseInt(in.readLine());
		
		// 각 길이의 숫자가 특정 숫자로 끝날 때의 오르막 수의 개수를 저장할 2차원 배열 counter 초기화
		int[][] counter = new int[numberLen + 1][10];
		
		// for 반복문을 사용해 한 자리 숫자일 때의 오르막 수의 개수를 초기화
		for (int c = 0; c < 10; c++)
			counter[1][c] = 1;
		
		// for 반복문을 사용해 각 자리 숫자를 순회
		for (int r = 2; r <= numberLen; r++) {
			
			// for 반복문을 사용해 각 끝나는 자리 수를 순회
			for (int c = 0; c < 10; c++) {
				
				// for 반복문을 사용해 끝나는 자리 수보다 적거나 같은 숫자의 개수를 사용해 오르막 수의 개수를 갱신
				for (int n = 0; n <= c; n++) {
					counter[r][c] += counter[r - 1][n];
					counter[r][c] %= 10007;
				}
			}
		}
		
		// 주어진 길이의 오르막 수의 개수를 저장할 변수 totalCnt 초기화
		int totalCnt = 0;
		
		// for 반복문을 사용해 주어진 길이의 오르막 수의 개수를 갱신
		for (int c = 0; c < 10; c++)
			totalCnt += counter[numberLen][c];
		
		// valueOf() 및 write() 메서드를 사용해 주어진 길이의 오르막 수의 개수를 출력
		out.write(String.valueOf(totalCnt % 10007));
	
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}