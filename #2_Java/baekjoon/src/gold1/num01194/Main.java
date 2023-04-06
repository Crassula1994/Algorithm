package gold1.num01194;

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
	
	// 미로의 크기를 저장할 각 변수 초기화
	static int height;
	static int width;
	
	// 미로의 상태를 저장할 2차원 배열 maze 초기화
	static char[][] maze;
	
	// 해당 위치의 방문 여부를 저장할 3차원 배열 visited 초기화
	static Integer[][][] visited;
	
	// 인접한 위치를 저장할 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// Location 클래스 정의
	public static class Location {
		
		// 해당 위치의 행과 열, 열쇠의 보유 상태을 나타낼 각 변수 초기화
		int row;
		int col;
		int hasKey = 0;
		
		// 매개변수를 입력 받은 생성자 정의
		public Location(int row, int col) {
			this.row = row;
			this.col = col;
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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 미로의 크기를 각 변수에 할당
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		
		// 미로의 상태를 저장할 2차원 배열 maze 초기화
		maze = new char[height][width];
		
		// 해당 위치의 방문 여부를 저장할 3차원 배열 visited 초기화
		visited = new Integer[height][width][64];
		
		// 민식이의 현재 위치를 저장할 변수 startLoc 초기화
		Location startLoc = new Location(-1, -1);
		
		// for 반복문을 사용해 배열 maze의 각 행을 순회
		for (int r = 0; r < height; r++) {
			
			// readLine() 메서드를 사용해 입력 받은 미로의 상태를 변수 line에 할당
			String line = in.readLine();
			
			// for 반복문을 사용해 배열 maze의 각 열을 순회
			for (int c = 0; c < width; c++) {
				
				// charAt() 메서드를 사용해 입력 받은 미로의 상태를 배열 maze에 저장
				maze[r][c] = line.charAt(c);
				
				// 해당 위치가 민식이의 현재 위치인 경우 변수 startLoc에 할당
				if (maze[r][c] == '0')
					startLoc = new Location(r, c);
			}
		}
		
		// escapeRouteFinder() 메서드를 호출해 미로를 탈출하기 위한 이동 횟수의 최솟값을 변수 minDistance에 할당
		int minDistance = escapeRouteFinder(startLoc);
		
		// valueOf() 및 write() 메서드를 사용해 미로를 탈출하기 위한 이동 횟수의 최솟값을 출력
		out.write(String.valueOf(minDistance));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// escapeRouteFinder() 메서드 정의
	public static int escapeRouteFinder(Location startLoc) {
		
		// 다음에 방문할 위치를 저장할 Queue 객체 visitList 초기화
		Queue<Location> visitList = new LinkedList<>();
		
		// offer() 메서드를 사용해 시작 위치를 visitList에 추가 및 방문 처리
		visitList.offer(startLoc);
		visited[startLoc.row][startLoc.col][startLoc.hasKey] = 0;
		
		// while 반복문을 사용해 visitList가 빌 때까지 순회
		while (!visitList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 방문 중인 위치를 변수 currentLoc에 할당
			Location currentLoc = visitList.poll();
			
			// 해당 위치가 출구인 경우 해당 위치까지의 거리를 반환
			if (maze[currentLoc.row][currentLoc.col] == '1')
				return visited[currentLoc.row][currentLoc.col][currentLoc.hasKey];
			
			// for 반복문을 사용해 해당 위치의 인접한 위치를 탐색
			for (int d = 0; d < 4; d++) {
				
				// 새로운 위치를 각 변수에 할당
				int nr = currentLoc.row + dr[d];
				int nc = currentLoc.col + dc[d];
				
				// 해당 위치가 미로의 범위를 벗어나거나, 방문한 장소거나, 벽인 경우 다음 위치를 순회
				if (nr < 0 || nr >= height || nc < 0 || nc >= width || visited[nr][nc][currentLoc.hasKey] != null || maze[nr][nc] == '#')
					continue;
				
				// 현재 위치를 변수 nextLoc에 할당
				Location nextLoc = new Location(nr, nc);
				nextLoc.hasKey = currentLoc.hasKey;
				
				// 해당 위치에 열쇠가 있는 경우
				if (maze[nr][nc] >= 97) {
					
					// 해당 열쇠를 주워서 열쇠의 보유 상황을 갱신
					nextLoc.hasKey |= 1 << maze[nr][nc] - 'a';
					
					// offer() 메서드를 사용해 시작 위치를 visitList에 추가 및 방문 처리
					visitList.offer(nextLoc);
					visited[nr][nc][nextLoc.hasKey] = visited[currentLoc.row][currentLoc.col][currentLoc.hasKey] + 1;
					
				// 해당 위치에 문이 있고 해당 열쇠를 보유한 경우
				} else if (maze[nr][nc] >= 65 && ((nextLoc.hasKey & (1 << maze[nr][nc] - 'A')) != 0)) {
					
					// offer() 메서드를 사용해 시작 위치를 visitList에 추가 및 방문 처리
					visitList.offer(nextLoc);
					visited[nr][nc][nextLoc.hasKey] = visited[currentLoc.row][currentLoc.col][currentLoc.hasKey] + 1;
				
				// 해당 위치가 빈 칸이거나 숫자인 경우
				} else if (maze[nr][nc] < 65) {
					
					// offer() 메서드를 사용해 시작 위치를 visitList에 추가 및 방문 처리
					visitList.offer(nextLoc);
					visited[nr][nc][nextLoc.hasKey] = visited[currentLoc.row][currentLoc.col][currentLoc.hasKey] + 1;
				}
			}
		}
		
		// 미로의 출구에 도달하지 못한 경우 -1 반환
		return -1;
	}
}