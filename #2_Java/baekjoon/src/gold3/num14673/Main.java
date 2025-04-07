package gold3.num14673;

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
	
	// 퍼즐의 너비와 높이, 준서의 차례에 얻을 수 있는 최고 고득점을 저장할 각 변수 초기화
	static int width;
	static int height;
	static int maxScore = 0;
	
	// 인접한 위치를 나타낼 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 퍼즐의 너비와 높이를 각 변수에 할당
		width = Integer.parseInt(st.nextToken());
		height = Integer.parseInt(st.nextToken());
		
		// 주어진 퍼즐을 저장할 2차원 배열 startPuzzle 초기화
		int[][] startPuzzle = new int[height][width];
		
		// for 반복문을 사용해 퍼즐의 각 행을 순회
		for (int r = 0; r < height; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 퍼즐 조각의 종류를 2차원 배열 startPuzzle에 저장
			for (int c = 0; c < width; c++)
				startPuzzle[r][c] = Integer.parseInt(st.nextToken());
		}
		
		// pieceSelector() 메서드를 호출해 준서의 차례에 얻을 수 있는 최고 고득점을 갱신
		pieceSelector(startPuzzle, 0, 0);
		
		// valueOf() 및 write() 메서드를 사용해 준서의 차례에 얻을 수 있는 최고 고득점을 출력
		out.write(String.valueOf(maxScore));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// pieceSelector() 메서드 정의
	public static void pieceSelector(int[][] curPuzzle, int selectedCnt, int score) {
		
		// 세 번을 모두 선택했거나 모든 퍼즐을 파괴한 경우 준서의 차례에 얻을 수 있는 최고 고득점을 갱신 후 메서드 종료
		if (selectedCnt == 3 || puzzleChecker(curPuzzle)) {
			maxScore = Math.max(score, maxScore);
			return;
		}
		
		// pieceSinker() 메서드를 호출해 공중에 떠 있는 조각의 위치를 갱신
		pieceSinker(curPuzzle);
		
		// for 반복문을 사용해 각 퍼즐의 행과 열을 순회
		for (int r = 0; r < height; r++) {
			for (int c = 0; c < width; c++) {
				
				// 해당 위치에 퍼즐이 없는 경우 다음 위치를 순회
				if (curPuzzle[r][c] == 0)
					continue;
				
				// 현재 위치의 퍼즐 조각을 파괴했을 때의 퍼즐을 저장할 2차원 배열 nextPuzzle 초기화 
				int[][] nextPuzzle = new int[height][width];
				
				// for 반복문을 사용해 2차원 배열 nextPuzzle 초기화
				for (int idx = 0; idx < height; idx++)
					nextPuzzle[idx] = curPuzzle[idx].clone();
				
				// pieceCrusher() 및 pieceSelector() 메서드를 호출해 다음 경우의 수를 순회
				pieceSelector(nextPuzzle, selectedCnt + 1, score + pieceCrusher(nextPuzzle, r, c));
			}
		}
	}

	// ----------------------------------------------------------------------------------------------------

	// puzzleChecker() 메서드 정의
	public static boolean puzzleChecker(int[][] curPuzzle) {
		
		// for 반복문을 사용해 각 퍼즐의 행과 열을 순회
		for (int r = 0; r < height; r++) {
			for (int c = 0; c < width; c++) {
				
				// 아직 퍼즐이 존재하는 경우 false 반환
				if (curPuzzle[r][c] != 0)
					return false;
			}
		}
		
		// 퍼즐이 더 이상 존재하지 않는 경우 true 반환
		return true;
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// pieceSinker() 메서드 정의
	public static void pieceSinker(int[][] curPuzzle) {
		
		// for 반복문을 사용해 퍼즐의 각 열을 순회
		for (int c = 0; c < width; c++) {
			
			// for 반복문을 사용해 퍼즐의 각 행을 거꾸로 순회
			for (int r = height - 1; r > 0; r--) {
				
				// 해당 위치에 퍼즐 조각이 존재하는 경우 다음 위치를 순회
				if (curPuzzle[r][c] != 0)
					continue;
				
				// 다음 퍼즐 조각이 존재하는 위치를 저장할 변수 nextPiece 초기화
				int nextPiece = r - 1;
				
				// while 반복문을 사용해 다음 퍼즐 조각이 존재하는 위치를 갱신
				while (nextPiece >= 0 && curPuzzle[nextPiece][c] == 0)
					nextPiece--;
				
				// 다음 퍼즐 조각이 존재하지 않는 경우 반복문 탈출
				if (nextPiece < 0)
					break;
				
				// 다음 퍼즐 조각의 위치를 현재 위치로 갱신
				curPuzzle[r][c] = curPuzzle[nextPiece][c];
				curPuzzle[nextPiece][c] = 0; 
			}
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// pieceCrusher() 메서드 정의
	public static int pieceCrusher(int[][] curPuzzle, int startRow, int startCol) {
		
		// 해당 퍼즐 조각을 통해 파괴된 퍼즐 조각의 수, 현재 퍼즐 조각의 종류를 저장할 각 변수 초기화
		int count = 1;
		int category = curPuzzle[startRow][startCol];
		
		// 다음에 부술 퍼즐의 위치를 저장할 Queue 객체 crushList 초기화
		Queue<int[]> crushList = new LinkedList<>();
		
		// offer() 메서드를 사용해 해당 위치를 crushList에 추가 및 파괴 처리
		crushList.offer(new int[] {startRow, startCol});
		curPuzzle[startRow][startCol] = 0;
		
		// while 반복문을 사용해 crushList가 빌 때까지 순회
		while (!crushList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 부술 퍼즐 조각의 위치를 배열 curLocation에 할당
			int[] curLocation = crushList.poll();
			
			// for 반복문을 사용해 인접한 위치를 순회
			for (int d = 0; d < 4; d++) {
				
				// 인접한 위치를 각 변수에 할당
				int nr = curLocation[0] + dr[d];
				int nc = curLocation[1] + dc[d];
				
				// 해당 위치가 퍼즐의 범위를 벗어나는 경우 다음 위치를 순회
				if (nr < 0 || nr >= height || nc < 0 || nc >= width)
					continue;
				
				// 해당 위치에 다른 종류의 퍼즐이 위치한 경우 다음 위치를 순회
				if (curPuzzle[nr][nc] != category)
					continue;
				
				// offer() 메서드를 사용해 다음에 부술 퍼즐 조각의 위치를 crushList에 추가 및 파괴 처리
				crushList.offer(new int[] {nr, nc});
				curPuzzle[nr][nc] = 0;
				
				// 파괴된 퍼즐 조각의 수를 갱신
				count++;
			}
		}
		
		// 해당 퍼즐 조각을 통해 얻은 점수를 반환
		return count * count;
	}
}