package gold4.num02374;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 자연수의 개수, 이전에 확인할 숫자를 각 변수에 할당
		int numberCnt = Integer.parseInt(in.readLine()) - 1;
		int prevNumber = Integer.parseInt(in.readLine());
		
		// 같은 수로 만들고자 하는 목표 숫자, 최소의 Add 연산 사용 횟수를 저장할 각 변수 초기화
		int targetNumber = prevNumber;
		long minCount = 0;
		
		// while 반복문을 사용해 각 자연수를 순회
		while (numberCnt-- > 0) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 자연수를 변수 curNumber에 할당
			int curNumber = Integer.parseInt(in.readLine());
			
			// max() 메서드를 사용해 같은 수로 만들고자 하는 목표 숫자를 갱신
			targetNumber = Math.max(curNumber, targetNumber);
				
			// 이전의 저장된 숫자보다 큰 경우 최소의 Add 연산 사용 횟수 및 저장된 숫자 갱신
			if (curNumber > prevNumber) {
				minCount += curNumber - prevNumber;
				prevNumber = curNumber;
				
			// 이전의 저장된 숫자보다 작은 경우 저장된 숫자 갱신
			} else if (curNumber < prevNumber) {
				prevNumber = curNumber;
			}
		}
		
		// 같은 수로 만들고자 하는 목표 숫자와의 차이만큼 최소의 Add 연산 사용 횟수를 갱신
		minCount += targetNumber - prevNumber;
		
		// valueOf() 및 write() 메서드를 사용해 최소의 Add 연산 사용 횟수를 출력
		out.write(String.valueOf(minCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}