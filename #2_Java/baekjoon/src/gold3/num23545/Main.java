package gold3.num23545;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 입력 받은 용기의 크기와 고양이의 체적을 저장할 각 변수 초기화
	static int height;
	static int width;
	static int volume;
	
	// 해당 칸이 속해 있는 공간, 해당 공간이 가진 칸의 개수를 저장할 각 배열 초기화
	static int[] rootCell;
	static int[] cellCount;
	
	// 인접한 위치를 나타낼 각 델타 배열 초기화
	static int[] dr = {1, 0, 0};
	static int[] dc = {0, -1, 1};
	
	// 용기의 상태를 저장할 2차원 배열 vessel 초기화
	static char[][] vessel;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 용기의 크기와 고양이의 체적을 각 변수에 할당
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		volume = Integer.parseInt(st.nextToken());
		
		// 해당 칸이 속해 있는 공간, 해당 공간이 가진 칸의 개수를 저장할 각 배열 초기화
		rootCell = new int[height * width];
		cellCount = new int[height * width];
		
		// 용기의 상태를 저장할 2차원 배열 vessel 초기화
		vessel = new char[height][width];
		
		// for 반복문을 사용해 입력 받은 용기의 상태를 2차원 배열 vessel에 저장
		for (int r = 0; r < height; r++)
			vessel[r] = in.readLine().toCharArray();
		
		// for 반복문을 사용해 용기의 각 칸을 순회
		for (int r = 0; r < height; r++) {
			for (int c = 0; c < width; c++) {
				
				// cellIdentifier() 메서드를 호출해 해당 칸의 번호를 변수 cellId에 할당
				int cellId = cellIdentifier(r, c);
				
				// 해당 칸이 속해 있는 공간 및 해당 공간이 가진 칸의 개수를 초기화
				rootCell[cellId] = cellId;
				cellCount[cellId] = 1;
			}
		}
		
		// highestCellFinder() 메서드
		out.write(String.valueOf(highestCellFinder()));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// cellIdentifier() 메서드 정의
	public static int cellIdentifier(int row, int column) {
		
		// 해당 칸의 번호를 반환
		return row * width + column;
	}
	
	// ----------------------------------------------------------------------------------------------------

	// highestCellFinder() 메서드 정의
	public static int highestCellFinder() {
		
		// for 반복문을 사용해 각 행을 거꾸로 순회
		for (int r = height - 1; r >= 0; r--) {
			
			// for 반복문을 사용해 각 칸을 순회
			for (int c = 0; c < width; c++) {
				
				// 해당 칸이 벽인 경우 다음 칸을 순회
				if (vessel[r][c] == '#')
					continue;
				
				// cellIdentifier() 및 rootCellFinder() 메서드를 호출해 현재 칸과 해당 칸이 속해 있는 공간을 각 변수에 할당
				int curCell = cellIdentifier(r, c);
				int curRootCell = rootCellFinder(curCell);
				
				// for 반복문을 사용해 현재 칸과 인접한 위치를 순회
				for (int d = 0; d < 3; d++) {
					
					// 해당 칸의 위치를 각 변수에 할당
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					// 해당 칸이 용기의 범위를 벗어나거나 벽인 경우 다음 칸을 순회
					if (nr >= height || nc < 0 || nc >= width || vessel[nr][nc] == '#')
						continue;
					
					// cellIdentifier() 및 rootCellFinder() 메서드를 호출해 다음 칸과 해당 칸이 속해 있는 공간을 각 변수에 할당
					int nextCell = cellIdentifier(nr, nc);
					int nextRootCell = rootCellFinder(nextCell);
					
					// 두 칸이 다른 공간에 속해 있는 경우 두 칸을 연결 처리
					if (nextRootCell != curRootCell) {
						rootCell[nextRootCell] = curRootCell;
						cellCount[curRootCell] += cellCount[nextRootCell];
					}
				}
				
				// 현재 공간의 부피가 고양이의 체적 이상인 경우 현재 칸의 행 번호를 반환
				if (cellCount[curRootCell] >= volume)
					return r + 1;
			}
		}
		
		// 고양이를 용기에 놓을 수 없는 경우 -1을 반환
		return -1;
	}
	
	// ----------------------------------------------------------------------------------------------------

	// rootCellFinder() 메서드 정의
	public static int rootCellFinder(int cell) {

		// 해당 칸이 속해 있는 공간이 자기 자신인 경우 해당 칸을 반환
		if (rootCell[cell] == cell)
			return cell;
		
		// rootCellFinder() 메서드를 재귀 호출해 해당 칸이 속해 있는 공간을 반환
		return rootCell[cell] = rootCellFinder(rootCell[cell]);
	}
}