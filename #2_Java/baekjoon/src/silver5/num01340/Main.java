package silver5.num01340;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 해당 연도가 윤년인지 여부를 나타낼 변수 isLeapYear 초기화
	static boolean isLeapYear;
	
	// 각 월의 일수를 저장할 배열 monthDays 초기화
	static int[] monthDays = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	// 각 월 정보를 저장할 Map 객체 months 초기화
	static Map<String, Integer> months = new HashMap<>();
	
	// put() 메서드를 사용해 각 월의 정보를 months에 저장
	static {
		months.put("January", 1);
		months.put("February", 2);
		months.put("March", 3);
		months.put("April", 4);
		months.put("May", 5);
		months.put("June", 6);
		months.put("July", 7);
		months.put("August", 8);
		months.put("September", 9);
		months.put("October", 10);
		months.put("November", 11);
		months.put("December", 12);
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 timeCalculator() 메서드를 사용해 입력 받은 오늘 날짜를 분 단위로 변환한 결과를 변수 curTime에 할당
		double curTime = timeCalculator(in.readLine());
		
		// 해당 연도의 총 시간을 분으로 변환한 결과를 변수 totalTime에 할당
		double totalTime = (isLeapYear) ? 366 * 24 * 60 : 365 * 24 * 60;
		
		// format() 및 write() 메서드를 사용해 해당 연도가 얼마나 지났는지를 % 단위로 출력
		out.write(String.format("%.15f", curTime * 100 / totalTime));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// timeCalculator() 메서드 정의
	public static int timeCalculator(String timeString) {
		
		// 오늘 날짜를 분 단위로 변환한 결과를 저장할 변수 curTime 초기화
		int curTime = 0;
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(timeString);
		
		// nextToken() 및 get() 메서드를 사용해 입력 받은 월의 정보를 변수 month에 할당
		int month = months.get(st.nextToken());
		
		// nextToken(), split(), parseInt() 메서드를 사용해 입력 받은 일과 연도의 정보를 각 변수에 할당
		int day = Integer.parseInt(st.nextToken().split(",")[0]);
		int year = Integer.parseInt(st.nextToken());
		
		// nextToken() 및 split() 메서드를 사용해 입력 받은 시간 정보를 배열 time에 저장
		String[] time = st.nextToken().split(":");
		
		// leapYearChecker() 메서드를 호출해 해당 연도가 윤년인지 여부를 갱신
		isLeapYear = leapYearChecker(year);
		
		// for 반복문을 사용해 각 월을 순회
		for (int m = 1; m < month; m++) {
			
			// 해당 월이 2월이고, 윤년인 경우 하루를 추가
			if (isLeapYear && m == 2)
				curTime++;
			
			// 해당 월에 해당하는 날짜를 curTime에 추가
			curTime += monthDays[m];
		}
		
		// 해당 일수를 curTime에 추가 후 분 단위로 변환
		curTime += day - 1;
		curTime *= 1440;
		
		// parseInt() 메서드를 사용해 해당 시간과 분의 정보를 curTime에 추가
		curTime += Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
		
		// 오늘 날짜를 분 단위로 변환한 결과를 반환
		return curTime;
	}
	
	// ----------------------------------------------------------------------------------------------------

	// leapYearChecker() 메서드 정의
	public static boolean leapYearChecker(int year) {
		
		// 해당 연도가 400으로 나누어 떨어지는 경우 true 반환
		if (year % 400 == 0)
			return true;
		
		// 해당 연도가 4로 나누어 떨어지면서 100으로 나누어 떨어지지 않는 경우 true 반환
		if (year % 4 == 0 && year % 100 != 0)
			return true;
		
		// 해당 연도가 윤년이 아닌 경우 false 반환
		return false;
	}
}