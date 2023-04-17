package gold3.num01600;

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
	
	// 말처럼 이동할 수 있는 횟수, 격자판의 가로 길이 및 세로 길이를 나타내는 각 변수 초기화
	static int limit;
	static int width;
	static int height;
	
	// 격자판의 상태를 저장할 2차원 배열 grid 초기화
	static int[][] grid;
	
	// 원숭이가 인접한 위치로 이동하는 경우를 나타내는 각 델타 배열 초기화
	static int[] mr = {-1, 1, 0, 0};
	static int[] mc = {0, 0, -1, 1};
	
	// 말처럼 이동하는 경우를 나타내는 각 델타 배열 초기화
	static int[] hr = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] hc = {-2, -1, 1, 2, 2, 1, -1, -2};
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 말처럼 이동할 수 있는 횟수를 변수 limit에 할당
		limit = Integer.parseInt(in.readLine());
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 격자판의 가로 길이 및 세로 길이를 각 변수에 할당
		width = Integer.parseInt(st.nextToken());
		height = Integer.parseInt(st.nextToken());
		
		// 격자판의 상태를 저장할 2차원 배열 grid 초기화
		grid = new int[height][width];
		
		// for 반복문을 사용해 격자판의 각 행을 순회
		for (int r = 0; r < height; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 격자판의 각 열을 순회하며 격자판의 상태를 배열 grid에 저장
			for (int c = 0; c < width; c++)
				grid[r][c] = Integer.parseInt(st.nextToken());
		}
		
		// movementTracker() 메서드를 호출해 원숭이 동작 수의 최솟값을 변수 minCnt에 할당
		int minCnt = movementTracker();
		
		// valueOf() 및 write() 메서드를 사용해 원숭이 동작 수의 최솟값을 출력
		out.write(String.valueOf(minCnt));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// movementTracker() 메서드 정의
	public static int movementTracker() {
		
		// 해당 위치의 방문 여부를 나타낼 3차원 배열 visited 초기화
		Integer[][][] visited = new Integer[limit + 1][height][width];
		
		// 다음에 방문할 위치를 저장할 Queue 객체 visitList 초기화
		Queue<int[]> visitList = new LinkedList<>();
		
		// offer() 메서드를 사용해 시작 위치를 추가 및 방문 처리
		visitList.offer(new int[] {0, 0, 0});
		visited[0][0][0] = 0;
		
		// while 반복문을 사용해 visitList가 빌 때까지 순회
		while (!visitList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 방문하는 위치를 배열 currentLoc에 할당
			int[] currentLoc = visitList.poll();
			
			// 해당 위치가 도착점인 경우 해당 위치까지의 이동 횟수를 반환
			if (currentLoc[1] == height - 1 && currentLoc[2] == width - 1)
				return visited[currentLoc[0]][currentLoc[1]][currentLoc[2]];
			
			// for 반복문을 사용해 원숭이가 인접한 위치로 이동하는 경우를 순회
			for (int m = 0; m < 4; m++) {
				
				// 새로운 인접 위치를 각 변수에 할당
				int nr = currentLoc[1] + mr[m];
				int nc = currentLoc[2] + mc[m];
				
				// 해당 위치가 범위를 벗어나는 경우 다음 위치를 순회
				if (nr < 0 || nr >= height || nc < 0 || nc >= width)
					continue;
					
				// 해당 위치를 방문한 적이 있거나 장애물인 경우 다음 위치를 순회
				if (visited[currentLoc[0]][nr][nc] != null || grid[nr][nc] == 1)
					continue;
					
				// offer() 메서드를 사용해 새로운 위치를 추가 및 방문 처리
				visitList.offer(new int[] {currentLoc[0], nr, nc});
				visited[currentLoc[0]][nr][nc] = visited[currentLoc[0]][currentLoc[1]][currentLoc[2]] + 1;
			}
			
			// 말처럼 이동한 횟수가 말처럼 이동할 수 있는 횟수 이상인 경우 다음 위치를 순회
			if (currentLoc[0] >= limit)
				continue;
			
			// for 반복문을 사용해 원숭이가 말처럼 이동하는 경우를 순회
			for (int h = 0; h < 8; h++) {
				
				// 새로운 인접 위치를 각 변수에 할당
				int nr = currentLoc[1] + hr[h];
				int nc = currentLoc[2] + hc[h];
				
				// 해당 위치가 범위를 벗어나는 경우 다음 위치를 순회
				if (nr < 0 || nr >= height || nc < 0 || nc >= width)
					continue;
								
				// 해당 위치를 방문한 적이 있거나 장애물인 경우 다음 위치를 순회
				if (visited[currentLoc[0] + 1][nr][nc] != null || grid[nr][nc] == 1)
					continue;
				
				// offer() 메서드를 사용해 새로운 위치를 추가 및 방문 처리
				visitList.offer(new int[] {currentLoc[0] + 1, nr, nc});
				visited[currentLoc[0] + 1][nr][nc] = visited[currentLoc[0]][currentLoc[1]][currentLoc[2]] + 1;
			}
		}
		
		// 도착점까지 도달할 수 없는 경우 -1을 반환
		return -1;
	}
}