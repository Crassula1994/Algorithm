package silver2.num14620;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 화단의 길이, 꽃을 심기 위한 최소 비용을 저장할 각 변수 초기화
	static int length;
	static int minCost = Integer.MAX_VALUE;
	
	// 각 꽃의 위치를 저장할 각 델타 배열 초기화
	static int[] dr = {0, -1, 1, 0, 0};
	static int[] dc = {0, 0, 0, -1, 1};
	
	// 화단의 각 지점에서의 가격 및 꽃이 피어있는지 여부를 저장할 각 2차원 배열 초기화
	static int[][] prices;
	static boolean[][] bloomed;
	
	// ----------------------------------------------------------------------------------------------------

	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 화단의 길이를 변수 length에 할당
		length = Integer.parseInt(in.readLine());
		
		// 화단의 각 지점에서의 가격 및 꽃이 피어있는지 여부를 저장할 각 2차원 배열 초기화
		prices = new int[length][length];
		bloomed = new boolean[length][length];
		
		// for 반복문을 사용해 화단의 각 행을 순회
		for (int r = 0; r < length; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 화단의 각 지점에서의 가격을 배열 prices에 저장
			for (int c = 0; c < length; c++)
				prices[r][c] = Integer.parseInt(st.nextToken());
		}
		
		// costCalculator() 메서드를 호출해 꽃을 심기 위한 최소 비용을 갱신
		costCalculator(1, 1, 0, 0);
		
		// valueOf() 및 write() 메서드를 사용해 꽃을 심기 위한 최소 비용을 출력
		out.write(String.valueOf(minCost));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// costCalculator() 메서드 정의
	public static void costCalculator(int curRow, int curCol, int selected, int costSum) {
				
		// 현재 비용이 저장된 최소 비용보다 많거나 같은 경우 메서드 종료
		if (costSum >= minCost)
			return;
		
		// 꽃을 심을 위치를 모두 정한 경우 꽃을 심기 위한 최소 비용 갱신 후 메서드 종료
		if (selected == 3) {
			minCost = costSum;
			return;
		}
		
		// for 반복문을 사용해 꽃을 심을 수 있는 위치를 순회
		for (int r = curRow; r < length - 1; r++) {			
			outer: for (int c = (r == curRow) ? curCol : 1; c < length - 1; c++) {
				
				// 해당 위치에 꽃을 심을 때의 비용을 저장할 변수 cost 초기화
				int cost = 0;
				
				// for 반복문을 사용해 꽃이 피는 각 위치를 순회
				for (int d = 0; d < 5; d++) {
					
					// 각 위치를 각 변수에 할당
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					// 해당 위치에 다른 꽃이 존재하는 경우 다음 위치를 순회
					if (bloomed[nr][nc])
						continue outer;
					
					// 해당 위치에 꽃을 심을 때의 비용을 갱신
					cost += prices[nr][nc];
				}
				
				// flowerPlanter() 메서드를 호출해 해당 위치에 꽃을 심은 것으로 처리
				flowerPlanter(r, c, true);
				
				// costCalculator() 메서드 재귀 호출
				costCalculator(r, c, selected + 1, costSum + cost);
				
				// flowerPlanter() 메서드를 호출해 해당 위치에 꽃을 심지 않은 것으로 처리
				flowerPlanter(r, c, false);
			}
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// flowerPlanter() 메서드 정의
	public static void flowerPlanter(int row, int column, boolean isBloomed) {
		
		// for 반복문을 사용해 꽃이 피는 각 위치를 순회
		for (int d = 0; d < 5; d++) {
			
			// 각 위치를 각 변수에 할당
			int nr = row + dr[d];
			int nc = column + dc[d];
			
			// 해당 위치에 꽃을 심은 상태를 갱신
			bloomed[nr][nc] = isBloomed;
		}
	}
}