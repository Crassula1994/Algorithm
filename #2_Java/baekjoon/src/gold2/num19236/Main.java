package gold2.num19236;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 상어가 먹을 수 있는 물고기 번호의 최댓값을 저장할 변수 maxFish 초기화
	static int maxFish = 0;
	
	// 물고기와 상어의 방향을 나타낼 각 델타 배열 초기화
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, -1, -1, -1, 0, 1, 1, 1};
	
	// ----------------------------------------------------------------------------------------------------
	
	// Fish 클래스 정의
	static class Fish {
		
		// 물고기의 현재 위치와 방향을 저장할 각 변수 초기화
		int row;
		int column;
		int direction;
		
		// 매개변수를 입력 받는 생성자 정의
		public Fish(int row, int column, int direction) {
			this.row = row;
			this.column = column;
			this.direction = direction;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 각 칸에 들어있는 상어와 물고기의 정보를 저장할 배열 fishes 초기화
		Fish[] fishes = new Fish[17];
		
		// 각 물고기와 상어의 위치를 저장할 2차원 배열 space 초기화
		int[][] space = new int[4][4];
		
		// for 반복문을 사용해 각 행을 순회
		for (int r = 0; r < 4; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 각 칸을 순회
			for (int c = 0; c < 4; c++) {
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 물고기의 번호와 방향을 각 변수에 할당
				int number = Integer.parseInt(st.nextToken());
				int direction = Integer.parseInt(st.nextToken()) - 1;
				
				// 해당 물고기의 정보를 배열 fishes에 저장
				fishes[number] = new Fish(r, c, direction);
				
				// 해당 물고기의 위치를 2차원 배열 space에 저장
				space[r][c] = number;
			}
		}
		
		// 상어가 공간에 들어가 물고기를 먹은 상태를 갱신
		maxFish += space[0][0];
		fishes[0] = new Fish(0, 0, fishes[space[0][0]].direction);
		fishes[space[0][0]] = null;
		space[0][0] = 0;
		
		// fishMover() 메서드를 호출해 상어가 먹을 수 있는 물고기 번호의 최댓값을 갱신
		fishMover(maxFish, fishes, space);
		
		// valueOf() 및 write() 메서드를 사용해 상어가 먹을 수 있는 물고기 번호의 최댓값을 출력
		out.write(String.valueOf(maxFish));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// fishMover() 메서드 정의
	public static void fishMover(int fishSum, Fish[] curFishes, int[][] curSpace) {
		
		// for 반복문을 사용해 각 물고기를 순회
		for (int idx = 1; idx <= 16; idx++) {
			
			// 해당 물고기가 상어에 의해 잡아 먹힌 경우 다음 물고기를 순회
			if (curFishes[idx] == null)
				continue;
			
			// for 반복문을 사용해 각 방향을 순회
			for (int d = 0; d < 8; d++) {
				
				// 물고기가 이동할 위치를 각 변수에 할당
				int nr = curFishes[idx].row + dr[curFishes[idx].direction];
				int nc = curFishes[idx].column + dc[curFishes[idx].direction];
				
				/* 물고기가 이동할 위치가 공간의 범위를 벗어나거나 상어가 위치한 곳인 경우
				물고기의 방향을 갱신 후 다음 방향을 순회 */
				if (nr < 0 || nr >= 4 || nc < 0 || nc >= 4 || curSpace[nr][nc] == 0) {
					curFishes[idx].direction = (curFishes[idx].direction + 1) % 8;
					continue;
				}
				
				// 물고기가 이동할 위치에 있는 물고기를 변수 nextFish에 할당
				int nextFish = curSpace[nr][nc];
				
				// 두 물고기의 위치를 변경
				curSpace[curFishes[idx].row][curFishes[idx].column] = nextFish;
				curSpace[nr][nc] = idx;
				
				// 이동할 위치에 물고기가 없는 경우 현재 물고기의 위치를 갱신
				if (nextFish == -1) {
					curFishes[idx].row = nr;
					curFishes[idx].column = nc;
					
				// 이동할 위치에 물고기가 있는 경우 현재 물고기와 다른 물고기의 위치를 갱신
				} else {
					curFishes[nextFish].row = curFishes[idx].row;
					curFishes[nextFish].column = curFishes[idx].column;
					curFishes[idx].row = nr;
					curFishes[idx].column = nc;
				}
				
				// 반복문 탈출
				break;
			}
		}
		
		// 상어가 이동할 위치가 존재하는지 여부를 나타낼 변수 canMove 초기화
		boolean canMove = false;
		
		// for 반복문을 사용해 상어가 이동할 위치를 순회
		for (int m = 1; m <= 3; m++) {
			
			// 상어가 이동할 위치를 각 변수에 할당
			int nr = curFishes[0].row + dr[curFishes[0].direction] * m;
			int nc = curFishes[0].column + dc[curFishes[0].direction] * m;
			
			// 상어가 이동할 위치가 공간의 범위를 벗어나거나 물고기가 없는 칸인 경우 다음 위치를 순회
			if (nr < 0 || nr >= 4 || nc < 0 || nc >= 4 || curSpace[nr][nc] == -1)
				continue;
			
			// 상어가 이동할 위치가 존재하는지 여부를 갱신
			canMove = true;
			
			// 상어가 이동한 후의 물고기 및 상어 정보를 저장할 배열 nextFishes 초기화
			Fish[] nextFishes = new Fish[17];
			
			// 상어가 이동한 후 물고기와 상어의 위치를 저장할 2차원 배열 nextSpace 초기화
			int[][] nextSpace = new int[4][4];
			
			// for 반복문을 사용해 상어가 이동한 후의 물고기 및 상어 정보를 순회
			for (int idx = 0; idx < nextFishes.length; idx++) {
				
				// 해당 물고기가 상어에 의해 잡아 먹힌 경우 다음 물고기를 순회
				if (curFishes[idx] == null)
					continue;
				
				// 상어가 이동한 후의 물고기 및 상어 정보를 초기화
				nextFishes[idx] = new Fish(curFishes[idx].row, curFishes[idx].column, curFishes[idx].direction);
			}
			
			// for 반복문을 사용해 상어가 이동한 후 물고기와 상어의 위치를 초기화
			for (int r = 0; r < 4; r++)
				nextSpace[r] = curSpace[r].clone();
			
			// 상어가 이동한 위치의 물고기를 먹은 상태를 갱신
			nextFishes[0].row = nr;
			nextFishes[0].column = nc;
			nextFishes[0].direction = curFishes[curSpace[nr][nc]].direction;
			nextFishes[curSpace[nr][nc]] = null;
			nextSpace[nr][nc] = 0;
			nextSpace[curFishes[0].row][curFishes[0].column] = -1;

			// fishMover() 메서드 재귀 호출
			fishMover(fishSum + curSpace[nr][nc], nextFishes, nextSpace);
		}
		
		// 상어가 더 이상 이동할 곳이 없는 경우 상어가 먹을 수 있는 물고기 번호의 최댓값을 갱신
		if (!canMove)
			maxFish = Math.max(fishSum, maxFish);
	}
}