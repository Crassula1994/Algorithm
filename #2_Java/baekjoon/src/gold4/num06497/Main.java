package gold4.num06497;

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
	
	// 각 집의 연결 정보를 저장할 DisjointSet 객체 connection 초기화
	static DisjointSet connection;
	
	// 각 길에 대한 정보를 저장할 List 객체 roads 초기화
	static List<Road> roads;
	
	// ----------------------------------------------------------------------------------------------------
	
	// Road 클래스 정의
	public static class Road implements Comparable<Road> {
		
		// 길이 연결하는 두 집과 그 거리를 저장할 각 변수 초기화
		int startHouse;
		int endHouse;
		int distance;
		
		// 매개변수를 입력 받는 생성자 정의
		public Road(int startHouse, int endHouse, int distance) {
			this.startHouse = startHouse;
			this.endHouse = endHouse;
			this.distance = distance;
		}
		
		// compareTo() 메서드 정의
		@Override
		public int compareTo(Road anotherRoad) {
			return distance - anotherRoad.distance;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// DisjointSet 클래스 정의
	public static class DisjointSet {
		
		// 연결된 대표 집을 저장할 배열 rootHouse 초기화
		int[] rootHouse;
		
		// 매개변수를 입력 받는 생성자 정의
		public DisjointSet(int houseNum) {
			
			// 연결된 대표 집을 저장할 배열 rootHouse 초기화
			rootHouse = new int[houseNum];
			
			// for 반복문을 사용해 각 집의 연결된 대표 집을 초기화
			for (int idx = 0; idx < rootHouse.length; idx++)
				rootHouse[idx] = idx;
		}
		
		// find() 메서드 정의
		public int find(int house) {
			
			// 해당 집의 연결된 대표 집이 자기 자신인 경우 자기 자신을 반환
			if (rootHouse[house] == house)
				return house;
			
			// find() 메서드를 재귀 호출해 해당 집의 연결된 대표 집을 찾아 반환
			return rootHouse[house] = find(rootHouse[house]);
		}
		
		// union() 메서드 정의
		public void union(int houseA, int houseB) {
			
			// find() 메서드를 호출해 찾은 각 집의 연결된 대표 집을 각 변수에 할당
			int rootA = find(houseA);
			int rootB = find(houseB);
			
			// 두 집의 연결된 대표 집이 다른 경우 연결된 대표 집을 갱신
			if (rootA != rootB)
				rootHouse[Math.max(rootA, rootB)] = Math.min(rootA, rootB);
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (true) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 집의 수와 길의 수를 각 변수에 할당
			int houseNum = Integer.parseInt(st.nextToken());
			int roadNum = Integer.parseInt(st.nextToken());
			
			// 집의 수와 길의 수가 0인 경우 반복문 탈출
			if (houseNum == 0 && roadNum == 0)
				break;
			
			// 절약할 수 있는 최대 비용과 불이 켜진 길의 수를 저장할 각 변수 초기화
			int maxSaving = 0;
			int count = 0;
			
			// 각 집의 연결 정보를 저장할 DisjointSet 객체 connection 초기화
			connection = new DisjointSet(houseNum);
			
			// 각 길에 대한 정보를 저장할 List 객체 roads 초기화
			roads = new ArrayList<>();
			
			// for 반복문을 사용해 입력 받은 각 길의 정보를 순회
			for (int road = 0; road < roadNum; road++) {
				
				// StringTokenizer 객체를 불러와 변수 st에 재할당
				st = new StringTokenizer(in.readLine());
				
				// nextToken() 및 parseInt() 메서드를 사용해 각 길의 정보를 각 변수에 할당
				int startHouse = Integer.parseInt(st.nextToken());
				int endHouse = Integer.parseInt(st.nextToken());
				int distance = Integer.parseInt(st.nextToken());
				
				// add() 메서드를 사용해 해당 길의 정보를 roads에 추가
				roads.add(new Road(startHouse, endHouse, distance));
				
				// 절약할 수 있는 최대 비용을 갱신
				maxSaving += distance;
			}
			
			// sort() 메서드를 사용해 각 길을 거리에 대하여 오름차순으로 정렬
			Collections.sort(roads);

			// for 반복문을 사용해 각 길을 순회
			for (Road road : roads) {
				
				// 모든 집을 연결한 경우 반복문 탈출
				if (count == houseNum - 1)
					break;
				
				// 도로에 연결된 두 집이 연결되지 않은 경우
				if (connection.find(road.startHouse) != connection.find(road.endHouse)) {
					
					// union() 메서드를 호출해 두 집을 연결
					connection.union(road.startHouse, road.endHouse);
					
					// 절약할 수 있는 최대 비용 및 불이 켜진 길의 수를 갱신
					maxSaving -= road.distance;
					count++;
				}
			}
			
			// write() 메서드를 사용해 절약할 수 있는 최대 비용을 출력
			out.write(maxSaving + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}