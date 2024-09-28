package silver1.num15900;

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
	
	// 각 리프 노드에서 루트 노드까지의 거리 합을 저장할 변수 distSum 초기화
	static int distSum = 0;
	
	// 각 정점의 확인 여부 및 각 정점의 간선 연결 정보를 저장할 각 배열 초기화
	static boolean[] checked;
	static List<Integer>[] edges;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 트리의 정점 개수를 변수 nodeNum에 할당
		int nodeNum = Integer.parseInt(in.readLine());
		
		// 각 정점의 확인 여부 및 각 정점의 간선 연결 정보를 저장할 각 배열 초기화
		checked = new boolean[nodeNum + 1];
		edges = new ArrayList[nodeNum + 1];
		
		// for 반복문을 사용해 각 정점의 간선 연결 정보를 저장할 List 객체 초기화
		for (int idx = 0; idx < edges.length; idx++)
			edges[idx] = new ArrayList<>();
		
		// for 반복문을 사용해 각 간선의 정보를 순회
		for (int edge = 0; edge < nodeNum - 1; edge++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 해당 간선과 연결된 두 정점의 번호를 각 변수에 할당
			int startNode = Integer.parseInt(st.nextToken());
			int endNode = Integer.parseInt(st.nextToken());
			
			// add() 메서드를 사용해 간선의 연결 정보를 배열 edges에 저장
			edges[startNode].add(endNode);
			edges[endNode].add(startNode);
		}
		
		// distCalculator() 메서드를 호출해 각 리프 노드에서 루트 노드까지의 거리 합을 갱신
		distCalculator(1, 0);
		
		// write() 메서드를 사용해 성원이가 게임을 이길 수 있는지 여부를 출력
		out.write(((distSum & 1) == 1) ? "Yes" : "No");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// distCalculator() 메서드 정의
	public static void distCalculator(int curNode, int distance) {
		
		// 해당 정점이 리프 노드인지 여부를 저장할 변수 isLeafNode 초기화
		boolean isLeafNode = true;
		
		// 현재 정점을 방문 처리
		checked[curNode] = true;
		
		// for 반복문을 사용해 연결된 다른 정점을 순회
		for (int nextNode : edges[curNode]) {
			
			// 해당 정점을 이미 방문한 경우 다음 정점을 순회
			if (checked[nextNode])
				continue;
			
			// 해당 정점이 리프 노드인지 여부를 갱신
			isLeafNode = false;
			
			// distCalculator() 메서드 재귀 호출
			distCalculator(nextNode, distance + 1);
		}
		
		// 해당 정점이 리프 노드인 경우 루트 노드까지의 거리 합을 갱신
		if (isLeafNode)
			distSum += distance;
	}
}