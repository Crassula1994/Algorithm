package bronze1.num20113;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 플레이어의 수를 변수 playerNum에 할당
		int playerNum = Integer.parseInt(in.readLine());
		
		// 각 플레이어가 받은 표의 수를 저장할 배열 voteCounts 초기화
		int[] voteCounts = new int[playerNum + 1];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// while 반복문을 사용해 각 플레이어가 받은 표의 수를 갱신
		while (st.hasMoreTokens())
			voteCounts[Integer.parseInt(st.nextToken())]++;
		
		// 모두 투표를 건너 뛴 경우 'skipped'를 출력
		if (voteCounts[0] == playerNum) {
			out.write("skipped");
			
		// 모두 투표를 건너뛰지 않은 경우
		} else {
			
			// 가장 많이 받은 표의 수, 표를 가장 많이 받은 플레이어, 공동 최다 득표 존재 여부를 저장할 각 변수 초기화
			int maxCount = 0;
			int maxPlayer = 0;
			boolean isJoint = false;
			
			// for 반복문을 사용해 각 플레이어가 받은 표의 수를 순회
			for (int idx = 1; idx < voteCounts.length; idx++) {
				
				/* 해당 플레이어가 받은 표의 수가 저장된 가장 많이 받은 표의 수보다 많은 경우
				가장 많이 받은 표의 수, 표를 가장 많이 받은 플레이어, 공동 최다 득표 존재 여부를 갱신 */
				if (voteCounts[idx] > maxCount) {
					maxCount = voteCounts[idx];
					maxPlayer = idx;
					isJoint = false;
					
				// 해당 플레이어가 받은 표의 수가 저장된 가장 많이 받은 표와 같은 경우 공동 최다 득표 존재 여부를 갱신
				} else if (voteCounts[idx] == maxCount) {
					isJoint = true;
				}
			}
			
			// 표를 가장 많이 받은 플레이어가 두 명 이상인 경우 'skipped'를 출력
			if (isJoint) {
				out.write("skipped");
				
			// 표를 가장 많이 받은 플레이어가 한 명인 경우 해당 플레이어의 번호를 출력
			} else {
				out.write(String.valueOf(maxPlayer));
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}