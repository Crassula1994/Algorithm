package gold5.num25827;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 질의의 개수를 변수 queryNum에 할당
		int queryNum = Integer.parseInt(in.readLine());
		
		// 유형 2의 질의가 나왔는지 여부를 나타낼 변수 isCategory2 초기화
		boolean isCategory2 = false;
		
		// 1을 더한 구간의 각 위치와 전체 시간 구간의 누적 합을 저장할 각 배열 초기화
		int[] time = new int[86401];
		long[] timeSum = new long[86401];
		
		// for 반복문을 사용해 각 질의를 순회
		for (int query = 0; query < queryNum; query++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken(), parseInt(), timeCalculator() 메서드를 사용해 입력 받은 질의의 유형 및 시간 구간을 각 변수에 할당
			int category = Integer.parseInt(st.nextToken());
			int startTime = timeCalculator(st.nextToken());
			int endTime = timeCalculator(st.nextToken());
			
			// 유형 1의 질의인 경우 1을 추가한 구간의 시작과 끝 위치에 1을 추가한 횟수를 갱신
			if (category == 1) {
				time[startTime + 1]++;
				time[endTime + 1]--;
				
			// 유형 2의 질의인 경우
			} else {
				
				// 유형 2의 질의가 처음 나온 경우
				if (!isCategory2) {
					
					// 유형 2의 질의가 나왔는지 여부를 갱신
					isCategory2 = true;
					
					// for 반복문을 사용해 각 초에서의 누적 합을 갱신
					for (int idx = 1; idx < timeSum.length; idx++) {
						time[idx] += time[idx - 1];
						timeSum[idx] = timeSum[idx - 1] + time[idx];
					}
				}
				
				// write() 메서드를 사용해 해당 시간 구간의 합을 출력
				out.write((timeSum[endTime] - timeSum[startTime]) + "\n");
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// timeCalculator() 메서드 정의
	public static int timeCalculator(String timeString) {
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(timeString, ":");
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 시간의 시, 분, 초를 각 변수에 할당
		int hours = Integer.parseInt(st.nextToken());
		int minutes = Integer.parseInt(st.nextToken());
		int seconds = Integer.parseInt(st.nextToken());
		
		// 해당 시간을 초로 변환하여 반환
		return hours * 3600 + minutes * 60 + seconds;
	}
}