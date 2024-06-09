package gold3.num02146;

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
	
	// 지도의 크기, 가장 짧은 다리의 길이를 저장할 각 변수 초기화
	static int size;
	static int minLength = Integer.MAX_VALUE;
	
	// 인접한 위치를 나타낼 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// 지도의 상태 및 섬 간의 거리를 저장할 각 2차원 배열 초기화
	static int[][] map;
	static Integer[][] distances;
	
	// ----------------------------------------------------------------------------------------------------
	
	// Location 클래스 정의
	public static class Location {
		
		// 해당 위치의 좌표를 저장할 각 변수 초기화
		int row;
		int column;
		
		// 매개변수를 입력 받는 생성자 정의
		public Location (int row, int column) {
			this.row = row;
			this.column = column;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 지도의 크기를 변수 size에 할당
		size = Integer.parseInt(in.readLine());
		
		// 지도의 상태를 저장할 2차원 배열 map 초기화
		map = new int[size][size];
		
		// for 반복문을 사용해 입력 받은 지도의 행의 상태를 순회
		for (int r = 0; r < size; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 입력 받은 지도의 상태를 2차원 배열 map에 저장
			for (int c = 0; c < size; c++)
				map[r][c] = Integer.parseInt(st.nextToken());
		}
		
		// for 반복문을 사용해 각 지도의 칸을 순회
		for (int r = 0, islandNum = 2; r < size; r++) {
			for (int c = 0; c < size; c++) {
				
				// 해당 지도의 칸이 바다이거나 이미 확인한 섬인 경우 다음 칸을 순회
				if (map[r][c] != 1)
					continue;
				
				// islandFinder() 메서드를 호출해 해당 위치의 섬을 확인
				islandFinder(r, c, islandNum++);
			}
		}
		
		// for 반복문을 사용해 각 지도의 칸을 순회
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
			
				// 해당 지도의 칸이 바다인 경우 다음 칸을 순회
				if (map[r][c] == 0)
					continue;
				
				// bridgeBuilder() 메서드를 호출해 해당 위치에서 건설할 수 있는 가장 짧은 다리의 길이를 갱신
				bridgeBuilder(r, c, map[r][c]);
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 가장 짧은 다리의 길이를 출력
		out.write(String.valueOf(minLength));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// islandFinder() 메서드 정의
	public static void islandFinder(int startRow, int startCol, int islandNum) {
		
		// 다음에 찾을 위치를 저장할 Queue 객체 findList 초기화
		Queue<Location> findList = new LinkedList<>();
		
		// offer() 메서드를 사용해 시작 위치를 findList에 추가 및 확인 처리
		findList.offer(new Location(startRow, startCol));
		map[startRow][startCol] = islandNum;
		
		// while 반복문을 사용해 findList가 빌 때까지 순회
		while (!findList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 확인 중인 위치를 변수 curLoc에 할당
			Location curLoc = findList.poll();
			
			// for 반복문을 사용해 인접한 위치를 순회
			for (int d = 0; d < 4; d++) {
			
				// 인접한 위치를 각 변수에 할당
				int nr = curLoc.row + dr[d];
				int nc = curLoc.column + dc[d];
				
				// 해당 위치가 지도의 범위를 벗어난 경우 다음 위치를 순회
				if (nr < 0 || nr >= size || nc < 0 || nc >= size)
					continue;
				
				// 해당 위치가 바다거나 이미 확인한 곳인 경우 다음 위치를 순회
				if (map[nr][nc] == 0 || map[nr][nc] == islandNum)
					continue;
				
				// offer() 메서드를 사용해 해당 위치를 findList에 추가 및 확인 처리
				findList.offer(new Location(nr, nc));
				map[nr][nc] = islandNum;
			}
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// bridgeBuilder() 메서드 정의
	public static void bridgeBuilder(int startRow, int startCol, int islandNum) {
		
		// 섬 간의 거리를 저장할 2차원 배열 distances 초기화
		distances = new Integer[size][size];
		
		// 다음에 건설할 위치를 저장할 Queue 객체 buildList 초기화
		Queue<Location> buildList = new LinkedList<>();
		
		// offer() 메서드를 사용해 시작 위치를 buildList에 추가 및 거리를 갱신
		buildList.offer(new Location(startRow, startCol));
		distances[startRow][startCol] = 0;
		
		// while 반복문을 사용해 buildList가 빌 때까지 순회
		while (!buildList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 확인 중인 위치를 변수 curLoc에 할당
			Location curLoc = buildList.poll();
			
			// 현재 확인 중인 위치가 다른 섬인 경우 가장 짧은 다리의 길이를 갱신 후 메서드 종료
			if (map[curLoc.row][curLoc.column] > 0 && map[curLoc.row][curLoc.column] != islandNum) {
				minLength = Math.min(distances[curLoc.row][curLoc.column] - 1, minLength);
				return;
			}
			
			// for 반복문을 사용해 인접한 위치를 순회
			for (int d = 0; d < 4; d++) {
			
				// 인접한 위치를 각 변수에 할당
				int nr = curLoc.row + dr[d];
				int nc = curLoc.column + dc[d];
				
				// 해당 위치가 지도의 범위를 벗어난 경우 다음 위치를 순회
				if (nr < 0 || nr >= size || nc < 0 || nc >= size)
					continue;
				
				// 해당 위치가 같은 섬이거나 이미 확인한 위치인 경우 다음 위치를 순회
				if (map[nr][nc] == islandNum || distances[nr][nc] != null)
					continue;
				
				// offer() 메서드를 사용해 해당 위치를 buildList에 추가 및 거리를 갱신
				buildList.offer(new Location(nr, nc));
				distances[nr][nc] = distances[curLoc.row][curLoc.column] + 1;
			}
		}
	}
}