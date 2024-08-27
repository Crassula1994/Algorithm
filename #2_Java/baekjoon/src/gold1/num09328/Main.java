package gold1.num09328;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 지도의 높이와 너비를 저장할 각 변수 초기화
	static int height;
	static int width;
	
	// 인접한 위치, 상근이가 가지고 있는 열쇠를 저장할 각 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean[] hasKey;
	
	// 지도의 상태를 저장할 2차원 배열 map 초기화
	static char[][] map;
	
	// ----------------------------------------------------------------------------------------------------
	
	// Location 클래스 정의
	static class Location {
		
		// 빌딩에서의 위치를 저장할 각 변수 초기화
		int row;
		int column;
		
		// 매개변수를 입력 받는 생성자 정의
		public Location(int row, int column) {
			this.row = row;
			this.column = column;
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
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 지도의 높이와 너비를 각 변수에 할당
			height = Integer.parseInt(st.nextToken());
			width = Integer.parseInt(st.nextToken());
			
			// 상근이가 가지고 있는 열쇠를 저장할 배열 hasKey 초기화
			hasKey = new boolean[26];
			
			// 지도의 상태를 저장할 2차원 배열 map 초기화
			map = new char[height + 2][width + 2];
			
			// for 반복문을 사용해 2차원 배열 map을 초기화
			for (int r = 0; r < height + 2; r++)
				Arrays.fill(map[r], '.');
			
			// for 반복문을 사용해 지도의 각 행을 순회
			for (int r = 1; r <= height; r++) {
				
				// readLine() 메서드를 사용해 입력 받은 지도의 행의 상태를 변수 line에 할당
				String line = in.readLine();
				
				// for 반복문을 사용해 입력 받은 지도의 상태를 2차원 배열 map에 저장
				for (int c = 1; c <= width; c++)
					map[r][c] = line.charAt(c - 1);
			}
			
			// readLine() 메서드를 사용해 가지고 있는 열쇠를 변수 keys에 저장
			String keys = in.readLine();
			
			// 열쇠를 하나 이상 가지고 있는 경우
			if (keys.charAt(0) != '0') {
			
				// for 반복문을 사용해 각 열쇠의 보유 현황을 갱신
				for (int idx = 0; idx < keys.length(); idx++)
					hasKey[keys.charAt(idx) - 'a'] = true;
			}
			
			// documentStealer() 메서드를 호출해 상근이가 훔칠 수 있는 문서의 최대 개수를 변수 maxCount에 할당
			int maxCount = documentStealer();
			
			// write() 메서드를 사용해 상근이가 훔칠 수 있는 문서의 최대 개수를 출력
			out.write(maxCount + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// documentStealer() 메서드 정의
	public static int documentStealer() {
		
		// 상근이가 훔칠 수 있는 문서의 최대 개수를 저장할 변수 maxCount 초기화
		int maxCount = 0;
		
		// 상근이가 확인한 곳을 저장할 2차원 배열 checked 초기화
		boolean[][] checked = new boolean[height + 2][width + 2];
		
		// 열쇠 없이 들어가지 못한 문의 위치를 저장할 Map 객체 lockedDoors 초기화
		Map<Integer, List<Location>> lockedDoors = new HashMap<>();
		
		// 상근이가 다음에 확인할 위치를 저장할 Queue 객체 checkList 초기화
		Queue<Location> checkList = new LinkedList<>();
		
		// offer() 메서드를 사용해 시작 위치를 checkList에 추가 및 확인 처리
		checkList.offer(new Location(0, 0));
		checked[0][0] = true;
		
		// while 반복문을 사용해 checkList가 빌 때까지 순회
		while (!checkList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 확인 중인 위치를 변수 curLocation에 할당
			Location curLocation = checkList.poll();
			
			// for 반복문을 사용해 각 인접한 위치를 순회
			for (int d = 0; d < 4; d++) {
				
				// 인접한 위치를 각 변수에 할당
				int nr = curLocation.row + dr[d];
				int nc = curLocation.column + dc[d];
				
				// 해당 위치가 지도의 범위를 벗어나는 경우 다음 위치를 순회
				if (nr < 0 || nr > height + 1 || nc < 0 || nc > width + 1)
					continue;
				
				// 해당 위치를 이미 확인했거나 벽인 경우 다음 위치를 순회
				if (checked[nr][nc] || map[nr][nc] == '*')
					continue;
				
				// 해당 위치에 상근이가 훔쳐야 하는 문서가 있는 경우 훔칠 수 있는 문서의 최대 개수를 갱신
				if (map[nr][nc] == '$') {
					maxCount++;
					
				// 해당 위치에 열쇠가 있는 경우
				} else if (map[nr][nc] >= 'a') {
					
					// 해당 열쇠의 알파벳을 변수 alphabet에 할당
					int alphabet = map[nr][nc] - 'a';
					
					// 해당 열쇠를 처음으로 줍는 경우
					if (!hasKey[alphabet]) {
						
						// 해당 열쇠의 보유 여부를 갱신
						hasKey[alphabet] = true;
						
						// 해당 열쇠로 새롭게 열 수 있는 문이 있는 경우
						if (lockedDoors.containsKey(alphabet)) {
							
							// for 반복문을 사용해 해당 문의 위치를 checkList에 추가 및 확인 처리
							for (Location door : lockedDoors.get(alphabet)) {
								checkList.offer(door);
								checked[door.row][door.column] = true;
							}
						}
					}
				
				// 해당 위치가 문인 경우
				} else if (map[nr][nc] >= 'A') {
					
					// 해당 문의 알파벳을 변수 alphabet에 할당
					int alphabet = map[nr][nc] - 'A';
					
					// 열쇠가 존재하지 않는 경우
					if (!hasKey[alphabet]) {
						
						// putIfAbsent(), get(), add() 메서드를 사용해 해당 알파벳의 문 위치를 lockedDoors에 저장
						lockedDoors.putIfAbsent(alphabet, new ArrayList<>());
						lockedDoors.get(alphabet).add(new Location(nr, nc));
						
						// 다음 위치를 순회
						continue;
					}
				}
				
				// offer() 메서드를 사용해 해당 위치를 checkList에 추가 및 확인 처리
				checkList.offer(new Location(nr, nc));
				checked[nr][nc] = true;
			}
		}
		
		// 상근이가 훔칠 수 있는 문서의 최대 개수를 반환
		return maxCount;
	}
}