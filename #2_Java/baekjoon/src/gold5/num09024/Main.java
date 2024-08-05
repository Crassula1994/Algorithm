package gold5.num09024;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
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
			
			// gc() 메서드를 사용해 메모리 초기화
			System.gc();
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 정수의 개수 및 목표 합을 각 변수에 할당
			int numberCnt = Integer.parseInt(st.nextToken());
			int targetSum = Integer.parseInt(st.nextToken());
			
			// 조합할 두 정수의 위치, 목표 합과 가장 가까운 합 및 그 조합의 개수를 저장할 각 변수 초기화
			int low = 0;
			int high = numberCnt - 1;
			int approxSum = Integer.MAX_VALUE;
			int count = 1;
			
			// 입력 받은 정수를 저장할 배열 numbers 초기화
			int[] numbers = new int[numberCnt];
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 입력 받은 정수를 배열 numbers에 저장
			for (int idx = 0; idx < numbers.length; idx++)
				numbers[idx] = Integer.parseInt(st.nextToken());
			
			// sort() 메서드를 사용해 입력 받은 정수를 오름차순 정렬
			Arrays.sort(numbers);
			
			// while 반복문을 사용해 각 숫자 조합을 찾을 수 있을 때까지 순회
			while (low < high) {
				
				// abs() 메서드를 사용해 숫자 조합의 합과 목표 합의 차이를 각 변수에 할당
				int sum = numbers[low] + numbers[high];
				int difference = Math.abs(targetSum - sum);
				
				// 숫자 조합의 합이 저장된 목표 합과 가장 가까운 합보다 더 가까운 경우
				if (difference < approxSum) {
					
					// 목표 합과 가장 가까운 합 및 그 조합의 개수를 갱신
					approxSum = difference;
					count = 1;
					
				// 숫자 조합의 합이 저장된 목표 합과 가장 가까운 합과 같은 경우 그 조합의 개수를 갱신
				} else if (difference == approxSum) {
					count++;
				}
				
				// 숫자 조합의 합이 목표 합보다 작은 경우 작은 숫자를 갱신
				if (sum < targetSum) {
					low++;
					
				// 숫자 조합의 합이 목표 합보다 큰 경우 큰 숫자를 갱신
				} else if (sum > targetSum) {
					high--;
					
				// 숫자 조합의 합이 목표 합과 같은 경우 모든 숫자를 갱신
				} else {
					low++;
					high--;
				}
			}
			
			// write() 메서드를 사용해 목표 합과 가장 가까운 두 정수 조합의 개수를 출력
			out.write(count + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}