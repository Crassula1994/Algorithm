package gold3.num01238;

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
	
	// 학생의 수, 도로의 수, 목적지 마을을 저장할 각 변수 초기화
	static int studentNum;
	static int roadNum;
	static int targetTown;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 학생의 수, 도로의 수, 목적지 마을을 각 변수에 할당
		studentNum = Integer.parseInt(st.nextToken());
		roadNum = Integer.parseInt(st.nextToken());
		targetTown = Integer.parseInt(st.nextToken());
		
		// 연결된 도로의 정보를 저장할 각 배열 초기화
		List<int[]>[] toRoads = new ArrayList[studentNum + 1];
		List<int[]>[] fromRoads = new ArrayList[studentNum + 1];	
		
		// for 반복문을 사용해 연결된 도로의 정보를 저장할 각 배열의 원소를 초기화
		for (int idx = 0; idx <= studentNum; idx++) {
			toRoads[idx] = new ArrayList<>();
			fromRoads[idx] = new ArrayList<>();			
		}
		
		// for 반복문을 사용해 각 도로의 정보를 순회
		for (int road = 0; road < roadNum; road++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 도로의 시작점, 끝점, 소요 시간을 각 변수에 할당
			int fromTown = Integer.parseInt(st.nextToken());
			int toTown = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			
			// add() 메서드를 사용해 연결된 도로의 정보를 각 배열에 추가
			toRoads[toTown].add(new int[] {fromTown, time});
			fromRoads[fromTown].add(new int[] {toTown, time});
		}
		
		// timeCalculator() 메서드를 호출해 최소 소요 시간의 배열을 각 배열에 할당
		int[] toMinTime = timeCalculator(toRoads);
		int[] fromMinTime = timeCalculator(fromRoads);
		
		// 가장 오래 걸리는 학생의 소요 시간을 저장할 변수 maxTime 초기화
		int maxTime = 0;
		
		// for 반복문을 사용해 가장 오래 걸리는 학생의 소요 시간을 갱신
		for (int student = 1; student <= studentNum; student++)
			maxTime = Math.max(toMinTime[student] + fromMinTime[student], maxTime);
		
		// valueOf() 및 write() 메서드를 사용해 가장 오래 걸리는 학생의 소요 시간을 출력
		out.write(String.valueOf(maxTime));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// timeCalculator() 메서드 정의
	public static int[] timeCalculator(List<int[]>[] roads) {
		
		// 다음에 이동할 마을을 저장할 PriorityQueue 객체 moveList 초기화
		PriorityQueue<int[]> moveList = new PriorityQueue<>((t1, t2) -> {
			return t1[1] - t2[1];
		});
		
		// 목적지 마을과 다른 마을 사이의 최소 소요 시간, 해당 마을의 이동 여부를 저장할 각 배열 초기화
		int[] minTime = new int[studentNum + 1];
		boolean[] moved = new boolean[studentNum + 1];
		
		// fill() 메서드를 사용해 목적지 마을과 다른 마을 사이의 최소 소요 시간의 값을 초기화
		Arrays.fill(minTime, Integer.MAX_VALUE);
		
		// 목적지 마을의 최소 소요 시간을 설정
		minTime[targetTown] = 0;
		
		// offer() 메서드를 사용해 목적지 마을을 moveList에 추가
		moveList.offer(new int[] {targetTown, 0});
		
		// while 반복문을 사용해 moveList가 빌 때까지 순회
		while (!moveList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 이동 중인 마을을 변수 currentTown에 할당
			int[] currentTown = moveList.poll();
			
			// 해당 마을을 이동한 적이 없는 경우
			if (!moved[currentTown[0]]) {
				
				// 현재 이동 중인 마을을 이동 처리
				moved[currentTown[0]] = true;
				
				// for 반복문을 사용해 해당 마을과 연결된 다른 마을을 순회
				for (int idx = 0; idx < roads[currentTown[0]].size(); idx++) {
					
					// get() 메서드를 사용해 연결된 마을 및 소요 시간을 각 변수에 할당
					int town = roads[currentTown[0]].get(idx)[0];
					int time = roads[currentTown[0]].get(idx)[1];
					
					// 해당 마을까지의 최소 소요 시간이 저장된 최소 소요 시간보다 적은 경우 최소 소요 시간 갱신 후 moveList에 추가
					if (minTime[town] > minTime[currentTown[0]] + time) {
						minTime[town] = minTime[currentTown[0]] + time;
						moveList.offer(new int[] {town, minTime[town]});
					}
				}
			}
		}
		
		// 목적지 마을과 다른 마을 사이의 최소 소요 시간을 저장한 배열 반환
		return minTime;
	}
}