package gold2.num14474;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// JOI 칼데라 땅의 크기를 저장할 각 변수 초기화
	static int height;
	static int width;
	
	// 인접한 위치를 나타낼 각 델타 배열, 각 고도의 위치를 나타낼 각 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[] altR;
	static int[] altC;
	
	// JOI 칼데라 땅의 고도와 해당 지역에 비가 내렸을 때 물이 고이는 고도를 저장할 각 2차원 배열 초기화
	static int[][] altitudes;
	static int[][] calderas;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 JOI 칼데라 땅의 크기를 각 변수에 할당
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		
		// 능선의 개수를 저장할 변수 ridgeCount 초기화
		int ridgeCount = 0;
		
		// 각 고도의 위치를 저장할 각 배열 초기화
		altR = new int[height * width + 1];
		altC = new int[height * width + 1];
		
		// JOI 칼데라 땅의 고도와 해당 지역에 비가 내렸을 때 물이 고이는 고도를 저장할 각 2차원 배열 초기화
		altitudes = new int[height][width];
		calderas = new int[height][width];
		
		// for 반복문을 사용해 JOI 칼데라 땅 남북의 각 칸을 순회
		for (int r = 0; r < height; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 JOI 칼데라 땅의 각 칸을 순회
			for (int c = 0; c < width; c++) {
				
				// nextToken() 및 parseInt() 메서드를 사용해 해당 칸의 고도를 2차원 배열 altitudes에 저장
				altitudes[r][c] = Integer.parseInt(st.nextToken());
				
				// 해당 고도의 위치를 각 배열에 저장
				altR[altitudes[r][c]] = r;
				altC[altitudes[r][c]] = c;
			}
		}
		
		// for 반복문을 사용해 각 고도를 순회
		for (int altitude = 1; altitude <= height * width; altitude++) {
			
			// 해당 고도의 위치 및 물이 고이는 고도를 저장할 각 변수 초기화
			int curR = altR[altitude];
			int curC = altC[altitude];
			int caldera = 0;
			
			// for 반복문을 사용해 각 인접한 위치를 순회
			for (int d = 0; d < 4; d++) {
				
				// 인접한 위치를 각 변수에 할당
				int nextR = curR + dr[d];
				int nextC = curC + dc[d];
				
				// 해당 위치가 JOI 칼데라 땅의 범위를 벗어난 경우 다음 위치를 순회
				if (nextR < 0 || nextR >= height || nextC < 0 || nextC >= width)
					continue;
				
				// 해당 위치로 물이 흘러갈 수 없는 경우 다음 위치를 순회
				if (altitudes[nextR][nextC] > altitude)
					continue;
				
				// 현재 위치의 물이 고이는 고도를 아직 찾지 못한 경우 해당 위치의 물이 고이는 고도로 이를 갱신
				if (caldera == 0) {
					caldera = calderas[nextR][nextC];
				
				// 현재 위치의 물이 고이는 고도를 이미 찾았으나, 다른 물이 고이는 고도가 있는 경우 물이 고이는 고도를 -1로 갱신
				} else if (caldera != calderas[nextR][nextC]) {
					caldera = -1;
				}
			}
			
			// 해당 위치가 물이 고이는 곳인지에 따라 해당 위치의 물이 고이는 고도를 갱신
			calderas[curR][curC] = (caldera == 0) ? altitude : caldera;
			
			// 해당 위치가 능선인 경우 능선의 개수를 갱신
			if (caldera == -1)
				ridgeCount++;
		}

		// valueOf() 및 write() 메서드를 사용해 능선의 개수를 출력
		out.write(String.valueOf(ridgeCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}