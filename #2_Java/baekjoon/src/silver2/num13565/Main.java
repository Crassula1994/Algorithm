package silver2.num13565;

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
	
	// 각 격자의 상태를 나타낼 각 상수 초기화
	static final int CONDUCTOR = 0;
	static final int INSULATOR = 1;
	static final int CURRENT = -1;
	
	// 격자의 크기를 저장할 각 변수 초기화
	static int height;
	static int width;
	
	// 인접한 격자를 나타낼 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// 격자의 상태를 저장할 2차원 배열 grid 초기화
	static int[][] grid;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 격자의 크기를 각 변수에 할당
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		
		// 바깥에서 흘려준 전류가 안쪽까지 잘 전달되는지 여부를 나타낼 변수 isConducted 초기화
		boolean isConducted = false;
		
		// 격자의 상태를 저장할 2차원 배열 grid 초기화
		grid = new int[height][width];
		
		// for 반복문을 사용해 격자의 각 행을 순회
		for (int r = 0; r < height; r++) {
			
			// readLine() 메서드를 사용해 입력 받은 행의 상태를 변수 line에 할당
			String line = in.readLine();
			
			// for 반복문을 사용해 격자의 상태를 2차원 배열 grid에 저장
			for (int c = 0; c < width; c++)
				grid[r][c] = line.charAt(c) - '0';
		}
		
		// for 반복문을 사용해 가장 바깥쪽의 격자를 순회
		for (int c = 0; c < width; c++) {
			
			// 해당 격자가 전류가 통하지 않는 검은색 격자인 경우 다음 격자를 순회
			if (grid[0][c] == INSULATOR)
				continue;
			
			// currentConductor() 메서드를 호출해 바깥에서 흘려준 전류가 안쪽까지 잘 전달되는지 여부를 갱신
			isConducted = currentConductor(0, c);
			
			// 바깥에서 흘려준 전류가 안쪽까지 잘 전달되는 경우 반복문 탈출
			if (isConducted)
				break;
		}
		
		// write() 메서드를 사용해 바깥에서 흘려준 전류가 안쪽까지 잘 전달되는지 여부를 출력
		out.write((isConducted) ? "YES" : "NO");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// currentConductor() 메서드 정의
	public static boolean currentConductor(int startRow, int startCol) {
		
		// 다음에 전류를 전달할 위치를 저장할 Queue 객체 conductList 초기화
		Queue<int[]> conductList = new LinkedList<>();
		
		// offer() 메서드를 사용해 시작 위치를 conductList에 저장 및 전류 전달 처리
		conductList.offer(new int[] {startRow, startCol});
		grid[startRow][startCol] = CURRENT;
		
		// while 반복문을 사용해 conductList가 빌 때까지 순회
		while (!conductList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 위치를 배열 curLoc에 할당
			int[] curLoc = conductList.poll();
			
			// 바깥에서 흘려준 전류가 안쪽까지 잘 전달된 경우 true 반환
			if (curLoc[0] == height - 1)
				return true;
			
			// for 반복문을 사용해 인접한 위치를 순회
			for (int d = 0; d < 4; d++) {
				
				// 인접한 새로운 위치를 각 변수에 할당
				int nr = curLoc[0] + dr[d];
				int nc = curLoc[1] + dc[d];
				
				// 해당 위치가 격자의 범위를 벗어난 경우 다음 위치를 순회
				if (nr < 0 || nr >= height || nc < 0 || nc >= width)
					continue;
				
				// 해당 위치가 전류가 통하지 않는 검은색 격자이거나 이미 전류가 흐르는 경우 다음 위치를 순회
				if (grid[nr][nc] != CONDUCTOR)
					continue;
				
				// offer() 메서드를 사용해 해당 위치를 conductList에 저장 및 전류 전달 처리
				conductList.offer(new int[] {nr, nc});
				grid[nr][nc] = CURRENT;
			}
		}
		
		// 바깥에서 흘려준 전류가 안쪽까지 전달되지 않는 경우 false 반환
		return false;
	}
}