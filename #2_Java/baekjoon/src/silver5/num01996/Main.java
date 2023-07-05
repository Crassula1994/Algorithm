package silver5.num01996;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

// Main 클래스 정의
public class Main {
	
	// 인접한 위치를 나타낼 각 델타 배열 초기화
	static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
	static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};
	
	//----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 지뢰 찾기 맵의 크기를 변수 size에 할당
		int size = Integer.parseInt(in.readLine());

		// 지뢰 찾기 맵의 상태를 저장할 2차원 배열 map 초기화
		int[][] map = new int[size][size];

		// 지뢰가 존재하는 곳의 위치를 저장할 Queue 객체 mines 초기화
		Queue<int[]> mines = new LinkedList<>();

		// for 반복문을 사용해 각 행을 순회
		for (int r = 0; r < size; r++) {

			// readLine() 메서드를 사용해 입력 받은 맵의 행 상태를 변수 line에 할당
			String line = in.readLine();

			// for 반복문을 사용해 각 열을 순회
			for (int c = 0; c < size; c++) {

				// charAt() 메서드를 사용해 입력 받은 각 칸의 정보를 변수 status에 할당
				char status = line.charAt(c);

				// 해당 위치가 지뢰가 존재하는 곳인 경우 mines에 추가
				if (status != '.')
					mines.add(new int[] {r, c, status - '0'});
			}
		}

		// while 반복문을 사용해 모든 지뢰를 순회
		while (!mines.isEmpty()) {

			// poll() 메서드를 사용해 현재 지뢰에 대한 정보를 배열 mine에 저장
			int[] mine = mines.poll();

			// 현재 지뢰의 위치에 대한 정보를 맵에 추가
			map[mine[0]][mine[1]] = -1;

			// for 반복문을 사용해 해당 지뢰와 인접한 위치를 순회
			for (int d = 0; d < 8; d++) {

				// 인접한 위치를 각 변수에 할당
				int nr = mine[0] + dr[d];
				int nc = mine[1] + dc[d];

				// 인접한 위치가 맵의 범위를 벗어난 경우 다음 위치를 순회
				if (nr < 0 || nr >= size || nc < 0 || nc >= size)
					continue;

				// 인접한 위치가 지뢰인 경우 다음 위치를 순회
				if (map[nr][nc] == -1)
					continue;

				// 인접한 위치에 지뢰의 개수를 갱신
				map[nr][nc] += mine[2];
			}
		}
		
		// for 반복문을 사용해 맵의 각 행과 열을 순회
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {

				// 해당 위치가 지뢰인 경우 '*' 출력
				if (map[r][c] == -1) {
					out.write("*");

				// 해당 위치의 값이 10 이상인 경우 'M' 출력
				} else if (map[r][c] >= 10) {
					out.write("M");

				// 해당 위치의 값이 10 미만인 경우 그대로 출력
				} else {
					out.write(String.valueOf(map[r][c]));
				}
			}

			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}