package gold3.num01833;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;  
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 각 도시의 대표 도시를 저장할 배열 rootCity 초기화
	static int[] rootCity;
	
	// ----------------------------------------------------------------------------------------------------
	
	// Railway 클래스 정의
	static class Railway implements Comparable<Railway> {
		
		// 해당 고속철도가 연결하는 도시 및 설치 비용을 저장할 각 변수 초기화
		int startCity;
		int endCity;
		int cost;
		
		// 매개변수를 입력 받는 생성자 정의
		public Railway(int startCity, int endCity, int cost) {
			this.startCity = startCity;
			this.endCity = endCity;
			this.cost = cost;
		}

		// compareTo() 메서드 정의
		@Override
		public int compareTo(Railway anotherRailway) {
			
			// 설치 비용이 낮은 순서대로 정렬
			return this.cost - anotherRailway.cost;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 도시의 개수를 변수 cityNum에 할당
		int cityNum = Integer.parseInt(in.readLine());
		
		// 고속철도망을 설치하는 데 든 총 비용을 저장할 변수 totalCost 초기화
		int totalCost = 0;
		
		// 각 도시의 대표 도시를 저장할 배열 rootCity 초기화
		rootCity = new int[cityNum + 1];
		
		// 각 도시를 연결하는 고속철도의 정보 및 새로 건설한 고속철도의 정보를 저장할 각 List 객체
		List<Railway> railways = new ArrayList<>();
		List<Railway> newRailways = new ArrayList<>();		
		
		// for 반복문을 사용해 각 도시의 대표 도시를 초기화
		for (int idx = 1; idx < rootCity.length; idx++)
			rootCity[idx] = idx;
		
		// for 반복문을 사용해 각 시작 도시를 순회
		for (int startCity = 1; startCity <= cityNum; startCity++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 각 끝 도시를 순회
			for (int endCity = 1; endCity <= cityNum; endCity++) {
				
				// nextToken() 및 parseInt() 메서드를 사용해 두 도시를 연결하는 고속철도의 설치 비용을 변수 cost에 할당
				int cost = Integer.parseInt(st.nextToken());
				
				// 이미 확인한 고속철도인 경우 다음 도시를 순회
				if (startCity >= endCity)
					continue;
				
				// 이미 설치한 고속철도인 경우
				if (cost < 0) {
					
					// 고속철도망을 설치하는 데 든 총 비용을 갱신
					totalCost += -cost;
					
					// 해당 고속철도의 도시가 아직 연결되지 않은 경우 해당 고속철도가 건설된 두 도시를 연결 처리
					if (cityFinder(startCity) != cityFinder(endCity))
						cityConnector(startCity, endCity);
					
					// 다음 도시를 순회
					continue;
				}
				
				// add() 메서드를 사용해 해당 고속철도의 정보를 railways에 저장
				railways.add(new Railway(startCity, endCity, cost));
			}
		}
		
		// sort() 메서드를 사용해 고속철도를 건설 비용이 낮은 순서대로 정렬
		Collections.sort(railways);
		
		// for 반복문을 사용해 각 고속철도를 순회
		for (Railway railway : railways) {
			
			// 해당 고속철도의 도시가 고속철도망에 연결된 경우 다음 고속철도를 순회
			if (cityFinder(railway.startCity) == cityFinder(railway.endCity))
				continue;
			
			// cityConnector() 메서드를 호출해 해당 고속철도의 도시를 고속철도망에 연결 처리
			cityConnector(railway.startCity, railway.endCity);
			
			// 고속철도망을 설치하는 데 든 총 비용을 갱신
			totalCost += railway.cost;
			
			// add() 메서드를 사용해 해당 고속철도를 newRailways에 추가
			newRailways.add(railway);
		}
		
		// size() 및 write() 메서드를 사용해 고속철도망을 설치하는 데 든 총 비용 및 새로이 설치한 고속철도의 개수를 출력
		out.write(totalCost + " " + newRailways.size() + "\n");
		
		// for 반복문을 사용해 새로 고속철도가 설치된 두 도시 번호를 출력
		for (Railway railway : newRailways)
			out.write(railway.startCity + " " + railway.endCity + "\n");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// cityFinder() 메서드 정의
	public static int cityFinder(int city) {
		
		// 해당 도시의 대표 도시가 자기 자신인 경우 해당 도시를 반환
		if (rootCity[city] == city)
			return city;
		
		// cityFinder() 메서드를 재귀 호출해 해당 도시의 대표 도시를 반환
		return rootCity[city] = cityFinder(rootCity[city]);
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// cityConnector() 메서드 정의
	public static void cityConnector(int cityA, int cityB) {
		
		// cityFinder() 메서드를 호출해 각 도시의 대표 도시를 각 변수에 할당
		int rootCityA = cityFinder(cityA);
		int rootCityB = cityFinder(cityB);
		
		// min() 및 max() 메서드를 사용해 두 도시를 연결 처리
		rootCity[Math.max(rootCityA, rootCityB)] = Math.min(rootCityA, rootCityB);
	}
}