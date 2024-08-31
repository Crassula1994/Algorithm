package bronze4.num05928;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 베시가 대회를 마친 각 시간을 각 변수에 할당
		int endDate = Integer.parseInt(st.nextToken());
		int endHour = Integer.parseInt(st.nextToken());
		int endMinute = Integer.parseInt(st.nextToken());
		
		// timeCalculator() 메서드를 호출해 대회를 시작한 시간과 마친 시간을 분으로 변환해 각 변수에 할당
		int startTime = timeCalculator(11, 11, 11);
		int endTime = timeCalculator(endDate, endHour, endMinute);
		
		// 베시가 대회에 투자한 총 시간을 계산해 변수 totalTime에 할당
		int totalTime = (startTime > endTime) ? -1 : endTime - startTime;
		
		// valueOf() 및 write() 메서드를 사용해 베시가 대회에 투자한 총 시간을 출력
		out.write(String.valueOf(totalTime));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// timeCalculator() 메서드 정의
	public static int timeCalculator(int date, int hour, int minute) {
		
		// 시간을 분으로 변환한 결과를 반환
		return (date - 11) * 1440 + hour * 60 + minute;
	}
}