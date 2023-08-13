package gold5.num14503;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 로봇 청소기가 바라보는 방향을 나타낼 델타 배열 초기화
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	// ----------------------------------------------------------------------------------------------------

	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 방의 크기를 각 변수에 할당
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		
		// 방의 상태를 저장할 2차원 배열 room 초기화
		int[][] room = new int[height][width];
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 로봇 청소기의 좌표 및 바라보는 방향을 각 변수에 할당
		int curRow = Integer.parseInt(st.nextToken());
		int curCol = Integer.parseInt(st.nextToken());
		int curDir = Integer.parseInt(st.nextToken());
		
		// for 반복문을 사용해 입력 받은 방의 각 줄을 순회
		for (int r = 0; r < height; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 입력 받은 방의 상태를 2차원 배열 room에 저장
			for (int c = 0; c < width; c++)
				room[r][c] = Integer.parseInt(st.nextToken());
		}
		
		// 로봇 청소기가 청소하는 칸의 개수를 저장할 변수 count 초기화
		int count = 0;
		
		// while 반복문을 사용해 청소기가 멈출 때까지 순회
		while (true) {
			
			// 현재 칸이 청소되지 않은 경우 현재 칸을 청소
			if (room[curRow][curCol] == 0) {
				room[curRow][curCol] = 2;
				count++;
			}
			
			// 주변 네 칸 중 청소되지 않는 빈 칸이 있는지 여부를 나타낼 변수 초기화
			boolean canClean = false;
			
			// for 반복문을 사용해 현재 칸의 주변 네 칸을 순회
			for (int d = 0; d < 4; d++) {
				
				// 로봇 청소기의 방향을 반시계 방향으로 90도 전환
				curDir = (curDir == 0) ? 3 : curDir - 1;
				
				// 주변 네 칸의 좌표를 각 변수에 할당
				int nr = curRow + dr[curDir];
				int nc = curCol + dc[curDir];
				
				// 해당 위치가 청소되지 않은 빈 칸인 경우 변수 갱신 후 반복문 탈출
				if (room[nr][nc] == 0) {
					curRow = nr;
					curCol = nc;
					canClean = true;
					break;
				}
			}
			
			// 주변 네 칸 중 청소되지 않는 빈 칸이 없는 경우
			if (!canClean) {
				
				// 바라보는 방향의 뒤쪽 칸을 나타낼 각 변수 초기화
				int nr = curRow + dr[(curDir + 2) % 4];
				int nc = curCol + dc[(curDir + 2) % 4];
				
				// 바라보는 방향의 뒤쪽 칸이 벽인 경우 반복문 탈출
				if (room[nr][nc] == 1)
					break;
				
				// 현재 로봇 청소기의 위치를 갱신
				curRow = nr;
				curCol = nc;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 로봇 청소기가 청소하는 칸의 개수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}