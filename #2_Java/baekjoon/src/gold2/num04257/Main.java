package gold2.num04257;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (true) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 트리의 최대 자식 개수를 변수 maxCount에 할당
			int maxCount = Integer.parseInt(st.nextToken());
			
			// 모든 테스트 케이스를 확인한 경우 반복문 탈출
			if (maxCount == 0)
				break;
			
			// nextToken() 메서드를 사용해 입력 받은 전위 순회 결과 및 후위 순회 결과를 각 변수에 할당
			String preOrder = st.nextToken();
			String postOrder = st.nextToken();
				
			// treeCounter() 및 write() 메서드를 사용해 주어진 전위 순회 및 후위 순회 결과를 갖는 트리의 개수를 출력
			out.write(treeCounter(maxCount, preOrder, postOrder) + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// treeCounter() 메서드 정의
	public static long treeCounter(int maxCount, String preOrder, String postOrder) {
		
		// 트리의 노드 개수가 1개인 경우 이를 만족하는 트리의 개수는 1개이므로 1을 반환
		if (preOrder.length() == 1)
			return 1;
		
		// 전위 순회 및 후위 순회 결과를 갖는 트리의 개수, 자식 노드의 개수, 자식 노드를 배치하는 순서의 수를 저장할 각 변수 초기화
		long totalCount = 1;
		int nodeCount = 0;
		long orderCount = 1;
		
		// substring() 메서드를 사용해 루트 노드를 제거한 전위 순회 및 후위 순회 결과를 갱신
		preOrder = preOrder.substring(1);
		postOrder = postOrder.substring(0, postOrder.length() - 1);
		
		// while 반복문을 사용해 각 자식 노드를 순회
		while (preOrder.length() > 0) {
			
			// 자식 노드의 개수를 갱신
			nodeCount++;
			
			// charAt() 및 indexOf() 메서드를 사용해 해당 자식 노드를 기준으로 한 서브트리의 인덱스를 변수 subTreeIndex에 할당
			int subTreeIndex = postOrder.indexOf(preOrder.charAt(0)) + 1;
			
			// substring() 메서드를 사용해 해당 자식 노드를 기준으로 한 서브트리의 전위 순회 및 후위 순회 결과를 각 변수에 할당
			String subPreOrder = preOrder.substring(0, subTreeIndex);
			String subPostOrder = postOrder.substring(0, subTreeIndex);
			
			// treeCounter() 메서드를 재귀 호출해 해당 서브트리를 갖는 트리의 개수를 전체 트리의 개수에 반영
			totalCount *= treeCounter(maxCount, subPreOrder, subPostOrder);
			
			// substring() 메서드를 사용해 해당 자식 노드를 기준으로 한 서브트리를 제거한 전위 순회 및 후위 순회 결과를 갱신
			preOrder = preOrder.substring(subTreeIndex);
			postOrder = postOrder.substring(subTreeIndex);
			
			// 자식 노드를 배치하는 순서의 수를 갱신
			orderCount = orderCount * (maxCount - nodeCount + 1) / nodeCount;
		}
		
		// 전위 순회 및 후위 순회 결과를 갖는 트리의 개수를 갱신
		totalCount *= orderCount;
		
		// 전위 순회 및 후위 순회 결과를 갖는 트리의 개수를 반환
		return totalCount;
	}
}