package gold4.num02412;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 홈의 개수, 정상의 높이를 저장할 각 변수 초기화
	static int furrowNum;
	static int topHeight;
	
	// 각 홈으로의 이동 여부를 저장할 Map 객체 climbed 초기화
	static Map<Integer, List<Integer>> climbed;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 홈의 개수 및 정상의 높이를 각 변수에 할당
		furrowNum = Integer.parseInt(st.nextToken());
		topHeight = Integer.parseInt(st.nextToken());		

		// 각 좌표의 방문 여부를 저장할 Map 객체 climbed 초기화
		climbed = new HashMap<>();
		
		// for 반복문을 사용해 각 홈의 좌표를 순회
		for (int f = 0; f < furrowNum; f++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 각 좌표를 각 변수에 할당
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			// 해당 x 좌표가 climbed에 존재하지 않는 경우 해당 x 좌표의 ArrayList 객체를 초기화
			if (!climbed.containsKey(x))
				climbed.put(x, new ArrayList<>());
			
			// get() 및 add() 메서드를 사용해 해당 좌표를 추가
			climbed.get(x).add(y);
		}
		
		// for 반복문을 사용해 climbed에 저장된 각 y 좌표를 오름차순으로 정렬
		for (int x : climbed.keySet())
			Collections.sort(climbed.get(x));
		
		// climbCounter() 메서드를 호출해 최소 이동횟수를 변수 minCnt에 할당
		int minCnt = climbCounter(0, 0);
		
		// valueOf() 및 write() 메서드를 사용해 최소 이동횟수를 출력
		out.write(String.valueOf(minCnt));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// climbCounter() 메서드 정의
	public static int climbCounter(int startX, int startY) {
		
		// 다음에 이동할 위치를 저장할 Queue 객체 climbList 초기화
		Queue<int[]> climbList = new LinkedList<>();
		
		// offer() 메서드를 사용해 출발 좌표를 climbList에 추가
		climbList.offer(new int[] {0, 0, 0});
		
		// while 반복문을 사용해 climbList가 빌 때까지 순회
		while (!climbList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 올라 있는 홈을 변수 배열 currentFurrow에 할당
			int[] currentFurrow = climbList.poll();
			
			// 해당 위치가 정상인 경우 정상까지의 이동횟수를 반환
			if (currentFurrow[1] == topHeight)
				return currentFurrow[2];
			
			// for 반복문을 사용해 이동할 수 있는 x 좌표를 순회
			for (int nx = currentFurrow[0] - 2; nx <= currentFurrow[0] + 2; nx++) {
				
				// 해당 y 좌표가 존재하지 않는 경우 다음 x 좌표를 순회
				if (!climbed.containsKey(nx))
					continue;
				
				// 해당 x 좌표에서의 y 좌표 중
				
				int index = Collections.binarySearch(climbed.get(nx), Math.max(0, currentFurrow[1] - 2));
				
				
				climbed.get(nx).remove(nx);
				
				
			}
			
			
		}
		
		
		// 정상에 오를 수 없는 경우 -1을 반환
		return -1;
	}
}