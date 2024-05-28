package gold5.num02240;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 자두가 떨어지는 시간 및 최대 이동 횟수를 각 변수에 할당
		int totalTime = Integer.parseInt(st.nextToken());
		int moveLimit = Integer.parseInt(st.nextToken());
		
		// 자두가 받을 수 있는 자두의 최대 개수를 저장할 변수 maxCount 초기화
		int maxCount = 0;
		
		// 각 시간별 자두가 떨어지는 나무의 번호를 저장할 배열 plums 초기화
		int[] plums = new int[totalTime + 1];
		
		// 각 자두의 이동 횟수별 최대로 획득할 수 있는 자두의 개수를 저장할 2차원 배열 maxCounts 초기화
		int[][] maxCounts = new int[moveLimit + 1][totalTime + 1];
		
		// for 반복문을 사용해 각 시간별 자두가 떨어지는 나무의 번호를 배열 plums에 저장
		for (int idx = 1; idx < plums.length; idx++)
			plums[idx] = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 이동하지 않은 경우 최대로 획득할 수 있는 자두의 개수를 갱신
		for (int idx = 1; idx < plums.length; idx++)
			maxCounts[0][idx] = (plums[idx] == 1) ? maxCounts[0][idx - 1] + 1 : maxCounts[0][idx - 1];
		
		// for 반복문을 사용해 각 시간을 순회
		for (int t = 1; t <= totalTime; t++) {
			
			// for 반복문을 사용해 각 이동 횟수를 순회
			for (int w = 1; w <= moveLimit; w++) {
				
				// 현재 1번 나무에 있는 경우
				if (w % 2 == 0) {
					
					// 1번 나무에서 자두가 떨어지는 경우 최대로 획득할 수 있는 자두의 개수를 갱신
					if (plums[t] == 1) {
						maxCounts[w][t] = Math.max(maxCounts[w - 1][t - 1], maxCounts[w][t - 1] + 1);
					
					// 2번 나무에서 자두가 떨어지는 경우 최대로 획득할 수 있는 자두의 개수를 갱신
					} else {
						maxCounts[w][t] = Math.max(maxCounts[w - 1][t - 1] + 1, maxCounts[w][t - 1]);
					}
					
				// 현재 2번 나무에 있는 경우 최대로 획득할 수 있는 자두의 개수를 갱신
				} else {
					
					// 1번 나무에서 자두가 떨어지는 경우 최대로 획득할 수 있는 자두의 개수를 갱신
					if (plums[t] == 1) {
						maxCounts[w][t] = Math.max(maxCounts[w - 1][t - 1] + 1, maxCounts[w][t - 1]);
					
					// 2번 나무에서 자두가 떨어지는 경우 최대로 획득할 수 있는 자두의 개수를 갱신
					} else {
						maxCounts[w][t] = Math.max(maxCounts[w - 1][t - 1], maxCounts[w][t - 1] + 1);
					}
				}
			}
		}
		
		// for 반복문을 사용해 자두가 받을 수 있는 자두의 최대 개수를 갱신
		for (int idx = 0; idx <= moveLimit; idx++)
			maxCount = Math.max(maxCounts[idx][totalTime], maxCount);
		
		// valueOf() 및 write() 메서드를 사용해 자두가 받을 수 있는 자두의 최대 개수를 출력
		out.write(String.valueOf(maxCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}