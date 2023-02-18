package silver3.num2559;

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

		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 각 날짜의 수를 각 변수에 할당
		int date = Integer.parseInt(st.nextToken());
		int length = Integer.parseInt(st.nextToken());
		
		// 온도의 수열을 저장할 배열 temperature 초기화
		int[] temperature = new int[date];

		// 가장 높은 온도의 합을 저장할 변수 maxTempSum 초기화
		int maxTempSum = Integer.MIN_VALUE;
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 각 날짜의 온도를 배열 temperature에 저장
		for (int idx = 0; idx < temperature.length; idx++)
			temperature[idx] = Integer.parseInt(st.nextToken());
		
		// for 반복문을 사용해 배열 temperature의 각 연속된 날짜를 순회
		for (int idx = 0, sum = 0; idx < date - length + 1; idx++) {
			
			// 수열의 첫 번째 연속 날짜인 경우
			if (idx == 0) {
				
				// for 반복문을 사용해 각 날짜의 온도 합을 계산
				for (int k = 0; k < length; k++)
					sum += temperature[k];
				
			// 수열의 첫 번째 연속 날짜가 아닌 경우
			} else {
				
				// 기존 수열에서 첫 값을 빼고 가장 마지막 값을 더해 온도 합 갱신
				sum -= temperature[idx - 1];
				sum += temperature[idx + length - 1];
			}
			
			// 저장된 가장 높은 온도의 합보다 온도 합이 높은 경우 가장 높은 온도의 합 갱신
			maxTempSum = (sum > maxTempSum) ? sum : maxTempSum;
		}

		// valueOf() 및 write() 메서드를 사용해 가장 높은 온도의 합을 출력
		out.write(String.valueOf(maxTempSum));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}