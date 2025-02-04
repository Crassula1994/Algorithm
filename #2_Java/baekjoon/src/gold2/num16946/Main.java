package gold2.num16946;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 맵의 크기를 저장할 각 변수 초기화
	static int height;
	static int width;
	
	// 인접한 위치를 나타낼 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// 맵의 상태와 빈 칸이 속한 그룹을 저장할 각 2차원 배열 초기화
	static int[][] map;
	static int[][] cellGroups;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 맵의 크기를 각 변수에 할당
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		
		// 맵의 상태와 빈 칸이 속한 그룹을 저장할 각 2차원 배열 초기화
		map = new int[height][width];
		cellGroups = new int[height][width];
		
		// 그룹의 번호를 저장할 변수 groupNum 초기화
		int groupNum = 1;
		
		// 각 빈 칸이 속한 그룹별 칸의 개수를 저장할 Map 객체 groupCounts 초기화
		Map<Integer, Integer> groupCounts = new HashMap<>();
		
		// for 반복문을 사용해 맵의 각 행을 순회
		for (int r = 0; r < height; r++) {
			
			// readLine() 메서드를 사용해 입력 받은 맵의 행의 상태를 변수 line에 할당
			String line = in.readLine();
			
			// for 반복문을 사용해 입력 받은 맵의 상태를 2차원 배열 map에 저장
			for (int c = 0; c < width; c++)
				map[r][c] = line.charAt(c) - '0';
		}
		
		// for 반복문을 사용해 맵의 각 칸을 순회
		for (int r = 0; r < height; r++) {
			for (int c = 0; c < width; c++) {
				
				// 해당 칸이 벽이거나 이미 그룹을 부여한 빈 칸인 경우 다음 칸을 순회
				if (map[r][c] == 1 || cellGroups[r][c] != 0)
					continue;
				
				// groupCounter() 및 put() 메서드를 사용해 해당 빈 칸 그룹의 칸의 개수를 groupCounts에 저장
				groupCounts.put(groupNum, groupCounter(r, c, groupNum++));
			}
		}
		
		// for 반복문을 사용해 맵의 각 칸을 순회
		for (int r = 0; r < height; r++) {
			for (int c = 0; c < width; c++) {
				
				// 해당 칸이 빈 칸인 경우 0을 출력 후 다음 칸을 순회
				if (map[r][c] == 0) {
					out.write("0");
					continue;
				}
				
				// 해당 벽에서 이동할 수 있는 칸의 개수를 저장할 변수 count 초기화
				int count = 1;
				
				// 해당 벽과 인접한 빈 칸의 그룹을 저장할 Set 객체 adjGroups 초기화
				Set<Integer> adjGroups = new HashSet<>();
				
				// for 반복문을 사용해 해당 벽과 인접한 각 위치를 순회
				for (int d = 0; d < 4; d++) {
					
					// 인접한 위치를 각 변수에 할당
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					// 해당 위치가 맵의 범위를 벗어나거나 벽인 경우 다음 위치를 순회
					if (nr < 0 || nr >= height || nc < 0 || nc >= width || map[nr][nc] == 1)
						continue;
					
					// 해당 빈 칸의 그룹을 이미 확인한 경우 다음 위치를 순회
					if (adjGroups.contains(cellGroups[nr][nc]))
						continue;
					
					// add() 메서드를 사용해 해당 빈 칸의 그룹을 adjGroups에 추가
					adjGroups.add(cellGroups[nr][nc]);
					
					// get() 메서드를 사용해 해당 벽에서 이동할 수 있는 칸의 개수를 갱신
					count += groupCounts.get(cellGroups[nr][nc]);
				}
					
				// valueOf() 및 write() 메서드를 사용해 이동할 수 있는 칸의 개수를 10으로 나눈 나머지를 출력
				out.write(String.valueOf(count % 10));
			}
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// groupCounter() 메서드 정의
	public static int groupCounter(int startRow, int startColumn, int groupNum) {
		
		// 해당 그룹에 속한 칸의 개수를 저장할 변수 count 초기화
		int count = 1;
		
		// 다음에 확인할 칸을 저장할 Queue 객체 cellList 초기화
		Queue<int[]> cellList = new LinkedList<>();
		
		// offer() 메서드를 사용해 시작한 칸을 cellList에 추가 후 그룹 번호 갱신
		cellList.offer(new int[] {startRow, startColumn});
		cellGroups[startRow][startColumn] = groupNum;
		
		// while 반복문을 사용해 cellList가 빌 때까지 순회
		while (!cellList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 칸을 배열 curCell에 할당
			int[] curCell = cellList.poll();
			
			// for 반복문을 사용해 인접한 각 칸을 순회
			for (int d = 0; d < 4; d++) {
				
				// 인접한 칸의 위치를 각 변수에 할당
				int nr = curCell[0] + dr[d];
				int nc = curCell[1] + dc[d];
				
				// 해당 칸이 맵의 범위를 벗어난 경우 다음 칸을 순회
				if (nr < 0 || nr >= height || nc < 0 || nc >= width)
					continue;
				
				// 해당 칸이 벽이거나 이미 확인한 위치인 경우 다음 칸을 순회
				if (map[nr][nc] == 1 || cellGroups[nr][nc] != 0)
					continue;
				
				// 해당 그룹에 속한 칸의 개수를 갱신
				count++;
				
				// offer() 메서드를 사용해 해당 칸을 cellList에 추가 후 그룹 번호 갱신
				cellList.offer(new int[] {nr, nc});
				cellGroups[nr][nc] = groupNum;
			}
		}
		
		// 해당 그룹에 속한 칸의 개수를 반환
		return count;
	}
}