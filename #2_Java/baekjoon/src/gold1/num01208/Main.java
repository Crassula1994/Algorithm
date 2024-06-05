package gold1.num01208;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 목표로 하는 값을 저장할 각 변수 초기화
	static int targetValue;
	static long count = 0;
	
	// 수열의 원소를 저장할 배열 sequence 초기화
	static int[] sequence;
	
	// 수열을 두 개의 부분 수열로 나누어 각 수열의 원소 합을 저장할 각 List 객체 초기화
	static List<Integer> subSequenceA;
	static List<Integer> subSequenceB;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 수열의 원소 개수와 목표로 하는 값을 각 변수에 할당
		int size = Integer.parseInt(st.nextToken());
		targetValue = Integer.parseInt(st.nextToken());
		
		// 해당 수열의 원소를 저장할 배열 sequence 초기화
		sequence = new int[size];
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 수열의 원소를 배열 sequence에 저장
		for (int idx = 0; idx < sequence.length; idx++)
			sequence[idx] = Integer.parseInt(st.nextToken());
		
		// 수열을 두 개의 부분 수열로 나누어 각 수열의 원소 합을 저장할 각 List 객체 초기화
		subSequenceA = new ArrayList<>();
		subSequenceB = new ArrayList<>();
		
		// sumCalculator() 메서드를 호출해 각 부분 수열의 합을 갱신
		sumCalculator(0, size / 2, 0, subSequenceA);
		sumCalculator(size / 2, size, 0, subSequenceB);
		
		// sort() 메서드를 사용해 두 부분 수열의 각 원소의 합을 오름차순으로 정렬
		Collections.sort(subSequenceA);
		Collections.sort(subSequenceB);
		
		// targetFinder() 메서드를 호출해 합이 목표 값이 되는 부분수열의 개수를 갱신
		targetFinder();
		
		// valueOf() 및 write() 메서드를 사용해 합이 목표 값이 되는 부분수열의 개수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// sumCalculator() 메서드 정의
	public static void sumCalculator(int start, int end, int sum, List<Integer> subSequence) {
		
		// 모든 원소를 확인한 경우
		if (start == end) {
			
			// add() 메서드를 사용해 해당 부분 수열의 합을 주어진 List 객체에 추가 후 메서드 종료
			subSequence.add(sum);
			return;
		}
		
		// 해당 원소를 합한 경우와 합하지 않은 경우를 상정해 sumCalculator() 메서드 재귀 호출
		sumCalculator(start + 1, end, sum + sequence[start], subSequence);
		sumCalculator(start + 1, end, sum, subSequence);
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// targetFinder() 메서드 정의
	public static void targetFinder() {
		
		// 첫 번째 부분수열과 두 번째 부분수열 합의 인덱스를 나타낼 각 변수 초기화
		int left = 0;
		int right = subSequenceB.size() - 1;
		
		// while 반복문을 사용해 두 부분수열의 합 중 하나의 부분수열의 합을 모두 확인할 때까지 순회
		while (left < subSequenceA.size() && right >= 0) {
			
			// get() 메서드를 사용해 두 부분수열의 각 원소의 값을 각 변수에 할당
			int sumA = subSequenceA.get(left);
			int sumB = subSequenceB.get(right);
			
			// 두 부분수열의 합을 계산하고 변수 sum에 할당
			int sum = sumA + sumB;
			
			// 해당 합이 목표로 하는 값보다 작은 경우 첫 번째 부분수열 합의 인덱스를 갱신
			if (sum < targetValue) {
				left++;
			
			// 해당 합이 목표로 하는 값보다 큰 경우 두 번째 부분수열 합의 인덱스를 갱신
			} else if (sum > targetValue) {
				right--;
				
			// 해당 합이 목표로 하는 값과 같은 경우
			} else {
				
				// 첫 번째 부분수열과 두 번째 부분수열에서 같은 합을 지닌 원소의 개수를 저장할 각 변수 초기화
				long countA = 0;
				long countB = 0;
				
				// while 반복문을 사용해 첫 번째 부분수열에서 해당 값과 같은 값이 있는지 순회
				while (left < subSequenceA.size() && subSequenceA.get(left) == sumA) {
					
					// 첫 번째 부분수열 합의 인덱스를 갱신
					left++;
					
					// 첫 번째 부분수열에서 같은 합을 지닌 원소의 개수를 갱신
					countA++;
				}
				
				// while 반복문을 사용해 두 번째 부분수열에서 해당 값과 같은 값이 있는지 순회
				while (right >= 0 && subSequenceB.get(right) == sumB) {
					
					// 두 번째 부분수열 합의 인덱스를 갱신
					right--;
					
					// 두 번째 부분수열에서 같은 합을 지닌 원소의 개수를 갱신
					countB++;
				}
				
				// 합이 목표 값이 되는 부분수열의 개수를 갱신
				count += countA * countB;
			}
		}
		
		// 목표로 하는 값이 0인 경우 공집합을 제외
		if (targetValue == 0)
			count--;
	}
}