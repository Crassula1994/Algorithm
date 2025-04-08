package gold3.num16947;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 순환선을 찾았는지 여부를 저장할 변수 isLoopFound 초기화
	static boolean isLoopFound = false;
	
	// 각 역의 순환선 확인 여부, 순환선 여부를 확인한 직전 역, 순환선으로부터의 거리, 역 사이를 연결하는 구간을 저장할 각 배열 초기화
	static boolean[] checked;
	static int[] prevStations;
	static Integer[] distances;
	static List<Integer>[] sections;
	
	// 순환선으로부터의 거리를 확인할 역을 저장할 Queue 객체 stationList 초기화
	static Queue<Integer> stationList = new LinkedList<>();
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 역의 개수를 변수 stationNum에 할당
		int stationNum = Integer.parseInt(in.readLine());
		
		// 각 역의 순환선 확인 여부, 순환선 여부를 확인한 직전 역, 순환선으로부터의 거리, 역 사이를 연결하는 구간을 저장할 각 배열 초기화
		checked = new boolean[stationNum + 1];
		prevStations = new int[stationNum + 1];
		distances = new Integer[stationNum + 1];
		sections = new ArrayList[stationNum + 1];
		
		// for 반복문을 사용해 각 역 사이를 연결하는 구간을 저장할 각 List 객체 초기화
		for (int idx = 0; idx < sections.length; idx++)
			sections[idx] = new ArrayList<>();
		
		// while 반복문을 사용해 각 역 사이를 연결하는 구간을 순회
		while (stationNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 해당 구간으로 연결된 각 역을 각 변수에 할당
			int startStation = Integer.parseInt(st.nextToken());
			int endStation = Integer.parseInt(st.nextToken());
			
			// add() 메서드를 사용해 각 역 사이를 연결하는 구간 정보를 배열 sections에 저장
			sections[startStation].add(endStation);
			sections[endStation].add(startStation);
		}
		
		// loopLineFinder() 메서드를 호출해 순환선에 해당하는 역을 stationList에 추가
		loopLineFinder(1);
		
		// distCalculator() 메서드를 호출해 각 역과 순환선 사이의 거리를 갱신
		distCalculator();
		
		// for 반복문을 사용해 각 역과 순환선 사이의 거리를 출력
		for (int idx = 1; idx < distances.length; idx++)
			out.write(distances[idx] + " ");

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// loopLineFinder() 메서드 정의
	public static void loopLineFinder(int curStation) {
		
		// 현재 역의 순환선 여부를 확인 처리
		checked[curStation] = true;
		
		// for 반복문을 사용해 현재 역과 연결된 각 역을 순회
		for (int nextStation : sections[curStation]) {
			
			// 이미 순환선을 찾은 경우 메서드 종료
			if (isLoopFound)
				return;
			
			// 해당 역이 순환선 여부를 확인하지 않은 경우
			if (!checked[nextStation]) {
				
				// 순환선 여부를 확인한 직전 역을 갱신
				prevStations[nextStation] = curStation;
				
				// loopLineFinder() 메서드를 재귀 호출 후 다음 역을 순회
				loopLineFinder(nextStation);
				continue;
			}
			
			// 해당 역이 순환선 여부를 확인하였고 직전 역이 아닌 경우
			if (prevStations[curStation] != nextStation) {
				
				// 순환선을 찾았는지 여부를 갱신
				isLoopFound = true;
				
				// offer() 메서드를 사용해 순환선의 시작점을 stationList에 추가 및 순환선으로부터의 거리를 갱신
				stationList.offer(nextStation);
				distances[nextStation] = 0;
				
				// while 반복문을 사용해 순환선의 끝점부터 시작점까지 순회
				while (curStation != nextStation) {
					
					// offer() 메서드를 사용해 해당 역을 stationList에 추가 및 순환선으로부터의 거리를 갱신
					stationList.offer(curStation);
					distances[curStation] = 0;
					
					// 현재 순환선의 역을 이전 순환선의 역으로 갱신
					curStation = prevStations[curStation];
				}
				
				// 메서드 종료
				return;
			}
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// distCalculator() 메서드 정의
	public static void distCalculator() {
		
		// while 반복문을 사용해 stationList가 빌 때까지 순회
		while (!stationList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 역을 변수 curStation에 할당
			int curStation = stationList.poll();
			
			// for 반복문을 사용해 현재 역과 연결된 각 역을 순회
			for (int nextStation : sections[curStation]) {
				
				// 해당 역을 이미 확인한 경우 다음 역을 순회
				if (distances[nextStation] != null)
					continue;
				
				// offer() 메서드를 사용해 해당 역을 stationList에 추가 및 순환선으로부터의 거리를 갱신
				stationList.offer(nextStation);
				distances[nextStation] = distances[curStation] + 1;
			}
		}
	}
}