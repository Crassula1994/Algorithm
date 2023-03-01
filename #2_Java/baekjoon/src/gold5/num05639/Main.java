package gold5.num05639;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// Node 클래스 정의
	public static class Node {
		
		// 자신의 값, 왼쪽 자식 노드 및 오른쪽 자식 노드를 저장할 변수 초기화
		char self;
		char leftChild;
		char rightChild;
		
		// 매개변수를 입력 받는 생성자 정의
		public Node(char self, char leftChild, char rightChild) {
			this.self = self;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}
	}
	
	// 각 노드를 저장할 배열 nodes 초기화
	static Node[] nodes;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 이진 트리의 노드 개수를 변수 nodeNum에 할당
		int nodeNum = Integer.parseInt(in.readLine());
		
		// 각 노드를 저장할 배열 nodes 초기화
		nodes = new Node[nodeNum];
		
		// for 반복문을 사용해 배열 nodes의 각 원소를 순회
		for (int n = 0; n < nodeNum; n++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 charAt() 메서드를 입력해 노드의 각 정보를 각 변수에 할당
			char self = st.nextToken().charAt(0);
			char leftChild = st.nextToken().charAt(0);
			char rightChild = st.nextToken().charAt(0);
			
			// 새로운 노드를 생성해 배열 nodes에 저장
			nodes[self - 'A'] = new Node(self, leftChild, rightChild);
		}
		
		// preTrav() 메서드를 호출해 전위 순회의 결과를 출력
		preTrav('A', out);
		
		// newLine() 메서드를 사용해 줄바꿈 출력
		out.newLine();
		
		// inTrav() 메서드를 호출해 중위 순회의 결과를 출력
		inTrav('A', out);
		
		// newLine() 메서드를 사용해 줄바꿈 출력
		out.newLine();
		
		// postTrav() 메서드를 호출해 후위 순회의 결과를 출력
		postTrav('A', out);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// preTrav() 메서드 정의
	public static void preTrav(char startNode, BufferedWriter out) throws IOException {
		
		// 해당 노드의 인덱스를 변수 nodeIdx에 할당
		int nodeIdx = startNode - 'A';
		
		// 해당 노드의 각 정보를 각 변수에 할당
		char self = nodes[nodeIdx].self;
		char leftChild = nodes[nodeIdx].leftChild;
		char rightChild = nodes[nodeIdx].rightChild;
		
		// write() 메서드를 사용해 방문 처리한 노드를 출력
		out.write(self);
		
		// 왼쪽 자식 노드가 존재하고 방문하지 않은 경우 이를 순회하도록 preTrav() 메서드 재귀 호출
		if (leftChild != '.')
			preTrav(leftChild, out);
			
		// 오른쪽 자식 노드가 존재하고 방문하지 않은 경우 이를 순회하도록 preTrav() 메서드 재귀 호출
		if (rightChild != '.')
			preTrav(rightChild, out);
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// inTrav() 메서드 정의
	public static void inTrav(char startNode, BufferedWriter out) throws IOException {
		
		// 해당 노드의 인덱스를 변수 nodeIdx에 할당
		int nodeIdx = startNode - 'A';
		
		// 해당 노드의 각 정보를 각 변수에 할당
		char self = nodes[nodeIdx].self;
		char leftChild = nodes[nodeIdx].leftChild;
		char rightChild = nodes[nodeIdx].rightChild;
		
		// 왼쪽 자식 노드가 존재하고 방문하지 않은 경우 이를 순회하도록 inTrav() 메서드 재귀 호출
		if (leftChild != '.')
			inTrav(leftChild, out);

		// write() 메서드를 사용해 방문 처리한 노드를 출력
		out.write(self);
		
		// 오른쪽 자식 노드가 존재하고 방문하지 않은 경우 이를 순회하도록 inTrav() 메서드 재귀 호출
		if (rightChild != '.')
			inTrav(rightChild, out);
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// postTrav() 메서드 정의
	public static void postTrav(char startNode, BufferedWriter out) throws IOException {
		
		// 해당 노드의 인덱스를 변수 nodeIdx에 할당
		int nodeIdx = startNode - 'A';
		
		// 해당 노드의 각 정보를 각 변수에 할당
		char self = nodes[nodeIdx].self;
		char leftChild = nodes[nodeIdx].leftChild;
		char rightChild = nodes[nodeIdx].rightChild;
		
		// 왼쪽 자식 노드가 존재하고 방문하지 않은 경우 이를 순회하도록 postTrav() 메서드 재귀 호출
		if (leftChild != '.')
			postTrav(leftChild, out);

		// 오른쪽 자식 노드가 존재하고 방문하지 않은 경우 이를 순회하도록 postTrav() 메서드 재귀 호출
		if (rightChild != '.')
			postTrav(rightChild, out);
		
		// write() 메서드를 사용해 방문 처리한 노드를 출력
		out.write(self);
	}
}