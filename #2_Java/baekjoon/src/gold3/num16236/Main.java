package gold3.num16236;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 공간의 크기 및 아기 상어가 스스로 물고기를 잡아먹을 수 있는 시간을 저장할 각 변수 초기화
	static int size;
	static int maxTime = 0;
	
	// 공간의 상태를 저장할 배열 map 초기화
	static int[][] map;
	
	// 인접한 위치를 탐색할 각 델타 배열 초기화
	static int[] dr = {-1, 0, 0, 1};
	static int[] dc = {0, -1, 1, 0};
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 공간의 크기를 변수 size에 할당
		size = Integer.parseInt(in.readLine());
		
		// 공간의 상태를 저장할 배열 map 초기화
		map = new int[size][size];
		
		// 아기 상어의 위치를 저장할 배열 startLoc 초기화
		int[] startLoc = new int[2];
		
		// for 반복문을 사용해 배열 map의 각 행을 순회
		for (int r = 0; r < size; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 배열 map의 각 열을 순회
			for (int c = 0; c < size; c++) {
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 공간의 상태를 변수 map에 저장
				map[r][c] = Integer.parseInt(st.nextToken());
				
				// 해당 값이 아기 상어의 위치인 경우 이를 배열 startLoc에 저장
				if (map[r][c] == 9) {
					map[r][c] = 0;
					startLoc[0] = r;
					startLoc[1] = c;
				}
			}
		}
			
		// fishCatcher() 메서드를 호출해 아기 상어가 스스로 물고기를 잡아먹을 수 있는 시간을 변수 maxTime에 갱신
		fishCatcher(startLoc, 0, 2);
			
		// valueOf() 및 write() 메서드를 사용해 아기 상어가 스스로 물고기를 잡아먹을 수 있는 시간을 출력
		out.write(String.valueOf(maxTime));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// fishCatcher() 메서드 정의 
	public static void fishCatcher(int[] startLoc, int fishEaten, int sharkSize) {
		
		// 먹은 생선의 수가 상어의 크기와 같다면 먹은 생선의 수 및 상어의 크기 갱신
		if (fishEaten == sharkSize) {
			fishEaten = 0;
			sharkSize++;
		}
		
		// 해당 위치의 방문 여부를 저장할 2차원 배열 visited 초기화
		Integer[][] visited = new Integer[size][size];
		
		// 다음에 방문할 위치를 저장할 Queue 객체 visitList 초기화
		Queue<int[]> visitList = new LinkedList<>();
		
		// 먹을 수 있는 물고기를 저장할 ProrityQueue 객체 edibleFishes 초기화
		PriorityQueue<int[]> edibleFishes = new PriorityQueue<>((f1, f2) -> {
			return (f1[0] == f2[0]) ? (f1[1] == f2[1]) ? f1[2] - f2[2] : f1[1] - f2[1] : f1[0] - f2[0];
		});
		
		// offer() 메서드를 사용해 입력 받은 시작 위치를 visitList에 추가 및 방문 처리
		visitList.offer(startLoc);
		visited[startLoc[0]][startLoc[1]] = 0;
		
		// while 반복문을 사용해 visitList가 빌 때까지 순회
		while (!visitList.isEmpty()) {
			
			// poll() 메서드를 사용해 계산할 값을 변수 currentLoc에 할당
			int[] currentLoc = visitList.poll();
			
			// 해당 위치가 먹을 수 있는 물고기인 경우 
			if (map[currentLoc[0]][currentLoc[1]] != 0 && map[currentLoc[0]][currentLoc[1]] < sharkSize) {
				
				// 해당 물고기까지의 거리, 위치를 배열 edibleFish에 저장
				int[] edibleFish = {visited[currentLoc[0]][currentLoc[1]], currentLoc[0], currentLoc[1]};
				
				// offer() 메서드를 사용해 배열 edibleFish를 edibleFishes에 추가
				edibleFishes.offer(edibleFish);
			}

			// for 반복문을 사용해 각 델타 배열을 순회
			for (int d = 0; d < 4; d++) {
				
				// 새로운 위치를 각 변수에 할당
				int nr = currentLoc[0] + dr[d];
				int nc = currentLoc[1] + dc[d];
				
				// 해당 위치가 공간을 벗어나지 않고, 방문하지 않은 위치이며 상어 크기와 같거나 작은 경우
				if (nr >= 0 && nr < size && nc >=0 && nc < size && visited[nr][nc] == null && map[nr][nc] <= sharkSize) {
					
					// 해당 위치를 배열 nextLoc에 저장
					int[] nextLoc = {nr, nc};
					
					// offer() 메서드를 사용해 해당 위치를 visitList에 추가 및 방문 처리
					visitList.offer(nextLoc);
					visited[nr][nc] = visited[currentLoc[0]][currentLoc[1]] + 1;
				}
			}
		}
		
		// 먹을 수 있는 물고기가 한 마리 이상 있는 경우
		if (!edibleFishes.isEmpty()) {
			
			// poll() 메서드를 사용해 가장 우선순위가 높은 물고기를 배열 selectedFish에 할당
			int[] selectedFish = edibleFishes.poll();

			// 해당 위치로 이동하기까지의 시간을 갱신
			maxTime += selectedFish[0];
			
			// 해당 위치의 물고기를 제거
			map[selectedFish[1]][selectedFish[2]] = 0;
			
			// 아기 상어의 위치를 배열 nextLoc에 저장
			int[] nextLoc = {selectedFish[1], selectedFish[2]};
			
			// fishCatcher() 메서드 재귀 호출
			fishCatcher(nextLoc, fishEaten + 1, sharkSize);
		}
	}
}