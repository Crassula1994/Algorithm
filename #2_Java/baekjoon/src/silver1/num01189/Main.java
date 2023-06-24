package silver1.num01189;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 맵의 크기, 집까지의 거리, 해당 거리까지의 가짓수를 나타낼 각 변수 초기화
	static int row;
	static int column;
	static int distance;
	static int count = 0;
	
	// 인접한 위치를 나타내는 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// 입력 받은 맵의 상태 및 방문 여부를 저장할 각 2차원 배열 초기화
	static char[][] map;
	static boolean[][] visited;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 맵의 크기 및 거리를 각 변수에 할당
		row = Integer.parseInt(st.nextToken());
		column = Integer.parseInt(st.nextToken());
		distance = Integer.parseInt(st.nextToken());
		
		// 입력 받은 맵의 상태 및 방문 여부를 저장할 각 2차원 배열 초기화
		map = new char[row][column];
		visited = new boolean[row][column];
		
		// for 반복문을 사용해 맵의 각 행을 순회
		for (int r = 0; r < row; r++) {
			
			// readLine() 메서드를 사용해 입력 받은 맵의 행 상태를 변수 line에 할당
			String line = in.readLine();
			
			// for 반복문을 사용해 맵의 상태를 배열 map에 저장
			for (int c = 0; c < column; c++)
				map[r][c] = line.charAt(c);
		}
		
		// pathFinder() 메서드를 호출해 특정 거리의 가짓수를 갱신
		pathFinder(row - 1, 0, 1);
		
		// valueOf() 및 write() 메서드를 사용해 특정 거리의 가짓수를 출력
		out.write(String.valueOf(count));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// pathFinder() 메서드 정의
	public static void pathFinder(int currentRow, int currentCol, int currentDist) {
		
		// 현재 위치 방문 처리
		visited[currentRow][currentCol] = true;
		
		// 현재의 거리가 목표로 하는 거리인 경우
		if (currentDist == distance) {
			
			// 해당 위치가 집인 경우 특정 거리의 가짓수 갱신
			if (currentRow == 0 && currentCol == column - 1)
				count++;
		
		// 현재의 거리가 목표로 하는 거리가 아닌 경우
		} else {
			
			// for 반복문을 사용해 인접한 각 위치를 순회
			for (int d = 0; d < 4; d++) {
				
				// 인접한 위치를 각 변수에 할당
				int nr = currentRow + dr[d];
				int nc = currentCol + dc[d];
				
				// 해당 위치가 범위를 벗어난 경우 다음 위치를 순회
				if (nr < 0 || nr >= row || nc < 0 || nc >= column)
					continue;
				
				// 해당 위치가 가지 못하는 곳이거나 이미 방문한 경우 다음 위치를 순회
				if (map[nr][nc] == 'T' || visited[nr][nc])
					continue;
				
				// pathFinder() 메서드를 재귀 호출
				pathFinder(nr, nc, currentDist + 1);
			}
		}
		
		// 현재 위치 방문 여부 원상복구 처리
		visited[currentRow][currentCol] = false;
	}
}