package silver1.num16918;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {

	// 격자판의 크기 및 시간을 저장할 각 변수를 할당
	static int row;
	static int column;
	static int time;

	// 인접한 위치를 나타낼 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	// 격자판의 상태를 저장할 2차원 배열 grid 초기화
	static char[][] grid;

	// ----------------------------------------------------------------------------------------------------

	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken(), parseInt(), pow() 메서드를 사용해 입력 받은 격자판의 크기 및 시간을 각 변수에 할당
		row = Integer.parseInt(st.nextToken());
		column = Integer.parseInt(st.nextToken());
		time = Integer.parseInt(st.nextToken());

		// 격자판의 상태를 저장할 2차원 배열 grid 초기화
		grid = new char[row][column];

		// for 반복문을 사용해 격자판의 각 행을 순회
		for (int r = 0; r < row; r++) {

			// readLine() 메서드를 사용해 입력 받은 격자판의 행의 정보를 변수 line에 할당
			String line = in.readLine();

			// for 반복문을 사용해 격자판의 각 정보를 2차원 배열 grid에 저장
			for (int c = 0; c < column; c++)
				grid[r][c] = line.charAt(c);
		}

		// 짝수 시간인 경우
		if (time % 2 == 0) {

			// for 반복문을 사용해 격자판의 각 행을 순회
			for (int r = 0; r < row; r++) {

				// for 반복문을 사용해 격자판의 각 열의 개수만큼 'O'를 출력
				for (int c = 0; c < column; c++)
					out.write("O");

				// newLine() 메서드를 사용해 줄바꿈을 출력
				out.newLine();
			}

		// 홀수 시간인 경우
		} else {

			// gridRenewer() 메서드를 호출해 격자판의 상태를 갱신
			gridRenewer(1);
			
			// for 반복문을 사용해 격자판의 각 행을 순회
			for (int r = 0; r < row; r++) {
				
				// for 반복문을 사용해 격자판의 각 열의 값을 출력
				for (int c = 0; c < column; c++)
					out.write(grid[r][c]);
				
				// newLine() 메서드를 사용해 줄바꿈을 출력
				out.newLine();
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// gridRenewer() 메서드 정의
	public static void gridRenewer(int second) {
		
		// while 반복문을 사용해 해당 시간에 도달할 때까지 순회
		while (second < time) {
			
			// 폭탄의 위치를 저장할 Queue 객체 bombList 초기화
			Queue<int[]> bombList = new LinkedList<>();
			
			// for 반복문을 사용해 격자판의 각 행과 열을 순회
			for (int r = 0; r < row; r++) {
				for (int c = 0; c < column; c++) {
					
					// 해당 위치가 폭탄인 경우 bombList에 추가
					if (grid[r][c] == 'O')
						bombList.offer(new int[] {r, c});
				}
			}
			
			// for 반복문을 사용해 격자판에 폭탄을 채우는 작업을 실행
			for (int r = 0; r < row; r++)
				Arrays.fill(grid[r], 'O');
			
			// while 반복문을 사용해 bombList가 빌 때까지 순회
			while (!bombList.isEmpty()) {
				
				// poll() 메서드를 사용해 현재 위치를 배열 currentLoc에 할당
				int[] currentLoc = bombList.poll();
				
				// 해당 위치의 폭탄을 터진 것으로 처리
				grid[currentLoc[0]][currentLoc[1]] = '.';
				
				// for 반복문을 사용해 현재 위치에 인접한 각 위치를 순회
				for (int d = 0; d < 4; d++) {
					
					// 인접한 위치를 각 변수에 할당
					int nr = currentLoc[0] + dr[d];
					int nc = currentLoc[1] + dc[d];
					
					// 해당 위치가 격자판의 범위를 벗어난 경우 다음 위치를 순회
					if (nr < 0 || nr >= row || nc < 0 || nc >= column)
						continue;
					
					// 폭탄이 터진 위치를 갱신
					grid[nr][nc] = '.';
				}
			}
			
			// 시간을 갱신
			second += 2;
		}
	}
}