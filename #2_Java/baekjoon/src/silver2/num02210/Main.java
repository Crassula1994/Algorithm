package silver2.num02210;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 인접한 위치를 저장할 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// 숫자판의 숫자를 저장할 2차원 배열 numpad 초기화
	static String[][] numpad = new String[5][5];
	
	// 만들 수 있는 서로 다른 여섯 자리의 수들을 저장할 Set 객체 numbers 초기화
	static Set<String> numbers = new HashSet<>();
		
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// for 반복문을 사용해 숫자판의 각 행을 순회
		for (int r = 0; r < 5; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 숫자판의 각 열을 순회
			for (int c = 0; c < 5; c++)
				numpad[r][c] = st.nextToken();
		}
		
		// for 반복문을 사용해 숫자판의 각 칸을 순회하며 만들 수 있는 서로 다른 여섯 자리의 수를 갱신
		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 5; c++)
				numberFinder(r, c, numpad[r][c]);
		}
		
		// size(), valueOf(), write() 메서드를 사용해 만들 수 있는 서로 다른 여섯 자리 수들의 개수를 출력
		out.write(String.valueOf(numbers.size()));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// numberFinder() 메서드 정의
	public static void numberFinder(int row, int column, String string) {
		
		// 여섯 자리 글자를 만든 경우 numbers에 추가 후 메서드 종료
		if (string.length() == 6) {
			numbers.add(string);
			return;
		}
		
		// for 반복문을 사용해 인접한 각 위치를 순회
		for (int d = 0; d < 4; d++) {
			
			// 인접한 위치를 각 변수에 할당
			int nr = row + dr[d];
			int nc = column + dc[d];
			
			// 인접한 위치가 숫자판의 범위를 벗어나는 경우 다음 위치를 순회
			if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5)
				continue;
			
			// numberFinder() 메서드 재귀 호출
			numberFinder(nr, nc, string + numpad[nr][nc]);
		}
	}
}