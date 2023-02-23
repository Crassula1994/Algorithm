package silver2.num04948;

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

		// while 반복문을 사용해 0이 입력될 때까지 순회
		while (true) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
			int number = Integer.parseInt(in.readLine());
			
			// 입력 받은 숫자가 0인 경우 반복문 탈출
			if (number == 0)
				break;
			
			// 소수인지 여부를 저장할 배열 isNotPrimeNum 초기화
			boolean[] isNotPrimeNum = new boolean[number * 2 + 1];
			
			// 0과 1의 값은 소수가 아니므로 초기화
			isNotPrimeNum[0] = true;
			isNotPrimeNum[1] = true;
			
			// for 반복문을 사용해 소수인지 차례로 검사
			for (int pNum = 2; pNum <= Math.sqrt(number * 2); pNum++) {
				
				// 해당 숫자가 소수가 아닌 경우 다음 숫자로 넘기기
				if (isNotPrimeNum[pNum])
					continue;
				
				// for 반복문을 사용해 소수가 아닌 경우 배열 갱신
				for (int idx = pNum * pNum; idx < number * 2 + 1; idx += pNum)
					isNotPrimeNum[idx] = true;
			}
			
			// 소수의 개수를 저장할 변수 count 초기화
			int count = 0;
			
			// for 반복문을 사용해 배열 isNotPrimeNum의 각 원소를 순회
			for (int idx = number + 1; idx < number * 2 + 1; idx++) {

				// 소수인 경우 소수의 개수 갱신
				if (!isNotPrimeNum[idx])
					count++;
			}
			
			// write() 메서드를 사용해 소수의 개수 출력
			out.write(count + "\n");
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}