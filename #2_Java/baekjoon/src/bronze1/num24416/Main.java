package bronze1.num24416;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 피보나치 수열의 결과를 저장할 배열 sequence 초기화
	static int[] sequence = new int[41];
	
	// 코드 1과 2의 횟수를 저장할 각 변수 초기화
	static int code1Cnt = 0;
	static int code2Cnt = 0;	

	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
		int number = Integer.parseInt(in.readLine());
		
		// fibonacci() 메서드를 호출해 각 코드의 실행 횟수를 갱신
		code1Cnt = fibonacci(number);
		
		// write() 메서드를 사용해 각 코드의 실행 횟수를 출력
		out.write(code1Cnt + " " + code2Cnt);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// fibonacci() 메서드 정의
	public static int fibonacci(int number) {
		
		// 피보나치 수열의 첫 번째와 두 번째 값을 초기화
		sequence[1] = 1;
		sequence[2] = 1;
		
		// for 반복문을 사용해 3부터 입력 받은 숫자까지 순회
		for (int idx = 3; idx <= number; idx++) {
			
			// 다음 피보나치 수열을 산식에 따라 계산해 저장
			sequence[idx] = sequence[idx - 1] + sequence[idx - 2];
			
			// 코드 2의 실행 횟수 갱신
			code2Cnt++;
		}
		
		// 결과 값 반환
		return sequence[number];
	}
}