package silver3.num12847;

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
		
		/* nextToken() 및 parseInt() 메서드를 사용해 입력 받은 월세를 내기 바로 전 날까지의 일자와
		일을 할 수 있는 기간을 각 변수에 할당 */
		int totalPeriod = Integer.parseInt(st.nextToken());
		int workingPeriod = Integer.parseInt(st.nextToken());
		
		// 준수가 일을 해서 벌 수 있는 최대 이익을 저장할 변수 maxWage 초기화
		long maxWage = 0;
		
		// 각 날짜의 일급 누적 합을 저장할 배열 wageSum 초기화
		long[] wageSum = new long[totalPeriod + 1];
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 날짜의 일급 누적 합을 갱신
		for (int idx = 1; idx < wageSum.length; idx++)
			wageSum[idx] = wageSum[idx - 1] + Integer.parseInt(st.nextToken());
		
		// for 반복문을 사용해 준수가 일을 해서 벌 수 있는 최대 이익을 갱신
		for (int start = 1; start <= totalPeriod - workingPeriod + 1; start++)
			maxWage = Math.max(wageSum[start + workingPeriod - 1] - wageSum[start - 1], maxWage);
		
		// valueOf() 및 write() 메서드를 사용해 준수가 일을 해서 벌 수 있는 최대 이익을 출력
		out.write(String.valueOf(maxWage));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}