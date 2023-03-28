package silver2.num11725;

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
	
	// 각 노드와 연결된 노드 및 부모 노드를 저장할 각 배열 초기화
	static List<Integer>[] connection;
	static int[] parentNodes;
	
	// 노드의 개수를 저장할 변수 nodeNum 초기화
	static int nodeNum;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 노드의 개수를 변수 nodeNum에 할당
		nodeNum = Integer.parseInt(in.readLine());
		
		// 각 노드와 연결된 노드를 저장할 배열 connection 초기화
		connection = new ArrayList[nodeNum + 1];
		
		// for 반복문을 사용해 connection 내의 ArrayList 객체 초기화
		for (int idx = 0; idx < connection.length; idx++)
			connection[idx] = new ArrayList<>();
		
		// 각 노드의 부모 노드를 저장할 배열 parentNodes 초기화
		parentNodes = new int[nodeNum + 1];
		
		// for 반복문을 사용해 각 간선의 정보를 순회
		for (int edge = 1; edge < nodeNum; edge++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 각 노드를 각 변수에 할당
			int toNode = Integer.parseInt(st.nextToken());
			int fromNode = Integer.parseInt(st.nextToken());
			
			// add() 메서드를 사용해 각 노드에 연결된 노드를 추가
			connection[toNode].add(fromNode);
			connection[fromNode].add(toNode);
		}
		
		// parentNodeFinder() 메서드를 호출해 각 노드별 부모 노드를 배열 parentNodes에 저장
		parentNodeFinder(1);
		
		// for 반복문을 사용해 각 노드의 부모 노드를 2번 노드부터 차례대로 출력
		for (int idx = 2; idx <= nodeNum; idx++)
			out.write(parentNodes[idx] + "\n");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// parentNodeFinder() 메서드 정의 
	public static void parentNodeFinder(int startNode) {
		
		// 해당 노드의 방문 여부를 저장할 배열 visited 초기화
		boolean[] visited = new boolean[nodeNum + 1];
		
		// 다음에 방문할 위치를 저장할 Queue 객체 visitList 초기화
		Queue<Integer> visitList = new LinkedList<>();
		
		// offer() 메서드를 사용해 시작 노드를 visitList에 추가 및 방문 처리
		visitList.offer(startNode);
		visited[startNode] = true;
		
		// while 반복문을 사용해 visitList가 빌 때까지 순회
		while (!visitList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 방문 중인 노드를 변수 currentNode에 할당
			int currentNode = visitList.poll();
			
			// for 반복문을 사용해 현재 노드와 연결된 다른 노드를 순회
			for (int idx = 0; idx < connection[currentNode].size(); idx++) {
				
				// get() 메서드를 사용해 해당 노드를 변수 nextNode에 할당
				int nextNode = connection[currentNode].get(idx);
				
				// 해당 노드를 방문한 적이 없는 경우
				if (!visited[nextNode]) {
					
					// 부모 노드를 배열 parentNodes에 저장
					parentNodes[nextNode] = currentNode;
					
					// offer() 메서드를 사용해 해당 노드를 visitList에 추가 및 방문 처리
					visitList.offer(nextNode);
					visited[nextNode] = true;
				}
			}
		}
	}
}