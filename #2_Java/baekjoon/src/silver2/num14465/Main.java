package silver2.num14465;

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
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		/* nextToken() 및 parseInt() 메서드를 사용해 입력 받은 횡단보도의 수,
		목표로 하는 연속한 신호등의 수, 망가진 신호등의 수를 각 변수에 할당 */
		int crosswalkNum = Integer.parseInt(st.nextToken());
		int targetCnt = Integer.parseInt(st.nextToken());
		int breakdownCnt = Integer.parseInt(st.nextToken());
		
		// 수리해야 하는 신호등의 최소 개수 및 현재 수리한 신호등의 개수를 저장할 각 변수 초기화
		int minCount = Integer.MAX_VALUE;
		int count = 0;
		
		// 각 신호등의 고장 여부를 저장할 배열 isBreakdown 초기화
		boolean[] isBreakdown = new boolean[crosswalkNum + 1];
		
		// while 반복문을 사용해 망가진 신호등
		while (breakdownCnt-- > 0)
			isBreakdown[Integer.parseInt(in.readLine())] = true;
		
		// for 반복문을 사용해 각 목표로 하는 연속한 신호등의 수의 길이를 순회
		for (int start = 1; start <= crosswalkNum - targetCnt + 1; start++) {
			
			// 첫 연속한 신호등인 경우
			if (start == 1) {
				
				// for 반복문을 사용해 해당 연속된 신호등에 속한 각 신호등을 순회
				for (int idx = start; idx <= start + targetCnt - 1; idx++) {
					
					// 해당 신호등이 망가진 경우 현재 수리한 신호등의 개수를 갱신
					if (isBreakdown[idx])
						count++;
				}
				
			// 첫 연속한 신호등이 아닌 경우
			} else {
				
				// 현재 수리한 신호등의 개수를 갱신
				count = (isBreakdown[start - 1]) ? count - 1 : count;
				count = (isBreakdown[start + targetCnt - 1]) ? count + 1 : count;
			}
			
			// min() 메서드를 사용해 수리해야 하는 신호등의 최소 개수를 갱신
			minCount = Math.min(count, minCount);
		}
		
		// valueOf() 및 write() 메서드를 사용해 수리해야 하는 신호등의 최소 개수를 출력
		out.write(String.valueOf(minCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}