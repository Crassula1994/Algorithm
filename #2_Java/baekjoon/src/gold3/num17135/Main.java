package gold3.num17135;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 격자판 행 및 열의 수, 궁수의 공격 거리 제한를 저장할 각 변수 초기화
	static int rowNum;
	static int colNum;
	static int distLimit;
	
	// 궁수의 공격으로 제거할 수 있는 적의 최대 수를 저장할 변수 maxKill 초기화
	static int maxKill = Integer.MIN_VALUE;
	
	// 격자판의 상태를 저장 또는 이를 복제해 저장할 각 2차원 배열 초기화
	static int[][] map;
	static int[][] mapCopied;
	
	// 인접한 위치를 탐색할 각 델타 배열 초기화
	static int[] dr = {-1, 0, 0};
	static int[] dc = {0, -1, 1};
	
	// 궁수의 모든 가능한 배치 위치를 저장할 List 객체 archerLocation 초기화
	static List<Integer[]> archerLocation = new ArrayList<>();
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 격자판 행 및 열의 수, 궁수의 공격 거리 제한을 각 변수에 할당
		rowNum = Integer.parseInt(st.nextToken());
		colNum = Integer.parseInt(st.nextToken());
		distLimit = Integer.parseInt(st.nextToken());
		
		// 격자판의 상태를 저장할 2차원 배열 map 초기화
		map = new int[rowNum][colNum];
		
		// for 반복문을 사용해 격자판의 각 행을 순회
		for (int r = 0; r < rowNum; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 격자판의 각 열을 순회하며 입력 받은 상태를 배열 map에 저장
			for (int c = 0; c < colNum; c++)
				map[r][c] = Integer.parseInt(st.nextToken());
		}
		
		// archerLocator() 메서드를 호출해 궁수의 모든 가능한 배치 위치를 archerLocation에 저장
		archerLocator(0, 0, new Integer[3]);
		
		// for 반복문을 사용해 궁수의 모든 가능한 배치 위치를 순회
		for (int idx = 0; idx < archerLocation.size(); idx++) {
			
			// 격자판의 상태를 복제해 저장할 2차원 배열 mapCopied 초기화
			mapCopied = new int[rowNum][];
			
			// for 반복문을 사용해 격자판의 상태를 mapCopied에 복사
			for (int r = 0; r < rowNum; r++)
				mapCopied[r] = map[r].clone();
			
			// killCountCalculator() 메서드를 호출해 제거할 수 있는 적의 최대 수를 갱신
			killCountCalculator(1, archerLocation.get(idx), 0);
		}
		
		// valueOf() 및 write() 메서드를 사용해 궁수의 공격으로 제거할 수 있는 적의 최대 수를 출력
		out.write(String.valueOf(maxKill));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// archerLocator() 메서드 정의
	public static void archerLocator(int selectedNum, int startIdx, Integer[] location) {
				
		// 3명의 궁수 위치를 모두 선택한 경우
		if (selectedNum == 3) {
			
			// add() 메서드를 사용해 궁수의 배치 위치를 저장한 배열 location을 archerLocation에 저장
			archerLocation.add(location);
		
		// 3명의 궁수 위치를 모두 선택하지 못한 경우
		} else {
			
			// for 반복문을 사용해 각 위치를 순회
			for (int loc = startIdx; loc < colNum; loc++) {
				
				// 해당 위치를 선택 처리
				location[selectedNum] = loc;
				
				// 해당 위치를 선택한 경우를 상정해 archerLocator 재귀 호출
				archerLocator(selectedNum + 1, loc + 1, location.clone());
				
				// 해당 위치를 원상 복구
				location[selectedNum] = null;
			}
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// killCountCalculator() 메서드 정의
	public static void killCountCalculator(int turn, Integer[] locations, int killCnt) {
		
		// 모든 턴이 끝난 경우
		if (turn > rowNum) {
			
			// max() 메서드를 사용해 궁수의 공격으로 제거할 수 있는 적의 최대 수를 갱신
			maxKill = Math.max(killCnt, maxKill);
			
			// 메서드 종료
			return;
		}
		
		// 각 궁수가 공격할 적의 위치를 저장할 Queue 객체 killList 초기화
		Queue<int[]> killList = new LinkedList<>();
		
		// for 반복문을 사용해 각 궁수를 순회
		for (int idx = 0; idx < locations.length; idx++) {
			
			// 해당 궁수로부터 각 위치까지의 거리를 저장할 2차원 배열 distances 초기화
			int[][] distances = new int[rowNum][colNum];
			
			// 방문할 위치를 저장할 Queue 객체 visitList 초기화
			Queue<int[]> visitList = new LinkedList<>();
			
			// 사정거리 내에 존재하는 모든 적을 저장할 PriorityQueue 객체 enemyList 초기화
			PriorityQueue<int[]> enemyList = new PriorityQueue<>((e1, e2) -> {
				return (e1[0] == e2[0]) ? e1[2] - e2[2] : e1[0] - e2[0];
			});
			
			// 시작 위치를 배열 startLoc에 저장
			int[] startLoc = {rowNum - turn, locations[idx]};
			
			// offer() 메서드를 사용해 시작 위치를 visitList에 추가 및 방문 처리
			visitList.offer(startLoc);
			distances[startLoc[0]][startLoc[1]] = 1;
			
			// while 반복문을 사용해 visitList가 빌 때까지 순회
			while (!visitList.isEmpty()) {
				
				// poll() 메서드를 사용해 현재 방문하고 있는 위치를 배열 currentLoc에 저장
				int[] currentLoc = visitList.poll();
				
				// 현재 방문하고 있는 위치의 거리를 변수 distance에 할당
				int distance = distances[currentLoc[0]][currentLoc[1]];
				
				// 해당 위치가 사정 거리를 벗어난 경우 반복문 탈출
				if (distance > distLimit)
					break;
				
				// 해당 위치에 적이 존재하는 경우
				if (mapCopied[currentLoc[0]][currentLoc[1]] == 1) {
					
					// 해당 위치까지의 거리 및 위치를 배열 enemy에 저장
					int[] enemy = {distance, currentLoc[0], currentLoc[1]};
					
					// offer() 메서드를 사용해 enemy를 enemyList에 추가
					enemyList.offer(enemy);
				}

				// for 반복문을 사용해 해당 위치에 인접한 위치를 순회
				for (int d = 0; d < 3; d++) {
					
					// 새로운 위치를 각 변수에 할당
					int nr = currentLoc[0] + dr[d];
					int nc = currentLoc[1] + dc[d];
					
					// 해당 위치가 공간을 벗어나지 않고, 방문하지 않은 위치인 경우
					if (nr >= 0 && nc >=0 && nc < colNum && distances[nr][nc] == 0) {
						
						// 해당 위치를 배열 nextLoc에 저장
						int[] nextLoc = {nr, nc};
						
						// offer() 메서드를 사용해 해당 위치를 visitList에 추가 및 방문 처리
						visitList.offer(nextLoc);
						distances[nr][nc] = distances[currentLoc[0]][currentLoc[1]] + 1;
					}
				}
			}
			
			// 공격할 수 있는 적이 하나 이상 있는 경우
			if (!enemyList.isEmpty()) {
				
				// poll() 메서드를 사용해 가장 우선순위가 높은 적을 배열 selectedEnemy에 할당
				int[] selectedEnemy = enemyList.poll();
				
				// 해당 적의 위치를 배열 killLoc에 저장
				int[] killLoc = {selectedEnemy[1], selectedEnemy[2]};
				
				// offer() 메서드를 사용해 공격한 적의 위치를 killList에 추가
				killList.offer(killLoc);
			}
		}
		
		// 죽인 적이 하나 이상 있는 경우
		if (!killList.isEmpty()) {
			
			// while 반복문을 사용해 공격한 모든 적을 순회
			while (!killList.isEmpty()) {
				
				// poll() 메서드를 사용해 죽인 적의 위치를 배열 killLoc에 저장
				int[] killLoc = killList.poll();
				
				// 해당 위치의 적이 죽지 않은 경우
				if (mapCopied[killLoc[0]][killLoc[1]] == 1) {
					
					// 해당 적 제거 처리
					mapCopied[killLoc[0]][killLoc[1]] = 0;
					
					// 죽인 적의 수 갱신
					killCnt++;
				}
			}
		}
		
		// killCountCalculator() 메서드 재귀 호출
		killCountCalculator(turn + 1, locations, killCnt);
	}
}