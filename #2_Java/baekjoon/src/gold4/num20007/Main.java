package gold4.num20007;

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
	
	// 성현이의 집으로부터 다른 집까지의 초기 거리를 나타낼 상수 INF 초기화
	static final int INF = 1000000000;
	
	// 성현이의 집에서 다른 집까지의 최단 거리, 확인 여부, 각 도로의 정보를 저장할 각 배열 초기화
	static int[] minDist;
	static boolean[] checked;
	static List<Road>[] roads;
	
	// Road 클래스 정의
	public static class Road {
		
		// 도로의 목적지, 길이를 저장할 각 변수 초기화
		int destination;
		int length;
		
		// 매개변수를 입력 받는 생성자 정의
		public Road(int destination, int length) {
			this.destination = destination;
			this.length = length;
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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 집의 수, 도로의 수, 최대 이동 거리, 성현이의 집을 각 변수에 할당
		int houseNum = Integer.parseInt(st.nextToken());
		int roadNum = Integer.parseInt(st.nextToken());
		int distLimit = Integer.parseInt(st.nextToken());
		int startHouse = Integer.parseInt(st.nextToken());
		
		// 성현이의 집에서 다른 집까지의 최단 거리, 확인 여부, 각 도로의 정보를 저장할 각 배열 초기화
		minDist = new int[houseNum];
		checked = new boolean[houseNum];
		roads = new ArrayList[houseNum];
		
		// for 반복문을 사용해 각 도로의 정보를 저장할 List 객체 초기화
		for (int idx = 0; idx < roads.length; idx++)
			roads[idx] = new ArrayList<>();
		
		// for 반복문을 사용해 각 도로의 정보를 순회
		for (int road = 0; road < roadNum; road++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 해당 도로가 연결하는 각 집과 도로의 길이를 각 변수에 할당
			int origin = Integer.parseInt(st.nextToken());
			int destination = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());
			
			// add() 메서드를 사용해 해당 도로의 정보를 배열 roads에 저장
			roads[origin].add(new Road(destination, length));
			roads[destination].add(new Road(origin, length));
		}
		
		// fill() 메서드를 사용해 집에서 성현이의 집에서 다른 집까지의 최단 거리를 갱신
		Arrays.fill(minDist, INF);
		
		// distCalculator() 메서드를 호출해 성현이의 집에서부터 다른 집까지의 최단 거리를 갱신
		distCalculator(startHouse);
		
		// periodCalculator() 메서드를 호출해 이웃집 모두에 떡을 돌리기 위한 최소 일수를 변수 minPeriod에 할당
		int minPeriod = periodCalculator(houseNum, distLimit);
		
		// valueOf() 및 write() 메서드를 사용해 이웃집 모두에 떡을 돌리기 위한 최소 일수를 출력
		out.write(String.valueOf(minPeriod));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------

	// distCalculator() 메서드 정의
	public static void distCalculator(int startHouse) {
		
		// 다음에 확인할 집을 저장할 PriorityQueue 객체 checkList 초기화
		PriorityQueue<int[]> checkList = new PriorityQueue<>((h1, h2) -> {
			return h1[1] - h2[1];
		});
		
		// offer() 메서드를 사용해 성현이의 집을 checkList에 추가
		checkList.offer(new int[] {startHouse, 0});
		
		// 성현이의 집의 최단 거리를 갱신
		minDist[startHouse] = 0;
		
		// while 반복문을 사용해 checkList가 빌 때까지 순회
		while (!checkList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 확인 중인 집을 배열 curHouse에 할당
			int[] curHouse = checkList.poll();
			
			// 해당 집을 이미 확인한 경우 다음 집을 순회
			if (checked[curHouse[0]])
				continue;
			
			// 해당 집을 확인 처리
			checked[curHouse[0]] = true;
			
			// for 반복문을 사용해 해당 집과 도로로 연결된 다른 집을 순회
			for (int idx = 0; idx < roads[curHouse[0]].size(); idx++) {
				
				// 연결된 다른 집의 번호와 그 거리를 각 변수에 할당
				int nextHouse = roads[curHouse[0]].get(idx).destination;
				int distance = roads[curHouse[0]].get(idx).length;
				
				// 저장된 다음 집까지의 최단 거리가 현재 확인 중인 집을 거쳐가는 경우보다 긴 경우
				if (minDist[nextHouse] > minDist[curHouse[0]] + distance) {
				
					// 다음 집까지의 최단 거리 갱신
					minDist[nextHouse] = minDist[curHouse[0]] + distance;
					
					// offer() 메서드를 사용해 다음 집의 정보를 checkList에 추가
					checkList.offer(new int[] {nextHouse, minDist[nextHouse]});
				}
			}
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// periodCalculator() 메서드 정의
	public static int periodCalculator(int houseNum, int distLimit) {
		
		// sort() 메서드를 사용해 각 집까지의 최단 거리를 오름차순으로 정렬
		Arrays.sort(minDist);
		
		// 도달할 수 없는 집이 있거나, 하루에 왕복할 수 없는 집이 있는 경우 -1 반환
		if (minDist[houseNum - 1] == INF || minDist[houseNum - 1] * 2 > distLimit)
			return -1;
		
		// 이웃집 모두에 떡을 돌리기 위한 최소 일수, 이동한 거리를 저장할 각 변수 초기화
		int minPeriod = 1;
		int movingDist = 0;
		
		// for 반복문을 사용해 각 집까지의 최단 거리를 순회
		for (int idx = 1; idx < minDist.length; idx++) {
			
			// 해당 집까지의 왕복 거리를 변수 curDist에 할당
			int curDist = minDist[idx] * 2;
			
			// 해당 날짜에 연속해서 이동할 수 없는 경우 다음 날 이동한 것으로 처리
			if (movingDist + curDist > distLimit) {
				minPeriod++;
				movingDist = curDist;
				
			// 해당 날짜에 연속해서 이동할 수 있는 경우 해당 날짜에 이동한 것으로 처리
			} else {
				movingDist += curDist;
			}
		}
		
		// 이웃집 모두에 떡을 돌리기 위한 최소 일수를 반환
		return minPeriod;
	}
}