package silver1.num01303;

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
	
	// 전쟁터의 크기, 각국 병사의 위력을 저장할 각 변수 초기화
	static int width;
	static int height;
	static int whitePower = 0;
	static int bluePower = 0;
	
	// 인접한 위치를 나타내는 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// 전쟁터의 병사의 위치 및 위력 계산 여부를 저장할 각 2차원 배열 초기화
	static char[][] battlefield;
	static boolean[][] calculated;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 전쟁터의 크기를 각 변수에 할당
		width = Integer.parseInt(st.nextToken());
		height = Integer.parseInt(st.nextToken());
		
		// 전쟁터의 병사의 위치 및 위력 계산 여부를 저장할 각 2차원 배열 초기화
		battlefield = new char[height][width];
		calculated = new boolean[height][width];
		
		// for 반복문을 사용해 전쟁터의 각 행을 순회
		for (int r = 0; r < height; r++) {
			
			// readLine() 메서드를 사용해 입력 받은 전쟁터의 행 정보를 배열 line에 할당
			String line = in.readLine();
			
			// for 반복문을 사용해 전쟁터 각 위치의 병사 옷 색을 2차원 배열 battlefield에 저장
			for (int c = 0; c < width; c++)
				battlefield[r][c] = line.charAt(c);
		}

		// for 반복문을 사용해 2차원 배열 battlefield의 각 행과 열을 순회
		for (int r = 0; r < height; r++) {
			for (int c = 0; c < width; c++) {
				
				// 해당 위치를 계산하지 않은 경우 powerCalculator() 메서드 호출
				if (!calculated[r][c])
					powerCalculator(battlefield[r][c], r, c);
			}
		}
		
		// write() 메서드를 사용해 각국 병사의 위력을 차례로 출력
		out.write(whitePower + " " + bluePower);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// powerCalculator() 메서드 정의
	public static void powerCalculator(char color, int startRow, int startCol) {
		
		// 계산한 위력을 저장할 변수 power 초기화
		int power = 0;
		
		// 다음 계산할 위치를 저장할 Queue 객체 calculateList 초기화
		Queue<int[]> calculateList = new LinkedList<>();
		
		// offer() 메서드를 사용해 시작 위치를 calculateList에 추가 및 계산 처리
		calculateList.offer(new int[] {startRow, startCol});
		calculated[startRow][startCol] = true;
		power++;
		
		// while 반복문을 사용해 calculateList가 빌 때까지 순회
		while (!calculateList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 계산 중인 위치를 배열 currentLoc에 할당
			int[] currentLoc = calculateList.poll();
			
			// for 반복문을 사용해 인접한 위치를 순회
			for (int d = 0; d < 4; d++) {
				
				// 인접한 위치를 각 변수에 할당
				int nr = currentLoc[0] + dr[d];
				int nc = currentLoc[1] + dc[d];
				
				// 인접한 위치가 범위를 벗어난 경우 다음 위치를 순회
				if (nr < 0 || nr >= height || nc < 0 || nc >= width)
					continue;
				
				// 해당 위치를 이미 계산했거나, 다른 색상인 경우 다음 위치를 순회
				if (calculated[nr][nc] || battlefield[nr][nc] != battlefield[currentLoc[0]][currentLoc[1]])
					continue;
				
				// offer() 메서드를 사용해 해당 위치를 calculateList에 추가 및 계산 처리
				calculateList.offer(new int[] {nr, nc});
				calculated[nr][nc] = true;
				power++;
			}
		}
		
		// 우리 병사의 위력인 경우 우리 병사의 위력을 갱신
		if (color == 'W') {
			whitePower += power * power;
			
		// 적국 병사의 위력인 경우 적국 병사의 위력을 갱신
		} else {
			bluePower += power * power;
		}
	}
}