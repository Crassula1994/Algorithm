package gold2.num09370;

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
	
	// 교차로의 개수를 저장할 변수 junctionNum 초기화
	static int junctionNum;
	
	// 연결된 도로의 정보를 저장할 배열 roads 초기화
	static List<Road>[] roads;
	
	// Road 클래스 정의
	public static class Road {
		
		// 도로의 목적지, 그 길이를 저장할 각 변수 초기화
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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 교차로, 도로, 목적지 후보의 개수를 출력
			junctionNum = Integer.parseInt(st.nextToken());
			int roadNum = Integer.parseInt(st.nextToken());
			int candidateNum = Integer.parseInt(st.nextToken());
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 출발지, 지나간 교차로의 번호를 각 변수에 할당
			int startJunc = Integer.parseInt(st.nextToken());
			int midJunc1 = Integer.parseInt(st.nextToken());
			int midJunc2 = Integer.parseInt(st.nextToken());
			
			// 연결된 도로의 정보를 저장할 배열 roads 초기화
			roads = new ArrayList[junctionNum + 1];
			
			// for 반복문을 사용해 연결된 도로의 정보를 저장할 List 객체 초기화
			for (int idx = 0; idx < roads.length; idx++)
				roads[idx] = new ArrayList<>();
			
			// for 반복문을 사용해 입력 받은 각 도로의 정보를 순회
			for (int road = 0; road < roadNum; road++) {
				
				// StringTokenizer 객체를 불러와 변수 st에 재할당
				st = new StringTokenizer(in.readLine());
				
				// nextToken() 및 parseInt() 메서드를 사용해 해당 도로의 출발지, 목적지, 그 길이를 각 변수에 할당
				int origin = Integer.parseInt(st.nextToken());
				int destination = Integer.parseInt(st.nextToken());
				int length = Integer.parseInt(st.nextToken());
				
				// 서커스 예술가가 지나간 도로인 경우 도로의 길이를 홀수로 저장
				if ((origin == midJunc1 && destination == midJunc2) || (origin == midJunc2 && destination == midJunc1)) {
					roads[origin].add(new Road(destination, length * 2 - 1));
					roads[destination].add(new Road(origin, length * 2 - 1));
					
				// 서커스 예술가가 지나가지 않은 도로인 경우 도로의 길이를 짝수로 저장
				} else {
					roads[origin].add(new Road(destination, length * 2));
					roads[destination].add(new Road(origin, length * 2));
				}
			}
			
			// 가능한 목적지 후보를 저장할 PriorityQueue 객체 candidateSorter 초기화
			PriorityQueue<Integer> candidateSorter = new PriorityQueue<>();
			
			// roadFinder() 메서드를 호출해 출발지로부터 각 교차로까지의 최단 거리를 저장한 배열을 minDist에 할당
			int[] minDist = roadFinder(startJunc);
			
			// for 반복문을 사용해 입력 받은 각 목적지 후보를 순회
			for (int t = 0; t < candidateNum; t++) {
				
				// readLine() 및 parseInt() 메서드를 사용해 입력 받은 목적지 후보를 변수 endJunc에 할당
				int endJunc = Integer.parseInt(in.readLine());
				
				// 출발지에서 목적지 후보까지 도달하지 못하는 경우 다음 목적지 후보를 순회
				if (minDist[endJunc] == Integer.MAX_VALUE)
					continue;
				
				// 출발지에서 목적지 후보까지 서커스 예술가가 지나간 도로를 지나지 않는 경우 다음 목적지 후보를 순회
				if (minDist[endJunc] % 2 == 0)
					continue;
				
				// offer() 메서드를 사용해 목적지 후보를 candidateSorter에 추가
				candidateSorter.offer(endJunc);
			}
			
			// while 반복문을 사용해 가능한 목적지 후보를 오름차순으로 출력
			while (!candidateSorter.isEmpty())
				out.write(candidateSorter.poll() + " ");
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// roadFinder() 메서드 정의
	public static int[] roadFinder(int startJunc) {
		
		// 다음에 확인할 교차로를 저장할 PriorityQueue 객체 checkList 초기화
		PriorityQueue<int[]> checkList = new PriorityQueue<>((r1, r2) -> {
			return r1[1] - r2[1];
		});
		
		// 출발지로부터의 최단 거리 및 확인 여부를 저장할 각 배열 초기화
		int[] minDist = new int[junctionNum + 1];
		boolean[] checked = new boolean[junctionNum + 1];
		
		// fill() 메서드를 사용해 출발지로부터의 최단 거리를 초기화
		Arrays.fill(minDist, Integer.MAX_VALUE);
		
		// offer() 메서드를 사용해 출발지를 checkList에 추가 후 출발지의 최단 거리를 갱신
		checkList.offer(new int[] {startJunc, 0});
		minDist[startJunc] = 0;
		
		// while 반복문을 사용해 checkList가 빌 때까지 순회
		while (!checkList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 확인 중인 교차로를 배열 curJunc에 할당
			int[] curJunc = checkList.poll();
			
			// 해당 교차로를 확인한 적이 있는 경우 다음 교차로를 순회
			if (checked[curJunc[0]])
				continue;
			
			// 현재 확인 중인 교차로를 확인 처리
			checked[curJunc[0]] = true;
			
			// for 반복문을 사용해 현재 확인 중인 교차로와 연결된 교차로를 순회
			for (int idx = 0; idx < roads[curJunc[0]].size(); idx++) {
				
				// get() 메서드를 사용해 연결된 교차로와 그 길이를 각 변수에 할당
				int nextJunc = roads[curJunc[0]].get(idx).destination;
				int length = roads[curJunc[0]].get(idx).length;
				
				// 해당 교차로의 최단 거리가 저장된 최단 거리보다 짧은 경우 최단 거리 갱신 후 checkList에 추가
				if (minDist[nextJunc] > minDist[curJunc[0]] + length) {
					minDist[nextJunc] = minDist[curJunc[0]] + length;
					checkList.offer(new int[] {nextJunc, minDist[nextJunc]});
				}
			}
		}
		
		// 출발지로부터 각 교차로까지의 최단 거리를 저장한 배열 반환
		return minDist;
	}
}