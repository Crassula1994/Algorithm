package gold3.num09591;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// Place 클래스 정의
	static class Place {
		
		// 해당 장소의 층수와 각 좌표를 저장할 각 변수 초기화
		int floor;
		int coordinateX;
		int coordinateY;
		
		// 매개변수를 입력 받는 생성자 정의
		public Place(int floor, int coordinateX, int coordinateY) {
			this.floor = floor;
			this.coordinateX = coordinateX;
			this.coordinateY = coordinateY;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// 각 장소 사이의 거리를 초기화할 상수 MAX_DIST 초기화
	static final double MAX_DIST = Integer.MAX_VALUE;
	
	// 입력 받은 장소의 정보를 저장할 배열 places 초기화
	static Place[] places;
	
	// 각 장소 사이의 거리와 최단거리, 중간에 들러야 하는 경유 장소를 저장할 각 2차원 배열 초기화
	static double[][] distances;
	static double[][] minDistances;
	static int[][] stopovers;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 장소의 수 및 각 연결편의 개수를 각 변수에 할당
		int placeNum = Integer.parseInt(st.nextToken());
		int connectionNum = Integer.parseInt(st.nextToken());
		
		// 입력 받은 장소의 정보를 저장할 배열 places 초기화
		places = new Place[placeNum];
		
		// 각 장소 사이의 거리와 최단거리, 중간에 들러야 하는 경유 장소를 저장할 각 2차원 배열 초기화
		distances = new double[placeNum][placeNum];
		minDistances = new double[placeNum][placeNum];
		stopovers = new int[placeNum][placeNum];
		
		// for 반복문을 사용해 각 장소의 쌍을 순회
		for (int p1 = 0; p1 < placeNum; p1++) {
			for (int p2 = 0; p2 < placeNum; p2++) {
				
				// 해당 장소 쌍의 중간에 들러야 하는 경유 장소를 초기화
				stopovers[p1][p2] = -1;
				
				// 두 장소가 같지 않은 경우 해당 장소 사이의 거리를 초기화
				if (p1 != p2)
					distances[p1][p2] = MAX_DIST;
			}
		}
		
		// for 반복문을 사용해 각 장소의 정보를 순회
		for (int idx = 0; idx < places.length; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 해당 장소의 층수와 각 좌표를 각 변수에 할당
			int floor = Integer.parseInt(st.nextToken());
			int coordinateX = Integer.parseInt(st.nextToken());
			int coordinateY = Integer.parseInt(st.nextToken());
			
			// 해당 장소의 정보를 배열 places에 저장
			places[idx] = new Place(floor, coordinateX, coordinateY);
		}
		
		// while 반복문을 사용해 각 연결편을 순회
		while (connectionNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 연결편의 두 장소와 이동의 종류를 각 변수에 할당
			int origin = Integer.parseInt(st.nextToken());
			int destination = Integer.parseInt(st.nextToken());
			String type = st.nextToken();
			
			// placeConnector() 메서드를 호출해 두 장소 사이의 연결편을 배열 distances에 갱신
			placeConnector(origin, destination, type);
		}
		
		// minDistCalculator() 메서드를 호출해 두 장소 쌍 사이의 최소 거리를 갱신
		minDistCalculator(placeNum);
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 질의의 수를 변수 queryNum에 할당
		int queryNum = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 질의를 순회
		while (queryNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 두 장소의 번호를 각 변수에 할당
			int origin = Integer.parseInt(st.nextToken());
			int destination = Integer.parseInt(st.nextToken());
			
			// shortestPathFinder() 및 write() 메서드를 사용해 출발 장소에서 도착 장소까지 최단 거리로 가기 위한 경로를 출력
			out.write(shortestPathFinder(origin, destination) + destination);
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------

	// placeConnector() 메서드 정의
	public static void placeConnector(int origin, int destination, String type) {
		
		// 엘리베이터를 타는 경우 두 장소의 연결편을 갱신
		if (type.equals("lift")) {
			distances[origin][destination] = 1.0;
			distances[destination][origin] = 1.0;
			
		// 에스컬레이터를 타는 경우 두 장소의 연결편을 갱신
		} else if (type.equals("escalator")) {
			distances[origin][destination] = 1.0;
			distances[destination][origin] = distCalculator(places[origin], places[destination]) * 3;
			
		// 걷거나 계단을 선택하는 경우 두 장소의 연결편을 갱신
		} else {
			double distance = distCalculator(places[origin], places[destination]);
			distances[origin][destination] = distance;
			distances[destination][origin] = distance;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------

	// distCalculator() 메서드 정의
	public static double distCalculator(Place placeA, Place placeB) {
		
		// 각 좌표와 각 층 사이의 차이를 저장할 각 변수 초기화
		double diffX = placeA.coordinateX - placeB.coordinateX;
		double diffY = placeA.coordinateY - placeB.coordinateY;
		double diffZ = (placeA.floor - placeB.floor) * 5;
		
		// sqrt() 메서드를 사용해 두 장소 사이의 유클리드 거리를 반환
		return Math.sqrt(diffX * diffX + diffY * diffY + diffZ * diffZ);
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// minDistCalculator() 메서드 정의
	public static void minDistCalculator(int placeNum) {
		
		// for 반복문을 사용해 각 장소 사이의 최소 이동 거리를 초기화
		for (int p1 = 0; p1 < placeNum; p1++) {
			for (int p2 = 0; p2 < placeNum; p2++)
				minDistances[p1][p2] = distances[p1][p2];
		}
		
		// for 반복문을 사용해 경유 장소, 시작 장소, 끝 장소를 순회
		for (int mid = 0; mid < placeNum; mid++) {
			for (int start = 0; start < placeNum; start++) {
				for (int end = 0; end < placeNum; end++) {
					
					// 해당 경유 장소를 들렀다 가는 것이 기존 이동 방법보다 더 짧은 경우 해당 장소 쌍의 최소 이동 거리 및 경유 장소를 갱신
					if (minDistances[start][end] > minDistances[start][mid] + minDistances[mid][end]) {
						minDistances[start][end] = minDistances[start][mid] + minDistances[mid][end];
						stopovers[start][end] = mid;
					}
				}
			}
		}
		
	}
	
	// ----------------------------------------------------------------------------------------------------

	// shortestPathFinder() 메서드 정의
	public static String shortestPathFinder(int origin, int destination) {
		
		// 해당 장소 쌍의 경유 장소를 변수 stopover에 할당
		int stopover = stopovers[origin][destination];
		
		// 출발 장소에서 도착 장소까지 최단 거리로 가기 위한 경로를 저장할 StringBuilder 객체 sb 초기화
		StringBuilder sb = new StringBuilder();
		
		// 경유 장소가 존재하지 않는 경우 출발 장소를 sb에 추가
		if (stopover == -1) {
			sb.append(origin).append(" ");
			
		// 경유 장소가 존재하는 경우 shortestPathFinder() 메서드를 재귀 호출해 경유지를 거쳤을 때의 경로를 sb에 추가
		} else {
			sb.append(shortestPathFinder(origin, stopover)).append(shortestPathFinder(stopover, destination));
		}
		
		// toString() 메서드를 사용해 출발 장소에서 도착 장소까지 최단 거리로 가기 위한 경로를 반환
		return sb.toString();
	}
}