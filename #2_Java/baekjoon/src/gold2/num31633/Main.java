package gold2.num31633;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 농장의 세로 길이와 가로 길이를 저장할 각 변수 초기화
	static int height;
	static int width;
	
	// 인접한 칸을 나타낼 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// 가지들의 크기 및 토양의 높이 배치를 저장할 각 2차원 배열 초기화
	static int[][] sizes;
	static Integer[][] altitudes;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 농장의 세로 길이와 가로 길이를 각 변수에 할당
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		
		// 가지들의 크기 및 토양의 높이 배치를 저장할 각 2차원 배열 초기화
		sizes = new int[height][width];
		altitudes = new Integer[height][width];
		
		// 가지 크기별 농장 칸을 저장할 List 객체 aubergineSorter 초기화
		List<int[]> aubergineSorter = new ArrayList<>();
		
		// for 반복문을 사용해 농장의 각 행을 순회
		for (int r = 0; r < height; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 입력 받은 각 농장의 칸을 순회
			for (int c = 0; c < width; c++) {
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 가지의 크기를 2차원 배열 sizes에 저장
				sizes[r][c] = Integer.parseInt(st.nextToken());
				
				// add() 메서드를 사용해 해당 칸의 정보를 aubergineSorter에 저장
				aubergineSorter.add(new int[] {r, c, sizes[r][c]});
			}
		}
		
		// sort() 메서드를 사용해 농장 칸을 가지 크기가 작은 순서대로 정렬
		Collections.sort(aubergineSorter, (c1, c2) -> {
			return c1[2] - c2[2];
		});
		
		// for 반복문을 사용해 각 농장 칸을 순회
		for (int[] cell : aubergineSorter) {
			
			// 해당 칸의 토양 높이를 이미 결정한 경우 다음 칸을 순회
			if (altitudes[cell[0]][cell[1]] != null)
				continue;
			
			// sizeMapper() 메서드를 호출해 해당 칸의 토양 높이를 갱신
			sizeMapper(cell[0], cell[1], cell[2]);
		}
		
		// for 반복문을 사용해 각 칸의 토양의 높이를 출력
		for (int r = 0; r < height; r++) {
			for (int c = 0; c < width; c++)
				out.write(altitudes[r][c] + " ");
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// sizeMapper() 메서드 정의
	public static void sizeMapper(int startRow, int startColumn, int targetSize) {
		
		// 시작 칸의 높이의 하한을 저장할 변수 minAltitude 초기화
		int minAltitude = -1;
		
		// 시작 칸과 높이가 같은 칸을 저장할 List 객체 cellGroup 초기화
		List<int[]> cellGroup = new ArrayList<>();
		
		// 다음에 확인할 칸을 저장할 Queue 객체 cellList 초기화
		Queue<int[]> cellList = new LinkedList<>();
		
		// offer() 메서드를 사용해 시작 칸을 cellList에 추가
		cellList.offer(new int[] {startRow, startColumn});
		
		// add() 메서드를 사용해 시작 칸을 cellGroup에 추가
		cellGroup.add(new int[] {startRow, startColumn});
		
		// 시작 칸을 확인 처리
		altitudes[startRow][startColumn] = -1;
		
		// while 반복문을 사용해 cellList가 빌 때까지 순회
		while (!cellList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 칸을 배열 curCell에 할당
			int[] curCell = cellList.poll();
			
			// for 반복문을 사용해 인접한 칸을 순회
			for (int d = 0; d < 4; d++) {
				
				// 인접한 칸의 위치를 각 변수에 할당
				int nr = curCell[0] + dr[d];
				int nc = curCell[1] + dc[d];
				
				// 해당 칸이 농장의 범위를 벗어나는 경우 다음 칸을 순회
				if (nr < 0 || nr >= height || nc < 0 || nc >= width)
					continue;
				
				// 해당 칸에 위치한 가지의 크기가 목표 크기와 다른 경우
				if (sizes[nr][nc] != targetSize) {
					
					// 해당 칸이 토양의 높이를 이미 결정한 경우 시작 칸의 높이를 갱신
					if (altitudes[nr][nc] != null)
						minAltitude = Math.max(altitudes[nr][nc], minAltitude);
					
					// 다음 칸을 순회
					continue;
				}
				
				// 해당 칸을 이미 확인한 경우 다음 칸을 순회
				if (altitudes[nr][nc] != null)
					continue;
				
				// offer() 메서드를 사용해 해당 칸을 cellList에 추가
				cellList.offer(new int[] {nr, nc});
				
				// add() 메서드를 사용해 해당 칸을 cellGroup에 추가
				cellGroup.add(new int[] {nr, nc});
				
				// 해당 칸을 확인 처리
				altitudes[nr][nc] = -1;
			}
		}
		
		// for 반복문을 사용해 가지의 크기가 같은 각 칸의 높이를 갱신
		for (int[] cell : cellGroup)
			altitudes[cell[0]][cell[1]] = minAltitude + 1;
	}
}