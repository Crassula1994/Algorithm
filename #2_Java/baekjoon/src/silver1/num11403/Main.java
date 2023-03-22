package silver1.num11403;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
 
	// 정점의 연결 정보 및 경로의 존재 유무를 저장할 각 2차원 배열 초기화
	static boolean[][] connection;
	static int[][] isConnected;
	
	// 정점의 수를 저장할 변수 nodeNum 초기화
	static int nodeNum;
	
	// ----------------------------------------------------------------------------------------------------
	
    // main() 메서드 정의
    public static void main(String[] args) throws IOException {
     
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 정점의 수를 변수 nodeNum에 할당
		nodeNum = Integer.parseInt(in.readLine());
		
		// 정점의 연결 정보를 저장할 2차원 배열 connection 초기화
		connection = new boolean[nodeNum][nodeNum];
		
		// 경로의 존재 유무를 저장할 2차원 배열 isConnected 초기화
		isConnected = new int[nodeNum][nodeNum];
		
		// for 반복문을 사용해 배열 connection의 각 행을 순회
		for (int r = 0; r < nodeNum; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 배열 paper의 각 열을 순회
			for (int c = 0; c < nodeNum; c++) {
				
				// 해당 값이 1인 경우 연결 정보를 갱신
				if (Integer.parseInt(st.nextToken()) == 1)
					connection[r][c] = true;
			}
		}
		
		// for 반복문을 사용해 각 노드에 대해 connectionFinder() 메서드를 호출하고 연결 여부를 갱신
		for (int node = 0; node < nodeNum; node++)
			connectionFinder(node);
		
		// for 반복문을 사용해 배열 isConnected의 각 행을 순회
		for (int r = 0; r < nodeNum; r++) {
			
			// for 반복문을 사용해 배열 isConnected의 각 열을 순회하며 값을 연결 여부를 출력
			for (int c = 0; c < nodeNum; c++)
				out.write(isConnected[r][c] + " ");
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
    }
    
    // ----------------------------------------------------------------------------------------------------

    // connectionFinder() 메서드 정의
	public static void connectionFinder(int startNode) {

		// 다음 방문할 위치를 저장할 Queue 객체 visitList 초기화
		Queue<Integer> visitList = new LinkedList<>();
		
		// 방문 여부를 저장할 배열 isVisited 초기화
		boolean[] isVisited = new boolean[nodeNum];
		
		// offer() 메서드를 사용해 visitList에 시작 노드를 추가
		visitList.offer(startNode);
		
		// while 반복문을 사용해 visitList가 빌 때까지 순회
		while (!visitList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 노드를 변수 currentNode에 할당
			int currentNode = visitList.poll();
			
			// for 반복문을 사용해 해당 노드와 연결된 다른 노드를 순회
			for (int node = 0; node < nodeNum; node++) {
				
				// 해당 노드와 연결이 되어 있고 해당 노드를 방문한 적이 없는 경우 visitList에 추가 및 방문 처리
				if (connection[currentNode][node] && !isVisited[node]) {
					visitList.offer(node);
					isVisited[node] = true;
				}				
			}
		}
		
		// for 반복문을 사용해 배열 isVisited의 각 원소를 순회
		for (int idx = 0; idx < isVisited.length; idx++) {
			
			// 해당 위치를 방문한 경우 연결 여부를 갱신
			if (isVisited[idx])
				isConnected[startNode][idx] = 1;
		}
	}
}