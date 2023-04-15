package silver2.num01182;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 수열의 길이 및 목표로 하는 부분합, 목표로 하는 부분합이 되는 부분수열의 개수를 나타낼 각 변수 초기화
	static int length;
	static int targetSum;
	static int count = 0;
	
	// 입력 받은 수열을 저장할 배열 sequence 초기화
	static int[] sequence;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StrintTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 수열의 길이 및 목표로 하는 부분합을 각 변수에 할당
		length = Integer.parseInt(st.nextToken());
		targetSum = Integer.parseInt(st.nextToken());
		
		// 입력 받은 수열을 저장할 배열 sequence 초기화
		sequence = new int[length];
		
		// StrintTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 수열의 각 수를 배열 sequence에 저장
		for (int idx = 0; idx < length; idx++)
			sequence[idx] = Integer.parseInt(st.nextToken());
		
		// sequenceFinder() 메서드를 호출해 각 목표로 하는 부분합이 되는 부분수열의 개수를 갱신
		sequenceFinder(0, 0);
		
		// 목표로 하는 부분합이 0인 경우 아무 것도 선택하지 않은 경우를 제거
		if (targetSum == 0)
			count--;
		
		// valueOf() 및 write() 메서드를 사용해 목표로 하는 부분합이 되는 부분수열의 개수를 출력
		out.write(String.valueOf(count));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// sequenceFinder() 메서드 정의
	public static void sequenceFinder(int startIdx, int sum) {
		
		// 마지막 원소에 도달한 경우
		if (startIdx == length) {
			
			// 해당 부분수열의 합이 목표로 하는 부분합인 경우 변수 count를 갱신
			if (sum == targetSum)
				count++;
			
			// 메서드 종료
			return;
		}

		// 해당 위치의 숫자를 선택한 경우와 선택하지 않은 경우를 상정해 sequenceFinder() 메서드 재귀 호출
		sequenceFinder(startIdx + 1, sum + sequence[startIdx]);
		sequenceFinder(startIdx + 1, sum);
	}
}