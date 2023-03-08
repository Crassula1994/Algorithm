package silver1.num06588;

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
		
		// 소수인지 여부를 저장할 배열 isNotPrimeNum 초기화
		boolean[] isNotPrimeNum = new boolean[1000001];
		
		// 0과 1의 값은 소수가 아니므로 초기화
		isNotPrimeNum[0] = true;
		isNotPrimeNum[1] = true;
		
		// for 반복문을 사용해 소수인지 차례로 검사
		for (int pNum = 2; pNum <= 1000; pNum++) {
			
			// 해당 숫자가 소수가 아닌 경우 다음 숫자로 넘기기
			if (isNotPrimeNum[pNum])
				continue;
			
			// for 반복문을 사용해 소수가 아닌 경우 배열 갱신
			for (int idx = pNum * pNum; idx < 1000001; idx += pNum)
				isNotPrimeNum[idx] = true;
		}
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (true) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
			int number = Integer.parseInt(in.readLine());
			
			// 골드바흐의 추측이 성립하는지를 나타낼 변수 isValid 초기화
			boolean isValid = false;
			
			// 0이 입력된 경우 반복문 탈출
			if (number == 0)
				break;
			
			// for 반복문을 사용해 isNotPrimeNum의 각 홀수 원소를 순회
			for (int idx = 1; idx <= number / 2; idx += 2) {

				// 두 수를 더했을 때 입력 받은 숫자가 되는 두 수가 소수인 경우
				if (!isNotPrimeNum[idx] && !isNotPrimeNum[number - idx]) {
					
					// write() 메서드를 사용해 각 소수를 차례로 출력
					out.write(number + " = " + idx + " + " + (number - idx) + "\n");
					
					// 골드바흐의 추측이 성립하므로 변수 isValid 갱신
					isValid = true;
					
					// 반복문 탈출
					break;
				}
			}
			
			// 골드바흐의 추측이 성립하지 않는 경우 정해진 문구 출력
			if (!isValid)
				out.write("Goldbach's conjecture is wrong.\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}