package bronze4.num15080;

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
		
		// readLine() 및 timeCalculator() 메서드를 사용해 입력 받은 택시 운행의 시작 시각과 내린 시각을 초로 변환한 각 변수에 할당
		int startTime = timeCalculator(in.readLine());
		int endTime = timeCalculator(in.readLine());
		
		// 택시의 운행 시간을 계산해 변수 totalTime에 할당
		int totalTime = (startTime > endTime) ? endTime - startTime + 86400 : endTime - startTime;
		
		// valueOf() 및 write() 메서드를 사용해 택시의 운행 시간을 출력
		out.write(String.valueOf(totalTime));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// timeCalculator() 메서드 정의
	public static int timeCalculator(String timeString) {
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(timeString);
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 시간 문자열의 시, 분, 초를 각 변수에 할당
		int hours = Integer.parseInt(st.nextToken());
		st.nextToken();
		int minutes = Integer.parseInt(st.nextToken());
		st.nextToken();
		int seconds = Integer.parseInt(st.nextToken());
		
		// 해당 시간 문자열을 초로 변환한 결과를 반환
		return hours * 3600 + minutes * 60 + seconds;
	}
}