package silver2.num11055;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 수열의 크기를 변수 length에 할당
		int length = Integer.parseInt(in.readLine());
		
		// 주어진 수열 및 해당 위치까지 가장 큰 증가하는 부분 수열의 합을 저장할 각 배열 초기화
		int[] sequence = new int[length + 1];
		int[] lisSum = new int[length + 1];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 배열 sequence의 각 원소에 숫자를 저장
		for (int idx = 1; idx <= length; idx++)
			sequence[idx] = Integer.parseInt(st.nextToken());
		
		// 가장 큰 증가하는 부분 수열의 합을 저장할 변수 maxSum 초기화
		int maxSum = Integer.MIN_VALUE;
		
		// for 반복문을 사용해 수열의 각 원소를 순회
		for (int idx = 1; idx <= length; idx++) {
			
			// 가장 큰 증가하는 부분 수열의 합을 초기화
			lisSum[idx] = sequence[idx];
			
			// for 반복문을 사용해 이전의 각 원소를 순회
			for (int prev = 1; prev < idx; prev++) {
			
				// 해당 값이 현재 값보다 작은 경우 가장 큰 증가하는 부분 수열의 합을 갱신
				if (sequence[prev] < sequence[idx])
					lisSum[idx] = Math.max(lisSum[prev] + sequence[idx], lisSum[idx]);

				maxLength = Math.max(lisLength[prev] + 1, maxLength);
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}