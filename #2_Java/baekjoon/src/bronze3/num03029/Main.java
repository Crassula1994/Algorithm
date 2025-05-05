package bronze3.num03029;

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
		
		// readLine() 및 timeCalculator() 메서드를 사용해 입력 받은 현재 시간과 나트륨을 던질 시간을 각 변수에 할당
		int curTime = timeCalculator(in.readLine());
		int targetTime = timeCalculator(in.readLine());
		
		// 나트륨을 던질 시간이 다음 날인 경우 나트륨을 던질 시간을 갱신
		if (curTime >= targetTime)
			targetTime += 86400;
		
		// timeStringMaker() 및 write() 메서드를 사용해 정인이가 기다려야 하는 시간을 출력
		out.write(timeStringMaker(targetTime - curTime));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// timeCalculator() 메서드 정의
	public static int timeCalculator(String timeString) {
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(timeString, ":");
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 시간의 시, 분, 초를 각 변수에 할당
		int hour = Integer.parseInt(st.nextToken());
		int minute = Integer.parseInt(st.nextToken());
		int second = Integer.parseInt(st.nextToken());
		
		// 해당 시간을 초로 변환한 결과를 반환
		return hour * 3600 + minute * 60 + second;
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// timeStringMaker() 메서드 정의
	public static String timeStringMaker(int time) {
		
		// 해당 시간의 시, 분, 초를 각 변수에 할당
		int hour = time / 3600;
		int minute = (time % 3600) / 60;
		int second = time % 60;
		
		// format() 메서드를 사용해 해당 시간을 문자열로 변환한 결과를 반환
		return String.format("%02d:%02d:%02d", hour, minute, second);
	}
}