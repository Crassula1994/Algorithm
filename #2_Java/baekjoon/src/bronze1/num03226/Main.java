package bronze1.num03226;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 상근이가 건 전화의 수를 변수 callNum에 할당
		int callNum = Integer.parseInt(in.readLine());
		
		// 총 전화 요금을 저장할 변수 totalCost 초기화
		int totalCost = 0;
		
		// while 반복문을 사용해 상근이가 건 각 전화를 순회
		while (callNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 전화를 건 시간과 통화 시간을 각 변수에 할당
			int startTime = timeConverter(st.nextToken());
			int duration = Integer.parseInt(st.nextToken());
			
			// costCalculator() 메서드를 호출해 총 전화 요금을 갱신
			totalCost += costCalculator(startTime, startTime + duration, duration);
		}
		
		// valueOf() 및 write() 메서드를 사용해 총 전화 요금을 출력
		out.write(String.valueOf(totalCost));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// timeConverter() 메서드 정의
	public static int timeConverter(String timeString) {
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(timeString, ":");
		
		// nextToken() 및 parseInt() 메서드를 사용해 시간 문자열을 분으로 변환한 결과를 반환
		return Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
	}
	
	// ----------------------------------------------------------------------------------------------------

	// costCalculator() 메서드 정의
	public static int costCalculator(int startTime, int endTime, int duration) {
		
		// 야간 요금만을 적용 받는 경우 전화 요금을 계산해 변환
		if (endTime <= 420 || startTime >= 1140)
			return duration * 5;
		
		// 주간 요금만을 적용 받는 경우 전화 요금을 계산해 반환
		if (startTime >= 420 && endTime <= 1140)
			return duration * 10;
		
		// max() 및 min() 메서드를 사용해 야간과 주간에 해당하는 각 통화 시간을 각 변수에 할당
		int nightTime = Math.max(420 - startTime, 0) + Math.max(endTime - 1140, 0);
		int dayTime = Math.min(endTime, 1140) - Math.max(startTime, 420);
		
		// 전화 요금을 계산해 반환
		return nightTime * 5 + dayTime * 10;
	}
}