package gold4.num20924;

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
	
	// 노드의 개수, 루트 노드, 기가 노드, 기둥의 길이, 가장 긴 가지의 길이를 저장할 각 변수 초기화
	static int nodeNum;
	static int rootNode;
	static int gigaNode;
	static int columnLen;
	static int maxBranchLen = Integer.MIN_VALUE;
	
	// 각 간선의 정보, 각 노드의 방문 여부를 저장할 배열 edges 초기화
	static List<Edge>[] edges;
	static boolean[] visited;
	
	// Edge 클래스 정의
	static class Edge {
		
		// 간선의 목적지, 길이를 저장할 각 변수 초기화
		int targetNode;
		int length;
		
		// 매개변수를 입력 받는 생성자 정의
		public Edge(int targetNode, int length) {
			this.targetNode = targetNode;
			this.length = length;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 노드의 개수와 루트 노드의 번호를 각 변수에 할당
		nodeNum = Integer.parseInt(st.nextToken());
		rootNode = Integer.parseInt(st.nextToken());
		
		// 각 간선의 정보, 각 노드의 방문 여부를 저장할 각 배열 초기화 
		edges = new ArrayList[nodeNum + 1];
		visited = new boolean[nodeNum + 1];
		
		// for 반복문을 사용해 각 간선의 정보를 저장할 List 객체 초기화
		for (int idx = 0; idx < edges.length; idx++)
			edges[idx] = new ArrayList<>();
		
		// for 반복문을 사용해 각 간선을 순회
		for (int edge = 0; edge < nodeNum - 1; edge++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 연결 노드와 간선의 길이를 각 변수에 할당
			int startNode = Integer.parseInt(st.nextToken());
			int endNode = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			
			// add() 메서드를 사용해 각 간선의 정보를 배열 edges에 추가
			edges[startNode].add(new Edge(endNode, length));
			edges[endNode].add(new Edge(startNode, length));
		}
		
		// columnChecker() 메서드를 호출해 기가 노드와 기둥의 길이를 갱신
		columnChecker(rootNode, 0);
		
		// branchChecker() 메서드를 호출해 가장 긴 가지의 길이를 갱신
		branchChecker(gigaNode, 0);
		
		// write() 메서드를 사용해 나무의 기둥의 길이와 가장 긴 가지의 길이를 출력
		out.write(columnLen + " " + maxBranchLen);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// columnChecker() 메서드 정의
	public static void columnChecker(int currentNode, int totalLen) {
		
		// 해당 노드가 기가 노드인 경우
		if (edges[currentNode].size() > 2 ||
			(edges[currentNode].size() == 2 && currentNode == rootNode) ||
			(edges[currentNode].size() == 1 && currentNode != rootNode)) {
			
			// 기가 노드 및 기둥의 길이를 갱신
			gigaNode = currentNode;
			columnLen = totalLen;
			
			// 메서드 종료
			return;
		}

		// 해당 노드 방문 처리
		visited[currentNode] = true;
		
		// for 반복문을 사용해 연결된 간선을 순회
		for (int idx = 0; idx < edges[currentNode].size(); idx++) {
			
			// get() 메서드를 사용해 해당 간선을 변수 edge에 할당
			Edge edge = edges[currentNode].get(idx);
			
			// 해당 간선의 노드를 방문한 적이 없는 경우 columnChecker() 메서드 재귀 호출
			if (!visited[edge.targetNode])
				columnChecker(edge.targetNode, totalLen + edge.length);
		}
	}
	
	// ----------------------------------------------------------------------------------------------------

	// branchChecker() 메서드 정의
	public static void branchChecker(int currentNode, int totalLen) {
		
		// 해당 노드가 리프 노드인 경우
		if (edges[currentNode].size() < 2) {
			
			// max() 메서드를 사용해 가장 긴 가지의 길이를 갱신
			maxBranchLen = Math.max(totalLen, maxBranchLen);
			
			// 메서드 종료
			return;
		}
		
		// 해당 노드 방문 처리
		visited[currentNode] = true;
		
		// for 반복문을 사용해 연결된 간선을 순회
		for (int idx = 0; idx < edges[currentNode].size(); idx++) {
			
			// get() 메서드를 사용해 해당 간선을 변수 edge에 할당
			Edge edge = edges[currentNode].get(idx);
			
			// 해당 간선의 노드를 방문한 적이 없는 경우 branchChecker() 메서드 재귀 호출
			if (!visited[edge.targetNode])
				branchChecker(edge.targetNode, totalLen + edge.length);
		}
	}
}