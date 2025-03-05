package silver4.num04396;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

// Main 클래스 정의
public class Main {
	
	// 격자판의 크기, 지뢰가 있는 칸이 열렸는지 여부를 저장할 각 변수 초기화
	static int size;
	static boolean isGameOver = false;
	
	// 인접한 위치를 저장할 각 델타 배열 초기화
	static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
	static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};
	
	// 지뢰가 있는 지점과 열린 칸의 결과를 저장할 각 2차원 배열 초기화
	static char[][] map;
	static char[][] result;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 격자판의 크기를 변수 size에 할당
		size = Integer.parseInt(in.readLine());
		
		// 지뢰가 있는 지점과 열린 칸의 결과를 저장할 각 2차원 배열 초기화
		map = new char[size][size];
		result = new char[size][size];
		
		// 지뢰가 있는 칸을 저장할 List 객체 mines 초기화
		List<int[]> mines = new ArrayList<>();
		
		// for 반복문을 사용해 입력 받은 지뢰가 있는 지점을 2차원 배열 map에 저장
		for (int r = 0; r < size; r++)
			map[r] = in.readLine().toCharArray();
		
		// for 반복문을 사용해 입력 받은 열린 칸을 2차원 배열 result에 저장
		for (int r = 0; r < size; r++)
			result[r] = in.readLine().toCharArray();
		
		// for 반복문을 사용해 각 칸을 순회
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				
				// 해당 칸에 지뢰가 있는 경우 mines에 추가
				if (map[r][c] == '*')
					mines.add(new int[] {r, c});
				
				// 해당 칸이 열리지 않은 경우 다음 칸을 순회
				if (result[r][c] == '.')
					continue;
				
				// mineFinder() 메서드를 호출해 해당 칸의 결과를 2차원 배열 result에 저장
				result[r][c] = mineFinder(r, c);
			}
		}
		
		// 지뢰가 있는 칸이 열린 경우
		if (isGameOver) {
			
			// for 반복문을 사용해 각 지뢰가 있는 위치를 열린 칸의 결과에 추가
			for (int[] mine : mines)
				result[mine[0]][mine[1]] = '*';
		}
		
		// for 반복문을 사용해 열린 칸의 결과를 출력
		for (int r = 0; r < size; r++) {
			out.write(result[r]);
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// mineFinder() 메서드 정의
	public static char mineFinder(int curRow, int curColumn) {
		
		// 해당 위치에 지뢰가 있는 경우 지뢰가 있는 칸이 열렸는지 여부를 갱신 후 '*' 반환
		if (map[curRow][curColumn] == '*') {
			isGameOver = true;
			return '*';
		}
		
		// 해당 위치 주변의 지뢰 개수를 저장할 변수 count 초기화
		int count = 0;
		
		// for 반복문을 사용해 인접한 칸을 순회
		for (int d = 0; d < 8; d++) {
			
			// 인접한 위치를 각 변수에 할당
			int nr = curRow + dr[d];
			int nc = curColumn + dc[d];
			
			// 해당 위치가 격자판의 범위를 벗어나는 경우 다음 칸을 순회
			if (nr < 0 || nr >= size || nc < 0 || nc >= size)
				continue;
			
			// 해당 위치에 지뢰가 존재하지 않는 경우 다음 칸을 순회
			if (map[nr][nc] == '.')
				continue;
			
			// 시작 위치 주변의 지뢰 개수를 갱신
			count++;
		}
		
		// 시작 위치 주변의 지뢰 개수를 문자로 변환하여 반환
		return (char) (count + '0');
	}
}