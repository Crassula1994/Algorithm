package gold4.num30797;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 각 도시의 대표 도시를 저장할 배열 rootCity 초기화
	static int[] rootCity;
	
	// ----------------------------------------------------------------------------------------------------
	
	// Track 클래스 정의
	static class Track implements Comparable<Track> {
		
		// 해당 철도가 연결하는 도시, 건설 비용, 건설 완료 시각을 저장할 각 변수 초기화
		int startCity;
		int endCity;
		int cost;
		int time;
		
		// 매개변수를 입력 받는 생성자 정의
		public Track(int startCity, int endCity, int cost, int time) {
			this.startCity = startCity;
			this.endCity = endCity;
			this.cost = cost;
			this.time = time;
		}

		// compareTo() 메서드 정의
		@Override
		public int compareTo(Track anotherTrack) {
			
			// 건설 비용이 적은 순서대로, 건설 비용이 같은 경우 건설 완료 시각이 빠른 순서대로 정렬
			return (this.cost == anotherTrack.cost)
					? this.time - anotherTrack.time : this.cost - anotherTrack.cost;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 도시의 수와 건설할 수 있는 노선의 수를 각 변수에 할당
		int cityNum = Integer.parseInt(st.nextToken());
		int trackNum = Integer.parseInt(st.nextToken());
		
		// 건설할 수 있는 노선이 가희의 도시와 다른 모든 도시를 연합하기 위한 노선의 최소 개수 미만인 경우 -1을 출력
		if (trackNum < cityNum - 1) {
			out.write("-1");
			
		// 건설할 수 있는 노선이 가희의 도시와 다른 모든 도시를 연합하기 위한 노선의 최소 개수 이상인 경우
		} else {
			
			// 모든 도시가 연합을 하는 시점, 총 건설 비용, 건설한 철도 노선의 수를 저장할 각 변수 초기화
			int endTime = 0;
			long totalCost = 0;
			int count = 0;
			
			// 각 도시의 대표 도시, 철도 노선의 정보를 저장할 각 배열 초기화
			rootCity = new int[cityNum + 1];
			Track[] tracks = new Track[trackNum];
			
			// for 반복문을 사용해 각 도시의 대표 도시를 초기화
			for (int idx = 1; idx < rootCity.length; idx++)
				rootCity[idx] = idx;
			
			// for 반복문을 사용해 각 철도 노선의 정보를 순회
			for (int idx = 0; idx < tracks.length; idx++) {
				
				// StringTokenizer 객체를 불러와 변수 st에 재할당
				st = new StringTokenizer(in.readLine());
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 철도 노선의 정보를 각 변수에 할당
				int startCity = Integer.parseInt(st.nextToken());
				int endCity = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());
				
				// 해당 철도 노선의 정보를 배열 tracks에 저장
				tracks[idx] = new Track(startCity, endCity, cost, time);
			}
			
			// sort() 메서드를 사용해 각 철도 노선을 건설 비용이 적고, 건설 완료 시각이 빠른 순서대로 정렬
			Arrays.sort(tracks);
			
			// for 반복문을 사용해 각 철도 노선을 순회
			for (Track track : tracks) {
				
				// 해당 철도 노선의 두 도시가 이미 연결된 경우 다음 철도 노선을 순회
				if (cityFinder(track.startCity) == cityFinder(track.endCity))
					continue;
				
				// cityConnector() 메서드를 호출해 두 도시를 연합 처리
				cityConnector(track.startCity, track.endCity);
				
				// max() 메서드를 사용해 모든 도시가 연합을 하는 시점을 갱신
				endTime = Math.max(track.time, endTime);
				
				// 총 건설 비용 및 건설한 철도 노선의 수를 갱신
				totalCost += track.cost;
				count++;
				
				// 모든 도시와 연합을 이룬 경우 반복문 탈출
				if (count == cityNum - 1)
					break;
			}
			
			// write() 메서드를 사용해 모든 도시가 연합을 하는 시점 및 총 건설 비용을 출력
			out.write(count < cityNum - 1 ? "-1" : endTime + " " + totalCost);
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// cityFinder() 메서드 정의
	public static int cityFinder(int city) {
		
		// 해당 도시의 대표 도시가 자기 자신인 경우 이를 반환
		if (rootCity[city] == city)
			return city;
		
		// cityFinder() 메서드를 재귀 호출해 해당 도시의 대표 도시를 찾아 반환
		return rootCity[city] = cityFinder(rootCity[city]);
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// cityConnector() 메서드 정의
	public static void cityConnector(int cityA, int cityB) {
		
		// cityFinder() 메서드를 호출해 각 도시의 대표 도시를 각 변수에 할당
		int rootCityA = cityFinder(cityA);
		int rootCityB = cityFinder(cityB);
		
		// max() 및 min() 메서드를 사용해 두 도시를 연결 처리
		rootCity[Math.max(rootCityA, rootCityB)] = Math.min(rootCityA, rootCityB);
	}
}