package gold4.num02580;

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
	
	// 입력 받은 스도쿠 판을 저장할 2차원 배열 sudoku 초기화
	static int[][] sudoku = new int[9][9];
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 빈 칸의 위치를 저장할 Queue 객체 blankLoc 초기화
		Queue<int[]> blankLoc = new LinkedList<>();
		
		// for 반복문을 사용해 스도쿠 판의 각 행을 순회
		for (int r = 0; r < 9; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 스도쿠 판의 각 열을 순회하며 스도쿠 판에 값을 저장
			for (int c = 0; c < 9; c++) {
				sudoku[r][c] = Integer.parseInt(st.nextToken());
				
				// 빈 칸인 경우 해당 위치를 blankLoc에 추가
				if (sudoku[r][c] == 0) {
					int[] location = {r, c};
					blankLoc.offer(location);
				}
			}
		}
		
		// while() 반복문을 사용해 빈 칸이 모두 없어질 때까지 순회
		while (!blankLoc.isEmpty()) {
			
			// poll() 메서드를 사용해 빈 칸의 위치를 배열 location에 할당
			int[] location = blankLoc.poll();
			
			// rowChecker() 메서드를 실행해 답을 구할 수 있는 경우 다음 빈 칸을 순회
			if (rowChecker(location[0], location[1])) continue;
			
			// columnChecker() 메서드를 실행해 답을 구할 수 있는 경우 다음 빈 칸을 순회
			if (columnChecker(location[0], location[1])) continue;
			
			// boxChecker() 메서드를 실행해 답을 구할 수 있는 경우 다음 빈 칸을 순회
			if (boxChecker(location[0], location[1])) continue;
			
			// offer() 메서드를 사용해 해당 값을 채울 수 없는 경우 blankLoc에 다시 추가
			blankLoc.offer(location);
		}

		// for 반복문을 사용해 스도쿠 판의 각 행을 순회
		for (int r = 0; r < 9; r++) {
			
			// for 반복문을 사용해 스도쿠 판의 각 열을 순회하며 값을 출력
			for (int c = 0; c < 9; c++)
				out.write(sudoku[r][c] + " ");
			
			// write() 메서드를 사용해 줄바꿈을 출력
			out.write("\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// rowChecker() 메서드 정의
	public static boolean rowChecker(int row, int column) {
		
		// 스도쿠의 빈 칸의 정답을 저장할 변수 answer 초기화
		int answer = 45;
		
		// for 반복문을 사용해 해당 행을 차례로 순회
		for (int c = 0; c < 9; c++) {
			
			// 해당 행에 또 다른 0이 있을 경우 false 반환
			if (c != column && sudoku[row][c] == 0)
				return false;
			
			// 해당 값을 갱신
			answer -= sudoku[row][c];
		}
		
		// 정답을 찾을 수 있는 경우 빈 칸을 채우고 true 반환
		sudoku[row][column] = answer;
		return true;
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// columnChecker() 메서드 정의
	public static boolean columnChecker(int row, int column) {
		
		// 스도쿠의 빈 칸의 정답을 저장할 변수 answer 초기화
		int answer = 45;
		
		// for 반복문을 사용해 해당 열을 차례로 순회
		for (int r = 0; r < 9; r++) {
			
			// 해당 행에 또 다른 0이 있을 경우 false 반환
			if (r != row && sudoku[r][column] == 0)
				return false;
			
			// 해당 값을 갱신
			answer -= sudoku[r][column];
		}
		
		// 정답을 찾을 수 있는 경우 빈 칸을 채우고 true 반환
		sudoku[row][column] = answer;
		return true;
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// boxChecker() 메서드 정의
	public static boolean boxChecker(int row, int column) {
		
		// 스도쿠의 빈 칸의 정답을 저장할 변수 answer 초기화
		int answer = 45;
		
		// 박스의 시작점의 각 좌표를 계산해 각 변수에 할당
		int startRow = 3 * (row / 3);
		int startCol = 3 * (column / 3);
		
		// for 반복문을 사용해 박스의 각 행과 열을 차례로 순회
		for (int r = startRow; r < startRow + 3; r++) {
			for (int c = startCol; c < startCol + 3; c++) {
				
				// 해당 박스에 또 다른 0이 있을 경우 false 반환
				if ((r != row || c != column) && sudoku[r][c] == 0)
					return false;
				
				// 해당 값을 갱신
				answer -= sudoku[r][c];
			}
		}
		
		// 정답을 찾을 수 있는 경우 빈 칸을 채우고 true 반환
		sudoku[row][column] = answer;
		return true;
	}
}