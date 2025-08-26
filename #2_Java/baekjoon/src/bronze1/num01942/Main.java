package bronze1.num01942;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 하루를 초로 바꾼 상수 DAY_SECONDS 초기화
	static final int DAY_SECONDS = 86400;
	
	// 각 구간의 시간 정수 중 3의 배수의 개수 누적 합을 저장할 배열 multipleSum 초기화
	static int[] multipleSum = new int[DAY_SECONDS + 1];
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// for 반복문을 사용해 하루 시간 중 중 3의 배수의 개수 누적 합을 갱신
		for (int time = 0; time < DAY_SECONDS; time++)
			multipleSum[time + 1] = multipleSum[time] + timeChecker(time);
		
		// for 반복문을 사용해 각 입력을 순회
		for (int input = 0; input < 3; input++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 timeConverter() 메서드를 사용해 시작하는 시각과 끝나는 시각을 초로 변환한 결과를 각 변수에 할당
			int startTime = timeConverter(st.nextToken());
			int endTime = timeConverter(st.nextToken());
			
			// 끝나는 시각이 하루를 넘어가는 경우 끝나는 시각을 갱신
			if (endTime < startTime)
				endTime += DAY_SECONDS;
			
			// 해당 입력의 구간에 포함되는 시계 정수들 중 3의 배수인 것의 개수를 계산해 변수 count에 할당
			int count = (endTime < DAY_SECONDS)
					? multipleSum[endTime + 1] - multipleSum[startTime]
					: multipleSum[DAY_SECONDS] - multipleSum[startTime] + multipleSum[endTime - DAY_SECONDS + 1];
			
			// write() 메서드를 사용해 해당 입력의 구간에 포함되는 시계 정수들 중 3의 배수인 것의 개수를 출력
			out.write(count + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// timeConverter() 메서드 정의
	public static int timeConverter(String timeString) {
		
		// 시간 문자열을 초로 변환한 결과를 저장할 변수 time 초기화
		int time = 0;
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(timeString, ":");
		
		// nextToken() 및 parseInt() 메서드를 사용해 시간 문자열을 초로 변환한 결과를 갱신
		time += Integer.parseInt(st.nextToken()) * 3600;
		time += Integer.parseInt(st.nextToken()) * 60;
		time += Integer.parseInt(st.nextToken());
		
		// 시간 문자열을 초로 변환한 결과를 반환
		return time;
	}
	
	// ----------------------------------------------------------------------------------------------------

	// timeChecker() 메서드 정의
	public static int timeChecker(int time) {
		
		// 현재 시간의 시, 분, 초 및 시간 정수를 각 변수에 할당
		int hour = time / 3600;
		int minute = time % 3600 / 60;
		int second = time % 60;
		int timeNumber = hour * 10000 + minute * 100 + second;
		
		// 해당 시간의 시간 정수에 대하여 3의 배수의 개수를 반환
		return (timeNumber % 3 == 0) ? 1 : 0;
	}
}