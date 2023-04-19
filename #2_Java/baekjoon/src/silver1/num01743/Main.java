package silver1.num01743;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 통로의 세로 길이와 가로 길이, 현재 음식물 쓰레기의 크기를 저장할 각 변수 초기화
	static int height;
	static int width;
	static int size;
	
	// 인접한 위치를 나타낼 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// 통로에 놓인 음식물 쓰레기의 위치를 저장할 2차원 배열 passage 초기화
	static boolean[][] passage;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 통로의 세로 길이 및 가로 길이, 음식물 쓰레기의 개수를 각 변수에 할당
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		int totalCnt = Integer.parseInt(st.nextToken());
		
		// 통로에 놓인 음식물 쓰레기의 위치를 저장할 2차원 배열 passage 초기화
		passage = new boolean[height + 1][width + 1];
		
		// for 반복문을 사용해 각 음식물이 떨어진 좌표를 순회
		for (int loc = 0; loc < totalCnt; loc++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 각 좌표를 각 변수에 할당
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			
			// 음식물이 떨어진 좌표를 배열 passage에 갱신
			passage[row][col] = true;
		}

		// 현재 찾은 음식물의 개수, 가장 큰 음식물의 크기를 저장할 각 변수 초기화
		int findCnt = 0;
		int maxSize = 0;
		
		// for 반복문을 사용해 배열 passage의 각 행과 열을 순회
		outer: for (int r = 1; r <= height; r++) {
			for (int c = 1; c <= width; c++) {
				
				// 해당 위치에 음식물이 떨어져 있는 경우
				if (passage[r][c]) {
					
					// 현재 음식물의 크기를 저장할 변수 size 초기화
					size = 0;
					
					// garbageCounter() 메서드를 호출해 현재 음식물의 크기를 갱신
					garbageCounter(r, c);
					
					// max() 메서드를 사용해 가장 큰 음식물의 크기를 갱신
					maxSize = Math.max(size, maxSize);
				}
				
				// 현재까지 확인한 쓰레기가 음식물 쓰레기의 개수와 같은 경우 반복문 탈출
				if (findCnt == totalCnt)
					break outer;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 가장 큰 음식물의 크기를 출력
		out.write(String.valueOf(maxSize));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// garbageCounter() 메서드 정의
	public static void garbageCounter(int row, int column) {
		
		// 현재 위치의 쓰레기를 확인 처리
		passage[row][column] = false;
		
		// 현재 음식물의 크기를 갱신
		size++;
		
		// for 반복문을 사용해 인접한 위치를 순회
		for (int d = 0; d < 4; d++) {
			
			// 새로운 위치를 각 변수에 할당
			int nr = row + dr[d];
			int nc = column + dc[d];
			
			// 해당 위치가 범위를 벗어나지 않고 음식물 쓰레기인 경우 garbageCounter() 메서드 재귀 호출
			if (nr > 0 && nr <= height && nc > 0 && nc <= width && passage[nr][nc])
				garbageCounter(nr, nc);
		}
	}
}