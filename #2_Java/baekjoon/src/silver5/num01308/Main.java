package silver5.num01308;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 오늘의 연도, 월, 일을 각 변수에 저장
		int todayYear = Integer.parseInt(st.nextToken());
		int todayMonth = Integer.parseInt(st.nextToken());
		int todayDay = Integer.parseInt(st.nextToken());
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 D-Day의 연도, 월, 일을 각 변수에 저장
		int dDayYear = Integer.parseInt(st.nextToken());
		int dDayMonth = Integer.parseInt(st.nextToken());
		int dDayDay = Integer.parseInt(st.nextToken());
		
		// 캠프가 끝날 때까지 남은 기간이 천 년 이상인 경우 'gg'를 출력
		if (dDayYear > todayYear + 1000 ||
			(dDayYear == todayYear + 1000 && dDayMonth > todayMonth) || 
			(dDayYear == todayYear + 1000 && dDayMonth == todayMonth && dDayDay >= todayDay)) {
			out.write("gg");
			
		// 캠프가 끝날 때까지 남은 기간이 천 년 미만인 경우
		} else {
			
			// dateCalculator() 메서드를 호출해 각 날짜가 1년 1월 1일로부터 며칠째인지를 각 변수에 할당
			int today = dateCalculator(todayYear, todayMonth, todayDay);
			int dDay = dateCalculator(dDayYear, dDayMonth, dDayDay);
			
			// write() 메서드를 사용해 캠프가 끝날 때까지 남은 기간을 출력
			out.write("D-" + (dDay - today));
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// dateCalculator() 메서드 정의
	public static int dateCalculator(int year, int month, int day) {
		
		// 월별 날짜를 저장할 배열 monthDay 초기화
		int[] monthDay = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		// 해당 연도가 윤년인지, 1년 1월 1일로부터 며칠째인지를 저장할 각 변수 초기화
		boolean isLeap = ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) ? true : false;
		int count = 0;
		
		// for 반복문을 사용해 각 연도를 순회
		for (int y = 1; y < year; y++) {
			
			// 해당 연도가 윤년인 경우 366일을 더해 갱신
			if ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0) {
				count += 366;
			
			// 해당 연도가 윤년이 아닌 경우 365일을 더해 갱신
			} else {
				count += 365;
			}
		}
		
		// for 반복문을 사용해 각 월을 순회
		for (int m = 1; m < month; m++) {
			
			// 해당 월의 날짜를 더해 갱신
			count += monthDay[m];
			
			// 2월이고 윤년인 경우 하루를 더해 갱신
			if (isLeap && m == 2)
				count++;
		}
		
		// 일수를 더해 갱신
		count += day;
		
		// 1년 1월 1일로부터 며칠째인지를 반환
		return count;
	}
}