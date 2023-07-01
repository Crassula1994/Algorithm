package gold5.num03980;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 능력치의 합의 최댓값을 저장할 변수 maxSum 초기화
	static int maxSum;
	
	// 각 선수의 포지션별 능력치를 저장할 2차원 배열 capabilities 초기화
	static int[][] capabilities;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// 능력치의 합의 최댓값을 저장할 변수 maxSum 초기화
			maxSum = 0;
			
			// 각 선수의 포지션별 능력치를 저장할 2차원 배열 capabilities 초기화
			capabilities = new int[11][11];
			
			// for 반복문을 사용해 입력 받은 각 선수를 순회
			for (int r = 0; r < 11; r++) {
				
				// StringTokenizer 객체를 불러와 변수 st에 할당
				StringTokenizer st = new StringTokenizer(in.readLine());
				
				// for 반복문을 사용해 입력 받은 해당 선수의 포지션별 능력치를 2차원 배열 capabilities에 저장
				for (int c = 0; c < 11; c++)
					capabilities[r][c] = Integer.parseInt(st.nextToken());
			}
			
			// 해당 포지션의 배치 여부를 저장할 배열 isOccupied 초기화
			boolean[] isOccupied = new boolean[11];
			
			// positionArranger() 메서드를 호출해 능력치의 합의 최댓값을 갱신
			positionArranger(0, 0, isOccupied);
			
			// write() 메서드를 사용해 능력치의 합의 최댓값을 출력
			out.write(maxSum + "\n");
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// positionArranger() 메서드 정의
	public static void positionArranger(int playerNum, int sum, boolean[] isOccupied) {
		
		// 모든 선수를 모든 포지션에 배치한 경우
		if (playerNum == 11) {
			
			// max() 메서드를 사용해 능력치의 합의 최댓값을 갱신
			maxSum = Math.max(sum, maxSum);
			
			// 메서드 종료
			return;
		}
		
		// for 반복문을 사용해 각 포지션을 순회
		for (int position = 0; position < 11; position++) {
			
			// 아직 배치되지 않은 포지션이고 해당 선수가 그 포지션에 적합한 경우
			if (!isOccupied[position] && capabilities[playerNum][position] != 0) {
				
				// 해당 포지션 배치 처리
				isOccupied[position] = true;
				
				// positionArranger() 메서드 재귀 호출
				positionArranger(playerNum + 1, sum + capabilities[playerNum][position], isOccupied);
				
				// 해당 포지션 배치 원상복구 처리
				isOccupied[position] = false;
			}
		}
	}
}