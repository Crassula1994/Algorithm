package gold2.num20010;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 첫 번째 마을을 기준으로 가장 비용이 많이 드는 마을의 위치 및 해당 비용을 저장할 각 변수 초기화
	static int maxTown = -1;
	static int maxCost = Integer.MIN_VALUE;
	
	// 각 마을의 대표 마을과 가능한 교역로, 각 마을을 잇는 교역로를 저장할 각 배열 초기화
	static int[] rootTown;
	static Route[] routes;
	static List<int[]>[] tradeRoutes;
	
	// ----------------------------------------------------------------------------------------------------
	
	// Route 클래스 정의
	static class Route implements Comparable<Route> {
		
		// 해당 교역로가 연결하는 두 마을과 그 비용을 저장할 각 변수 초기화
		int startTown;
		int endTown;
		int cost;
		
		// 매개변수를 입력 받는 생성자 정의
		public Route(int startTown, int endTown, int cost) {
			this.startTown = startTown;
			this.endTown = endTown;
			this.cost = cost;
		}
		
		// compareTo() 메서드 정의
		@Override
		public int compareTo(Route anotherRoute) {

			// 교역로의 비용이 더 적은 순으로 정렬
			return this.cost - anotherRoute.cost;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 마을의 수 및 설치 가능한 교역로의 수를 각 변수에 할당
		int townNum = Integer.parseInt(st.nextToken());
		int routeNum = Integer.parseInt(st.nextToken());
		
		// 모든 마을을 연결하는 최소 비용 및 마을을 잇는 교역로의 개수를 저장할 각 변수 초기화
		int minCost = 0;
		int count = 0;
		
		// 각 마을의 대표 마을과 가능한 교역로, 각 마을을 잇는 교역로를 저장할 각 배열 초기화
		rootTown = new int[townNum];
		routes = new Route[routeNum];
		tradeRoutes = new ArrayList[townNum];
		
		// for 반복문을 사용해 각 마을의 대표 마을을 초기화
		for (int idx = 0; idx < rootTown.length; idx++)
			rootTown[idx] = idx;
		
		// for 반복문을 사용해 각 마을을 잇는 교역로를 저장할 List 객체 초기화
		for (int idx = 0; idx < tradeRoutes.length; idx++)
			tradeRoutes[idx] = new ArrayList<>();
		
		// for 반복문을 사용해 각 교역로의 정보를 순회
		for (int idx = 0; idx < routes.length; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 해당 교역로가 연결하는 두 마을 및 연결 비용을 각 변수에 할당
			int startTown = Integer.parseInt(st.nextToken());
			int endTown = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			// 해당 교역로의 정보를 배열 routes에 저장
			routes[idx] = new Route(startTown, endTown, cost);
		}
		
		// sort() 메서드를 사용해 입력 받은 교역로를 비용이 적은 순서대로 오름차순 정렬
		Arrays.sort(routes);
		
		// for 반복문을 사용해 각 교역로를 순회
		for (Route route : routes) {
			
			// 해당 교역로의 두 마을이 이미 연결된 경우 다음 교역로를 순회
			if (townFinder(route.startTown) == townFinder(route.endTown))
				continue;
			
			// townConnector() 메서드를 호출해 두 마을을 교역로로 연결 처리
			townConnector(route.startTown, route.endTown);
			
			// add() 메서드를 사용해 마을을 잇는 각 교역로의 정보를 배열 tradeRoutes에 저장
			tradeRoutes[route.startTown].add(new int[] {route.endTown, route.cost});
			tradeRoutes[route.endTown].add(new int[] {route.startTown, route.cost});
			
			// 모든 마을을 연결하는 최소 비용 및 마을을 잇는 교역로의 개수를 갱신
			minCost += route.cost;
			count++;
			
			// 모든 마을을 이은 경우 반복문 탈출
			if (count == townNum - 1)
				break;
		}
		
		// maxCostFinder() 메서드를 호출해 첫 번째 마을을 기준으로 가장 비용이 많이 드는 마을의 위치를 갱신
		maxCostFinder(0, 0, new boolean[townNum]);
		
		// maxCostFinder() 메서드를 호출해 가장 비용이 많이 드는 마을을 기준으로 가장 비용이 많이 드는 마을의 위치를 갱신
		maxCostFinder(maxTown, 0, new boolean[townNum]);
		
		// write() 메서드를 사용해 모든 마을을 연결하는 최소 비용 및 그 중 비용이 가장 큰 경로의 비용을 출력
		out.write(minCost + "\n" + maxCost);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------

	// townFinder() 메서드 정의
	public static int townFinder(int town) {
		
		// 해당 마을의 대표 마을이 자기 자신인 경우 이를 반환
		if (rootTown[town] == town)
			return town;
		
		// townFinder() 메서드를 재귀 호출해 해당 마을의 대표 마을을 찾아 반환
		return rootTown[town] = townFinder(rootTown[town]);
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// townConnector() 메서드 정의
	public static void townConnector(int townA, int townB) {
		
		// townFinder() 메서드를 호출해 두 마을의 대표 마을을 찾아 각 변수에 할당
		int rootTownA = townFinder(townA);
		int rootTownB = townFinder(townB);
		
		// max() 및 min() 메서드를 사용해 두 마을을 연결 처리
		rootTown[Math.max(rootTownA, rootTownB)] = Math.min(rootTownA, rootTownB);
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// maxCostFinder() 메서드 정의
	public static void maxCostFinder(int curTown, int curCost, boolean[] checked) {
		
		// 현재 마을을 확인한 것으로 처리
		checked[curTown] = true;
		
		// 현재 마을까지의 이동 비용이 저장된 최대 비용보다 많은 경우 가장 비용이 많이 드는 마을의 위치 및 해당 비용을 갱신
		if (curCost > maxCost) {
			maxCost = curCost;
			maxTown = curTown;
		}
		
		// for 반복문을 사용해 연결된 각 마을을 순회
		for (int[] nextTown : tradeRoutes[curTown]) {
			
			// 해당 마을을 확인한 경우 다음 마을을 순회
			if (checked[nextTown[0]])
				continue;
			
			// maxCostFinder() 메서드를 재귀 호출
			maxCostFinder(nextTown[0], curCost + nextTown[1], checked);
		}
	}
}