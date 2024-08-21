package silver2.num07107;

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
	
	// 보드판의 크기를 저장할 각 변수 초기화
	static int rowNum;
	static int colNum;
	
	// 나이트가 이동할 수 있는 위치를 나타낼 각 델타 배열 초기화
	static int[] dr = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] dc = {1, 2, 2, 1, -1, -2, -2, -1};
	
	// 각 위치의 이동 여부를 저장할 2차원 배열 moved 초기화
	static Integer[][] moved;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 보드판의 크기, 목표 칸의 위치를 각 변수에 할당
		rowNum = Integer.parseInt(st.nextToken());
		colNum = Integer.parseInt(st.nextToken());
		int targetRow = Integer.parseInt(st.nextToken());
		int targetCol = Integer.parseInt(st.nextToken());
		
		// 각 위치의 이동 여부를 저장할 2차원 배열 moved 초기화
		moved = new Integer[rowNum + 1][colNum + 1];
		
		// knightMover() 메서드를 호출해 나이트가 목표 칸에 도달할 수 있는 최소 이동 횟수를 변수 minCount에 할당
		int minCount = knightMover(targetRow, targetCol);
		
		// 목표 칸에 도달할 수 없는 경우 'NEVAR' 출력
		if (minCount == -1) {
			out.write("NEVAR");
			
		// 목표 칸에 도달할 수 있는 경우 최소 이동 횟수를 출력
		} else {
			out.write(String.valueOf(minCount));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// knightMover() 메서드 정의
	public static int knightMover(int targetRow, int targetCol) {
		
		// 다음에 이동할 위치를 저장할 Queue 객체 moveList 초기화
		Queue<int[]> moveList = new LinkedList<>();
		
		// offer() 메서드를 사용해 시작 위치를 moveList에 추가 및 이동 처리
		moveList.offer(new int[] {1, 1});
		moved[1][1] = 0;
		
		// while 반복문을 사용해 moveList가 빌 때까지 순회
		while (!moveList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 나이트의 위치를 배열 curLocation에 할당
			int[] curLocation = moveList.poll();
			
			// 현재 위치가 목표 칸인 경우 이동 횟수를 반환
			if (curLocation[0] == targetRow && curLocation[1] == targetCol)
				return moved[curLocation[0]][curLocation[1]];
			
			// for 반복문을 사용해 나이트가 이동할 다음 위치를 순회
			for (int d = 0; d < 8; d++) {
				
				// 나이트가 이동할 다음 위치를 각 변수에 할당
				int nr = curLocation[0] + dr[d];
				int nc = curLocation[1] + dc[d];
				
				// 해당 위치가 보드판의 범위를 벗어나는 경우 다음 위치를 순회
				if (nr > rowNum || nr < 1 || nc > colNum || nc < 1)
					continue;
				
				// 해당 위치를 이미 이동한 적이 있는 경우 다음 위치를 순회
				if (moved[nr][nc] != null)
					continue;
				
				// offer() 메서드를 사용해 다음 이동 위치를 moveList에 추가 및 이동 처리
				moveList.offer(new int[] {nr, nc});
				moved[nr][nc] = moved[curLocation[0]][curLocation[1]] + 1;
			}
		}
		
		// 목표 칸에 도달할 수 없는 경우 -1 반환
		return -1;
	}
}