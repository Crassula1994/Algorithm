package silver2.num14248;

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
	
	// 돌다리의 돌 개수를 저장할 변수 stoneNum 초기화
	static int stoneNum;
	
	// 각 돌에서 점프할 수 있는 거리를 저장할 배열 stoneBridge 초기화
	static int[] stoneBridge;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 돌다리의 돌 개수를 변수 stoneNum에 할당
		stoneNum = Integer.parseInt(in.readLine());
		
		// 각 돌에서 점프할 수 있는 거리를 저장할 배열 stoneBridge 초기화
		stoneBridge = new int[stoneNum];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 각 돌에서 점프할 수 있는 거리를 배열 stoneBridge에 저장
		for (int idx = 0; idx < stoneBridge.length; idx++)
			stoneBridge[idx] = Integer.parseInt(st.nextToken());
		
		// readLine(), parseInt(), stoneCounter(), valueOf(), write() 메서드를 사용해 영우가 방문 가능한 돌들의 개수를 출력
		out.write(String.valueOf(stoneCounter(Integer.parseInt(in.readLine()) - 1)));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// stoneCounter() 메서드 정의
	public static int stoneCounter(int startStone) {
		
		// 영우가 방문 가능한 돌들의 개수를 저장할 변수 count 초기화
		int count = 1;
		
		// 영우가 각 돌을 방문했는지 여부를 저장할 배열 visited 초기화
		boolean[] visited = new boolean[stoneNum];
		
		// 다음에 방문할 돌을 저장할 Queue 객체 stoneList 초기화
		Queue<Integer> stoneList = new LinkedList<>();
		
		// offer() 메서드를 사용해 영우의 출발점을 stoneList에 추가 및 방문 여부를 갱신
		stoneList.offer(startStone);
		visited[startStone] = true;
		
		// while 반복문을 사용해 stoneList가 빌 때까지 순회
		while (!stoneList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 돌을 변수 curStone에 할당
			int curStone = stoneList.poll();
			
			// 현재 돌에서 점프할 수 있는 각 돌의 위치를 각 변수에 할당
			int leftStone = curStone - stoneBridge[curStone];
			int rightStone = curStone + stoneBridge[curStone];
			
			// 왼쪽 돌로 점프할 수 있는 경우 왼쪽 돌을 stoneList에 추가 및 방문 여부, 영우가 방문 가능한 돌들의 개수를 갱신
			if (leftStone >= 0 && !visited[leftStone]) {
				stoneList.offer(leftStone);
				visited[leftStone] = true;
				count++;
			}
			
			// 오른쪽 돌로 점프할 수 있는 경우 오른쪽 돌을 stoneList에 추가 및 방문 여부, 영우가 방문 가능한 돌들의 개수를 갱신
			if (rightStone < stoneNum && !visited[rightStone]) {
				stoneList.offer(rightStone);
				visited[rightStone] = true;
				count++;
			}
		}
		
		// 영우가 방문 가능한 돌들의 개수를 반환
		return count;
	}
}