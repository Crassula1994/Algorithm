package gold4.num04803;

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
	
	// 각 정점의 연결 정보와 방문 여부를 저장할 각 배열 초기화
	static List<Integer>[] edges;
	static boolean[] visited;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 테스트 케이스의 번호를 나타낼 변수 testCase 초기화
		int testCase = 0;
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (true) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 정점의 개수와 간선의 개수를 각 변수에 할당
			int nodeNum = Integer.parseInt(st.nextToken());
			int edgeNum = Integer.parseInt(st.nextToken());
			
			// 0이 두 개 입력된 경우 반복문 탈출
			if (nodeNum == 0 && edgeNum == 0)
				break;
			
			// 각 정점의 연결 정보와 방문 여부를 저장할 배열 초기화
			edges = new ArrayList[nodeNum + 1];
			visited = new boolean[nodeNum + 1];
			
			// for 반복문을 사용해 각 정점의 연결 정보를 저장할 List 객체 초기화
			for (int idx = 0; idx < edges.length; idx++)
				edges[idx] = new ArrayList<>();
			
			// for 반복문을 사용해 각 간선 정보를 순회
			for (int edge = 0; edge < edgeNum; edge++) {
				
				// StringTokenizer 객체를 불러와 변수 st에 재할당
				st = new StringTokenizer(in.readLine());
				
				// nextToken() 및 parseInt() 메서드를 사용해 각 간선의 연결 정점을 각 변수에 할당
				int startNode = Integer.parseInt(st.nextToken());
				int endNode = Integer.parseInt(st.nextToken());
				
				// add() 메서드를 사용해 각 간선의 연결 정보를 배열 edges에 저장
				edges[startNode].add(endNode);
				edges[endNode].add(startNode);
			}
			
			// 트리의 개수를 저장할 변수 treeNum 초기화
			int treeNum = 0;
			
			// for 반복문을 사용해 각 정점을 순회
			for (int node = 1; node <= nodeNum; node++) {
				
				// 해당 정점을 방문한 경우 다음 정점을 순회
				if (visited[node])
					continue;
				
				// treeFinder() 메서드를 호출해 트리인 경우 트리의 개수를 갱신
				treeNum = (treeFinder(node)) ? treeNum + 1 : treeNum;
			}
			
			// write() 메서드를 사용해 테스트 케이스의 번호를 출력
			out.write("Case " + ++testCase + ": ");
			
			// 트리가 없는 경우 정해진 문구를 출력
			if (treeNum == 0) {
				out.write("No trees.");
				
			// 트리가 1개인 경우 정해진 문구를 출력
			} else if (treeNum == 1) {
				out.write("There is one tree.");
				
			// 트리가 2개 이상인 경우 정해진 문구를 출력
			} else {
				out.write("A forest of " + treeNum + " trees.");
			}
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// treeFinder() 메서드 정의
	public static boolean treeFinder(int startNode) {
		
		// 정점의 개수와 간선의 개수를 저장할 각 변수 초기화
		int nodeCnt = 0;
		int edgeCnt = 0;
		
		// 다음에 방문할 정점을 저장할 Queue 객체 visitList 초기화
		Queue<Integer> visitList = new LinkedList<>();
		
		// offer() 메서드를 사용해 시작 정점을 visitList에 추가 및 방문 처리
		visitList.offer(startNode);
		visited[startNode] = true;
		
		// while 반복문을 사용해 visitList가 빌 때까지 순회
		while (!visitList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 정점을 변수 curNode에 할당
			int curNode = visitList.poll();
			
			// 정점의 개수와 간선의 개수를 갱신
			nodeCnt++;
			edgeCnt += edges[curNode].size();
			
			// for 반복문을 사용해 연결된 정점을 순회
			for (int nextNode : edges[curNode]) {
				
				// 해당 정점을 이미 방문한 경우 다음 정점을 순회
				if (visited[nextNode])
					continue;
				
				// offer() 메서드를 사용해 해당 정점을 visitList에 추가 및 방문 처리
				visitList.offer(nextNode);
				visited[nextNode] = true;
			}
		}
		
		// 해당 정점이 포함된 그래프가 트리인지 여부를 반환
		return edgeCnt == (nodeCnt - 1) * 2;
	}
}