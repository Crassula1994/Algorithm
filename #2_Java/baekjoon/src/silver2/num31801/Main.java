package silver2.num31801;

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
		
		// 각 숫자까지의 증가 후 감소하는 수의 개수를 저장할 배열 counts 초기화
		int[] counts = new int[1000001];
		
		// for 반복문을 사용해 fluctuationFinder() 메서드를 호출하고 증가 후 감소하는 수의 개수를 갱신
		for (int n = 1; n < counts.length; n++)
			counts[n] = (fluctuationFinder(n)) ? counts[n - 1] + 1 : counts[n - 1];
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 두 양의 정수를 각 변수에 할당
			int numberA = Integer.parseInt(st.nextToken());
			int numberB = Integer.parseInt(st.nextToken());
			
			// 증가 후 감소하는 수의 개수를 계산해 변수 totalCount에 할당
			int totalCount = counts[numberB] - counts[numberA - 1];
			
			// write() 메서드를 사용해 증가 후 감소하는 수의 개수를 출력
			out.write(totalCount + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// fluctuationFinder() 메서드 정의
	public static boolean fluctuationFinder(int number) {
		
		// 해당 숫자가 세 자리 수 미만인 경우 false 반환
		if (number < 100)
			return false;
		
		// 해당 숫자가 이전에 증가하거나 감소한 적이 있는지를 나타낼 변수 isDecreased 초기화
		boolean isIncreased = false;
		boolean isDecreased = false;
		
		// valueOf() 메서드를 사용해 해당 숫자를 문자열로 변환한 결과를 변수 numStr에 할당
		String numStr = String.valueOf(number);
		
		// for 반복문을 사용해 각 자릿수를 순회
		for (int idx = 1; idx < numStr.length(); idx++) {
			
			// charAt() 메서드를 사용해 현재와 이전 자릿수를 각 변수에 할당
			int curDigit = numStr.charAt(idx) - '0';
			int prevDigit = numStr.charAt(idx - 1) - '0';
			
			// 같은 숫자가 연속된 경우 false 반환
			if (curDigit == prevDigit)
				return false;
			
			// 해당 숫자가 증가하고 있는 경우
			if (curDigit > prevDigit) {
				
				// 해당 숫자가 이전에 증가한 적이 있는지를 나타낼 변수 갱신
				isIncreased = true;
				
				// 이미 이전에 감소한 경우 false 반환
				if (isDecreased)
					return false;
				
			// 해당 숫자가 감소하고 있는 경우 해당 숫자가 이전에 감소한 적이 있는지를 나타낼 변수 갱신
			} else {
				isDecreased = true;
			}
		}
		
		// 해당 숫자가 증가 후 감소하는 수인지를 반환
		return isIncreased && isDecreased;
	}
}