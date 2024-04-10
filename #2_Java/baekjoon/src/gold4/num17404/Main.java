package gold4.num17404;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 집의 수를 변수 houseNum에 할당
		int houseNum = Integer.parseInt(in.readLine());
		
		// 각 집을 칠하는 비용을 저장할 2차원 배열 costs 초기화
		int[][] costs = new int[houseNum + 1][3];
		
		// for 반복문을 사용해 각 집을 칠하는 비용을 순회
		for (int house = 1; house <= houseNum; house++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 각 색으로 집을 칠하는 비용을 2차원 배열 costs에 저장
			costs[house][0] = Integer.parseInt(st.nextToken());
			costs[house][1] = Integer.parseInt(st.nextToken());
			costs[house][2] = Integer.parseInt(st.nextToken());
		}
		
		// 모든 집을 칠하는 최소 비용을 저장할 변수 minCost 초기화
		int minCost = Integer.MAX_VALUE;
		
		// for 반복문을 사용해 첫 번째 집을 각 색상으로 칠하는 경우를 갱신
		for (int color = 0; color < 3; color++) {
			
			// 각 집을 칠하는 최소 비용을 저장할 2차원 배열 minCosts 초기화
			int[][] minCosts = new int[houseNum + 1][3];
			
			// for 반복문을 사용해 첫 번째 집을 해당 색상으로 칠하는 최소 비용을 갱신
			for (int c = 0; c < 3; c++)
				minCosts[1][c] = (color == c) ? costs[1][color] : 987654321;
			
			// for 반복문을 사용해 각 집을 각 색상으로 칠하는 최소 비용을 갱신
			for (int house = 2; house <= houseNum; house++) {
				minCosts[house][0] = Math.min(minCosts[house - 1][1], minCosts[house - 1][2]) + costs[house][0];
				minCosts[house][1] = Math.min(minCosts[house - 1][0], minCosts[house - 1][2]) + costs[house][1];
				minCosts[house][2] = Math.min(minCosts[house - 1][0], minCosts[house - 1][1]) + costs[house][2];
			}
			
			// for 반복문을 사용해 모든 집을 칠하는 최소 비용을 갱신
			for (int c = 0; c < 3; c++)
				minCost = (color == c) ? minCost : Math.min(minCosts[houseNum][c], minCost);
		}

		// valueOf() 및 write() 메서드를 사용해 모든 집을 칠하는 최소 비용을 출력
		out.write(String.valueOf(minCost));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}