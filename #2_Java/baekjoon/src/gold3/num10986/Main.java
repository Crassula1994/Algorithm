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
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 수열의 길이, 제수를 각 변수에 할당
		int length = Integer.parseInt(st.nextToken());
		int divisor = Integer.parseInt(st.nextToken());
		
		// 각 숫자까지의 누적 합을 제수로 나눈 나머지와 해당 나머지의 개수를 저장할 각 배열 초기화
		long[] sumRemain = new long[length + 1];
		long[] remainCnt = new long[divisor];
		
		// 제수로 나누어 떨어지는 구간의 개수를 저장할 변수 totalCnt 초기화
		long totalCnt = 0;
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 수열의 각 숫자를 순회
		for (int idx = 1; idx <= length; idx++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 배열 sumRemain에 누적 합을 제수로 나눈 나머지를 저장
			sumRemain[idx] = (sumRemain[idx - 1] + Integer.parseInt(st.nextToken())) % divisor;
			
			// 제수로 나눈 나머지가 0인 경우 제수로 나누어 떨어지는 구간의 개수를 갱신
			if (sumRemain[idx] == 0)
				totalCnt++;
			
			// 해당 나머지의 개수를 갱신
			remainCnt[(int) sumRemain[idx]]++;
		}

		// for 반복문을 사용해 배열 remainCnt의 각 원소를 순회
		for (int idx = 0; idx < remainCnt.length; idx++) {
			
			// 해당 구간의 개수가 1개 이하인 경우 다음 원소를 순회
			if (remainCnt[idx] < 2)
				continue;
			
			// 제수로 나누어 떨어지는 구간의 개수를 갱신
			totalCnt += (remainCnt[idx] * (remainCnt[idx] - 1)) / 2;
		}
		
		// valueOf() 및 write() 메서드를 사용해 제수로 나누어 떨어지는 구간의 개수를 출력
		out.write(String.valueOf(totalCnt));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}