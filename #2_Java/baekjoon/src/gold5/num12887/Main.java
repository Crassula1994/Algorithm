package gold5.num12887;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

// Main 클래스 정의
public class Main {
	
	// 열의 개수를 저장할 변수 columnNum 초기화
	static int columnNum;
	
	// 인접한 위치를 나타낼 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// 게임판의 상태를 저장할 2차원 배열 gameBoard 초기화
	static char[][] gameBoard;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 열의 개수를 변수 columnNum에 할당
		columnNum = Integer.parseInt(in.readLine());
		
		// 하얀색 칸의 개수, 왼쪽-오른쪽 경로의 최단 길이를 저장할 각 변수 초기화
		int totalCount = 0;
		int minLength = Integer.MAX_VALUE;
		
		// 게임판의 상태를 저장할 2차원 배열 gameBoard 초기화
		gameBoard = new char[2][columnNum];
		
		// for 반복문을 사용해 게임판의 각 행을 순회
		for (int r = 0; r < 2; r++) {
			
			// readLine() 메서드를 사용해 입력 받은 게임판의 행의 상태를 변수 row에 할당
			String row = in.readLine();
			
			// for 반복문을 사용해 게임판의 각 칸을 순회
			for (int c = 0; c < columnNum; c++) {
				
				// charAt() 메서드를 사용해 입력 받은 게임판의 상태를 2차원 배열 gameBoard에 저장
				gameBoard[r][c] = row.charAt(c);
				
				// 해당 칸이 하얀색 칸인 경우 하얀색 칸의 개수를 갱신
				if (gameBoard[r][c] == '.')
					totalCount++;
			}
		}
		
		// for 반복문을 사용해 각 시작 위치를 순회
		for (int r = 0; r < 2; r++) {
			
			// pathFinder() 메서드를 호출해 해당 위치에서의 왼쪽-오른쪽 경로의 길이를 변수 length에 할당
			int length = pathFinder(r, 0);
			
			// 왼쪽-오른쪽 경로가 존재하는 경우 왼쪽-오른쪽 경로의 최단 길이를 갱신
			if (length > 0)
				minLength = Math.min(length, minLength);
		}
		
		// valueOf() 및 write() 메서드를 사용해 하얀색 칸의 개수, 왼쪽-오른쪽 경로의 최단 길이를 출력
		out.write(String.valueOf(totalCount - minLength));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// pathFinder() 메서드 정의
	public static int pathFinder(int startRow, int startColumn) {
		
		// 해당 위치가 검은색 칸인 경우 0을 반환
		if (gameBoard[startRow][startColumn] == '#')
			return 0;
		
		// 현재 위치까지의 왼쪽-오른쪽 경로의 길이를 저장할 2차원 배열 lengths 초기화
		int[][] lengths = new int[2][columnNum];
		
		// 다음에 방문할 위치를 저장할 Queue 객체 visitList 초기화
		Queue<int[]> visitList = new LinkedList<>();
		
		// offer() 메서드를 사용해 시작 위치를 visitList에 추가 및 왼쪽-오른쪽 경로의 길이를 갱신
		visitList.offer(new int[] {startRow, startColumn});
		lengths[startRow][startColumn] = 1;
		
		// while 반복문을 사용해 visitList가 빌 때까지 순회
		while (!visitList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 위치를 배열 curLocation에 할당
			int[] curLocation = visitList.poll();
			
			// 해당 위치가 오른쪽 끝인 경우 왼쪽-오른쪽 경로의 길이를 반환
			if (curLocation[1] == columnNum - 1)
				return lengths[curLocation[0]][curLocation[1]];
			
			// for 반복문을 사용해 인접한 위치를 순회
			for (int d = 0; d < 4; d++) {
				
				// 인접한 위치를 각 변수에 할당
				int nr = curLocation[0] + dr[d];
				int nc = curLocation[1] + dc[d];
				
				// 해당 위치가 게임판의 범위를 벗어난 경우 다음 위치를 순회
				if (nr < 0 || nr >= 2 || nc < 0 || nc >= columnNum)
					continue;
				
				// 해당 위치가 검정색 칸이거나 이미 방문한 곳인 경우 다음 위치를 순회
				if (gameBoard[nr][nc] == '#' || lengths[nr][nc] != 0)
					continue;
				
				// offer() 메서드를 사용해 해당 위치를 visitList에 추가 및 왼쪽-오른쪽 경로의 길이를 갱신
				visitList.offer(new int[] {nr, nc});
				lengths[nr][nc] = lengths[curLocation[0]][curLocation[1]] + 1;
			}
		}
		
		// 왼쪽-오른쪽 경로가 존재하지 않는 경우 0을 반환
		return 0;
	}
}