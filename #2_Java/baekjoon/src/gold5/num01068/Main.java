package gold5.num01068;

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
	
	// 루트 노드 및 지울 노드의 번호, 리프 노드의 개수를 저장할 각 변수 초기화
	static int rootNode;
	static int deletedNode;
	static int count = 0;
	
	// 각 노드에 대한 정보를 저장할 배열 nodes 초기화
	static Node[] nodes;
	
	// Node 클래스 정의
	static class Node {
		
		// 해당 노드의 부모 노드를 저장할 변수 parent 초기화
		int parent;
		
		// 해당 노드의 자식 노드를 저장할 List 객체 children 초기화
		List<Integer> children = new ArrayList<>();
		
		// 기본 생성자 정의
		public Node() {}
	}
	
	// ----------------------------------------------------------------------------------------------------
			
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 노드의 개수를 변수 nodeNum에 할당
		int nodeNum = Integer.parseInt(in.readLine());
		
		// 각 노드에 대한 정보를 저장할 배열 nodes 초기화
		nodes = new Node[nodeNum];
		
		// for 반복문을 사용해 각 노드를 초기화
		for (int idx = 0; idx < nodeNum; idx++)
			nodes[idx] = new Node();
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 노드에 정보를 순회
		for (int idx = 0; idx < nodeNum; idx++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 노드의 부모를 갱신
			nodes[idx].parent = Integer.parseInt(st.nextToken());
			
			// 해당 위치가 루트 노드인 경우 변수 rootNode 갱신
			if (nodes[idx].parent == -1) {
				rootNode = idx;
			
			// 해당 위치가 루트 노드가 아닌 경우 각 자식 노드를 갱신
			} else {
				nodes[nodes[idx].parent].children.add(idx);
			}
		}
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 지울 노드의 번호를 변수 deletedNode에 할당
		deletedNode = Integer.parseInt(in.readLine());
		
		// 지울 노드의 번호가 루트 노드인 경우 0 출력
		if (deletedNode == rootNode) {
			out.write(String.valueOf(0));
		
		// 지울 노드의 번호가 루트 노드가 아닌 경우
		} else {
			
			// nodeRemover() 메서드를 호출해 지울 노드와 부모 노드와의 연결을 제거
			nodeRemover();
			
			// leafNodeFinder() 메서드를 호출해 리프 노드의 개수를 갱신
			leafNodeFinder(rootNode);
			
			// valueOf() 및 write() 메서드를 사용해 리프 노드의 개수를 출력
			out.write(String.valueOf(count));
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------

	// nodeRemover() 메서드 정의
	public static void nodeRemover() {
		
		// 지울 노드의 부모 노드 번호 및 지울 노드의 부모 노드로부터 제거할 인덱스를 저장할 각 변수 초기화
		int parentNode = nodes[deletedNode].parent;
		int deletedIdx = -1;
		
		// for 반복문을 사용해 부모 노드의 자식 노드를 순회
		for (int idx = 0; idx < nodes[parentNode].children.size(); idx++) {
			
			// 해당 노드가 지울 노드인 경우 인덱스 갱신 후 반복문 탈출
			if (nodes[parentNode].children.get(idx) == deletedNode) {
				deletedIdx = idx;
				break;
			}
		}
		
		// remove() 메서드를 사용해 해당 노드와의 연결을 제거
		nodes[parentNode].children.remove(deletedIdx);
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// leafNodeFinder() 메서드 정의
	public static void leafNodeFinder(int nodeNum) {
		
		// 현재 방문 중인 노드를 변수 currentNode에 할당
		Node currentNode = nodes[nodeNum];
		
		// 해당 노드의 자식 노드가 존재하지 않는 경우 리프 노드의 개수 갱신 후 메서드 종료
		if (currentNode.children.isEmpty()) {
			count++;
			return;
		}
		
		// for 반복문을 사용해 각 자식 노드에 대해 leafNodeFinder() 메서드 재귀 호출
		for (int idx = 0; idx < currentNode.children.size(); idx++)
			leafNodeFinder(currentNode.children.get(idx));
	}
}