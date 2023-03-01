package silver2.num01260;

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
	
	// 각 정점의 연결 상태를 저장할 2차원 배열 connection 초기화
	static boolean[][] connection;
	
	// 각 정점의 방문 여부를 저장할 배열 visited 초기화
	static boolean[] visited;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 정점의 개수, 간선의 개수, 시작할 정점의 번호를 각 변수에 할당
		int nodeNum = Integer.parseInt(st.nextToken());
		int edgeNum = Integer.parseInt(st.nextToken());
		int startNode = Integer.parseInt(st.nextToken());
		
		// 각 정점의 연결 상태를 저장할 2차원 배열 connection 초기화
		connection = new boolean[nodeNum + 1][nodeNum + 1];
		
		// 각 정점의 방문 여부를 저장할 배열 visited 초기화
		visited = new boolean[nodeNum + 1];
		
		// for 반복문을 사용해 각 간선의 연결 상태를 순회
		for (int n = 0; n < edgeNum; n++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 각 정점을 각 변수에 할당
			int toNode = Integer.parseInt(st.nextToken());
			int fromNode = Integer.parseInt(st.nextToken());
			
			// 각 정점의 연결 상태를 connection에 저장
			connection[toNode][fromNode] = true;
			connection[fromNode][toNode] = true;
		}
		
		// dfs 함수를 호출해 깊이 우선 탐색(DFS)을 수행한 결과를 출력
		dfs(startNode, out);
		
		// 각 정점의 방문 여부를 저장할 배열 visited 초기화
		visited = new boolean[nodeNum + 1];
		
		// newLine() 메서드를 사용해 줄바꿈 출력
		out.newLine();
		
		// bfs 함수를 호출해 너비 우선 탐색(BFS)을 수행한 결과를 출력
		bfs(startNode, out);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// dfs() 메서드 정의
	public static void dfs(int startNode, BufferedWriter out) throws IOException {
		
		// 입력 받은 노드를 방문 처리
		visited[startNode] = true;
		
		// write() 메서드를 사용해 방문 처리한 노드를 출력
		out.write(startNode + " ");
		
		// for 반복문을 사용해 다른 노드를 순회
		for (int node = 1; node < connection.length; node++) {
			
			// 해당 노드와 연결되어 있고 방문한 노드가 아닐 경우 dfs() 메서드 재귀 호출
			if (connection[startNode][node] && !visited[node])
				dfs(node, out);
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// bfs() 메서드 정의
	public static void bfs(int startNode, BufferedWriter out) throws IOException {
		
		// 방문할 다음 위치를 저장할 Queue 객체 nodeQueue 초기화
		Queue<Integer> nodeQueue = new LinkedList<>();
		
		// offer() 메서드를 사용해 입력 받은 노드를 nodeQueue에 추가
		nodeQueue.offer(startNode);
		
		// 해당 노드 방문 처리
		visited[startNode] = true;
		
		// while 문을 사용해 nodeQueue가 빌 때까지 순회
		while (!nodeQueue.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 방문한 노드를 꺼내와 변수 currentNode에 할당
			int currentNode = nodeQueue.poll();
			
			// write() 메서드를 사용해 현재 노드를 출력
			out.write(currentNode + " ");
			
			// for 반복문을 사용해 다른 노드를 순회
			for (int node = 1; node < connection.length; node++) {
				
				// 해당 노드와 연결되어 있고 방문한 노드가 아닐 경우 nodeQueue에 추가 및 방문 처리
				if (connection[currentNode][node] && !visited[node]) {
					nodeQueue.offer(node);
					visited[node] = true;
				}
			}
		}
	}
}