package silver1.num01149;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {

	// 각 집을 칠하는 비용 및 해당 집까지의 최소 비용을 저장할 각 2차원 배열 초기화
	static int[][] costs;
	static int[][] minCosts;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 집의 수를 변수 houseNum에 할당
		int houseNum = Integer.parseInt(in.readLine());
		
		// 각 집을 칠하는 비용을 저장할 2차원 배열 costs 초기화
		costs = new int[houseNum][3];
		
		// 해당 집까지의 최소 비용을 저장할 2차원 배열 minCosts 초기화
		minCosts = new int[houseNum][3];
		
		// for 반복문을 사용해 2차원 배열 costs의 각 행을 순회
		for (int r = 0; r < costs.length; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 배열 cost에 각 집을 칠하는 비용을 저장
			for (int c = 0; c < 3; c++)
				costs[r][c] = Integer.parseInt(st.nextToken());
		}
		
		// 첫 집까지의 최소 비용을 초기화
		minCosts[0][0] = costs[0][0];
		minCosts[0][1] = costs[0][1];
		minCosts[0][2] = costs[0][2];
		
		// costCalculator() 메서드를 호출해 모든 집을 칠하는 비용의 최솟값을 각 변수에 할당
		int minRedCost = costCalculator(houseNum - 1, 0);
		int minGreenCost = costCalculator(houseNum - 1, 1);
		int minBlueCost = costCalculator(houseNum - 1, 2);
		
		// min() 메서드를 사용해 비용의 최솟값을 변수 minCost에 할당
		int minCost = Math.min(Math.min(minRedCost, minGreenCost), minBlueCost);
		
		// valueOf() 및 write() 메서드를 사용해 모든 집을 칠하는 비용의 최솟값을 출력
		out.write(String.valueOf(minCost));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// costCalculator() 메서드 정의
	public static int costCalculator(int house, int color) {
		
		// 최소 비용이 저장되어 있는 경우 저장된 값 반환
		if (minCosts[house][color] != 0) {
			return minCosts[house][color];
		
		// 최소 비용이 저장되어 있지 않은 경우
		} else {
			
			// 빨강으로 칠한 경우 이전 색을 초록 또는 파랑으로 칠하는 경우를 비교하여 배열 minCosts에 저장
			if (color == 0) {
				minCosts[house][0] = Math.min(costCalculator(house - 1, 1), costCalculator(house - 1, 2)) + costs[house][0];
				
			// 초록으로 칠할 경우 이전 색을 빨강 또는 파랑으로 칠하는 경우를 비교하여 배열 minCosts에 저장
			} else if (color == 1) {
				minCosts[house][1] = Math.min(costCalculator(house - 1, 0), costCalculator(house - 1, 2)) + costs[house][1];
				
			// 파랑으로 칠할 경우 다음 색을 빨강 또는 파랑으로 칠하는 경우를 비교하여 배열 minCosts에 저장
			} else {
				minCosts[house][2] = Math.min(costCalculator(house - 1, 0), costCalculator(house - 1, 1)) + costs[house][2];
			}
			
			// 저장한 값 반환
			return minCosts[house][color];
		}
	}
}