package gold4.num14502;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 지도의 크기, 안전 영역 크기의 최댓값을 나타낼 각 변수 초기화
	static int height;
	static int width;
	static int maxSize = Integer.MIN_VALUE;
	
	// 인접한 위치를 나타낼 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// 지도의 모양을 저장할 2차원 배열 map 초기화
	static int[][] map;
	
	// 벽을 세울 수 있는 위치, 바이러스의 초기 위치를 저장할 각 List 객체 p초기화
	static List<int[]> proposedSite = new ArrayList<>();
	static List<int[]> virusLoc = new ArrayList<>();
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 지도의 크기를 각 변수에 할당
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		
		// 지도의 모양을 저장할 2차원 배열 map 초기화
		map = new int[height][width];
		
		// for 반복문을 사용해 2차원 배열 map의 각 행을 순회
		for (int r = 0; r < height; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 2차원 배열 map의 각 열을 순회
			for (int c = 0; c < width; c++) {
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 지도의 모양을 2차원 배열 map에 저장
				map[r][c] = Integer.parseInt(st.nextToken());
				
				// 해당 위치가 빈 칸인 경우 proposedSite에 해당 위치를 추가
				if (map[r][c] == 0) {
					proposedSite.add(new int[] {r, c});
				
				// 해당 위치가 바이러스인 경우 virusLoc에 해당 위치를 추가
				} else if (map[r][c] == 2) {
					virusLoc.add(new int[] {r, c});
				}
			}
		}
		
		// 벽을 건설하기로 선택한 위치를 저장할 2차원 배열 selected 초기화
		Integer[][] selected = new Integer[3][2];
		
		// wallBuilder() 메서드를 호출해 안전 영역 크기의 최댓값을 갱신
		wallBuilder(0, 0, selected);
		
		// valueOf() 및 wirte() 메서드를 사용해 안전 영역 크기의 최댓값을 출력
		out.write(String.valueOf(maxSize));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// wallBuilder() 메서드 정의
	public static void wallBuilder(int startIdx, int wallCnt, Integer[][] selected) {
		
		// 세 개의 벽을 세울 위치를 모두 선택한 경우
		if (wallCnt == 3) {
			
			// 저장된 지도의 모양을 복사해 저장할 배열 mapCopied 초기화
			int[][] mapCopied = new int[height][width];
			
			// for 반복문을 사용해 지도의 모양을 복사해 배열 mapCopied에 저장
			for (int r = 0; r < height; r++)
				mapCopied[r] = map[r].clone();
			
			// for 반복문을 사용해 벽을 세울 위치에 벽을 세우기
			for (int idx = 0; idx < 3; idx++)
				mapCopied[selected[idx][0]][selected[idx][1]] = 1;
			
			// 다음에 바이러스가 퍼질 위치를 저장할 Queue 객체 spreadList 초기화
			Queue<int[]> spreadList = new LinkedList<>();
			
			// for 반복문을 사용해 바이러스의 초기 위치를 spreadList에 추가
			for (int idx = 0; idx < virusLoc.size(); idx++)
				spreadList.offer(new int[] {virusLoc.get(idx)[0], virusLoc.get(idx)[1]});
			
			// while 반복문을 사용해 spreadList가 빌 때까지 순회
			while (!spreadList.isEmpty()) {
				
				// poll() 메서드를 사용해 현재 위치를 배열 currentLoc에 할당
				int[] currentLoc = spreadList.poll();
				
				// for 반복문을 사용해 인접한 위치를 순회
				for (int d = 0; d < 4; d++) {
					
					// 인접한 위치를 나타내는 각 변수에 할당
					int nr = currentLoc[0] + dr[d];
					int nc = currentLoc[1] + dc[d];
					
					// 해당 위치가 범위를 벗어난 경우 다음 위치를 순회
					if (nr < 0 || nr >= height || nc < 0 || nc >= width)
						continue;
					
					// 해당 위치가 벽이거나 이미 바이러스가 퍼진 위치인 경우 다음 위치를 순회
					if (mapCopied[nr][nc] != 0)
						continue;
					
					// offer() 메서드를 사용해 해당 위치를 spreadList에 추가 및 감염 처리
					spreadList.offer(new int[] {nr, nc});
					mapCopied[nr][nc] = 2;
				}
			}
			
			// safeAreaCounter() 메서드를 호출해 안전 영역의 개수를 변수 count에 할당
			int count = safeAreaCounter(mapCopied);
			
			// max() 메서드를 사용해 안전 영역 크기의 최댓값을 갱신
			maxSize = Math.max(count, maxSize);
			
			// 메서드 종료
			return;
		}
		
		// for 반복문을 사용해 각 빈 칸을 순회
		for (int idx = startIdx; idx < proposedSite.size(); idx++) {
			
			// get() 메서드를 사용해 해당 빈 칸을 선택 처리
			selected[wallCnt][0] = proposedSite.get(idx)[0];
			selected[wallCnt][1] = proposedSite.get(idx)[1];
			
			// wallBuilder() 메서드 재귀 호출
			wallBuilder(idx + 1, wallCnt + 1, selected);
			
			// 해당 빈 칸을 원상 복구
			selected[wallCnt][0] = null;
			selected[wallCnt][1] = null;			
		}
	}

	// ----------------------------------------------------------------------------------------------------
	
	// safeAreaCounter() 메서드 정의
	public static int safeAreaCounter(int[][] mapCopied) {
		
		// 안전 영역의 개수를 저장할 변수 count 초기화
		int count = 0;
		
		// for 반복문을 사용해 2차원 배열 mapCopied의 각 행과 열을 순회
		for (int r = 0; r < height; r++) {
			for (int c = 0; c < width; c++) {
				
				// 해당 위치가 안전 영역인 경우 안전 영역의 개수 갱신
				if (mapCopied[r][c] == 0)
					count++;
			}
		}
		
		// 안전 영역의 개수를 반환
		return count;
	}
}