package silver1.num02468;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 지역의 크기를 저장할 변수 size 초기화
	static int size;
	
	// 지도의 상태 및 안전한 영역인지 여부를 저장할 각 2차원 배열 초기화
	static int[][] map;
	static boolean[][] isSafe;
	
	// 인접한 위치를 탐색할 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 지역의 크기를 변수 size에 할당
		size = Integer.parseInt(in.readLine());
		
		// 지도의 상태를 저장할 2차원 배열 map 초기화
		map = new int[size][size];
		
		// 해당 지역의 최소 높이와 최대 높이를 저장할 각 변수 초기화
		int minHeight = Integer.MAX_VALUE;
		int maxHeight = Integer.MIN_VALUE;
		
		// for 반복문을 사용해 배열 map의 각 행을 순회
		for (int r = 0; r < size; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 배열 map의 각 열을 순회
			for (int c = 0; c < size; c++) {
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 지역의 높이를 배열 map에 저장
				map[r][c] = Integer.parseInt(st.nextToken());
				
				// min() 및 max() 메서드를 사용해 해당 지역의 최소 높이와 최대 높이를 갱신
				minHeight = Math.min(map[r][c], minHeight);
				maxHeight = Math.max(map[r][c], maxHeight);
			}
		}
		
		// 안전한 영역의 최대 개수를 저장할 변수 maxCnt 초기화
		int maxCnt = 1;
		
		// for 반복문을 사용해 최소 높이부터 최대 높이까지 물의 높이를 갱신
		for (int height = minHeight; height < maxHeight; height++) {
			
			// 안전한 영역인지 여부를 저장할 2차원 배열 isSafe 초기화
			isSafe = new boolean[size][size];
			
			// for 반복문을 사용해 배열 isSafe의 각 행과 열을 순회
			for (int r = 0; r < size; r++) {
				for (int c = 0; c < size; c++) {
					
					// 해당 위치가 물의 높이보다 고도가 높은 경우 안전한 영역인지 여부를 갱신
					if (height < map[r][c])
						isSafe[r][c] = true;
				}
			}
			
			// 해당 물의 높이에서 안전한 영역의 개수를 저장할 변수 count 초기화
			int count = 0;
			
			// for 반복문을 사용해 배열 isSafe의 각 행과 열을 순회
			for (int r = 0; r < size; r++) {
				for (int c = 0; c < size; c++) {
					
					// 해당 위치가 안전한 영역인 경우 
					if (isSafe[r][c]) {
						
						// 해당 물의 높이에서 안전한 영역의 개수를 갱신
						count++;
						
						// safeAreaCounter() 메서드를 호출해 안전한 영역의 개수를 갱신
						safeAreaCounter(r, c);
					}
				}
			}
			
			// max() 메서드를 사용해 해전한 영역의 최대 개수를 갱신
			maxCnt = Math.max(count, maxCnt);	
		}
			
		// valueOf() 및 write() 메서드를 사용해 장마철에 물에 잠기지 않는 안전한 영역의 최대 개수를 출력
		out.write(String.valueOf(maxCnt));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// safeAreaCounter() 메서드 정의
	public static void safeAreaCounter(int row, int column) {
		
		// 해당 위치를 방문 처리
		isSafe[row][column] = false;
		
		// for 반복문을 사용해 인접한 위치를 순회
		for (int d = 0; d < 4; d++) {
			
			// 새로운 인접한 위치를 각 변수에 할당
			int nr = row + dr[d];
			int nc = column + dc[d];
			
			// 해당 위치가 범위를 벗어난 경우 다음 위치를 순회
			if (nr < 0 || nr >= size || nc < 0 || nc >= size)
				continue;
			
			// 해당 위치가 안전한 영역인 경우 safeAreaCounter() 메서드 재귀 호출
			if (isSafe[nr][nc])
				safeAreaCounter(nr, nc);
		}
	}
}