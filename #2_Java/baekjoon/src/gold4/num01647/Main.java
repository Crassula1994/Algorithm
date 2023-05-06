package gold4.num01647;

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
	
	// Path 클래스 정의
	static class Path {
		
		// 길과 연결된 집, 길의 유지비를 저장할 각 변수 초기화
		int startHouse;
		int endHouse;
		int cost;
		
		// 매개변수를 입력 받는 생성자 정의
		public Path(int startHouse, int endHouse, int cost) {
			this.startHouse = startHouse;
			this.endHouse = endHouse;
			this.cost = cost;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// DisjointSet 클래스 정의
	static class DisjointSet {
		
		// 각 집의 부모 집을 저장할 배열 parent 초기화
		int[] parent;
		
		// 매개변수를 입력 받는 생성자 정의
		public DisjointSet(int houseNum) {
			
			// 부모 집을 저장할 배열 parent 초기화
			parent = new int[houseNum + 1];
			
			// for 반복문을 사용해 각 집의 부모 집을 초기화
			for (int idx = 1; idx < parent.length; idx++)
				parent[idx] = idx;
		}
		
		// find() 메서드 정의
		public int find(int house) {
			
			// 해당 집의 부모 집이 자기 자신이 아닌 경우 find() 메서드 재귀 호출
			if (parent[house] != house)
				parent[house] = find(parent[house]);
			
			// 해당 집의 부모 집을 반환
			return parent[house];
		}
		
		// union() 메서드 정의
		public void union(int house1, int house2) {
			
			// 두 집을 연결
			parent[find(house1)] = find(house2);
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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 집의 개수와 길의 개수를 각 변수에 할당
		int houseNum = Integer.parseInt(st.nextToken());
		int pathNum = Integer.parseInt(st.nextToken());
		
		// 각 길의 정보를 저장할 PriorityQueue 객체 paths 초기화 
		PriorityQueue<Path> paths = new PriorityQueue<>((p1, p2) -> {
			return p1.cost - p2.cost;
		});
		
		// for 반복문을 사용해 각 길의 정보를 순회
		for (int path = 0; path < pathNum; path++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 연결된 집과 길의 유지비를 각 변수에 할당
			int startHouse = Integer.parseInt(st.nextToken());
			int endHouse = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			// offer() 메서드를 사용해 각 길의 정보를 paths에 추가
			paths.offer(new Path(startHouse, endHouse, cost));
		}

		// 길 유지비의 최솟값 및 선택한 길의 개수를 저장할 각 변수 초기화
		int minCost = 0;
		int pathCnt = 0;
		
		// 각 집의 연결 정보를 저장할 DisjointSet 객체 connection 초기화
		DisjointSet connection = new DisjointSet(houseNum);
		
		// while 반복문을 사용해 paths가 빌 때까지 순회
		while (!paths.isEmpty()) {
			
			// 필요한 최소의 길을 모두 선택한 경우 반복문 탈출
			if (pathCnt == houseNum - 2)
				break;
			
			// poll() 메서드를 사용해 가장 유지비가 적은 길을 변수 path에 할당
			Path path = paths.poll();
			
			// 두 집 사이에 연결이 존재하지 않는 경우
			if (connection.find(path.startHouse) != connection.find(path.endHouse)) {
				
				// 두 집을 연결
				connection.union(path.startHouse, path.endHouse);
				
				// 길 유지비의 최솟값 및 선택한 길의 개수를 갱신
				minCost += path.cost;
				pathCnt++;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 길 유지비의 최솟값을 출력
		out.write(String.valueOf(minCost));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}