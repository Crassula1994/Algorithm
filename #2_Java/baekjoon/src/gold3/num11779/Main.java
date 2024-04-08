package gold3.num11779;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 도시의 개수, 버스의 개수를 저장할 각 변수 초기화
	static int cityNum;
	static int busNum;
	
	// 출발 도시에서 각 도시까지의 최소 비용, 해당 도시의 최소 비용 확인 여부, 연결된 버스의 정보를 저장할 각 배열 초기화
	static City[] minCosts;
	static boolean[] calculated;
	static List<int[]>[] buses;
	
	// City 클래스 정의
	public static class City {
		
		// 출발 도시에서 해당 도시까지의 최소 비용 및 최소 경로를 저장할 각 변수 초기화
		int minCost;
		List<Integer> minRoute = new ArrayList<>();
		
		// 인자를 입력 받는 생성자 정의
		public City(int minCost) {
			this.minCost = minCost;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 도시의 개수와 버스의 개수를 각 변수에 할당
		cityNum = Integer.parseInt(in.readLine());
		busNum = Integer.parseInt(in.readLine());
		
		// 출발 도시에서 각 도시까지의 최소 비용, 해당 도시의 최소 비용 확인 여부, 연결된 버스의 정보를 저장할 각 배열 초기화
		minCosts = new City[cityNum + 1];
		calculated = new boolean[cityNum + 1];
		buses = new ArrayList[cityNum + 1];
		
		// for 반복문을 사용해 각 도시까지의 최소 비용을 초기화
		for (int idx = 0; idx < minCosts.length; idx++)
			minCosts[idx] = new City(Integer.MAX_VALUE);
		
		// for 반복문을 사용해 연결된 버스의 정보를 저장할 List 객체 초기화
		for (int idx = 0; idx < buses.length; idx++)
			buses[idx] = new ArrayList<>();
		
		// for 반복문을 사용해 각 버스의 정보를 순회
		for (int bus = 0; bus < busNum; bus++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 버스의 출발 도시, 도착 도시, 비용을 각 변수에 할당
			int startCity = Integer.parseInt(st.nextToken());
			int endCity = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			// add() 메서드를 사용해 연결된 버스의 정보를 배열 buses에 추가
			buses[startCity].add(new int[] {endCity, cost});
		}
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 출발 도시와 도착 도시를 각 변수에 할당
		int startCity = Integer.parseInt(st.nextToken());
		int endCity = Integer.parseInt(st.nextToken());
		
		// costCalculator() 메서드를 호출해 출발 도시부터 도착 도시까지의 최소 비용와 그 경로를 갱신
		costCalculator(startCity, endCity);
		
		// size() 및 write() 메서드를 사용해 출발 도시부터 도착 도시까지의 최소 비용와 그 경로 상의 도시의 수를 출력
		out.write(minCosts[endCity].minCost + "\n" + minCosts[endCity].minRoute.size() + "\n");
		
		// for 반복문을 사용해 출발 도시부터 도착 도시까지의 경로를 순서대로 출력
		for (int idx = 0; idx < minCosts[endCity].minRoute.size(); idx++)
			out.write(minCosts[endCity].minRoute.get(idx) + " ");

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// costCalculator() 메서드 정의
	public static void costCalculator(int startCity, int endCity) {
		
		// 다음에 계산할 도시를 저장할 PriorityQueue 객체 calculateList 초기화
		PriorityQueue<int[]> calculateList = new PriorityQueue<>((c1, c2) -> {
			return c1[1] - c2[1];
		});
		
		// 시작 도시의 최소 비용 및 경로를 설정
		minCosts[startCity].minCost = 0;
		minCosts[startCity].minRoute.add(startCity);
		
		// offer() 메서드를 사용해 시작 도시를 calculateList에 추가
		calculateList.offer(new int[] {startCity, 0});
		
		// while 반복문을 사용해 calculateList가 빌 때까지 순회
		while (!calculateList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 계산 중인 도시를 배열 curCity에 할당
			int[] curCity = calculateList.poll();
			
			// 해당 도시를 계산한 적이 없는 경우
			if (!calculated[curCity[0]]) {
				
				// 현재 계산 중인 도시를 계산 처리
				calculated[curCity[0]] = true;
				
				// for 반복문을 사용해 해당 도시와 연결된 다른 도시를 순회
				for (int idx = 0; idx < buses[curCity[0]].size(); idx++) {
					
					// get() 메서드를 사용해 연결된 도시 및 비용을 각 변수에 할당
					int city = buses[curCity[0]].get(idx)[0];
					int cost = buses[curCity[0]].get(idx)[1];
					
					// 해당 도시까지의 최소 비용이 저장된 최소 비용보다 적은 경우
					if (minCosts[city].minCost > minCosts[curCity[0]].minCost + cost) {
						
						// 해당 도시의 최소 비용을 갱신
						minCosts[city].minCost = minCosts[curCity[0]].minCost + cost;
						
						// addAll() 및 add() 메서드를 사용해 해당 도시의 최소 비용 경로를 갱신
						minCosts[city].minRoute = new ArrayList<>();
						minCosts[city].minRoute.addAll(minCosts[curCity[0]].minRoute);
						minCosts[city].minRoute.add(city);
						
						// offer() 메서드를 사용해 해당 도시를 calculateList에 추가
						calculateList.offer(new int[] {city, minCosts[city].minCost});
					}
				}
			}
		}
	}
}