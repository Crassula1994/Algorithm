package gold4.num14938;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 경로가 존재하지 않을 경우 초기화할 무한대의 값을 상수 INF에 할당
	static final int INF = 10000;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 지역의 개수,	예은이의 수색 범위, 길의 개수를 각 변수에 할당
		int zoneNum = Integer.parseInt(st.nextToken());
		int searchRange = Integer.parseInt(st.nextToken());
		int pathNum = Integer.parseInt(st.nextToken());
		
		// 각 지역별 아이템의 수를 저장할 배열 items 초기화
		int[] items = new int[zoneNum + 1];
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 지역별 아이템의 개수를 배열 items에 저장
		for (int idx = 1; idx <= zoneNum; idx++)
			items[idx] = Integer.parseInt(st.nextToken());
		
		// 각 지역 사이 길의 최단 길이를 저장할 2차원 배열 paths 초기화
		int[][] paths = new int[zoneNum + 1][zoneNum + 1];
		
		// for 반복문을 사용해 2차원 배열 paths의 행과 열을 순회
		for (int r = 1; r <= zoneNum; r++) {
			for (int c = 1; c <= zoneNum; c++)
				
				// 출발지와 목적지가 다른 경우를 제외하고 길의 정보를 초기화
				if (r != c)
					paths[r][c] = INF;
		}
		
		// for 반복문을 사용해 각 길의 정보를 순회
		for (int path = 0; path < pathNum; path++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 길의 정보를 각 변수에 할당
			int startZone = Integer.parseInt(st.nextToken());
			int endZone = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			
			// 입력 받은 길의 정보를 2차원 배열 paths에 갱신
			paths[startZone][endZone] = length;
			paths[endZone][startZone] = length;
		}
		
		// for 반복문을 사용해 모든 경유지, 출발지, 도착지를 순회
		for (int stopover = 1; stopover <= zoneNum; stopover++) {
			for (int start = 1; start <= zoneNum; start++) {
				for (int end = 1; end <= zoneNum; end++) {
					
					// 경유지를 거치는 것이 더 짧은 경우 최소 비용 갱신
					if (paths[start][stopover] + paths[stopover][end] < paths[start][end])
						paths[start][end] = paths[start][stopover] + paths[stopover][end];
				}
			}
		}
		
		// 예은이가 얻을 수 있는 최대 아이템 개수를 저장할 변수 maxItem 초기화
		int maxItem = 0;
		
		// for 반복문을 사용해 각 지역을 순회
		for (int zone = 1; zone <= zoneNum; zone++) {
			
			// 각 지역에서 얻을 수 있는 아이템의 개수를 저장할 변수 count 초기화
			int count = 0;
			
			// for 반복문을 사용해 다른 지역을 순회
			for (int idx = 1; idx <= zoneNum; idx++) {
				
				// 수색 범위 내의 지역인 경우 아이템의 개수 갱신
				if (paths[zone][idx] <= searchRange)
					count += items[idx];
			}
			
			// max() 메서드를 사용해 예은이가 얻을 수 있는 최대 아이템 개수를 갱신
			maxItem = Math.max(count, maxItem);
		}
		
		// valueOf() 및 write() 메서드를 사용해 예은이가 얻을 수 있는 최대 아이템 개수를 출력
		out.write(String.valueOf(maxItem));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}