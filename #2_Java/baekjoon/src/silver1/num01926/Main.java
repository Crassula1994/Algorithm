package silver1.num01926;

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
	
	// 도화지의 크기, 가장 넓은 그림의 넓이를 나타낼 각 변수 초기화
	static int height;
	static int width;
	static int maxSize = 0;
	
	// 연결된 위치를 저장할 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// 도화지의 상태를 저장할 2차원 배열 drawingPaper 초기화
	static int[][] drawingPaper;
	
	// ----------------------------------------------------------------------------------------------------

	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 도화지의 세로 및 가로 크기를 각 변수에 할당
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		
		// 도화지의 상태를 저장할 2차원 배열 drawingPaper 초기화
		drawingPaper = new int[height][width];
		
		// for 반복문을 사용해 도화지의 각 행을 순회
		for (int r = 0; r < height; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 입력 받은 각 도화지의 상태를 2차원 배열 drawingPaper에 저장
			for (int c = 0; c < width; c++)
				drawingPaper[r][c] = Integer.parseInt(st.nextToken());
		}
		
		// 그림의 개수를 저장할 변수 count 초기화
		int count = 0;
		
		// for 반복문을 사용해 도화지의 각 칸을 순회
		for (int r = 0; r < height; r++) {
			for (int c = 0; c < width; c++) {
				
				// 해당 칸이 색칠이 된 부분인 경우
				if (drawingPaper[r][c] == 1) {
				
					// 그림의 개수 갱신
					count++;
					
					// sizeCalculator() 메서드를 호출해 가장 넓은 그림의 크기를 갱신
					sizeCalculator(r, c);
				}
			}
		}
		
		// write() 메서드를 사용해 그림의 개수 및 가장 넓은 그림의 넓이를 출력
		out.write(count + "\n" + maxSize);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// sizeCalculator() 메서드 정의
	public static void sizeCalculator(int startRow, int startCol) {
		
		// 그림의 크기를 나타낼 변수 size 초기화
		int size = 1;
		
		// 다음에 확인할 위치를 저장할 Queue 객체 calculateList 초기화
		Queue<int[]> calculateList = new LinkedList<>();
		
		// offer() 메서드를 사용해 시작 위치를 calculateList에 추가 및 확인 처리
		calculateList.offer(new int[] {startRow, startCol});
		drawingPaper[startRow][startCol] = 0;
		
		// while 반복문을 사용해 calculateList가 빌 때까지 순회
		while (!calculateList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 위치를 배열 currentLoc에 할당
			int[] currentLoc = calculateList.poll();
			
			// for 반복문을 사용해 연결된 각 위치를 순회
			for (int d = 0; d < 4; d++) {
				
				// 연결된 위치를 각 변수에 할당
				int nr = currentLoc[0] + dr[d];
				int nc = currentLoc[1] + dc[d];
				
				// 해당 위치가 도화지의 범위를 벗어난 경우 다음 위치를 순회
				if (nr < 0 || nr >= height || nc < 0 || nc >= width)
					continue;
				
				// 해당 위치가 색칠이 안 된 부분인 경우 다음 위치를 순회
				if (drawingPaper[nr][nc] == 0)
					continue;
				
				// 그림의 크기 갱신
				size++;
				
				// offer() 메서드를 사용해 다음 위치를 calculateList에 추가 및 확인 처리
				calculateList.offer(new int[] {nr, nc});
				drawingPaper[nr][nc] = 0;
			}
		}
		
		// max() 메서드를 사용해 가장 넓은 그림의 크기를 갱신
		maxSize = Math.max(size, maxSize);
	}
}