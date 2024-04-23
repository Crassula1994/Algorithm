package silver1.num16948;

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
	
	// 체스판의 크기를 저장할 변수 size 초기화
	static int size;
	
	// 데스 나이트의 이동 경로를 저장할 각 델타 배열 초기화
	static int[] dr = {-2, -2, 0, 0, 2, 2};
	static int[] dc = {-1, 1, -2, 2, -1, 1};
	
	// 데스 나이트의 이동 여부를 저장할 2차원 배열 chessBoard 초기화
	static Integer[][] chessBoard;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 체스판의 크기를 변수 size에 할당
		size = Integer.parseInt(in.readLine());
		
		// 데스 나이트의 이동 여부를 저장할 2차원 배열 chessBoard 초기화
		chessBoard = new Integer[size][size];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 데스 나이트의 시작 위치와 도착 위치를 각 변수에 할당
		int startRow = Integer.parseInt(st.nextToken());
		int startCol = Integer.parseInt(st.nextToken());
		int endRow = Integer.parseInt(st.nextToken());
		int endCol = Integer.parseInt(st.nextToken());
		
		// deathKnightMover() 메서드를 호출해 도착 위치에 도착하기 위한 최소 이동 횟수를 변수 minCount에 할당
		int minCount = deathKnightMover(startRow, startCol, endRow, endCol);
		
		// valueOf() 및 write() 메서드를 사용해 도착 위치에 도착하기 위한 최소 이동 횟수를 출력
		out.write(String.valueOf(minCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// deathKnightMover() 메서드 정의
	public static int deathKnightMover(int startRow, int startCol, int endRow, int endCol) {
		
		// 다음에 이동할 위치를 저장할 Queue 객체 moveList 초기화
		Queue<int[]> moveList = new LinkedList<>();
		
		// offer() 메서드를 사용해 시작 위치를 moveList에 추가 및 이동 여부를 갱신
		moveList.offer(new int[] {startRow, startCol});
		chessBoard[startRow][startCol] = 0;
		
		// while 반복문을 사용해 moveList가 빌 때까지 순회
		while (!moveList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 위치를 배열 curLoc에 할당
			int[] curLoc = moveList.poll();
			
			// 해당 위치가 도착 위치인 경우 최소 이동 횟수를 반환
			if (curLoc[0] == endRow && curLoc[1] == endCol)
				return chessBoard[curLoc[0]][curLoc[1]];
			
			// for 반복문을 사용해 데스 나이트가 이동할 수 있는 위치를 순회
			for (int d = 0; d < 6; d++) {
				
				// 새로운 위치를 각 변수에 할당
				int nr = curLoc[0] + dr[d];
				int nc = curLoc[1] + dc[d];
				
				// 해당 위치가 범위를 벗어난 경우 다음 위치를 순회
				if (nr < 0 || nr >= size || nc < 0 || nc >= size)
					continue;
				
				// 해당 위치를 이미 확인한 경우 다음 위치를 순회
				if (chessBoard[nr][nc] != null)
					continue;
				
				// offer() 메서드를 사용해 해당 위치를 moveList에 추가 및 이동 여부를 갱신
				moveList.offer(new int[] {nr, nc});
				chessBoard[nr][nc] = chessBoard[curLoc[0]][curLoc[1]] + 1;
			}
		}
		
		// 도착 위치에 도달하지 못하는 경우 -1 반환
		return -1;
	}
}