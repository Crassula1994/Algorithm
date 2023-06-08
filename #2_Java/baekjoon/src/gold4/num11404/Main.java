package gold4.num11404;

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
	static final int INF = 10000001;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 도시의 개수 및 버스의 개수를 각 변수에 할당
		int cityNum = Integer.parseInt(in.readLine());
		int busNum = Integer.parseInt(in.readLine());
		
		// 각 도시 간의 버스 경로 및 최소 비용을 저장할 각 2차원 배열 초기화
		int[][] busRoute = new int[cityNum + 1][cityNum + 1];
		int[][] costs = new int[cityNum + 1][cityNum + 1];
		
		// for 반복문을 사용해 2차원 배열 busRoute의 각 행과 열을 순회
		for (int r = 1; r <= cityNum; r++) {
			for (int c = 1; c <= cityNum; c++) {
				
				// 출발지와 도착지가 같은 경우를 제외하고 연결 정보를 초기화
				if (r != c)
					busRoute[r][c] = INF;
			}
		}
		
		// for 반복문을 사용해 각 버스 정보를 순회
		for (int bus = 0; bus < busNum; bus++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 버스 정보를 각 변수에 할당
			int startCity = Integer.parseInt(st.nextToken());
			int endCity = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			// min() 메서드를 사용해 입력 받은 버스 정보를 2차원 배열 busRoute에 갱신
			busRoute[startCity][endCity] = Math.min(cost, busRoute[startCity][endCity]);
		}
		
		// for 반복문을 사용해 최소 비용을 저장할 costs 배열 초기화
		for (int r = 1; r <= cityNum; r++) {
			for (int c = 1; c <= cityNum; c++)
				costs[r][c] = busRoute[r][c];
		}
		
		// for 반복문을 사용해 모든 경유지, 출발지, 도착지를 순회
		for (int stopover = 1; stopover <= cityNum; stopover++) {
			for (int start = 1; start <= cityNum; start++) {
				for (int end = 1; end <= cityNum; end++) {
					
					// 경유지를 거치는 것이 더 짧은 경우 최소 비용 갱신
					if (costs[start][stopover] + costs[stopover][end] < costs[start][end])
						costs[start][end] = costs[start][stopover] + costs[stopover][end];
				}
			}
		}
		
		// for 반복문을 사용해 배열 costs의 각 행과 열을 순회
		for (int r = 1; r <= cityNum; r++) {
			for (int c = 1; c <= cityNum; c++) {
				
				// 각 도시 간 이동 방법이 없는 경우 0을 출력
				if (costs[r][c] == INF) {
					out.write(0 + " ");
					
				// 각 도시 간 이동 방법이 있는 경우 최소 비용을 출력
				} else {
					out.write(costs[r][c] + " ");
				}
			}
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}