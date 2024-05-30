package silver1.num14716;

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
	
	// 현수막의 크기를 저장할 각 변수 초기화
	static int height;
	static int width;
	
	// 인접한 위치를 나타낼 각 델타 배열 초기화
	static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
	static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};
	
	// 현수막의 상태를 저장할 2차원 배열 banner 초기화
	static boolean[][] banner;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 현수막의 크기를 각 변수에 할당
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		
		// 글자의 개수를 저장할 변수 letterNum 초기화
		int letterNum = 0;
		
		// 현수막의 상태를 저장할 2차원 배열 banner 초기화
		banner = new boolean[height][width];
		
		// for 반복문을 사용해 보물 지도의 행을 순회
		for (int r = 0; r < height; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 보물 지도의 칸을 순회
			for (int c = 0; c < width; c++) {
				
				// 해당 위치가 글자인 경우 현수막의 상태를 갱신
				if (Integer.parseInt(st.nextToken()) == 1)
					banner[r][c] = true;
			}
		}
		
		// for 반복문을 사용해 각 보물 지도의 칸을 순회
		for (int r = 0; r < height; r++) {
			for (int c = 0; c < width; c++) {
				
				// 해당 위치가 글자인 경우 
				if (banner[r][c]) {
					
					// 글자의 개수 갱신
					letterNum++;
					
					// letterFinder() 메서드를 호출해 같은 글자를 탐색
					letterFinder(r, c);
				}
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 글자의 개수를 출력
		out.write(String.valueOf(letterNum));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// letterFinder() 메서드 정의
	public static void letterFinder(int startRow, int startCol) {
		
		// 다음에 확인할 위치를 저장할 Queue 객체 checkList 초기화
		Queue<int[]> checkList = new LinkedList<>();
		
		// offer() 메서드를 사용해 시작 위치를 checkList에 추가 및 해당 글자 확인 처리
		checkList.offer(new int[] {startRow, startCol});
		banner[startRow][startCol] = false;
		
		// while 반복문을 사용해 checkList가 빌 때까지 순회
		while (!checkList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 위치를 배열 curLoc에 할당
			int[] curLoc = checkList.poll();
			
			// for 반복문을 사용해 인접한 위치를 순회
			for (int d = 0; d < 8; d++) {
				
				// 새로운 위치를 각 변수에 할당
				int nr = curLoc[0] + dr[d];
				int nc = curLoc[1] + dc[d];
				
				// 해당 위치가 현수막의 범위를 벗어난 경우 다음 위치를 순회
				if (nr < 0 || nr >= height || nc < 0 || nc >= width)
					continue;
				
				// 해당 위치를 이미 확인했거나 글자가 아닌 부분인 경우 다음 위치를 순회
				if (!banner[nr][nc])
					continue;
				
				// offer() 메서드를 사용해 해당 위치를 checkList에 추가 및 해당 글자 확인 처리
				checkList.offer(new int[] {nr, nc});
				banner[nr][nc] = false;
			}
		}
	}
}