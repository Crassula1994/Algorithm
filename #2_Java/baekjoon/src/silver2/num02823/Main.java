package silver2.num02823;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 마을의 크기를 저장할 각 변수 초기화
	static int height;
	static int width;
	
	// 연결된 방향을 저장할 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// 마을의 지도를 저장할 2차원 배열 map 초기화
	static char[][] map;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 마을의 크기를 각 변수에 할당
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		
		// 마을의 지도를 저장할 2차원 배열 map 초기화
		map = new char[height][width];
		
		// for 반복문을 사용해 입력 받은 마을의 지도를 2차원 배열 map에 저장
		for (int r = 0; r < height; r++)
			map[r] = in.readLine().toCharArray();
		
		// deadEndFinder(), valueOf(), write() 메서드를 사용해 마을에 막다른 길이 존재하는지 여부를 출력
		out.write(String.valueOf(deadEndFinder()));
			
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// deadEndFinder() 메서드 정의
	public static int deadEndFinder() {
		
		// for 반복문을 사용해 마을의 각 칸을 순회
		for (int r = 0; r < height; r++) {
			for (int c = 0; c < width; c++) {
				
				// 해당 위치가 빌딩인 경우 다음 위치를 순회
				if (map[r][c] == 'X')
					continue;
				
				// 해당 길이 다른 길과 연결된 방향의 개수를 저장할 변수 count 초기화
				int count = 0;
				
				// for 반복문을 사용해 연결된 각 위치를 순회
				for (int d = 0; d < 4; d++) {
					
					// 연결된 위치를 각 변수에 할당
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					// 해당 위치가 범위를 벗어난 경우 다음 위치를 순회
					if (nr < 0 || nr >= height || nc < 0 || nc >= width)
						continue;
					
					// 해당 위치가 빌딩인 경우 다음 위치를 순회
					if (map[nr][nc] == 'X')
						continue;
					
					// 해당 길이 다른 길과 연결된 방향의 개수를 갱신
					count++;
				}
				
				// 해당 길이 다른 길과 연결된 방향의 개수가 2개 미만인 경우 막다른 길이므로 1을 반환
				if (count < 2)
					return 1;
			}
		}
		
		// 마을에 막다른 길이 존재하지 않는 경우 0을 반환
		return 0;
	}
}