package gold4.num16202;

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
		
		// 간선의 연결 정점, 가중치를 저장할 각 변수 초기화
		int startNode;
		int endNode;
		int weight;
		
		// 매개변수를 입력 받는 생성자 정의
		public Edge(int startNode, int endNode, int weight) {
			this.startNode = startNode;
			this.endNode = endNode;
			this.weight = weight;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 정점의 개수, 간선의 개수, 턴의 수를 각 변수에 할당
		int nodeNum = Integer.parseInt(st.nextToken());
		int edgeNum = Integer.parseInt(st.nextToken());
		int turnCnt = Integer.parseInt(st.nextToken());
		
		// 각 간선의 정보를 저장할 PriorityQueue 객체 edges 초기화 
		PriorityQueue<Edge> edges = new PriorityQueue<>((e1, e2) -> {
			return e1.weight - e2.weight;
		});
		
		// for 반복문을 사용해 각 간선의 정보를 순회
		for (int weight = 1; weight <= edgeNum; weight++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 연결 정점을 각 변수에 할당
			int startNode = Integer.parseInt(st.nextToken());
			int endNode = Integer.parseInt(st.nextToken());
			
			// offer() 메서드를 사용해 각 간선의 정보를 edges에 추가
			edges.offer(new Edge(startNode, endNode, weight));
		}
		
		// 턴의 수를 저장할 변수 count 초기화
		int count = 0;
		
		// while 반복문을 사용해 턴의 수만큼 순회
		while (count < turnCnt) {
			
			// 최소 스패닝 트리의 가중치 및 선택한 간선의 개수를 저장할 각 변수 초기화
			int totalWeight = 0;
			int edgeCnt = 0;
			
			// 최소 스패닝 트리를 만들기 위해 확인한 간선을 다시 저장할 PriorityQueue 객체 checked 초기화
			PriorityQueue<Edge> checked = new PriorityQueue<>((e1, e2) -> {
				return e1.weight - e2.weight;
			});
			
			// 각 정점의 연결 정보를 저장할 DisjointSet 객체 connection 초기화
			DisjointSet connection = new DisjointSet(nodeNum);
			
			// while 반복문을 사용해 edges가 빌 때까지 순회
			while (!edges.isEmpty()) {
				
				// poll() 메서드를 사용해 가장 길이가 짧은 간선을 변수 edge에 할당
				Edge edge = edges.poll();
				
				// 두 정점 사이에 연결이 존재하지 않는 경우
				if (connection.find(edge.startNode) != connection.find(edge.endNode)) {
					
					// 두 정점을 연결
					connection.union(edge.startNode, edge.endNode);
					
					// 최소 스패닝 트리의 가중치 및 선택한 간선의 개수를 갱신
					totalWeight += edge.weight;
					edgeCnt++;
				}
				
				// offer() 메서드를 사용해 확인한 간선을 checked에 추가
				checked.offer(edge);
			}
			
			// 최소 스패닝 트리를 만들 수 없는 경우
			if (edgeCnt < nodeNum - 1) {
				
				// for 반복문을 사용해 남은 턴만큼 0을 출력 
				for (int turn = 0; turn < turnCnt - count; turn++)
					out.write(0 + " ");
				
				// 반복문 탈출
				break;
				
			// 최소 스패닝 트리를 만들 수 있는 경우
			} else {
				
				// write() 메서드를 사용해 해당 턴의 점수를 출력
				out.write(totalWeight + " ");
				
				// poll() 메서드를 사용해 가장 작은 가중치를 지닌 간선을 제거 후 간선의 정보를 갱신
				checked.poll();
				edges = checked;
				
				// 턴의 수를 갱신
				count++;
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}