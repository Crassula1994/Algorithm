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
	static Map<Integer, List<Furrow>> climbed;
	
	// Furrow 클래스 정의
	static public class Furrow implements Comparable<Furrow> {
		
		// 해당 홈의 x 좌표, y 좌표, 이동 횟수를 저장할 각 변수 초기화
		int x;
		int y;
		Integer count = null;
		
		// 인자를 입력 받는 각 생성자 정의
		public Furrow(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public Furrow(int x, int y, Integer count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
		
		// compareTo() 메서드 정의
		@Override
		public int compareTo(Furrow f) {
			return y - f.y;
		}
	}
	
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
			climbed.get(x).add(new Furrow(x, y));
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
		Queue<Furrow> climbList = new LinkedList<>();
		
		// offer() 메서드를 사용해 출발 좌표를 climbList에 추가 및 방문 처리
		climbList.offer(new Furrow(0, 0, 0));
		
		// while 반복문을 사용해 climbList가 빌 때까지 순회
		while (!climbList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 올라 있는 홈을 변수 currentFurrow에 할당
			Furrow currentFurrow = climbList.poll();
			
			// 해당 위치가 정상인 경우 정상까지의 이동횟수를 반환
			if (currentFurrow.y == topHeight)
				return currentFurrow.count;
			
			// for 반복문을 사용해 이동할 수 있는 x 좌표를 순회
			for (int nx = currentFurrow.x - 2; nx <= currentFurrow.x + 2; nx++) {
				
				// 해당 x 좌표가 존재하지 않는 경우 다음 x 좌표를 순회
				if (!climbed.containsKey(nx))
					continue;
				
				// get() 메서드를 사용해 해당 x 좌표에 위치한 y 좌표들을 List 객체 yCoordinates에 할당
				List<Furrow> yCoordinates = climbed.get(nx);
				
				// max(), binarySearch() 메서드를 사용해 이동 가능한 y 좌표가 존재하는 시작 인덱스를 변수 startIdx에 할당
				int startIdx = Collections.binarySearch(yCoordinates, new Furrow(currentFurrow.x, Math.max(0, currentFurrow.y - 2)));
				
				// 정확히 일치하는 값이 없는 경우 x 좌표의 위치를 변환
				if (startIdx < 0)
					startIdx = Math.abs(startIdx) - 1;
				
				// for 반복문을 사용해 가능한 위치를 순회
				for (int idx = startIdx; idx < yCoordinates.size(); idx++) {
					
					// 해당 값이 가능한 범위를 벗어난 경우 반복문 탈출
					if (yCoordinates.get(idx).y > currentFurrow.y + 2)
						break;
					
					// 해당 위치를 이미 방문한 경우 다음 위치를 순회
					if (yCoordinates.get(idx).count != null)
						continue;
					
					// get() 및 offer() 메서드를 사용해 해당 위치를 climbList에 추가 및 방문 처리
					climbList.offer(yCoordinates.get(idx));
					yCoordinates.get(idx).count = currentFurrow.count + 1;
				}
			}
		}

		// 정상에 오를 수 없는 경우 -1을 반환
		return -1;
	}
}