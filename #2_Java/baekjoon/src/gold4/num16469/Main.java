package gold4.num16469;

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
	
	// 미로의 행과 열의 크기, 한 지점에 세 악당이 모일 때 걸리는 최소 시간과 그러한 지점의 개수를 저장할 각 변수 초기화
	static int height;
	static int width;
	static int minTotalTime = Integer.MAX_VALUE;
	static int minCount = 0;
	
	// 악당들의 이동 방향을 나타낼 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// 미로의 정보, 세 악당의 시작 위치를 저장할 각 2차원 배열 초기화
	static boolean[][] maze;
	static int[][] startLocations = new int[3][2];
	
	// 세 악당이 각 위치로 이동하기 위해 필요한 최소 시간을 저장할 3차원 배열 minTimes 초기화
	static Integer[][][] minTimes;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 미로의 행과 열의 크기를 각 변수에 할당
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		
		// 미로의 정보를 저장할 2차원 배열 maze 초기화
		maze = new boolean[height][width];
		
		// 세 악당이 각 위치로 이동하기 위해 필요한 최소 시간을 저장할 3차원 배열 minTimes 초기화
		minTimes = new Integer[3][height][width];
		
		// for 반복문을 사용해 미로의 각 행을 순회
		for (int r = 0; r < height; r++) {
			
			// readLine() 메서드를 사용해 입력 받은 미로의 행의 상태를 변수 row에 할당
			String row = in.readLine();
			
			// for 반복문을 사용해 미로의 각 칸을 순회
 			for (int c = 0; c < width; c++) {
 				
 				// 해당 칸이 이동 가능한 길인 경우 미로의 상태를 갱신
 				if (row.charAt(c) - '0' == 0)
 					maze[r][c] = true;
 			}
		}
		
		// for 반복문을 사용해 각 악당의 시작 위치를 순회
		for (int idx = 0; idx < 3; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 해당 악당의 시작 위치를 2차원 배열 startLocations에 저장
			startLocations[idx][0] = Integer.parseInt(st.nextToken()) - 1;
			startLocations[idx][1] = Integer.parseInt(st.nextToken()) - 1;
		}
		
		// for 반복문을 사용해 각 악당이 각 위치로 이동하기 위해 필요한 최소 시간을 갱신
		for (int idx = 0; idx < 3; idx++)
			minTimeCalculator(idx);
		
		// minTimeFinder() 메서드를 호출해 한 지점에 세 악당이 모일 때 걸리는 최소 시간과 그러한 지점의 개수를 갱신
		minTimeFinder();
		
		// 세 악당이 모이는 지점이 없는 경우 -1을 출력
		if (minCount == 0) {
			out.write(String.valueOf(-1));
			
		// 세 악당이 모이는 지점이 있는 경우 최소 시간과 그 개수를 출력
		} else {
			out.write(minTotalTime + "\n" + minCount);
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// minTimeCalculator() 메서드 정의
	public static void minTimeCalculator(int curVillain) {
		
		// 다음에 악당이 이동할 위치를 저장할 Queue 객체 moveList 초기화
		Queue<int[]> moveList = new LinkedList<>();
		
		// offer() 메서드를 사용해 해당 악당의 출발 위치를 moveList에 저장 및 출발 위치까지의 최소 시간을 갱신
		moveList.offer(new int[] {startLocations[curVillain][0], startLocations[curVillain][1]});
		minTimes[curVillain][startLocations[curVillain][0]][startLocations[curVillain][1]] = 0;
		
		// while 반복문을 사용해 moveList가 빌 때까지 순회
		while (!moveList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 위치를 배열 curLocation에 할당
			int[] curLocation = moveList.poll();
			
			// for 반복문을 사용해 인접한 위치를 순회
			for (int d = 0; d < 4; d++) {
				
				// 인접한 위치의 좌표를 각 변수에 할당
				int nr = curLocation[0] + dr[d];
				int nc = curLocation[1] + dc[d];
				
				// 해당 위치가 미로의 범위를 벗어나는 경우 다음 위치를 순회
				if (nr < 0 || nr >= height || nc < 0 || nc >= width)
					continue;
				
				// 해당 위치가 벽이거나 해당 위치를 이미 이동했던 경우 다음 위치를 순회
				if (!maze[nr][nc] || minTimes[curVillain][nr][nc] != null)
					continue;
				
				// offer() 메서드를 사용해 해당 위치를 moveList에 저장 및 해당 위치까지의 최소 시간을 갱신
				moveList.offer(new int[] {nr, nc});
				minTimes[curVillain][nr][nc] = minTimes[curVillain][curLocation[0]][curLocation[1]] + 1;
			}
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// minTimeFinder() 메서드 정의
	public static void minTimeFinder() {
		
		// for 반복문을 사용해 각 칸을 순회
		for (int r = 0; r < height; r++) {
			outer: for (int c = 0; c < width; c++) {
				
				// 해당 위치가 벽인 경우 다음 위치를 순회
				if (!maze[r][c])
					continue;
				
				// 해당 칸에서 세 악당이 모일 때 걸리는 최소 시간을 저장할 변수 minTime 초기화
				int minTime = 0;
				
				// for 반복문을 사용해 각 악당을 순회
				for (int idx = 0; idx < 3; idx++) {
					
					// 해당 악당이 현재 칸으로 이동할 수 없는 경우 다음 칸을 순회
					if (minTimes[idx][r][c] == null)
						continue outer;
					
					// max() 메서드를 사용해 해당 칸에서 세 악당이 모일 때 걸리는 최소 시간을 갱신
					minTime = Math.max(minTimes[idx][r][c], minTime);
				}
				
				// 해당 칸에서 세 악당이 모일 때 걸리는 최소 시간이 저장된 최소 시간보다 짧은 경우
				if (minTime < minTotalTime) {
					
					// 세 악당이 모이는 최소 시간과 그 지점의 수를 갱신
					minTotalTime = minTime;
					minCount = 1;
					
				// 해당 칸에서 세 악당이 모일 때 걸리는 최소 시간이 저장된 최소 시간과 같은 경우 그 지점의 수를 갱신
				} else if (minTime == minTotalTime) {
					minCount++;
				}
			}
		}
	}
}