package gold4.num16398;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// Flow 클래스 정의
	static class Flow {
		
		// 플로우의 연결 행성, 관리 비용을 저장할 각 변수 초기화
		int startPlanet;
		int endPlanet;
		int cost;
		
		// 매개변수를 입력 받는 생성자 정의
		public Flow(int startPlanet, int endPlanet, int cost) {
			this.startPlanet = startPlanet;
			this.endPlanet = endPlanet;
			this.cost = cost;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// DisjointSet 클래스 정의
	static class DisjointSet {
		
		// 각 행성의 부모 행성을 저장할 배열 parent 초기화
		int[] parent;
		
		// 매개변수를 입력 받는 생성자 정의
		public DisjointSet(int planetNum) {
			
			// 부모 행성을 저장할 배열 parent 초기화
			parent = new int[planetNum + 1];
			
			// for 반복문을 사용해 각 행성의 부모 행성을 초기화
			for (int idx = 1; idx < parent.length; idx++)
				parent[idx] = idx;
		}
		
		// find() 메서드 정의
		public int find(int planet) {
			
			// 해당 행성의 부모 행성이 자기 자신이 아닌 경우 find() 메서드 재귀 호출
			if (parent[planet] != planet)
				parent[planet] = find(parent[planet]);
			
			// 해당 행성의 부모 행성을 반환
			return parent[planet];
		}
		
		// union() 메서드 정의
		public void union(int planet1, int planet2) {
			
			// 두 행성을 연결
			parent[find(planet1)] = find(planet2);
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 행성의 개수를 변수 planetNum에 할당
		int planetNum = Integer.parseInt(in.readLine());
		
		// 각 플로우의 정보를 저장할 PriorityQueue 객체 flows 초기화 
		PriorityQueue<Flow> flows = new PriorityQueue<>((f1, f2) -> {
			return f1.cost - f2.cost;
		});
		
		// for 반복문을 사용해 각 플로우의 정보에 대한 행을 순회
		for (int r = 1; r <= planetNum; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 각 플로우의 정보에 대한 열을 순회
			for (int c = 1; c <= planetNum; c++) {
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 비용을 변수 cost에 할당
				int cost = Integer.parseInt(st.nextToken());
				
				// 해당 플로우의 정보가 추가되지 않은 경우 해당 플로우의 정보를 flows에 추가
				if (c > r) 
					flows.offer(new Flow(r, c, cost));
			}
		}

		// 최소 플로우의 관리 비용 및 선택한 플로우의 개수를 저장할 각 변수 초기화
		long minCost = 0;
		int flowCnt = 0;
		
		// 각 행성의 연결 정보를 저장할 DisjointSet 객체 connection 초기화
		DisjointSet connection = new DisjointSet(planetNum);
		
		// while 반복문을 사용해 flows가 빌 때까지 순회
		while (!flows.isEmpty()) {
			
			// 모든 행성 연결을 위해 필요한 플로우를 모두 선택한 경우 반복문 탈출
			if (flowCnt == planetNum - 1)
				break;
			
			// poll() 메서드를 사용해 가장 관리 비용이 적은 플로우을 변수 flow에 할당
			Flow flow = flows.poll();
			
			// 두 행성 사이에 연결이 존재하지 않는 경우
			if (connection.find(flow.startPlanet) != connection.find(flow.endPlanet)) {
				
				// 두 행성을 연결
				connection.union(flow.startPlanet, flow.endPlanet);
				
				// 최소 플로우의 관리 비용 및 선택한 플로우의 개수를 갱신
				minCost += flow.cost;
				flowCnt++;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 최소 플로우의 관리 비용를 출력
		out.write(String.valueOf(minCost));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}