package level1.num012901;

// Solution 클래스 정의
public class Solution {

	// solution() 메서드 정의
	public static String solution(int a, int b) {
		
		// 각 달의 날짜와 각 요일의 이름을 저장할 각 배열 초기화
		int[] months = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		String[] days = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
		
		// 주어진 날짜를 일로 변환해 저장할 변수 date 초기화
		int date = b;
		
		// for 반복문을 사용해 각 달의 날짜를 더해 주어진 날짜를 일로 변환한 결과를 갱신
		for (int month = 1; month < a; month++)
			date += months[month];
		
		// 주어진 날짜의 요일의 이름을 반환
		return days[date % 7];
    }
}