package gold4.num30893;

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
	
	// 각 정점의 연결 여부 및 방문 여부를 저장할 각 배열 초기화
	static boolean[] visited;
	static List<Integer>[] edges;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 정점의 개수, 시작 정점, 목표 정점을 각 변수에 할당
		int nodeNum = Integer.parseInt(st.nextToken());
		int startNode = Integer.parseInt(st.nextToken());
		int targetNode = Integer.parseInt(st.nextToken());
		
		// 각 정점의 연결 여부 및 방문 여부를 저장할 각 배열 초기화
		visited = new boolean[nodeNum + 1];
		edges = new ArrayList[nodeNum + 1];
		
		// for 반복문을 사용해 각 정점의 연결 여부를 저장할 List 객체 초기화
		for (int idx = 0; idx < edges.length; idx++)
			edges[idx] = new ArrayList<>();
		
		// for 반복문을 사용해 각 간선을 순회
		for (int edge = 0; edge < nodeNum - 1; edge++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 해당 간선에 연결된 정점을 각 변수에 할당
			int nodeA = Integer.parseInt(st.nextToken());
			int nodeB = Integer.parseInt(st.nextToken());
			
			// add() 메서드를 사용해 각 정점의 연결 여부를 갱신
			edges[nodeA].add(nodeB);
			edges[nodeB].add(nodeA);
		}
		
		// gameSimulator() 메서드를 호출해 목표 정점에 도달할 수 있는지 여부를 변수 isPossible에 할당
		boolean isPossible = gameSimulator(startNode, targetNode, true);
		
		// write() 메서드를 사용해 목표 정점에 도달할 수 있는지 여부에 따라 선공, 후공 선택 여부를 출력
		out.write((isPossible) ? "First" : "Second");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// gameSimulator() 메서드 정의
	public static boolean gameSimulator(int curNode, int targetNode, boolean isFirst) {
		
		// 현재 정점이 목표 정점인 경우 true 반환
		if (curNode == targetNode)
			return true;
		
		// 현재 정점에서 목표 정점에 도달할 수 있는지 여부 및 자식 정점의 수를 나타낼 각 변수 초기화
		boolean isPossible = false;
		int count = 0;
		
		// 현재 정점을 방문 처리
		visited[curNode] = true;
		
		// for 반복문을 사용해 연결된 다른 정점을 순회
		for (int nextNode : edges[curNode]) {
			
			// 연결된 다른 정점을 이미 방문한 경우 다음 정점을 순회
			if (visited[nextNode])
				continue;
			
			// 자식 정점의 수를 갱신
			count++;
			
			// gameSimulator() 메서드를 재귀 호출해 목표 정점에 도달할 수 있는지 여부를 갱신
			isPossible |= gameSimulator(nextNode, targetNode, !isFirst);
		}
		
		// 현재가 후공 차례이고, 자식 노드가 2개 이상인 경우 false 반환
		if (!isFirst && count > 1)
			return false;
		
		// 현재 정점에서 목표 정점에 도달할 수 있는지 여부를 반환
		return isPossible;
	}
}