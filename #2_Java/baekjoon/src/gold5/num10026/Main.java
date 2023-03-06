package gold5.num10026;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 그림의 크기를 나타내는 변수 size 초기화
	static int size;
	
	// 그림 및 해당 그림 위치의 확인 여부를 저장할 각 2차원 배열 초기화
	static char[][] painting;
	static boolean[][] checked;
	
	// 인접한 위치를 탐색하기 위한 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 그림의 크기를 변수 size에 할당
		size = Integer.parseInt(in.readLine());
		
		// 그림 및 해당 그림 위치의 확인 여부를 저장할 각 2차원 배열 초기화
		painting = new char[size][size];
		checked = new boolean[size][size];
		
		// for 반복문을 사용해 배열 painting의 각 행을 순회
		for (int r = 0; r < size; r++) {
			
			// readLine() 메서드를 사용해 입력 받은 색상의 줄을 변수 line에 할당
			String line = in.readLine();
			
			// for 반복문을 사용해 각 색상을 배열 painting에 저장
			for (int c = 0; c < size; c++)
				painting[r][c] = line.charAt(c);
		}
		
		// 적록색약이 아닌 사람이 봤을 때 구역의 수와 적록색약인 사람이 봤을 때 구역의 수를 저장할 각 변수 초기화
		int normalCnt = 0;
		int abnormalCnt = 0;
		
		// for 반복문을 사용해 배열 painting의 각 행과 열을 순회
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				
				// 해당 위치를 확인하지 않은 경우 구역의 수 갱신 및 colorChecker() 메서드 호출해 확인 여부 갱신
				if (!checked[r][c]) {
					normalCnt++;
					colorChecker(r, c, true);
				}
			}
		}

		// 그림 위치의 확인 여부를 저장할 2차원 배열 checked 초기화
		checked = new boolean[size][size];
		
		// for 반복문을 사용해 배열 painting의 각 행과 열을 순회
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				
				// 해당 위치를 확인하지 않은 경우 구역의 수 갱신 및 colorChecker() 메서드 호출해 확인 여부 갱신
				if (!checked[r][c]) {
					abnormalCnt++;
					colorChecker(r, c, false);
				}
			}
		}
		
		// write() 메서드를 사용해 적록색약이 아닌 사람이 봤을 때 구역의 수와 적록색약인 사람이 봤을 때 구역의 수를 출력
		out.write(normalCnt + " " + abnormalCnt);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// colorChecker() 메서드 정의
	private static void colorChecker(int row, int column, boolean isNormal) {
		
		// 해당 위치의 색상을 변수 color에 할당
		char color = painting[row][column];
		
		// 해당 위치 확인 처리
		checked[row][column] = true;
		
		// 정상인인 경우
		if (isNormal) {
			
			// for 반복문을 사용해 인접한 위치를 순회
			for (int d = 0; d < 4; d++) {
				
				// 새로운 위치를 각 변수에 할당
				int nr = row + dr[d];
				int nc = column + dc[d];
				
				// 새로운 위치가 배열을 벗어나지 않고, 같은 색상이며, 확인하지 않은 경우 colorChecker() 메서드 재귀 호출
				if (nr >= 0 && nr < size && nc >= 0 && nc < size && !checked[nr][nc] && painting[nr][nc] == color)
					colorChecker(nr, nc, isNormal);
			}
		
		// 적록색약인 경우
		} else {
			
			// for 반복문을 사용해 인접한 위치를 순회
			for (int d = 0; d < 4; d++) {
				
				// 새로운 위치를 각 변수에 할당
				int nr = row + dr[d];
				int nc = column + dc[d];
				
				// 새로운 위치가 배열을 벗어나지 않고 확인하지 않은 경우
				if (nr >= 0 && nr < size && nc >= 0 && nc < size && !checked[nr][nc]) {
					
					// 색상이 빨강 또는 초록이고 새로운 위치도 같은 색상인 경우 colorChecker() 메서드 재귀 호출
					if (color != 'B' && painting[nr][nc] != 'B') {
						colorChecker(nr, nc, isNormal);
					
					// 색상이 파랑이고 새로운 위치도 같은 색상인 경우 colorChecker() 메서드 재귀 호출
					} else if (color == 'B' && painting[nr][nc] == 'B') {
						colorChecker(nr, nc, isNormal);
					}
				}
			}
		}
	}
}