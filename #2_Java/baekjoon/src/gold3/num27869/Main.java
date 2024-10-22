package gold3.num27869;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 이벤트를 진행하는 날 수 및 테스트 동작의 수를 각 변수에 할당
		int dayCount = Integer.parseInt(st.nextToken());
		int testCount = Integer.parseInt(st.nextToken());
		
		// 각 날짜별로 받을 이벤트 토큰의 누적 합을 저장할 배열 tokenSum 초기화
		long[] tokenSum = new long[dayCount + 1];
		
		// 이벤트 토큰을 초기화할 날짜를 저장할 Set 객체 resetDays 초기화
		TreeSet<Integer> resetDays = new TreeSet<>();
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 날짜별로 받을 이벤트 토큰의 누적 합을 배열 tokenSum에 저장
		for (int idx = 1; idx < tokenSum.length; idx++)
			tokenSum[idx] = Integer.parseInt(st.nextToken()) + tokenSum[idx - 1];
		
		// while 반복문을 사용해 각 테스트 동작을 순회
		while (testCount-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 테스트 동작의 종류를 변수 category에 할당
			int category = Integer.parseInt(st.nextToken());
			
			// 1번 종류의 테스트 동작인 경우
			if (category == 1) {
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 초기화 일자를 변수 resetDay에 할당
				int resetDay = Integer.parseInt(st.nextToken());
				
				// add() 메서드를 사용해 입력 받은 초기화 일자를 음수로 변환해 resetDays에 저장
				resetDays.add(-resetDay);

			// 2번 종류의 테스트 동작인 경우
			} else {
			
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 시작 일자와 끝 일자를 각 변수에 할당
				int startDay = Integer.parseInt(st.nextToken());
				int endDay = Integer.parseInt(st.nextToken());
				
				// 주어진 기간 중 끝 일자와 가장 가까운 초기화 일자를 저장할 변수 recentResetDay 초기화
				int recentResetDay = 0;
				
				// 초기화 일자가 존재하는 경우
				if (!resetDays.isEmpty()) {
					
					// higher() 메서드를 사용해 끝 일자와 가장 가까운 초기화 일자를 변수 resetDay에 할당
					Integer resetDay = resetDays.higher(-endDay);
					
					// 끝 일자와 가장 가까운 초기화 일자가 존재하는 경우 주어진 기간 중 끝 일자와 가장 가까운 초기화 일자를 갱신
					if (resetDay != null)
						recentResetDay = -resetDay;
				}
				
				// 끝 일자와 가장 가까운 초기화 일자가 존재하지 않는 경우 해당 기간의 이벤트 토큰 개수를 출력
				if (recentResetDay == 0) {
					out.write((tokenSum[endDay] - tokenSum[startDay - 1]) + "\n");
				
				// 끝 일자와 가장 가까운 초기화 일자가 존재하는 경우 해당 기간의 이벤트 토큰 개수를 출력
				} else {
					out.write((tokenSum[endDay] - tokenSum[Math.max(recentResetDay, startDay - 1)]) + "\n");
				}
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}