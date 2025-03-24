package silver3.num17829;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 입력 받은 행렬을 풀링한 결과를 저장할 2차원 배열 matrix 초기화
	static int[][] matrix;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 행렬의 크기를 변수 size에 할당
		int size = Integer.parseInt(in.readLine());
		
		// 입력 받은 행렬을 풀링한 결과를 저장할 2차원 배열 matrix 초기화
		matrix = new int[size][size];
		
		// for 반복문을 사용해 행렬의 각 행을 순회
		for (int r = 0; r < size; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 입력 받은 행렬의 각 원소를 2차원 배열 matrix에 저장
			for (int c = 0; c < size; c++)
				matrix[r][c] = Integer.parseInt(st.nextToken());
		}
		
		// matrixPooler() 메서드를 호출해 주어진 행렬을 222-풀링한 결과를 갱신
		matrixPooler(size);
		
		// valueOf() 및 write() 메서드를 사용해 마지막에 남은 수를 출력
		out.write(String.valueOf(matrix[0][0]));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// matrixPooler() 메서드 정의
	public static void matrixPooler(int size) {
		
		// 행렬의 크기가 1로 줄어든 경우 메서드 종료
		if (size == 1)
			return;
		
		// for 반복문을 사용해 각 정사각형을 순회
		for (int r = 0; r < size; r += 2) {			
			for (int c = 0; c < size; c += 2) {
				
				// 정사각형의 원소를 저장한 배열 elements 초기화
				int[] elements = {matrix[r][c], matrix[r][c + 1], matrix[r + 1][c], matrix[r + 1][c + 1]};
				
				// sort() 메서드를 사용해 정사각형의 원소를 오름차순으로 정렬
				Arrays.sort(elements);
				
				// 정사각형의 원소를 풀링한 결과를 배열 matrix에 저장
				matrix[r / 2][c / 2] = elements[2];
			}
		}
		
		// matrixPooler() 메서드 재귀 호출
		matrixPooler(size / 2);
	}
}