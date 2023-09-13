package silver1.num01890;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 게임판의 크기를 변수 size에 할당
		int size = Integer.parseInt(in.readLine());
		
		// 게임판의 숫자, 해당 위치까지의 경로의 수를 저장할 각 2차원 배열 초기화
		int[][] board = new int[size][size];
		long[][] routes = new long[size][size];
		
		// for 반복문을 사용해 각 게임판의 행을 순회
		for (int r = 0; r < size; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 입력 받은 각 게임판의 숫자를 2차원 배열 board에 저장
			for (int c = 0; c < size; c++)
				board[r][c] = Integer.parseInt(st.nextToken());
		}
		
		// 첫 위치의 경로의 개수를 갱신
		routes[0][0] = 1;
		
		// for 반복문을 사용해 각 칸을 차례로 순회
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				
				// 해당 칸의 값이 0인 경우 다음 칸을 순회
				if (board[r][c] == 0)
					continue;
				
				// 해당 위치에서 오른쪽으로 이동할 수 있는 칸이 범위를 벗어나지 않는 경우 경로의 개수 갱신
				if (c + board[r][c] < size)
					routes[r][c + board[r][c]] += routes[r][c];
				
				// 해당 위치에서 아래쪽으로 이동할 수 있는 칸이 범위를 벗어나지 않는 경우 경로의 개수 갱신
				if (r + board[r][c] < size)
					routes[r + board[r][c]][c] += routes[r][c];
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 가장 오른쪽 아래 칸으로 갈 수 있는 경로의 개수를 출력
		out.write(String.valueOf(routes[size - 1][size - 1]));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}