package silver2.num10971;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 도시의 수, 외판원의 순회에 필요한 최소 비용을 저장할 각 변수 초기화
	static int cityNum;
	static int minCost = Integer.MAX_VALUE;
	
	// 각 도시별 비용 행렬을 저장할 2차원 배열 costMatrix 초기화
	static int[][] costMatrix;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 도시의 수를 변수 cityNum에 할당
		cityNum = Integer.parseInt(in.readLine());
		
		// 각 도시별 비용 행렬을 저장할 2차원 배열 costMatrix 초기화
		costMatrix = new int[cityNum + 1][cityNum + 1];
		
		// for 반복문을 사용해 비용 행렬의 각 행을 순회
		for (int r = 1; r <= cityNum; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 비용 행렬의 각 값을 2차원 배열 costMatrix에 저장
			for (int c = 1; c <= cityNum; c++)
				costMatrix[r][c] = Integer.parseInt(st.nextToken());
		}
			
		// 각 도시의 방문 여부를 저장할 배열 visited 초기화
		boolean[] visited = new boolean[cityNum + 1];
		
		// for 반복문을 사용해 각 도시를 기점으로 했을 경우를 순회
		for (int city = 1; city <= cityNum; city++) {
			
			// 해당 도시 방문 처리
			visited[city] = true;
			
			// costCalculator() 메서드를 호출해 외판원의 순회에 필요한 최소 비용을 갱신
			costCalculator(city, city, 1, 0, visited);
			
			// 해당 도시 방문 여부 원상복구 처리
			visited[city] = false;
		}
		
		// valueOf() 및 write() 메서드를 사용해 외판원의 순회에 필요한 최소 비용을 출력
		out.write(String.valueOf(minCost));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// costCalculator() 메서드 정의
	public static void costCalculator(int startCity, int currentCity, int cityCnt, int cost, boolean[] visited) {
		
		// 모든 도시를 다 순회한 경우
		if (cityCnt == cityNum) {
			
			// 해당 도시에서 시작 도시로 돌아오는 경로가 있는 경우 외판원의 순회에 필요한 최소 비용을 갱신
			if (costMatrix[currentCity][startCity] != 0)
				minCost = Math.min(cost + costMatrix[currentCity][startCity], minCost);
			
			// 메서드 종료
			return;
		}
		
		// for 반복문을 사용해 각 도시를 차례로 순회
		for (int city = 1; city <= cityNum; city++) {
			
			// 해당 도시로 갈 수 있고 방문하지 않은 도시인 경우
			if (costMatrix[currentCity][city] != 0 && !visited[city]) {
				
				// 해당 도시 방문 처리
				visited[city] = true;
				
				// costCalculator() 메서드 재귀 호출
				costCalculator(startCity, city, cityCnt + 1, cost + costMatrix[currentCity][city], visited);
				
				// 해당 도시 방문 여부 원상복구 처리
				visited[city] = false;
			}
		}
	}
}