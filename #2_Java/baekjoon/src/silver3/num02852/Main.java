package silver3.num02852;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 골이 들어간 횟수를 변수 goalNum에 할당
		int goalNum = Integer.parseInt(in.readLine());
		
		// 각 팀의 득점, 마지막 득점 시각, 각 팀이 이기고 있던 시간을 저장할 각 변수 초기화
		int prevScore1 = 0;
		int prevScore2 = 0;
		int prevTime = 0;
		int winningTime1 = 0;
		int winningTime2 = 0;
		
		// for 반복문을 사용해 각 골을 순회
		for (int goal = 0; goal < goalNum; goal++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 득점한 팀의 번호와 득점한 시간을 각 변수에 할당
			int team = Integer.parseInt(st.nextToken());
			StringTokenizer timeString = new StringTokenizer(st.nextToken(), ":");
			int minutes = Integer.parseInt(timeString.nextToken());
			int seconds = Integer.parseInt(timeString.nextToken());
			
			// 각 팀의 새로운 득점을 갱신하고, 득점 시간을 초로 변환해 각 변수에 할당
			int curScore1 = (team == 1) ? prevScore1 + 1 : prevScore1;
			int curScore2 = (team == 1) ? prevScore2 : prevScore2 + 1;
			int curTime = minutes * 60 + seconds;
			
			// 이전까지 동점이었던 경우 마지막 득점 시각을 갱신
			if (prevScore1 == prevScore2) {
				prevTime = curTime;
				
			// 득점 후 동점이 되는 경우 각 팀이 이기고 있던 시간을 갱신
			} else if (curScore1 == curScore2) {
				winningTime1 = (prevScore1 < prevScore2) ? winningTime1 : winningTime1 + curTime - prevTime;
				winningTime2 = (prevScore1 < prevScore2) ? winningTime2 + curTime - prevTime : winningTime2;
			}
			
			// 각 팀의 득점을 갱신
			prevScore1 = curScore1;
			prevScore2 = curScore2;
		}
		
		// 경기가 끝났을 때 각 팀이 이기고 있던 시간을 갱신
		if (prevScore1 != prevScore2) {
			winningTime1 = (prevScore1 < prevScore2) ? winningTime1 : winningTime1 + 2880 - prevTime;
			winningTime2 = (prevScore1 < prevScore2) ? winningTime2 + 2880 - prevTime : winningTime2;
		}
		
		// timeConverter() 메서드를 호출해 각 팀이 이기고 있던 시간을 문자열 형식으로 출력
		out.write(timeConverter(winningTime1) + "\n" + timeConverter(winningTime2));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// timeConverter() 메서드 정의
	public static String timeConverter(int winningTime) {
		
		// 이기고 있던 시간을 분과 초로 나누어 각 변수에 할당
		int minutes = winningTime / 60;
		int seconds = winningTime % 60;
		
		// format() 메서드를 사용해 입력 받은 시간을 문자열로 변환한 결과를 반환
		return String.format("%02d", minutes) + ":" + String.format("%02d", seconds);
	}
}