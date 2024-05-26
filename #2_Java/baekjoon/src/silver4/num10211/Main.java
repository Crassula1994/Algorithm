package silver4.num10211;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 배열의 크기를 변수 size에 할당
			int size = Integer.parseInt(in.readLine());
			
			// 최대 부분 배열의 합을 저장할 변수 maxSum 초기화
			int maxSum = Integer.MIN_VALUE;
			
			// 입력 받은 배열의 누적 합을 저장할 배열 sum 초기화
			int[] sum = new int[size + 1];
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 배열의 누적 합을 배열 sum에 갱신
			for (int idx = 1; idx < sum.length; idx++)
				sum[idx] = sum[idx - 1] + Integer.parseInt(st.nextToken());
			
			// for 반복문을 사용해 각 부분 배열을 순회
			for (int start = 0; start < size; start++) {
				for (int end = start + 1; end <= size; end++) {
				
					// max() 메서드를 사용해 최대 부분 배열의 합을 갱신
					maxSum = Math.max(sum[end] - sum[start], maxSum);
				}
			}
			
			// write() 메서드를 사용해 최대 부분 배열의 합을 출력
			out.write(maxSum + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}