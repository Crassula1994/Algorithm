package gold4.num17130;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 이전의 가능한 위치를 나타낼 각 델타 배열 초기화
	static int[] dr = {-1, 0, 1};
	static int[] dc = {-1, -1, -1};
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 격자의 크기를 각 변수에 할당
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		
		// 토끼의 위치 및 토끼가 얻을 수 있는 최대 당근의 개수를 저장할 각 변수 초기화
		int startR = -1;
		int startC = -1;
		int maxCount = -1;
		
		// 격자의 상태, 각 위치에서 얻을 수 있는 최대 당근의 개수를 저장할 각 2차원 배열 초기화
		char[][] grid = new char[height][width];
		int[][] maxCounts = new int[height][width];
		
		// for 반복문을 사용해 격자의 각 행을 순회
		for (int r = 0; r < height; r++) {
			
			// readLine() 메서드를 사용해 입력 받은 격자의 행의 상태를 변수 line에 할당
			String line = in.readLine();
			
			// fill() 메서드를 사용해 각 위치에서 얻을 수 있는 최대 당근의 개수를 초기화
			Arrays.fill(maxCounts[r], -1);
			
			// for 반복문을 사용해 격자의 각 열을 순회
			for (int c = 0; c < width; c++) {
				
				// charAt() 메서드를 사용해 입력 받은 격자의 상태를 2차원 배열 grid에 저장
				grid[r][c] = line.charAt(c);
				
				// 해당 위치에 토끼가 위치한 경우 토끼의 위치를 갱신
				if (grid[r][c] == 'R') {
					startR = r;
					startC = c;
				}
			}
		}
		
		// 토끼의 시작 위치에서 얻을 수 있는 최대 당근의 개수를 초기화
		maxCounts[startR][startC] = 0;
		
		// for 반복문을 사용해 격자의 각 열을 순회
		for (int c = startC + 1; c < width; c++) {
			
			// for 반복문을 사용해 격자의 각 행을 순회
			for (int r = 0; r < height; r++) {
				
				// 해당 칸이 벽인 경우 다음 칸을 순회
				if (grid[r][c] == '#')
					continue;
				
				// for 반복문을 사용해 이전의 가능한 위치를 순회
				for (int d = 0; d < 3; d++) {
					
					// 이전의 가능한 위치를 각 변수에 할당
					int pr = r + dr[d];
					int pc = c + dc[d];
					
					// 이전의 가능한 위치가 범위를 벗어나거나 토끼가 이동할 수 없는 곳인 경우 다음 위치를 순회
					if (pr < 0 || pr >= height || pc < 0 || pc >= width || maxCounts[pr][pc] == -1)
						continue;
					
					// 현재 위치에 당근이 위치한 경우 토끼가 얻을 수 있는 최대 당근의 개수 갱신
					if (grid[r][c] == 'C') {
						maxCounts[r][c] = Math.max(maxCounts[pr][pc] + 1, maxCounts[r][c]);
						
					// 현재 위치가 빈 공간인 경우 토끼가 얻을 수 있는 최대 당근의 개수 갱신
					} else if (grid[r][c] == '.') {
						maxCounts[r][c] = Math.max(maxCounts[pr][pc], maxCounts[r][c]);
						
					// 현재 위치가 정보섬 쪽문인 경우 토끼가 얻을 수 있는 최대 당근의 개수 갱신
					} else if (grid[r][c] == 'O') {
						maxCounts[r][c] = Math.max(maxCounts[pr][pc], maxCounts[r][c]);
						maxCount = Math.max(maxCounts[r][c], maxCount);
					}
				}
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 토끼가 얻을 수 있는 최대 당근의 개수를 출력
		out.write(String.valueOf(maxCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}