package gold3.num22944;

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
	
	// 격자의 크기, 현재 체력, 우산의 내구도를 저장할 각 변수 초기화
	static int size;
	static int health;
	static int durability;
	
	// 인접한 위치를 나타낼 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// 격자의 정보, 이동 여부를 저장할 각 2차원 배열 초기화
	static char[][] grid;
	static Integer[][] moved;
	
	// 다음에 이동할 위치를 저장할 Queue 객체 moveList 초기화
	static Queue<Location> moveList = new LinkedList<>(); 
	
	// Location 클래스 정의
	public static class Location {
		
		// 해당 위치에서의 좌표, 체력, 내구도, 이동 횟수를 저장할 각 변수 초기화
		int row;
		int column;
		int health;
		int shield;
		int count;
		
		// 인자를 입력 받는 생성자 정의
		public Location(int row, int column, int health, int shield, int count) {
			this.row = row;
			this.column = column;
			this.health = health;
			this.shield = shield;
			this.count = count;
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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 격자의 크기, 현재 체력, 우산의 내구도를 각 변수에 할당
		size = Integer.parseInt(st.nextToken());
		health = Integer.parseInt(st.nextToken());
		durability = Integer.parseInt(st.nextToken());
		
		// 격자의 정보, 이동 여부를 저장할 각 2차원 배열 초기화
		grid = new char[size][size];
		moved = new Integer[size][size];
		
		// for 반복문을 사용해 격자의 각 행의 정보를 순회
		for (int r = 0; r < size; r++) {
			
			// readLine() 메서드를 사용해 입력 받은 행의 정보를 변수 line에 할당
			String line = in.readLine();
			
			// for 반복문을 사용해 격자의 각 열의 정보를 순회
			for (int c = 0; c < size; c++) {
				
				// charAt() 메서드를 사용해 해당 열의 정보를 2차원 배열 grid에 저장
				grid[r][c] = line.charAt(c);
				
				// 해당 위치가 시작 위치인 경우 moveList에 추가 및 방문 처리
				if (grid[r][c] == 'S') {
					moveList.offer(new Location(r, c, health, 0, 0));
					moved[r][c] = health;
				}
			}
		}
		
		// pathFinder() 메서드를 호출해 안전지대로 이동할 때의 최소 이동 횟수를 변수 minCnt에 할당
		int minCnt = pathFinder();
		
		// valueOf() 및 write() 메서드를 사용해 안전지대로 이동할 때의 최소 이동 횟수를 출력
		out.write(String.valueOf(minCnt));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// pathFinder() 메서드 정의
	public static int pathFinder() {

		// while 반복문을 사용해 moveList가 빌 때까지 순회
		while (!moveList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재의 위치를 변수 currentLoc에 할당
			Location currentLoc = moveList.poll();
			
			// 현재 위치가 안전지대인 경우 최소 이동 횟수를 반환
			if (grid[currentLoc.row][currentLoc.column] == 'E')
				return currentLoc.count;
			
			// 해당 위치에서의 체력이 0인 경우 다음 위치를 순회
			if (currentLoc.health == 0)
				continue;
			
			// for 반복문을 사용해 각 인접한 위치를 순회
			for (int d = 0; d < 4; d++) {
				
				// 인접한 위치를 각 변수에 할당
				int nr = currentLoc.row + dr[d];
				int nc = currentLoc.column + dc[d];
				
				// 해당 위치가 범위를 벗어난 경우 다음 위치를 순회
				if (nr < 0 || nr >= size || nc < 0 || nc >= size)
					continue;
				
				// 해당 위치에서의 체력과 우산의 내구도를 나타낼 각 변수 초기화
				int nextHealth = currentLoc.health;
				int nextShield = (grid[nr][nc] == 'U') ? durability : currentLoc.shield;
				
				// 죽음의 비에 따른 체력 또는 우산의 내구도 감소 처리
				nextHealth = (nextShield > 0) ? nextHealth : --nextHealth;
				nextShield = (nextShield > 0) ? --nextShield : nextShield;
				
				// 해당 위치를 이미 방문했던 경우 다음 위치를 순회
				if (moved[nr][nc] != null && moved[nr][nc] >= nextHealth + nextShield)
					continue;
				
				// offer() 메서드를 사용해 다음 위치를 moveList에 추가 및 방문 처리
				moveList.offer(new Location(nr, nc, nextHealth, nextShield, currentLoc.count + 1));
				moved[nr][nc] = nextHealth + nextShield;
			}
		}

		// 안전지대에 도달할 수 없는 경우 -1 반환
		return -1;
	}
}