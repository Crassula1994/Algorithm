package bronze1.num09455;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 그리드의 크기를 각 변수에 할당
			int row = Integer.parseInt(st.nextToken());
			int column = Integer.parseInt(st.nextToken());
			
			// 모든 박스가 이동한 거리를 저장할 변수 totalDistance 초기화
			int totalDistance = 0;
			
			// 그리드의 상태를 저장할 2차원 배열 grid 초기화
			int[][] grid = new int[row][column];
			
			// for 반복문을 사용해 그리드의 각 행을 순회
			for (int r = 0; r < row; r++) {
				
				// StringTokenizer 객체를 불러와 변수 st에 재할당
				st = new StringTokenizer(in.readLine());
				
				// for 반복문을 사용해 그리드의 상태를 2차원 배열 grid에 저장
				for (int c = 0; c < column; c++)
					grid[r][c] = Integer.parseInt(st.nextToken());
			}
			
			// for 반복문을 사용해 그리드의 각 행과 열을 순회
			for (int r = 0; r < row - 1; r++) {
				for (int c = 0; c < column; c++) {
				
					// 박스가 위치한 경우
					if (grid[r][c] == 1) {
						
						// for 반복문을 사용해 박스의 아래 행을 순회
						for (int d = r + 1; d < row; d++) {
						
							// 해당 칸이 빈 칸인 경우 박스가 이동한 거리를 갱신
							if (grid[d][c] == 0)
								totalDistance++;
						}
					}
				}
			}
			
			// write() 메서드를 사용해 모든 박스가 이동한 거리를 출력
			out.write(totalDistance + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}