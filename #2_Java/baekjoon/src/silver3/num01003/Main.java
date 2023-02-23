package silver3.num01003;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 피보나치 수열을 계산 시 호출되는 횟수를 저장할 배열 fiboSeq 초기화
	static int[][]fiboSeq = new int[41][2];
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// 0과 1일 때의 호출 횟수를 할당
		fiboSeq[0][0] = 1;
		fiboSeq[0][1] = 0;
		fiboSeq[1][0] = 0;
		fiboSeq[1][1] = 1;
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
			int number = Integer.parseInt(in.readLine());
			
			// fibonacci() 메서드를 호출해 피보나치 수열의 0과 1울 호출한 횟수를 배열 result에 할당
			int[] result = fibonacci(number);
			
			// write() 메서드를 사용해 0이 출력되는 횟수와 1이 출력되는 횟수를 출력
			out.write(result[0] + " " + result[1] + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// fibonacci() 메서드 정의
	public static int[] fibonacci(int number) {
		
		// 기존에 저장된 값이 없는 경우
		if (fiboSeq[number][0] == 0 && fiboSeq[number][1] == 0) {
		
			// fibonacci() 메서드 재귀 호출
			fiboSeq[number][0] = fibonacci(number - 1)[0] + fibonacci(number - 2)[0];
			fiboSeq[number][1] = fibonacci(number - 1)[1] + fibonacci(number - 2)[1];
		}
		
		// 0과 1을 호출한 횟수를 반환
		return fiboSeq[number];
	}
}