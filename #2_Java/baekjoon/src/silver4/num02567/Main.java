package silver4.num02567;

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
		
		// 색종이를 붙일 도화지를 나타낼 2차원 배열 drawingPaper 초기화
		int[][] drawingPaper = new int[100][100];
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 색종이의 수를 변수 cartolina에 할당
		int cartolina = Integer.parseInt(in.readLine());
		
		// 색종이의 둘레를 저장할 변수 초기화
		int round = 0;
		
		// 상하좌우의 인덱스 값을 담은 각 델타 배열 초기화
		int[] dx = {0, 0, -1, 1};
		int[] dy = {-1, 1, 0, 0};

		// for 반복문을 사용해 각 색종이의 경우를 순회
		for (int i = 0; i < cartolina; i++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력받은 색종이의 행과 열의 위치를 각 변수에 할당
			int colLoc = Integer.parseInt(st.nextToken());
			int rowLoc = Integer.parseInt(st.nextToken());
			
			// for 반복문을 사용해 색종이가 붙은 위치의 행을 순회
			for (int r = rowLoc; r < rowLoc + 10; r++) {
				
				// for 반복문을 사용해 색종이가 붙은 위치의 열을 순회하며 위치 표시
				for (int c = colLoc; c < colLoc + 10; c++)
					drawingPaper[r][c]++;
			}
		}
		
		// for 반복문을 사용해 도화지의 각 행과 열을 순회
		for (int r = 0; r < drawingPaper.length; r++) {
			for (int c = 0; c < drawingPaper.length; c++) {
				
				// 색종이가 붙어 있는 경우
				if (drawingPaper[r][c] != 0) {
					
					// for 반복문을 사용해 델타 배열을 순회
					for (int d = 0; d < 4; d++) {
						
						// 델타 배열을 활용해 검사할 위치를 각 변수에 할당
						int nx = r + dx[d];
						int ny = c + dy[d];
						
						// 해당 위치가 범위를 벗어난 경우 둘레를 갱신
						if (nx < 0 || nx > drawingPaper.length - 1 || ny < 0 || ny > drawingPaper.length - 1) {
							round++;
						
						// 해당 위치의 값이 0인 경우 둘레를 갱신
						} else if (drawingPaper[nx][ny] == 0) {
							round++;
						}
					}
				}
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 둘레의 길이를 출력
		out.write(String.valueOf(round));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}