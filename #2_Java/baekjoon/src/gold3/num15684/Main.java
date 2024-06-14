package gold3.num15684;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 세로선의 개수, 가로선의 개수, 가로선을 놓을 수 있는 위치의 개수, 추가해야 하는 가로선 개수의 최솟값을 저장할 각 변수 초기화
	static int width;
	static int lineCount;
	static int height;
	static int minCount = 4;
	
	// 사다리의 상태를 저장할 2차원 배열 ladders 초기화
	static int[][] ladders;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		/* nextToken() 및 parseInt() 메서드를 사용해 입력 받은 세로선의 개수, 가로선의 개수,
		가로선을 놓을 수 있는 위치의 개수를 각 변수에 할당 */
		width = Integer.parseInt(st.nextToken());
		lineCount = Integer.parseInt(st.nextToken());
		height = Integer.parseInt(st.nextToken());
		
		// 사다리의 상태를 저장할 2차원 배열 ladders 초기화
		ladders = new int[height + 1][width + 1];
		
		// for 반복문을 사용해 각 가로선의 정보를 순회
		for (int line = 0; line < lineCount; line++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 가로선의 정보를 각 변수에 할당
			int row = Integer.parseInt(st.nextToken());
			int column = Integer.parseInt(st.nextToken());
			
			// 해당 가로선의 정보를 2차원 배열 ladders에 저장
			ladders[row][column] = 1;
			ladders[row][column + 1] = 2;
		}
		
		// lineConnector() 메서드를 호출해 추가해야 하는 가로선 개수의 최솟값을 갱신
		lineConnector(0, 1, 1);

		// valueOf() 및 write() 메서드를 사용해 추가해야 하는 가로선 개수의 최솟값을 출력
		out.write(String.valueOf((minCount > 3) ? -1 : minCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// lineConnector() 메서드 정의
	public static void lineConnector(int count, int row, int column) {
		
		// 현재 추가한 가로선이 현재 저장된 가로선 개수의 최솟값과 같거나 많은 경우 메서드 종료
		if (count >= minCount)
			return;
		
		// 각 세로선의 사다리 타기 결과 자기 자신이 나오는 경우 추가해야 하는 가로선 개수의 최솟값 갱신 후 메서드 종료
		if (ladderChecker()) {
			minCount = count;
			return;
		}
		
		// for 반복문을 사용해 각 사다리의 가능한 가로선을 순회
		for (int r = row; r <= height; r++, column = 1) {
			for (int c = column; c < width; c++) {
				
				// 해당 위치와 연결할 위치에 이미 가로선이 존재하는 경우 다음 가로선을 순회
				if (ladders[r][c] != 0 || ladders[r][c + 1] != 0)
					continue;
				
				// 두 세로선 사이에 가로선을 추가
				ladders[r][c] = 1;
				ladders[r][c + 1] = 2;
				
				// lineConnector() 메서드 재귀 호출
				lineConnector(count + 1, r, c + 2);
				
				// 두 세로선 사이에 가로선을 제거
				ladders[r][c] = 0;
				ladders[r][c + 1] = 0;
			}
		}
	}
	
	// ----------------------------------------------------------------------------------------------------

	// ladderChecker() 메서드 정의
	public static boolean ladderChecker() {
		
		// for 반복문을 사용해 각 세로선을 순회
		for (int c = 1; c <= width; c++) {
			
			// 현재 위치한 세로선을 저장할 변수 curLine 초기화
			int curLine = c;
			
			// for 반복문을 사용해 각 줄을 순회
			for (int r = 1; r <= height; r++) {
				
				// 오른쪽으로 이동하는 가로선이 존재하는 경우 현재 위치한 세로선을 갱신
				if (ladders[r][curLine] == 1) {
					curLine++;
					
				// 왼쪽으로 이동하는 가로선이 존재하는 경우 현재 위치한 세로선을 갱신
				} else if (ladders[r][curLine] == 2) {
					curLine--;
				}
			}
			
			// 마지막 위치가 자기 자신이 아닌 경우 false 반환
			if (curLine != c)
				return false;
		}
		
		// 모든 세로선이 사다리 타기 결과 자기 자신이 나오는 경우 true 반환
		return true;
	}
}