package silver1.num24268;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {

	// 기준 숫자, 주어진 진법, 기준 숫자보다 크면서 주어진 진법의 숫자가 모두 한 번씩 나타나는 숫자를 나타낼 각 변수 초기화
	static int lowerLimit;
	static int baseNotation;
	static int targetNumber = Integer.MAX_VALUE;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 기준 숫자와 진법을 각 변수에 할당
		lowerLimit = Integer.parseInt(st.nextToken());
		baseNotation = Integer.parseInt(st.nextToken());
		
		// numberGenerator() 메서드를 호출해 가능한 숫자의 조합을 모두 순회
		numberGenerator(0, 0, 0);
		
		// 기준 숫자보다 크면서 주어진 진법의 숫자가 모두 한 번씩 나타나는 숫자가 존재하지 않는 경우 -1을 출력
		if (targetNumber == Integer.MAX_VALUE) {
			out.write(String.valueOf(-1));
		
		// 기준 숫자보다 크면서 주어진 진법의 숫자가 모두 한 번씩 나타나는 숫자가 존재하는 경우 해당 숫자를 출력
		} else {
			out.write(String.valueOf(targetNumber));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// numberGenerator() 메서드 정의
	public static void numberGenerator(int usedNum, int usedMask, int result) {
		
		// 모든 숫자를 다 사용한 경우
		if (usedNum == baseNotation) {
			
			// 해당 숫자가 기준 숫자보다 큰 경우 기준 숫자보다 크면서 주어진 진법의 숫자가 모두 한 번씩 나타나는 숫자를 갱신
			if (result > lowerLimit)
				targetNumber = Math.min(result, targetNumber);
			
			// 메서드 종료
			return;
		}
		
		// for 반복문을 사용해 각 자리 숫자를 순회
		for (int digit = 0; digit < baseNotation; digit++) {
			
			// 첫 번째 자리 수가 0인 경우 다음 숫자를 순회
			if (usedNum == 0 && digit == 0)
				continue;
		
			// 해당 숫자를 사용한 경우 다음 숫자를 순회
			if ((usedMask & (1 << digit)) != 0)
				continue;
			
			// numberGenerator() 메서드 재귀 호출
			numberGenerator(usedNum + 1, usedMask | (1 << digit), result * baseNotation + digit);
		}
	}
}