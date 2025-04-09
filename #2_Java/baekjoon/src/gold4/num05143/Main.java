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
		
		// 해당 위치까지 이동하기 위해 지나야 하는 검은 기름 칸의 수를 저장할 2차원 배열 blackGoops 초기화
		Integer[][] blackGoops = new Integer[height][width];
		
		// 다음에 이동할 위치를 저장할 Queue 객체 moveList 초기화
		Queue<int[]> moveList = new LinkedList<>();
		
		// offer() 메서드를 사용해 시모어의 서식지를 moveList에 추가 및 서식지에서 지나야 하는 검은 기름 칸의 수를 갱신
		moveList.offer(new int[] {startRow, startColumn});
		blackGoops[startRow][startColumn] = 0;
		
		// while 반복문을 사용해 moveList가 빌 때까지 순회
		while (!moveList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 위치를 배열 curLocation에 할당
			int[] curLocation = moveList.poll();
			
			// 현재 위치를 각 변수에 할당
			int cr = curLocation[0];
			int cc = curLocation[1];
			
			// for 반복문을 사용해 현재 위치와 인접한 위치를 순회
			for (int d = 0; d < 4; d++) {
				
				// 해당 위치를 각 변수에 할당
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				// 해당 위치가 지도의 범위를 벗어나는 경우 다음 위치를 순회
				if (nr < 0 || nr >= height || nc < 0 || nc >= width)
					continue;
				
				// 해당 위치를 더 방문할 수 없는 경우
				if (map[nr][nc] == 'G' && blackGoops[cr][cc] == 3)
					continue;
				
			}
		}
	}
}