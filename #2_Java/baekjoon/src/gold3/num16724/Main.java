package gold3.num16724;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 'SAFE ZONE'의 최소 개수를 저장할 변수 minCount 초기화
	static int minCount = 0;
	
	// 지도의 상태, 각 위치의 확인 여부를 저장할 각 2차원 배열 초기화
	static char[][] map;
	static int[][] checked;

	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 지도의 크기를 각 변수에 할당
		int rowNum = Integer.parseInt(st.nextToken());
		int colNum = Integer.parseInt(st.nextToken());
		
		// 지도의 상태, 각 위치의 확인 여부를 저장할 각 2차원 배열 map 초기화
		map = new char[rowNum][colNum];
		checked = new int[rowNum][colNum];
		
		// for 반복문을 사용해 지도의 각 행을 순회
		for (int r = 0; r < rowNum; r++) {
			
			// readLine() 메서드를 사용해 입력 받은 지도의 행의 상태를 변수 line에 할당
			String line = in.readLine();
			
			// for 반복문을 사용해 입력 받은 지도의 상태를 2차원 배열 map에 저장
			for (int c = 0; c < colNum; c++)
				map[r][c] = line.charAt(c);
		}
		
		// for 반복문을 사용해 지도의 각 칸을 순회
		for (int r = 0, group = 1; r < rowNum; r++) {
			for (int c = 0; c < colNum; c++) {
			
				// 해당 위치를 한 번도 확인하지 않은 경우 groupChecker() 메서드를 호출해 'SAFE ZONE'의 최소 개수를 갱신
				if (checked[r][c] == 0)
					groupChecker(r, c, group++);
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 'SAFE ZONE'의 최소 개수를 출력
		out.write(String.valueOf(minCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// groupChecker() 메서드 정의
	public static void groupChecker(int row, int column, int group) {
		
		// 해당 위치를 이미 방문한 경우
		if (checked[row][column] != 0) {
			
			// 해당 위치가 탐색을 시작 곳과 같은 그룹에 속하는 경우 'SAFE ZONE'의 최소 개수를 갱신
			if (checked[row][column] == group)
				minCount++;
			
			// 메서드 종료
			return;
		}
		
		// 해당 위치를 방문 처리
		checked[row][column] = group;
		
		// swtich 조건문을 사용해 각 방향에 따라 groupChecker() 메서드 재귀 호출
		switch (map[row][column]) {
			case 'U':
				groupChecker(row - 1, column, group);
				break;
			case 'D':
				groupChecker(row + 1, column, group);
				break;
			case 'L':
				groupChecker(row, column - 1, group);
				break;
			default:
				groupChecker(row, column + 1, group);
		}
	}
}