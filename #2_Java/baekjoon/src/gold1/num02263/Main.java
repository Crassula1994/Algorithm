package gold1.num02263;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 정점의 개수, 배열 preOrder의 인덱스를 저장할 각 변수 초기화
	static int nodeNum;
	static int preIndex = 0;
	
	// 트리의 전위, 중위, 후위 순회 결과를 저장할 각 배열 초기화
	static int[] preOrder;
	static int[] inOrder;
	static int[] postOrder;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 정점의 개수를 변수 nodeNum에 할당
		nodeNum = Integer.parseInt(in.readLine());
		
		// 트리의 전위, 중위, 후위 순회 결과를 저장할 각 배열 초기화
		preOrder = new int[nodeNum];
		inOrder = new int[nodeNum];
		postOrder = new int[nodeNum];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 중위 순회의 결과를 배열 inOrder에 저장
		for (int idx = 0; idx < nodeNum; idx++)
			inOrder[idx] = Integer.parseInt(st.nextToken());

		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 후위 순회의 결과를 배열 postOrder에 저장
		for (int idx = 0; idx < nodeNum; idx++)
			postOrder[idx] = Integer.parseInt(st.nextToken());
		
		// preOrderMaker() 메서드를 호출해 전위 순회의 결과를 갱신
		preOrderMaker(0, nodeNum - 1, 0, nodeNum - 1);
		
		// for 반복문을 사용해 전위 순회의 결과를 출력
		for (int idx = 0; idx < nodeNum; idx++)
			out.write(preOrder[idx] + " ");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// preOrderMaker() 메서드 정의
	public static void preOrderMaker(int inStart, int inEnd, int postStart, int postEnd) {
		
		// 해당 범위 내에 값이 더 이상 존재하지 않는 경우 메서드 종료
		if (inStart > inEnd || postStart > postEnd)
			return;
		
		// 해당 범위의 후위 순회의 마지막 값이 루트 노드이므로 이를 배열 preOrder에 추가
		preOrder[preIndex++] = postOrder[postEnd];
		
		// 중위 순회에서 루트 노드의 인덱스를 저장할 변수 rootIndex 초기화
		int rootIndex = -1;
		
		// for 반복문을 사용해 배열 inOrder의 해당 범위를 순회
		for (int idx = inStart; idx <= inEnd; idx++) {
			
			// 해당 값이 루트 노드인 경우 중위 순회에서 루트 노드의 인덱스 갱신 후 반복문 탈출
			if (inOrder[idx] == postOrder[postEnd]) {
				rootIndex = idx;
				break;
			}
		}
		
		// 왼쪽 자식 노드와 오른쪽 자식 노드를 나누어 preOrderMaker() 메서드를 재귀 호출
		preOrderMaker(inStart, rootIndex - 1, postStart, postStart - inStart + rootIndex - 1);
		preOrderMaker(rootIndex + 1, inEnd, postStart - inStart + rootIndex, postEnd - 1);
	}
}