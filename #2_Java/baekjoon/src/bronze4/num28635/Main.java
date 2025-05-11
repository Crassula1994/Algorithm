package bronze4.num28635;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		/* readLine() 및 parseInt() 메서드를 사용해 입력 받은 카운터가 표시할 수 있는 정수의 상한,
		현재 카운터의 숫자와 도달하기 위한 카운터의 숫자를 각 변수에 할당 */
		int numberLimit = Integer.parseInt(in.readLine());
		int curNumber = Integer.parseInt(in.readLine());
		int targetNumber = Integer.parseInt(in.readLine());
		
		// 목표 숫자에 도달하기 위해 카운터의 버튼을 눌러야 하는 횟수를 계산해 변수 count에 할당
		int count = (targetNumber >= curNumber) ? targetNumber - curNumber : targetNumber + numberLimit - curNumber;
		
		// valueOf() 및 write() 메서드를 사용해 목표 숫자에 도달하기 위해 카운터의 버튼을 눌러야 하는 횟수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}