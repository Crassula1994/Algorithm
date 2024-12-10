package gold3.num11997;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 소의 수를 변수 cowNum에 할당
		int cowNum = Integer.parseInt(in.readLine());
		
		// 네 구역 중 최대 소의 수의 최솟값을 저장할 변수 minMaxCount 초기화
		int minMaxCount = Integer.MAX_VALUE;
		
		// 소의 위치를 저장할 2차원 배열 cows 초기화
		int[][] cows = new int[cowNum][2];
		
		// 소가 위치한 각 좌표를 순서대로 저장할 각 Set 객체 초기화
		Set<Integer> locationX = new TreeSet<>();
		Set<Integer> locationY = new TreeSet<>();
		
		// for 반복문을 사용해 각 소의 위치를 순회
		for (int idx = 0; idx < cowNum; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 소의 위치를 2차원 배열 cows에 저장
			cows[idx][0] = Integer.parseInt(st.nextToken());
			cows[idx][1] = Integer.parseInt(st.nextToken());
			
			// add() 메서드를 사용해 소가 위치한 각 좌표를 각 Set 객체에 저장
			locationX.add(cows[idx][0]);
			locationY.add(cows[idx][1]);
		}
		
		// locationCompressor() 메서드를 호출해 소가 위치한 각 좌표를 압축하여 저장할 각 Map 객체 초기화
		Map<Integer, Integer> newLocationX = locationCompressor(locationX);
		Map<Integer, Integer> newLocationY = locationCompressor(locationY);
		
		// size() 메서드를 사용해 소가 존재하는 상대적 좌표의 개수를 각 변수에 할당
		int xCount = locationX.size();
		int yCount = locationY.size();
		
		// 압축한 좌표에 위치한 소의 누적 합을 저장할 2차원 배열 cowSum 초기화
		int[][] cowSum = new int[xCount + 1][yCount + 1];

		// for 반복문을 사용해 각 소의 위치를 순회
		for (int idx = 0; idx < cowNum; idx++) {
			
			// get() 메서드를 사용해 해당 소의 압축한 좌표를 각 변수에 할당
			int newPointX = newLocationX.get(cows[idx][0]);
			int newPointY = newLocationY.get(cows[idx][1]);
			
			// 해당 압축한 좌표에 존재하는 소의 수를 갱신
			cowSum[newPointX][newPointY]++;
		}
		
		// for 반복문을 사용해 압축한 좌표에 위치한 소의 누적 합을 갱신
		for (int x = 1; x <= xCount; x++) {
			for (int y = 1; y <= yCount; y++)
				cowSum[x][y] += cowSum[x - 1][y] + cowSum[x][y - 1] - cowSum[x - 1][y - 1];
		}
		
		// for 반복문을 사용해 구역을 나누는 각 경우의 수를 순회
		for (int x = 0; x <= xCount; x++) {
			for (int y = 0; y <= yCount; y++) {
				
				// 네 구역에 존재하는 각 소의 수를 계산해 각 변수에 할당
				int countNW = cowSum[x][y];
				int countNE = cowSum[x][yCount] - countNW;
				int countSW = cowSum[xCount][y] - countNW;
				int countSE = cowSum[xCount][yCount] - countNW - countNE - countSW;
				
				// max() 메서드를 사용해 네 구역 중 최대 소의 수를 변수 maxCount에 할당
				int maxCount = Math.max(Math.max(countNW, countNE), Math.max(countSW, countSE));
				
				// min() 메서드를 사용해 네 구역 중 최대 소의 수의 최솟값을 갱신
				minMaxCount = Math.min(maxCount, minMaxCount);
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 네 구역 중 최대 소의 수의 최솟값을 출력
		out.write(String.valueOf(minMaxCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// locationCompressor() 메서드 정의
	public static Map<Integer, Integer> locationCompressor(Set<Integer> location) {
		
		// 각 좌표의 상대적 순서를 저장할 변수 order 초기화
		int order = 1;
		
		// 소가 위치한 각 좌표를 압축해 저장할 Map 객체 newLocation 초기화
		Map<Integer, Integer> newLocation = new HashMap<>();
		
		// for 반복문을 사용해 소가 위치한 각 좌표를 압축해 newLocation에 저장
		for (int point : location)
			newLocation.put(point, order++);
		
		// 소가 위치한 각 좌표를 압축해 저장한 Map 객체 반환
		return newLocation;
	}
}