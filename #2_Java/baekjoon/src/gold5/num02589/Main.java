package gold5.num02589;

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
	
	// 보물 지도의 크기, 보물이 묻혀 있는 두 곳 사이를 최단 거리로 이동하는 시간을 저장할 각 변수 초기화
	static int height;
	static int width;
	static int minTime = 0;
	
	// 인접한 위치를 나타낼 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// 보물 지도의 상태를 저장할 2차원 배열 map 초기화
	static char[][] map;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 보물 지도의 크기를 각 변수에 할당
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		
		// 보물 지도의 상태를 저장할 2차원 배열 map 초기화
		map = new char[height][width];
		
		// for 반복문을 사용해 보물 지도의 행을 순회
		for (int r = 0; r < height; r++) {
			
			// readLine() 메서드를 사용해 입력 받은 보물 지도의 행의 상태를 변수 line에 할당
			String line = in.readLine();
			
			// for 반복문을 사용해 보물 지도의 상태를 2차원 배열 map에 저장
			for (int c = 0; c < width; c++)
				map[r][c] = line.charAt(c);
		}
		
		// for 반복문을 사용해 각 보물 지도의 칸을 순회
		for (int r = 0; r < height; r++) {
			for (int c = 0; c < width; c++) {
				
				/* 해당 위치가 육지인 경우 treasureFinder() 메서드를 호출해
				보물이 묻혀 있는 두 곳 사이를 최단 거리로 이동하는 시간을 갱신 */
				if (map[r][c] == 'L') 
					treasureFinder(r, c);
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 보물이 묻혀 있는 두 곳 사이를 최단 거리로 이동하는 시간을 출력
		out.write(String.valueOf(minTime));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// treasureFinder() 메서드 정의
	public static void treasureFinder(int startRow, int startCol) {
		
		// 시작 위치로부터 소요되는 이동 시간을 저장할 2차원 배열 minDist 초기화
		Integer[][] minDist = new Integer[height][width];
		
		// 다음에 확인할 위치를 저장할 Queue 객체 checkList 초기화
		Queue<int[]> checkList = new LinkedList<>();
		
		// offer() 메서드를 사용해 시작 위치를 checkList에 추가 및 최소 이동 시간 갱신
		checkList.offer(new int[] {startRow, startCol});
		minDist[startRow][startCol] = 0;
		
		// while 반복문을 사용해 checkList가 빌 때까지 순회
		while (!checkList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 위치를 배열 curLoc에 할당
			int[] curLoc = checkList.poll();
			
			// max() 메서드를 사용해 보물이 묻혀 있는 두 곳 사이를 최단 거리로 이동하는 시간을 갱신
			minTime = Math.max(minDist[curLoc[0]][curLoc[1]], minTime);
			
			// for 반복문을 사용해 인접한 위치를 순회
			for (int d = 0; d < 4; d++) {
				
				// 새로운 위치를 각 변수에 할당
				int nr = curLoc[0] + dr[d];
				int nc = curLoc[1] + dc[d];
				
				// 해당 위치가 보물 지도의 범위를 벗어난 경우 다음 위치를 순회
				if (nr < 0 || nr >= height || nc < 0 || nc >= width)
					continue;
				
				// 해당 위치를 이미 확인했거나 바다인 경우 다음 위치를 순회
				if (minDist[nr][nc] != null || map[nr][nc] == 'W')
					continue;
				
				// offer() 메서드를 사용해 해당 위치를 checkList에 추가 및 최소 이동 시간 갱신
				checkList.offer(new int[] {nr, nc});
				minDist[nr][nc] = minDist[curLoc[0]][curLoc[1]] + 1;
			}
		}
	}
}