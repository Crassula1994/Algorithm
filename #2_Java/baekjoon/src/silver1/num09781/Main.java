package silver1.num09781;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 격자판의 크기를 저장할 각 변수 초기화
	static int height;
	static int width;
	
	// 나이트가 이동할 위치를 저장할 각 델타 배열 초기화
	static int[] dr = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] dc = {-2, -1, 1, 2, 2, 1, -1, -2};
	
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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 격자판의 크기를 각 변수에 할당
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		
		// 나이트의 출발 위치를 저장할 각 변수 초기화
		int startRow = -1;
		int startColumn = -1;
		
		// 격자판의 상태를 저장할 2차원 배열 grid 초기화
		grid = new char[height][width];
		
		// for 반복문을 사용해 격자판의 각 행을 순회
		for (int r = 0; r < height; r++) {
			
			// readLine() 메서드를 사용해 입력 받은 격자판의 행의 상태를 변수 row에 할당
			String row = in.readLine();
			
			// for 반복문을 사용해 격자판의 각 칸을 순회
			for (int c = 0; c < width; c++) {
				
				// charAt() 메서드를 사용해 입력 받은 격자판의 상태를 2차원 배열 grid에 저장
				grid[r][c] = row.charAt(c);
				
				// 해당 위치가 나이트의 출발 위치인 경우 나이트의 출발 위치를 갱신
				if (grid[r][c] == 'K') {
					grid[r][c] = '.';
					startRow = r;
					startColumn = c;
				}
			}
		}
		
		// knightSimulator(), valueOf(), write() 메서드를 사용해 목적지에 도달하기 위한 나이트의 최소 이동 횟수를 출력
		out.write(String.valueOf(knightSimulator(startRow, startColumn)));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// knightSimulator() 메서드 정의
	public static int knightSimulator(int startRow, int startColumn) {
		
		// 나이트의 이동 횟수를 저장할 2차원 배열 minCounts 초기화
		Integer[][] minCounts = new Integer[height][width];
		
		// 다음에 이동할 위치를 저장할 Queue 객체 moveList 초기화
		Queue<int[]> moveList = new LinkedList<>();
		
		// offer() 메서드를 사용해 나이트의 출발 위치를 moveList에 추가 및 나이트의 이동 횟수를 갱신
		moveList.offer(new int[] {startRow, startColumn});
		minCounts[startRow][startColumn] = 0;
		
		// while 반복문을 사용해 moveList가 빌 때까지 순회
		while (!moveList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 위치를 배열 curPosition에 할당
			int[] curPosition = moveList.poll();
			
			// 현재 위치를 각 변수에 할당
			int curRow = curPosition[0];
			int curColumn = curPosition[1];
			
			// 현재 위치가 목적지인 경우 목적지까지의 최소 이동 횟수를 반환
			if (grid[curRow][curColumn] == 'X')
				return minCounts[curRow][curColumn];
			
			// for 반복문을 사용해 나이트가 다음에 이동할 위치를 순회
			for (int d = 0; d < 8; d++) {
				
				// 다음에 이동할 위치를 각 변수에 할당
				int nextRow = curRow + dr[d];
				int nextColumn = curColumn + dc[d];
				
				// 해당 위치가 격자판의 범위를 벗어나는 경우 다음 위치를 순회
				if (nextRow < 0 || nextRow >= height || nextColumn < 0 || nextColumn >= width)
					continue;
				
				// 해당 위치에 다른 말이 있거나 이미 이동했던 위치인 경우 다음 위치를 순회
				if (grid[nextRow][nextColumn] == '#' || minCounts[nextRow][nextColumn] != null)
					continue;
				
				// offer() 메서드를 사용해 해당 위치를 moveList에 추가 및 나이트의 이동 횟수를 갱신
				moveList.offer(new int[] {nextRow, nextColumn});
				minCounts[nextRow][nextColumn] = minCounts[curRow][curColumn] + 1;
			}
		}
		
		// 나이트가 목적지에 도달할 수 없는 경우 -1을 반환
		return -1;
	}
}