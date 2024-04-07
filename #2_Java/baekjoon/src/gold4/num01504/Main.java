package gold4.num01504;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 정점의 수, 간선의 수, 반드시 거쳐야 하는 두 개의 정점을 저장할 각 변수 초기화
	static int nodeNum;
	static int edgeNum;
	static int node1;
	static int node2;
	
	// 연결된 간선의 정보를 저장할 배열 edges 초기화
	static List<int[]>[] edges;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 정점의 개수와 간선의 개수를 각 변수에 할당
		nodeNum = Integer.parseInt(st.nextToken());
		edgeNum = Integer.parseInt(st.nextToken());
		
		// 연결된 간선의 정보를 저장할 배열 edges 초기화
		edges = new ArrayList[nodeNum + 1];
		
		// for 반복문을 사용해 연결된 간선의 정보를 저장할 List 객체 초기화
		for (int idx = 0; idx < edges.length; idx++)
			edges[idx] = new ArrayList<>();
		
		// for 반복문을 사용해 각 간선의 정보를 순회
		for (int edge = 0; edge < edgeNum; edge++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 간선의 각 정점, 거리를 각 변수에 할당
			int startNode = Integer.parseInt(st.nextToken());
			int endNode = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			
			// add() 메서드를 사용해 연결된 간선의 정보를 배열 edges에 추가
			edges[startNode].add(new int[] {endNode, distance});
			edges[endNode].add(new int[] {startNode, distance});
		}
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 반드시 거쳐야 하는 두 개의 정점을 각 변수에 할당
		node1 = Integer.parseInt(st.nextToken());
		node2 = Integer.parseInt(st.nextToken());
		
		// distanceCalculator() 메서드를 호출해 두 개의 정점을 지나는 최단 경로의 길이를 변수 minDistance에 할당
		long minDistance = distanceCalculator();
		
		// valueOf() 및 write() 메서드를 사용해 두 개의 정점을 지나는 최단 경로의 길이를 출력
		out.write(String.valueOf(minDistance));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// distanceCalculator() 메서드 정의
	public static long distanceCalculator() {
		
		// pathFinder() 메서드를 호출해 반드시 거쳐야 하는 두 정점 사이의 최단 거리를 변수 distN1N2에 할당
		long distN1N2 = pathFinder(node1, node2);
		
		// 반드시 거쳐야 하는 두 정점이 연결되지 않은 경우 -1 반환
		if (distN1N2 == Integer.MAX_VALUE)
			return -1;
		
		// pathFinder() 메서드를 호출해 각 정점 사이의 최단 거리를 각 변수에 할당
		long distSN1 = pathFinder(1, node1);
		long distSN2 = pathFinder(1, node2);
		long distN1E = pathFinder(node1, nodeNum);
		long distN2E = pathFinder(node2, nodeNum);
		
		// 경로를 택하는 두 가지 경우의 최단 거리를 각 변수에 할당
		long distSN1N2E = distSN1 + distN1N2 + distN2E;
		long distSN2N1E = distSN2 + distN1N2 + distN1E;
		
		// 반드시 거쳐야 하는 두 개의 정점에 도달할 수 없는 경우 -1 반환
		if (distSN1N2E >= Integer.MAX_VALUE && distSN2N1E >= Integer.MAX_VALUE)
			return -1;
		
		// min() 메서드를 사용해 최단 거리가 더 짧은 경우 반환
		return Math.min(distSN1N2E, distSN2N1E);
	}

	// ----------------------------------------------------------------------------------------------------
	
	// pathFinder() 메서드 정의
	public static int pathFinder(int startNode, int endNode) {
		
		// 다음에 확인할 정점을 저장할 PriorityQueue 객체 checkList 초기화
		PriorityQueue<int[]> checkList = new PriorityQueue<>((n1, n2) -> {
			return n1[1] - n2[1];
		});
		
		// 시작 정점과 다른 정점 사이의 최소 거리, 해당 정점의 확인 여부를 저장할 각 배열 초기화
		int[] minDist = new int[nodeNum + 1];
		boolean[] checked = new boolean[nodeNum + 1];
		
		// fill() 메서드를 사용해 시작 정점과 다른 정점 사이의 최소 거리를 초기화
		Arrays.fill(minDist, Integer.MAX_VALUE);
		
		// 시작 정점의 최소 소요 시간을 설정
		minDist[startNode] = 0;
		
		// offer() 메서드를 사용해 시작 정점을 checkList에 추가
		checkList.offer(new int[] {startNode, 0});
		
		// while 반복문을 사용해 checkList가 빌 때까지 순회
		while (!checkList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 확인 중인 정점을 배열 curNode에 할당
			int[] curNode = checkList.poll();
			
			// 해당 정점을 이동한 적이 없는 경우
			if (!checked[curNode[0]]) {
				
				// 현재 확인 중인 정점을 확인 처리
				checked[curNode[0]] = true;
				
				// for 반복문을 사용해 해당 정점과 연결된 다른 정점을 순회
				for (int idx = 0; idx < edges[curNode[0]].size(); idx++) {
					
					// get() 메서드를 사용해 연결된 정점 및 거리를 각 변수에 할당
					int node = edges[curNode[0]].get(idx)[0];
					int distance = edges[curNode[0]].get(idx)[1];
					
					// 해당 정점까지의 최단 거리가 저장된 최단 거리보다 짧은 경우 최단 거리 갱신 후 checkList에 추가
					if (minDist[node] > minDist[curNode[0]] + distance) {
						minDist[node] = minDist[curNode[0]] + distance;
						checkList.offer(new int[] {node, minDist[node]});
					}
				}
			}
		}
		
		// 시작 종점에서 끝 종점까지의 최단 거리를 반환
		return minDist[endNode];
	}
}