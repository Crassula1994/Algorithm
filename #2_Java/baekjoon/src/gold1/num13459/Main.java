package gold1.num13459;

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
	
	// 보드의 세로, 가로 크기를 저장할 각 변수 초기화
	static int height;
	static int width;
	
	// 빨간 구슬과 파란 구슬의 시작 위치를 저장할 각 변수 초기화
	static Location startRed;
	static Location startBlue;
	
	// 구슬의 이동 방향을 나타낼 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// 보드의 상태를 저장할 2차원 배열 board 초기화
	static char[][] board;
	
	// 각 칸에 대한 두 구슬의 이동 순서를 저장할 4차원 배열 moved 초기화
	static Integer[][][][] moved;
	
	// ----------------------------------------------------------------------------------------------------
	
	// Location 클래스 정의
	static class Location {
		
		// 해당 위치를 나타낼 각 변수 초기화
		int row;
		int column;
		
		// 매개변수를 입력 받는 생성자 정의
		public Location(int row, int column) {
			this.row = row;
			this.column = column;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------

	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 보드의 세로, 가로 크기를 각 변수에 할당
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		
		// 보드의 상태를 저장할 2차원 배열 board 초기화
		board = new char[height][width];
		
		// 각 칸에 대한 두 구슬의 이동 순서를 저장할 4차원 배열 moved 초기화
		moved = new Integer[height][width][height][width];
		
		// for 반복문을 사용해 보드의 각 행을 순회
		for (int r = 0; r < height; r++) {
			
			// readLine() 메서드를 사용해 입력 받는 행의 상태를 변수 line에 할당
			String line = in.readLine();
			
			// for 반복문을 사용해 보드의 각 칸을 순회
			for (int c = 0; c < width; c++) {
				
				// charAt() 메서드를 사용해 해당 칸의 상태를 2차원 배열 board에 저장
				board[r][c] = line.charAt(c);
				
				// 해당 칸에 구슬이 위치한 경우
				if (board[r][c] == 'R' || board[r][c] == 'B') {
					
					// 빨간 구슬과 푸른 구슬의 시작 위치를 각 변수에 갱신
					startRed = (board[r][c] == 'R') ? new Location(r, c) : startRed;
					startBlue = (board[r][c] == 'B') ? new Location(r, c) : startBlue;
					
					// 해당 칸의 상태를 빈 칸으로 갱신
					board[r][c] = '.';
				}
			}
		}
		
		// boardTilter() 메서드를 호출해 빨간 구슬을 구멍을 통해 빼낼 수 있는지 여부를 변수 isPossible에 할당
		int isPossible = boardTilter();
		
		// valueOf() 및 write() 메서드를 사용해 빨간 구슬을 구멍을 통해 빼낼 수 있는지 여부를 출력
		out.write(String.valueOf(isPossible));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// boardTilter() 메서드 정의
	public static int boardTilter() {
		
		// 다음에 이동할 구슬의 위치를 저장할 Queue 객체 moveList 초기화
		Queue<Location[]> moveList = new LinkedList<>();
		
		// offer() 메서드를 사용해 시작 위치를 moveList에 추가 후 이동 처리
		moveList.offer(new Location[] {startRed, startBlue});
		moved[startRed.row][startRed.column][startBlue.row][startBlue.column] = 0;
		
		// while 반복문을 사용해 moveList가 빌 때까지 순회
		while (!moveList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 구슬의 위치를 배열 curLocation에 할당
			Location[] curLocation = moveList.poll();
			
			// 각 구슬의 현재 위치 및 이동 횟수를 각 변수에 할당
			Location curRed = curLocation[0];
			Location curBlue = curLocation[1];
			int curCount = moved[curRed.row][curRed.column][curBlue.row][curBlue.column];
			
			// 10번을 이동해도 빨간 구슬을 빼내지 못한 경우 반복문 탈출
			if (curCount >= 10)
				break;
			
			// for 반복문을 사용해 각 방향으로 기울였을 때를 순회
			outer: for (int d = 0; d < 4; d++) {
				
				// 각 구슬의 다음 위치를 나타낼 각 변수 초기화
				int nextRedR = curRed.row;
				int nextRedC = curRed.column;
				int nextBlueR = curBlue.row;
				int nextBlueC = curBlue.column;
				
				// while 반복문을 사용해 파란 구슬이 이동할 위치를 갱신
				while (board[nextBlueR + dr[d]][nextBlueC + dc[d]] != '#') {
					nextBlueR += dr[d];
					nextBlueC += dc[d];
					
					// 파란 구슬이 구멍에 빠지는 경우 다음 방향을 순회
					if (board[nextBlueR][nextBlueC] == 'O')
						continue outer;
				}
				
				// while 반복문을 사용해 빨간 구슬이 이동할 위치를 갱신
				while (board[nextRedR + dr[d]][nextRedC + dc[d]] != '#') {
					nextRedR += dr[d];
					nextRedC += dc[d];
					
					// 빨간 구슬이 구멍에 빠지는 경우 1을 반환
					if (board[nextRedR][nextRedC] == 'O')
						return 1;
				}
				
				// 두 구슬의 위치가 겹치는 경우
				if (nextRedR == nextBlueR && nextRedC == nextBlueC) {
					
					// switch 조건문에 따라 각 방향에 따른 두 구슬의 위치를 조정
					switch (d) {
						case 0:
							nextRedR = (curRed.row > curBlue.row) ? nextRedR + 1 : nextRedR;
							nextBlueR = (curRed.row > curBlue.row) ? nextBlueR : nextBlueR + 1;
							break;
						case 1:
							nextRedR = (curRed.row > curBlue.row) ? nextRedR : nextRedR - 1;
							nextBlueR = (curRed.row > curBlue.row) ? nextBlueR - 1 : nextBlueR;
							break;
						case 2:
							nextRedC = (curRed.column > curBlue.column) ? nextRedC + 1 : nextRedC;
							nextBlueC = (curRed.column > curBlue.column) ? nextBlueC : nextBlueC + 1;
							break;
						default:
							nextRedC = (curRed.column > curBlue.column) ? nextRedC : nextRedC - 1;
							nextBlueC = (curRed.column > curBlue.column) ? nextBlueC - 1 : nextBlueC;
					}
				}
				
				// 각 구슬의 위치가 이미 이동했던 곳인 경우 다음 방향을 순회
				if (moved[nextRedR][nextRedC][nextBlueR][nextBlueC] != null)
					continue;
				
				// offer() 메서드를 사용해 이동할 위치를 moveList에 추가 후 이동 처리
				moveList.offer(new Location[] {
						new Location(nextRedR, nextRedC), new Location(nextBlueR, nextBlueC)
				});
				moved[nextRedR][nextRedC][nextBlueR][nextBlueC] = curCount + 1;
			}
		}
		
		// 10번 이하로 움직여 빨간 구슬을 빼낼 수 없는 경우 0 반환
		return 0;
	}
}