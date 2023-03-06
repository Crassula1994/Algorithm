package silver1.num07562;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {

	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// 나이트의 이동 경로를 나타낼 각 델타 배열 초기화
		int[] dr = {-1, -2, -2, -1, 1, 2, 2, 1};
		int[] dc = {-2, -1, 1, 2, 2, 1, -1, -2};
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 체스판의 크기를 변수 size에 할당
			int size = Integer.parseInt(in.readLine());
			
			// 체스판을 나타낼 2차원 배열 chessBoard 초기화
			Integer[][] chessBoard = new Integer[size][size];
			
			// 이동할 위치를 저장할 Queue 객체 movingList 초기화
			Queue<int[]> movingList = new LinkedList<>();
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 나이트의 출발 위치를 배열 startLoc에 할당
			int[] startLoc = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 나이트의 도착 위치를 배열 endLoc에 할당
			int[] endLoc = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
			
			// offer() 메서드를 사용해 나이트의 출발 위치를 movingList에 추가 및 방문 처리
			movingList.offer(startLoc);
			chessBoard[startLoc[0]][startLoc[1]] = 0;
			
			// while 반복문을 사용해 movingList가 빌 때까지 순회
			while (!movingList.isEmpty()) {

				// poll() 메서드를 사용해 이동한 위치을 변수 currentLoc에 할당
				int[] currentLoc = movingList.poll();
				
				// 이동한 위치가 도착 위치인 경우
				if (Arrays.equals(currentLoc, endLoc)) {
					
					// write() 메서드를 사용해 최소 이동 횟수 출력
					out.write(chessBoard[endLoc[0]][endLoc[1]] + "\n");
					
					// 반복문 탈출
					break;
				}
				
				// for 반복문을 사용해 각 델타 배열을 순회
				for (int d = 0; d < 8; d++) {
					
					// 새로운 위치의 좌표를 계산해 각 변수에 할당
					int nr = currentLoc[0] + dr[d];
					int nc = currentLoc[1] + dc[d];
					
					// 해당 위치의 좌표가 체스판을 벗어나지 않고 이동하지 않았던 위치인 경우
					if (nr >= 0 && nr < size && nc >= 0 && nc < size && chessBoard[nr][nc] == null) {
						
						// 해당 위치를 배열 nextLoc에 저장
						int[] nextLoc = {nr, nc};
						
						// offer() 메서드를 사용해 새로운 위치를 movingList에 추가 및 방문 처리
						movingList.offer(nextLoc);
						chessBoard[nr][nc] = chessBoard[currentLoc[0]][currentLoc[1]] + 1;
					}
				}
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}