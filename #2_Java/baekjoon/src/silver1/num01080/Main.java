package silver1.num01080;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 행렬의 크기를 각 변수에 할당
		int row = Integer.parseInt(st.nextToken());
		int column = Integer.parseInt(st.nextToken());
		
		// 행렬을 뒤집는 최소 횟수를 저장할 변수 minCount 초기화
		int minCount = 0;
		
		// 입력 받은 행렬 A와 행렬 B를 저장할 각 2차원 배열 초기화
		boolean[][] matrixA = new boolean[row][column];
		boolean[][] matrixB = new boolean[row][column];
		
		// for 반복문을 사용해 행렬 A의 각 행을 순회
		for (int r = 0; r < row; r++) {
			
			// readLine() 메서드를 사용해 입력 받은 행의 상태를 변수 line에 할당
			String line = in.readLine();
			
			// for 반복문을 사용해 행렬 A의 각 열을 순회
			for (int c = 0; c < column; c++) {
				
				// charAt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
				char number = line.charAt(c);
				
				// 해당 숫자가 1인 경우 2차원 배열에 true로 저장
				if (number == '1')
					matrixA[r][c] = true;
			}
		}
		
		// for 반복문을 사용해 행렬 B의 각 행을 순회
		for (int r = 0; r < row; r++) {
			
			// readLine() 메서드를 사용해 입력 받은 행의 상태를 변수 line에 할당
			String line = in.readLine();
			
			// for 반복문을 사용해 행렬 B의 각 열을 순회
			for (int c = 0; c < column; c++) {
				
				// charAt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
				char number = line.charAt(c);
				
				// 해당 숫자가 1인 경우 2차원 배열에 true로 저장
				if (number == '1')
					matrixB[r][c] = true;
			}
		}
		
		// for 반복문을 사용해 행렬 A의 각 행과 열을 순회
		outer: for (int r = 0; r < row; r++) {
			for (int c = 0; c < column; c++) {
				
				// 해당 위치의 값이 행렬 B와 다른 경우
				if (matrixA[r][c] != matrixB[r][c]) {
					
					// 해당 위치를 뒤집었을 때 범위를 벗어나는 경우
					if (r + 2 >= row || c + 2 >= column) {
						
						// 행렬을 뒤집는 최소 횟수를 갱신 후 반복문 탈출
						minCount = -1;
						break outer;
					}
					
					// for 반복문을 사용해 행렬 A의 각 원소를 변환
					for (int br = r; br < r + 3; br++) {
						for (int bc = c; bc < c + 3; bc++) {
							matrixA[br][bc] = !matrixA[br][bc];
						}
					}
					
					// 행렬을 뒤집는 최소 횟수를 갱신
					minCount++;
				}
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 행렬을 뒤집는 최소 횟수를 출력
		out.write(String.valueOf(minCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}