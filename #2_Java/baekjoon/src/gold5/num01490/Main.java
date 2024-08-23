package gold5.num01490;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

// Main 클래스 정의
public class Main {
	
	// 각 자릿수가 존재하는지 여부를 나타낼 배열 isDigit 초기화
	static boolean[] isDigit = new boolean[10];
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 메서드를 사용해 입력 받은 숫자를 변수 numberStr 할당
		String numberStr = in.readLine();
		
		// for 반복문을 사용해 각 자릿수가 존재하는지 여부를 갱신
		for (int idx = 0; idx < numberStr.length(); idx++)
			isDigit[numberStr.charAt(idx) - '0'] = true;
		
		// 가능한 숫자를 저장할 Queue 객체 numbers 초기화
		Queue<Long> numbers = new LinkedList<>();
		
		// parseLong() 및 offer() 메서드를 사용해 입력 받은 숫자를 numbers에 추가
		numbers.offer(Long.parseLong(numberStr));
		
		// while 반복문을 사용해 모든 자릿수로 나누어 떨어지는 가장 작은 수를 찾을 때까지 순회
		while (true) {
			
			// poll() 메서드를 사용해 현재 숫자를 변수 curNumber에 할당
			long curNumber = numbers.poll();
			
			// digitDivider() 메서드를 호출해 해당 숫자가 모든 자릿수로 나누어 떨어지는지 여부를 변수 isPossible에 할당
			boolean isPossible = digitDivider(curNumber);
			
			// 해당 숫자가 모든 자릿수로 나누어 떨어지는 경우 해당 숫자 출력 후 반복문 탈출
			if (isPossible) {
				out.write(String.valueOf(curNumber));
				break;
			}
			
			// for 반복문을 사용해 가능한 숫자를 numbers에 추가
			for (int digit = 0; digit < 10; digit++)
				numbers.offer(curNumber * 10 + digit);
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// digitDivider() 메서드 정의
	public static boolean digitDivider(long number) {
		
		// for 반복문을 사용해 각 자릿수를 순회
		for (int digit = 1; digit < 10; digit++) {
			
			// 해당 자릿수가 존재하지 않는 경우 다음 자릿수를 순회
			if (!isDigit[digit])
				continue;
			
			// 해당 자릿수로 나누어 떨어지지 않는 경우 false 반환
			if (number % digit != 0)
				return false;
		}
		
		// 모든 자릿수로 나누어 떨어지는 경우 true 반환
		return true;
	}
}