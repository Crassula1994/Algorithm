package gold2.num10423;

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
	
	// Cable 클래스 정의
	static class Cable {
		
		// 케이블의 연결 도시, 비용을 저장할 각 변수 초기화
		int startCity;
		int endCity;
		int cost;
		
		// 매개변수를 입력 받는 생성자 정의
		public Cable(int startCity, int endCity, int cost) {
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
			
			// 해당 도시의 부모 도시가 자기 자신 또는 발전소가 설치된 도시가 아닌 경우 find() 메서드 재귀 호출
			if (parent[city] != city && parent[city] != -1)
				parent[city] = find(parent[city]);
			
			// 해당 도시의 부모 도시를 반환
			return parent[city];
		}
		
		// union() 메서드 정의
		public void union(int city1, int city2) {
			
			// find() 메서드를 호출해 두 도시의 부모 도시를 각 변수에 할당
			int parent1 = find(city1);
			int parent2 = find(city2);
			
			// 두 도시가 이미 발전소에 연결된 경우 메서드 종료
			if (parent1 == -1 && parent2 == -1)
				return;
			
			// 첫 번째 도시만 발전소에 연결된 경우 두 도시를 연결 후 메서드 종료
			if (parent1 == -1) {
				parent[parent2] = parent1;
				return;
			}
			
			// 두 번째 도시만 발전소에 연결된 경우 두 도시를 연결 후 메서드 종료
			if (parent2 == -1) {
				parent[parent1] = parent2;
				return;
			}
			
			// 두 도시 중 발전소에 연결된 도시가 없는 경우 두 도시를 연결
			parent[parent1] = parent2;
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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 도시의 개수, 설치 가능한 케이블의 개수, 발전소의 개수를 각 변수에 할당
		int cityNum = Integer.parseInt(st.nextToken());
		int cableNum = Integer.parseInt(st.nextToken());
		int powerPlantNum = Integer.parseInt(st.nextToken());
		
		// 각 도시의 연결 정보를 저장할 DisjointSet 객체 connection 초기화
		DisjointSet connection = new DisjointSet(cityNum);
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 발전소가 위치한 도시를 순회
		for (int p = 0; p < powerPlantNum; p++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 발전소의 위치를 변수 powerPlant에 할당
			int powerPlant = Integer.parseInt(st.nextToken());
			
			// 해당 발전소가 위치한 도시의 부모 도시를 -1로 초기화
			connection.parent[powerPlant] = -1;
		}
		
		// 각 케이블의 정보를 저장할 PriorityQueue 객체 cables 초기화 
		PriorityQueue<Cable> cables = new PriorityQueue<>((c1, c2) -> {
			return c1.cost - c2.cost;
		});
		
		// for 반복문을 사용해 각 케이블의 정보를 순회
		for (int cable = 0; cable < cableNum; cable++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 연결 도시와 비용를 각 변수에 할당
			int startCity = Integer.parseInt(st.nextToken());
			int endCity = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			// offer() 메서드를 사용해 각 케이블의 정보를 cables에 추가
			cables.offer(new Cable(startCity, endCity, cost));
		}

		// 케이블 설치 최소 비용을 저장할 변수 minCost 초기화
		int minCost = 0;
		
		// while 반복문을 사용해 cables가 빌 때까지 순회
		while (!cables.isEmpty()) {
			
			// poll() 메서드를 사용해 가장 비용이 적은 케이블을 변수 cable에 할당
			Cable cable = cables.poll();
			
			// 두 도시 사이에 연결이 존재하지 않는 경우
			if (connection.find(cable.startCity) != connection.find(cable.endCity)) {
				
				// 두 도시를 연결
				connection.union(cable.startCity, cable.endCity);
				
				// 케이블 설치 최소 비용을 갱신
				minCost += cable.cost;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 케이블 설치 최소 비용을 출력
		out.write(String.valueOf(minCost));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}