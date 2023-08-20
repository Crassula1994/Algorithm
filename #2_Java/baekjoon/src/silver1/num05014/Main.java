package silver1.num05014;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 건물의 층수, 시작 층수, 도착 층수, 한번에 위로 이동하는 층수, 아래로 이동하는 층수를 저장할 각 변수 초기화
	static int floorNum;
	static int startFloor;
	static int endFloor;
	static int upInterval;
	static int downInterval;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		/* nextToken() 및 parseInt() 메서드를 사용해 입력 받은 건물의 층수, 시작 층수, 도착 층수,
		한 번에 위로 이동하는 층수, 한 번에 아래로 이동하는 층수를 각 변수에 할당 */
		floorNum = Integer.parseInt(st.nextToken());
		startFloor = Integer.parseInt(st.nextToken());
		endFloor = Integer.parseInt(st.nextToken());
		upInterval = Integer.parseInt(st.nextToken());
		downInterval = Integer.parseInt(st.nextToken());
		
		// routeFinder() 메서드를 호출해 강호가 눌러야 하는 버튼 개수의 최솟값을 변수 minCnt에 할당
		int minCnt = routeFinder();
		
		// 엘리베이터로 이동할 수 없는 경우 'use the stairs'를 출력
		if (minCnt == -1) {
			out.write("use the stairs");
			
		// 엘리베이터로 이동할 수 있는 경우 강호가 눌러야 하는 버튼 개수의 최솟값을 출력
		} else {
			out.write(String.valueOf(minCnt));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// routeFinder() 메서드 정의
	public static int routeFinder() {
		
		// 해당 층수까지의 버튼을 누른 횟수를 저장할 배열 visited 초기화
		Integer[] counter = new Integer[floorNum + 1];
		
		// 다음에 이동할 위치를 저장할 Queue 객체 floorList 초기화
		Queue<Integer> floorList = new LinkedList<>();
		
		// offer() 메서드를 사용해 시작 위치를 floorList에 추가 및 방문 처리
		floorList.offer(startFloor);
		counter[startFloor] = 0;
		
		// while 반복문을 사용해 floorList가 빌 때까지 순회
		while (!floorList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 방문 중인 층수를 변수 currentFloor에 할당
			int currentFloor = floorList.poll();
			
			// 해당 층수가 스타트링크가 있는 곳인 경우 눌러야 하는 버튼 개수를 반환
			if (currentFloor == endFloor)
				return counter[endFloor];
			
			// 다음에 방문할 수 있는 각 층수를 각 변수에 할당
			int nextUpFloor = currentFloor + upInterval;
			int nextDownFloor = currentFloor - downInterval;
			
			// 위 층수가 범위 내이고, 이미 방문한 위치가 아닌 경우 floorList에 추가 및 방문 처리
			if (nextUpFloor <= floorNum && counter[nextUpFloor] == null) {
				floorList.offer(nextUpFloor);
				counter[nextUpFloor] = counter[currentFloor] + 1;
			}
			
			// 아래 층수가 범위 내이고, 이미 방문한 위치가 아닌 경우 floorList에 추가 및 방문 처리
			if (nextDownFloor > 0 && counter[nextDownFloor] == null) {
				floorList.offer(nextDownFloor);
				counter[nextDownFloor] = counter[currentFloor] + 1;
			}
		}
		
		// 엘리베이터로 이동할 수 없는 경우 -1 반환
		return -1;
	}
}