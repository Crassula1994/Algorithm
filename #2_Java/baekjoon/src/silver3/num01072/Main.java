package silver3.num01072;

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
		
		// nextToken() 및 parseLong() 메서드를 사용해 입력 받은 게임 횟수와 이긴 게임의 수를 각 변수에 할당
		long totalCount = Long.parseLong(st.nextToken());
		long winCount = Long.parseLong(st.nextToken());
		
		// 현재까지의 승률을 계산해 변수 winningRate에 할당
		long winningRate = winCount * 100 / totalCount;
		
		// 형택이가 게임을 해야 하는 최소 횟수를 저장할 변수 minCount 초기화
		int minCount = -1;
		
		// 승률이 99% 이상이 아닌 경우
		if (winningRate < 99) {
			
			// 이분탐색을 위해 필요한 각 변수 초기화
			int top = 1000000000;
			int bottom = 1;
			
			// while 반복문을 사용해 이분탐색이 끝날 때까지 순회
			while (top >= bottom) {
			
				// 두 수의 중간 값을 계산해 변수 middle에 할당
				int middle = (top + bottom) / 2;
				
				// 바뀐 승률을 계산해 변수 newWinningRate에 할당
				long newWinningRate = (winCount + middle) * 100 / (totalCount + middle);
				
				// 바뀐 승률이 이전 승률과 같은 경우 하한을 갱신
				if (winningRate == newWinningRate) {
					bottom = middle + 1;
				
				// 바뀐 승률이 이전 승률과 다른 경우 상한을 갱신
				} else {
					top = middle - 1;
				}
			}
			
			// 형택이가 게임을 해야 하는 최소 횟수를 갱신
			minCount = bottom;
		}
		
		// valueOf() 및 write() 메서드를 사용해 형택이가 게임을 해야 하는 최소 횟수를 출력
		out.write(String.valueOf(minCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}