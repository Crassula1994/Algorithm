package gold4.num01987;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 보드의 크기, 말이 지날 수 있는 최대의 칸 수를 나타낼 각 변수 초기화
	static int rowNum;
	static int colNum;
	static int maxCnt = 0;
	
	// 인접한 위치를 나타낼 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// 보드의 알파벳을 저장할 2차원 배열 board 초기화
	static char[][] board;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 보드의 크기를 각 변수에 할당
		rowNum = Integer.parseInt(st.nextToken());
		colNum = Integer.parseInt(st.nextToken());
		
		// 보드의 알파벳을 저장할 2차원 배열 board 초기화
		board = new char[rowNum][colNum];
		
		// for 반복문을 사용해 2차원 배열 board의 각 행을 순회
		for (int r = 0; r < rowNum; r++) {
			
			// readLine() 메서드를 사용해 해당 행의 알파벳을 변수 alphabets에 할당
			String alphabets = in.readLine();
			
			// for 반복문을 사용해 입력 받은 알파벳을 2차원 배열 board에 저장
			for (int c = 0; c < colNum; c++)
				board[r][c] = alphabets.charAt(c);
		}

		// 알파벳의 등장 여부를 저장할 배열 alphabets 초기화
		boolean[] alphabets = new boolean[26];
		
		// 말이 위치한 곳의 알파벳을 등장 처리
		alphabets[board[0][0] - 'A'] = true;
		
		// pathFinder() 메서드를 호출해 말이 지날 수 있는 최대의 칸 수를 갱신
		pathFinder(0, 0, 1, alphabets);
		
		// valueOf() 및 write() 메서드를 사용해 말이 지날 수 있는 최대의 칸 수를 출력
		out.write(String.valueOf(maxCnt));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// pathFinder() 메서드 정의
	public static void pathFinder(int row, int col, int count, boolean[] alphabets) {
		
		// 더 이상 이동할 곳이 없는지를 나타내는 변수 isEnd 초기화
		boolean isEnd = true;
		
		// for 반복문을 사용해 각 인접한 위치를 순회
		for (int d = 0; d < 4; d++) {
			
			// 새로운 위치를 각 변수에 할당
			int nr = row + dr[d];
			int nc = col + dc[d];
			
			// 새로운 위치가 보드의 범위를 벗어나는 경우 다음 위치를 순회
			if (nr < 0 || nr >= rowNum || nc < 0 || nc >= colNum)
				continue;
			
			// 해당 위치의 알파벳이 이미 등장한 경우 다음 위치를 순회
			if (alphabets[board[nr][nc] - 'A'])
				continue;
			
			// 더 이상 이동할 곳이 없는지를 나타내는 변수 갱신
			isEnd = false;
			
			// 해당 위치의 알파벳을 등장 처리
			alphabets[board[nr][nc] - 'A'] = true;
			
			// pathFinder() 메서드 재귀 호출
			pathFinder(nr, nc, count + 1, alphabets);
			
			// 해당 위치의 알파벳을 원상 복구
			alphabets[board[nr][nc] - 'A'] = false;
		}
		
		// 더 이상 이동할 곳이 없는 경우 말이 지날 수 있는 최대의 칸 수를 갱신
		if (isEnd)
			maxCnt = Math.max(count, maxCnt);
	}
}