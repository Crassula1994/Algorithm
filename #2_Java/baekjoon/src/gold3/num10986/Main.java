package gold3.num10986;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 수열의 길이, 나누는 숫자, 나누는 숫자로 나누어 떨어지는 구간의 개수를 나타낼 각 변수 초기화
	static int length;
	static int divisor;
	static int count;
	
	// 각 숫자까지의 누적 합을 저장할 배열 sequenceSum 초기화
	static long[] sequenceSum;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 수열의 길이, 나누는 숫자를 각 변수에 할당
		length = Integer.parseInt(st.nextToken());
		divisor = Integer.parseInt(st.nextToken());
		
		// 각 숫자까지의 누적 합을 저장할 배열 sequenceSum 초기화
		sequenceSum = new long[length + 1];
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 수열의 각 숫자를 순회하며 누적 합을 갱신
		for (int idx = 1; idx <= length; idx++)
			sequenceSum[idx] = sequenceSum[idx - 1] + (Integer.parseInt(st.nextToken()) % divisor);
		
		// 나누는 숫자로 나누어 떨어지는 구간의 개수를 저장할 변수 count 초기화
		count = 0;
		
		// divisibleCounter() 메서드를 호출해 나누는 숫자로 나누어 떨어지는 구간의 개수를 갱신
		divisibleCounter(1);
		
		// valueOf() 및 write() 메서드를 사용해 나누는 숫자로 나누어 떨어지는 구간의 개수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// divisibleCounter() 메서드 정의
	public static void divisibleCounter(int startIdx) {
		
		// 
		
	}
}