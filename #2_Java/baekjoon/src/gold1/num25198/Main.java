package gold1.num25198;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 도시의 개수를 저장할 변수 cityNum 초기화
	static int cityNum;
	
	// 각 도시를 연결하는 양방향 도로의 정보를 저장할 배열 roads 초기화
	static List<Integer>[] roads;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 도시의 개수를 변수 cityNum에 할당
		cityNum = Integer.parseInt(in.readLine());
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 현재 도시, 심부름 도시, 집 도시를 각 변수에 할당
		int origin = Integer.parseInt(st.nextToken());
		int stopover = Integer.parseInt(st.nextToken());
		int destination = Integer.parseInt(st.nextToken());
		
		// 각 도시를 연결하는 양방향 도로의 정보를 저장할 배열 roads 초기화
		roads = new ArrayList[cityNum + 1];
		
		// for 반복문을 사용해 각 도시를 연결하는 양방향 도로의 정보를 저장할 각 List 객체 초기화
		for (int idx = 0; idx < roads.length; idx++)
			roads[idx] = new ArrayList<>();
		
		// for 반복문을 사용해 각 도로의 정보를 순회
		for (int road = 0; road < cityNum - 1; road++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 해당 도로가 연결하는 각 도시를 각 변수에 할당
			int startCity = Integer.parseInt(st.nextToken());
			int endCity = Integer.parseInt(st.nextToken());
			
			// add() 메서드를 사용해 해당 도로의 정보를 배열 roads에 저장
			roads[startCity].add(endCity);
			roads[endCity].add(startCity);
		}
		
		// distanceMeasurer() 메서드를 호출해 현재 도시, 심부름 도시로부터의 최단 거리를 각 배열에 할당
		Integer[] distanceO = distanceMeasurer(origin);
		Integer[] distanceS = distanceMeasurer(stopover);
		
		// 현재 도시, 심부름 도시, 집 도시 사이의 최단 거리를 각 변수에 할당
		int distOS = distanceO[stopover];
		int distOD = distanceO[destination];
		int distSD = distanceS[destination];

		/* 현재 도시와 심부름 도시, 심부름 도시와 집 도시 사이에 중복으로 들려야 하는 도시의 수,
		현재 도시와 집 도시 사이에 중복 없이 들러야 하는 도시의 수, 만들 수 있는 순서쌍의 개수를 각 변수에 할당 */
		long revisitCount = (distOS + distSD - distOD) / 2 + 1;
		long visitCount = distOD + revisitCount;
		long totalCount = (visitCount * (visitCount - 1) + revisitCount * (revisitCount - 1)) / 2;
		
		// valueOf() 및 write() 메서드를 사용해 만들 수 있는 순서쌍의 개수를 출력
		out.write(String.valueOf(totalCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// distanceMeasurer() 메서드 정의
	public static Integer[] distanceMeasurer(int startCity) {
		
		// 시작 도시에서 각 도시까지의 이동 거리를 저장할 배열 distances 초기화
		Integer[] distances = new Integer[cityNum + 1];
		
		// 다음에 이동할 도시를 저장할 Queue 객체 cityList 초기화
		Queue<Integer> cityList = new LinkedList<>();
		
		// offer() 메서드를 사용해 시작 도시를 cityList에 추가 및 시작 도시로부터의 거리를 갱신
		cityList.offer(startCity);
		distances[startCity] = 0;
		
		// while 반복문을 사용해 cityList가 빌 때까지 순회
		while (!cityList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 도시를 변수 curCity에 할당
			int curCity = cityList.poll();
			
			// for 반복문을 사용해 연결된 도시를 순회
			for (int nextCity : roads[curCity]) {
				
				// 해당 도시를 이미 방문한 경우 다음 도시를 순회
				if (distances[nextCity] != null)
					continue;
				
				// offer() 메서드를 사용해 해당 도시를 cityList에 추가 및 시작 도시로부터의 거리를 갱신
				cityList.offer(nextCity);
				distances[nextCity] = distances[curCity] + 1;
			}
		}
		
		// 시작 도시에서 각 도시까지의 이동 거리를 저장한 배열을 반환
		return distances;
	}
}