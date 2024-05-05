package silver2.num17086;

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
	
	// 공간의 크기, 안전 거리의 최댓값을 저장할 각 변수 초기화
	static int height;
	static int width;
	static int maxDistance = 0;
	
	// 인접한 위치를 나타낼 각 델타 배열 초기화
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	
	// 아기 상어의 위치를 저장할 2차원 배열 space 초기화
	static boolean[][] space;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine()); 
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 공간의 크기를 각 변수에 할당
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		
		// 아기 상어의 위치를 저장할 2차원 배열 space 초기화
		space = new boolean[height][width];
		
		// for 반복문을 사용해 공간의 행을 순회
		for (int r = 0; r < height; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 공간의 열을 순회
			for (int c = 0; c < width; c++) {
				
				// 아기 상어가 존재하는 경우 아기 상어의 위치를 갱신
				if (Integer.parseInt(st.nextToken()) == 1)
					space[r][c] = true;
			}
		}
		
		// for 반복문을 사용해 공간의 각 칸을 순회
		for (int r = 0; r < height; r++) {
			for (int c = 0; c < width; c++) {
				
				// 해당 칸에 아기 상어가 위치한 경우 다음 칸을 순회
				if (space[r][c])
					continue;
				
				// distCalculator() 메서드를 호출해 안전 거리의 최댓값을 갱신
				distCalculator(r, c);
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 안전 거리의 최댓값을 출력
		out.write(String.valueOf(maxDistance));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// distCalculator() 메서드 정의
	public static void distCalculator(int startRow, int startCol) {
		
		// 각 공간의 확인 여부를 저장할 2차원 배열 checked 초기화
		Integer[][] checked = new Integer[height][width];
		
		// 다음에 확인할 위치를 저장할 Queue 객체 checkList 초기화
		Queue<int[]> checkList = new LinkedList<>();
		
		// offer() 메서드를 사용해 시작 위치를 checkList에 추가 및 확인 처리
		checkList.offer(new int[] {startRow, startCol});
		checked[startRow][startCol] = 0;
		
		// while 반복문을 사용해 checkList가 빌 때까지 순회
		while (!checkList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 확인 중인 위치를 배열 curLoc에 할당
			int[] curLoc = checkList.poll();
			
			// 해당 위치에 상어가 위치한 경우
			if (space[curLoc[0]][curLoc[1]]) {
				
				// max() 메서드를 사용해 안전 거리의 최댓값을 갱신
				maxDistance = Math.max(checked[curLoc[0]][curLoc[1]], maxDistance);
				
				// 메서드 종료
				return;
			}
			
			// for 반복문을 사용해 인접한 위치를 순회
			for (int d = 0; d < 8; d++) {
				
				// 새로운 위치를 각 변수에 할당
				int nr = curLoc[0] + dr[d];
				int nc = curLoc[1] + dc[d];
				
				// 해당 위치가 공간의 범위를 벗어난 경우 다음 위치를 순회
				if (nr < 0 || nr >= height || nc < 0 || nc >= width)
					continue;
				
				// 해당 위치를 이미 확인한 경우 다음 위치를 순회
				if (checked[nr][nc] != null)
					continue;
				
				// offer() 메서드를 사용해 해당 위치를 checkList에 추가 및 확인 처리
				checkList.offer(new int[] {nr, nc});
				checked[nr][nc] = checked[curLoc[0]][curLoc[1]] + 1;
			}
		}
	}
}