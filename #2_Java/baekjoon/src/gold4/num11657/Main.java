package gold4.num11657;

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
	
	// Bus 클래스 정의
	static class Bus {
		
		// 버스 노선의 시작 도시, 도착 도시, 걸리는 시간을 나타내는 각 변수 초기화
		int source;
		int destination;
		int time;
		
		// 인자를 입력 받는 생성자 정의
		public Bus(int source, int destination, int time) {
			this.source = source;
			this.destination = destination;
			this.time = time;
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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 도시의 개수 및 버스 노선의 개수를 각 변수에 할당
		int cityNum = Integer.parseInt(st.nextToken());
		int busNum = Integer.parseInt(st.nextToken());
		
		// 버스 노선의 정보를 저장할 List 객체 busLines 초기화
		List<Bus> busLines = new ArrayList<>();

		// for 반복문을 사용하여 각 버스 노선의 정보를 순회
		for (int line = 0; line < busNum; line++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 버스 노선의 시작 도시, 도착 도시, 걸리는 시간을 각 변수에 할당
			int source = Integer.parseInt(st.nextToken());
			int destination = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			
			// add() 메서드를 사용해 버스 노선의 정보를 busLines에 추가
			busLines.add(new Bus(source, destination, time));
		}
		
		// 각 도시까지의 최단 시간을 저장할 배열 minTime 초기화
		long[] minTime = new long[cityNum + 1];
		
		// fill() 메서드를 사용해 최단 시간을 무한대의 값으로 초기화 및 시작 도시의 최단 시간을 초기화
		Arrays.fill(minTime, INF);
		minTime[1] = 0;
		
		// for 반복문을 사용해 각 도시를 순회
		for (int city = 1; city <= cityNum; city++) {
			
			// for 반복문을 사용해 각 버스 노선을 순회
			for (Bus busLine : busLines) {
				
				// 해당 노선의 시작 도시, 도착 도시, 걸리는 시간을 각 변수에 할당
				int source = busLine.source;
				int destination = busLine.destination;
				int time = busLine.time;
				
				// 출발 도시와 시작 도시가 연결되어 있고, 목적 도시까지의 거리가 더 짧은 경우 목적 도시까지의 최단 시간을 갱신
				if (minTime[source] != INF && minTime[source] + time < minTime[destination])
					minTime[destination] = minTime[source] + time;
			}
		}
		
		// 시간을 무한히 오래 전으로 되돌릴 수 있는지 여부를 나타낼 변수 hasCycle 초기화
		boolean hasCycle = false;
			
		// for 반복문을 사용해 각 버스 노선을 순회
		for (Bus busLine : busLines) {
			
			// 해당 노선의 시작 도시, 도착 도시, 걸리는 시간을 각 변수에 할당
			int source = busLine.source;
			int destination = busLine.destination;
			int time = busLine.time;
			
			// 시간을 무한히 오래 전으로 되돌릴 수 있는 경우 hasCycle 변수 갱신 후 반복문 탈출
			if (minTime[source] != INF && minTime[source] + time < minTime[destination]) {
				hasCycle = true;
				break;
			}
		}
		
		// 시간을 무한히 오래 전으로 되돌릴 수 있는 경우 -1을 출력
		if (hasCycle) {
			out.write(String.valueOf(-1));
		
		// 시간을 무한히 오래 전으로 되돌릴 수 없는 경우
		} else {
			
			// for 반복문을 사용해 각 도시의 최단 시간을 순회
			for (int idx = 2; idx < minTime.length; idx++) {
				
				// 해당 도시에 도달할 수 없는 경우 -1을 출력
				if (minTime[idx] == INF) {
					out.write(-1 + "\n");
					
				// 해당 도시에 도달할 수 있는 경우 최단 시간을 출력
				} else {
					out.write(minTime[idx] + "\n");
				}
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}