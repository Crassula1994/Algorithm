package bronze1.num01924;

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
		
		// 요일 및 달마다의 날짜를 저장할 각 배열 초기화
		String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
		int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 날짜의 달을 변수 targetMonth에 할당
		int targetMonth = Integer.parseInt(st.nextToken());

		// nextToken() 및 parseInt() 메서드를 사용해 해당 날짜까지의 날짜의 합을 저장할 변수 daySum 초기화
		int daySum = Integer.parseInt(st.nextToken());
		
		// for 반복문을 사용해 입력 받은 달 이전까지의 날짜를 daySum에 추가
		for (int idx = 1; idx < targetMonth; idx++)
			daySum += months[idx];
		
		// 해당 날짜의 요일을 계산해 변수 answer에 할당
		String answer = days[daySum % 7];
		
		// write() 메서드를 사용해 해당 날짜의 요일을 출력
		out.write(answer);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}