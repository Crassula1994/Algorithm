package bronze2.num18312;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 마지막 시각의 시간 및 포함되야 하는 숫자를 각 변수에 할당
		int endHour = Integer.parseInt(st.nextToken());
		int targetDigit = Integer.parseInt(st.nextToken());
		
		// 포함되어야 하는 숫자가 포함된 시각의 수를 저장할 변수 timeCount 초기화
		int timeCount = 0;
		
		// for 반복문을 사용해 각 시각의 시간을 순회
		for (int hours = 0; hours <= endHour; hours++) {
			
			// 해당 시간에 포함되어야 하는 숫자가 포함된 경우 포함되어야 하는 숫자가 포함된 시각의 수를 갱신 후 다음 시간을 순회
			if (timeChecker(hours, targetDigit)) {
				timeCount += 3600;
				continue;
			}
			
			// for 반복문을 사용해 각 시각의 분을 순회
			for (int minutes = 0; minutes < 60; minutes++) {
				
				// 해당 분에 포함되어야 하는 숫자가 포함된 경우 포함되어야 하는 숫자가 포함된 시각의 수를 갱신 후 다음 분을 순회
				if (timeChecker(minutes, targetDigit)) {
					timeCount += 60;
					continue;
				}
				
				// for 반복문을 사용해 각 시간의 초를 순회
				for (int seconds = 0; seconds < 60; seconds++) {
					
					// 해당 초에 포함되어야 하는 숫자가 포함된 경우 포함되어야 하는 숫자가 포함된 시각의 수를 갱신
					if (timeChecker(seconds, targetDigit))
						timeCount++;
				}
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 포함되어야 하는 숫자가 포함된 시각의 수를 출력
		out.write(String.valueOf(timeCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// timeChecker() 메서드 정의
	public static boolean timeChecker(int timeElement, int targetDigit) {
		
		// 해당 시각에 포함되어야 하는 숫자가 포함되어 있는지 여부를 반환
		return timeElement / 10 == targetDigit || timeElement % 10 == targetDigit;
	}
}