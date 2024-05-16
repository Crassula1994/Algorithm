package gold1.num17472;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 지도의 크기, 섬의 개수를 저장할 각 변수 초기화
	static int height;
	static int width;
	static int islandNum = 0;
	
	// 각 인접한 위치를 저장할 델타 배열 초기화
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	
	// 지도의 정보를 저장할 2차원 배열 map 초기화
	static int[][] map;
	
	// 가능한 다리의 목록을 저장할 List 객체 bridges 초기화
	static List<Bridge> bridges = new ArrayList<>();
	
	// ----------------------------------------------------------------------------------------------------
	
	// Bridge 클래스 정의
	public static class Bridge implements Comparable<Bridge> {
		
		// 다리가 연결하는 각 섬 및 그 길이를 저장할 각 변수 초기화
		int startIsland;
		int endIsland;
		int length;
		
		// 매개변수를 입력 받는 생성자 정의
		public Bridge(int startIsland, int endIsland, int length) {
			this.startIsland = startIsland;
			this.endIsland = endIsland;
			this.length = length;
		}

		// compareTo() 메서드 정의
		@Override
		public int compareTo(Bridge anotherBridge) {
			return length - anotherBridge.length;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// DisjointSet 클래스 정의
	public static class DisjointSet {
		
		// 각 섬의 근원 섬을 저장할 배열 rootIsland 초기화
		int[] rootIsland;
		
		// 매개변수를 입력 받는 생성자 정의
		public DisjointSet(int islandNum) {
			
			// 각 섬의 근원 섬을 저장할 배열 rootIsland 초기화
			rootIsland = new int[islandNum + 2];
			
			// for 반복문을 사용해 각 섬의 근원 섬을 갱신
			for (int idx = 0; idx < rootIsland.length; idx++)
				rootIsland[idx] = idx;
		}
		
		// find() 메서드 정의
		public int find(int island) {
			
			// 해당 섬의 근원 섬이 자기 자신인 경우 자기 자신을 반환
			if (rootIsland[island] == island)
				return island;
			
			// find() 메서드를 재귀 호출해 해당 섬의 근원 섬을 찾아 반환
			return rootIsland[island] = find(rootIsland[island]);
		}
		
		// union() 메서드 정의
		public void union(int islandA, int islandB) {
			
			// find() 메서드를 호출해 각 섬의 근원 섬을 찾아 각 변수에 할당
			int rootA = find(islandA);
			int rootB = find(islandB);
			
			// 두 섬의 근원 섬이 다른 경우 근원 섬을 갱신
			if (rootA != rootB)
				rootIsland[Math.max(rootA, rootB)] = Math.min(rootA, rootB);
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 지도의 크기를 각 변수에 할당
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		
		// 지도의 정보를 저장할 2차원 배열 map 초기화
		map = new int[height][width];
		
		// for 반복문을 사용해 지도의 각 행을 순회
		for (int r = 0; r < height; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 지도의 정보를 2차원 배열 map에 저장
			for (int c = 0; c < width; c++)
				map[r][c] = Integer.parseInt(st.nextToken());
		}
		
		// for 반복문을 사용해 지도의 각 칸을 순회
		for (int r = 0; r < height; r++) {
			for (int c = 0; c < width; c++) {
				
				// 해당 칸이 아직 확인하지 않은 섬인 경우 islandCounter() 메서드를 호출해 섬의 개수 갱신
				if (map[r][c] == 1)
					islandCounter(r, c);
			}
		}
		
		// for 반복문을 사용해 지도의 각 칸을 순회
		for (int r = 0; r < height; r++) {
			for (int c = 0; c < width; c++) {
			
				// 해당 칸이 바다인 경우
				if (map[r][c] == 0) {
					
					// for 반복문을 사용해 인접한 위치를 순회
					for (int d = 0; d < 4; d++) {
						
						// 인접한 위치를 각 변수에 할당
						int nr = r + dr[d];
						int nc = c + dc[d];
						
						// 해당 위치가 지도의 범위를 벗어난 경우 다음 위치를 순회
						if (nr < 0 || nr >= height || nc < 0 || nc >= width)
							continue;
						
						// 해당 위치가 바다인 경우 다음 위치를 순회
						if (map[nr][nc] == 0)
							continue;
						
						// bridgeMaker() 메서드를 호출해 건설 가능한 다리인지 확인 후 bridges에 추가
						bridgeMaker(map[nr][nc], nr, nc, (d + 2) % 4, 0);
					}
				}
			}
		}
		
		// sort() 메서드를 사용해 각 다리를 길이 기준 오름차순으로 정렬
		Collections.sort(bridges);
		
		// 각 섬의 연결 여부를 확인할 DisjointSet 객체 connection 초기화
		DisjointSet connection = new DisjointSet(islandNum);
		
		// 모든 섬을 연결하는 다리 길이의 최솟값과 연결한 다리의 개수를 저장할 각 변수 초기화
		int minLength = 0;
		int bridgeNum = 0;
		
		// for 반복문을 사용해 각 다리를 순회
		for (Bridge bridge : bridges) {
			
			// 섬 연결에 필요한 모든 다리를 연결한 경우 반복문 탈출
			if (bridgeNum == islandNum - 1)
				break;
			
			// 해당 다리가 연결하는 두 섬이 연결되지 않은 경우
			if (connection.find(bridge.startIsland) != connection.find(bridge.endIsland)) {
				
				// union() 메서드를 호출해 두 섬을 연결 처리
				connection.union(bridge.startIsland, bridge.endIsland);
				
				// 모든 섬을 연결하는 다리 길이의 최솟값과 연결한 다리의 개수를 갱신
				minLength += bridge.length;
				bridgeNum++;
			}
		}
		
		// 모든 섬을 연결하는 것이 불가능한 경우 -1 출력
		if (bridgeNum < islandNum - 1) {
			out.write(String.valueOf(-1));
			
		// 모든 섬을 연결하는 것이 가능한 경우 모든 섬을 연결하는 다리 길이의 최솟값을 출력
		} else {
			out.write(String.valueOf(minLength));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------

	// islandCounter() 메서드 정의
	public static void islandCounter(int startRow, int startCol) {
		
		// 다음에 확인할 위치를 저장할 Queue 객체 checkList 초기화
		Queue<int[]> checkList = new LinkedList<>();
		
		// offer() 메서드를 사용해 시작 위치를 checkList에 추가 및 확인 처리
		checkList.offer(new int[] {startRow, startCol});
		map[startRow][startCol] = islandNum + 2;
		
		// while 반복문을 사용해 checkList가 빌 때까지 순회
		while (!checkList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 확인 중인 위치를 배열 curLoc에 할당
			int[] curLoc = checkList.poll();
			
			// for 반복문을 사용해 인접한 각 위치를 순회
			for (int d = 0; d < 4; d++) {
				
				// 인접한 위치를 각 변수에 할당
				int nr = curLoc[0] + dr[d];
				int nc = curLoc[1] + dc[d];
				
				// 해당 위치가 지도의 범위를 벗어난 경우 다음 위치를 순회
				if (nr < 0 || nr >= height || nc < 0 || nc >= width)
					continue;
				
				// 해당 위치가 바다이거나 이미 확인한 경우 다음 위치를 순회
				if (map[nr][nc] != 1)
					continue;
				
				// offer() 메서드를 사용해 해당 위치를 checkList에 추가 및 확인 처리
				checkList.offer(new int[] {nr, nc});
				map[nr][nc] = islandNum + 2;
			}
		}
		
		// 섬의 개수를 갱신
		islandNum++;
	}
	
	// ----------------------------------------------------------------------------------------------------

	// bridgeMaker() 메서드 정의
	public static void bridgeMaker(int startIsland, int curRow, int curCol, int direction, int length) {
		
		// 다음 위치를 나타낼 각 변수 초기화
		int nextRow = curRow + dr[direction];
		int nextCol = curCol + dc[direction];
		
		// 다음 위치가 범위를 벗어난 경우 메서드 종료
		if (nextRow < 0 || nextRow >= height || nextCol < 0 || nextCol >= width)
			return;
		
		// 다음 위치가 땅인 경우
		if (map[nextRow][nextCol] != 0) {
			
			
			// 다음 위치가 시작한 섬이 아니고 다리의 길이가 2 이상인 경우 해당 다리의 정보를 bridges에 추가
			if (map[nextRow][nextCol] != startIsland && length >= 2)
				bridges.add(new Bridge(startIsland, map[nextRow][nextCol], length));
			
			// 메서드 종료
			return;
		}
		
		// bridgeMaker() 메서드 재귀 호출
		bridgeMaker(startIsland, nextRow, nextCol, direction, length + 1);
	}
}