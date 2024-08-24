package gold4.num27740;

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
	
	// Count 클래스 정의
	static class Count {
		
		// L-시프트 및 R-시프트를 했을 때 이동하는 데 필요한 연산 횟수를 저장할 각 변수 초기화
		int countL;
		int countR;
		
		// 매개변수를 입력 받는 생성자 정의
		public Count(int countL, int countR) {
			this.countL = countL;
			this.countR = countR;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 수열의 길이를 변수 length에 할당
		int length = Integer.parseInt(in.readLine());
		
		// 연산 최소 적용 횟수 및 각 시프트 연산을 시행할 최소 횟수를 저장할 각 변수 초기화
		int minCount = Integer.MAX_VALUE;
		int minCountL = 0;
		int minCountR = 0;
		
		// L-시프트 및 R-시프트를 했을 때 해당 위치까지 이동하는 데 필요한 연산 횟수를 저장할 List 객체 counts 초기화
		List<Count> counts = new ArrayList<>();
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 수열의 각 원소를 순회
		for (int idx = 1; idx <= length; idx++) {
			
			// 입력 받은 수열의 원소가 0인 경우 다음 수열을 순회
			if (Integer.parseInt(st.nextToken()) == 0)
				continue;
			
			// add() 메서드를 사용해 해당 수열까지 이동하는 데 필요한 연산 횟수를 counts에 저장
			counts.add(new Count(idx, length - idx + 1));
		}
		
		// for 반복문을 사용해 원소가 1인 각 원소를 순회
		for (int idx = -1; idx < counts.size(); idx++) {
			
			/* get() 및 size() 메서드를 사용해 해당 원소까지 왼쪽으로 이동시켜야 하는 횟수,
			그 다음 1인 원소를 오른쪽으로 이동시켜야 하는 횟수를 각 변수에 할당 */
			int countL = (idx < 0) ? 0 : counts.get(idx).countL;
			int countR = (idx + 1 < counts.size()) ? counts.get(idx + 1).countR : 0;
			
			// min() 메서드를 사용해 이동 횟수를 계산하고 변수 moveCount에 할당
			int moveCount = countL + countR + Math.min(countL, countR);
			
			// 해당 이동 횟수가 연산 최소 적용 횟수인 경우 연산 최소 적용 횟수 및 각 시프트 연산을 시행할 최소 횟수를 갱신
			if (minCount > moveCount) {
				minCount = moveCount;
				minCountL = (countL > countR) ? countL + countR : countL; 
				minCountR = (countL > countR) ? countR : countL + countR;
			}
		}
		
		// shiftCalculator() 및 write() 메서드를 사용해 연산 최소 적용 횟수 및 각 시프트 연산의 시행 방법을 출력
		out.write(minCount + "\n");
		out.write(shiftCalculator(minCountL, minCountR));
			
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// shiftCalculator() 메서드 정의
	public static String shiftCalculator(int minCountL, int minCountR) {
		
		// 시프트 연산의 시행 방법을 저장할 StringBuilder 객체 sb 초기화
		StringBuilder sb = new StringBuilder();
		
		// 왼쪽으로 보내는 연산이 더 작은 경우
		if (minCountL < minCountR) {
			
			// for 반복문을 사용해 'L'을 sb에 추가
			for (int c = 0; c < minCountL; c++)
				sb.append("L");
			
			// for 반복문을 사용해 'R'을 sb에 추가
			for (int c = 0; c < minCountR; c++)
				sb.append("R");
			
		// 오른쪽으로 보내는 연산이 더 작은 경우
		} else {
			
			// for 반복문을 사용해 'R'을 sb에 추가
			for (int c = 0; c < minCountR; c++)
				sb.append("R");
			
			// for 반복문을 사용해 'L'을 sb에 추가
			for (int c = 0; c < minCountL; c++)
				sb.append("L");
		}
		
		// toString() 메서드를 사용해 해당 시프트 연산의 시행 방법을 반환
		return sb.toString();
	}
}