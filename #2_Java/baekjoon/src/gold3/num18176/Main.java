package gold3.num18176;

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
		
		// nextToken() 및 parseLong() 메서드를 사용해 스피커의 최소 및 최대 개수를 각 변수에 할당
		long minCount = Long.parseLong(st.nextToken());
		long maxCount = Long.parseLong(st.nextToken());
		
		// variabilityCounter() 메서드를 호출해 변동성의 합을 변수 sum에 할당
		long sum = variabilityCounter(maxCount) - variabilityCounter(minCount - 1);
		
		// valueOf() 및 write() 메서드를 사용해 변동성의 합을 출력
		out.write(String.valueOf(sum));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// variabilityCounter() 메서드 정의
	public static long variabilityCounter(long count) {
		
		// 변동성의 합을 저장할 변수 sum 초기화
		long sum = 0;
		
		// sqrt() 메서드를 사용해 탐색할 약수의 범위의 상한을 변수 upperLimit에 할당
		long upperLimit = (long) Math.sqrt(count);
		
		// for 반복문을 사용해 변동성의 합을 갱신
		for (long factor = 1; factor <= upperLimit; factor++)
			sum += count / factor;
		
		// 변동성의 합을 갱신
		sum = sum * 2 - upperLimit * upperLimit;
		
		// 변동성의 합을 반환
		return sum;
	}
}