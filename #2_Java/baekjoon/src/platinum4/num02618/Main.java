package platinum4.num02618;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 도로의 개수와 사건의 개수를 저장할 각 변수 초기화
	static int roadNum;
	static int caseNum;
	
	// 각 사건의 위치, 각 사건을 해결 후 두 경찰차의 위치에 따라 이동할 최소 거리를 저장할 각 2차원 배열 초기화
	static int[][] cases;
	static int[][] minDistances;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 도로의 개수와 사건의 개수를 각 변수에 할당
		roadNum = Integer.parseInt(in.readLine());
		caseNum = Integer.parseInt(in.readLine());
		
		// 각 사건의 위치, 각 사건을 해결 후 두 경찰차의 위치에 따라 이동할 최소 거리를 저장할 각 2차원 배열 초기화
		cases = new int[caseNum + 1][2];
		minDistances = new int[caseNum + 1][caseNum + 1];
		
		// for 반복을 사용해 각 사건을 순회
		for (int idx = 1; idx < cases.length; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 사건의 위치를 2차원 배열 cases에 저장
			cases[idx][0] = Integer.parseInt(st.nextToken());
			cases[idx][1] = Integer.parseInt(st.nextToken());
		}
		
		// policeDispatcher() 메서드를 호출해 각 사건을 해결 후 두 경찰차의 위치에 따라 이동할 최소 거리를 변수 minDist에 할당
		int minDist = policeDispatcher(0, 0, 1);
		
		// write() 메서드를 사용해 두 경찰차가 이동한 총 거리를 출력
		out.write(minDist + "\n");
		
		// 두 경찰차의 위치를 저장할 각 변수 초기화
		int car1 = 0;
		int car2 = 0;
		
		// for 반복문을 사용해 각 사건을 순회
		for (int idx = 1; idx < cases.length; idx++) {
			
			// distCalculator() 메서드를 호출해 1번 경찰차를 이동시킨 경우 이동해야 할 거리를 변수 distance에 할당
			int distance = distCalculator(1, car1, idx);
			
			// 1번 경찰차가 이동한 경우 1번 경찰차의 위치를 갱신 후 경찰차 번호 1을 출력
			if (distance + minDistances[idx][car2] == minDistances[car1][car2]) {
				car1 = idx;
				out.write(String.valueOf(1));
			
			// 2번 경찰차가 이동한 경우 2번 경찰차의 위치를 갱신 후 경찰차 번호 2를 출력
			} else {
				car2 = idx;
				out.write(String.valueOf(2));
			}
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// policeDispatcher() 메서드 정의
	public static int policeDispatcher(int car1, int car2, int curCase) {
		
		// 마지막 사건을 해결한 경우 이동한 거리를 반환
		if (curCase > caseNum)
			return 0;
		
		// 해당 경찰차 배치를 이미 확인한 경우 최소 거리를 반환
		if (minDistances[car1][car2] != 0)
			return minDistances[car1][car2];
		
		/* 경찰차 1과 경찰차 2를 각각 출동시킨 경우를 상정해 policeDispatcher() 메서드를 호출하고
		distCalculator() 메서드를 호출해 다음 사건이 발생한 위치까지 이동한 거리를 더해 각 변수에 할당 */
		int distance1 = policeDispatcher(curCase, car2, curCase + 1) + distCalculator(1, car1, curCase);
		int distance2 = policeDispatcher(car1, curCase, curCase + 1) + distCalculator(2, car2, curCase);
		
		// min() 메서드를 사용해 최소 거리를 갱신
		minDistances[car1][car2] = Math.min(distance1, distance2);
		
		// 두 경찰차의 위치에 따라 이동할 최소 거리를 반환
		return minDistances[car1][car2];
	}
	
	// ----------------------------------------------------------------------------------------------------

	// distCalculator() 메서드 정의
	public static int distCalculator(int carNum, int startLoc, int endLoc) {
		
		// 경찰차의 출발 위치와 도착 위치의 각 좌표를 각 변수에 할당
		int startX = (startLoc == 0) ? (carNum == 1) ? 1 : roadNum : cases[startLoc][0];
		int startY = (startLoc == 0) ? (carNum == 1) ? 1 : roadNum : cases[startLoc][1];
		int endX = cases[endLoc][0];
		int endY = cases[endLoc][1];
		
		// abs() 메서드를 사용해 경찰차의 이동 거리를 계산하고 변수 distance에 할당
		int distance = Math.abs(startX - endX) + Math.abs(startY - endY);
		
		// 경찰차의 이동 거리를 반환
		return distance;
	}
}