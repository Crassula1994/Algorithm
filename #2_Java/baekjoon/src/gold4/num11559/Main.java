package gold4.num11559;

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
	
	// 연쇄가 발생했는지를 나타내는 변수 isOccur 초기화
	static boolean isOccur;
	
	// 인접한 위치를 나타내는 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// 필드의 정보를 저장할 2차원 배열 field 초기화
	static char[][] field = new char[12][6];
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// for 반복문을 사용해 2차원 배열 field의 각 행을 순회
		for (int r = 0; r < 12; r++) {
			
			// readLine() 메서드를 사용해 입력 받은 행의 상태를 변수 line에 할당
			String line = in.readLine();
			
			// for 반복문을 사용해 각 칸의 상태를 2차원 배열 field에 저장
			for (int c = 0; c < 6; c++)
				field[r][c] = line.charAt(c);
		}
		
		// 연쇄의 횟수를 저장할 변수 count 초기화
		int count = 0;
		
		// while 반복문을 사용해 연쇄가 발생하지 않을 때까지 순회
		while (true) {
			
			// 연쇄가 발생했는지를 나타내는 변수 isOccur 초기화
			isOccur = false;
			
			// chainFinder() 메서드를 호출해 연쇄가 있는 경우 해당 뿌요를 제거
			chainFinder();
			
			// 연쇄가 발생하지 않은 경우 반복문 탈출
			if (!isOccur)
				break;
			
			// fieldRenewer() 메서드를 호출해 필드의 상태를 갱신
			fieldRenewer();
			
			// 연쇄의 횟수를 갱신
			count++;
		}
		
		// valueOf() 및 write() 메서드를 사용해 연쇄의 횟수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// chainFinder() 메서드 정의
	public static void chainFinder() {
		
		// 해당 뿌요의 확인 여부를 나타낼 2차원 배열 checked 초기화
		boolean[][] checked = new boolean[12][6];
		
		// 차례로 확인할 위치를 저장할 Queue 객체 checkList 초기화
		Queue<int[]> checkList = new LinkedList<>();
		
		// for 반복문을 사용해 2차원 배열 field의 각 행과 열을 순회
		for (int r = 0; r < 12; r++) {
			for (int c = 0; c < 6; c++) {
				
				// 해당 위치를 방문한 적이 없고, 뿌요인 경우
				if (!checked[r][c] && field[r][c] != '.') {
					
					// 연결된 뿌요의 위치를 저장할 Queue 객체 connectList 초기화
					Queue<int[]> connectList = new LinkedList<>();
					
					// offer() 메서드를 사용해 해당 위치를 checkList 및 connectList에 추가 및 방문 처리
					checkList.offer(new int[] {r, c});
					connectList.offer(new int[] {r, c});
					checked[r][c] = true;
					
					// while 반복문을 사용해 checkList가 빌 때까지 순회
					while (!checkList.isEmpty()) {
						
						// poll() 메서드를 사용해 현재 위치를 배열 currentLoc에 할당
						int[] currentLoc = checkList.poll();
						
						// for 반복문을 사용해 각 인접한 위치를 순회
						for (int d = 0; d < 4; d++) {
							
							// 새로운 위치를 각 변수에 할당
							int nr = currentLoc[0] + dr[d];
							int nc = currentLoc[1] + dc[d];
							
							// 해당 위치가 범위를 벗어난 경우 다음 위치를 순회
							if (nr < 0 || nr > 11 || nc < 0 || nc > 5)
								continue;
							
							// 해당 위치를 방문한 적이 없고, 같은 색상인 경우
							if (!checked[nr][nc] && field[currentLoc[0]][currentLoc[1]] == field[nr][nc]) {
								
								// offer() 메서드를 사용해 해당 위치를 checkList 및 connectList에 추가 및 방문 처리
								checkList.offer(new int[] {nr, nc});
								connectList.offer(new int[] {nr, nc});
								checked[nr][nc] = true;
							}
						}
					}
					
					// 4개 이상의 뿌요가 연결된 경우
					if (connectList.size() >= 4) {
						
						// 연쇄가 발생했는지를 갱신
						isOccur = true;
						
						// while 반복문을 사용해 connectList가 빌 때까지 순회
						while (!connectList.isEmpty()) {
							
							// poll() 메서드를 사용해 터뜨릴 뿌요의 위치를 배열 location에 할당
							int[] location = connectList.poll();
							
							// 해당 위치의 뿌요를 터뜨려 빈 칸으로 변환
							field[location[0]][location[1]] = '.';
						}
					}
				}
			}
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// fieldRenewer() 메서드 정의
	public static void fieldRenewer() {
		
		// for 반복문을 사용해 2차원 배열 field의 각 열을 순회
		for (int c = 0; c < 6; c++) {
			
			// for 반복문을 사용해 2차원 배열 field의 각 행을 거꾸로 순회
			for (int r = 11; r > 0; r--) {
				
				// 해당 위치가 빈 칸인 경우
				if (field[r][c] == '.') {
					
					// for 반복문을 사용해 해당 칸 위의 칸을 순회
					for (int nr = r - 1; nr >= 0; nr--) {
						
						// 해당 위치가 빈 칸이 아닌 경우
						if (field[nr][c] != '.') {
							
							// 두 칸의 위치를 교환 후 반복문 탈출
							field[r][c] = field[nr][c];
							field[nr][c] = '.';
							break;
						}
					}
				}
			}
		}
	}
}