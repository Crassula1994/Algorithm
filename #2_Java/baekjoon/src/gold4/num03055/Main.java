package gold4.num03055;

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
	
	// 지도의 크기를 저장할 각 변수를 초기화
	static int rowNum;
	static int colNum;
	
	// 지도의 상태를 저장할 2차원 배열 map 초기화
	static char[][] map;
	
	// 인접한 위치를 탐색할 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// 물의 위치를 저장할 Queue 객체 floodedArea 초기화
	static Queue<int[]> floodedArea = new LinkedList<>();
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 각 지도의 크기를 각 변수에 할당
		rowNum = Integer.parseInt(st.nextToken());
		colNum = Integer.parseInt(st.nextToken());
		
		// 지도의 상태를 저장할 2차원 배열 map 초기화
		map = new char[rowNum][colNum];
		
		// 고슴도치의 시작 위치를 저장할 배열 startLoc 초기화
		int[] startLoc = new int[2];
		
		// for 반복문을 사용해 지도의 각 행을 순회
		for (int r = 0; r < rowNum; r++) {
			
			// readLine() 메서드를 사용해 해당 행의 상태를 변수 line에 할당
			String line = in.readLine();
			
			// for 반복문을 사용해 지도의 각 열을 순회
			for (int c = 0; c < colNum; c++) {
				
				// charAt() 메서드를 사용해 해당 위치의 상태를 배열 map에 저장
				map[r][c] = line.charAt(c);
				
				// 해당 위치가 고슴도치의 시작 위치인 경우
				if (map[r][c] == 'S') {
					
					// 해당 위치를 배열 startLoc에 저장
					startLoc[0] = r;
					startLoc[1] = c;
					
					// 해당 위치를 비어있는 곳으로 갱신
					map[r][c] = '.';
					
				// 해당 위치가 물이 차 있는 지역인 경우
				} else if (map[r][c] == '*') {
					
					// offer() 메서드를 사용해 floodedArea에 물이 차 있는 지역을 추가
					floodedArea.offer(new int[] {r, c});
				}
			}
		}
		
		// pathFinder() 메서드를 호출해 고슴도치가 비버의 굴로 이동할 수 있는 가장 빠른 시간을 변수 minTime에 할당
		int minTime = pathFinder(startLoc);
		
		// 고슴도치가 안전하게 비버의 굴로 이동할 수 없는 경우 'KAKTUS' 출력
		if (minTime == -1) {
			out.write("KAKTUS");
			
		// 고슴도치가 안전하게 비버의 굴로 이동할 수 있는 경우 가장 빠른 시간을 출력
		} else {
			out.write(String.valueOf(minTime));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// pathFinder() 메서드 정의
	public static int pathFinder(int[] startLoc) {
		
		// 해당 위치까지의 이동 거리를 저장할 2차원 배열 visited 초기화
		Integer[][] visited = new Integer[rowNum][colNum];
		
		// 고슴도치의 다음 방문 위치를 저장할 Queue 객체 visitList 초기화
		Queue<int[]> visitList = new LinkedList<>();
		
		// offer() 메서드를 사용해 visitList에 고슴도치의 시작 위치를 추가 및 방문 처리
		visitList.offer(startLoc);
		visited[startLoc[0]][startLoc[1]] = 0;
		
		// while 반복문을 사용해 visitList가 빌 때까지 순회
		while (!visitList.isEmpty()) {
			
			// size() 메서드를 사용해 현재 저장된 물이 차 있는 지역의 수를 변수 floodedCnt에 할당
			int floodedCnt = floodedArea.size();
			
			// for 반복문을 사용해 현재 물이 차 있는 지역을 순회
			for (int area = 0; area < floodedCnt; area++) {
				
				// poll() 메서드를 사용해 현재 침수된 지역을 변수 currentArea에 할당
				int[] currentArea = floodedArea.poll(); 
				
				// for 반복문을 사용해 인접한 위치를 순회
				for (int d = 0; d < 4; d++) {
					
					// 새로운 인접한 위치를 각 변수에 할당
					int nr = currentArea[0] + dr[d];
					int nc = currentArea[1] + dc[d];
					
					// 해당 위치가 범위를 벗어난 경우 다음 위치를 순회
					if (nr < 0 || nr >= rowNum || nc < 0 || nc >= colNum)
						continue;
					
					// 해당 위치가 빈 땅인 경우 
					if (map[nr][nc] == '.') {
						
						// offer() 메서드를 사용해 floodedArea에 해당 지역을 추가 및 물이 차 있도록 변경
						floodedArea.offer(new int[] {nr, nc});
						map[nr][nc] = '*';
					}
				}
			}
			
			// size() 메서드를 사용해 현재 고슴도치가 방문할 수 있는 위치의 수를 변수 visitCnt에 할당
			int visitCnt = visitList.size();
			
			// for 반복문을 사용해 현재 고슴도치가 방문할 수 있는 위치를 순회
			for (int loc = 0; loc < visitCnt; loc++) {
				
				// poll() 메서드를 사용해 현재 방문 중인 위치을 변수 currentLoc에 할당
				int[] currentLoc = visitList.poll();
				
				// 해당 위치가 비버의 굴인 경우 해당 위치까지 걸린 시간을 반환
				if (map[currentLoc[0]][currentLoc[1]] == 'D')
					return visited[currentLoc[0]][currentLoc[1]];
				
				// for 반복문을 사용해 인접한 위치를 순회
				for (int d = 0; d < 4; d++) {
				
					// 새로운 인접한 위치를 각 변수에 할당
					int nr = currentLoc[0] + dr[d];
					int nc = currentLoc[1] + dc[d];
					
					// 해당 위치가 범위를 벗어난 경우 다음 위치를 순회
					if (nr < 0 || nr >= rowNum || nc < 0 || nc >= colNum)
						continue;
					
					// 해당 위치가 물이 찬 지역이거나 돌인 경우 다음 위치를 순회
					if (map[nr][nc] == '*' || map[nr][nc] == 'X')
						continue;
					
					// 해당 위치를 방문한 적이 없는 경우
					if (visited[nr][nc] == null) {
						
						// offer() 메서드를 사용해 visitList에 해당 지역을 추가 및 방문 처리
						visitList.offer(new int[] {nr, nc});
						visited[nr][nc] = visited[currentLoc[0]][currentLoc[1]] + 1;
					}
				}
			}			
		}
		
		// 고슴도치가 안전하게 비버의 굴로 이동할 수 없는 경우 -1 반환
		return -1;
	}
}