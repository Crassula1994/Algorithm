package gold4.num01967;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 1번 노드로부터 가장 먼 노드 및 트리의 지름을 저장할 각 변수 초기화
	static int leafNode;
	static int diameter = Integer.MIN_VALUE;
	
	// 각 간선에 대한 정보를 저장할 배열 edges 초기화
	static List<Edge>[] edges;
	
	// Edge 클래스 정의
	static class Edge {
		
		// 해당 간선의 종점과 거리를 저장할 각 변수 초기화
		int endNode;
		int distance;
		
		// 매개변수를 입력 받는 생성자 정의
		public Edge(int endNode, int distance) {
			this.endNode = endNode;
			this.distance = distance;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
			
	// main() 메서드 정의
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 노드의 개수를 변수 nodeNum에 할당
		int nodeNum = Integer.parseInt(in.readLine());
		
		// 각 간선에 대한 정보를 저장할 배열 edges 초기화
		edges = new ArrayList[nodeNum + 1];
		
		// for 반복문을 사용해 각 간선의 정보를 저장할 List 객체 초기화
		for (int idx = 0; idx < edges.length; idx++)
			edges[idx] = new ArrayList<>();
		
		// for 반복문을 사용해 각 간선을 순회
		for (int n = 0; n < nodeNum - 1; n++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 연결된 정점의 번호 및 거리를 각 변수에 할당
			int startNode = Integer.parseInt(st.nextToken());
			int endNode = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
				
			// add() 메서드를 사용해 간선의 정보를 추가
			edges[startNode].add(new Edge(endNode, distance));
			edges[endNode].add(new Edge(startNode, distance));
		}
		
		// 해당 노드의 방문 여부를 나타낼 visited 배열 초기화 및 방문 처리
		boolean[] visited = new boolean[nodeNum + 1];
		
		// farthestNodeFinder() 메서드를 호출해 루트 노드로부터 가장 멀리 떨어진 노드를 갱신
		visited[1] = true;
		farthestNodeFinder(1, 0, visited);
		visited[1] = false;
		
		// 트리의 지름에서 한쪽 끝 노드를 변수 startNode에 할당
		int startNode = leafNode;
		
		// farthestNodeFinder() 메서드를 호출해 트리의 지름을 갱신
		visited[startNode] = true;
		farthestNodeFinder(startNode, 0, visited);
		visited[startNode] = false;

		// valueOf() 및 write() 메서드를 사용해 트리의 지름을 출력
		out.write(String.valueOf(diameter));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------

	// farthestNodeFinder() 메서드 정의
	public static void farthestNodeFinder(int currentNode, int sum, boolean[] visited) {
		
		// 해당 노드가 말단 노드인지를 나타낼 변수 isLeafNode 초기화
		boolean isLeafNode = true;
		
		// for 반복문을 사용해 연결된 간선을 순회
		for (int idx = 0; idx < edges[currentNode].size(); idx++) {
			
			// get() 메서드를 사용해 해당 간선을 변수 edge에 할당
			Edge edge = edges[currentNode].get(idx);
			
			// 연결된 노드를 방문한 적이 없는 경우
			if (!visited[edge.endNode]) {
				
				// 해당 노드가 말단 노드인지를 나타낼 변수 갱신
				isLeafNode = false;
				
				// 해당 노드를 방문 처리
				visited[edge.endNode] = true;
				
				// farthestNodeFinder() 메서드를 재귀 호출
				farthestNodeFinder(edge.endNode, sum + edge.distance, visited);
				
				// 해당 노드를 원상 복구
				visited[edge.endNode] = false;
			}
		}
		
		// 해당 노드가 말단 노드이고 최종 거리가 저장된 트리의 지름보다 긴 경우
		if (isLeafNode && sum > diameter) {
		
			// 시작 노드로부터 가장 먼 노드, 트리의 지름을 갱신
			leafNode = currentNode;
			diameter = sum;
		}
	}
}