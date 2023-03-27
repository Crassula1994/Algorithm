package gold3.num02206;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 각 행렬의 크기, 최단 거리를 저장할 각 변수 초기화
	static int rowNum;
	static int colNum;
	static int minDistance = Integer.MAX_VALUE;
	
	// 인접한 위치를 탐색할 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// 맵의 상태를 저장할 2차원 배열 map 초기화
	static int[][] map;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 각 행렬의 크기를 각 변수에 할당
		rowNum = Integer.parseInt(st.nextToken());
		colNum = Integer.parseInt(st.nextToken());
		
		// 맵의 상태를 저장할 2차원 배열 map 초기화
		map = new int[rowNum][colNum];
		
		// 벽의 위치를 저장할 List 객체 wallList 초기화
		List<int[]> wallList = new ArrayList<>();
		
		// for 반복문을 사용해 배열 map의 각 행을 순회
		for (int r = 0; r < rowNum; r++) {
			
			// readLine() 메서드를 사용해 입력 받은 각 행의 숫자를 변수 line에 할당
			String line = in.readLine();
			
			// for 반복문을 사용해 배열 map의 각 열에 입력 받은 맵의 상태를 저장
			for (int c = 0; c < colNum; c++) {
				map[r][c] = line.charAt(c) - '0';
				
				// 해당 위치가 벽인 경우 add() 메서드를 사용해 wallList에 추가
				if (map[r][c] == 1)
					wallList.add(new int[] {r, c});
			}
		}
		
		// minDistCalculator() 메서드를 호출해 벽을 부수지 않은 경우 최단 거리를 변수 minDistance에 갱신
		minDistCalculator();
		
		// for 반복문을 사용해 각 벽을 부쉈을 경우를 순회
		for (int idx = 0; idx < wallList.size(); idx++) {
			
			// get() 메서드를 사용해 부술 벽의 위치를 배열 brokenWall에 할당
			int[] brokenWall = wallList.get(idx);
			
			// 벽을 부순 것으로 처리
			map[brokenWall[0]][brokenWall[1]] = 0;
			
			// minDistCalculator() 메서드를 호출해 최단 거리를 변수 minDistance에 갱신
			minDistCalculator();
			
			// 부순 벽을 원상복구
			map[brokenWall[0]][brokenWall[1]] = 1;
		}
		
		// 도달할 수 없는 경우 -1 출력
		if (minDistance == Integer.MAX_VALUE) {
			out.write(String.valueOf(-1));
			
		// 도달할 수 있는 경우 최단 거리를 출력
		} else {
			out.write(String.valueOf(minDistance));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// minDistCalculator() 메서드 정의 
	public static void minDistCalculator() {
		
		// 출발점으로부터의 거리를 저장할 2차원 배열 distances 초기화
		int[][] distances = new int[rowNum][colNum];
		
		// 방문할 위치를 저장할 Queue 객체 visitList 초기화
		Queue<int[]> visitList = new LinkedList<>();
		
		// offer() 메서드를 사용해 출발점을 visitList에 추가 및 방문 처리
		visitList.offer(new int[] {0, 0});
		distances[0][0] = 1;
		
		// while 반복문을 사용해 visitList가 빌 때까지 순회
		while (!visitList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 방문 중인 위치를 배열 currentLoc에 저장
			int[] currentLoc = visitList.poll();
			
			// for 반복문을 사용해 인접한 위치를 순회
			for (int d = 0; d < 4; d++) {
				
				// 다음에 방문할 인접 위치를 각 변수에 할당
				int nr = currentLoc[0] + dr[d];
				int nc = currentLoc[1] + dc[d];
				
				// 해당 위치가 범위를 벗어나지 않고, 방문하지 않은 곳이며 벽이 아닌 경우
				if (nr >= 0 && nr < rowNum && nc >= 0 && nc < colNum && distances[nr][nc] == 0 && map[nr][nc] == 0) {
					
					// offer() 메서드를 사용해 visitList에 추가 및 방문 처리
					visitList.offer(new int[] {nr, nc});
					distances[nr][nc] = distances[currentLoc[0]][currentLoc[1]] + 1;
				}
			}
		}
		
		// 도달할 수 없는 경우가 아닌 경우 min() 메서드를 사용해 최단 거리를 갱신
		if (distances[rowNum - 1][colNum - 1] != 0)
			minDistance = Math.min(distances[rowNum - 1][colNum - 1], minDistance);
	}
}