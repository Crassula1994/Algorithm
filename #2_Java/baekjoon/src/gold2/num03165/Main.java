package gold2.num03165;

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
		
		// nextToken(), parseLong(), parseInt() 메서드를 사용해 입력 받은 자연수의 하한 및 5가 포함되는 횟수를 각 변수에 할당
		long lowerLimit = Long.parseLong(st.nextToken());
		int targetCount = Integer.parseInt(st.nextToken());
		
		// minNumberFinder(), valueOf(), write() 메서드를 사용해 주어진 5가 포함되는 자연수의 하한 이상인 가장 작은 수를 출력
		out.write(String.valueOf(minNumberFinder(lowerLimit + 1, targetCount)));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// minNumberFinder() 메서드 정의
	public static long minNumberFinder(long number, int targetCount) {
		
		// 현재 숫자에 포함된 5의 개수가 5가 포함되는 횟수 이상인 경우 현재 숫자를 반환
		if (fiveCounter(number) >= targetCount)
			return number;
		
		// 현재 숫자의 마지막 자릿수를 변수 lastDigit에 할당
		int lastDigit = (int) (number % 10);
		
		// 현재 숫자의 마지막 자릿수를 제거
		number /= 10;
		
		// 가장 마지막 자릿수가 5 초과인 경우
		if (lastDigit > 5) {
			
			// 현재 숫자의 다음 자릿수를 높인 숫자에 포함된 5의 개수가 5가 포함되는 횟수 이상인 경우 해당 숫자를 반환
			if (fiveCounter(++number) >= targetCount)
				return number * 10;
		}
		
		// minNumberFinder() 메서드를 재귀 호출해 가장 낮은 자릿수를 5로 바꾼 수를 반환
		return minNumberFinder(number, targetCount - 1) * 10 + 5;
	}
	
	// ----------------------------------------------------------------------------------------------------

	// fiveCounter() 메서드 정의
	public static int fiveCounter(long number) {
		
		// 주어진 숫자에 포함된 숫자 5의 개수를 저장할 변수 count 초기화
		int count = 0;
		
		// while 반복문을 사용해 각 자릿수를 순회
		while (number > 0) {
			
			// 현재 자릿수가 5인 경우 주어진 숫자에 포함된 숫자 5의 개수를 갱신
			if (number % 10 == 5)
				count++;
			
			// 현재 숫자를 갱신
			number /= 10;
		}
		
		// 주어진 숫자에 포함된 숫자 5의 개수를 반환
		return count;
	}
}