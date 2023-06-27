package gold4.num01707;

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
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 정점의 개수 및 간선의 개수를 각 변수에 할당
			int nodeNum = Integer.parseInt(st.nextToken());
			int edgeNum = Integer.parseInt(st.nextToken());
			
			// 해당 그래프가 이분 그래프인지를 나타내는 변수 isBipartite 초기화
			boolean isBipartite = true;
			
			// 각 정점의 확인 여부를 저장할 배열 checked 초기화
			int[] checked = new int[nodeNum + 1];
			
			// 각 정점과 연결된 간선 정보를 저장할 배열 connection 초기화
			@SuppressWarnings("unchecked")
			List<Integer>[] connection = new ArrayList[nodeNum + 1];
			
			// for 반복문을 사용해 각 정점과 연결된 간선 정보를 저장할 List 객체 초기화
			for (int idx = 0; idx < connection.length; idx++)
				connection[idx] = new ArrayList<>();
			
			// for 반복문을 사용해 입력 받은 각 간선의 정보를 순회
			for (int edge = 0; edge < edgeNum; edge++) {
				
				// StringTokenizer 객체를 불러와 변수 st에 재할당
				st = new StringTokenizer(in.readLine());
				
				// nextToken() 및 parseInt() 메서드를 사용해 연결된 각 정점을 각 변수에 할당
				int startNode = Integer.parseInt(st.nextToken());
				int endNode = Integer.parseInt(st.nextToken());
				
				// add() 메서드를 사용해 각 정점의 연결 정보를 갱신
				connection[startNode].add(endNode);
				connection[endNode].add(startNode);
			}
			
			// for 반복문을 사용해 각 정점을 순회
			outer: for (int idx = 1; idx < checked.length; idx++) {
				
				// 해당 정점을 확인하지 않은 경우
				if (checked[idx] == 0) {
					
					// 다음에 확인할 정점을 저장할 Queue 객체 checkList 초기화
					Queue<Integer> checkList = new LinkedList<>();
					
					// offer() 메서드를 사용해 해당 정점을 checkList에 추가 및 확인 처리
					checkList.offer(idx);
					checked[idx] = 1;

					// while 반복문을 사용해 checkList가 빌 때까지 순회
					while (!checkList.isEmpty()) {
						
						// poll() 메서드를 사용해 현재 확인 중인 정점을 변수 currentNode에 할당
						int currentNode = checkList.poll();
						
						// for 반복문을 사용해 해당 정점과 연결된 정점을 순회
						for (int n = 0; n < connection[currentNode].size(); n++) {
							
							// get() 메서드를 사용해 현재 확인 중인 정점과 연결된 정점을 변수 nextNode에 할당
							int nextNode = connection[currentNode].get(n);
							
							// 해당 정점을 이미 방문했으며, 이분 그래프가 아닌 경우
							if (checked[currentNode] == checked[nextNode]) {
								
								// 해당 그래프가 이분 그래프인지를 나타내는 변수 갱신 및 반복문 탈출
								isBipartite = false;
								break outer;
							}
							
							// 해당 정점을 이미 방문한 경우 다음 정점을 순회
							if (checked[nextNode] != 0)
								continue;
							
							// offer() 메서드를 사용해 해당 정점을 checkList에 추가 및 확인 처리
							checkList.offer(nextNode);
							checked[nextNode] = (checked[currentNode] == 1) ? 2 : 1;
						}
					}
				}
			}
			
			// 해당 그래프가 이분 그래프인 경우 'YES' 출력
			if (isBipartite) {
				out.write("YES");
				
			// 해당 그래프가 이분 그래프가 아닌 경우 'NO' 출력
			} else {
				out.write("NO");
			}
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}