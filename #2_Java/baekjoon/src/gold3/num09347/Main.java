package gold3.num09347;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 화원의 행의 수와 열의 수를 저장할 각 변수 초기화
	static int rowNum;
	static int columnNum;
	
	// 진욱이가 이동할 수 있는 인접한 위치를 나타낼 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// 화원의 상태, 화원의 각 칸에 대한 확인 여부를 저장할 각 2차원 배열 초기화
	static boolean[][] garden;
	static boolean[][] checked;
	
	// 다음에 확인할 각 칸을 저장할 PriorityQueue 객체 cellList 초기화
	static PriorityQueue<Cell> cellList;
	
	// ----------------------------------------------------------------------------------------------------
	
	// Cell 클래스 정의
	static class Cell implements Comparable<Cell> {
		
		// 해당 화원 칸의 위치 및 해당 위치까지 도달하기 위해 부숴야 하는 울타리의 수를 저장할 각 변수 초기화
		int row;
		int column;
		int level;
		
		// 매개변수를 입력 받는 생성자 정의
		public Cell(int row, int column, int level) {
			this.row = row;
			this.column = column;
			this.level = level;
		}

		// compareTo() 메서드 정의
		@Override
		public int compareTo(Cell anotherCell) {
			
			// 부숴야 하는 울타리의 수가 적은 순서대로 정렬
			return this.level - anotherCell.level;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 화원의 행의 수와 열의 수를 각 변수에 할당
			rowNum = Integer.parseInt(st.nextToken());
			columnNum = Integer.parseInt(st.nextToken());
			
			// 화원의 상태를 저장할 2차원 배열 garden 초기화
			garden = new boolean[rowNum][columnNum];
			
			// for 반복문을 사용해 화원의 각 행을 순회
			for (int r = 0; r < rowNum; r++) {
				
				// StringTokenizer 객체를 불러와 변수 st에 재할당
				st = new StringTokenizer(in.readLine());
				
				// for 반복문을 사용해 입력 받은 화원의 상태를 2차원 배열 garden에 저장
				for (int c = 0; c < columnNum; c++)
					garden[r][c] = Integer.parseInt(st.nextToken()) == 1;
			}
			
			/* gardenChecker() 메서드를 호출해 가장 많이 부숴야 하는 울타리의 수 및
			그때 얻을 수 있는 꽃의 수를 배열 result에 저장 */
			int[] result = gardenChecker();
			
			// write() 메서드를 사용해 가장 많이 부숴야 하는 울타리의 수 및 그때 얻을 수 있는 꽃의 수를 출력
			out.write(result[0] + " " + result[1] + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// gardenChecker() 메서드 정의
	public static int[] gardenChecker() {
		
		// 가장 많이 부숴야 하는 울타리의 수 및 그때 얻을 수 있는 꽃의 수를 저장할 각 변수 초기화
		int maxLevel = 0;
		int maxCount = 0;
		
		// 화원의 각 칸에 대한 확인 여부를 저장할 배열 checked 초기화
		checked = new boolean[rowNum][columnNum];
		
		// 다음에 확인할 각 칸을 저장할 PriorityQueue 객체 cellList 초기화
		cellList = new PriorityQueue<>();
		
		// for 반복문을 사용해 위쪽과 아래쪽 테두리를 cellList에 추가 후 확인 처리
		for (int c = 0; c < columnNum; c++) {
			borderChecker(0, c);
			borderChecker(rowNum - 1, c);
		}
		
		// for 반복문을 사용해 왼쪽과 오른쪽 테두리를 cellList에 추가 후 확인 처리
		for (int r = 1; r < rowNum - 1; r++) {
			borderChecker(r, 0);
			borderChecker(r, columnNum - 1);
		}
		
		// while 반복문을 사용해 cellList가 빌 때까지 순회
		while (!cellList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 확인 중인 칸을 변수 curCell에 할당
			Cell curCell = cellList.poll();
			
			// for 반복문을 사용해 해당 칸과 인접한 위치를 순회
			for (int d = 0; d < 4; d++) {
				
				// 인접한 위치의 행과 열을 각 변수에 할당
				int nr = curCell.row + dr[d];
				int nc = curCell.column + dc[d];
				
				// 해당 위치가 화원의 범위를 벗어난 경우 다음 위치를 순회
				if (nr < 0 || nr >= rowNum || nc < 0 || nc >= columnNum)
					continue;
				
				// 해당 칸을 이미 확인한 경우 다음 위치를 순회
				if (checked[nr][nc])
					continue;
				
				// offer() 메서드를 사용해 해당 위치 정보를 cellList에 추가 후 확인 처리
				cellList.offer(new Cell(nr, nc, (garden[nr][nc]) ? curCell.level + 1 : curCell.level));
				checked[nr][nc] = true;
			}
			
			// 현재 위치가 울타리인 경우 다음 위치를 순회
			if (garden[curCell.row][curCell.column])
				continue;
			
			// 현재 위치에서 부순 울타리의 수가 가장 많이 부숴야 하는 울타리의 수보다 큰 경우
			if (curCell.level > maxLevel) {
				
				// 가장 많이 부숴야 하는 울타리의 수 및 그때 얻을 수 있는 꽃의 수를 갱신
				maxLevel = curCell.level;
				maxCount = 1;
				
			// 현재 위치에서 부순 울타리의 수가 가장 많이 부숴야 하는 울타리의 수와 같은 경우 얻을 수 있는 꽃의 수를 갱신
			} else if (curCell.level == maxLevel) {
				maxCount++;
			}
		}
		
		// 가장 많이 부숴야 하는 울타리의 수 및 그때 얻을 수 있는 꽃의 수를 저장한 배열을 반환
		return new int[] {maxLevel, maxCount};
	}
	
	// ----------------------------------------------------------------------------------------------------

	// borderChecker() 메서드 정의
	public static void borderChecker(int row, int column) {
		
		// offer() 메서드를 사용해 해당 테두리 칸의 정보를 cellList에 추가 후 확인 처리
		cellList.offer(new Cell(row, column, (garden[row][column]) ? 1 : 0));
		checked[row][column] = true;
	}
}