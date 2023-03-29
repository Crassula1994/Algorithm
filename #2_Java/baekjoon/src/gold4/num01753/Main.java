package gold4.num01753;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
// https://www.acmicpc.net/board/view/103139 해당 반례 반드시 점검
// Main 클래스 정의
public class Main {
	
	// 정점의 개수 및 간선의 개수를 저장할 각 변수 초기화
	static int vertexNum;
	static int edgeNum;
	
	// 연결된 간선의 정보 및 해당 정점의 최단 경로의 값, 방문 여부를 저장할 각 배열 초기화
	static List<int[]>[] edges;
	static int[] distance;
	static boolean[] visited;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 정점의 개수 및 간선의 개수를 각 변수에 할당
		vertexNum = Integer.parseInt(st.nextToken());
		edgeNum = Integer.parseInt(st.nextToken());
		
		// 연결된 간선의 정보를 저장할 배열 edges 초기화
		edges = new ArrayList[vertexNum + 1];
		
		// for 반복문을 사용해 배열 edges의 각 원소를 초기화
		for (int idx = 1; idx < edges.length; idx++)
			edges[idx] = new ArrayList<>();
		
		// 해당 정점의 최단 경로의 값 및 방문 여부를 저장할 각 배열 초기화 
		distance = new int[vertexNum + 1];
		visited = new boolean[vertexNum + 1];
		
		// fill() 메서드를 사용해 배열 distance의 각 최단 경로의 값을 초기화
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		// readLine() 및 parseInt() 메서드를 사용해 시작 정점을 변수 startNode에 할당
		int startNode = Integer.parseInt(in.readLine());
		
		// 시작 노드의 최단 거리를 초기화
		distance[startNode] = 0;
		
		// for 반복문을 사용해 각 간선의 정보를 순회
		for (int edge = 0; edge < edgeNum; edge++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 간선의 시작점, 간선의 끝점, 간선의 가중치를 각 변수에 할당
			int fromNode = Integer.parseInt(st.nextToken());
			int toNode = Integer.parseInt(st.nextToken());
			int weightVal = Integer.parseInt(st.nextToken());
			
			// add() 메서드를 사용해 간선의 시작점에 최단 경로의 정보를 저장
			edges[fromNode].add(new int[] {toNode, weightVal});
		}

		// 정점이 두 개 이상인 경우 distCalculator() 메서드를 호출해 최단 경로의 값을 갱신
		if (vertexNum > 1)
			distCalculator(startNode);
		
		// for 반복문을 사용해 배열 distance의 각 원소를 순회
		for (int idx = 1; idx < distance.length; idx++) {
			
			// 경로가 존재하지 않는 경우 'INF' 출력
			if (distance[idx] == Integer.MAX_VALUE) {
				out.write("INF\n");
				
			// 경로가 존재하는 경우 최단 경로의 경로 값을 출력
			} else {
				out.write(distance[idx] + "\n");
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// distCalculator() 메서드 정의
	public static void distCalculator(int startNode) {
		
		// 
		// 현재 노드 방문 처리
		visited[currentNode] = true;
		
		// 해당 노드와 연결된 다른 노드를 순회
		for (int idx = 0; idx < edges[currentNode].size(); idx++) {
			
			// get() 메서드를 사용해 연결된 노드 및 가중치를 각 변수에 할당
			int node = edges[currentNode].get(idx)[0];
			int weightVal = edges[currentNode].get(idx)[1];
			
			// min() 메서드를 사용해 최단 거리를 갱신
			distance[node] = Math.min(distance[currentNode] + weightVal, distance[node]);
			
			// 해당 노드를 방문한 적이 없고 저장된 최단 거리보다 계산한 최단 거리가 짧은 경우
			if (!visited[node] && distance[node] < minDistance) {
				
				// 다음에 방문할 노드 및 해당 노드의 최단 거리 갱신
				nextNode = node;
				minDistance = distance[node];
			}
		}
	}
}