package gold5.num16928;

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
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 사다리와 뱀의 수를 각 변수에 할당
		int ladderNum = Integer.parseInt(st.nextToken());
		int snakeNum = Integer.parseInt(st.nextToken());
		
		// 방문할 위치를 저장할 Queue 객체 visitList 초기화
		Queue<Integer> visitList = new LinkedList<>();
		
		// 사다리와 뱀의 이동 정보를 저장할 배열 map 초기화
		int[] map = new int[101];
		
		// 해당 칸까지의 도달 가능한 최소 주사위 수를 저장할 배열 visited 초기화
		Integer[] visited = new Integer[101];
		
		// for 반복문을 사용해 각 사다리의 정보를 순회
		for (int l = 0; l < ladderNum; l++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			 st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 사다리의 정보를 각 변수에 할당
			int currentLoc = Integer.parseInt(st.nextToken());
			int nextLoc = Integer.parseInt(st.nextToken());
			
			// 해당 정보를 배열 map에 추가
			map[currentLoc] = nextLoc;
		}
		
		// for 반복문을 사용해 각 뱀의 정보를 순회
		for (int s = 0; s < snakeNum; s++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			 st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 뱀의 정보를 각 변수에 할당
			int currentLoc = Integer.parseInt(st.nextToken());
			int prevLoc = Integer.parseInt(st.nextToken());
			
			// 해당 정보를 배열 map에 추가
			map[currentLoc] = prevLoc;
		}
		
		// offer() 메서드를 사용해 시작 위치를 visitList에 추가
		visitList.offer(1);
		
		// 시작 위치를 방문 처리
		visited[1] = 0;
		
		// while() 반복문을 사용해 visitList가 빌 때까지 순회
		while (!visitList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 위치를 변수 currentLoc에 할당
			int currentLoc = visitList.poll();
			
			// 해당 위치가 목적지인 경우 반복문 탈출
			if (currentLoc == 100)
				break;
			
			// for 반복문을 사용해 주사위로 갈 수 있는 6칸을 순회
			for (int i = 1; i <= 6; i++) {
				
				// 다음 위치를 변수 nextLoc에 할당
				int nextLoc = currentLoc + i;
				
				// 해당 위치가 배열을 벗어나지 않고 방문한 적이 없는 경우
				if (nextLoc <= 100 && visited[nextLoc] == null) {
					
					// 해당 위치 방문 처리
					visited[nextLoc] = visited[currentLoc] + 1;
					
					// 해당 위치가 사다리 또는 뱀인 경우
					if (map[nextLoc] != 0) {
						
						// offer() 메서드를 사용해 이동하는 위치를 visitList에 추가
						visitList.offer(map[nextLoc]);
						
						// 해당 위치를 방문하지 않았다면 방문 처리
						if (visited[map[nextLoc]] == null)
							visited[map[nextLoc]] = visited[currentLoc] + 1;
						
					// 해당 위치가 사다리 또는 뱀이 아닌 경우
					} else {
						
						// offer() 메서드를 사용해 해당 위치를 visitList에 추가
						visitList.offer(nextLoc);
					}
				}
			}
		}
		
		// 주사위를 굴려야 하는 최소 횟수를 변수 minCnt에 할당
		int minCnt = visited[100];
		
		// valueOf() 및 write() 메서드를 사용해 주사위를 굴려야 하는 최소 횟수를 출력
		out.write(String.valueOf(minCnt));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}