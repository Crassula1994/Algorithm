package gold3.num16940;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 각 정점의 실제 BFS 방문 순서, 트리의 간선 정보를 저장할 각 배열 초기화
	static int[] orders;
	static List<Integer>[] edges;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 정점의 수를 변수 nodeNum에 할당
		int nodeNum = Integer.parseInt(in.readLine());
		
		// 주어진 BFS 방문 순서가 올바른 순서인지 여부를 저장할 변수 isRight 초기화
		boolean isRight = true;
		
		// 각 정점의 주어진 BFS 방문 순서, 실제 BFS 방문 순서, 트리의 간선 정보를 저장할 각 배열 초기화
		int[] targetOrders = new int[nodeNum + 1];
		orders = new int[nodeNum + 1];
		edges = new ArrayList[nodeNum + 1];
		
		// for 반복문을 사용해 트리의 간선 정보를 저장할 각 List 객체 초기화
		for (int idx = 0; idx < edges.length; idx++)
			edges[idx] = new ArrayList<>();
		
		// for 반복문을 사용해 각 간선의 정보를 순회
		for (int edge = 0; edge < nodeNum - 1; edge++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 해당 간선이 연결하는 두 정점을 각 변수에 할당
			int startNode = Integer.parseInt(st.nextToken());
			int endNode = Integer.parseInt(st.nextToken());
			
			// add() 메서드를 사용해 해당 간선의 정보를 배열 edges에 저장
			edges[startNode].add(endNode);
			edges[endNode].add(startNode);
		}
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 주어진 BFS 방문 순서를 순회
		for (int order = 1; order <= nodeNum; order++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 현재 순서의 정점을 변수 node에 할당
			int node = Integer.parseInt(st.nextToken());
			
			// 해당 정점의 주어진 BFS 방문 순서를 배열 targetOrders에 저장
			targetOrders[node] = order;
		}
		
		// 1번 정점부터 시작하지 않는 경우 0을 출력
		if (targetOrders[1] != 1) {
			out.write("0");
			
		// 1번 정점부터 시작하는 경우
		} else {
			
			// for 반복문을 사용해 각 정점의 방문 순서에 따라 정점과 연결된 각 정점을 정렬
			for (List<Integer> nodeList : edges)
				Collections.sort(nodeList, (n1, n2) -> {
					return targetOrders[n1] - targetOrders[n2];
				});
			
			// orderFinder() 메서드를 호출해 각 정점의 BFS 방문 순서를 갱신
			orderFinder();
			
			// for 반복문을 사용해 각 정점을 순회
			for (int node = 1; node <= nodeNum; node++) {
				
				// 해당 정점의 방문 순서가 일치하지 않는 경우 주어진 BFS 방문 순서가 올바른 순서인지 여부를 갱신 후 반복문 탈출
				if (orders[node] != targetOrders[node]) {
					isRight = false;
					break;
				}
			}
			
			// write() 메서드를 사용해 주어진 BFS 방문 순서가 올바른 순서인지 여부를 출력
			out.write((isRight) ? "1" : "0");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// orderFinder() 메서드 정의
	public static void orderFinder() {
		
		// 현재 확인 중인 정점의 방문 순서를 저장할 변수 curOrder 초기화
		int curOrder = 1;
		
		// 다음에 방문할 정점을 저장할 Queue 객체 nodeList 초기화
		Queue<Integer> nodeList = new LinkedList<>();
		
		// offer() 메서드를 사용해 시작 정점을 nodeList에 추가 및 방문 처리
		nodeList.offer(1);
		orders[1] = curOrder++;
		
		// while 반복문을 사용해 nodeList가 빌 때까지 순회
		while (!nodeList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 확인 중인 정점을 변수 curNode에 할당
			int curNode = nodeList.poll();
			
			// for 반복문을 사용해 현재 정점과 연결된 정점을 순회
			for (int nextNode : edges[curNode]) {

				// 이전에 확인한 정점인 경우 다음 정점을 순회
				if (orders[nextNode] > 0)
					continue;
				
				// offer() 메서드를 사용해 해당 정점을 nodeList에 추가 및 방문 처리
				nodeList.offer(nextNode);
				orders[nextNode] = curOrder++;
			}
		}
	}
}