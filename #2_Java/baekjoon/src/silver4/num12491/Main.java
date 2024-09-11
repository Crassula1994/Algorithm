package silver4.num12491;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 빨간 타일의 문자 및 위치를 나타낼 각 배열 초기화
	static char[] redTile = {'/', '\\', '\\', '/'};
	static int[] dr = {0, 0, 1, 1};
	static int[] dc = {0, 1, 0, 1};
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 1; tc <= testCase; tc++) {
			
			// write() 메서드를 사용해 테스트 케이스의 번호를 출력
			out.write("Case #" + tc + ":\n");
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 그림의 크기를 각 변수에 할당
			int row = Integer.parseInt(st.nextToken());
			int column = Integer.parseInt(st.nextToken());
			
			// 그림의 파란 타일을 빨간 타일로 바꿀 수 있는지 여부를 나타낼 변수 canTransform 초기화
			boolean canTransform = true;
			
			// 입력 받은 그림을 저장할 2차원 배열 picture 초기화
			char[][] picture = new char[row][column];
			
			// for 반복문을 사용해 입력 받은 그림의 상태를 2차원 배열 picture에 저장
			for (int r = 0; r < row; r++)
				picture[r] = in.readLine().toCharArray();
			
			// for 반복문을 사용해 각 그림의 행과 열을 순회
			outer: for (int r = 0; r < row; r++) {
				for (int c = 0; c < column; c++) {
				
					// 해당 위치의 타일이 파란 타일이 아닌 경우 다음 타일을 순회
					if (picture[r][c] != '#')
						continue;
					
					// 테두리 부분에 남은 파란 타일이 있는 경우
					if (r == row - 1 || c == column - 1) {
						
						// 그림의 파란 타일을 빨간 타일로 바꿀 수 있는지 여부를 갱신 후 반복문 탈출
						canTransform = false;
						break outer;
					}
					
					// for 반복문을 사용해 빨간 타일을 붙일 위치를 순회
					for (int d = 0; d < 4; d++) {
						
						// 빨간 타일을 붙일 위치를 각 변수에 할당
						int nr = r + dr[d];
						int nc = c + dc[d];
						
						// 해당 위치가 파란 타일이 아닌 경우
						if (picture[nr][nc] != '#') {
							
							// 그림의 파란 타일을 빨간 타일로 바꿀 수 있는지 여부를 갱신 후 반복문 탈출
							canTransform = false;
							break outer;
						}
						
						// 해당 위치의 파란 타일을 빨간 타일로 교체
						picture[nr][nc] = redTile[d];
					}
				}
			}
			
			// 그림의 파란 타일을 빨간 타일로 바꿀 수 있는 경우
			if (canTransform) {
				
				// for 반복문을 사용해 빨간 타일로 바꾼 결과를 출력
				for (int r = 0; r < row; r++) {
					for (int c = 0; c < column; c++)
						out.write(picture[r][c]);
					
					// newLine() 메서드를 사용해 줄바꿈 출력
					out.newLine();
				}
				
			// 그림의 파란 타일을 빨간 타일로 바꿀 수 없는 경우 'Impossible' 출력
			} else {
				out.write("Impossible\n");
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}