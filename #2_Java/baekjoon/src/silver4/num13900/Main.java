package silver4.num13900;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받을 정수의 개수를 변수 numberCnt에 할당
		int numberCnt = Integer.parseInt(in.readLine());
		
		// 순서쌍의 곱의 합을 저장할 변수 productSum 초기화
		long productSum = 0;
		
		// 입력 받은 정수의 누적 합을 저장할 변수 numberSum 초기화
		long[] numberSum = new long[numberCnt + 1];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 각 정수를 순회
		for (int idx = 1; idx < numberSum.length; idx++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 정수를 변수 number에 할당
			int number = Integer.parseInt(st.nextToken());
			
			// 정수의 누적 합을 계산해 배열 numberSum에 저장
			numberSum[idx] = numberSum[idx - 1] + number;
			
			// 순서쌍의 곱의 합을 갱신
			productSum += numberSum[idx - 1] * number;
		}
		
		// valueOf() 및 write() 메서드를 사용해 순서쌍의 곱의 합을 출력
		out.write(String.valueOf(productSum));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}