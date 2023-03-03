package silver2.num24480;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 정점 간 연결 여부를 저장할 Map 객체 connection 초기화
	static Map<Integer, ArrayList<Integer>> connection;
	
	// 정점의 방문 여부를 저장할 배열 visited 초기화
	static int[] visited;
	
	// 방문 순서를 나타내는 변수 visitCnt 초기화
	static int visitCnt = 1;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 정점의 수, 간선의 수, 시작 정점을 각 변수에 할당
		int nodeNum = Integer.parseInt(st.nextToken());
		int edgeNum = Integer.parseInt(st.nextToken());
		int startNode = Integer.parseInt(st.nextToken());
		
		// 정점 간 연결 여부를 저장할 Map 객체 connection 초기화
		connection = new HashMap<>();
		
		// for 반복문을 사용해 정점의 개수만큼 연결 여부를 connection에 추가
		for (int node = 1; node <= nodeNum; node++)
			connection.put(node, new ArrayList<>());
		
		// 정점의 방문 여부를 저장할 배열 visited 초기화
		visited = new int[nodeNum + 1];
		
		// for 반복문을 사용해 각 간선 정보를 순회
		for (int e = 0; e < edgeNum; e++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 각 정점을 각 변수에 할당
			int toNode = Integer.parseInt(st.nextToken());
			int fromNode = Integer.parseInt(st.nextToken());
			
			// 두 정점 간 연결 정보를 추가
			connection.get(toNode).add(fromNode);
			connection.get(fromNode).add(toNode);
		}
			
		// for 반복문을 사용해 정점의 연결 여부를 내림차순으로 정렬
		for (int node = 1; node <= nodeNum; node++)
			Collections.sort(connection.get(node), Collections.reverseOrder());
		
		// dfs() 메서드를 호출해 각 정점별 방문 횟수를 갱신
		dfs(startNode);
		
		// for 반복문을 사용해 각 정점의 방문 순서를 출력
		for (int idx = 1; idx < visited.length; idx++)
			out.write(visited[idx] + "\n");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// dfs() 메서드 정의
	public static void dfs(int startNode) {
		
		// 시작 정점을 방문 처리
		visited[startNode] = visitCnt++;
	
		// for 반복문을 사용해 연결된 정점을 순회
		for (int idx = 0; idx < connection.get(startNode).size(); idx++) {
			
			// get() 메서드를 사용해 연결된 정점을 변수 nextNode에 할당
			int nextNode = connection.get(startNode).get(idx);
			
			// 해당 정점을 방문한 적이 없는 경우 dfs() 메서드 재귀 호출
			if (visited[nextNode] == 0)
				dfs(nextNode);
		}
	}
}