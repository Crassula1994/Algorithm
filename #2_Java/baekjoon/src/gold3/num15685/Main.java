package gold3.num15685;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 드래곤 커브의 시작 방향을 나타낼 각 델타 배열 초기화
	static int[] dr = {0, -1, 0, 1};
	static int[] dc = {1, 0, -1, 0};
	
	// 드래곤 커브를 그릴 격자의 상태를 저장할 2차원 배열 grid 초기화
	static boolean[][] grid = new boolean[101][101];
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 드래곤 커브의 개수를 변수 curveNum에 할당
		int curveNum = Integer.parseInt(in.readLine());
		
		// 정사각형의 네 꼭짓점이 모두 드래곤 커브의 일부인 것의 개수를 저장할 변수 count 초기화
		int count = 0;
		
		// for 반복문을 사용해 각 드래곤 커브를 순회
		for (int curve = 0; curve < curveNum; curve++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 각 드래곤 커브의 정보를 각 변수에 할당
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			int direction = Integer.parseInt(st.nextToken());
			int generation = Integer.parseInt(st.nextToken());
			
			// 각 드래곤 커브의 방향을 저장할 List 객체 directions 초기화
			List<Integer> directions = new ArrayList<>();
			
			// add() 메서드를 사용해 0단계 드래곤 커브의 방향을 directions에 저장
			directions.add(direction);
			
			// dragonCurveDrawer() 메서드를 호출해 드래곤 커브를 갱신
			dragonCurveDrawer(startX, startY, 1, generation, directions);
		}
		
		// for 반복문을 사용해 격자의 각 정사각형을 순회
		for (int r = 0; r < 100; r++) {
			for (int c = 0; c < 100; c++) {

				// 해당 정사각형의 네 꼭짓점이 모두 드래곤 커브의 일부가 아닌 경우 다음 정사각형을 순회
				if (!grid[r][c] || !grid[r][c + 1] || !grid[r + 1][c] || !grid[r + 1][c + 1])
					continue;
				
				// 정사각형의 네 꼭짓점이 모두 드래곤 커브의 일부인 것의 개수를 갱신
				count++;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 정사각형의 네 꼭짓점이 모두 드래곤 커브의 일부인 것의 개수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// dragonCurveDrawer() 메서드 정의
	public static void dragonCurveDrawer(int startX, int startY, int curGen, int targetGen, List<Integer> directions) {
		
		// 모든 세대의 드래곤 커브를 그린 경우
		if (curGen > targetGen) {
			
			// 출발점의 드래곤 커브 해당 여부를 갱신
			grid[startY][startX] = true;
			
			// 현재 확인 중인 드래곤 커브의 점 좌표를 저장할 각 변수 초기화
			int currentX = startX;
			int currentY = startY;
			
			// for 반복문을 사용해 드래곤 커브의 각 방향을 순회
			for (int direction : directions) {
				
				// 다음 점 좌표를 계산해 각 변수에 할당
				int nextX = currentX + dc[direction];
				int nextY = currentY + dr[direction];
				
				// 다음 점의 드래곤 커브 해당 여부를 갱신
				grid[nextY][nextX] = true;
				
				// 다음 점을 현재 확인 중인 점으로 갱신
				currentX = nextX;
				currentY = nextY;
			}
			
			// 메서드 종료
			return;
		}
		
		// for 반복문을 사용해 전 세대의 각 드래곤 커브의 방향을 시계 방향으로 90도 회전시킨 결과를 다시 directions에 저장
		for (int idx = directions.size() - 1; idx >= 0; idx--)
			directions.add((directions.get(idx) + 1) % 4);
		
		// dragonCurveDrawer() 메서드 재귀 호출
		dragonCurveDrawer(startX, startY, curGen + 1, targetGen, directions);
	}
}