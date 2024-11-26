package gold3.num17270;

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
	
	// 각 장소 사이의 최소 시간을 초기화할 상수 INF 초기화
	static final int INF = 987654321;
	
	// 약속 장소 후보의 수를 저장할 변수 placeNum 초기화
	static int placeNum;
	
	// 각 장소의 연결 정보를 저장할 배열 paths 초기화
	static List<int[]>[] paths;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 약속 장소 후보의 수 및 총 길의 수를 각 변수에 할당
		placeNum = Integer.parseInt(st.nextToken());
		int pathNum = Integer.parseInt(st.nextToken());
		
		// 지헌이를 위한 이상적인 약속 장소의 위치, 그 때 두 사람의 최단 시간의 합, 지헌이가 걸리는 시간을 저장할 각 변수 초기화
		int targetPlace = -1;
		int minTimeSum = INF;
		int timeJH = INF;
		
		// 지헌이와 성하로부터 각 장소까지 걸리는 최소 시간, 각 장소의 연결 정보를 저장할 각 배열 초기화
		int[] minTimeJH = new int[placeNum + 1];
		int[] minTimeSH = new int[placeNum + 1];
		paths = new ArrayList[placeNum + 1];
		
		// for 반복문을 사용해 각 장소의 연결 정보를 저장할 각 List 객체 초기화
		for (int idx = 0; idx < paths.length; idx++)
			paths[idx] = new ArrayList<>();
		
		// while 반복문을 사용해 각 길의 정보를 순회
		while (pathNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 길의 정보를 각 변수에 할당
			int startPlace = Integer.parseInt(st.nextToken());
			int endPlace = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			
			// add() 메서드를 사용해 입력 받은 길의 정보를 배열 paths에 저장
			paths[startPlace].add(new int[] {endPlace, time});
			paths[endPlace].add(new int[] {startPlace, time});
		}
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 지헌이와 성하의 위치를 각 변수에 할당
		int placeJH = Integer.parseInt(st.nextToken());
		int placeSH = Integer.parseInt(st.nextToken());
		
		// minTimeCalculator() 메서드를 호출해 지헌이와 성하로부터 각 장소까지 걸리는 최소 시간을 갱신
		minTimeCalculator(placeJH, minTimeJH);
		minTimeCalculator(placeSH, minTimeSH);
		
		// for 반복문을 사용해 각 약속 장소를 순회
		for (int idx = 1; idx <= placeNum; idx++) {
			
			// 해당 장소가 지헌이나 성하가 위치한 장소인 경우 다음 장소를 순회
			if (idx == placeJH || idx == placeSH)
				continue;
			
			// min() 메서드를 사용해 두 사람의 최단 시간의 합을 갱신
			minTimeSum = Math.min(minTimeJH[idx] + minTimeSH[idx], minTimeSum);
		}
		
		// for 반복문을 사용해 각 약속 장소를 순회
		for (int idx = 1; idx <= placeNum; idx++) {
			
			// 해당 장소가 지헌이나 성하가 위치한 장소인 경우 다음 장소를 순회
			if (idx == placeJH || idx == placeSH)
				continue;
			
			// 두 사람의 최단 시간의 합이 저장된 최단 시간의 합보다 큰 경우
			if (minTimeJH[idx] + minTimeSH[idx] > minTimeSum)
				continue;
			
			// 지헌이가 성하보다 늦게 도착하는 장소인 경우 다음 장소를 순회
			if (minTimeJH[idx] > minTimeSH[idx])
				continue;
				
			// 지헌이가 걸리는 시간이 더 짧은 경우 지헌이를 위한 이상적인 약속 장소의 위치, 그 때 지헌이가 걸리는 시간을 갱신
			if (minTimeJH[idx] < timeJH) {
				targetPlace = idx;
				timeJH = minTimeJH[idx];
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 지헌이를 위한 이상적인 약속 장소의 위치를 출력
		out.write(String.valueOf(targetPlace));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// minTimeCalculator() 메서드 정의
	public static void minTimeCalculator(int startPlace, int[] minTime) {
		
		// 각 장소의 확인 여부를 저장할 배열 checked 초기화
		boolean[] checked = new boolean[placeNum + 1];
		
		// 다음에 확인할 위치를 저장할 PriorityQueue 객체 placeChecker 초기화
		PriorityQueue<int[]> placeChecker = new PriorityQueue<>((p1, p2) -> {
			return p1[1] - p2[1];
		});
		
		// fill() 메서드를 사용해 출발 장소로부터 각 장소까지 걸리는 최소 시간을 초기화
		Arrays.fill(minTime, INF);
		
		// 출발 장소의 최소 시간을 갱신
		minTime[startPlace] = 0;
		
		// offer() 메서드를 사용해 출발 장소를 placeChecker에 추가
		placeChecker.offer(new int[] {startPlace, 0});
		
		// while 반복문을 사용해 placeChecker가 빌 때까지 순회
		while (!placeChecker.isEmpty()) {
			
			// poll() 메서드를 사용해 확인할 위치를 배열 curPath에 할당
			int[] curPlace = placeChecker.poll();
			
			// 해당 장소를 이미 확인한 경우 다음 장소를 순회
			if (checked[curPlace[0]])
				continue;
			
			// 현재 장소를 확인한 것으로 처리
			checked[curPlace[0]] = true;
			
			// for 반복문을 사용해 현재 장소와 연결된 각 장소를 순회
			for (int[] nextPlace : paths[curPlace[0]]) {
				
				// 저장된 해당 장소까지의 최소 시간이 현재 장소를 거쳐가는 것보다 짧은 경우 다음 장소를 순회
				if (minTime[curPlace[0]] + nextPlace[1] >= minTime[nextPlace[0]])
					continue;
				
				// 해당 장소까지의 최소 시간을 갱신
				minTime[nextPlace[0]] = minTime[curPlace[0]] + nextPlace[1];
				
				// offer() 메서드를 사용해 해당 장소를 placeChecker에 추가
				placeChecker.offer(new int[] {nextPlace[0], minTime[nextPlace[0]]});
			}
		}
	}
}