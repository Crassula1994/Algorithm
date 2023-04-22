package bronze4.num02530;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 현재 시각을 각 변수에 할당
		int currentHour = Integer.parseInt(st.nextToken());
		int currentMinute = Integer.parseInt(st.nextToken());
		int currentSecond = Integer.parseInt(st.nextToken());
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 요리하는 데 필요한 시간을 변수 requiredTime에 할당
		int requiredTime = Integer.parseInt(in.readLine());
		
		// 요리하는 데 필요한 시간을 현재 시각에 합산해 종료 시각을 나타내는 각 변수에 할당
		int endHour = currentHour + (requiredTime / 3600);
		requiredTime %= 3600;
		int endMinute = currentMinute + (requiredTime / 60);
		requiredTime %= 60;
		int endSecond = currentSecond + requiredTime;
		
		// 60초를 초과하는 경우 종료 시각 갱신
		if (endSecond >= 60) {
			endSecond %= 60;
			endMinute++;
		}
		
		// 60분을 초과하는 경우 종료 시각 갱신
		if (endMinute >= 60) {
			endMinute %= 60;
			endHour++;
		}
		
		// 24시간을 초과하는 경우 종료 시각 갱신
		if (endHour >= 24)
			endHour %= 24;
			
		// write() 메서드를 사용해 요리가 완성되는 종료 시각을 출력
		out.write(endHour + " " + endMinute + " " + endSecond);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}