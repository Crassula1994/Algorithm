package silver1.num02615;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 오목인지를 확인할 각 델타 배열 초기화
	static int[] dr = {1, 0, 1, -1};
	static int[] dc = {0, 1, 1, 1};
	
	// 바둑판의 상태를 저장할 각 2차원 배열 초기화
	static int[][] goBoard = new int[20][20];
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// for 반복문을 사용해 각 바둑판의 행을 순회
		for (int r = 1; r < 20; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 바둑판의 상태를 2차원 배열 goBoard에 저장
			for (int c = 1; c < 20; c++)
				goBoard[r][c] = Integer.parseInt(st.nextToken());
		}
		
		// 승부가 결정되었는지를 나타낼 변수 isEnded 초기화
		boolean isEnded = false;
		
		// for 반복문을 사용해 각 바둑판의 상태를 순회
		outer: for (int r = 1; r < 20; r++) {
			for (int c = 1; c < 20; c++) {
				
				// 해당 바둑판에 돌이 있는 경우
				if (goBoard[r][c] != 0) {
					
					// omokChecker() 메서드를 호출해 해당 위치가 오목인지 여부를 변수 isOmok에 할당
					boolean isOmok = omokChecker(r, c, goBoard[r][c]);
					
					// 오목인 경우
					if (isOmok) {
						
						// 승부가 결정되었는지를 나타낸 변수 갱신
						isEnded = true;
						
						// write() 메서드를 사용해 이긴 돌의 색과 오목을 이룬 가장 왼쪽 위 바둑알의 위치를 출력
						out.write(goBoard[r][c] + "\n" + r + " " + c);
						
						// 반복문 탈출
						break outer;
					}
				}
			}
		}
		
		// 아직 승부가 결정되지 않은 경우 0을 출력
		if (!isEnded)
			out.write(String.valueOf(0));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// omokChecker() 메서드 정의
	public static boolean omokChecker(int startRow, int startCol, int color) {
		
		// for 반복문을 사용해 각 방향을 순회
		for (int d = 0; d < 4; d++) {
			
			// 해당 방향에서 같은 돌의 개수를 저장할 변수 count 초기화
			int count = 1;
			
			// for 반복문을 사용해 해당 방향의 돌을 순회
			for (int m = 1; m < 19; m++) {
				
				// 확인할 바둑판의 위치를 각 변수에 할당
				int nr = startRow + dr[d] * m;
				int nc = startCol + dc[d] * m;
				
				// 해당 위치가 바둑판의 범위를 벗어난 경우 반복문 탈출
				if (nr < 1 || nr > 19 || nc < 1 || nc > 19)
					break;
				
				// 해당 위치에 아무런 돌이 없거나 다른 색의 돌이 있는 경우 반복문 탈출
				if (goBoard[nr][nc] != color)
					break;
				
				// 같은 돌의 개수를 갱신
				count++;
			}
			
			// 해당 방향에서 오목을 이루지 않은 경우 다음 방향을 순회
			if (count != 5)
				continue;
			
			// for 반복문을 사용해 해당 역방향의 돌을 순회
			for (int m = 1; m < 19; m++) {
				
				// 확인할 바둑판의 위치를 각 변수에 할당
				int nr = startRow - dr[d] * m;
				int nc = startCol - dc[d] * m;
				
				// 해당 위치가 바둑판의 범위를 벗어난 경우 반복문 탈출
				if (nr < 1 || nr > 19 || nc < 1 || nc > 19)
					break;
				
				// 해당 위치에 아무런 돌이 없거나 다른 색의 돌이 있는 경우 반복문 탈출
				if (goBoard[nr][nc] != color)
					break;
				
				// 같은 돌의 개수를 갱신
				count++;
			}
			
			// 해당 방향에서 오목을 이룬 경우 true 반환
			if (count == 5)
				return true;
		}
		
		// 오목이 아닌 경우 false 반환
		return false;
	}
}