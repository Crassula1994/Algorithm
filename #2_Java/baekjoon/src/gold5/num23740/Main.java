package gold5.num23740;

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
	
	// BusRoute 클래스 정의
	public static class BusRoute implements Comparable<BusRoute> {
		
		// 버스 노선의 구간과 요금을 저장할 각 변수 초기화
		int start;
		int end;
		int cost;
		
		// 매개변수를 입력 받는 생성자 정의
		public BusRoute(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

		// compareTo() 메서드 정의
		@Override
		public int compareTo(BusRoute otherRoute) {
			return this.start - otherRoute.start;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 버스 노선의 수를 변수 routeNum에 할당
		int routeNum = Integer.parseInt(in.readLine());
		
		// 버스 노선을 저장할 배열 busRoutes 초기화
		BusRoute[] busRoutes = new BusRoute[routeNum];
		
		// 버스 노선의 개편 결과를 저장할 List 객체 newRoutes 초기화
		List<BusRoute> newRoutes = new ArrayList<>();
		
		// for 반복문을 사용해 각 버스 노선을 순회
		for (int idx = 0; idx < busRoutes.length; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 버스 노선의 구간과 요금을 각 변수에 할당
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			// 해당 버스 노선의 정보를 배열 busRoutes에 저장
			busRoutes[idx] = new BusRoute(start, end, cost);
		}
		
		// sort() 메서드를 사용해 버스 노선을 구간의 시작 지점을 기준으로 오름차순 정렬
		Arrays.sort(busRoutes);
		
		// for 반복문을 사용해 각 버스 노선을 순회
		for (BusRoute busRoute : busRoutes) {
			
			// 저장된 노선이 없거나 저장된 노선과 겹치지 않는 경우 해당 버스 노선을 추가
			if (newRoutes.isEmpty() || newRoutes.get(newRoutes.size() - 1).end < busRoute.start) {
				newRoutes.add(busRoute);
			
			// 저장된 노선과 겹치는 경우
			} else {
				
				// size() 및 get() 메서드를 사용해 마지막으로 저장된 노선을 변수 newRoute에 할당
				BusRoute newRoute = newRoutes.get(newRoutes.size() - 1);
				
				// max() 및 min() 메서드를 사용해 개편된 노선의 끝 구간과 비용을 갱신
				newRoute.end = Math.max(busRoute.end, newRoute.end);
				newRoute.cost = Math.min(busRoute.cost, newRoute.cost);
			}
		}
		
		// size() 및 write() 메서드를 사용해 개편된 버스 노선의 수를 출력
		out.write(newRoutes.size() + "\n");
		
		// for 반복문을 사용해 각 버스 노선의 구간과 요금을 출력
		for (BusRoute newRoute : newRoutes)
			out.write(newRoute.start + " " + newRoute.end + " " + newRoute.cost + "\n");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}