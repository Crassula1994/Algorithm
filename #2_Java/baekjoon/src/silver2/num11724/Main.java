package silver2.num11724;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 그래프의 연결 상태를 저장할 2차원 배열 connection 초기화
	static boolean[][] connection;
	
	// 그래프의 방문 여부를 표시할 배열 visited 초기화
	static boolean[] visited;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 정점과 간선의 개수를 각 변수에 할당
		int nodeNum = Integer.parseInt(st.nextToken());
		int edgeNum = Integer.parseInt(st.nextToken());
		
		// 그래프의 연결 상태를 저장할 2차원 배열 connection 초기화
		connection = new boolean[nodeNum + 1][nodeNum + 1];
		
		// 그래프의 방문 여부를 표시할 배열 visited 초기화
		visited = new boolean[nodeNum + 1];
		
		// for 반복문을 사용해 각 간선을 순회
		for (int edge = 0; edge < edgeNum; edge++) {
			
			// StringTokernizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 간선의 양 끝점을 각 변수에 할당
			int startNode = Integer.parseInt(st.nextToken());
			int endNode = Integer.parseInt(st.nextToken());
			
			// 간선의 연결 여부를 배열 connection에 저장
			connection[startNode][endNode] = true;
			connection[endNode][startNode] = true;
		}
		
		// 연결 요소의 개수를 저장할 변수 count 초기화
		int count = 0;
		
		// for 반복문을 사용해 방문 처리되지 않은 각 정점을 순회
		for (int node = 1; node < nodeNum + 1; node++) {
			
			// 방문하지 않은 정점인 경우 
			if (!visited[node]) {
				
				// connectChecker() 메서드를 호출해 연결 요소를 방문 처리
				connectChecker(node);
				
				// 연결 요소의 개수 갱신
				count++;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 연결 요소의 개수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// connectChecker() 메서드 정의
	public static void connectChecker(int startNode) {
		
		// 처음 시작 정점을 방문 처리
		visited[startNode] = true;
		
		// for 반복문을 사용해 시작 정점과 연결된 정점을 순회
		for (int node = 1; node < connection.length; node++) {
			
			// 연결되어 있고 방문하지 않은 정점인 경우 connectChecker() 메서드 재귀 호출
			if (connection[startNode][node] && !visited[node])
				connectChecker(node);
		}
	}
}