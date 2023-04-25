package gold5.num01916;

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
	
	// Bus 클래스 정의
	static class Bus {
		
		// 버스의 도착 도시, 버스 비용을 나타내는 각 변수 초기화
		int destination;
		int cost;
		
		// 매개변수를 입력 받는 생성자 정의
		public Bus(int destination, int cost) {
			this.destination = destination;
			this.cost = cost;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 도시의 개수 및 버스의 개수를 각 변수에 할당
		int cityNum = Integer.parseInt(in.readLine());
		int busNum = Integer.parseInt(in.readLine());
		
		// 버스의 정보를 저장할 배열 busInfo 초기화
		@SuppressWarnings("unchecked")
		List<Bus>[] busInfo = new ArrayList[cityNum + 1];
		
		// for 반복문을 사용해 각 버스의 정보를 저장할 List 객체 초기화
		for (int idx = 0; idx < busInfo.length; idx++)
			busInfo[idx] = new ArrayList<>();

		// for 반복문을 사용해 각 버스의 정보를 순회
		for (int bus = 0; bus < busNum; bus++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 버스의 정보를 각 변수에 할당
			int departure = Integer.parseInt(st.nextToken());
			int destination = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			// add() 메서드를 사용해 해당 지름길의 정보를 List 객체 busInfo에 저장
			busInfo[departure].add(new Bus(destination, cost));
		}
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 출발 도시와 도착 도시를 각 변수에 할당
		int startCity = Integer.parseInt(st.nextToken());
		int endCity = Integer.parseInt(st.nextToken());
		
		// 출발 도시로부터 각 도시까지의 최소 비용, 해당 도시의 비용 확인 여부를 저장할 각 배열 초기화
		int[] minCost = new int[cityNum + 1];
		boolean[] isConfirmed = new boolean[cityNum + 1];
		
		// fill() 메서드를 사용해 배열 minCost의 각 원소를 초기화
		Arrays.fill(minCost, Integer.MAX_VALUE);

		// 출발 도시의 최소 비용을 초기화
		minCost[startCity] = 0;
		
		// 현재 도시를 기준으로 가장 가까워 다음으로 확인할 도시를 저장할 PrioirtyQueue 객체 confirmList 초기화
		PriorityQueue<int[]> confirmList = new PriorityQueue<>((c1, c2) -> {
			return c1[1] - c2[1];
		});
		
		// offer() 메서드를 사용해 출발 도시를 confirmList에 추가
		confirmList.offer(new int[] {startCity, 0});
		
		// while 반복문을 사용해 confirmList가 빌 때까지 순회
		while (!confirmList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 확인 중인 도시를 배열 currentCity에 할당
			int[] currentCity = confirmList.poll();
			
			// 현재 확인 중인 도시를 이미 확인한 경우 다음 도시를 순회
			if (isConfirmed[currentCity[0]])
				continue;
			
			// 현재 확인 중인 도시를 확인 처리
			isConfirmed[currentCity[0]] = true;
			
			// for 반복문을 사용해 현재 도시의 버스 노선을 순회
			for (int idx = 0; idx < busInfo[currentCity[0]].size(); idx++) {
				
				// get() 메서드를 사용해 해당 버스 노선을 변수 bus에 할당
				Bus bus = busInfo[currentCity[0]].get(idx);
				
				// 해당 버스 노선의 목적지를 이미 확인한 경우 다음 버스 노선을 순회
				if (isConfirmed[bus.destination])
					continue;
				
				// min() 메서드를 사용해 해당 도시까지의 최소 비용을 갱신
				minCost[bus.destination] = Math.min(currentCity[1] + bus.cost, minCost[bus.destination]);
				
				// offer() 메서드를 사용해 해당 도시를 confirmList에 추가
				confirmList.offer(new int[] {bus.destination, minCost[bus.destination]});
			}
		}
		
		// valueOf() 및 wirte() 메서드를 사용해 출발 도시에 도착 도시까지의 최소 비용을 출력
		out.write(String.valueOf(minCost[endCity]));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}