package silver2.num05212;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 인접한 칸의 위치를 나타낼 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 지도의 크기를 각 변수에 할당
		int rowNum = Integer.parseInt(st.nextToken());
		int columnNum = Integer.parseInt(st.nextToken());
		
		// 출력할 지도의 범위를 저장할 각 변수 초기화
		int upperLimit = rowNum - 1;
		int lowerLimit = 0;
		int leftLimit = columnNum - 1;
		int rightLimit = 0;
		
		// 현재 지도 및 50년 후의 지도를 저장할 각 2차원 배열 초기화
		char[][] curMap = new char[rowNum][columnNum];
		char[][] nextMap = new char[rowNum][columnNum];
		
		// for 반복문을 사용해 입력 받은 현재의 지도를 2차원 배열 curMap에 저장
		for (int r = 0; r < rowNum; r++)
			curMap[r] = in.readLine().toCharArray();
		
		// for 반복문을 사용해 각 지도의 칸을 순회
		for (int r = 0; r < rowNum; r++) {
			for (int c = 0; c < columnNum; c++) {
				
				// 해당 칸이 바다인 경우 50년 후의 지도 갱신 후 다음 칸을 순회
				if (curMap[r][c] == '.') {
					nextMap[r][c] = '.';
					continue;
				}
							
				// 바다와 인접한 칸의 개수를 저장할 변수 count 초기화
				int count = 0;
				
				// for 반복문을 사용해 각 인접한 칸을 순회
				for (int d = 0; d < 4; d++) {
					
					// 인접한 칸의 위치를 각 변수에 할당
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					// 해당 위치가 지도의 범위를 벗어나는 경우 바다와 인접한 칸의 개수를 갱신 후 다음 칸을 순회
					if (nr < 0 || nr >= rowNum || nc < 0 || nc >= columnNum) {
						count++;
						continue;
					}
					
					// 해당 칸이 바다인 경우 바다와 인접한 칸의 개수를 갱신
					if (curMap[nr][nc] == '.')
						count++;
				}
				
				// 바다와 인접한 칸의 개수에 따라 50년 후의 지도 갱신
				nextMap[r][c] = (count >= 3) ? '.' : 'X';
				
				// 50년 후에도 섬인 경우 출력할 지도의 범위를 갱신
				if (nextMap[r][c] == 'X') {
					upperLimit = Math.min(r, upperLimit);
					lowerLimit = Math.max(r, lowerLimit);
					leftLimit = Math.min(c, leftLimit);
					rightLimit = Math.max(c, rightLimit);
				}
			}
		}
		
		// for 반복문을 사용해 50년 후의 지도를 출력
		for (int r = upperLimit; r <= lowerLimit; r++) {
			for (int c = leftLimit; c <= rightLimit; c++)
				out.write(nextMap[r][c]);
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}