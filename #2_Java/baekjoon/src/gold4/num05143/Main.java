package gold4.num05143;

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
	
	// 시모어가 죽지 않고 도달할 수 있는 청어 먹이의 수, 지도의 크기를 저장할 각 변수 초기화
	static int herringCount;
	static int width;
	static int height;
	
	// 시모어의 이동 방향을 저장할 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// 입력 받은 지도의 상태를 저장할 2차원 배열 map 초기화
	static char[][] map;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 데이터 세트의 개수를 변수 dataSet에 할당
		int dataSet = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 데이터 세트를 순회
		for (int ds = 1; ds <= dataSet; ds++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 지도의 크기를 각 변수에 할당
			width = Integer.parseInt(st.nextToken());
			height = Integer.parseInt(st.nextToken());
			
			// 시모어가 죽지 않고 도달할 수 있는 청어 먹이의 수, 시모어의 서식지 위치를 저장할 각 변수 초기화
			herringCount = 0;
			int startRow = -1;
			int startColumn = -1;
			
			// 입력 받은 지도의 상태를 저장할 2차원 배열 map 초기화
			map = new char[height][width];
			
			// for 반복문을 사용해 지도의 각 행을 순회
			for (int r = 0; r < height; r++) {
				
				// readLine() 메서드를 사용해 입력 받은 지도의 행 정보를 변수 row에 할당
				String row = in.readLine();
				
				// for 반복문을 사용해 지도의 각 칸을 순회
				for (int c = 0; c < width; c++) {
					
					// charAt() 메서드를 사용해 입력 받은 지도의 상태를 2차원 배열 map에 저장
					map[r][c] = row.charAt(c);
					
					// 해당 위치가 시모어의 서식지인 경우 해당 위치의 지도의 상태와 시모어 서식지 위치를 갱신
					if (map[r][c] == 'S') {
						map[r][c] = '.';
						startRow = r;
						startColumn = c;
					}
				}
			}
			
			// herringFinder() 메서드를 호출해 시모어가 죽지 않고 도달할 수 있는 청어 먹이의 수를 갱신
			herringFinder(startRow, startColumn);
			
			// format() 및 write() 메서드를 사용해 데이터 세트의 번호와 시모어가 죽지 않고 도달할 수 있는 청어 먹이의 수를 출력
			out.write(String.format("Data Set %d:\n%d\n", ds, herringCount));
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// herringFinder() 메서드 정의
	public static void herringFinder(int startRow, int startColumn) {
		
		// 지나갈 수 있는 검은 기름 칸의 수에 따른 이동 여부를 저장할 3차원 배열 moved 초기화
		boolean[][][] moved = new boolean[height][width][4];
		
		// 다음에 이동할 위치를 저장할 Queue 객체 moveList 초기화
		Queue<int[]> moveList = new LinkedList<>();
		
		// offer() 메서드를 사용해 시모어의 서식지를 moveList에 추가 및 지나갈 수 있는 검은 기름 칸의 수에 따른 이동 여부를 갱신
		moveList.offer(new int[] {startRow, startColumn, 3});
		moved[startRow][startColumn][3] = true;
		
		// while 반복문을 사용해 moveList가 빌 때까지 순회
		while (!moveList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 위치를 배열 curLocation에 할당
			int[] curLocation = moveList.poll();
			
			// 현재 위치와 지나갈 수 있는 검은 기름 칸의 수를 각 변수에 할당
			int curRow = curLocation[0];
			int curColumn = curLocation[1];
			int curCount = curLocation[2];
			
			// 현재 칸에 청어 먹이가 존재하는 경우 청어 먹이를 제거 후 시모어가 죽지 않고 도달할 수 있는 청어 먹이의 수를 갱신
			if (map[curRow][curColumn] == 'H') {
				map[curRow][curColumn] = '.';
				herringCount++;
			}
			
			// for 반복문을 사용해 현재 위치와 인접한 위치를 순회
			for (int d = 0; d < 4; d++) {
				
				// 해당 위치 및 지나갈 수 있는 검은 기름 칸의 수를 각 변수에 할당
				int nextRow = curRow + dr[d];
				int nextColumn = curColumn + dc[d];
				int nextCount = curCount;
				
				// 해당 위치가 지도의 범위를 벗어나는 경우 다음 위치를 순회
				if (nextRow < 0 || nextRow >= height || nextColumn < 0 || nextColumn >= width)
					continue;
				
				// 해당 위치에 검은 기름이 존재하는 경우
				if (map[nextRow][nextColumn] == 'G') {
					
					// 더 이상 검은 기름을 통과할 수 없는 경우 다음 위치를 순회
					if (curCount == 0)
						continue;
					
					// 지나갈 수 있는 검은 기름 칸의 수를 갱신
					nextCount--;
					
				// 해당 위치에 바다표범을 씻겨 주는 사람이 존재하는 경우 지나갈 수 있는 검은 기름 칸의 수를 갱신
				} else if (map[nextRow][nextColumn] == 'P') {
					nextCount = 3;
				}
				
				// 해당 위치를 이미 이동했던 경우 다음 위치를 순회
				if (moved[nextRow][nextColumn][nextCount])
					continue;
				
				// offer() 메서드를 사용해 해당 위치를 moveList에 추가 및 지나갈 수 있는 검은 기름 칸의 수에 따른 이동 여부를 갱신
				moveList.offer(new int[] {nextRow, nextColumn, nextCount});
				moved[nextRow][nextColumn][nextCount] = true;
			}
		}
	}
}