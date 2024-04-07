package silver1.num03184;

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
	
	// 뒷마당의 크기, 살아남은 양과 늑대의 수를 저장할 각 변수 초기화
	static int rowNum;
	static int columnNum;
	static int sheepSum = 0;
	static int wolfSum = 0;
	
	// 인접한 위치를 나타내는 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// 뒷마당의 상태, 해당 지역을 확인했는지 여부를 나타낼 각 2차원 배열 초기화
	static char[][] backyard;
	static boolean[][] checked;
	
	// ----------------------------------------------------------------------------------------------------

	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 마당의 크기를 각 변수에 할당
		rowNum = Integer.parseInt(st.nextToken());
		columnNum = Integer.parseInt(st.nextToken());
		
		// 뒷마당의 상태, 해당 지역을 확인했는지 여부를 나타낼 각 2차원 배열 초기화
		backyard = new char[rowNum][columnNum];
		checked = new boolean[rowNum][columnNum];
		
		// for 반복문을 사용해 입력 받은 뒷마당 행의 상태를 순회
		for (int r = 0; r < rowNum; r++) {
			
			// readLine() 메서드를 사용해 입력 받은 행의 상태를 변수 line에 할당
			String line = in.readLine();
			
			// for 반복문을 사용해 입력 받은 뒷마당의 상태를 2차원 배열 backyard에 저장
			for (int c = 0; c < columnNum; c++)
				backyard[r][c] = line.charAt(c);
		}
		
		// for 반복문을 사용해 입력 받은 뒷마당의 각 칸을 순회
		for (int r = 0; r < rowNum; r++) {
			for (int c = 0; c < columnNum; c++) {
				
				// 해당 칸이 울타리가 아니고 확인하지 않은 경우 sheepAttacker() 메서드를 호출해 살아남은 양과 늑대의 수를 갱신
				if (backyard[r][c] != '#' && !checked[r][c])
					sheepAttacker(r, c);
			}
		}
		
		// write() 메서드를 사용해 살아남아 있는 양과 늑대의 수를 출력
		out.write(sheepSum + " " + wolfSum);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// sheepAttacker() 메서드 정의
	public static void sheepAttacker(int startRow, int startCol) {
		
		// 현재 영역 내의 양과 늑대의 수를 갱신할 각 변수 초기화
		int sheepCnt = 0;
		int wolfCnt = 0;
		
		// 다음에 확인할 위치를 저장할 Queue 객체 checkList 초기화 
		Queue<int[]> checkList = new LinkedList<>();
		
		// offer() 메서드를 사용해 시작 위치를 checkList에 추가 및 확인 처리
		checkList.offer(new int[] {startRow, startCol});
		checked[startRow][startCol] = true;
		
		// while 반복문을 사용해 checkList가 빌 때까지 순회
		while (!checkList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 위치를 배열 curLoc에 할당
			int[] curLoc = checkList.poll();
			
			// 해당 위치에 양이 존재하는 경우 현재 영역 내 양의 수를 갱신
			if (backyard[curLoc[0]][curLoc[1]] == 'o') {
				sheepCnt++;
				
			// 해당 위치에 늑대가 존재하는 경우 현재 영역 내 늑대의 수를 갱신
			} else if (backyard[curLoc[0]][curLoc[1]] == 'v') {
				wolfCnt++;
			}
			
			// for 반복문을 사용해 인접한 위치를 순회
			for (int d = 0; d < 4; d++) {
				
				// 인접한 위치를 각 변수에 할당
				int nr = curLoc[0] + dr[d];
				int nc = curLoc[1] + dc[d];
				
				// 해당 위치가 뒷마당의 범위를 벗어난 경우 다음 위치를 순회
				if (nr < 0 || nr >= rowNum || nc < 0 || nc >= columnNum)
					continue;
				
				// 해당 위치가 울타리이거나 이미 확인한 곳인 경우 다음 위치를 순회
				if (backyard[nr][nc] == '#' || checked[nr][nc])
					continue;
				
				// offer() 메서드를 사용해 해당 위치를 checkList에 추가 및 확인 처리
				checkList.offer(new int[] {nr, nc});
				checked[nr][nc] = true;
			}
		}
		
		// 현재 영역 내 양의 수가 더 많은 경우 살아남은 양의 수를 갱신
		if (sheepCnt > wolfCnt) {
			sheepSum += sheepCnt;
			
		// 현재 영역 내 늑대의 수가 더 많은 경우 살아남은 늑대의 수를 갱신
		} else {
			wolfSum += wolfCnt;
		}
	}
}