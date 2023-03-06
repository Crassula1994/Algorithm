package silver2.num01912;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {

	// 각 수열의 숫자를 저장할 배열 및 해당 인덱스까지의 최대 연속 합을 저장할 배열 초기화
	static int[] sequence;
	static Integer[] summation;

	// 연속 합 중에서 최댓값을 저장할 변수 maxSum 초기화
	static int maxSum;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 수열의 숫자 개수를 변수 length에 할당
		int length = Integer.parseInt(in.readLine());
		
		// 각 수열의 숫자를 저장할 배열 sequence 초기화
		sequence = new int[length];
		
		// 해당 인덱스까지의 최대 연속 합을 저장할 배열 summation 초기화
		summation = new Integer[length];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 숫자를 배열 sequence에 저장
		for (int idx = 0; idx < sequence.length; idx++)
			sequence[idx] = Integer.parseInt(st.nextToken());
		
		// 연속 합의 가장 처음 값 및 연속 합 중 최댓값을 초기화
		summation[0] = sequence[0];
		maxSum = sequence[0];

		// maxSumFinder() 메서드를 호출해 배열 maxSum의 각 원소를 갱신
		maxSumFinder(length - 1);
		
		// valueOf() 및 write() 메서드를 사용해 연속 합 중 최댓값을 출력
		out.write(String.valueOf(maxSum));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// maxSumFinder() 메서드 정의
	public static int maxSumFinder(int index) {
		
		// 최댓값이 저장되어 있는 경우 저장된 값 반환
		if (summation[index] != null) {
			return summation[index];
		
		// 최댓값이 저장되어 있지 않은 경우
		} else {
			
			// maxSumFinder() 메서드를 재귀 호출해 현재 값을 이전 최댓값에 더했을 때와 현재 값을 비교해 더 큰 값을 배열 summation에 저장
			summation[index] = Math.max(maxSumFinder(index - 1) + sequence[index], sequence[index]);
			
			// 해당 연속 합이 최대일 경우 최대 연속 합을 갱신
			maxSum = (summation[index] > maxSum) ? summation[index] : maxSum;
			
			// 계산한 연속 합을 반환
			return summation[index];
		}
	}
}