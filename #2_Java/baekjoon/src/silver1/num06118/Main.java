package silver1.num06118;

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
	
	// main() 메서드 정의
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 헛간의 개수와 길의 개수를 각 변수에 할당
		int barnNum = Integer.parseInt(st.nextToken());
		int roadNum = Integer.parseInt(st.nextToken());
		
		// 숨어야 하는 헛간 번호, 1번 헛간으로부터 가장 멀리 떨어진 거리, 그 거리를 갖는 헛간의 개수를 저장할 각 변수 초기화
		int targetBarn = 0;
		int maxDistance = 0;
		int count = 0;
		
		// 1번 헛간으로부터의 거리, 헛간에 연결된 길을 저장할 각 배열 초기화
		Integer[] distances = new Integer[barnNum + 1];
		List<Integer>[] roads = new ArrayList[barnNum + 1];
		
		// for 반복문을 사용해 헛간에 연결된 길을 저장할 각 List 객체 초기화
		for (int idx = 0; idx < roads.length; idx++)
			roads[idx] = new ArrayList<>();
		
		// for 반복문을 사용해 각 길의 정보를 순회
		for (int road = 0; road < roadNum; road++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 길의 양 끝을 각 변수에 할당
			int startBarn = Integer.parseInt(st.nextToken());
			int endBarn = Integer.parseInt(st.nextToken());
			
			// add() 메서드를 사용해 해당 길의 정보를 배열 roads에 추가
			roads[startBarn].add(endBarn);
			roads[endBarn].add(startBarn);
		}
		
		// 다음에 확인할 헛간을 저장할 Queue 객체 checkList 초기화
		Queue<Integer> checkList = new LinkedList<>();
		
		// offer() 메서드를 사용해 1번 헛간을 checkList에 추가하고, 거리를 갱신
		checkList.offer(1);
		distances[1] = 0;
		
		// while 반복문을 사용해 checkList가 빌 때까지 순회
		while (!checkList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 확인 중인 헛간의 번호를 변수 curBarn에 할당
			int curBarn = checkList.poll();
			
			// max() 메서드를 사용해 1번 헛간으로부터 가장 멀리 떨어진 거리를 갱신
			maxDistance = Math.max(distances[curBarn], maxDistance);
			
			// for 반복문을 사용해 현재 헛간과 연결된 다른 헛간을 순회
			for (int nextBarn : roads[curBarn]) {
				
				// 해당 헛간을 이미 확인한 경우 다음 헛간을 순회
				if (distances[nextBarn] != null)
					continue;
				
				// offer() 메서드를 사용해 해당 헛간을 checkList에 추가하고, 거리를 갱신
				checkList.offer(nextBarn);
				distances[nextBarn] = distances[curBarn] + 1;
			}
		}
		
		// for 반복문을 사용해 각 헛간의 거리를 순회
		for (int idx = 2; idx < distances.length; idx++) {
			
			// 1번 헛간으로부터 가장 멀리 떨어진 거리에 해당하지 않는 경우 다음 헛간을 순회
			if (distances[idx] == null || distances[idx] < maxDistance)
				continue;
			
			// 숨어야 하는 헛간 번호를 찾은 경우 숨어야 하는 헛간 번호를 갱신
			if (targetBarn == 0)
				targetBarn = idx;
			
			// 1번 헛간으로부터 가장 멀리 떨어진 거리를 갖는 헛간의 개수를 갱신
			count++;
		}
		
		// write() 메서드를 사용해 숨어야 하는 헛간 번호, 해당 헛간까지의 거리, 그와 같은 거리를 갖는 헛간의 개수를 출력
		out.write(targetBarn + " " + maxDistance + " " + count);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}