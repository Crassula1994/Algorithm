package gold5.num09205;

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
	
	// 편의점의 좌표를 저장할 배열 및 편의점의 방문 여부를 저장할 배열 초기화
	static int[][] cStores;
	static boolean[] visited;
	
	// 상근이네 집 좌표 및 펜타포트 락 페스티벌의 좌표를 저장할 각 변수 초기화
	static int startX;
	static int startY;
	static int endX;
	static int endY;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 편의점의 수를 변수 cStoreNum에 할당
			int cStoreNum = Integer.parseInt(in.readLine());
			
			// 편의점의 좌표를 저장할 배열 cStores 초기화
			cStores = new int[cStoreNum][2];
			
			// 편의점의 방문 여부를 저장할 배열 visited 초기화
			visited = new boolean[cStoreNum];
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 상근이네 집의 좌표를 각 변수에 할당
			startX = Integer.parseInt(st.nextToken());
			startY = Integer.parseInt(st.nextToken());
			
			// for 반복문을 사용해 배열 cStores의 각 원소를 순회
			for (int idx = 0; idx < cStores.length; idx++) {
				
				// StringTokenizer 객체를 불러와 변수 st에 재할당
				st = new StringTokenizer(in.readLine());
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 편의점의 좌표를 배열 cStores에 저장
				cStores[idx][0] = Integer.parseInt(st.nextToken());
				cStores[idx][1] = Integer.parseInt(st.nextToken());
			}
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 펜타포트 락 페스티벌의 좌표를 각 변수에 할당
			endX = Integer.parseInt(st.nextToken());
			endY = Integer.parseInt(st.nextToken());
			
			// 페스티벌에 행복하게 갈 수 있는지 여부를 isHappy() 메서드를 호출해 계산 후 변수 result에 할당
			String result = (isHappy()) ? "happy" : "sad";
			
			// write() 메서드를 사용해 페스티벌에 행복하게 갈 수 있는지 여부를 출력
			out.write(result + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// isHappy() 메서드 정의
	public static boolean isHappy() {
		
		// 다음 방문 위치를 저장할 Queue 객체 destination 초기화
		Queue<int[]> destination = new LinkedList<>();
	
		// offer() 메서드를 사용해 처음 상근이네 집을 destination에 추가
		int[] startLoc = {startX, startY};
		destination.offer(startLoc);
		
		// while 반복문을 사용해 desination에 더 이상의 목적지가 없을 때까지 순회
		while (!destination.isEmpty()) {
			
			// poll() 메서드를 사용해 방문한 위치를 currentLoc에 할당
			int[] currentLoc = destination.poll();
			
			// 현재 위치에서 페스티벌까지의 거리가 1000미터 이하인 경우 true 반환
			if (Math.abs(currentLoc[0] - endX) + Math.abs(currentLoc[1] - endY) <= 1000)
				return true;
			
			// for 반복문을 사용해 편의점의 위치를 순회
			for (int idx = 0; idx < cStores.length; idx++) {
				
				// 다음에 방문할 편의점을 nextLoc에 할당
				int[] nextLoc = cStores[idx];
				
				// 현재 위치에서 방문할 편의점까지의 거리를 변수 distance에 할당
				int distance = Math.abs(currentLoc[0] - nextLoc[0]) + Math.abs(currentLoc[1] - nextLoc[1]);
				
				// 현재 위치에서 다음에 방문할 편의점까지의 거리가 1000미터 이하이고 방문한 적이 없는 경우
				if (distance <= 1000 && !visited[idx]) {
					
					// 해당 편의점 방문 처리
					visited[idx] = true;
					
					// offer() 메서드를 사용해 desination에 추가
					destination.offer(nextLoc);
				}
			}
		}
		
		// 편의점으로부터 페스티벌까지의 거리가 1000미터 이상인 경우 false 반환
		return false;
	}
}