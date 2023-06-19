package gold3.num09470;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스 번호, 노드의 수, 간선의 수를 각 변수에 할당
			int testCaseNum = Integer.parseInt(st.nextToken());
			int nodeNum = Integer.parseInt(st.nextToken());
			int edgeNum = Integer.parseInt(st.nextToken());
			
			// 각 노드별 선행 노드의 수, 각 노드의 슈트랄러 순서를 저장할 각 배열 초기화
			int[] prevNodes = new int[nodeNum + 1];
			int[] strahlerOrder = new int[nodeNum + 1];
			
			// 각 간선의 연결 정보를 저장할 각 배열 초기화
			List<Integer>[] nextConn = new ArrayList[nodeNum + 1];
			List<Integer>[] prevConn = new ArrayList[nodeNum + 1];
			
			// for 반복문을 사용해 연결 정보를 저장할 각 List 객체 초기화
			for (int idx = 0; idx <= nodeNum; idx++) {
				nextConn[idx] = new ArrayList<>();
				prevConn[idx] = new ArrayList<>();
			}
				
			// for 반복문을 사용해 각 간선을 순회
			for (int edge = 0; edge < edgeNum; edge++) {
				
				// StringTokenizer 객체를 불러와 변수 st에 재할당
				st = new StringTokenizer(in.readLine());
				
				// nextToken() 및 parseInt() 메서드를 사용해 선행 노드 및 다음 노드를 각 변수에 할당
				int prevNode = Integer.parseInt(st.nextToken());
				int nextNode = Integer.parseInt(st.nextToken());
				
				// add() 메서드를 사용해 연결 정보를 추가
				nextConn[prevNode].add(nextNode);
				prevConn[nextNode].add(prevNode);
				
				// 노드별 선행 노드의 수를 갱신
				prevNodes[nextNode]++;
			}
			
			// 다음에 슈트랄러 순서를 확인할 노드를 저장할 Queue 객체 orderList 초기화
			Queue<Integer> orderList = new LinkedList<>();
			
			// for 반복문을 사용해 배열 prevNodes의 각 원소를 순회
			for (int idx = 1; idx < prevNodes.length; idx++) {
				
				// 해당 노드의 선행 노드가 존재하지 않는 근원인 경우
				if (prevNodes[idx] == 0) {
					
					// offer() 메서드를 사용해 해당 노드를 orderList에 추가 및 슈트랄러 순서 갱신
					orderList.offer(idx);
					strahlerOrder[idx] = 1;
				}
			}
			
			// while 반복문을 사용해 orderList가 빌 때까지 순회
			while (!orderList.isEmpty()) {
				
				// poll() 메서드를 사용해 현재 확인 중인 노드를 변수 currentNode에 할당
				int currentNode = orderList.poll();
				
				// for 반복문을 사용해 현재 확인 중인 노드가 선행 노드인 노드를 순회
				for (int i = 0; i < nextConn[currentNode].size(); i++) {
					
					// get() 메서드를 사용해 현재 확인 중인 노드가 선행 노드인 노드를 변수 nextNode에 할당
					int nextNode = nextConn[currentNode].get(i);
					
					// 해당 노드의 선행 노드의 수를 갱신
					prevNodes[nextNode]--;
					
					// 해당 노드의 선행 노드 수가 0인 경우
					if (prevNodes[nextNode] == 0) {
						
						// offer() 메서드를 사용해 해당 노드를 orderList에 추가
						orderList.offer(nextNode);
						
						// 해당 노드로 들어오는 가장 큰 슈트랄러 순서, 해당 순서의 개수를 저장할 각 변수 초기화
						int order = 0;
						int count = 0;
						
						// for 반복문을 사용해 해당 노드의 이전 노드를 순회
						for (int j = 0; j < prevConn[nextNode].size(); j++) {
							
							// get() 메서드를 사용해 해당 노드의 이전 노드를 변수 prevNode에 할당
							int prevNode = prevConn[nextNode].get(j);
							
							// 해당 노드로 들어오는 슈트랄러 순서가 저장된 가장 큰 슈트랄러 순서보다 높은 경우
							if (strahlerOrder[prevNode] > order) {
								
								// 해당 노드로 들어오는 가장 큰 슈트랄러 순서 및 순서의 개수 갱신
								order = strahlerOrder[prevNode];
								count = 1;
								
							// 해당 노드로 들어오는 슈트랄러 순서가 저장된 가장 큰 슈트랄러 순서와 같은 경우 순서의 개수 갱신
							} else if (strahlerOrder[prevNode] == order) {
								count++;
							}
						}
						
						// 해당 노드의 슈트랄러 순서를 갱신
						strahlerOrder[nextNode] = (count > 1) ? order + 1 : order;
					}
				}
			}
			
			// write() 메서드를 사용해 테스트 케이스 번호 및 주어진 하천계의 슈트랄러 순서를 출력
			out.write(testCaseNum + " " + strahlerOrder[nodeNum] + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}