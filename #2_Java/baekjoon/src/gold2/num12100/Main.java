package gold2.num12100;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 보드의 크기 및 최대 5번 이동시켜 얻을 수 있는 가장 큰 블록을 저장할 각 변수 초기화
	static int size;
	static int maxBlock = 0;
	
	// 각 이동 방향을 저장할 각 델타 배열, 블록을 이동시킨 방향을 저장할 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[] directions = new int[5];
	
	// 이동 전 및 이동 후 블록의 상태, 해당 위치의 블록이 합쳐졌는지 여부를 저장할 각 2차원 배열 초기화
	static int[][] startBoard;
	static int[][] endBoard;
	static boolean[][] merged;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 보드의 크기를 변수 size에 할당
		size = Integer.parseInt(in.readLine());
		
		// 이동 전 블록의 상태를 저장할 2차원 배열 startBoard 초기화
		startBoard = new int[size][size];
		
		// for 반복문을 사용해 보드의 각 행을 순회
		for (int r = 0; r < size; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 현재 블록의 상태를 2차원 배열 startBoard에 저장
			for (int c = 0; c < size; c++)
				startBoard[r][c] = Integer.parseInt(st.nextToken());
		}
		
		// boardMover() 메서드를 호출해 최대 5번 이동시켜 얻을 수 있는 가장 큰 블록을 갱신
		boardMover(0);
		
		// valueOf() 및 write() 메서드를 사용해 최대 5번 이동시켜 얻을 수 있는 가장 큰 블록를 출력
		out.write(String.valueOf(maxBlock));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// boardMover() 메서드 정의
	public static void boardMover(int moveCnt) {
		
		/* 5번을 모두 움직인 경우 blockChecker() 메서드를 호출해
		최대 5번 이동시켜 얻을 수 있는 가장 큰 블록을 갱신 후 메서드 종료 */
		if (moveCnt == 5) {
			blockChecker();
			return;
		}
		
		// for 반복문을 사용해 보드를 움직인 방향을 갱신 후 boardMover() 메서드 재귀 호출
		for (int d = 0; d < 4; d++) {
			directions[moveCnt] = d;
			boardMover(moveCnt + 1);
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// blockChecker() 메서드 정의
	public static void blockChecker() {
		
		// 이동 후 보드의 상태를 저장할 2차원 배열 endBoard 초기화
		endBoard = new int[size][size];
		
		// for 반복문을 사용해 이동 후 보드의 상태를 이동 전 보드의 상태로 초기화
		for (int r = 0; r < size; r++)
			endBoard[r] = startBoard[r].clone();
		
		// for 반복문을 사용해 각 이동한 방향을 순회
		for (int idx = 0; idx < directions.length; idx++) {
			
			// 해당 위치의 블록이 합쳐졌는지 여부를 저장할 2차원 배열 merged 초기화
			merged = new boolean[size][size];
			
			// 이동한 방향을 변수 direction에 할당
			int direction = directions[idx];
			
			// for 반복문을 사용해 blockMover() 메서드를 호출하고 블록을 이동 처리
			for (int r = (direction == 1) ? size - 1 : 0; r >= 0 && r < size; r += (direction == 1) ? -1 : 1) {
				for (int c = (direction == 3) ? size - 1 : 0; c >= 0 && c < size; c += (direction == 3) ? -1 : 1)
					blockMover(r, c, direction);
			}
		}
		
		// for 반복문을 사용해 최대 5번 이동시켜 얻을 수 있는 가장 큰 블록을 갱신
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++)
				maxBlock = Math.max(endBoard[r][c], maxBlock);
		}
	}
	
	// ----------------------------------------------------------------------------------------------------

	// blockMover() 메서드 정의
	public static void blockMover(int startRow, int startCol, int direction) {
		
		// 옮길 블록의 숫자가 0인 경우 메서드 종료
		if (endBoard[startRow][startCol] == 0)
			return;
		
		// 현재 블록의 위치를 저장할 각 변수 초기화
		int curRow = startRow;
		int curCol = startCol;
		
		// while 반복문을 사용해 해당 블록을 이동할 수 있을 때까지 이동
		while (true) {
		
			// 다음에 이동시킬 블록의 위치를 각 변수에 할당
			int nextRow = curRow + dr[direction];
			int nextCol = curCol + dc[direction];
			
			// 해당 위치가 보드의 범위를 벗어나는 경우 메서드 종료
			if (nextRow < 0 || nextRow >= size || nextCol < 0 || nextCol >= size)
				return;
			
			// 해당 위치에 이미 합친 숫자가 있는 경우 메서드 종료
			if (merged[nextRow][nextCol])
				return;
			
			// 해당 위치에 합쳐지지 않은 같은 숫자가 있는 경우 블록을 합치고 메서드 종료
			if (endBoard[curRow][curCol] == endBoard[nextRow][nextCol]) {
				endBoard[curRow][curCol] = 0;
				endBoard[nextRow][nextCol] *= 2;
				merged[nextRow][nextCol] = true;
				return;
				
			// 해당 위치에 같지 않은 다른 숫자가 있는 경우 메서드 종료
			} else if (endBoard[nextRow][nextCol] != 0) {
				return;
			}
			
			// 현재 블록을 다음 위치로 이동 처리
			endBoard[nextRow][nextCol] = endBoard[curRow][curCol];
			endBoard[curRow][curCol] = 0;
			
			// 현재 블록의 위치를 갱신
			curRow = nextRow;
			curCol = nextCol;
		}
	}
}