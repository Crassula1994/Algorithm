package bronze1.num02435;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 전체 날짜의 수, 합을 구하기 위한 연속적인 날짜의 수를 각 변수에 할당
		int dayNum = Integer.parseInt(st.nextToken());
		int period = Integer.parseInt(st.nextToken());
		
		// 각 날짜별 온도를 저장할 배열 temperature 초기화
		int[] temperature = new int[dayNum];
		
		// 온도의 합 및 온도의 합이 최대가 되는 값을 저장할 각 변수 초기화
		int sum = 0;
		int maxSum = 0;
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 각 날짜별 온도를 순회
		for (int idx = 0; idx < temperature.length; idx++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 날짜의 온도를 배열 temperature에 저장
			temperature[idx] = Integer.parseInt(st.nextToken());
			
			// 첫 기간인 경우 온도의 합 및 온도의 합이 최대가 되는 값을 갱신
			if (idx < period) {
				sum += temperature[idx];
				maxSum += temperature[idx];
				
			// 첫 기간이 지난 경우
			} else {
				
				// 현재 온도의 합을 갱신
				sum += temperature[idx] - temperature[idx - period];
				
				// max() 메서드를 사용해 온도의 합이 최대가 되는 값을 갱신
				maxSum = Math.max(sum, maxSum);
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 온도의 합이 최대가 되는 값을 출력
		out.write(String.valueOf(maxSum));
				
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}