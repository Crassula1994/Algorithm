package unrated.num01949;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// Solution 클래스 정의
public class Solution {

	// 지도의 크기와 최대 공사 가능 깊이, 만들 수 있는 가장 긴 등산로의 길이를 저장할 각 변수 초기화
	static int size;
	static int maxDepth;
	static int maxLength;
	
	// 지도 정보 및 방문 여부를 저장할 각 2차원 배열 초기화
	static int[][] map;
	static int[][] visited;
	
	// 인접한 지형의 위치를 저장할 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// Location 클래스 정의
	public static class Location {
		
		// 각 행과 열의 위치를 나타낼 변수 초기화
		int row;
		int col;
		
		// 매개변수를 입력 받는 생성자 정의
		public Location(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());

		// for 반복문을 사용해 각 테스트 케이스를 순회
		for(int tc = 1; tc <= testCase; tc++) {

			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());

			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 지도의 크기와 최대 공사 가능 깊이를 각 변수에 할당
			size = Integer.parseInt(st.nextToken());
			maxDepth = Integer.parseInt(st.nextToken());

			// 지도 정보를 저장할 2차원 배열 map 초기화
			map = new int[size][size];
			
			// 가장 높은 봉우리의 위치를 저장할 Queue 객체 peakList 초기화
			Queue<Location> peakList = new LinkedList<>();
			
			// 지형의 최대 높이를 저장할 변수 maxHeight 초기화
			int maxHeight = 0;
        	
			// for 반복문을 사용해 배열 map의 각 행을 순회
			for (int r = 0; r < size; r++) {
				
				// StringTokenizer 객체를 불러와 변수 st에 재할당
				st = new StringTokenizer(in.readLine());
				
				// for 반복문을 사용해 배열 map의 각 열을 순회
				for (int c = 0; c < size; c++) {
					
					// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 지도의 정보를 배열 map에 저장
					map[r][c] = Integer.parseInt(st.nextToken());
					
					// 해당 높이가 최대 높이인 경우
					if (map[r][c] > maxHeight) {
						
						// 최대 높이를 갱신
						maxHeight = map[r][c];
						
						// 가장 높은 봉우리의 위치를 저장할 Queue 객체 peakList 초기화
						peakList = new LinkedList<>();
						
						// offer() 메서드를 사용해 해당 위치를 peakList에 추가
						peakList.offer(new Location(r, c));
						
					// 해당 높이가 최대 높이와 같은 경우 해당 위치를 peakList에 추가
					} else if (map[r][c] == maxHeight) {
						peakList.offer(new Location(r, c));
					}
				}
			}

			// 만들 수 있는 가장 긴 등산로의 길이를 저장할 변수 maxLength 초기화
			maxLength = Integer.MIN_VALUE;
			
			// while 반복문을 사용해 peakList가 빌 때까지 순회
			while (!peakList.isEmpty()) {
				
				// poll() 메서드를 사용해 가장 높은 봉우리의 위치를 변수 startLoc에 할당
				Location startLoc = peakList.poll();
				
				// 방문 여부를 저장할 2차원 배열 visited 초기화
				visited = new int[size][size];
			
				// trailFinder() 메서드를 호출해 만들 수 있는 가장 긴 등산로의 길이를 갱신
				trailFinder(startLoc, 1, false);
			}

			// write() 메서드를 사용해 만들 수 있는 가장 긴 등산로의 길이를 출력
			out.write("#" + tc + " " + maxLength + "\n");
		}	

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// trailFinder() 메서드 정의
	public static void trailFinder(Location currentLoc, int length, boolean constructed) {
		
		// 방문한 위치 방문 처리
		visited[currentLoc.row][currentLoc.col] = length;
		
		// 현재 위치의 높이를 변수 curentHeight에 할당
		int currentHeight = map[currentLoc.row][currentLoc.col];
		
		// for 반복문을 사용해 인접한 위치 순회
		for (int d = 0; d < 4; d++) {
			
			// 새로운 위치를 각 변수에 할당
			int nr = currentLoc.row + dr[d];
			int nc = currentLoc.col + dc[d];
			
			// 해당 위치가 지도의 범위를 벗어났거나 방문한 위치인 경우 다음 위치를 순회
			if (nr < 0 || nr >= size || nc < 0 || nc >= size || visited[nr][nc] != 0)
				continue;
			
			// 다음 위치의 좌표 및 다음 위치의 높이를 각 변수에 할당
			Location nextLoc = new Location(nr, nc);
			int nextHeight = map[nr][nc];
			
			// 해당 위치가 현재 높이보다 낮은 경우
			if (nextHeight < currentHeight) {
				
				// trailFinder() 메서드 재귀 호출
				trailFinder(nextLoc, length + 1, constructed);
				
			// 공사를 통해 해당 위치의 높이보다 높거나 같지만, 공사를 하지 않은 경우
			} else if (nextHeight - maxDepth < currentHeight && !constructed) {
				
				// 공사를 한 것으로 처리
				map[nr][nc] = currentHeight - 1;
				
				// trailFinder() 메서드 재귀 호출
				trailFinder(nextLoc, length + 1, true);
				
				// 공사를 하지 않은 것으로 처리
				map[nr][nc] = nextHeight;
			}
		}
		
		// max() 메서드를 사용해 가장 긴 등산로의 길이를 갱신
		maxLength = Math.max(length, maxLength);
		
		// 방문한 위치 원상 복구
		visited[currentLoc.row][currentLoc.col] = 0;
	}
}