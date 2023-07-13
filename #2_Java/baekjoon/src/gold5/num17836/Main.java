package gold5.num17836;

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

	// 성의 크기, 공주에게 걸린 저주의 제한 시간을 저장할 각 변수 초기화
	static int height;
	static int width;
	static int limit;

	// 이동할 수 있는 인접 위치를 나타낼 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	// 성의 상태를 저장할 2차원 배열 castle 초기화
	static int[][] castle;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());

		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 성의 크기, 공주에게 걸린 저주의 제한 시간을 각 변수에 할당
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		limit = Integer.parseInt(st.nextToken());

		// 성의 상태를 저장할 2차원 배열 castle 초기화
		castle = new int[height][width];
		
		// for 반복문을 사용해 배열 castle의 각 행을 순회
		for (int r = 0; r < height; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 입력 받은 성의 상태를 2차원 배열 castle에 저장
			for (int c = 0; c < width; c++)
				castle[r][c] = Integer.parseInt(st.nextToken());
		}
		
		// timeCalculator() 메서드를 호출해 공주에게 도달할 수 있는 최단 시간을 계산하고 변수 minTime에 할당
		int minTime = timeCalculator(0, 0);

		// 용사가 공주를 시간 내에 구출할 수 없는 경우 'Fail' 출력
		if (minTime > limit || minTime == -1) {
			out.write("Fail");

		// 용사가 공주를 시간 내에 도달할 수 있는 경우 도달할 수 있는 최단 시간을 출력
		} else {
			out.write(String.valueOf(minTime));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// timeCalculator() 메서드 정의
	public static int timeCalculator(int startRow, int startCol) {

		// 해당 위치의 소요 시간을 저장할 3차원 배열 time 초기화
		Integer[][][] time = new Integer[2][height][width];

		// 다음에 소요 시간을 계산할 위치를 저장할 Queue 객체 calculateList 초기화
		Queue<int[]> calculateList = new LinkedList<>();

		// 시작 위치를 calculateList에 추가 및 소요 시간 계산 처리
		calculateList.offer(new int[] {startRow, startCol, 0});
		time[0][startRow][startCol] = 0;

		// while 반복문을 사용해 calculateList가 빌 때까지 순회
		while (!calculateList.isEmpty()) {

			// poll() 메서드를 사용해 현재 위치를 배열 currentLoc에 할당
			int[] currentLoc = calculateList.poll();

			// 해당 위치가 공주의 위치인 경우 해당 거리까지의 최단 거리를 반환
			if (currentLoc[0] == height - 1 && currentLoc[1] == width - 1)
				return time[currentLoc[2]][currentLoc[0]][currentLoc[1]];

			// for 반복문을 사용해 인접한 위치를 순회
			for (int d = 0; d < 4; d++) {

				// 새로운 위치를 각 변수에 할당
				int nr = currentLoc[0] + dr[d];
				int nc = currentLoc[1] + dc[d];

				// 해당 위치가 성의 범위를 벗어난 경우 다음 위치 순회
				if (nr < 0 || nr >= height || nc < 0 || nc >= width)
					continue;

				// 그람을 보유하지 않고 해당 위치가 벽인 경우 다음 위치 순회
				if (currentLoc[2] == 0 && castle[nr][nc] == 1)
					continue;

				// 해당 위치를 이미 방문한 경우 다음 위치 순회
				if (time[currentLoc[2]][nr][nc] != null)
					continue;

				// 해당 위치에 그람이 존재하는 경우 calculateList에 추가 및 소요 시간 계산 처리
				if (castle[nr][nc] == 2) {
					calculateList.offer(new int[] {nr, nc, 1});
					time[1][nr][nc] = time[currentLoc[2]][currentLoc[0]][currentLoc[1]] + 1;

				// 나머지 경우 calculateList에 추가 및 소요 시간 계산 처리
				} else {
					calculateList.offer(new int[] {nr, nc, currentLoc[2]});
					time[currentLoc[2]][nr][nc] = time[currentLoc[2]][currentLoc[0]][currentLoc[1]] + 1;
				}
			}
		}

		// 공주에게 도달할 수 없는 경우 -1 반환
		return -1;
	}
}