package gold3.num14950;

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
	
	// Road 클래스 정의
	static class Road {
		
		// 도로의 연결 도시, 비용을 저장할 각 변수 초기화
		int startCity;
		int endCity;
		int cost;
		
		// 매개변수를 입력 받는 생성자 정의
		public Road(int startCity, int endCity, int cost) {
			this.startCity = startCity;
			this.endCity = endCity;
			this.cost = cost;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// DisjointSet 클래스 정의
	static class DisjointSet {
		
		// 각 도시의 부모 도시를 저장할 배열 parent 초기화
		int[] parent;
		
		// 매개변수를 입력 받는 생성자 정의
		public DisjointSet(int cityNum) {
			
			// 부모 도시를 저장할 배열 parent 초기화
			parent = new int[cityNum + 1];
			
			// for 반복문을 사용해 각 도시의 부모 도시를 초기화
			for (int idx = 1; idx < parent.length; idx++)
				parent[idx] = idx;
		}
		
		// find() 메서드 정의
		public int find(int city) {
			
			// 해당 도시의 부모 도시가 자기 자신이 아닌 경우 find() 메서드 재귀 호출
			if (parent[city] != city)
				parent[city] = find(parent[city]);
			
			// 해당 도시의 부모 도시를 반환
			return parent[city];
		}
		
		// union() 메서드 정의
		public void union(int city1, int city2) {
			
			// 두 도시를 연결
			parent[find(city1)] = find(city2);
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 도시의 개수, 도로의 개수, 증가하는 도로의 비용을 각 변수에 할당
		int cityNum = Integer.parseInt(st.nextToken());
		int roadNum = Integer.parseInt(st.nextToken());
		int extraCost = Integer.parseInt(st.nextToken());
		
		// 각 도로의 정보를 저장할 PriorityQueue 객체 roads 초기화 
		PriorityQueue<Road> roads = new PriorityQueue<>((r1, r2) -> {
			return r1.cost - r2.cost;
		});
		
		// for 반복문을 사용해 각 도로의 정보를 순회
		for (int road = 0; road < roadNum; road++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 연결 도시과 도로의 비용을 각 변수에 할당
			int startCity = Integer.parseInt(st.nextToken());
			int endCity = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			// offer() 메서드를 사용해 각 간선의 정보를 roads에 추가
			roads.offer(new Road(startCity, endCity, cost));
		}

		// 정복에 필요한 최소 비용 및 선택한 도로의 개수를 저장할 각 변수 초기화
		long minCost = 0;
		int roadCnt = 0;
		
		// 각 도시의 연결 정보를 저장할 DisjointSet 객체 connection 초기화
		DisjointSet connection = new DisjointSet(cityNum);
		
		// while 반복문을 사용해 roads가 빌 때까지 순회
		while (!roads.isEmpty()) {
			
			// 모든 도시 정복을 위해 필요한 도로를 모두 선택한 경우 반복문 탈출
			if (roadCnt == cityNum - 1)
				break;
			
			// poll() 메서드를 사용해 가장 비용이 적은 도로를 변수 road에 할당
			Road road = roads.poll();
			
			// 두 도시 사이에 연결이 존재하지 않는 경우
			if (connection.find(road.startCity) != connection.find(road.endCity)) {
				
				// 두 도시를 연결
				connection.union(road.startCity, road.endCity);
				
				// 정복에 필요한 최소 비용 및 선택한 도로의 개수를 갱신
				minCost += road.cost + roadCnt * extraCost;
				roadCnt++;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 정복에 필요한 최소 비용을 출력
		out.write(String.valueOf(minCost));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}