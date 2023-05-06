package gold4.num01197;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// Edge 클래스 정의
	static class Edge {
		
		// 간선의 연결 정점, 길이를 저장할 각 변수 초기화
		int startNode;
		int endNode;
		int length;
		
		// 매개변수를 입력 받는 생성자 정의
		public Edge(int startNode, int endNode, int length) {
			this.startNode = startNode;
			this.endNode = endNode;
			this.length = length;
		}
	}
	
	// DisjointSet 클래스 정의
	static class DisjointSet {
		
		// 각 정점의 부모 정점을 저장할 배열 parent 초기화
		int[] parent;
		
		// 매개변수를 입력 받는 생성자 정의
		public DisjointSet(int nodeNum) {
			
			// 부모 정점을 저장할 배열 parent 초기화
			parent = new int[nodeNum + 1];
			
			// for 반복문을 사용해 각 정점의 부모 정점을 초기화
			for (int idx = 1; idx < parent.length; idx++)
				parent[idx] = idx;
		}
		
		// find() 메서드 정의
		public int find(int node) {
			
			// 해당 정점의 부모 정점이 자기 자신이 아닌 경우 find() 메서드 재귀 호출
			if (parent[node] != node)
				parent[node] = find(parent[node]);
			
			// 해당 정점의 부모 정점을 반환
			return parent[node];
		}
		
		// union() 메서드 정의
		public void union(int node1, int node2) {
			
			// 두 정점을 연결
			parent[find(node1)] = find(node2);
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 정점의 개수와 간선의 개수를 각 변수에 할당
		int nodeNum = Integer.parseInt(st.nextToken());
		int edgeNum = Integer.parseInt(st.nextToken());
		
		// 각 간선의 정보를 저장할 PriorityQueue 객체 edges 초기화 
		PriorityQueue<Edge> edges = new PriorityQueue<>((e1, e2) -> {
			return e1.length - e2.length;
		});
		
		// for 반복문을 사용해 각 간선의 정보를 순회
		for (int edge = 0; edge < edgeNum; edge++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 연결 정점과 간선의 길이를 각 변수에 할당
			int startNode = Integer.parseInt(st.nextToken());
			int endNode = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			
			// offer() 메서드를 사용해 각 간선의 정보를 edges에 추가
			edges.offer(new Edge(startNode, endNode, length));
		}

		// 최소 스패닝 트리의 가중치 및 선택한 간선의 개수를 저장할 각 변수 초기화
		int totalWeight = 0;
		int edgeCnt = 0;
		
		// 각 정점의 연결 정보를 저장할 DisjointSet 객체 connection 초기화
		DisjointSet connection = new DisjointSet(nodeNum);
		
		// while 반복문을 사용해 edges가 빌 때까지 순회
		while (!edges.isEmpty()) {
			
			// 최소 스패닝 트리를 위해 필요한 간선을 모두 선택한 경우 반복문 탈출
			if (edgeCnt == nodeNum - 1)
				break;
			
			// poll() 메서드를 사용해 가장 길이가 짧은 간선을 변수 edge에 할당
			Edge edge = edges.poll();
			
			// 두 정점 사이에 연결이 존재하지 않는 경우
			if (connection.find(edge.startNode) != connection.find(edge.endNode)) {
				
				// 두 정점을 연결
				connection.union(edge.startNode, edge.endNode);
				
				// 최소 스패닝 트리의 가중치 및 선택한 간선의 개수를 갱신
				totalWeight += edge.length;
				edgeCnt++;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 최소 스패닝 트리의 가중치를 출력
		out.write(String.valueOf(totalWeight));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}