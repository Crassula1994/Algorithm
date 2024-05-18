package gold5.num01240;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 각 노드 사이의 간선 및 방문 여부를 저장할 배열 초기화
	static List<Node>[] edges;
	static boolean[] visited;
	
	// ----------------------------------------------------------------------------------------------------
	
	// Node 클래스 정의
	public static class Node {
		
		// 해당 노드의 번호와 그 거리를 저장할 각 변수 초기화
		int number;
		int distance;
		
		// 매개변수를 입력 받는 생성자 정의
		public Node(int number, int distance) {
			this.number = number;
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
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 노드의 개수와 거리를 알고 싶은 노드 쌍의 개수를 각 변수에 할당
		int nodeNum = Integer.parseInt(st.nextToken());
		int pairNum = Integer.parseInt(st.nextToken());
		
		// 두 노드 사이의 간선을 저장할 배열 초기화
		edges = new ArrayList[nodeNum + 1];
		
		// for 반복문을 사용해 두 노드 사이의 간선을 저장할 List 객체 초기화
		for (int idx = 0; idx < edges.length; idx++)
			edges[idx] = new ArrayList<>();
		
		// for 반복문을 사용해 입력 받은 각 간선의 정보를 순회
		for (int edge = 0; edge < nodeNum - 1; edge++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 간선의 정보를 각 변수에 할당
			int startNode = Integer.parseInt(st.nextToken());
			int endNode = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			
			// add() 메서드를 사용해 간선의 정보를 배열 edges에 추가
			edges[startNode].add(new Node(endNode, distance));
			edges[endNode].add(new Node(startNode, distance));
		}
		
		// for 반복문을 사용해 거리를 알고 싶은 각 노드 쌍을 순회
		for (int pair = 0; pair < pairNum; pair++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 두 노드를 각 변수에 할당
			int startNode = Integer.parseInt(st.nextToken());
			int endNode = Integer.parseInt(st.nextToken());
			
			// distCalculator() 메서드를 호출해 두 노드 사이의 거리를 변수 distance에 할당
			int distance = distCalculator(nodeNum, startNode, endNode);
			
			// write() 메서드를 사용해 두 노드 사이의 거리를 출력
			out.write(distance + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// distCalculator() 메서드 정의
	public static int distCalculator(int nodeNum, int startNode, int endNode) {
		
		// 두 노드 사이의 거리를 저장할 배열 distance 초기화
		int distance = 0;
		
		// 각 노드의 방문 여부를 저장할 배열 visited 초기화
		visited = new boolean[nodeNum + 1];
		
		// 다음에 방문할 노드를 저장할 Queue 객체 visitList 초기화
		Queue<Node> visitList = new LinkedList<>();
		
		// offer() 메서드를 사용해 출발 노드를 visitList에 추가 및 방문 처리
		visitList.offer(new Node(startNode, 0));
		visited[startNode] = true;
		
		// while 반복문을 사용해 visitList가 빌 때까지 순회
		while (!visitList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 방문 중인 노드를 배열 curNode에 할당
			Node curNode = visitList.poll();
			
			// 현재 방문 중인 노드가 도착 노드인 경우 두 노드 사이의 거리를 갱신 후 반복문 탈출
			if (curNode.number == endNode) {
				distance = curNode.distance;
				break;
			}
			
			// for 반복문을 사용해 연결된 노드를 순회
			for (Node nextNode : edges[curNode.number]) {
				
				// 해당 노드를 이미 방문한 경우 다음 노드를 순회
				if (visited[nextNode.number])
					continue;
				
				// offer() 메서드를 사용해 다음 노드를 visitList에 추가 및 방문 처리
				visitList.offer(new Node(nextNode.number, curNode.distance + nextNode.distance));
				visited[nextNode.number] = true;
			}
		}
		
		// 두 노드 사이의 거리를 반환
		return distance;
	}
}