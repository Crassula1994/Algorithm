package gold3.num31791;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	/* 격자의 크기, 바이러스가 전파되는 시간, 건물에서 전파가 지연되는 시간, 처음 바이러스가 살포된 지점의 개수,
	건물의 개수를 저장할 각 변수 초기화 */
	static int height;
	static int width;
	static int totalTime;
	static int delayTime;
	static int startZoneCount;
	static int buildingNum;
	
	// 인접한 구역을 나타낼 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// 처음 바이러스가 살포된 지점, 각 지점의 바이러스 전파 완료 시점을 저장할 각 2차원 배열 초기화
	static int[][] startZones;
	static Integer[][] infected;
	
	// ----------------------------------------------------------------------------------------------------
	
	// Zone 클래스 정의
	static class Zone implements Comparable<Zone> {
		
		// 해당 구역의 좌표 및 바이러스 전파 시간을 저장할 각 변수 초기화
		int row;
		int column;
		int infectedTime;
		
		// 매개변수를 입력 받는 생성자 정의
		public Zone(int row, int column, int infectedTime) {
			this.row = row;
			this.column = column;
			this.infectedTime = infectedTime;
		}

		// compareTo() 메서드 정의
		@Override
		public int compareTo(Zone anotherZone) {
			
			// 더 빠른 바이러스 전파 시간을 갖는 구역 순으로 정렬
			return infectedTime - anotherZone.infectedTime;
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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 격자의 크기를 각 변수에 할당
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		/* nextToken() 및 parseInt() 메서드를 사용해 입력 받은 바이러스가 전파되는 시간, 건물에서 전파가 지연되는 시간,
		처음 바이러스가 살포된 지점의 개수, 건물의 개수를 각 변수에 할당 */
		totalTime = Integer.parseInt(st.nextToken());
		delayTime = Integer.parseInt(st.nextToken());
		startZoneCount = Integer.parseInt(st.nextToken());
		buildingNum = Integer.parseInt(st.nextToken());
		
		// 처음 바이러스가 살포된 지점, 각 지점의 바이러스 전파 완료 시점을 저장할 각 2차원 배열 초기화
		startZones = new int[startZoneCount][2];
		infected = new Integer[height + 1][width + 1];
		
		// for 반복문을 사용해 각 격자의 행을 순회
		for (int r = 1, idx = 0; r <= height; r++) {
			
			// readLine() 메서드를 사용해 입력 받은 도시의 상태를 변수 line에 할당
			String line = in.readLine();
			
			// for 반복문을 사용해 각 격자의 칸을 순회
			for (int c = 1; c <= width; c++) {
				
				// charAt() 메서드를 사용해 해당 격자 칸의 상태를 변수 status에 할당
				char status = line.charAt(c - 1);
				
				// 해당 구역이 처음 바이러스가 살포된 지점인 경우 해당 지점을 2차원 배열 startZones에 저장
				if (status == '*') {
					startZones[idx][0] = r;
					startZones[idx][1] = c;
					idx++;
					
				// 해당 구역이 건물인 경우 해당 지점의 바이러스 전파 완료 시점을 갱신
				} else if (status == '#') {
					infected[r][c] = -1;
				}
			}
		}
		
		// safeZoneFinder() 및 write() 메서드를 사용해 안전한 구역을 출력
		out.write(safeZoneFinder());
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// safeZoneFinder() 메서드 정의
	public static String safeZoneFinder() {
		
		// 다음에 감염시킬 구역을 저장할 PriorityQueue 객체 infectList 초기화
		PriorityQueue<Zone> infectList = new PriorityQueue<>();
		
		// for 반복문을 사용해 처음 바이러스가 살포된 각 지점을 순회
		for (int[] startZone : startZones) {
			
			// offer() 메서드를 사용해 처음 바이러스가 살포된 지점을 infectList에 추가
			infectList.offer(new Zone(startZone[0], startZone[1], 0));
			
			// 처음 바이러스가 살포된 지점의 바이러스 전파 완료 시점을 배열 infected에 저장
			infected[startZone[0]][startZone[1]] = 0;
		}
		
		// while 반복문을 사용해 infectList가 빌 때까지 순회
		while (!infectList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 바이러스가 퍼진 지점을 변수 curZone에 할당
			Zone curZone = infectList.poll();
			
			// 해당 지점의 바이러스 전파 완료 시점이 바이러스가 전파되는 시간을 벗어나는 경우 반복문 탈출
			if (curZone.infectedTime > totalTime)
				break;
			
			// for 반복문을 사용해 인접한 각 지점을 순회
			for (int d = 0; d < 4; d++) {
				
				// 인접한 지점의 각 좌표를 각 변수에 할당
				int nr = curZone.row + dr[d];
				int nc = curZone.column + dc[d];
				
				// 해당 지점의 좌표가 격자의 범위를 벗어나는 경우 다음 지점을 순회
				if (nr < 1 || nr > height || nc < 1 || nc > width)
					continue;
				
				// 해당 지점에 이미 바이러스가 전파된 경우 다음 지점을 순회
				if (infected[nr][nc] != null && infected[nr][nc] >= 0)
					continue;
				
				// 해당 지점의 바이러스 전파 완료 시점을 계산해 변수 infectedTime에 할당
				int infectedTime = (infected[nr][nc] == null) ? curZone.infectedTime + 1 : curZone.infectedTime + delayTime + 1;
				
				// offer() 메서드를 사용해 해당 지점을 infectList에 추가
				infectList.offer(new Zone(nr, nc, infectedTime));
				
				// 해당 지점의 바이러스 전파 완료 시점을 배열 infected에 저장
				infected[nr][nc] = infectedTime;
			}
		}
		
		// 도시 내 안전한 구역을 저장할 StringBuilder 객체 sb 초기화
		StringBuilder sb = new StringBuilder();
		
		// for 반복문을 사용해 각 도시의 구역을 순회
		for (int r = 1; r <= height; r++) {
			for (int c = 1; c <= width; c++) {
				
				// 해당 구역이 안전한 구역인 경우 해당 구역을 sb에 추가
				if (infected[r][c] == null || infected[r][c] == -1 || infected[r][c] > totalTime)
					sb.append(r).append(" ").append(c).append("\n");
			}
		}
		
		// 도시 내 안전한 구역이 없는 경우 sb에 -1을 추가
		if (sb.length() == 0)
			sb.append(-1);
		
		// toString() 메서드를 사용해 도시 내 안전한 구역을 반환
		return sb.toString();
	}
}