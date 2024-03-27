package silver3.num01913;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 표의 크기 및 찾고자 하는 자연수와 그 좌표를 저장할 각 변수 초기화
	static int size;
	static int targetNumber;
	static int targetRow = -1;
	static int targetCol = -1;
	
	// 달팽이의 이동 방향을 나타낼 각 델타 배열 초기화
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	// 자연수를 채울 표를 나타낼 2차원 배열 table 초기화
	static int[][] table;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 표의 크기 및 찾고자 하는 자연수와 그 좌표를 각 변수에 할당
		size = Integer.parseInt(in.readLine());
		targetNumber = Integer.parseInt(in.readLine());
		
		// 자연수를 채울 표를 나타낼 2차원 배열 table 초기화
		table = new int[size][size];
		
		// tableMaker() 메서드를 호출해 표에 자연수를 저장
		tableMaker(size * size, 0, 0, 0);
		
		// for 반복문을 사용해 표의 각 자연수를 출력
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++)
				out.write(table[r][c] + " ");
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// write() 메서드를 사용해 찾고자 하는 자연수의 좌표를 출력
		out.write(targetRow + " " + targetCol);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// tableMaker() 메서드 정의
	public static void tableMaker(int number, int curRow, int curCol, int direction) {
		
		// 해당 숫자를 표에 저장
		table[curRow][curCol] = number;
		
		// 찾고자 하는 자연수의 경우 그 좌표를 갱신
		if (number == targetNumber) {
			targetRow = curRow + 1;
			targetCol = curCol + 1;
		}
		
		// 마지막 숫자에 도달한 경우 메서드 종료
		if (number == 1)
			return;
		
		// 다음에 숫자를 저장할 위치를 각 변수에 할당
		int nr = curRow + dr[direction];
		int nc = curCol + dc[direction];
		
		// 다음에 숫자를 저장할 위치가 범위를 벗어나거나 이미 자연수가 저장된 경우
		if (nr < 0 || nr >= size || nc < 0 || nc >= size || table[nr][nc] != 0) {
			
			// 새로운 방향을 계산해 변수 newDirection에 할당
			int newDirection = (direction + 1) % 4;
			
			// 다음에 숫자를 저장할 위치를 갱신
			nr = curRow + dr[newDirection];
			nc = curCol + dc[newDirection];
			
			// tableMaker() 메서드 재귀 호출
			tableMaker(number - 1, nr, nc, newDirection);
			
		// 다음에 숫자를 저장할 수 있는 경우 tableMaker() 메서드 재귀 호출
		} else {
			tableMaker(number - 1, nr, nc, direction);
		}
	}
}