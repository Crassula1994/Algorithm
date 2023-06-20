package gold3.num01865;

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
	
	// 무한대의 값을 나타낼 상수 INF 초기화
	static final int INF = Integer.MAX_VALUE;
	
	// Path 클래스 정의
	static class Path {
		
		// 도로 및 웜홀의 시작 지점, 도착 지점, 걸리는 시간을 나타내는 각 변수 초기화
		int startPoint;
		int endPoint;
		int time;
		
		// 인자를 입력 받는 생성자 정의
		public Path(int startPoint, int endPoint, int time) {
			this.startPoint = startPoint;
			this.endPoint = endPoint;
			this.time = time;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 지점의 개수, 도로의 개수, 웜홀의 개수를 각 변수에 할당
			int pointNum = Integer.parseInt(st.nextToken());
			int roadNum = Integer.parseInt(st.nextToken());
			int wormholeNum = Integer.parseInt(st.nextToken());
			
			// 도로 및 웜홀의 정보를 저장할 List 객체 paths 초기화
			List<Path> paths = new ArrayList<>();
			
			// for 반복문을 사용하여 각 도로와 웜홀의 정보를 순회
			for (int path = 0; path < roadNum + wormholeNum; path++) {
				
				// StringTokenizer 객체를 불러와 변수 st에 재할당
				st = new StringTokenizer(in.readLine());
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 도로 및 웜홀의 시작 지점, 도착 지점, 걸리는 시간을 각 변수에 할당
				int startPoint = Integer.parseInt(st.nextToken());
				int endPoint = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());
				
				// 도로의 경우 add() 메서드를 사용해 도로의 정보를 paths에 추가
				if (path < roadNum) {
					paths.add(new Path(startPoint, endPoint, time));
					paths.add(new Path(endPoint, startPoint, time));
				
				// 웜홀의 경우 add() 메서드를 사용해 웜홀의 정보를 paths에 추가
				} else {
					paths.add(new Path(startPoint, endPoint, -time));
				}
			}
			
			// 각 지점까지의 최단 시간을 저장할 배열 minTime 초기화
			long[] minTime = new long[pointNum + 1];
			
			// fill() 메서드를 사용해 최단 시간을 무한대의 값으로 초기화 및 시작 지점의 최단 시간을 초기화
			Arrays.fill(minTime, INF);
			minTime[1] = 0;
			
			// for 반복문을 사용해 각 지점을 순회
			for (int point = 1; point <= pointNum; point++) {
				
				// for 반복문을 사용해 각 도로와 웜홀을 순회
				for (Path path : paths) {
					
					// 해당 도로 및 웜홀의 시작 지점, 도착 지점, 걸리는 시간을 각 변수에 할당
					int startPoint = path.startPoint;
					int endPoint = path.endPoint;
					int time = path.time;
					
					// 목적 지점까지의 시간이 더 짧은 경우 목적 지점까지의 최단 시간을 갱신
					if (minTime[startPoint] + time < minTime[endPoint])
						minTime[endPoint] = minTime[startPoint] + time;
				}
			}
			
			// 시간이 줄어들면서 출발 위치로 돌아올 수 있는지 여부를 나타낼 변수 isPossible 초기화
			boolean isPossible = false;
			
			// for 반복문을 사용해 각 도로와 웜홀을 순회
			for (Path path : paths) {
				
				// 해당 도로 및 웜홀의 시작 지점, 도착 지점, 걸리는 시간을 각 변수에 할당
				int startPoint = path.startPoint;
				int endPoint = path.endPoint;
				int time = path.time;
				
				// 시간이 줄어들면서 출발 위치로 돌아올 수 있는 경우 isPossible 변수 갱신 후 반복문 탈출
				if (minTime[startPoint] + time < minTime[endPoint]) {
					isPossible = true;
					break;
				}
			}
			
			// 시간이 줄어들면서 출발 위치로 돌아올 수 있는 경우 'YES' 출력
			if (isPossible) {
				out.write("YES");
				
			// 시간이 줄어들면서 출발 위치로 돌아올 수 없는 경우 'NO' 출력
			} else {
				out.write("NO");
			}
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}