package gold2.num14529;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// Main 클래스 정의
public class Main {
	
	// 격자의 크기를 저장할 변수 size 초기화
	static int size;
	
	// 연속적인 지역을 나타낼 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// 격자의 상태를 저장할 2차원 배열 grid 초기화
	static char[][] grid;
	
	// 각 사각형이 PCL인지 여부를 저장할 4차원 배열 isPCL 초기화
	static boolean[][][][] isPCL;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 격자의 크기를 변수 size에 할당
		size = Integer.parseInt(in.readLine());
		
		// 이미지에 존재하는 PCL의 개수를 저장할 변수 count 초기화
		int count = 0;
		
		// 격자의 상태를 저장할 2차원 배열 grid 초기화
		grid = new char[size][size];
		
		// 각 사각형이 PCL인지 여부를 저장할 4차원 배열 isPCL 초기화
		isPCL = new boolean[size][size][size][size];
		
		// for 반복문을 사용해 입력 받은 격자의 상태를 2차원 배열 grid에 저장
		for (int r = 0; r < size; r++)
			grid[r] = in.readLine().toCharArray();
		
		// for 반복문을 사용해 각 사각형의 크기를 순회
		for (int height = size; height > 0; height--) {
			for (int width = size; width > 0; width--) {
				
				// for 반복문을 사용해 각 시작 위치를 순회
				for (int r = 0; r <= size - height; r++) {
					for (int c = 0; c <= size - width; c++) {
						
						// 해당 위치가 이미 PCL의 부분 사각형인 경우 다음 위치를 순회
						if (isPCL[r][c][r + height - 1][c + width - 1])
							continue;
						
						// 해당 사각형이 PCL인 경우 그 사각형 및 부분 사각형의 PCL 여부, 이미지에 존재하는 PCL의 개수 갱신
						if (rectangleChecker(r, c, r + height - 1, c + width - 1)) {
							subGridChecker(r, c, r + height - 1, c + width - 1);
							count++;
						}
					}
				}
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 이미지에 존재하는 PCL의 개수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// rectangleChecker() 메서드 정의
	public static boolean rectangleChecker(int startR, int startC, int endR, int endC) {
		
		// 해당 사각형의 확인 여부를 저장할 2차원 배열 checked 초기화
		boolean[][] checked = new boolean[size][size];
		
		// 해당 사각형에 존재하는 색깔 영역의 개수를 저장할 Map 객체 colorCounts 초기화
		Map<Character, Integer> colorCounts = new HashMap<>();
		
		// for 반복문을 사용해 사각형의 각 칸을 순회
		for (int r = startR; r <= endR; r++) {
			for (int c = startC; c <= endC; c++) {
				
				// 해당 칸을 이미 확인한 경우 다음 칸을 순회
				if (checked[r][c])
					continue;
				
				// 해당 칸의 색깔을 변수 targetColor에 할당
				char targetColor = grid[r][c];
				
				// getOrDefault() 및 put() 메서드를 사용해 해당 색깔 영역의 개수를 colorCounts에 저장
				colorCounts.put(targetColor, colorCounts.getOrDefault(targetColor, 0) + 1);
				
				// 다음에 확인할 칸을 저장할 Queue 객체 checkList 초기화
				Queue<int[]> checkList = new LinkedList<>();
				
				// offer() 메서드를 사용해 checkList에 해당 칸을 추가 및 확인 처리
				checkList.offer(new int[] {r, c});
				checked[r][c] = true;
				
				// while 반복문을 사용해 checkList가 빌 때까지 순회
				while (!checkList.isEmpty()) {
					
					// poll() 메서드를 사용해 현재 위치를 배열 curLocation에 할당
					int[] curLocation = checkList.poll();
					
					// for 반복문을 사용해 인접한 위치를 순회
					for (int d = 0; d < 4; d++) {
						
						// 인접한 위치의 좌표를 각 변수에 할당
						int nr = curLocation[0] + dr[d];
						int nc = curLocation[1] + dc[d];
						
						// 해당 위치가 사각형의 범위를 벗어난 경우 다음 위치를 순회
						if (nr < startR || nr > endR || nc < startC || nc > endC)
							continue;
						
						// 해당 위치가 다른 색깔이거나 해당 위치를 이미 확인한 경우 다음 위치를 순회
						if (grid[nr][nc] != targetColor || checked[nr][nc])
							continue;
						
						// offer() 메서드를 사용해 checkList에 해당 위치를 추가 및 확인 처리
						checkList.offer(new int[] {nr, nc});
						checked[nr][nc] = true;
					}
				}
				
				// 색깔의 종류가 3개 이상인 경우 false 반환
				if (colorCounts.size() > 2)
					return false;
			}
		}
		
		// 색깔의 종류가 2개가 아닌 경우 false 반환
		if (colorCounts.size() != 2)
			return false;
		
		// values() 메서드를 사용해 각 색깔 영역의 개수를 저장할 List 객체 counts 초기화
		List<Integer> counts = new ArrayList<>(colorCounts.values());
		
		// 해당 사각형이 PCL인지 여부를 반환
		return (counts.get(0) == 1 && counts.get(1) > 1) || (counts.get(0) > 1 && counts.get(1) == 1);
	}
	
	// ----------------------------------------------------------------------------------------------------

	// subGridChecker() 메서드 정의
	public static void subGridChecker(int startR, int startC, int endR, int endC) {
		
		// for 반복문을 사용해 각 시작 칸을 순회
		for (int sr = startR; sr <= endR; sr++) {
			for (int sc = startC; sc <= endC; sc++) {
				
				// for 반복문을 사용해 각 끝 칸을 순회
				for (int er = sr; er <= endR; er++) {
					for (int ec = sc; ec <= endC; ec++)
						
						// 해당 부분 사각형의 PCL 여부 갱신
						isPCL[sr][sc][er][ec] = true;
				}
			}
		}
	}
}