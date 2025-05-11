package gold5.num06984;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 각 도시를 연결하는 길의 정보를 저장할 Map 객체 roads 초기화
	static Map<Character, List<Character>> roads = new HashMap<>();
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 길의 수와 질문의 수를 각 변수에 할당
		int roadNum = Integer.parseInt(st.nextToken());
		int queryNum = Integer.parseInt(st.nextToken());
		
		// while 반복문을 사용해 각 길의 정보를 순회
		while (roadNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 charAt() 메서드를 사용해 입력 받은 길이 연결하는 도시를 각 변수에 할당
			char startCity = st.nextToken().charAt(0);
			char endCity = st.nextToken().charAt(0);
			
			// computeIfAbsent() 및 add() 메서드를 사용해 길의 정보를 roads에 저장
			roads.computeIfAbsent(startCity, _key -> new ArrayList<>()).add(endCity);
			roads.computeIfAbsent(endCity, _key -> new ArrayList<>()).add(startCity);
		}
		
		// while 반복문을 사용해 각 질문을 순회
		while (queryNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 charAt() 메서드를 사용해 입력 받은 출발 도시와 도착 도시를 각 변수에 할당
			char startCity = st.nextToken().charAt(0);
			char endCity = st.nextToken().charAt(0);
			
			// roadFinder() 및 write() 메서드를 사용해 출발 도시로부터 도착 도시까지의 최단 경로를 출력
			out.write(roadFinder(startCity, endCity));
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// roadFinder() 메서드 정의
	public static String roadFinder(char startCity, char endCity) {
		
		// 다음에 방문할 도시를 저장할 Queue 객체 cityList 초기화
		Queue<Character> cityList = new LinkedList<>();
		
		// 각 도시까지의 이동 정보를 저장할 Map 객체 routes 초기화
		Map<Character, String> routes = new HashMap<>();
		
		// offer() 메서드를 사용해 시작 도시를 cityList에 추가
		cityList.offer(startCity);
		
		// toString() 및 put() 메서드를 사용해 시작 도시까지의 이동 정보를 routes에 저장
		routes.put(startCity, Character.toString(startCity));
		
		// while 반복문을 사용해 cityList가 빌 때까지 순회
		while (!cityList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 도시를 변수 curCity에 할당
			char curCity = cityList.poll();
			
			// 현재 도시가 도착 도시인 경우 반복문 탈출
			if (curCity == endCity)
				break;
			
			// for 반복문을 사용해 연결된 도시를 순회
			for (char nextCity : roads.get(curCity)) {
			
				// 이미 방문한 도시인 경우 다음 도시를 순회
				if (routes.containsKey(nextCity))
					continue;
				
				// offer() 메서드를 사용해 해당 도시를 cityList에 추가
				cityList.offer(nextCity);
				
				// get() 및 put() 메서드를 사용해 해당 도시까지의 이동 정보를 routes에 저장
				routes.put(nextCity, routes.get(curCity) + nextCity);
			}
		}
		
		// get() 메서드를 사용해 도착 도시까지의 이동 정보를 반환
		return routes.get(endCity);
	}
}