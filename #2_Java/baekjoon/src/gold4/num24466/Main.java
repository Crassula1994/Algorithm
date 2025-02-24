package gold4.num24466;

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
	
	// 병준이가 있을 가장 높은 확률을 소숫점으로 나타내기 위한 제수를 저장할 상수 DIVISOR 초기화
	static final long DIVISOR = 1_000_000_000_000_000_000L;
	
	// ----------------------------------------------------------------------------------------------------
	
	// Route 클래스 정의
	static class Route {
		
		// 경로의 목적지 및 이동할 확률을 저장할 각 변수 초기화
		int destination;
		int percentage;
		
		// 매개변수를 입력 받는 생성자 정의
		public Route(int destination, int percentage) {
			this.destination = destination;
			this.percentage = percentage;
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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 도시의 수 및 이동 가능한 경로의 수를 각 변수에 할당
		int cityNum = Integer.parseInt(st.nextToken());
		int routeNum = Integer.parseInt(st.nextToken());
		
		// 병준이가 있을 가장 높은 확률을 저장할 변수 maxPercentage 초기화
		long maxPercentage = 0;
		
		// 각 도시 간 경로, 현재 및 다음 날 도시 간의 이동 확률을 저장할 각 배열 초기화
		List<Route>[] routes = new ArrayList[cityNum];
		long[] curPercentage = new long[cityNum];
		long[] nextPercentage = new long[cityNum];
		
		// 병준이가 있을 확률이 가장 높은 도시의 번호를 저장할 List 객체 maxCity 초기화
		List<Integer> maxCity = new ArrayList<>();
		
		// for 반복문을 사용해 각 도시 간 경로를 저장할 List 객체 초기화
		for (int idx = 0; idx < routes.length; idx++)
			routes[idx] = new ArrayList<>();
		
		// while 반복문을 사용해 각 이동 가능한 경로를 순회
		while (routeNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 해당 경로의 정보를 각 변수에 할당
			int origin = Integer.parseInt(st.nextToken());
			int destination = Integer.parseInt(st.nextToken());
			int percentage = Integer.parseInt(st.nextToken());
			
			// add() 메서드를 사용해 해당 경로의 정보를 배열 routes에 저장
			routes[origin].add(new Route(destination, percentage));
		}
		
		// 탈옥 시점의 도시 간 이동 확률을 초기화
		curPercentage[0] = 1;
		
		// for 반복문을 사용해 각 날짜를 순회
		for (int day = 0; day < 9; day++) {
			
			// for 반복문을 사용해 각 도시를 순회
			for (int idx = 0; idx < cityNum; idx++) {
				
				// for 반복문을 사용해 다음 날 도시 간 이동 확률을 갱신
				for (Route route : routes[idx])
					nextPercentage[route.destination] += curPercentage[idx] * route.percentage;
			}
			
			// clone() 메서드를 사용해 현재 도시 간 이동 확률을 갱신
			curPercentage = nextPercentage.clone();
			
			// 다음 날 도시 간 이동 확률을 저장할 배열 nextPercentage 초기화
			nextPercentage = new long[cityNum];
		}
		
		// for 반복문을 사용해 각 도시를 순회
		for (int idx = 0; idx < curPercentage.length; idx++) {
			
			// 해당 도시에 있을 확률이 저장된 가장 높은 확률보다 높은 경우
			if (curPercentage[idx] > maxPercentage) {
				
				// 병준이가 있을 가장 높은 확률을 갱신
				maxPercentage = curPercentage[idx];
				
				// clear() 메서드를 사용해 기존 maxCity에 저장된 도시를 삭제
				maxCity.clear();
				
				// add() 메서드를 사용해 해당 도시를 maxCity에 저장
				maxCity.add(idx);
			
			// 해당 도시에 있을 확률이 저장된 가장 높은 확률과 같은 경우 해당 도시를 maxCity에 저장
			} else if (curPercentage[idx] == maxPercentage) {
				maxCity.add(idx);
			}
		}
		
		// for 반복문을 사용해 병준이가 있을 확률이 가장 높은 도시의 번호를 출력
		for (int city : maxCity)
			out.write(city + " ");
		
		// newLine() 메서드를 사용해 줄바꿈을 출력
		out.newLine();
		
		// format() 및 write() 메서드를 사용해 병준이가 있을 가장 높은 확률을 출력
		out.write(String.format("%d.%018d", maxPercentage / DIVISOR, maxPercentage % DIVISOR));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}