package silver4.num26433;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 하우스 내에 존재하는 각 팀의 스톤이 하우스의 중심으로부터 떨어진 거리를 저장할 배열 stones 초기화
	static List<Integer>[] stones;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 1; tc <= testCase; tc++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 스톤과 하우스의 반지름을 각 변수에 할당
			int radiusStone = Integer.parseInt(st.nextToken());
			int radiusHouse = Integer.parseInt(st.nextToken());
			
			// 하우스 내에 존재하기 위한 스톤의 거리를 계산해 변수 maxDistance에 할당
			int maxDistance = (radiusStone + radiusHouse) * (radiusStone + radiusHouse);
			
			// 하우스 내에 존재하는 각 팀의 스톤이 하우스의 중심으로부터 떨어진 거리를 저장할 배열 stones 초기화
			stones = new ArrayList[2];
			
			// for 반복문을 사용해 각 팀을 순회
			for (int idx = 0; idx < 2; idx++) {
				
				// 팀의 스톤이 하우스의 중심으로부터 떨어진 거리를 저장할 List 객체 초기화
				stones[idx] = new ArrayList<>();
				
				// readLine() 및 parseInt() 메서드를 사용해 입력 받은 팀의 스톤 개수를 변수 count에 할당
				int count = Integer.parseInt(in.readLine());
				
				// while 반복문을 사용해 팀의 각 스톤을 순회
				while (count-- > 0) {
					
					// StringTokenizer 객체를 불러와 변수 st에 재할당
					st = new StringTokenizer(in.readLine());
					
					// nextToken() 및 parseInt() 메서드를 사용해 해당 스톤이 위치한 좌표를 각 변수에 할당
					int coordinateX = Integer.parseInt(st.nextToken());
					int coordinateY = Integer.parseInt(st.nextToken());
					
					// 해당 스톤이 하우스의 중심으로부터 떨어진 거리를 변수 distance에 할당
					int distance = coordinateX * coordinateX + coordinateY * coordinateY;
					
					// 해당 스톤이 하우스 내에 존재하는 경우 배열 stones에 해당 스톤이 하우스의 중심으로부터 떨어진 거리를 추가
					if (distance <= maxDistance)
						stones[idx].add(distance);
				}
				
				// sort() 메서드를 사용해 각 스톤을 하우스의 중심과 가까운 순서대로 정렬
				Collections.sort(stones[idx]);
			}
			
			// scoreCalculator() 메서드를 호출해 빨강 팀과 노랑 팀의 점수를 각 변수에 할당
			int redScore = scoreCalculator(0);
			int yellowScore = scoreCalculator(1);
			
			// format() 및 write() 메서드를 사용해 빨강 팀과 노랑 팀의 점수를 출력
			out.write(String.format("Case #%d: %d %d\n", tc, redScore, yellowScore));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// scoreCalculator() 메서드 정의
	public static int scoreCalculator(int team) {
		
		// 하우스 내에 존재하는 스톤이 없는 경우 0을 반환
		if (stones[team].isEmpty())
			return 0;
		
		// 상대 팀의 하우스 내에 존재하는 스톤이 없는 경우 해당 팀의 하우스 내에 존재하는 스톤의 개수를 반환
		if (stones[1 - team].isEmpty())
			return stones[team].size();
		
		// get() 메서드를 사용해 상대 팀의 스톤 중 하우스의 중심에 가장 가까운 거리를 변수 targetDistance에 할당
		int targetDistance = stones[1 - team].get(0);
		
		// 해당 팀이 얻은 점수를 저장할 변수 score 초기화
		int score = 0;
		
		// for 반복문을 사용해 해당 팀의 각 스톤을 순회
		for (int distance : stones[team]) {
			
			// 상대 팀의 모든 스톤보다 해당 스톤이 하우스의 중심에 가까이 있지 않은 경우 반복문 탈출
			if (distance > targetDistance)
				break;
			
			// 해당 팀이 얻은 점수를 갱신
			score++;
		}
		
		// 해당 팀이 얻은 점수를 반환
		return score;
	}
}