package gold3.num24620;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 각 수업에서 베시가 잠든 횟수의 누적 합을 저장할 배열 countSum 초기화
	static int[] countSum;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 수업의 수를 변수 classNum에 할당
			int classNum = Integer.parseInt(in.readLine());
			
			// 각 수업에서 베시가 잠든 횟수를 같게 만들 수 있는 최소 수정 횟수를 저장할 변수 minCount 초기화
			int minCount = Integer.MAX_VALUE;
			
			// 각 수업에서 베시가 잠든 횟수의 누적 합을 저장할 배열 countSum 초기화
			countSum = new int[classNum + 1];
			
			// 각 수업에서 베시가 잠든 횟수를 같게 만들 수 있는 각 횟수를 저장할 List 객체 intervals 초기화
			List<Integer> intervals = new ArrayList<>();
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 각 수업에서 베시가 잠든 횟수의 누적 합을 배열 countSum에 저장
			for (int idx = 1; idx < countSum.length; idx++)
				countSum[idx] = countSum[idx - 1] + Integer.parseInt(st.nextToken());
			
			// for 반복문을 사용해 베시가 잠든 전체 횟수의 가능한 약수를 순회
			for (int factor = 1; factor * factor <= countSum[classNum]; factor++) {
				
				// 해당 횟수가 전체 잠든 횟수의 약수가 아닌 경우 다음 횟수를 순회
				if (countSum[classNum] % factor != 0)
					continue;
				
				// add() 메서드를 사용해 베시가 잠든 횟수를 같게 만들 수 있는 횟수를 intervals에 저장
				intervals.add(factor);
				
				// 약수가 자기 자신을 곱했을 때 잠든 전체 횟수가 되는 경우 다음 횟수를 순회
				if (factor == countSum[classNum] / factor)
					continue;
				
				// add() 메서드를 사용해 베시가 잠든 횟수를 같게 만들 수 있는 횟수를 intervals에 저장
				intervals.add(countSum[classNum] / factor);
			}
			
			// for 반복문을 사용해 각 수업에서 베시가 잠든 횟수를 같게 만들 수 있는 각 횟수를 순회
			for (int interval : intervals) {
				
				// 베시가 잠든 횟수를 같게 만들 수 있는 최소 수정 횟수를 찾은 경우 반복문 탈출
				if (minCount == 1)
					break;
				
				// 해당 잠든 횟수로 수정이 불가능한 경우 다음 횟수를 순회
				if (countSum[classNum] / interval > classNum)
					continue;
				
				// 해당 잠든 횟수로 같게 만들 수 있는 경우 베시가 잠든 횟수를 같게 만들 수 있는 최소 수정 횟수를 갱신
				if (countModder(interval))
					minCount = Math.min(classNum - countSum[classNum] / interval, minCount);
			}
			
			// write() 메서드를 사용해 각 수업에서 베시가 잠든 횟수를 같게 만들 수 있는 최소 수정 횟수를 출력
			out.write((minCount == Integer.MAX_VALUE) ? 0 + "\n" : minCount + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// countModder() 메서드 정의
	public static boolean countModder(int interval) {
		
		// for 반복문을 사용해 각 수업에서 베시가 잠든 횟수의 누적 합을 순회
		for (int idx = 1, baseIdx = 0; idx < countSum.length; idx++) {
			
			// 잠든 횟수의 차이를 계산해 변수 difference에 할당
			int difference = countSum[idx] - countSum[baseIdx];
			
			// 입력 받은 잠든 횟수로 같게 만들 수 없는 경우 true를 반환
			if (difference > interval)
				return false;
			
			// 입력 받은 잠든 횟수의 간격보다 작은 경우 다음 횟수를 순회
			if (difference < interval)
				continue;
			
			// 기준이 되는 잠든 횟수를 갱신
			baseIdx = idx;
		}
		
		// 입력 받은 잠든 횟수로 같게 만들 수 있는 경우 true를 반환
		return true;
	}
}