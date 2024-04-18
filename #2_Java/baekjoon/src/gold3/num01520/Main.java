package gold3.num01520;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 지도의 크기를 저장할 각 변수 초기화
	static int height;
	static int width;
	
	// 인접한 각 지점을 나타낼 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// 각 지점의 높이 및 해당 위치까지 이동하는 경로의 개수를 저장할 각 2차원 배열 초기화
	static int[][] map;
	static int[][] counts;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 지도의 크기를 각 변수에 할당
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		
		// 각 지점의 높이 및 해당 지점까지 이동하는 경로의 개수를 저장할 각 2차원 배열 초기화
		map = new int[height][width];
		counts = new int[height][width];
		
		// for 반복문을 사용해 지도의 각 행을 순회
		for (int r = 0; r < height; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 각 지점을 순회
			for (int c = 0; c < width; c++) {
				
				// nextToken() 및 parseInt() 메서드를 사용해 해당 지점의 높이를 2차원 배열 map에 저장
				map[r][c] = Integer.parseInt(st.nextToken());
				
				// 해당 지점까지 이동하는 경로의 수를 초기화
				counts[r][c] = -1;
			}
		}
		
		// pathCounter() 메서드를 호출해 이동 가능한 경로의 수를 변수 totalCnt에 할당
		int totalCnt = pathCounter(0, 0);
		
		// valueOf() 및 write() 메서드를 사용해 이동 가능한 경로의 수를 출력
		out.write(String.valueOf(totalCnt));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// pathCounter() 메서드 정의
	public static int pathCounter(int curRow, int curCol) {
		
		// 해당 위치가 제일 오른쪽 아래 칸인 경우 1을 반환
		if (curRow == height - 1 && curCol == width - 1)
			return 1;
		
		// 해당 위치를 이미 확인한 경우 저장된 경로의 수를 반환
		if (counts[curRow][curCol] != -1)
			return counts[curRow][curCol];
		
		// 해당 위치의 방문 여부를 갱신
		counts[curRow][curCol] = 0;
			
		// for 반복문을 사용해 인접한 각 위치를 순회
		for (int d = 0; d < 4; d++) {
			
			// 인접한 위치를 각 변수에 할당
			int nr = curRow + dr[d];
			int nc = curCol + dc[d];
			
			// 해당 위치가 지도의 범위를 벗어난 경우 다음 위치를 순회
			if (nr < 0 || nr >= height || nc < 0 || nc >= width)
				continue;
			
			// 다음 위치가 해당 위치보다 높이가 더 높거나 같은 경우 다음 위치를 순회
			if (map[nr][nc] >= map[curRow][curCol])
				continue;
			
			// pathCounter() 메서드를 호출해 해당 지점까지 이동하는 경로의 수를 갱신
			counts[curRow][curCol] += pathCounter(nr, nc);
		}
		
		// 해당 지점까지 이동하는 경로의 수를 반환
		return counts[curRow][curCol];
	}
}