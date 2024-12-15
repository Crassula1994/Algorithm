package gold5.num05996;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 각 도시를 연결하는 길의 최소 비용을 초기화할 상수 INF 초기화
	static final int INF = 987654321;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 도시의 수, 길의 수, 시작 도시, 도착 도시를 각 변수에 할당
		int townNum = Integer.parseInt(st.nextToken());
		int roadNum = Integer.parseInt(st.nextToken());
		int startTown = Integer.parseInt(st.nextToken());
		int endTown = Integer.parseInt(st.nextToken());
		
		// 시작 도시로부터 각 도시까지의 최소 비용, 길의 정보를 저장할 각 배열 초기화
		int[] minExpenses = new int[townNum + 1];
		List<int[]>[] connections = new ArrayList[townNum + 1];
		
		// 다음에 비용을 계산할 도시를 저장할 PriorityQueue 객체 travelList 초기화
		PriorityQueue<int[]> travelList = new PriorityQueue<>((t1, t2) -> {
			return t1[1] - t2[1];
		});
		
		// fill() 메서드를 사용해 시작 도시로부터 각 도시까지의 최소 비용을 초기화
		Arrays.fill(minExpenses, INF);
		
		// for 반복문을 사용해 입력 받은 길의 정보를 저장할 각 List 객체 초기화
		for (int idx = 0; idx < connections.length; idx++)
			connections[idx] = new ArrayList<>();
		
		// while 반복문을 사용해 각 길의 정보를 순회
		while (roadNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 각 길의 정보를 각 변수에 할당
			int origin = Integer.parseInt(st.nextToken());
			int destination = Integer.parseInt(st.nextToken());
			int expense = Integer.parseInt(st.nextToken());
			
			// add() 메서드를 사용해 해당 길의 정보를 배열 connections에 저장
			connections[origin].add(new int[] {destination, expense});
			connections[destination].add(new int[] {origin, expense});
		}
		
		// 시작 도시까지의 최소 비용을 초기화
		minExpenses[startTown] = 0;
		
		// offer() 메서드를 사용해 시작 도시의 정보를 travelList에 추가
		travelList.offer(new int[] {startTown, 0});
		
		// while 반복문을 사용해 travelList가 빌 때까지 순회
		while (!travelList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 도시의 정보를 배열 currentTown에 할당
			int[] currentTown = travelList.poll();
			
			// 해당 도시를 이미 비용 계산한 경우 다음 도시를 순회
			if (currentTown[1] > minExpenses[currentTown[0]])
				continue;
			
			// for 반복문을 사용해 해당 도시와 연결된 다른 도시를 순회
			for (int[] nextTown : connections[currentTown[0]]) {
				
				// 저장된 시작 도시까지의 최소 비용보다 해당 도시를 거치는 것이 더 비용이 적은 경우
				if (minExpenses[currentTown[0]] + nextTown[1] < minExpenses[nextTown[0]]) {
					
					// 해당 도시의 시작 도시까지의 최소 비용을 갱신
					minExpenses[nextTown[0]] = minExpenses[currentTown[0]] + nextTown[1];
					
					// offer() 메서드를 사용해 해당 도시의 정보를 travelList에 추가
					travelList.offer(new int[] {nextTown[0], minExpenses[nextTown[0]]});
				}
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 시작 도시부터 도착 도시까지의 최소 비용을 출력
		out.write(String.valueOf(minExpenses[endTown]));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}