package gold1.num01311;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 일의 수행 조합별 비용의 최솟값을 초기화할 상수 INF 초기화
	static final int INF = 987654321;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 사람과 일의 수를 변수 workNum에 할당
		int workNum = Integer.parseInt(in.readLine());
		
		// 각 일의 수행 조합별 비용의 최솟값을 저장할 배열 minCosts 초기화
		int[] minCosts = new int[1 << workNum]; 
		
		// for 반복문을 사용해 각 일의 수행 조합별 비용의 최솟값을 초기화
		for (int idx = 1; idx < minCosts.length; idx++)
			minCosts[idx] = INF;
		
		// 각 사람에 따른 일의 비용을 저장할 2차원 배열 costs 초기화
		int[][] costs = new int[workNum][workNum];
		
		// for 반복문을 사용해 각 사람을 순회
		for (int r = 0; r < workNum; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 각 일의 비용을 2차원 배열 costs에 저장
			for (int c = 0; c < workNum; c++)
				costs[r][c] = Integer.parseInt(st.nextToken());
		}
		
		// for 반복문을 사용해 각 일의 조합을 순회
		for (int comb = 0; comb < minCosts.length; comb++) {
			
			// bitCount() 메서드를 사용해 현재 일의 조합에서 선택된 일의 개수를 변수 count에 할당
			int count = Integer.bitCount(comb);
			
			// for 반복문을 사용해 각 일을 순회
			for (int work = 0; work < workNum; work++) {
				
				// 해당 일이 이미 선택된 경우 다음 일을 순회
				if ((comb & (1 << work)) != 0)
					continue;
				
				// min() 메서드를 사용해 선택되지 않은 일을 선택한 경우의 최소 비용을 갱신
				minCosts[comb | (1 << work)]
						= Math.min(minCosts[comb] + costs[count][work], minCosts[comb | (1 << work)]);
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 모든 일을 하는데 필요한 비용의 최솟값을 출력
		out.write(String.valueOf(minCosts[minCosts.length - 1]));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}