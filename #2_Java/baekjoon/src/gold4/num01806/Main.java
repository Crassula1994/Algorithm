package gold4.num01806;

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
		
		// StrintTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 수열의 길이 및 목표로 하는 부분합을 각 변수에 할당
		int length = Integer.parseInt(st.nextToken());
		int targetSum = Integer.parseInt(st.nextToken());
		
		// 입력 받은 수열의 누적 합을 저장할 배열 sequenceSum 초기화
		int[] sequenceSum = new int[length + 1];
		
		// StrintTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 수열의 누적합을 배열 sequenceSum에 저장
		for (int idx = 1; idx <= length; idx++)
			sequenceSum[idx] = sequenceSum[idx - 1] + Integer.parseInt(st.nextToken());
		
		// 목표로 하는 부분합 이상이 되는 최소의 길이를 저장할 변수 minLength 초기화
		int minLength = Integer.MAX_VALUE;
		
		// 각 부분합을 탐색하기 위해 필요한 인덱스 변수 초기화
		int start = 0;
		int end = 1;
		
		// while 반복문을 사용해 끝 인덱스가 배열의 끝에 도달할 때까지 순회
		while (end <= length) {
		
			// 각 구간의 부분 합을 변수 partialSum에 할당
			int partialSum = sequenceSum[end] - sequenceSum[start];
			
			// 해당 부분 합이 목표로 하는 부분 합보다 작은 경우 끝 인덱스를 조정
			if (partialSum < targetSum) {
				end++;
				
			// 해당 부분 합이 목표로 하는 부분 합보다 크거나 같은 경우
			} else {
				
				// min() 메서드를 사용해 목표로 하는 부분합 이상이 되는 최소의 길이를 갱신
				minLength = Math.min(end - start, minLength);
				
				// 시작 인덱스를 조정
				start++;
			}
		}
		
		// 목표로 하는 부분합 이상이 되는 부분합이 없는 경우 0을 출력
		if (minLength == Integer.MAX_VALUE) {
			out.write(String.valueOf(0));
			
		// 목표로 하는 부분합 이상이 되는 부분합이 있는 경우 목표로 하는 부분합 이상이 되는 최소의 길이를 출력
		} else {
			out.write(String.valueOf(minLength));
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}