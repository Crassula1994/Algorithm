package silver1.num04883;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 테스트 케이스의 번호를 저장할 변수 testCase 초기화
		int testCase = 0;

		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (true) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 그래프의 행의 개수를 변수 rowNum에 할당
			int rowNum = Integer.parseInt(in.readLine());
			
			// 마지막 테스트 케이스인 경우 반복문 탈출
			if (rowNum == 0)
				break;
			
			// 그래프에서 각 정점에서의 최소 비용을 저장할 2차원 배열 minCosts 초기화
			int[][] minCosts = new int[rowNum][3];
			
			// for 반복문을 사용해 각 행을 순회
			for (int r = 0; r < rowNum; r++) {
				
				// StringTokenizer 객체를 불러와 변수 st에 할당
				StringTokenizer st = new StringTokenizer(in.readLine());
				
				// for 반복문을 사용해 각 열을 순회
				for (int c = 0; c < 3; c++) {
					
					// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 해당 정점의 비용을 2차원 배열 minCosts에 저장
					minCosts[r][c] = Integer.parseInt(st.nextToken());
					
					// 첫째 줄인 경우 다음 열을 순회
					if (r == 0)
						continue;
					
					// 둘째 줄 첫 번째 칸인 경우 해당 정점에서의 최소 비용을 갱신
					if (r == 1 && c == 0) {
						minCosts[r][c] += minCosts[r - 1][1];
						
					// 둘째 줄 두 번째 또는 세 번째 칸인 경우 해당 정점에서의 최소 비용을 갱신
					} else if (r == 1) {
						minCosts[r][c] += Math.min(minCosts[r][c - 1],
								Math.min(minCosts[r - 1][1], minCosts[r - 1][1] + minCosts[r - 1][2]));
						
					// 셋째 줄 이상인 첫 번째 칸인 경우 해당 정점에서의 최소 비용을 갱신
					} else if (c == 0) {
						minCosts[r][c] += Math.min(minCosts[r - 1][0], minCosts[r - 1][1]);
						
					// 셋째 줄 이상인 두 번째 칸인 경우 해당 정점에서의 최소 비용을 갱신
					} else if (c == 1) {
						minCosts[r][c] += Math.min(Math.min(minCosts[r][0], minCosts[r - 1][0]),
								Math.min(minCosts[r - 1][1], minCosts[r - 1][2]));
						
					// 셋째 줄 이상인 세 번째 칸인 경우 해당 정점에서의 최소 비용을 갱신
					} else {
						minCosts[r][c] += Math.min(minCosts[r][1], Math.min(minCosts[r - 1][1], minCosts[r - 1][2]));
					}
				}
			}
			
			// write() 메서드를 사용해 테스트 케이스 번호와 최소 비용을 출력
			out.write(++testCase + ". " + minCosts[rowNum - 1][1] + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}