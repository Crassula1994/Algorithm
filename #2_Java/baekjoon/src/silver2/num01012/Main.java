package silver2.num01012;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 배추밭의 배추가 심긴 위치를 저장할 2차원 배열 farmMap 초기화
	static boolean[][] farmMap;
	
	// 배추가 인접해 있는지를 확인하기 위한 델타 배열을 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// 배추밭의 길이를 나타내는 각 변수 초기화
	static int width;
	static int height;

	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());

		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++ ) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 배추밭의 길이, 배추의 개수를 각 변수에 할당
			width = Integer.parseInt(st.nextToken());
			height = Integer.parseInt(st.nextToken());
			int napaCabbages = Integer.parseInt(st.nextToken());
			
			// 배추밭의 배추가 심긴 위치를 저장할 2차원 배열 farmMap 초기화
			farmMap = new boolean[height][width];
			
			// for 반복문을 사용해 각 배추의 위치를 순회
			for (int cab = 0; cab < napaCabbages; cab++) {
				
				// StringTokenizer 객체를 불러와 변수 st에 재할당
				st = new StringTokenizer(in.readLine());
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 배추의 위치를 각 변수에 할당
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				// 배추의 위치를 배열 farmMap에 표시
				farmMap[y][x] = true;
			}
			
			// 필요한 최소의 배추흰지렁이 마리 수를 저장할 변수 minWorm 초기화
			int minWorm = 0;
			
			// for 반복문을 사용해 배추밭의 각 행과 열을 순회
			for (int r = 0; r < height; r++) {
				for (int  c = 0; c < width; c++) {
					
					// 배추가 심긴 경우
					if (farmMap[r][c]) {
						
						// contiguityChecker() 메서드를 호출해 인접한 배추를 확인 처리
						contiguityChecker(r, c);
						
						// 배추흰지렁이 마리 수를 갱신
						minWorm++;
					}
				}
			}
			
			// write() 메서드를 사용해 배추흰지렁이 마리 수를 출력
			out.write(minWorm + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// contiguityChecker() 메서드 정의
	public static void contiguityChecker(int startRow, int startCol) {
		
		// 현재의 배추를 확인 처리
		farmMap[startRow][startCol] = false;
		
		// for 반복문을 사용하여 델타 배열을 순회
		for (int d = 0; d < 4; d++) {
			
			// 인접한 새로운 위치를 각 변수에 할당
			int nr = startRow + dr[d];
			int nc = startCol + dc[d];
			
			// 인접한 위치가 배열을 벗어나지 않으면서 배추가 심긴 경우 contiguityChecker() 메서드 재귀 호출
			if (nr >= 0 && nr < height && nc >= 0 && nc < width && farmMap[nr][nc])
				contiguityChecker(nr, nc);
		}
	}
}