package gold3.num04179;

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
	
	// 미로의 행의 개수, 열의 개수를 저장할 각 변수 초기화
	static int row;
	static int column;
	
	// 인접한 위치를 나타내는 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// 불이 난 공간을 저장할 Queue 객체 fireSpace 초기화
	static Queue<int[]> fireSpace = new LinkedList<>();
	
	// 미로의 상태를 저장할 2차원 배열 maze 초기화
	static char[][] maze;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 미로의 행의 개수 및 열의 개수를 각 변수에 할당
		row = Integer.parseInt(st.nextToken());
		column = Integer.parseInt(st.nextToken());
		
		// 미로의 상태를 저장할 2차원 배열 maze 초기화
		maze = new char[row][column];
		
		// 지훈이의 초기 위치를 나타낼 각 변수 초기화
		int startRow = -1;
		int startCol = -1;
		
		// for 반복문을 사용해 미로의 각 행을 순회
		for (int r = 0; r < row; r++) {
			
			// readLine() 메서드를 사용해 입력 받은 미로의 행의 상태를 변수 line에 할당
			String line = in.readLine();
			
			// for 반복문을 사용해 미로의 각 열을 순회
			for (int c = 0; c < column; c++) {
				
				// charAt() 메서드를 사용해 해당 위치의 정보를 배열 maze에 저장
				maze[r][c] = line.charAt(c);
				
				// 해당 위치가 지훈이의 초기 위치인 경우 각 변수 갱신
				if (maze[r][c] == 'J') {
					startRow = r;
					startCol = c;
					
				// 해당 위치가 불이 난 공간인 경우 fireSpace에 추가
				} else if (maze[r][c] == 'F') {
					fireSpace.offer(new int[] {r, c});
				}
			}
		}
		
		// pathFinder() 메서드를 호출해 지훈이가 탈출할 수 있는 가장 빠른 시간을 변수 minTime에 할당
		int minTime = pathFinder(startRow, startCol);
		
		// 지훈이가 미로를 탈출할 수 없는 경우 'IMPOSSIBLE' 출력
		if (minTime == -1) {
			out.write("IMPOSSIBLE");
		
		// 지훈이가 미로를 탈출할 수 있는 경우 탈출할 수 있는 가장 빠른 시간을 출력
		} else {
			out.write(String.valueOf(minTime + 1));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// pathFinder() 메서드 정의
	public static int pathFinder(int startRow, int startCol) {
		
		// 각 위치까지의 이동 시간을 저장할 2차원 배열 escapeTime 초기화
		Integer[][] escapeTime = new Integer[row][column];
		
		// 지훈이가 이동할 다음 위치를 저장할 Queue 객체 pathList 초기화
		Queue<int[]> pathList = new LinkedList<>();
		
		// offer() 메서드를 사용해 지훈이의 초기 위치를 pathList에 추가 및 방문 처리
		pathList.offer(new int[] {startRow, startCol});
		escapeTime[startRow][startCol] = 0;
		
		// while 반복문을 사용해 pathList가 빌 때까지 순회
		while (!pathList.isEmpty()) {
			
			// size() 메서드를 사용해 도달할 불의 위치의 개수, 지훈이가 이동할 위치의 개수를 각 변수에 할당
			int fireCnt = fireSpace.size();
			int moveCnt = pathList.size();
			
			// for 반복문을 사용해 각 불의 위치를 순회
			for (int f = 0; f < fireCnt; f++) {
				
				// poll() 메서드를 사용해 현재 불이 난 위치를 배열 currentLoc에 할당
				int[] currentLoc = fireSpace.poll();
				
				// for 반복문을 사용해 인접한 위치를 순회
				for (int d = 0; d < 4; d++) {
					
					// 인접한 위치를 각 변수에 할당
					int nr = currentLoc[0] + dr[d];
					int nc = currentLoc[1] + dc[d];
					
					// 인접한 위치가 미로의 범위를 벗어난 경우 다음 위치를 순회
					if (nr < 0 || nr >= row || nc < 0 || nc >= column)
						continue;
					
					// 인접한 위치가 벽이거나 이미 불이 난 곳인 경우 다음 위치를 순회
					if (maze[nr][nc] == '#' || maze[nr][nc] == 'F')
						continue;
					
					// offer() 메서드를 사용해 해당 위치를 fireSpace에 추가 및 불 확산 처리
					fireSpace.offer(new int[] {nr, nc});
					maze[nr][nc] = 'F';
				}
			}
			
			// for 반복문을 사용해 지훈이가 이동할 위치를 순회
			for (int m = 0; m < moveCnt; m++) {
				
				// poll() 메서드를 사용해 현재 지훈이의 위치를 배열 currentLoc에 할당
				int[] currentLoc = pathList.poll();
				
				// 해당 위치가 탈출할 수 있는 위치인 경우 해당 위치까지의 소요 시간을 반환
				if (currentLoc[0] == 0 || currentLoc[0] == row - 1 || currentLoc[1] == 0 || currentLoc[1] == column - 1)
					return escapeTime[currentLoc[0]][currentLoc[1]];
				
				// for 반복문을 사용해 인접한 위치를 순회
				for (int d = 0; d < 4; d++) {
					
					// 인접한 위치를 각 변수에 할당
					int nr = currentLoc[0] + dr[d];
					int nc = currentLoc[1] + dc[d];
					
					// 인접한 위치가 미로의 범위를 벗어난 경우 다음 위치를 순회
					if (nr < 0 || nr >= row || nc < 0 || nc >= column)
						continue;
					
					// 인접한 위치가 벽이거나 이미 불이 났거나 방문한 곳인 경우 다음 위치를 순회
					if (maze[nr][nc] == '#' || maze[nr][nc] == 'F' || escapeTime[nr][nc] != null)
						continue;
					
					// offer() 메서드를 사용해 해당 위치를 pathList에 추가 및 방문 처리
					pathList.offer(new int[] {nr, nc});
					escapeTime[nr][nc] = escapeTime[currentLoc[0]][currentLoc[1]] + 1;
				}
			}
		}
		
		// 지훈이가 미로를 탈출 할 수 없는 경우 -1 반환
		return -1;
	}
}