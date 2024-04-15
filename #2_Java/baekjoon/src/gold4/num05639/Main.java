package gold4.num05639;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// Node 클래스 정의
	public static class Node {
		
		// 자신의 값, 왼쪽 자식 노드 및 오른쪽 자식 노드를 저장할 변수 초기화
		int self;
		Node leftChild;
		Node rightChild;
		
		// 매개변수를 입력 받는 생성자 정의
		public Node(int self) {
			this.self = self;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 이진 트리의 루트 노드를 나타내는 Node 객체 rootNode 생성
		Node rootNode = new Node(Integer.parseInt(in.readLine()));

		// while 반복문을 사용해 각 노드를 순회
		while (true) {
			
			// 예외가 발생하지 않는 경우
			try {
			
				// readLine() 및 parseInt() 메서드를 사용해 입력 받은 노드의 번호를 변수 nextNode에 할당
				int nextNode = Integer.parseInt(in.readLine());
				
				// addNode() 메서드를 사용해 입력 받은 노드의 번호를 추가
				addNode(rootNode, nextNode);

			// 예외가 발생하는 경우 반복문 탈출
			} catch (NumberFormatException e) {
				break;
			}
		}
		
		// postTrav() 메서드를 호출해 후위 순회한 결과를 출력
		postTrav(rootNode, out);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// addNode() 메서드 정의
	public static void addNode(Node currentNode, int nextNode) {
		
		// 현재 노드보다 작은 값의 노드인 경우
		if (currentNode.self > nextNode) {
			
			// 왼쪽 자식 노드가 존재하지 않는 경우 새로 노드를 생성해 할당
			if (currentNode.leftChild == null) {
				currentNode.leftChild = new Node(nextNode);
			
			// 왼쪽 자식 노드가 존재하는 경우 왼쪽 자식 노드를 기준으로 노드를 생성해 할당하도록 addNode() 메서드 재귀 호출
			} else {
				addNode(currentNode.leftChild, nextNode);
			}
		
		// 현재 노드보다 큰 값의 노드인 경우
		} else {
			
			// 오른쪽 자식 노드가 존재하지 않는 경우 새로 노드를 생성해 할당
			if (currentNode.rightChild == null) {
				currentNode.rightChild = new Node(nextNode);
			
			// 오른쪽 자식 노드가 존재하는 경우 오른쪽 자식 노드를 기준으로 노드를 생성해 할당하도록 addNode() 메서드 재귀 호출
			} else {
				addNode(currentNode.rightChild, nextNode);
			}
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// postTrav() 메서드 정의
	public static void postTrav(Node rootNode, BufferedWriter out) throws IOException {
		
		// 왼쪽 자식 노드가 존재할 경우 이를 순회하도록 postTrav() 메서드 재귀 호출
		if (rootNode.leftChild != null)
			postTrav(rootNode.leftChild, out);

		// 오른쪽 자식 노드가 존재할 경우 이를 순회하도록 postTrav() 메서드 재귀 호출
		if (rootNode.rightChild != null)
			postTrav(rootNode.rightChild, out);
		
		// write() 메서드를 사용해 방문 처리한 노드를 출력
		out.write(rootNode.self + "\n");
	}
}