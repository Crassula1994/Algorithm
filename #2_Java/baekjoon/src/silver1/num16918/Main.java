package silver1.num16918;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {

	// 격자판의 크기 및 시간을 저장할 각 변수를 할당
	static int row;
	static int column;
	static int time;

	// 인접한 위치를 나타낼 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	// 다음에 인접할 위치를 저장할 배열 초기화

	// 격자판의 상태를 저장할 2차원 배열 grid 초기화
	static char[][] grid;

	// ----------------------------------------------------------------------------------------------------

	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken(), parseInt(), pow() 메서드를 사용해 입력 받은 격자판의 크기 및 시간을 각 변수에 할당
		row = Integer.parseInt(st.nextToken());
		column = Integer.parseInt(st.nextToken());
		time = Integer.parseInt(st.nextToken());

		// 격자판의 상태를 저장할 2차원 배열 grid 초기화
		grid = new char[row][column];

		// for 반복문을 사용해 격자판의 각 행을 순회
		for (int r = 0; r < row; r++) {

			// readLine() 메서드를 사용해 입력 받은 격자판의 행의 정보를 변수 line에 할당
			String line = in.readLine();

			// for 반복문을 사용해 격자판의 각 정보를 2차원 배열 grid에 저장
			for (int c = 0; c < column; c++)
				grid[r][c] = line.charAt(c);
		}

		// 짝수 시간인 경우
		if (time % 2 == 0) {

			// for 반복문을 사용해 격자판의 각 행을 순회
			for (int r = 0; r < row; r++) {

				// for 반복문을 사용해 격자판의 각 열의 개수만큼 'O'를 출력
				for (int c = 0; c < column; c++)
					out.write("O");

				// newLine() 메서드를 사용해 줄바꿈을 출력
				out.newLine();
			}

		// 홀수 시간인 경우
		} else {

			//

		}

		// orderFinder() 메서드를 호출해 방문 순서를 변수 order에 할당
//		int order = orderFinder(size, targetRow, targetCol);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}