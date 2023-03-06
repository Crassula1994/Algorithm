package silver2.num04963;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 지도를 나타낼 2차원 배열 map 초기화
	static int[][] map;
	
	// 지도의 너비 및 높이를 나타내는 각 변수 초기화
	static int width;
	static int height;
	
	// 인접한 섬을 탐색할 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] dc = {0, 0, -1, 1, -1, 1, 1, -1};
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// while 반복문을 사용해 모든 테스트 케이스를 순회
		while (true) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 지도의 너비 및 높이를 각 변수에 할당
			width = Integer.parseInt(st.nextToken());
			height = Integer.parseInt(st.nextToken());
			
			// 0과 0을 입력 받은 경우 반복문 탈출
			if (width == 0 && height ==0)
				break;
			
			// 지도를 나타낼 2차원 배열 map 초기화
			map = new int[height][width];
			
			// for 반복문을 사용해 배열 map의 각 행을 순회
			for (int r = 0; r < height; r++ ) {

				// StringTokenizer 객체를 불러와 변수 st에 재할당
				st = new StringTokenizer(in.readLine());
				
				// for 반복문을 사용해 배열 map의 각 열을 순회하며 지도를 배열 map에 저장
				for (int c = 0; c < width; c++)
					map[r][c] = Integer.parseInt(st.nextToken());
			}
			
			// 섬의 개수를 저장할 변수 islandCnt 초기화
			int islandCnt = 0;
			
			// for 반복문을 사용해 배열 map의 각 행과 열을 순회
			for (int r = 0; r < height; r++ ) {
				for (int c = 0; c < width; c++) {
					if (map[r][c] == 1) {
						
						// 섬의 개수 갱신
						islandCnt++;
						
						// islandFinder() 메서드를 호출해 연결된 섬을 탐색
						islandFinder(r, c);
					}
				}
			}
			
			// write() 메서드를 사용해 섬의 개수를 출력
			out.write(islandCnt + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// islandFinder() 메서드 정의
	public static void islandFinder(int startRow, int startCol) {
		
		// 처음 위치 방문 처리
		map[startRow][startCol] = 0;
		
		// for 반복문을 사용해 델타 배열을 순회
		for (int d = 0; d < 8; d++) {
			
			// 새로운 위치를 각 변수에 할당
			int nr = startRow + dr[d];
			int nc = startCol + dc[d];
			
			// 새로운 위치가 지도의 범위를 벗어나지 않고 방문하지 않은 섬인 경우 islandFinder() 메서드 재귀 호출
			if (nr >= 0 && nr < height && nc >= 0 && nc < width && map[nr][nc] == 1)
				islandFinder(nr, nc);
		}
	}
}