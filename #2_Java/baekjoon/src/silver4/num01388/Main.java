package silver4.num01388;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 방 바닥의 크기 및 기훈이의 방 바닥을 장식하는데 필요한 나무 판자의 개수를 저장할 각 변수 초기화
	static int height;
	static int width;
	static int totalCnt = 0;
	
	// 방의 각 나무 판자 모양 및 확인 여부를 저장할 각 2차원 배열 초기화
	static char[][] room;
	static boolean[][] checked;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 방 바닥의 크기를 각 변수에 할당
		height = Integer.parseInt(st.nextToken());
		width = Integer.parseInt(st.nextToken());
		
		// 방의 각 나무 판자 모양 및 확인 여부를 저장할 각 2차원 배열 초기화
		room = new char[height][width];
		checked = new boolean[height][width];
		
		// for 반복문을 사용해 방의 각 행을 순회
		for (int r = 0; r < height; r++) {
			
			// readLine() 메서드를 사용해 방의 행의 나무 판자 상태를 변수 line에 할당
			String line = in.readLine();
			
			// for 반복문을 사용해 각 방의 나무 판자 모양을 2차원 배열 room에 저장
			for (int c = 0; c < width; c++)
				room[r][c] = line.charAt(c);
		}
		
		// for 반복문을 사용해 각 방의 나무 판자를 순회
		for (int r = 0; r < height; r++) {
			for (int c = 0; c < width; c++) {
				
				// 해당 나무 판자를 이미 확인한 경우 다음 나무 판자를 순회
				if (checked[r][c])
					continue;
				
				// 해당 나무 판자의 개수 갱신 후 plankChecker() 메서드를 호출해 연결된 나무 판자 확인 처리
				totalCnt++;
				plankChecker(r, c, room[r][c]);
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 기훈이의 방 바닥을 장식하는데 필요한 나무 판자의 개수를 출력
		out.write(String.valueOf(totalCnt));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// plankChecker() 메서드 정의
	public static void plankChecker(int curRow, int curCol, char category) {
		
		// 해당 위치의 나무 판자를 확인 처리
		checked[curRow][curCol] = true;
		
		// 해당 위치의 나무 판자의 종류에 따라 다음에 확인할 위치를 각 변수에 할당
		int nr = (category == '-') ? curRow : curRow + 1;
		int nc = (category == '-') ? curCol + 1 : curCol;
		
		// 다음에 확인할 위치가 방의 범위를 벗어나는 경우 메서드 종료
		if (nr >= height || nc >= width)
			return;
		
		// 다음에 확인할 위치의 판자 모양이 다른 경우 메서드 종료
		if (room[nr][nc] != category)
			return;
		
		// plankChecker() 메서드 재귀 호출
		plankChecker(nr, nc, room[nr][nc]);
	}
}