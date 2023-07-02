package gold5.num14712;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 격자판의 행의 개수 및 열의 개수, 게임을 그만두었을 때 배치의 가짓수를 저장할 각 변수 초기화
	static int rowNum;
	static int columnNum;
	static int totalCount = 0;
	
	// 인접한 위치를 저장할 각 델타 배열 초기화
	static int[] dr = {-1, -1, 0};
	static int[] dc = {-1, 0, -1};
	
	// 격자판의 상태를 저장할 2차원 배열 grid 초기화
	static boolean[][] grid;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 격자판의 행의 개수 및 열의 개수를 각 변수에 할당
		rowNum = Integer.parseInt(st.nextToken());
		columnNum = Integer.parseInt(st.nextToken());
		
		// 격자판의 상태를 저장할 2차원 배열 grid 초기화
		grid = new boolean[rowNum][columnNum];
		
		// caseFinder() 메서드를 호출해 게임을 그만두었을 때 배치의 가짓수를 갱신
		caseFinder(0);
		
		// valueOf() 및 write() 메서드를 사용해 게임을 그만두었을 때 배치의 가짓수를 출력
		out.write(String.valueOf(totalCount));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// caseFinder() 메서드 정의
	public static void caseFinder(int checkedNum) {
		
		// 모든 칸을 확인한 경우
		if (checkedNum == rowNum * columnNum) {
			
			// 게임을 그만두었을 때 배치의 가짓수를 갱신 후 메서드 종료
			totalCount++;
			return;
		}
		
		// 현재 확인 중인 칸을 계산해 각 변수에 할당
		int currentRow = checkedNum / columnNum;
		int currentCol = checkedNum % columnNum;
		
		// 해당 칸에 넴모를 배치하지 않는 경우를 상정해 caseFinder() 메서드 재귀 호출
		caseFinder(checkedNum + 1);
		
		// 해당 칸에 넴모를 배치했을 때 2 × 2 사각형을 이루지 않는 경우
		if (!squareChecker(currentRow, currentCol)) {
			
			// 해당 칸에 넴모 배치
			grid[currentRow][currentCol] = true;
			
			// 해당 칸에 넴모를 배치하는 경우를 상정해 caseFinder() 메서드 재귀 호출
			caseFinder(checkedNum + 1);
			
			// 해당 칸의 넴모 배치 원상복구
			grid[currentRow][currentCol] = false;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------

	// squareChecker() 메서드 정의
	public static boolean squareChecker(int currentRow, int currentCol) {
			
		// 넴모의 개수를 저장할 변수 count 초기화
		int count = 0;
		
		// for 반복문을 사용해 각 델타 배열을 순회
		for (int d = 0; d < 3; d++) {
			
			// 새로운 인접 위치를 각 변수에 할당
			int nr = currentRow + dr[d];
			int nc = currentCol + dc[d];
			
			// 해당 위치가 격자판의 범위를 벗어나는 경우 반복문 탈출
			if (nr < 0 || nr >= rowNum || nc < 0 || nc >= columnNum)
				break;
			
			// 해당 위치에 넴모가 존재하는 경우 넴모의 개수를 갱신
			if (grid[nr][nc])
				count++;
		}
		
		// 2 × 2 사각형을 이루는 경우 true 반환
		if (count == 3)
			return true;
		
		// 2 × 2 사각형을 이루지 않는 경우 false 반환
		return false;
	}
}