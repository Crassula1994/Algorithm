package gold4.num01956;

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
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 마을의 개수 및 도로의 개수를 각 변수에 할당
		int townNum = Integer.parseInt(st.nextToken());
		int roadNum = Integer.parseInt(st.nextToken());
		
		// 각 마을 간의 도로 및 최단 길이를 저장할 각 2차원 배열 초기화
		int[][] roads = new int[townNum + 1][townNum + 1];
		int[][] lengths = new int[townNum + 1][townNum + 1];
		
		// for 반복문을 사용해 2차원 배열 roads의 도로 연결 정보를 초기화
		for (int r = 1; r <= townNum; r++) {
			for (int c = 1; c <= townNum; c++)
				roads[r][c] = INF;
		}
		
		// for 반복문을 사용해 각 도로 정보를 순회
		for (int road = 0; road < roadNum; road++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 도로 정보를 각 변수에 할당
			int startTown = Integer.parseInt(st.nextToken());
			int endTown = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			
			// 입력 받은 도로 정보를 2차원 배열 roads에 갱신
			roads[startTown][endTown] = length;
		}
		
		// for 반복문을 사용해 최단 길이를 저장할 lengths 배열 초기화
		for (int r = 1; r <= townNum; r++) {
			for (int c = 1; c <= townNum; c++)
				lengths[r][c] = roads[r][c];
		}
		
		// for 반복문을 사용해 모든 경유지, 출발지, 도착지를 순회
		for (int stopover = 1; stopover <= townNum; stopover++) {
			for (int start = 1; start <= townNum; start++) {
				for (int end = 1; end <= townNum; end++) {
					
					// 경유지를 거치는 것이 더 짧은 경우 최소 비용 갱신
					if (lengths[start][stopover] + lengths[stopover][end] < lengths[start][end])
						lengths[start][end] = lengths[start][stopover] + lengths[stopover][end];
				}
			}
		}
		
		// 최소 사이클의 도로 길이의 합을 저장할 변수 minLength 초기화
		int minLength = INF;
		
		// for 반복문을 사용해 최소 사이클의 도로 길이의 합을 갱신
		for (int idx = 1; idx <= townNum; idx++)
			minLength = Math.min(lengths[idx][idx], minLength);
		
		// 운동 경로를 찾는 것이 불가능한 경우 -1 출력
		if (minLength == INF) {
			out.write(String.valueOf(-1));
			
		// 운동 경로를 찾을 수 있는 경우 최소 사이클의 도로 길이의 합을 출력
		} else {
			out.write(String.valueOf(minLength));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}