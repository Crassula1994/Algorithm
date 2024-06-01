package gold3.num15683;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 사무실의 크기, CCTV의 개수, 사각 지대의 최소 크기를 저장할 각 변수 초기화
	static int height;
	static int width;
	static int cameraNum = 0;
	static int minSize = Integer.MAX_VALUE;
	
	// CCTV의 정보와 그 방향의 설정 여부를 저장할 각 배열 초기화
	static Camera[] cameras = new Camera[8];
	static Integer[] directions = new Integer[8];
	
	// CCTV가 바라보는 방향을 나타낼 델타 배열 초기화
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	// 사무실의 상태와 그 사각 지대를 저장할 각 2차원 배열 초기화
	static int[][] office;
	static int[][] blindSpots;
	
	// ----------------------------------------------------------------------------------------------------
	
	// Camera 클래스 정의
	public static class Camera {
		
		// CCTV의 종류와 위치를 저장할 각 변수 초기화
		int category;
		int row;
		int column;
		
		// 매개변수를 입력 받는 생성자 정의
		public Camera(int category, int row, int column) {
			this.category = category;
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
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 사무실의 크기를 각 변수에 할당
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		
		// 사무실의 상태를 저장할 2차원 배열 office 초기화
		office = new int[height][width];
		
		// for 반복문을 사용해 사무실의 각 행을 순회
		for (int r = 0; r < height; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 사무실의 각 칸을 순회
			for (int c = 0; c < width; c++) {
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 사무실의 상태를 2차원 배열 office에 저장
				office[r][c] = Integer.parseInt(st.nextToken());
				
				// 해당 위치가 빈 칸이나 벽인 경우 다음 칸을 순회
				if (office[r][c] == 0 || office[r][c] == 6)
					continue;
				
				// CCTV의 정보를 배열 cameras에 저장
				cameras[cameraNum++] = new Camera(office[r][c], r, c);
			}
		}
		
		// cameraInstaller() 메서드를 호출해 각 CCTV의 배치에 따른 사각 지대의 최소 크기를 갱신
		cameraInstaller(0);
		
		// valueOf() 및 write() 메서드를 사용해 사각 지대의 최소 크기를 출력
		out.write(String.valueOf(minSize));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// cameraInstaller() 메서드 정의
	public static void cameraInstaller(int curCamera) {
		
		// 모든 CCTV의 방향을 설정한 경우
		if (curCamera == cameraNum) {
			
			// blindSpotFinder() 메서드를 호출해 사각 지대의 최소 크기를 갱신 후 메서드 종료
			blindSpotFinder();
			return;
		}
		
		// 현재 CCTV의 종류가 2번 CCTV인 경우
		if (cameras[curCamera].category == 2) {
			
			// for 반복문을 사용해 CCTV의 방향에 따라 cameraInstaller() 메서드 재귀 호출
			for (int d = 0; d < 2; d++) {
				directions[curCamera] = d;
				cameraInstaller(curCamera + 1);
			}
			
		// 현재 CCTV의 종류가 5번 CCTV인 경우 방향을 설정 후 cameraInstaller() 메서드 재귀 호출
		} else if (cameras[curCamera].category == 5) {
			directions[curCamera] = 0;
			cameraInstaller(curCamera + 1);
			
		// 현재 CCTV의 종류가 1번, 3번, 4번 CCTV인 경우
		} else {
			
			// for 반복문을 사용해 CCTV의 방향에 따라 cameraInstaller() 메서드 재귀 호출
			for (int d = 0; d < 4; d++) {
				directions[curCamera] = d;
				cameraInstaller(curCamera + 1);
			}
		}
	}
	
	// ----------------------------------------------------------------------------------------------------

	// blindSpotFinder() 메서드 정의
	public static void blindSpotFinder() {
		
		// 사각 지대의 크기를 저장할 변수 size 초기화
		int size = 0;
		
		// 사각 지대를 저장할 2차원 배열 blindSpots 초기화
		blindSpots = new int[height][width];
		
		// for 반복문을 사용해 사무실의 초기 상태를 2차원 배열 blindSpots에 저장
		for (int r = 0; r < height; r++) {
			for (int c = 0; c < width; c++)
				blindSpots[r][c] = office[r][c];
		}
		
		// for 반복문을 사용해 각 CCTV를 순회
		for (int idx = 0; idx < cameraNum; idx++) {
			
			// 해당 CCTV의 종류를 변수 category에 할당
			int category = cameras[idx].category;
			
			// switch 조건문을 사용해 각 CCTV의 종류에 따라 사각 지대가 아닌 곳을 탐색
			switch (category) {
				case 1:
					rangeChecker(directions[idx], cameras[idx].row, cameras[idx].column);
					break;
				case 2:
					rangeChecker(directions[idx], cameras[idx].row, cameras[idx].column);
					rangeChecker(directions[idx] + 2, cameras[idx].row, cameras[idx].column);
					break;
				case 3:
					for (int n = 0; n < 2; n++)
						rangeChecker((directions[idx] + n) % 4, cameras[idx].row, cameras[idx].column);
					break;
				case 4:
					for (int n = 0; n < 3; n++)
						rangeChecker((directions[idx] + n) % 4, cameras[idx].row, cameras[idx].column);
					break;
				default:
					for (int n = 0; n < 4; n++)
						rangeChecker(directions[idx] + n, cameras[idx].row, cameras[idx].column);
			}
		}
		
		// for 반복문을 사용해 사각 지대의 크기를 갱신
		for (int r = 0; r < height; r++) {
			for (int c = 0; c < width; c++)
				size = (blindSpots[r][c] == 0) ? size + 1 : size;
		}
		
		// min() 메서드를 사용해 사각 지대의 최소 크기를 갱신
		minSize = Math.min(size, minSize);
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// rangeChecker() 메서드 정의
	public static void rangeChecker(int direction, int startRow, int startCol) {
		
		// CCTV로부터 떨어진 거리를 저장할 변수 distance 초기화
		int distance = 1;
		
		// while 반복문을 사용해 CCTV를 기준으로 입력 받은 방향의 칸을 차례로 순회
		while (true) {
			
			// 확인할 CCTV의 위치를 나타낼 각 변수 초기화
			int nr = startRow + dr[direction] * distance;
			int nc = startCol + dc[direction] * distance;
			
			// 해당 위치가 범위를 벗어난 경우 반복문 탈출
			if (nr < 0 || nr >= height || nc < 0 || nc >= width)
				break;
			
			// 해당 위치가 벽인 경우 반복문 탈출
			if (blindSpots[nr][nc] == 6)
				break;
			
			// 해당 위치가 빈 칸인 경우 CCTV의 감시 범위를 갱신
			if (blindSpots[nr][nc] == 0)
				blindSpots[nr][nc] = -1;
			
			// CCTV로부터 떨어진 거리를 갱신
			distance++;
		}
	}
}