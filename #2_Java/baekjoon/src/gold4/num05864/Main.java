package gold4.num05864;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 소의 수, 기지국 설치를 위한 고정 비용, 전송 거리 단위당 비용을 저장할 각 변수 초기화
	static int cowNum;
	static int fixedCost;
	static int unitCost;
	
	// 각 소의 위치와 해당 위치까지 기지국을 설치하기 위한 최소 비용의 2배를 저장할 각 배열 초기화
	static int[] cows;
	static Integer[] minCosts;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		/* nextToken() 및 parseInt() 메서드를 사용해 입력 받은 소의 수, 기지국 설치를 위한 고정 비용,
		전송 거리 단위당 비용을 각 변수에 할당 */
		cowNum = Integer.parseInt(st.nextToken());
		fixedCost = Integer.parseInt(st.nextToken());
		unitCost = Integer.parseInt(st.nextToken());
		
		// 각 소의 위치와 해당 위치까지 기지국을 설치하기 위한 최소 비용의 2배를 저장할 각 배열 초기화
		cows = new int[cowNum];
		minCosts = new Integer[cowNum];
		
		// for 반복문을 사용해 입력 받은 소의 위치를 배열 cows에 저장
		for (int idx = 0; idx < cows.length; idx++)
			cows[idx] = Integer.parseInt(in.readLine());
		
		// sort() 메서드를 사용해 입력 받은 소의 위치를 오름차순으로 정렬
		Arrays.sort(cows);
		
		// 가장 왼쪽에 위치한 소의 위치에 기지국을 설치했을 때의 최소 비용을 초기화
		minCosts[0] = fixedCost * 2;
		
		// minCostCalculator() 메서드를 호출해 기지국을 설치하기 위한 최소 비용의 2배를 변수 minCost에 할당
		int minCost = minCosts[0] + minCostCalculator(1);
		
		// valueOf() 및 write() 메서드를 사용해 기지국을 설치하기 위한 최소 비용을 출력
		out.write(String.valueOf(minCost / 2));
		
		// 최소 비용의 소숫점이 존재하는 경우 소숫점을 출력
		if ((minCost & 1) == 1)
			out.write(".5");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// minCostCalculator() 메서드 정의
	public static int minCostCalculator(int curCow) {
		
		// 모든 소를 확인한 경우 0을 반환
		if (curCow == cowNum)
			return 0;
		
		// 현재 소의 위치에서 최소 비용의 2배를 이미 계산한 경우 해당 최소 비용의 2배를 반환
		if (minCosts[curCow] != null)
			return minCosts[curCow];
		
		/* minCostCalculator() 메서드를 재귀 호출해 직전에 설치한 기지국을 이전하거나
		새로 기지국을 설치하는 경우를 상정하고 각 최소 비용의 2배를 각 변수에 할당 */
		int moveCost = unitCost * (cows[curCow] - cows[curCow - 1]) + minCostCalculator(curCow + 1);
		int installCost = 2 * fixedCost + minCostCalculator(curCow + 1);
		
		// min() 메서드를 사용해 현재 소의 위치에서 최소 비용의 2배를 반환
		return minCosts[curCow] = Math.min(moveCost, installCost);
	}
}