package gold4.num25515;

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
	
	// 노드의 개수를 저장할 변수 nodeNum 초기화
	static int nodeNum;
	
	// 각 노드에 적힌 정수, 각 노드에서의 최댓값, 연결된 간선의 정보를 저장할 각 배열 초기화
	static int[] nodes;
	static long[] maxValues;
	static List<Integer>[] edges;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 노드의 개수를 변수 nodeNum에 할당
		nodeNum = Integer.parseInt(in.readLine());
		
		// 각 노드에 적힌 정수, 각 노드에서의 최댓값, 연결된 간선의 정보를 저장할 각 배열 초기화
		nodes = new int[nodeNum];
		maxValues = new long[nodeNum];
		edges = new ArrayList[nodeNum];
		
		// for 반복문을 사용해 연결된 간선의 정보를 저장할 각 List 객체 초기화
		for (int idx = 0; idx < edges.length; idx++)
			edges[idx] = new ArrayList<>();
		
		// for 반복문을 사용해 각 간선의 정보를 순회
		for (int edge = 0; edge < nodeNum - 1; edge++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 간선의 두 정점을 각 변수에 할당
			int parentNode = Integer.parseInt(st.nextToken());
			int childNode = Integer.parseInt(st.nextToken());
			
			// add() 메서드를 사용해 입력 받은 간선의 정보를 배열 edges에 저장
			edges[parentNode].add(childNode);
		}
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 노드의 정수를 배열 nodes에 저장
		for (int idx = 0; idx < nodes.length; idx++)
			nodes[idx] = Integer.parseInt(st.nextToken());
		
		// maxValueFinder() 메서드를 호출해 각 노드에서의 최댓값을 갱신
		maxValueFinder(0);
		
		// valueOf() 및 write() 메서드를 사용해 방문한 노드에 적혀 있는 정수 합의 최댓값을 출력
		out.write(String.valueOf(maxValues[0]));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// maxValueFinder() 메서드 정의
	public static void maxValueFinder(int curNode) {
		
		// 현재 노드에서 방문한 정수 합의 최댓값을 초기화
		maxValues[curNode] = nodes[curNode];
		
		// for 반복문을 사용해 연결된 자식 노드를 순회
		for (int nextNode : edges[curNode]) {
			
			// maxValueFinder() 메서드 재귀 호출
			maxValueFinder(nextNode);
			
			// max() 메서드를 사용해 현재 노드에서 방문한 정수 합의 최댓값을 갱신
			maxValues[curNode] = Math.max(maxValues[curNode] + maxValues[nextNode], maxValues[curNode]);
		}
	}
}