package gold4.num04485;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {

	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// 테스트 케이스의 번호를 저장할 변수 testCase 초기화
		int testCase = 0;
		
		// 인접한 위치를 나타낼 각 델타 배열 초기화
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		
		// while 반복문을 사용해 모든 테스트 케이스를 순회
		while (true) {
			
			// readLine() 및 parseInt() 메서드를 사용해 동굴의 크기를 변수 size에 할당
			int size = Integer.parseInt(in.readLine());
			
			// 동굴의 크기가 0인 경우 반복문 탈출
			if (size == 0)
				break;
			
			// 동굴의 도둑루피의 상태 및 각 위치까지 잃을 수밖에 없는 최소 금액, 해당 위치의 방문 여부를 저장할 각 2차원 배열 초기화
			int[][] cave = new int[size][size];
			int[][] minCost = new int[size][size];
			boolean[][] visited = new boolean[size][size];
			
			// for 반복문을 사용해 minCost의 각 값을 초기화
			for (int r = 0; r < size; r++)
				Arrays.fill(minCost[r], Integer.MAX_VALUE);
			
			// for 반복문을 사용해 2차원 배열 cave의 각 행을 순회
			for (int r = 0; r < size; r++) {
				
				/// StringTokenizer 객체를 불러와 변수 st에 할당
				StringTokenizer st = new StringTokenizer(in.readLine());
				
				// for 반복문을 사용해 입력 받은 알파벳을 2차원 배열 cave에 저장
				for (int c = 0; c < size; c++)
					cave[r][c] = Integer.parseInt(st.nextToken());
			}
			
			// 다음에 방문할 위치를 저장할 PriorityQueue 객체 visitList 초기화
			PriorityQueue<int[]> visitList = new PriorityQueue<>((l1, l2) -> {
				return minCost[l1[0]][l1[1]] - minCost[l2[0]][l2[1]];
			});
			
			// 출발점의 비용을 초기화
			minCost[0][0] = cave[0][0];
			
			// offer() 메서드를 사용해 출발 위치를 visitList에 추가
			visitList.offer(new int[] {0, 0});
			
			// while 반복문을 사용해 visitList가 빌 때까지 순회
			while (!visitList.isEmpty()) {
				
				// poll() 메서드를 사용해 현재 방문 중인 위치를 배열 currentLoc에 할당
				int[] currentLoc = visitList.poll();
				
				// 해당 위치를 이미 방문한 경우 다음 위치를 순회
				if (visited[currentLoc[0]][currentLoc[1]])
					continue;
				
				// 해당 위치를 방문 처리
				visited[currentLoc[0]][currentLoc[1]] = true;
				
				// for 반복문을 사용해 인접한 위치를 순회
				for (int d = 0; d < 4; d++) {
					
					// 인접한 위치를 각 변수에 할당
					int nr = currentLoc[0] + dr[d];
					int nc = currentLoc[1] + dc[d];
					
					// 새로운 위치가 범위를 벗어나거나 이미 방문한 곳인 경우 다음 위치를 순회
					if (nr < 0 || nr >= size || nc < 0 || nc >= size || visited[nr][nc])
						continue;
					
					// min() 메서드를 사용해 해당 위치까지의 최소 금액을 갱신
					minCost[nr][nc] = Math.min(minCost[currentLoc[0]][currentLoc[1]] + cave[nr][nc], minCost[nr][nc]);
					
					// offer() 메서드를 사용해 해당 위치를 visitList에 추가
					visitList.offer(new int[] {nr, nc});
				}
			}

			// write() 메서드를 사용해 반대편 출구까지 잃을 수밖에 없는 최소 금액을 출력
			out.write("Problem " + (++testCase) + ": " + minCost[size - 1][size - 1] + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}