package gold5.num02470;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 전체 용액의 수를 변수 solutionNum에 할당
		int solutionNum = Integer.parseInt(in.readLine());
		
		// 각 용액의 특성값을 저장할 배열 pHIndex 초기화
		int[] pHIndex = new int[solutionNum];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 용액의 특성값을 배열 pHIndex에 저장
		for (int idx = 0; idx < solutionNum; idx++)
			pHIndex[idx] = Integer.parseInt(st.nextToken());
		
		// sort() 메서드를 사용해 배열 pHIndex를 오름차순으로 정렬
		Arrays.sort(pHIndex);
		
		// 0에 가장 가까운 용액의 특성값의 합, 해당 합을 구성하는 각 용액의 인덱스를 저장할 각 변수 초기화
		int minStart = 0;
		int minEnd = solutionNum - 1;
		int minDiff = Math.abs(pHIndex[minStart] + pHIndex[minEnd]);
		
		// 각 용액의 쌍을 탐색하기 위해 필요한 인덱스 변수 초기화
		int start = 0;
		int end = solutionNum - 1;
		
		// while 반복문을 사용해 시작 인덱스와 끝 인덱스가 교차할 때까지 순회
		while (start < end) {
		
			// 각 용액 쌍의 특성값 합을 변수 sum에 할당
			int sum = pHIndex[start] + pHIndex[end];
			
			// 특성값의 합이 현재 저장된 0에 가장 가까운 용액의 특성값의 합보다 작은 경우
			if (Math.abs(sum) < minDiff) {
				
				// 0에 가장 가까운 용액의 특성값의 합을 갱신
				minDiff = Math.abs(sum);
				minStart = start;
				minEnd = end;
				
				// 특성값의 합이 0인 경우 반복문 탈출
				if (sum == 0)
					break;
			}
			
			// 각 쌍의 특성값 합이 0보다 작은 경우 시작 인덱스를 조정
			if (sum < 0) {
				start++;

			// 각 쌍의 특성값 합이 0보다 큰 경우 끝 인덱스를 조정
			} else {
				end--;
			}
		}
		
		// write() 메서드를 사용해 0에 가장 가까운 용액의 특성값을 지니는 경우를 출력
		out.write(pHIndex[minStart] + " " + pHIndex[minEnd]);

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}