package gold5.num15681;

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
	
	// 각 정점의 연결 정보, 각 정점에 속한 하위 정점의 개수, 계산 여부를 저장할 각 배열 초기화
	static List<Integer>[] edges;
	static int[] counts;
	static boolean[] counted;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 트리의 정점의 수, 루트의 번호, 쿼리의 수를 각 변수에 할당
		int nodeNum = Integer.parseInt(st.nextToken());
		int rootNode = Integer.parseInt(st.nextToken());
		int queryNum = Integer.parseInt(st.nextToken());
		
		// 각 정점의 연결 정보, 각 정점에 속한 하위 정점의 개수, 계산 여부를 저장할 각 배열 초기화
		edges = new ArrayList[nodeNum + 1];
		counts = new int[nodeNum + 1];
		counted = new boolean[nodeNum + 1];
		
		// for 반복문을 사용해 각 정점의 연결 정보를 저장할 List 객체 초기화
		for (int idx = 0; idx < edges.length; idx++)
			edges[idx] = new ArrayList<>();
		
		// for 반복문을 사용해 각 간선을 순회
		for (int edge = 0; edge < nodeNum - 1; edge++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 간선이 연결하는 정점을 각 변수에 할당
			int startNode = Integer.parseInt(st.nextToken());
			int endNode = Integer.parseInt(st.nextToken());
			
			// add() 메서드를 사용해 각 간선의 정보를 배열 edges에 저장
			edges[startNode].add(endNode);
			edges[endNode].add(startNode);
		}
		
		// nodeCounter() 메서드를 호출해 각 정점에 속한 하위 정점의 개수를 갱신
		nodeCounter(rootNode);
		
		// for 반복문을 사용해 각 쿼리를 순회
		for (int q = 0; q < queryNum; q++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 쿼리를 변수 query에 할당
			int query = Integer.parseInt(in.readLine());
			
			// write() 메서드를 사용해 해당 쿼리의 답을 출력
			out.write(counts[query] + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// nodeCounter() 메서드 정의
	public static int nodeCounter(int currentNode) {
		
		// 해당 정점에 속한 정점의 개수를 초기화
		counts[currentNode] = 1;
		
		// 해당 정점을 계산한 것으로 처리
		counted[currentNode] = true;
		
		// for 반복문을 사용해 해당 정점과 연결된 정점을 순회
		for (int nextNode : edges[currentNode]) {
			
			// 해당 정점을 이미 계산한 경우 다음 정점을 순회
			if (counted[nextNode])
				continue;
			
			// nodeCounter() 메서드를 재귀 호출해 해당 정점에 속한 정점의 개수를 갱신
			counts[currentNode] += nodeCounter(nextNode);
		}
		
		// 해당 정점에 속한 정점의 개수를 반환
		return counts[currentNode];
	}
}