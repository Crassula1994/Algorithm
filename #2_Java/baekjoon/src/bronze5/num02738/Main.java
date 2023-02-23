package bronze5.num02738;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 행렬의 크기를 각 변수에 할당
		int rowNum = Integer.parseInt(st.nextToken());
		int columnNum = Integer.parseInt(st.nextToken());
		
		// 각 행렬을 저장할 2차원 배열을 초기화
		int[][] matrixA = new int[rowNum][columnNum];
		int[][] matrixB = new int[rowNum][columnNum];
		
		// for 반복문을 사용해 행렬의 각 행을 순회
		for (int r = 0; r < rowNum * 2; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 행렬의 각 열을 순회
			for (int c = 0; c < columnNum; c++) {
				
				// 행렬 A의 원소인 경우 입력 받은 행렬 A에 각 원소를 저장
				if (r < rowNum) {
					matrixA[r][c] = Integer.parseInt(st.nextToken());
					
				// 행렬 B의 원소인 경우 입력 받은 행렬 B에 각 원소를 저장
				} else {
					matrixB[r - rowNum][c] = Integer.parseInt(st.nextToken());
				}
			}
		}

		// for 반복문을 사용해 행렬의 각 행을 순회
		for (int r = 0; r < rowNum; r++) {
			
			// for 반복문을 사용해 행렬의 각 열을 순회
			for (int c = 0; c < columnNum; c++) {
				
				// 행렬 덧셈의 결과를 변수 sum에 저장
				int sum = matrixA[r][c] + matrixB[r][c];
				
				// write() 메서드를 사용해 행렬 덧셈의 결과를 출력
				out.write(sum + " ");
				
				// 행렬의 마지막 열인 경우 줄바꿈 출력
				if (c == columnNum - 1)
					out.write("\n");
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}