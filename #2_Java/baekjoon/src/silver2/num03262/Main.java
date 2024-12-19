package silver2.num03262;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 행과 열의 수, 던진 폭탄의 수를 각 변수에 할당
		int rowNum = Integer.parseInt(st.nextToken());
		int columnNum = Integer.parseInt(st.nextToken());
		int bombNum = Integer.parseInt(st.nextToken());
		
		// 벙커가 위치할 수 있는 게임판 칸의 개수를 저장할 변수 count 초기화
		int count = rowNum * columnNum;
		
		// 게임판의 각 칸에 벙커가 위치할 수 없는지 여부를 저장할 2차원 배열 board 초기화
		boolean[][] board = new boolean[rowNum + 1][columnNum + 1];
		
		// while 반복문을 사용해 각 폭탄의 정보를 순회
		while (bombNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 각 폭탄의 정보를 각 변수에 할당
			int centerRow = Integer.parseInt(st.nextToken());
			int centerColumn = Integer.parseInt(st.nextToken());
			int diameter = Integer.parseInt(st.nextToken());
			int hasBunker = Integer.parseInt(st.nextToken());
			
			// max() 및 min() 메서드를 사용해 해당 폭탄의 폭발 범위를 각 변수에 할당
			int startRow = Math.max(1, centerRow - diameter / 2);
			int endRow = Math.min(rowNum, centerRow + diameter / 2);
			int startColumn = Math.max(1, centerColumn - diameter / 2);
			int endColumn = Math.min(columnNum, centerColumn + diameter / 2);
			
			// 해당 폭탄의 폭발 범위 내에 벙커가 존재하는 경우
			if (hasBunker == 1) {
				
				// for 반복문을 사용해 각 게임판의 칸을 순회
				for (int r = 1; r <= rowNum; r++) {
					for (int c = 1; c <= columnNum; c++) {
						
						// 해당 칸에 벙커가 위치할 수 없는 경우 다음 칸을 순회
						if (board[r][c])
							continue;
						
						// 해당 칸이 폭탄의 폭발 범위 내인 경우 다음 칸을 순회
						if (r >= startRow && r <= endRow && c >= startColumn && c <= endColumn)
							continue;
						
						// 해당 칸에 벙커가 위치할 수 없는지 여부를 갱신
						board[r][c] = true;
					}
				}
				
			// 해당 폭탄의 폭발 범위 내에 벙커가 존재하지 않는 경우
			} else {
				
				// for 반복문을 사용해 해당 폭탄의 폭발 범위 내에 폭탄이 존재하지 않는지 여부를 갱신
				for (int r = startRow; r <= endRow; r++) {
					for (int c = startColumn; c <= endColumn; c++)
						board[r][c] = true;
				}
			}
		}
		
		// for 반복문을 사용해 각 게임판의 칸을 순회
		for (int r = 1; r <= rowNum; r++) {
			for (int c = 1; c <= columnNum; c++) {
				
				// 해당 칸에 벙커가 위치할 수 있는 경우 다음 칸을 순회
				if (!board[r][c])
					continue;
				
				// 벙커가 위치할 수 있는 게임판 칸의 개수를 갱신
				count--;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 벙커가 위치할 수 있는 게임판 칸의 개수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}