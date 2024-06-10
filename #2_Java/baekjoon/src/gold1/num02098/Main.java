package gold1.num02098;

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
	
	// 각 도시의 순회 상태에 따른 순회 비용을 초기화할 상수 INF 초기화
	static final int INF = 987654321;
	
	// 도시의 수를 저장할 변수 cityNum 초기화
	static int cityNum;
	
	// 각 도시간 이동 비용, 각 도시의 순회 상태에 따른 최소 비용을 저장할 각 2차원 배열 초기화
	static int[][] costs;
	static int[][] minCosts;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 도시의 수를 변수 cityNum에 할당
		cityNum = Integer.parseInt(in.readLine());
		
		// 각 도시간 이동 비용, 각 도시의 순회 상태에 따른 최소 비용을 저장할 각 2차원 배열 초기화
		costs = new int[cityNum][cityNum];
		minCosts = new int[cityNum][1 << cityNum];
		
		// for 반복문을 사용해 각 도시를 순회
		for (int r = 0; r < cityNum; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 해당 도시에서 다른 도시로 이동하는 비용을 2차원 배열 costs에 저장
			for (int c = 0; c < cityNum; c++)
				costs[r][c] = Integer.parseInt(st.nextToken());
		}
		
		// for 반복문을 사용해 각 도시의 순회 상태에 따른 최소 비용을 초기화
		for (int idx = 0; idx < minCosts.length; idx++)
			Arrays.fill(minCosts[idx], -1);
		
		// costCalculator() 메서드를 호출해 외판원의 순회에 필요한 최소 비용을 변수 minCost에 할당
		int minCost = costCalculator(0, 1);
		
		// valueOf() 및 write() 메서드를 사용해 외판원의 순회에 필요한 최소 비용을 출력
		out.write(String.valueOf(minCost));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// costCalculator() 메서드 정의
	public static int costCalculator(int curCity, int visited) {
		
		// 모든 도시를 방문한 경우 시작 도시로 돌아올 수 있는지 여부에 따라 그 비용을 반환
		if (visited == (1 << cityNum) - 1)
			return (costs[curCity][0] == 0) ? INF : costs[curCity][0];
		
		// 이미 해당 경로를 방문한 경우 저장된 최소 비용을 반환
		if (minCosts[curCity][visited] != -1)
			return minCosts[curCity][visited];
		
		// 현재 도시의 방문 상태에 따른 최소 비용을 초기화
		minCosts[curCity][visited] = INF;
		
		// for 반복문을 사용해 각 도시를 순회
		for (int nextCity = 0; nextCity < cityNum; nextCity++) {
			
			// 해당 도시를 이미 방문했거나 해당 도시로 가는 경로가 없는 경우 다음 도시를 순회
			if ((visited & (1 << nextCity)) != 0 || costs[curCity][nextCity] == 0)
				continue;
			
			// costCalculator() 메서드를 재귀 호출해 다음 도시를 방문했을 때의 비용을 변수 cost에 할당
			int cost = costs[curCity][nextCity] + costCalculator(nextCity, visited | (1 << nextCity));
			
			// min() 메서드를 사용해 현재 도시의 방문 상태에 따른 최소 비용을 갱신
			minCosts[curCity][visited] = Math.min(cost, minCosts[curCity][visited]);
		}
		
		// 현재 도시의 방문 상태에 따른 최소 비용을 반환
		return minCosts[curCity][visited];
	}
}