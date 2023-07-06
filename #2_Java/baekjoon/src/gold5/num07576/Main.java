package gold5.num07576;

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
	
	// 토마토의 보관 상태를 저장할 2차원 배열 warehouse 초기화
	static int[][] warehouse;
	
	// 창고의 가로와 세로의 크기를 나타낼 각 변수 초기화
	static int width;
	static int height;
	
	// 차례로 탐색할 위치를 저장할 Queue 객체 visitList 초기화
	static Queue<int[]> visitList = new LinkedList<>();
	
	// 토마토의 익는 방향을 저장할 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};	
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st  = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 창고의 가로와 세로 칸 수를 각 변수에 할당
		width = Integer.parseInt(st.nextToken());
		height = Integer.parseInt(st.nextToken());
		
		// 토마토의 보관 상태를 저장할 2차원 배열 warehouse 초기화
		warehouse = new int[height][width];
		
		// 토마토가 모두 익었는지 검사할 변수 isRipe 초기화
		boolean isRipe = true;

		// for 반복문을 사용해 창고의 행을 순회
		for (int r = 0; r < height; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st  = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 창고의 열을 순회하며 배열 warehouse에 토마토의 상태 저장
			for (int c = 0; c < width; c++) {
				warehouse[r][c] = Integer.parseInt(st.nextToken());
				
				// 토마토가 하나라도 익지 않은 경우 isRipe 변수 갱신
				if (isRipe && warehouse[r][c] == 0)
					isRipe = false;
				
				// 토마토가 익은 경우 해당 위치를 visitList에 추가
				if (warehouse[r][c] == 1) {
					int[] location = {r , c};
					visitList.add(location);
				}
			}
		}
		
		// 토마토가 모두 익은 경우 0을 출력
		if (isRipe) {
			out.write(String.valueOf(0));

		// 토마토가 모두 익지 않은 경우
		} else {
	
			// timeCalculator() 메서드를 호출해 토마토가 모두 익는 최단 시간을 계산해 변수 minTime에 할당
			int minTime = timeCalculator();
			
			// valueOf() 및 write() 메서드를 사용해 토마토가 모두 익는 최단 시간을 출력
			out.write(String.valueOf(minTime));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// timeCalculator() 메서드 정의
	public static int timeCalculator() {
		
		// while 반복문을 사용해 visitList가 빌 때까지 순회
		while (!visitList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 토마토가 익은 위치를 변수 currentLoc에 할당
			int[] currentLoc = visitList.poll();
			
			// for 반복문을 사용해 현재 위치에 인접한 위치를 순회
			for (int d = 0; d < 4; d++) {
				
				// 인접한 위치를 각 변수에 할당
				int nr = currentLoc[0] + dr[d];
				int nc = currentLoc[1] + dc[d];
				
				// 인접한 위치가 배열을 벗어나지 않고 익지 않은 경우
				if (nr >= 0 && nr < height && nc >= 0 && nc < width && warehouse[nr][nc] == 0) {
					
					// 해당 위치를 visitList에 추가
					int[] location = {nr , nc};
					visitList.add(location);
					
					// 익은 날짜를 갱신
					warehouse[nr][nc] = warehouse[currentLoc[0]][currentLoc[1]] + 1;
				}
			}
		}
		
		// 토마토가 익는 데 필요한 시간을 저장할 변수 minTime 초기화
		int minTime = 0;
		
		// for 반복문을 사용해 토마토 창고의 행과 열을 순회
		for (int r = 0; r < height; r++) {
			for (int c = 0; c < width; c++) {
				
				// 익지 않은 토마토가 있는 경우 -1을 반환
				if (warehouse[r][c] == 0)
					return -1;
				
				// max() 메서드를 사용해 토마토가 익는 데 필요한 시간을 갱신
				minTime = Math.max(warehouse[r][c], minTime);
			}
		}
		
		// 토마토가 익는 데 필요한 시간을 반환
		return minTime - 1;
	}
}