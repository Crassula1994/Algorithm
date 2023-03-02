package d2.num01989;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Solution 클래스 정의
public class Solution {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 행렬의 크기를 변수 size에 할당
			int size = Integer.parseInt(in.readLine());
			
			// 주어진 행렬을 저장할 2차원 배열 matrix 초기화
			int[][] matrix = new int[size][size];
			
			// for 반복문을 사용해 행렬의 각 행을 순회
			for (int r = 0; r < size; r++) {
				
				// StringTokenizer 객체를 불러와 변수 st에 할당
				StringTokenizer st = new StringTokenizer(in.readLine());
				
				// for 반복문을 사용해 행렬의 각 열을 순회하며 배열에 값을 저장
				for (int c = 0; c < size; c++)
					matrix[r][c] = Integer.parseInt(st.nextToken());
			}
			
			// write() 메서드를 사용해 테스트 케이스의 번호를 출력
			out.write("#" + (tc + 1) + "\n");
			
			// for 반복문을 사용해 각 줄을 순회
			for (int i = 0; i < size; i++) {
				
				// for 반복문을 사용해 90도 회전의 경우를 출력
				for (int j = 0; j < size; j++)
					out.write(String.valueOf(matrix[size - j - 1][i]));
				
				// write() 메서드를 사용해 띄어쓰기 출력
				out.write(" ");
				
				// for 반복문을 사용해 180도 회전의 경우를 출력
				for (int j = 0; j < size; j++)
					out.write(String.valueOf(matrix[size - i - 1][size - j - 1]));
				
				// write() 메서드를 사용해 띄어쓰기 출력
				out.write(" ");
				
				// for 반복문을 사용해 270도 회전의 경우를 출력
				for (int j = 0; j < size; j++)
					out.write(String.valueOf(matrix[j][size - i - 1]));
				
				// write() 메서드를 사용해 줄바꿈 출력
				out.write("\n");
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}