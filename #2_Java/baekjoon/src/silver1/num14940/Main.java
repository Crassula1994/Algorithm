package silver1.num14940;

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

	// 지도의 크기를 저장할 각 변수 초기화
	static int height;
	static int width;
	
	// 인접한 위치를 나타내는 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// 지도의 상태, 목표 지점까지의 거리를 저장할 각 2차원 배열 초기화
	static int[][] map;
	static Integer[][] distances;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 지도의 크기를 각 변수에 할당
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		
		// 지도의 상태, 목표 지점까지의 거리를 저장할 각 2차원 배열 초기화
		map = new int[height][width];
		distances = new Integer[height][width];
		
		// 목표 지점의 위치를 저장할 각 변수 초기화
		int startRow = -1;
		int startCol = -1;
		
		// for 반복문을 사용해 2차원 배열 map의 각 행을 순회
		for (int r = 0; r < height; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 2차원 배열 map의 각 열을 순회
			for (int c = 0; c < width; c++) {
				
				// nextToken() 및 parseInt() 메서드를 사용해 지도의 상태를 저장
				map[r][c] = Integer.parseInt(st.nextToken());
				
				// 해당 위치가 목표 지점인 경우 목표 지점의 위치를 나타내는 변수 갱신
				if (map[r][c] == 2) {
					startRow = r;
					startCol = c;
				}
			}
		}
		
		// distanceCalculator() 메서드를 사용해 모든 지점으로부터 목표 지점까지의 거리를 계산
		distanceCalculator(startRow, startCol);
		
		// for 반복문을 사용해 2차원 배열 distances의 각 행과 열을 순회
		for (int r = 0; r < height; r++) {
			for (int c = 0; c < width; c++) {
				
				// 갈 수 없는 땅인 위치의 경우 0을 출력
				if (distances[r][c] == null && map[r][c] == 0) {
					out.write(0 + " ");
					
				// 갈 수 있는 땅 부분 중에서 도달할 수 없는 위치의 경우 -1을 출력
				} else if (distances[r][c] == null && map[r][c] == 1) {
					out.write(-1 + " ");
					
				// 갈 수 있는 땅의 위치인 경우 거리를 출력
				} else {
					out.write(distances[r][c] + " ");
				}
			}
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// distanceCalculator() 메서드 정의
	public static void distanceCalculator(int startRow, int startCol) {
		
		// 다음에 계산할 위치를 저장할 Queue 객체 calculateList 초기화
		Queue<int[]> calculateList = new LinkedList<>();
		
		// offer() 메서드를 사용해 시작 위치를 calculateList에 추가 및 계산 처리
		calculateList.offer(new int[] {startRow, startCol});
		distances[startRow][startCol] = 0;
		
		// while 반복문을 사용해 calculateList가 빌 때까지 순회
		while (!calculateList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 계산 중인 위치를 배열 currentLoc에 할당
			int[] currentLoc = calculateList.poll();
			
			// for 반복문을 사용해 인접한 위치를 순회
			for (int d = 0; d < 4; d++) {
				
				// 인접한 위치를 계산해 각 변수에 할당
				int nr = currentLoc[0] + dr[d];
				int nc = currentLoc[1] + dc[d];
				
				// 해당 위치가 지도를 벗어난 경우 다음 위치를 순회
				if (nr < 0 || nr >= height || nc < 0 || nc >= width)
					continue;
				
				// 해당 위치를 계산했거나 갈 수 없는 땅인 경우 다음 위치를 순회
				if (distances[nr][nc] != null || map[nr][nc] == 0)
					continue;
				
				// offer() 메서드를 사용해 해당 위치를 calculateList에 추가 및 계산 처리
				calculateList.offer(new int[] {nr, nc});
				distances[nr][nc] = distances[currentLoc[0]][currentLoc[1]] + 1;
			}
		}
	}
}