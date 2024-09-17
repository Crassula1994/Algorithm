package gold3.num17471;

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
	
	// 구역의 개수, 두 선거구의 인구 차이의 최솟값을 저장할 각 변수 초기화
	static int districtNum;
	static int minDiff = Integer.MAX_VALUE;
	
	// 각 구역의 인구, 구역 A에 해당하는지 여부, 인접 구역의 정보를 저장할 각 배열 초기화
	static int[] population;
	static boolean[] isDistA;
	static List<Integer>[] neighbors;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 구역의 개수를 변수 districtNum에 할당
		districtNum = Integer.parseInt(in.readLine());
		
		// 각 구역의 인구, 구역 A에 해당하는지 여부, 인접 구역의 정보를 저장할 각 배열 초기화
		population = new int[districtNum + 1];
		isDistA = new boolean[districtNum + 1];
		neighbors = new ArrayList[districtNum + 1];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 각 구역의 인구를 배열 population에 저장
		for (int idx = 1; idx < population.length; idx++)
			population[idx] = Integer.parseInt(st.nextToken());
		
		// for 반복문을 사용해 각 인접 구역의 정보를 저장할 List 객체 초기화
		for (int idx = 0; idx < neighbors.length; idx++)
			neighbors[idx] = new ArrayList<>();
		
		// for 반복문을 사용해 각 구역의 정보를 순회
		for (int idx = 1; idx <= districtNum; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 인접 구역의 수를 변수 neighborCnt에 할당
			int neighborCnt = Integer.parseInt(st.nextToken());
			
			// while 반복문을 사용해 입력 받은 인접 구역을 배열 neighbors에 저장
			while (neighborCnt-- > 0)
				neighbors[idx].add(Integer.parseInt(st.nextToken()));
		}
		
		// districtDivider() 메서드를 호출해 각 구역을 구역 A와 구역 B로 분리
		districtDivider(1);
		
		// valueOf() 및 write() 메서드를 사용해 두 선거구의 인구 차이의 최솟값을 출력
		out.write((minDiff == Integer.MAX_VALUE) ? String.valueOf(-1) : String.valueOf(minDiff));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// districtDivider() 메서드 정의
	public static void districtDivider(int curDist) {
		
		// 모든 구역에 대하여 선택이 끝난 경우
		if (curDist > districtNum) {
			
			// 각 선거구에 속한 구역을 저장할 각 List 객체 초기화
			List<Integer> distA = new ArrayList<>();
			List<Integer> distB = new ArrayList<>();
			
			// for 반복문을 사용해 각 구역을 순회
			for (int idx = 1; idx < isDistA.length; idx++) {
				
				// 해당 구역이 선거구 A인 경우 distA에 해당 구역을 추가
				if (isDistA[idx]) {
					distA.add(idx);
					
				// 해당 구역이 선거구 B인 경우 distB에 해당 구역을 추가
				} else {
					distB.add(idx);
				}
			}
			
			// 어느 한 선거구에 속한 구역이 없는 경우 메서드 종료
			if (distA.isEmpty() || distB.isEmpty())
				return;
			
			// 두 선거구가 각각 연결되어 있는 경우 diffCalculator() 메서드를 호출해 두 선거구의 인구 차이의 최솟값을 갱신
			if (districtChecker(distA) && districtChecker(distB))
				diffCalculator(distA, distB);
			
			// 메서드 종료
			return;
		}
		
		// 해당 구역을 구역 A로 선택한 것으로 상정하고 districtDivider() 메서드 재귀 호출
		isDistA[curDist] = true;
		districtDivider(curDist + 1);
		
		// 해당 구역을 구역 B로 선택한 것으로 상정하고 districtDivider() 메서드 재귀 호출
		isDistA[curDist] = false;
		districtDivider(curDist + 1);
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// districtChecker() 메서드 정의
	public static boolean districtChecker(List<Integer> dists) {
		
		// 해당 구역에 속한 선거구 중 확인한 선거구의 개수를 저장할 변수 count 초기화
		int count = 1;
		
		// 각 구역의 확인 여부를 저장할 배열 checked 초기화
		boolean[] checked = new boolean[districtNum + 1];
		
		// 다음에 확인할 구역을 저장할 Queue 객체 checkList 초기화
		Queue<Integer> checkList = new LinkedList<>();
		
		// get() 및 offer() 메서드를 사용해 시작 구역을 checkList에 추가 및 확인 처리
		checkList.offer(dists.get(0));
		checked[dists.get(0)] = true;
		
		// while 반복문을 사용해 checkList가 빌 때까지 순회
		while (!checkList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 확인 중인 구역을 변수 curDist에 할당
			int curDist = checkList.poll();
			
			// for 반복문을 사용해 현재 구역과 인접한 구역을 순회
			for (int nextDist : neighbors[curDist]) {
				
				// 해당 구역을 이미 확인했거나 같은 구역에 속한 선거구가 아닌 경우 다음 구역을 순회
				if (checked[nextDist] || !dists.contains(nextDist))
					continue;
				
				// offer() 메서드를 사용해 해당 구역을 checkList에 추가 및 확인 처리
				checkList.offer(nextDist);
				checked[nextDist] = true;
				
				// 해당 구역에 속한 선거구 중 확인한 선거구의 개수를 갱신
				count++;
			}
		}
		
		// 해당 선거구의 구역이 연결되어 있지 않은 경우 false 반환
		if (count != dists.size())
			return false;
		
		// 해당 선거구의 구역이 연결되어 있는 경우 true 반환
		return true;
	}
	
	// ----------------------------------------------------------------------------------------------------

	// diffCalculator() 메서드 정의
	public static void diffCalculator(List<Integer> distA, List<Integer> distB) {
		
		// 두 선거구의 인구를 저장할 각 변수를 초기화
		int populationA = 0;
		int populationB = 0;
		
		// for 반복문을 사용해 선거구 A의 인구를 갱신
		for (int dist : distA)
			populationA += population[dist];
		
		// for 반복문을 사용해 선거구 B의 인구를 갱신
		for (int dist : distB)
			populationB += population[dist];
		
		// abs() 및 min() 메서드를 사용해 두 선거구의 인구 차이의 최솟값을 갱신
		minDiff = Math.min(Math.abs(populationA - populationB), minDiff);		
	}
}