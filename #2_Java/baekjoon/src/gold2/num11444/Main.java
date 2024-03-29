package gold2.num11444;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 피보나치 수를 나눌 제수를 저장할 변수 divisor 초기화
	static long divisor = 1000000007;
	
	// 피보나치 수를 구하기 위해 필요한 행렬을 저장할 2차원 배열 matrix 초기화
	static long[][] matrix = {{1, 1}, {1, 0}};
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseLong() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
		long number = Long.parseLong(in.readLine());
		
		// power() 메서드를 호출해 행렬을 제곱한 결과를 통해 도출한 피보나치 수를 변수 fibonacci에 저장
		long fibonacci = power(matrix, number - 1)[0][0];
		
		// valueOf() 및 write() 메서드를 사용해 도출한 피보나치 수를 출력
		out.write(String.valueOf(fibonacci));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// power() 메서드 정의
	public static long[][] power(long[][] base, long exponent) {
		
		// 지수가 0 또는 1인 경우 행렬을 그대로 반환
		if (exponent == 0 || exponent == 1)
			return base;
		
		// power() 메서드를 재귀 호출해 해당 지수의 절반의 값을 계산하고 2차원 배열 half에 할당
		long[][] half = power(base, exponent / 2);
		
		// 지수가 홀수인지 짝수인지에 따라 multiply() 메서드를 호출해 그 계산 결과를 반환
		return (exponent % 2 == 0) ? multiply(half, half) : multiply(multiply(half, half), matrix);
	}
	
	// ----------------------------------------------------------------------------------------------------

	// multiply() 메서드 정의
	public static long[][] multiply(long[][] matrix1, long[][] matrix2) {
		
		// 행렬 곱셈의 결과를 저장할 2차원 배열 result 초기화
		long[][] result = new long[2][2];
		
		// for 반복문을 사용해 배열 result의 각 행과 열을 순회
		for (int r = 0; r < 2; r++) {
			for (int c = 0; c < 2; c++) {
				
				// for 반복문을 사용해 곱셈 결과에 필요한 각 원소를 순회
				for (int l = 0; l < 2; l++) {
					
					// 곱셈 결과를 갱신
					result[r][c] += matrix1[r][l] * matrix2[l][c];
					result[r][c] %= divisor;
				}
			}
		}
		
		// 행렬 곱셈의 결과를 반환
		return result;
	}
}