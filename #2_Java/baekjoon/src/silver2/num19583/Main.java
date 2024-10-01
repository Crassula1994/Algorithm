package silver2.num19583;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
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
		
		/* nextToken() 및 timeCalculator() 메서드를 사용해 입력 받은 개강총회의 시작 시간 및 종료 시간,
		스트리밍이 끝난 시간을 각 변수에 할당 */
		int startTime = timeCalculator(st.nextToken());
		int endTime = timeCalculator(st.nextToken());
		int closeTime = timeCalculator(st.nextToken());
		
		// 입장과 퇴장이 확인된 학회원의 닉네임을 저장할 각 Set 객체 초기화
		Set<String> enterList = new HashSet<>();
		Set<String> exitList = new HashSet<>();		
		
		// 입력 받은 채팅 기록을 저장할 변수 chatLog 초기화
		String chatLog;
		
		// while 반복문을 사용해 각 채팅 기록을 순회
		while ((chatLog = in.readLine()) != null) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(chatLog);
			
			// nextToken() 및 timeCalculator() 메서드를 사용해 입력 받은 채팅 기록의 시간과 닉네임을 각 변수에 할당
			int logTime = timeCalculator(st.nextToken());
			String nickname = st.nextToken();
			
			// 스트리밍이 종료된 이후인 경우 반복문 탈출
			if (logTime > closeTime)
				break;
			
			// 입장 확인 시간인 경우 학회원의 닉네임을 enterList에 추가
			if (logTime <= startTime) {
				enterList.add(nickname);
				
			// 퇴장 확인 시간이고, 입장이 확인된 학회원인 경우 학회원의 닉네임을 exitList에 추가
			} else if (logTime >= endTime && enterList.contains(nickname)) {
				exitList.add(nickname);
			}
		}
		
		// size(), valueOf(), write() 메서드를 사용해 출석이 확인된 학회원의 인원 수를 출력
		out.write(String.valueOf(exitList.size()));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// timeCalculator() 메서드 정의
	public static int timeCalculator(String timeString) {
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(timeString, ":");
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 시와 분을 각 변수에 할당
		int hour = Integer.parseInt(st.nextToken());
		int minute = Integer.parseInt(st.nextToken());
		
		// 입력 받은 문자열을 분 단위 시간으로 바꾼 결과를 반환
		return hour * 60 + minute;
	}
}