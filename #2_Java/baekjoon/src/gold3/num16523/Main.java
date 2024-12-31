package gold3.num16523;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 이동 횟수를 저장할 변수 tirpNum 초기화
	static int tripNum;
	
	// 각 이동 정보를 저장할 배열 trips 초기화
	static Trip[] trips;
	
	// 각 이동 횟수, 구간 내 이동 시작 시간에 따른 최소 비용을 저장할 2차원 배열 minCosts 초기화
	static Double[][] minCosts;
	
	// ----------------------------------------------------------------------------------------------------
	
	// Trip 클래스 정의
	static class Trip {
		
		// 이동 시간 및 비용을 저장할 각 변수 초기화
		int duration;
		int cost;
		
		// 매개변수를 입력 받는 생성자 정의
		public Trip(int duration, int cost) {
			this.duration = duration;
			this.cost = cost;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 이동 횟수를 변수 tripNum에 할당
		tripNum = Integer.parseInt(in.readLine());
		
		// 각 이동 정보를 저장할 배열 trips 초기화
		trips = new Trip[tripNum];
		
		// 각 이동 횟수, 구간 내 이동 시작 시간에 따른 최소 비용을 저장할 3차원 배열 minCosts 초기화
		minCosts = new Double[tripNum][121];
		
		// for 반복문을 사용해 각 이동 정보를 순회
		for (int idx = 0; idx < trips.length; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 해당 이동의 소요 시간 및 비용을 각 변수에 할당
			int duration = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			// 해당 이동의 정보를 배열 trips에 저장
			trips[idx] = new Trip(duration, cost);
		}
		
		// costCalculator(), format(), write() 메서드를 사용해 아스토르가 부담해야 할 최소 비용을 출력
		out.write(String.format("%.2f", costCalculator(0, 0, 0)));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// costCalculator() 메서드 정의
	public static double costCalculator(int curTrip, int startTime, int discountCnt) {
		
		// 모든 이동을 확인한 경우 메서드 종료
		if (curTrip == tripNum)
			return 0;
		
		// 이미 최소 비용을 확인한 경우 해당 비용을 반환
		if (minCosts[curTrip][startTime] != null)
			return minCosts[curTrip][startTime];
		
		// 현재 이동에서의 최소 비용과 현재 이동이 끝났을 때의 시간을 저장할 각 변수 초기화
		double minCost = 0;
		int endTime = startTime + trips[curTrip].duration;
		
		// 할인 횟수가 0인 경우 현재 이동에서의 최소 비용을 갱신
		if (discountCnt == 0) {
			minCost += trips[curTrip].cost;
			
		// 할인 횟수가 1인 경우 현재 이동에서의 최소 비용을 갱신
		} else if (discountCnt == 1) {
			minCost += trips[curTrip].cost * 0.5;
			
		// 할인 횟수가 2 이상인 경우 현재 이동에서의 최소 비용을 갱신
		} else {
			minCost += trips[curTrip].cost * 0.25;
		}
		
		// 다음 이동에서 할인을 받을 수 있는 경우 현재 이동에서의 최소 비용을 갱신
		if (endTime < 120 && discountCnt < 5) {
			minCost += Math.min(costCalculator(curTrip + 1, 0, 0), costCalculator(curTrip + 1, endTime, discountCnt + 1));
			
		// 다음 이동에서 할인을 받을 수 없는 경우 현재 이동에서의 최소 비용을 갱신
		} else {
			minCost += costCalculator(curTrip + 1, 0, 0);
		}
		
		// 현재 위치에서의 최소 비용을 반환
		return minCosts[curTrip][startTime] = minCost;
	}
}