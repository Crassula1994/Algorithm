package gold5.num15686;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 도시의 크기, 제한할 치킨집의 개수, 도시의 최소 치킨 거리를 나타낼 각 변수 초기화
	static int size;
	static int limit;
	static int minDistance = Integer.MAX_VALUE;
	
	// 입력 받은 집의 위치, 치킨집의 위치, 해당 치킨집의 폐업 여부를 저장할 각 배열 초기화
	static List<int[]> houses = new ArrayList<>();
	static List<int[]> restaurants = new ArrayList<>();
	static boolean[] isOpened;
	
	// 입력 받은 도시의 상태를 저장할 2차원 배열 city 초기화
	static int[][] city;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 도시의 크기 및 제한할 치킨집의 개수를 각 변수에 할당
		size = Integer.parseInt(st.nextToken());
		limit = Integer.parseInt(st.nextToken());
		
		// 입력 받은 도시의 상태를 저장할 2차원 배열 city 초기화
		city = new int[size][size];
		
		// for 반복문을 사용해 도시의 각 행을 순회
		for (int r = 0; r < size; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 도시의 각 열을 순회
			for (int c = 0; c < size; c++) {
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 도시의 상태를 2차원 배열 city에 저장
				city[r][c] = Integer.parseInt(st.nextToken());
				
				// 해당 위치가 집인 경우 houses에 추가
				if (city[r][c] == 1)
					houses.add(new int[] {r, c});
				
				// 해당 위치가 치킨집인 경우 restaurants에 추가
				if (city[r][c] == 2)
					restaurants.add(new int[] {r, c});
			}
		}
		
		// 각 치킨집의 폐업 여부를 저장할 배열 isOpened 초기화
		isOpened = new boolean[restaurants.size()];
		
		// restaurantSelector() 메서드를 호출해 도시의 최소 치킨 거리를 갱신
		restaurantSelector(0, 0);
		
		// valueOf() 및 write() 메서드를 사용해 도시의 최소 치킨 거리를 출력
		out.write(String.valueOf(minDistance));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// restaurantSelector() 메서드 정의
	public static void restaurantSelector(int startIdx, int selectedNum) {
		
		// 선택한 치킨집의 개수가 제한할 치킨집의 개수와 같은 경우
		if (selectedNum == limit) {
			
			// distanceCalculator() 메서드를 호출해 도시의 최소 치킨 거리를 갱신
			distanceCalculator();
			
			// 메서드 종료
			return;
		}
		
		// for 반복문을 사용해 각 치킨집을 순회
		for (int idx = startIdx; idx < restaurants.size(); idx++) {
			
			// 해당 치킨집을 선택 처리
			isOpened[idx] = true;
			
			// restaurantSelector() 메서드 재귀 호출
			restaurantSelector(idx + 1, selectedNum + 1);
			
			// 해당 치킨집의 선택 여부를 원상 복구
			isOpened[idx] = false;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// distanceCalculator() 메서드 정의
	public static void distanceCalculator() {
		
		// 치킨집을 모두 선택했을 때 도시의 치킨 거리를 저장할 변수 totalDistance 초기화
		int totalDistance = 0;
		
		// for 반복문을 사용해 각 집을 순회
		for (int i = 0; i < houses.size(); i++) {
			
			// get() 메서드를 사용해 현재 확인 중인 집의 위치를 배열 house에 할당
			int[] house = houses.get(i);
			
			// 해당 집의 최소 치킨 거리를 저장할 변수 minDist 초기화
			int minDist = Integer.MAX_VALUE;
			
			// for 반복문을 사용해 각 치킨집을 순회
			for (int j = 0; j < restaurants.size(); j++) {
				
				// 해당 치킨집이 폐업 상태가 아닌 경우
				if (isOpened[j]) {
					
					// get() 메서드를 사용해 현재 확인 중인 치킨집의 위치를 배열 restaurant에 할당
					int[] restaurant = restaurants.get(j);
					
					// abs() 메서드를 사용해 해당 집의 치킨 거리를 계산해 변수 dist에 할당
					int dist = Math.abs(house[0] - restaurant[0]) + Math.abs(house[1] - restaurant[1]);
					
					// min() 메서드를 사용해 해당 집의 최소 치킨 거리를 갱신
					minDist = Math.min(dist, minDist);
				}
			}
			
			// 도시의 치킨 거리를 갱신
			totalDistance += minDist;
		}
		
		// min() 메서드를 사용해 도시의 최소 치킨 거리를 갱신
		minDistance = Math.min(totalDistance, minDistance);
	}
}