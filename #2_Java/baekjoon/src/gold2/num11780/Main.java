package gold2.num11780;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 각 도시를 이동하는 데 필요한 최소 비용을 초기화할 상수 INF 초기화
	static final int INF = 987654321;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 도시의 개수와 버스의 개수를 각 변수에 할당
		int cityNum = Integer.parseInt(in.readLine());
		int busNum = Integer.parseInt(in.readLine());
		
		// 각 도시를 연결하는 최소 비용과 거쳐간 이전 도시를 저장할 각 2차원 배열 초기화
		int[][] minCosts = new int[cityNum + 1][cityNum + 1];
		int[][] paths = new int[cityNum + 1][cityNum + 1];
		
		// 이동 경로를 저장할 Stack 객체 pathFinder 초기화
		Stack<Integer> pathFinder = new Stack<>();
		
		// for 반복문을 사용해 각 도시 간의 최소 비용을 갱신
		for (int idx = 0; idx <= cityNum; idx++)
			Arrays.fill(minCosts[idx], INF);
		
		// for 반복문을 사용해 각 버스 정보를 순회
		for (int bus = 0; bus < busNum; bus++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 버스의 출발 도시와 도착 도시, 그 비용을 각 변수에 할당
			int origin = Integer.parseInt(st.nextToken());
			int destination = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			// min() 메서드를 사용해 해당 버스 노선의 정보와 거쳐간 이전 도시를 각 2차원 배열에 저장
			minCosts[origin][destination] = Math.min(cost, minCosts[origin][destination]);
			paths[origin][destination] = origin;
		}
		
		// for 반복문을 사용해 각 경유지를 순회
		for (int mid = 1; mid <= cityNum; mid++) {
			
			// for 반복문을 사용해 각 출발지를 순회
			for (int start = 1; start <= cityNum; start++) {
				
				// for 반복문을 사용해 각 도착지를 순회
				for (int end = 1; end <= cityNum; end++) {
					
					// 출발지와 도착지가 같은 경우 다음 위치를 순회
					if (start == end)
						continue;
					
					// 저장된 최소 비용보다 현재 경유지를 거치는 것이 더 적은 비용이 드는 경우
					if (minCosts[start][end] > minCosts[start][mid] + minCosts[mid][end]) {
						
						// 저장된 최소 비용 및 거쳐간 이전 도시를 갱신
						minCosts[start][end] = minCosts[start][mid] + minCosts[mid][end];
						paths[start][end] = paths[mid][end];
					}
				}
			}
		}
		
		// for 반복문을 사용해 각 도시의 최소 비용을 순회
		for (int start = 1; start <= cityNum; start++) {
			for (int end = 1; end <= cityNum; end++) {
				
				// 해당 도시로 갈 수 없는 경우 0을 출력
				if (minCosts[start][end] == INF) {
					out.write(0 + " ");
					
				// 해당 도시로 갈 수 있는 경우 최소 비용을 출력
				} else {
					out.write(minCosts[start][end] + " ");
				}
			}
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// for 반복문을 사용해 각 도시의 이동 경로를 순회
		for (int start = 1; start <= cityNum; start++) {
			for (int end = 1; end <= cityNum; end++) {
				
				// 해당 도시로 갈 수 없는 경우 0을 출력
				if (paths[start][end] == 0) {
					out.write(String.valueOf(0));
					
				// 해당 도시로 갈 수 있는 경우
				} else {
					
					// 현재 확인 중인 도시를 나타낼 변수 curCity 초기화
					int curCity = end;
					
					// while 반복문을 사용해 시작 도시에 도달할 때까지 순회
					while (true) {
						
						// push() 메서드를 사용해 현재 확인 중인 도시를 pathFinder에 추가
						pathFinder.push(curCity);
						
						// 시작 도시에 도달한 경우 반복문 탈출
						if (curCity == start)
							break;
						
						// 다음 확인할 도시를 갱신
						curCity = paths[start][curCity];
					}
					
					// size() 및 write() 메서드를 사용해 최소 비용에 포함되어 있는 도시의 개수를 출력
					out.write(pathFinder.size() + " ");
					
					// while 반복문을 사용해 도착 도시까지의 경로를 출력
					while (!pathFinder.isEmpty())
						out.write(pathFinder.pop() + " ");
				}
				
				// newLine() 메서드를 사용해 줄바꿈 출력
				out.newLine();
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}