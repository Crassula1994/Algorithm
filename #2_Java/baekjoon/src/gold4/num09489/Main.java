package gold4.num09489;

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

		// while 반복문을 사용해 모든 테스트 케이스를 순회
		while (true) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 노드의 수와 사촌의 수를 구해야 하는 노드의 번호를 각 변수에 할당
			int nodeCnt = Integer.parseInt(st.nextToken());
			int targetNode = Integer.parseInt(st.nextToken());
			
			// 노드의 수와 사촌의 수를 구해야 하는 노드의 번호가 모두 0인 경우 반복문 탈출
			if (nodeCnt == 0 && targetNode == 0)
				break;
			
			// 각 노드의 번호 및 해당 노드의 부모를 저장할 각 배열 초기화
			int[] nodeNums = new int[nodeCnt];
			int[] parentNodes = new int[nodeCnt];
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// 부모 노드의 인덱스, 목표 노드의 인덱스를 저장할 각 변수 초기화
			int parentIdx = -1;
			int targetIdx = -1;
			
			// for 반복문을 사용해 입력 받은 각 노드 번호를 순회
			for (int idx = 0; idx < nodeCnt; idx++) {
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 노드 번호를 배열 nodeNums에 저장
				nodeNums[idx] = Integer.parseInt(st.nextToken());
				
				// 해당 노드가 목표 노드인 경우 목표 노드의 인덱스를 갱신
				if (nodeNums[idx] == targetNode)
					targetIdx = idx;
				
				// 루트 노드인 경우 부모 노드를 초기화 후 다음 노드 번호를 순회
				if (idx == 0) {
					parentNodes[idx] = -1;
					continue;
				}
				
				// 해당 노드 번호가 이전 번호와 연속되는 경우 부모 노드를 갱신
				if (nodeNums[idx] == nodeNums[idx - 1] + 1) {
					parentNodes[idx] = parentIdx;
				
				// 해당 노드 번호가 이전 번호와 연속되지 않는 경우 부모 노드를 갱신
				} else {
					parentNodes[idx] = ++parentIdx;
				}
			}
			
			// 사촌의 수를 저장할 변수 count 초기화
			int count = 0;
			
			// for 반복문을 사용해 각 노드를 순회
			for (int idx = 0; idx < nodeCnt; idx++) {
				
				// 해당 노드가 루트 노드이거나 루트 노드의 자식 노드인 경우 다음 노드를 순회
				if (parentNodes[idx] <= 0)
					continue;
				
				// 해당 노드가 사촌인 경우 사촌의 수를 갱신
				if (parentNodes[idx] != parentNodes[targetIdx] && parentNodes[parentNodes[idx]] == parentNodes[parentNodes[targetIdx]])
					count++;
			}
			
			// write() 메서드를 사용해 사촌의 수를 출력
			out.write(count + "\n");
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}