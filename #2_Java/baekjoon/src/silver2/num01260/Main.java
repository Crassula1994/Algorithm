package silver2.num01260;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 각 정점의 연결 상태를 저장할 2차원 배열 connection 초기화
	static boolean[][] connection;
	
	// 각 정점의 방문 여부를 저장할 배열 visited 초기화
	static boolean[] visited;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 정점의 개수, 간선의 개수, 시작할 정점의 번호를 각 변수에 할당
		int nodeNum = Integer.parseInt(st.nextToken());
		int edgeNum = Integer.parseInt(st.nextToken());
		int startNode = Integer.parseInt(st.nextToken());
		
		// 각 정점의 연결 상태를 저장할 2차원 배열 connection 초기화
		connection = new boolean[nodeNum + 1][nodeNum + 1];
		
		// 각 정점의 방문 여부를 저장할 배열 visited 초기화
		visited = new boolean[nodeNum + 1];
		
		// for 반복문을 사용해 각 간선의 연결 상태를 순회
		for (int n = 0; n < edgeNum; n++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 각 정점을 각 변수에 할당
			int toNode = Integer.parseInt(st.nextToken());
			int fromNode = Integer.parseInt(st.nextToken());
			
			// 각 정점의 연결 상태를 connection에 저장
			connection[toNode][fromNode] = true;
			connection[fromNode][toNode] = true;
		}
		
		// dfs 함수를 호출해 dfs를 수행한 결과를 출력
		
		
		// write() 메서드를 사용해 최대공약수 및 최소공배수를 출력
		out.write(gcd + "\n" + lcm);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}