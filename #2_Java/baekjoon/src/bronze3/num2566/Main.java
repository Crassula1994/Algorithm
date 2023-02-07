package bronze3.num2566;

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
		
		// 입력 받은 81개의 값을 저장할 2차원 배열 matrix 초기화
		int[][] matrix = new int[9][9];
		
		// 최댓값과 최댓값의 위치를 저장할 각 변수 초기화
		int max = -1;
		int maxRow = 0;
		int maxColumn = 0;
		
		// for 반복문을 사용해 2차원 배열의 행을 순회
		for (int r = 0; r < 9; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 2차원 배열의 열을 순회
			for (int c = 0; c < 9; c++) {
				
				// nextToken() 및 parseInt() 메서드를 사용해 해당 배열에 입력 받은 값을 저장
				matrix[r][c] = Integer.parseInt(st.nextToken());
				
				// 해당 값이 최댓값인 경우 최댓값 및 위치 갱신
				if (matrix[r][c] > max) {
					max = matrix[r][c];
					maxRow = r + 1;
					maxColumn = c + 1;
				}
			}
		}

		// write() 메서드를 사용해 최댓값 및 최댓값의 위치 출력
		out.write(max + "\n" + maxRow + " " + maxColumn);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}