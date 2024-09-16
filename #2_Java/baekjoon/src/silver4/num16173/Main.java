package silver4.num16173;

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
	
	// 게임 구역의 크기를 저장할 변수 size 초기화
	static int size;
	
	// '쩰리'가 이동 가능한 방향을 나타낼 각 델타 배열 초기화
	static int[] dr = {1, 0};
	static int[] dc = {0, 1};
	
	// 게임판의 구역을 저장할 2차원 배열 map 초기화
	static int[][] map;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 게임 구역의 크기를 변수 size에 할당
		size = Integer.parseInt(in.readLine());
		
		// 게임판의 구역을 저장할 2차원 배열 map 초기화
		map = new int[size][size];
		
		// for 반복문을 사용해 게임판의 각 행을 순회
		for (int r = 0; r < size; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 입력 받은 게임판의 숫자를 2차원 배열 map에 저장
			for (int c = 0; c < size; c++)
				map[r][c] = Integer.parseInt(st.nextToken());
		}
		
		// gameSimulator() 및 write() 메서드를 사용해 '쩰리'가 끝 점에 도달할 수 있는지 여부를 출력
		out.write(gameSimulator(0, 0));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// gameSimulator() 메서드 정의
	public static String gameSimulator(int startRow, int startCol) {
		
		// 해당 위치로의 이동 여부를 나타낼 2차원 배열 moved 초기화
		boolean[][] moved = new boolean[size][size];
		
		// 다음에 이동할 위치를 저장할 Queue 객체 moveList 초기화
		Queue<int[]> moveList = new LinkedList<>();
		
		// offer() 메서드를 사용해 '쩰리'의 시작 위치를 moveList에 추가 및 이동 처리
		moveList.offer(new int[] {startRow, startCol});
		moved[startRow][startCol] = true;
		
		// while 반복문을 사용해 moveList가 빌 때까지 순회
		while (!moveList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 위치를 배열 curLoc에 할당
			int[] curLoc = moveList.poll();
			
			// 현재 위치가 끝 점인 경우 'HaruHaru' 반환
			if (curLoc[0] == size - 1 && curLoc[1] == size - 1)
				return "HaruHaru";
			
			// for 반복문을 사용해 다음에 이동할 위치를 순회
			for (int d = 0; d < 2; d++) {
				
				// 다음에 이동할 위치를 각 변수에 할당
				int nr = curLoc[0] + dr[d] * map[curLoc[0]][curLoc[1]];
				int nc = curLoc[1] + dc[d] * map[curLoc[0]][curLoc[1]];
				
				// 해당 위치가 범위를 벗어났거나 이미 이동한 적 있는 경우 다음 위치를 순회
				if (nr >= size || nc >= size || moved[nr][nc])
					continue;
				
				// offer() 메서드를 사용해 해당 위치를 moveList에 추가 및 이동 처리
				moveList.offer(new int[] {nr, nc});
				moved[nr][nc] = true;
			}
		}
		
		// '쩰리'가 끝 점에 도달할 수 없는 경우 'Hing' 반환
		return "Hing";
	}
}