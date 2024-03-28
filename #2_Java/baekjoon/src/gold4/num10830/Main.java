package gold4.num10830;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 행렬의 크기를 저장할 변수 size 초기화
	static int size;
	
	// 입력 받은 행렬을 저장할 배열 matrix 초기화
	static int[][] matrix;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken(), parseInt(), parseLong() 메서드를 사용해 입력 받은 행렬의 크기와 지수를 각 변수에 할당
		size = Integer.parseInt(st.nextToken());
		long exponent = Long.parseLong(st.nextToken());
		
		// 입력 받은 행렬을 저장할 배열 matrix 초기화
		matrix = new int[size][size];
		
		// for 반복문을 사용해 행렬의 행을 순회
		for (int r = 0; r < size; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 입력 받은 행렬의 원소를 2차원 배열 matrix에 저장
			for (int c = 0; c < size; c++)
				matrix[r][c] = Integer.parseInt(st.nextToken()) % 1000;
		}
		
		// power() 메서드를 호출해 행렬을 제곱한 결과를 2차원 배열 result에 저장
		int[][] result = power(matrix, exponent);
		
		// for 반복문을 사용해 행렬을 제곱한 결과의 각 행과 열의 원소를 출력
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++)
				out.write(result[r][c] + " ");
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// power() 메서드 정의
	public static int[][] power(int[][] base, long exponent) {
		
		// 지수가 1인 경우 행렬을 그대로 반환
		if (exponent == 1)
			return base;
		
		// power() 메서드를 재귀 호출해 해당 지수의 절반의 값을 계산하고 2차원 배열 half에 할당
		int[][] half = power(base, exponent / 2);
		
		// 지수가 홀수인지 짝수인지에 따라 multiply() 메서드를 호출해 그 계산 결과를 반환
		return (exponent % 2 == 0) ? multiply(half, half) : multiply(multiply(half, half), matrix);
	}
	
	// ----------------------------------------------------------------------------------------------------

	// multiply() 메서드 정의
	public static int[][] multiply(int[][] matrix1, int[][] matrix2) {
		
		// 행렬 곱셈의 결과를 저장할 2차원 배열 result 초기화
		int[][] result = new int[size][size];
		
		// for 반복문을 사용해 배열 result의 각 행과 열을 순회
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				
				// for 반복문을 사용해 곱셈 결과에 필요한 각 원소를 순회
				for (int l = 0; l < size; l++) {
					
					// 곱셈 결과를 갱신
					result[r][c] += matrix1[r][l] * matrix2[l][c];
					result[r][c] %= 1000;
				}
			}
		}
		
		// 행렬 곱셈의 결과를 반환
		return result;
	}
}