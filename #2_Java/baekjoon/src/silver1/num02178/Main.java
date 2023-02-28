package silver1.num02178;

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
	
	// 미로의 구조를 저장할 2차원 배열 maze 초기화
	static int[][] maze;
	
	// 미로의 크기를 저장할 각 변수 초기화
	static int height;
	static int width;
	
	// 이동할 위치를 검사할 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// 이동할 위치를 담을 Queue 객체 moved 초기화
	static Queue<int[]> moved = new LinkedList<>();
	
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
		
		// 미로의 구조를 저장할 2차원 배열 maze 초기화
		maze = new int[height][width];
		
		// for 반복문을 사용해 배열 maze의 각 행을 순회
		for (int r = 0; r < height; r++) {
			
			// readLine() 메서드를 사용해 입력 받은 미로의 각 행을 변수 line에 할당
			String line = in.readLine();
			
			// for 반복문을 사용해 배열 maze의 각 열을 순회하며 주어진 값을 배열 maze에 저장
			for (int c = 0; c < width; c++)
				maze[r][c] = line.charAt(c) - '0';
		}
		
		// pathFinder() 메서드를 호출해 미로를 탈출할 수 있는 최단 거리를 변수 minDistance에 할당
		int minDistance = pathFinder(0, 0);

		// valueOf() 및 write() 메서드를 사용해 미로를 탈출할 수 있는 최단 거리를 출력
		out.write(String.valueOf(minDistance));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// pathFinder() 메서드 정의
	public static int pathFinder(int startRow, int startCol) {
		
		// offer() 메서드를 사용해 시작 위치를 배열 startLoc에 저장 후 moved에 추가
		int[] startLoc = {startRow, startCol};
		moved.offer(startLoc);
		
		// while 반복문을 사용해 moved의 모든 위치를 이동할 때까지 순회
		while (!moved.isEmpty()) {
			
			// poll() 메서드를 사용해 배열 currentLoc에 위치를 할당
			int[] currentLoc = moved.poll();
			
			// for 반복문을 사용해 각 델타 배열을 순회
			for (int d = 0; d < 4; d++) {
				
				// 새로운 위치를 각 변수에 할당
				int nr = currentLoc[0] + dr[d];
				int nc = currentLoc[1] + dc[d];
				
				// 새로운 위치가 미로의 범위를 벗어나지 않고, 방문한 적이 없는 경우
				if (nr >= 0 && nr < height && nc >= 0 && nc < width && maze[nr][nc] == 1) {
					
					// 출발점으로부터의 최단 거리를 갱신
					maze[nr][nc] = maze[currentLoc[0]][currentLoc[1]] + 1;
					
					// offer() 메서드를 사용해 해당 위치를 moved에 추가
					int[] nextLoc = {nr, nc};
					moved.offer(nextLoc);
				}
			}
		}
		
		// 도착 위치까지의 최단 거리를 반환
		return maze[height - 1][width - 1];
	}
}