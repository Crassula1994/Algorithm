package gold2.num04933;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// readLine() 및 binaryTreeMaker() 메서드를 사용해 입력 받은 두 트리에 대하여 각 정점의 부모 정점을 각 배열에 저장
			int[] firstTree = binaryTreeMaker(in.readLine());
			int[] secondTree = binaryTreeMaker(in.readLine());
			
			// binaryTreeChecker() 및 write() 메서드를 사용해 두 트리가 동등한지 여부를 출력
			out.write(binaryTreeChecker(firstTree, secondTree));
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// binaryTreeMaker() 메서드 정의
	public static int[] binaryTreeMaker(String treeString) {
		
		// 주어진 트리의 각 정점의 부모 정점을 저장할 배열 parentNodes 초기화
		int[] parentNodes = new int[27];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(treeString);
		
		// 후위순회 방식으로 저장된 정점을 차례로 저장할 Stack 객체 nodes 초기화
		Stack<Integer> nodes = new Stack<>();
		
		// while 반복문을 사용해 각 정점을 순회
		while (st.hasMoreTokens()) {
			
			// nextToken() 메서드를 사용해 현재 정점을 변수 node에 할당
			String node = st.nextToken();
			
			// 모든 정점을 확인한 경우 반복문 탈출
			if (node.equals("end"))
				break;
			
			// equals() 및 charAt() 메서드를 사용해 현재 정점을 인덱스로 변환한 결과를 변수 nodeIdx에 할당
			int nodeIdx = (node.equals("nil")) ? 0 : node.charAt(0) - 'A' + 1;
			
			// 현재 정점이 부모 정점인 경우
			if (nodeIdx != 0 && nodes.size() >= 2) {
				
				// pop() 메서드를 사용해 각 자식 정점을 각 변수에 할당
				int rightIdx = nodes.pop();
				int leftIdx = nodes.pop();
				
				// 오른쪽 서브트리가 존재하는 경우 오른쪽 자식 정점의 부모 정점을 갱신
				if (rightIdx != 0)
					parentNodes[rightIdx] = nodeIdx;
				
				// 왼쪽 서브트리가 존재하는 경우 왼쪽 자식 정점의 부모 정점을 갱신
				if (leftIdx != 0)
					parentNodes[leftIdx] = nodeIdx;
			}
			
			// push() 메서드를 사용해 nodes에 해당 정점의 인덱스를 저장
			nodes.push(nodeIdx);
		}
		
		// pop() 메서드를 사용해 루트 정점을 변수 rootNode에 할당
		int rootNode = nodes.pop();
		
		// 루트 정점의 부모 정점을 자기 자신으로 갱신
		parentNodes[rootNode] = rootNode;
		
		// 주어진 트리의 각 정점의 부모 정점을 저장할 배열 반환
		return parentNodes;
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// binaryTreeChecker() 메서드 정의
	public static String binaryTreeChecker(int[] firstTree, int[] secondTree) {
		
		// for 반복문을 사용해 각 트리의 정점을 순회
		for (int idx = 1; idx < 27; idx++) {
			
			// 해당 정점의 부모 정점이 다른 경우 동등하지 않으므로 'false' 반환
			if (firstTree[idx] != secondTree[idx])
				return "false";
		}
		
		// 두 트리가 동등한 경우 'true' 반환
		return "true";
	}
}