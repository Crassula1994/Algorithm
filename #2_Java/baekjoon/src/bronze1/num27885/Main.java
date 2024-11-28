package bronze1.num27885;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 상행 열차와 하행 열차의 수를 각 변수에 할당
		int upTrainCnt = Integer.parseInt(st.nextToken());
		int downTrainCnt = Integer.parseInt(st.nextToken());
		
		// 산성대로 건널목의 차단기가 올라가 있는 시간을 저장할 변수 offTime 초기화
		int offTime = 86400;
		
		// 상행 열차와 하행 열차의 건널목 접근 시간을 저장할 배열 trains 초기화
		int[] trains = new int[upTrainCnt + downTrainCnt];
		
		// for 반복문을 사용해 각 상행 열차의 건널목 접근 시간을 배열 trains에 저장
		for (int idx = 0; idx < upTrainCnt; idx++)
			trains[idx] = timeCalculator(in.readLine());
		
		// for 반복문을 사용해 각 하행 열차의 건널목 접근 시간을 배열 trains에 저장
		for (int idx = upTrainCnt; idx < upTrainCnt + downTrainCnt; idx++)
			trains[idx] = timeCalculator(in.readLine());
		
		// sort() 메서드를 사용해 각 열차의 건널목 접근 시간을 오름차순으로 정렬
		Arrays.sort(trains);
		
		// for 반복문을 사용해 각 열차를 순회
		for (int idx = 0; idx < trains.length; idx++) {
			
			// 상행 열차와 하행 열차가 겹치지 않는 경우 차단기가 올라가 있는 시간을 갱신
			if (idx == trains.length - 1 || trains[idx] + 40 < trains[idx + 1]) {
				offTime -= 40;
				
			// 상행 열차와 하행 열차가 겹치는 경우 차단기가 올라가 있는 시간을 갱신
			} else {
				offTime -= trains[idx + 1] - trains[idx];
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 산성대로 건널목의 차단기가 올라가 있는 시간을 출력
		out.write(String.valueOf(offTime));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// timeCalculator() 메서드 정의
	public static int timeCalculator(String timeStr) {
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(timeStr, ":");
		
		// nextToken() 및 parseInt() 메서드를 사용해 해당 열차의 시, 분, 초를 각 변수에 할당
		int hours = Integer.parseInt(st.nextToken());
		int minutes = Integer.parseInt(st.nextToken());
		int seconds = Integer.parseInt(st.nextToken());
		
		// 해당 시간 문자열을 초로 변환한 결과를 반환
		return hours * 3600 + minutes * 60 + seconds;
	}
}