package level1.num172928;

// 필요한 패키지 불러오기
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// Solution 클래스 정의
public class Solution {
	
	// 각 이동 방향을 나타낼 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// ----------------------------------------------------------------------------------------------------
	
	// solution() 메서드 정의
	public static int[] solution(String[] park, String[] routes) {
		
		// 공원의 가로 길이와 세로 길이를 각 변수에 할당
		int height = park.length;
		int width = park[0].length();
		
		// 로봇 강아지의 현재 위치를 저장할 각 변수 초기화
		int curRow = -1;
		int curCol = -1;
		
		// 공원의 상태를 저장할 2차원 배열 map 초기화
		char[][] map = new char[height][width];
		
		// for 반복문을 사용해 해당 공원의 상태를 순회
		for (int r = 0; r < height; r++) {
			for (int c = 0; c < width; c++) {
				
				// charAt() 메서드를 사용해 해당 공원의 상태를 2차원 배열 map에 저장
				map[r][c] = park[r].charAt(c);
				
				// 해당 위치가 로봇 강아지의 시작 위치인 경우 로봇 강아지의 현재 위치를 갱신
				if (map[r][c] == 'S') {
					curRow = r;
					curCol = c;
				}
			}
		}
		
		// 이동 방향을 저장할 Map 객체 directions 초기화
		Map<String, Integer> directions = new HashMap<>();
		
		// put() 메서드를 사용해 이동 방향을 directions에 저장
		directions.put("N", 0);
		directions.put("S", 1);
		directions.put("W", 2);
		directions.put("E", 3);
		
		// for 반복문을 사용해 각 명령을 순회
		outer: for (String route : routes) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(route);
			
			// nextToken(), get(), parseInt() 메서드를 사용해 이동 방향과 이동 거리를 각 변수에 할당
			int direction = directions.get(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			
			// for 반복문을 사용해 이동할 거리를 차례로 순회
			for (int m = 1; m <= distance; m++) {
				
				// 이동할 위치를 각 변수에 할당
				int nr = curRow + dr[direction] * m;
				int nc = curCol + dc[direction] * m;
				
				// 해당 위치가 범위를 벗어나는 경우 다음 명령을 순회
				if (nr < 0 || nr >= height || nc < 0 || nc >= width)
					continue outer;
				
				// 해당 위치가 장애물인 경우 다음 명령을 순회
				if (map[nr][nc] == 'X')
					continue outer;
			}
			
			// 로봇 강아지를 명령에 따라 이동 처리
			curRow += dr[direction] * distance;
			curCol += dc[direction] * distance;
		}
		
		// 로봇 강아지가 명령을 수행 후 놓인 위치를 저장한 배열 반환
        return new int[] {curRow, curCol};
    }
}