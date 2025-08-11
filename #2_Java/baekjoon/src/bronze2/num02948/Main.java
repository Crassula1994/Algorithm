package bronze2.num02948;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 각 달의 날 수와 요일의 순서를 저장할 각 배열 초기화
	static int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	static String[] dayOfWeeks = {"Wednesday", "Thursday", "Friday", "Saturday", "Sunday", "Monday", "Tuesday"};
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 일과 월을 각 변수에 할당
		int targetDay = Integer.parseInt(st.nextToken());
		int targetMonth = Integer.parseInt(st.nextToken());
		
		// 현재 날짜를 일수로 저장할 변수 today 초기화
		int today = targetDay;
		
		// for 반복문을 사용해 각 달의 날을 현재 날짜에 갱신
		for (int m = 0; m < targetMonth - 1; m++)
			today += months[m];
		
		// write() 메서드를 사용해 현재 날짜의 요일을 출력
		out.write(dayOfWeeks[today % 7]);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}