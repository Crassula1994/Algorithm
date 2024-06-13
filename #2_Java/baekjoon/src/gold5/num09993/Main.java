package gold5.num09993;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 사육장의 크기, 레이저의 최대 반사 횟수를 나타낼 각 변수 초기화
	static int height;
	static int width;
	static int maxCount = 0;
	
	// 인접한 위치를 나타낼 각 델타 배열 초기화
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	// 사육장에 놓인 거울의 배치, 거울에 따른 전환 방향을 저장할 각 2차원 배열 초기화
	static char[][] field;
	static int[][] mirrors = {{1, 0, 3, 2}, {3, 2, 1, 0}};
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 사육장의 크기를 각 변수에 할당
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		
		// 사육장에 놓인 거울의 배치를 저장할 2차원 배열 field 초기화
		field = new char[height][width];
		
		// for 반복문을 사용해 입력 받은 거울의 배치 상태를 2차원 배열 field에 저장
		for (int r = 0; r < height; r++)
			field[r] = in.readLine().toCharArray();
		
		// for 반복문을 사용해 가로로 쏜 레이저의 최대 반사 횟수를 갱신
		for (int r = 0; r < height; r++) {
			laserReflector(r, 0, 1);
			laserReflector(r, width - 1, 3);
		}
		
		// for 반복문을 사용해 세로로 쏜 레이저의 최대 반사 횟수를 갱신
		for (int c = 0; c < width; c++) {
			laserReflector(0, c, 2);
			laserReflector(height - 1, c, 0);
		}
		
		// valueOf() 및 write() 메서드를 사용해 레이저의 최대 반사 횟수를 출력
		out.write(String.valueOf(maxCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// laserReflector() 메서드 정의
	public static void laserReflector(int startRow, int startCol, int direction) {
		
		// 레이저가 거울에 반사된 횟수, 현재 위치를 저장할 각 변수 초기화
		int count = 0;
		int curRow = startRow;
		int curCol = startCol;
		
		// while 반복문을 사용해 사육장의 범위를 벗어날 때까지 순회
		while (curRow >= 0 && curRow < height && curCol >= 0 && curCol < width) {
			
			// 해당 위치에 놓인 거울이 좌측 하단에서 우측 상단으로 향하는 거울인 경우 레이저의 방향을 변경
			if (field[curRow][curCol] == '/') {
				direction = mirrors[0][direction];
				
			// 해당 위치에 놓인 거울이 좌측 상단에서 우측 하단으로 향하는 거울인 경우 레이저의 방향을 변경
			} else {
				direction = mirrors[1][direction];
			}
			
			// 현재 위치 및 레이저가 거울에 반사된 횟수 갱신
			curRow += dr[direction];
			curCol += dc[direction];
			count++;
		}
		
		// max() 메서드를 사용해 레이저의 최대 반사 횟수를 갱신
		maxCount = Math.max(count, maxCount);
	}
}