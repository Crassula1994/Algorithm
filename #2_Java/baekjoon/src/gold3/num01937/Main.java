package gold3.num01937;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 대나무 숲의 크기, 판다가 이동할 수 있는 칸의 수의 최댓값을 저장할 각 변수 초기화
	static int size;
	static int maxCount = 0;
	
	// 인접한 위치를 저장할 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// 대나무 숲의 정보 및 각 칸에서 최대한 방문할 수 있는 칸의 수를 저장할 각 2차원 배열 초기화
	static int[][] bambooForest;
	static int[][] maxPath;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 대나무 숲의 크기를 변수 size에 할당
		size = Integer.parseInt(in.readLine());
		
		// 대나무 숲의 정보 및 각 칸에서 최대한 방문할 수 있는 칸의 수를 저장할 각 2차원 배열 초기화
		bambooForest = new int[size][size];
		maxPath = new int[size][size];
		
		// for 반복문을 사용해 대나무 숲의 행을 순회
		for (int r = 0; r < size; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 대나무 숲의 정보를 2차원 배열 bambooForest에 저장
			for (int c = 0; c < size; c++)
				bambooForest[r][c] = Integer.parseInt(st.nextToken());
		}
		
		// for 반복문을 사용해 대나무 숲의 각 칸을 순회
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				
				// pathFinder() 메서드를 호출해 해당 칸에서 판다가 이동할 수 있는 칸의 최댓값을 변수 count에 할당
				int count = pathFinder(r, c);
				
				// max() 메서드를 사용해 판다가 이동할 수 있는 칸의 수의 최댓값을 갱신
				maxCount = Math.max(count, maxCount);
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 판다가 이동할 수 있는 칸의 수의 최댓값을 출력
		out.write(String.valueOf(maxCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// pathFinder() 메서드 정의
	public static int pathFinder(int startRow, int startCol) {
		
		// 해당 칸을 이미 방문한 경우 해당 칸에서 방문할 수 있는 칸의 수의 최댓값을 반환
		if (maxPath[startRow][startCol] != 0)
			return maxPath[startRow][startCol];
		
		// 해당 칸에서 이동할 수 있는 가장 많은 칸의 수를 저장할 변수 count 초기화
		int count = 0;
		
		// 해당 칸에서 방문할 수 있는 칸의 수의 최댓값을 초기화
		maxPath[startRow][startCol] = 1;
		
		// for 반복문을 사용해 인접한 위치를 순회
		for (int d = 0; d < 4; d++) {
			
			// 인접한 위치를 각 변수에 할당
			int nr = startRow + dr[d];
			int nc = startCol + dc[d];
			
			// 해당 위치가 대나무 숲의 범위를 벗어난 경우 다음 위치를 순회
			if (nr < 0 || nr >= size || nc < 0 || nc >= size)
				continue;
			
			// 해당 위치의 대나무가 현재 위치의 대나무보다 적거나 같은 경우 다음 위치를 순회
			if (bambooForest[nr][nc] <= bambooForest[startRow][startCol])
				continue;
			
			// max() 메서드를 사용해 해당 칸에서 이동할 수 있는 가장 많은 칸의 수를 갱신
			count = Math.max(pathFinder(nr, nc), count);
		}
		
		// 해당 칸에서 방문할 수 있는 칸의 수의 최댓값을 갱신
		maxPath[startRow][startCol] += count;
		
		// 해당 칸에서 방문할 수 있는 칸의 수의 최댓값을 반환
		return maxPath[startRow][startCol];
	}
}