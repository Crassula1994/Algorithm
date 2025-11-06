package bronze1.num27494;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 목표로 하는 당첨 번호를 저장할 배열 winningNumber 초기화
	static int[] winningNumber = {2, 0, 2, 3};
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 흑묘 복권의 티켓 수를 변수 ticketNum에 할당
		int ticketNum = Integer.parseInt(in.readLine());
		
		// 흑묘 복권의 당첨 티켓 수를 저장할 변수 count 초기화
		int count = 0;
		
		// for 반복문을 사용해 각 티켓의 시리얼 번호를 순회
		for (int number = 2023; number <= ticketNum; number++)
			count += ticketChecker(number);
		
		// valueOf() 및 write() 메서드를 사용해 흑묘 복권의 당첨 티켓 수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// ticketChecker() 메서드 정의
	public static int ticketChecker(int number) {
		
		// 현재 확인 중인 당첨 번호의 자릿수를 나타낼 변수 winningIdx 초기화
		int winningIdx = winningNumber.length - 1;
		
		// while 반복문을 사용해 시리얼 번호의 모든 자릿수를 순회할 때까지 순회
		while (number > 0) {
			
			// 해당 자릿수와 당첨 번호의 자릿수가 같고 모든 당첨 번호가 순서대로 일치하는 경우 1을 반환
			if (number % 10 == winningNumber[winningIdx] && --winningIdx < 0)
				return 1;
			
			// 현재 시리얼 번호를 갱신
			number /= 10;
		}
		
		// 당첨 번호가 아닌 경우 0을 반환
		return 0;
	}
}