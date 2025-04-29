package silver3.num17484;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 각 이동 방향에 따른 각 칸까지의 최소 연료의 값을 초기화할 상수 MAX_AMOUNT 초기화
	static final int MAX_AMOUNT = 987654321;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 지구와 달 사이 공간을 나타내는 행렬의 크기를 각 변수에 할당
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		
		// 달 여행에 필요한 최소 연료의 값을 저장할 변수 minAmount 초기화
		int minAmount = MAX_AMOUNT;
		
		// 각 이동 방향에 따른 각 칸까지의 최소 연료의 값을 저장할 3차원 배열 minFuel 초기화
		int[][][] minFuel = new int[height][width][3];
		
		// for 반복문을 사용해 각 행을 순회
		for (int r = 0; r < height; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 각 칸을 순회
			for (int c = 0; c < width; c++) {
				
				// nextToken() 및 parseInt() 메서드를 사용해 해당 칸에서 필요한 연료량을 변수 fuelAmount에 할당
				int fuelAmount = Integer.parseInt(st.nextToken());
				
				// 첫 번째 줄인 경우
				if (r == 0) {
					
					// for 반복문을 사용해 각 이동 방향에 따른 각 칸까지의 최소 연료의 값을 갱신
					for (int d = 0; d < 3; d++)
						minFuel[r][c][d] = fuelAmount;
					
					// 다음 칸을 순회
					continue;
				}
				
				// for 반복문을 사용해 각 이동 방향에 따른 각 칸까지의 최소 연료의 값을 초기화
				for (int d = 0; d < 3; d++)
					minFuel[r][c][d] = MAX_AMOUNT;
				
				// 첫 번째 칸이 아닌 경우 왼쪽 위에서 이동해 왔을 때 해당 칸까지의 최소 연료의 값을 갱신
				if (c > 0)
					minFuel[r][c][0] = Math.min(minFuel[r - 1][c - 1][1], minFuel[r - 1][c - 1][2]) + fuelAmount;
				
				// min() 메서드를 사용해 바로 위에서 이동해 왔을 때 해당 칸까지의 최소 연료의 값을 갱신
				minFuel[r][c][1] = Math.min(minFuel[r - 1][c][0], minFuel[r - 1][c][2]) + fuelAmount;
				
				// 마지막 칸이 아닌 경우 오른쪽 위에서 이동해 왔을 때 해당 칸까지의 최소 연료의 값을 갱신
				if (c < width - 1)
					minFuel[r][c][2] = Math.min(minFuel[r - 1][c + 1][0], minFuel[r - 1][c + 1][1]) + fuelAmount;
			}
		}
		
		// for 반복문을 사용해 달 여행에 필요한 최소 연료의 값을 갱신
		for (int c = 0; c < width; c++) {
			for (int d = 0; d < 3; d++)
				minAmount = Math.min(minFuel[height - 1][c][d], minAmount);
		}
		
		// valueOf() 및 write() 메서드를 사용해 달 여행에 필요한 최소 연료의 값을 출력
		out.write(String.valueOf(minAmount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}