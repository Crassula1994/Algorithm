package gold4.num01976;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 각 도시의 부모 도시를 저장할 배열 rootCity 초기화
	static int[] rootCity;
		
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 도시의 수, 여행 계획에 속한 도시의 수를 각 변수에 할당
		int cityNum = Integer.parseInt(in.readLine());
		int pathLength = Integer.parseInt(in.readLine());
		
		// 각 도시의 부모 도시를 저장할 배열 rootCity 초기화
		rootCity = new int[cityNum + 1];
		
		// for 반복문을 사용해 각 도시의 부모 도시를 초기화
		for (int idx = 1; idx < rootCity.length; idx++)
			rootCity[idx] = idx;
		
		// for 반복문을 사용해 각 도시의 연결 정보를 순회
		for (int r = 1; r <= cityNum; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 두 도시 간의 연결 정보를 순회
			for (int c = 1; c <= cityNum; c++) {
				
				// 두 도시가 연결된 경우 cityConnector() 메서드를 호출해 두 도시를 연결
				if (Integer.parseInt(st.nextToken()) == 1)
					cityConnector(r, c);
			}
		}
		
		// 여행 계획이 가능한지 여부를 나타낼 변수 isPossible 초기화
		boolean isPossible = true;
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 여행 계획의 이전 도시를 저장할 변수 prevCity 초기화
		int prevCity = Integer.parseInt(st.nextToken());
		
		// for 반복문을 사용해 여행 계획 상의 모든 도시를 순회
		for (int path = 1; path < pathLength; path++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 여행 계획의 다음 도시를 변수 nextCity에 저장
			int nextCity = Integer.parseInt(st.nextToken());
			
			// 두 도시가 연결되어 있지 않은 경우 여행 계획이 가능한지 여부를 갱신 후 반복문 탈출
			if (cityFinder(prevCity) != cityFinder(nextCity)) {
				isPossible = false;
				break;
			}
			
			// 여행 계획의 이전 도시를 다음 도시로 갱신
			prevCity = nextCity;
		}
		
		// 여행 계획이 가능한 경우 'YES' 출력
		if (isPossible) {
			out.write("YES");
		
		// 여행 계획이 불가능한 경우 'NO' 출력
		} else {
			out.write("NO");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// cityConnector() 메서드 정의
	public static void cityConnector(int cityA, int cityB) {
		
		// cityFinder() 메서드를 호출해 각 도시의 부모 도시를 각 변수에 할당
		int rootA = cityFinder(cityA);
		int rootB = cityFinder(cityB);
		
		// 두 도시의 부모 도시가 다른 경우 부모 도시를 갱신
		if (rootA != rootB)
			rootCity[Math.max(rootA, rootB)] = Math.min(rootA, rootB);
	}
	
	// ----------------------------------------------------------------------------------------------------

	// cityFinder() 메서드 정의
	public static int cityFinder(int city) {
		
		// 부모 도시가 자기 자신인 경우 자기 자신을 반환
		if (rootCity[city] == city)
			return city;
		
		// cityFinder() 메서드를 재귀 호출해 부모 도시를 찾아 반환
		return rootCity[city] = cityFinder(rootCity[city]);
	}
}