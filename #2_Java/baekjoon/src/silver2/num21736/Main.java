package silver2.num21736;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 인접한 위치를 나타낼 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 캠퍼스의 크기를 각 변수에 할당
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		
		// 캠퍼스의 정보, 확인 여부를 저장할 각 2차원 배열 초기화
		char[][] campus = new char[height][width];
		boolean[][] checked = new boolean[height][width];
		
		// 도연이의 위치를 저장할 각 변수 초기화
		int startRow = -1;
		int startCol = -1;
		
		// for 반복문을 사용해 각 캠퍼스 정보의 행을 순회
		for (int r = 0; r < height; r++) {

			// readLine() 메서드를 사용해 입력 받은 캠퍼스 정보를 변수 line에 할당
			String line = in.readLine();
			
			// for 반복문을 사용해 각 캠퍼스 정보의 열을 순회
			for (int c = 0; c < width; c++) {
				
				// charAt() 메서드를 사용해 캠퍼스 정보를 2차원 배열 campus에 저장
				campus[r][c] = line.charAt(c);
				
				// 해당 위치에 도연이가 있는 경우 도연이의 위치를 갱신
				if (campus[r][c] == 'I') {
					startRow = r;
					startCol = c;
				}
			}
		}
		
		// 다음에 확인할 위치를 저장할 Queue 객체 checkList 초기화
		Queue<int[]> checkList = new LinkedList<>();
		
		// 도연이가 만날 수 있는 사람의 수를 저장할 변수 personNum 초기화
		int personNum = 0;
		
		// offer() 메서드를 사용해 도연이의 위치를 checkList에 추가 및 확인 처리
		checkList.offer(new int[] {startRow, startCol});
		checked[startRow][startCol] = true;
		
		// while 반복문을 사용해 checkList가 빌 때까지 순회
		while (!checkList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 확인 중인 위치를 배열 currentLoc에 할당
			int[] currentLoc = checkList.poll();
			
			// 해당 위치에 사람이 있는 경우 도연이가 만날 수 있는 사람의 수를 갱신
			if (campus[currentLoc[0]][currentLoc[1]] == 'P')
				personNum++;
			
			// for 반복문을 사용해 인접한 위치를 순회
			for (int d = 0; d < 4; d++) {
				
				// 인접한 위치를 각 변수에 할당
				int nr = currentLoc[0] + dr[d];
				int nc = currentLoc[1] + dc[d];
				
				// 해당 위치가 캠퍼스의 범위를 벗어난 경우 다음 위치를 순회
				if (nr < 0 || nr >= height || nc < 0 || nc >= width)
					continue;
				
				// 해당 위치를 이미 확인하였거나 벽인 경우 다음 위치를 순회
				if (checked[nr][nc] || campus[nr][nc] == 'X')
					continue;
				
				// offer() 메서드를 사용해 해당 위치를 checkList에 추가 및 확인 처리
				checkList.offer(new int[] {nr, nc});
				checked[nr][nc] = true;
			}
		}
		
		// 아무도 만나지 못한 경우 'TT' 출력
		if (personNum == 0) {
			out.write("TT");
		
		// 한 명 이상 만난 경우 도연이가 만날 수 있는 사람의 수를 출력
		} else {
			out.write(String.valueOf(personNum));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}