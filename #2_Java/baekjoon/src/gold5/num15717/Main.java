package gold5.num15717;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 나이를 먹는 방법의 가짓수를 나눌 상수 DIVISOR 초기화
	static final int DIVISOR = 1000000007;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseLong() 메서드를 사용해 입력 받은 떡파이어의 나이를 변수 age에 할당
		long age = Long.parseLong(in.readLine());
		
		// countCalculator() 메서드를 호출해 떡파이어가 나이를 먹는 방법의 가짓수를 변수 totalCount에 할당
		long totalCount = (age == 0) ? 1 : countCalculator(age - 1);
		
		// valueOf() 및 write() 메서드를 사용해 떡파이어가 나이를 먹는 방법의 가짓수를 출력
		out.write(String.valueOf(totalCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// countCalculator() 메서드 정의
	public static long countCalculator(long exponent) {
		
		// 거듭제곱의 지수가 0인 경우 1 반환
		if (exponent == 0)
			return 1;
		
		// 지수를 2로 나눈 값으로 countCalculator() 메서드를 재귀 호출한 결과를 변수 half에 할당
		long half = countCalculator(exponent / 2) % DIVISOR;
		
		// 떡파이어가 나이를 먹는 방법의 가짓수를 계산해 반환
		return ((exponent & 1) == 1) ? (half * half * 2) % DIVISOR : (half * half) % DIVISOR;
	}
}