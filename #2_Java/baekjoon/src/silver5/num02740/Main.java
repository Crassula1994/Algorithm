package silver5.num02740;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 행렬 A의 크기를 각 변수에 할당
		int rowA = Integer.parseInt(st.nextToken());
		int colA = Integer.parseInt(st.nextToken());
		
		// 행렬 A의 상태를 저장할 2차원 배열 matrixA 초기화
		int[][] matrixA = new int[rowA][colA];
		
		// for 반복문을 사용해 행렬 A의 각 행을 순회
		for (int r = 0; r < rowA; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 입력 받은 행렬 A의 각 원소를 2차원 배열 matrixA에 저장
			for (int c = 0; c < colA; c++)
				matrixA[r][c] = Integer.parseInt(st.nextToken());
		}
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 행렬 B의 크기를 각 변수에 할당
		int rowB = Integer.parseInt(st.nextToken());
		int colB = Integer.parseInt(st.nextToken());
		
		// 행렬 B의 상태를 저장할 2차원 배열 matrixB 초기화
		int[][] matrixB = new int[rowB][colB];
		
		// for 반복문을 사용해 행렬 B의 각 행을 순회
		for (int r = 0; r < rowB; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 입력 받은 행렬 B의 각 원소를 2차원 배열 matrixB에 저장
			for (int c = 0; c < colB; c++)
				matrixB[r][c] = Integer.parseInt(st.nextToken());
		}
		
		// 행렬 A와 행렬 B를 곱한 결과를 저장할 2차원 배열 resultMatrix 초기화
		int[][] resultMatrix = new int[rowA][colB];
		
		// for 반복문을 사용해 resultMatrix의 각 칸을 순회
			for (int r = 0; r < rowA; r++) {
				for (int c = 0; c < colB; c++) {
					
					// for 반복문을 사용해 각 곱셈의 결과를 resultMatrix의 각 칸에 저장
					for (int m = 0; m < rowB; m++)
						resultMatrix[r][c] += matrixA[r][m] * matrixB[m][c];
				}
			}
		
		
		// for 반복문을 사용해 resultMatrix의 각 칸을 순회
		for (int r = 0; r < rowA; r++) {
			for (int c = 0; c < colB; c++)
				
				// write() 메서드를 사용해 각 칸의 원소를 출력
				out.write(resultMatrix[r][c] + " ");
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}