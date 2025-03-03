package gold4.num10022;

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
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 들판의 크기 및 이동할 수 있는 걸음의 수를 각 변수에 할당
		int size = Integer.parseInt(st.nextToken());
		int stepLimit = Integer.parseInt(st.nextToken());
		
		// 베시가 도달할 수 있는 최대 풀의 양을 저장할 변수 maxAmount 초기화
		int maxAmount = 0;
		
		// 45도 회전한 풀의 양과 각 위치까지 풀 양의 합을 저장할 각 2차원 배열 초기화
		int[][] field = new int[size * 2][size * 2];
		int[][] maxAmounts = new int[size * 2][size * 2];
		
		// for 반복문을 사용해 각 들판의 행을 순회
		for (int r = 0; r < size; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 각 들판의 풀 양을 45도 회전하여 2차원 배열 field에 저장
			for (int c = 0; c < size; c++)
				field[r + c + 1][size - r + c] = Integer.parseInt(st.nextToken());
		}
		
		// for 반복문을 사용해 각 들판의 위치까지 풀 양의 합을 2차원 배열 maxAmounts에 저장
		for (int r = 1; r < size * 2; r++) {
			for (int c = 1; c < size * 2; c++)
				maxAmounts[r][c] = field[r][c] + maxAmounts[r - 1][c]
						+ maxAmounts[r][c - 1] - maxAmounts[r - 1][c - 1];
		}
		
		// for 반복문을 사용해 각 들판의 위치를 순회
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				
				// 현재 들판의 위치를 각 변수에 할당
				int curRow = r + c + 1;
				int curColumn = size - r + c;
				
				// min() 및 max() 메서드를 사용해 해당 위치에서 그린 범위의 각 극한 값을 각 변수에 할당
				int upLimit = Math.max(1, curRow - stepLimit);
				int downLimit = Math.min(size * 2 - 1, curRow + stepLimit);
				int leftLimit = Math.max(1, curColumn - stepLimit);
				int rightLimit = Math.min(size * 2 - 1, curColumn + stepLimit);
				
				// 해당 위치에서 베시가 도달할 수 있는 최대 풀의 양을 변수 amount에 할당
				int amount = maxAmounts[downLimit][rightLimit] - maxAmounts[upLimit - 1][rightLimit]
						- maxAmounts[downLimit][leftLimit - 1] + maxAmounts[upLimit - 1][leftLimit - 1];
				
				// max() 메서드를 사용해 베시가 도달할 수 있는 최대 풀의 양을 갱신
				maxAmount = Math.max(amount, maxAmount);
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 베시가 도달할 수 있는 최대 풀의 양을 출력
		out.write(String.valueOf(maxAmount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}