package bronze1.num01526;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 가장 큰 금민수를 저장할 변수 maxNumber 초기화
	static int maxNumber = 0;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
		int number = Integer.parseInt(in.readLine());
		
		// numberFinder() 메서드를 호출해 가장 큰 금민수를 갱신
		numberFinder(4, number);
		numberFinder(7, number);
		
		// valueOf() 및 write() 메서드를 사용해 가장 큰 금민수를 출력
		out.write(String.valueOf(maxNumber));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// numberFinder() 메서드 정의
	public static void numberFinder(int currentNumber, int upperBound) {

		// 현재의 금민수가 상한보다 더 큰 숫자인 경우 메서드 종료
		if (currentNumber > upperBound)
			return;
		
		// max() 메서드를 사용해 해당 숫자가 현재 저장된 가장 큰 금민수보다 큰 경우 갱신
		maxNumber = Math.max(currentNumber, maxNumber);
		
		// numberFinder() 메서드 재귀 호출
		numberFinder(currentNumber * 10 + 4, upperBound);
		numberFinder(currentNumber * 10 + 7, upperBound);
	}
}