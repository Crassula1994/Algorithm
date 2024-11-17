package silver4.num07800;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// Matrix 클래스 정의
	static class Matrix implements Comparable<Matrix> {
		
		// 해당 부분 행렬의 시작 행과 열의 인덱스, 원소의 종류 개수를 나타낼 각 변수 초기화
		int startRow;
		int startColumn;
		int count;
		
		// 원소의 존재 여부를 저장할 배열 elements 초기화
		boolean[] elements;
		
		// 매개변수를 입력 받는 생성자 정의
		public Matrix(int startRow, int startColumn) {
			this.startRow = startRow;
			this.startColumn = startColumn;
			this.count = 0;
			this.elements = new boolean[10];
		}

		// compareTo() 메서드 정의
		@Override
		public int compareTo(Matrix anotherMatrix) {
			
			// 원소의 종류 개수가 같은 경우
			if (this.count == anotherMatrix.count) {
				
				// for 반복문을 사용해 각 원소를 차례로 순회
				for (int digit = 9; digit >= 0; digit--) {
					
					// 해당 행렬이 더 높은 숫자를 가진 경우 해당 행렬을 반환
					if (this.elements[digit] && !anotherMatrix.elements[digit]) {
						return -1;
						
					// 비교 행렬이 더 높은 숫자를 가진 경우 비교 행렬을 반환
					} else if (!this.elements[digit] && anotherMatrix.elements[digit]) {
						return 1;
					}
				}
				
				// 부분 행렬의 시작 행이 같은 경우 시작 열이 작은 순서대로 반환
				if (this.startRow == anotherMatrix.startRow)
					return this.startColumn - anotherMatrix.startColumn;
				
				// 부분 행렬의 시작 행이 작은 순서대로 반환
				return this.startRow - anotherMatrix.startRow;
			}
			
			// 원소의 종류 개수가 작은 순서대로 반환
			return this.count - anotherMatrix.count;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 입력 받은 테스트 케이스의 정보를 저장할 변수 line 초기화
		String line;
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while ((line = in.readLine()) != null) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(line);
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 행렬과 선택할 부분 행렬의 크기를 각 변수에 할당
			int matrixSize = Integer.parseInt(st.nextToken());
			int subMatrixSize = Integer.parseInt(st.nextToken());
			
			// 부분 행렬의 정보를 저장할 List 객체 subMatrixes 초기화
			List<Matrix> subMatrixes = new ArrayList<Matrix>();
			
			// 입력 받은 행렬을 저장할 2차원 배열 matrix 초기화
			int[][] matrix = new int[matrixSize + 1][matrixSize + 1];
			
			// for 반복문을 사용해 행렬의 각 행을 순회
			for (int r = 1; r <= matrixSize; r++) {
				
				// StringTokenizer 객체를 불러와 변수 st에 재할당
				st = new StringTokenizer(in.readLine());
				
				// for 반복문을 사용해 입력 받은 행렬의 각 행렬의 원소를 2차원 배열 matrix에 저장
				for (int c = 1; c <= matrixSize; c++)
					matrix[r][c] = Integer.parseInt(st.nextToken());
			}
			
			// for 반복문을 사용해 각 부분 행렬의 시작 위치를 순회
			for (int startR = 1; startR <= matrixSize - subMatrixSize + 1; startR++) {
				for (int startC = 1; startC <= matrixSize - subMatrixSize + 1; startC++) {
					
					// 현재 부분 행렬의 정보를 저장할 변수 subQMatrix 초기화
					Matrix subMatrix = new Matrix(startR, startC);
					
					// for 반복문을 사용해 각 부분 행렬의 행과 열을 순회
					for (int r = startR; r < startR + subMatrixSize; r++) {
						for (int c = startC; c < startC + subMatrixSize; c++) {
							
							// 해당 원소를 이미 확인한 경우 다음 원소를 순회
							if (subMatrix.elements[matrix[r][c]])
								continue;
							
							// 원소 종류의 개수와 해당 원소의 존재 여부를 갱신
							subMatrix.count++;
							subMatrix.elements[matrix[r][c]] = true;
						}
					}
					
					// add() 메서드를 사용해 해당 부분 행렬의 정보를 subMatrixes에 저장
					subMatrixes.add(subMatrix);
				}
			}
			
			// sort() 메서드를 사용해 부분 행렬을 오름차순으로 정렬
			Collections.sort(subMatrixes);
			
			// get() 및 write() 메서드를 사용해 해당 부분 행렬의 시작 행과 열 인덱스를 출력
			out.write(subMatrixes.get(0).startRow + " " + subMatrixes.get(0).startColumn + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}