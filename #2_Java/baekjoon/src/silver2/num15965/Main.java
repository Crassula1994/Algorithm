package silver2.num15965;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 소수의 순서를 변수 targetOrder에 할당
		int targetOrder = Integer.parseInt(in.readLine());
		
		// log() 메서드를 사용해 로서의 정리(Rosser's Theorem)에 따른 소수의 근삿값을 계산하고 변수 approximation에 할당
		double approximation = targetOrder * (Math.log(targetOrder) + Math.log(Math.log(targetOrder)));
		
		// max() 메서드를 사용해 소수를 찾을 범위의 상한을 변수 upperLimit에 할당
		int upperLimit = Math.max(3, (int) approximation + 2);
		
		// 해당 숫자가 소수가 아닌지 여부를 저장할 배열 isNotPrime 초기화
		boolean[] isNotPrime = new boolean[upperLimit + 1];
		
		// 0과 1은 소수가 아니므로 값을 초기화
		isNotPrime[0] = true;
		isNotPrime[1] = true;
		
		// for 반복문을 사용해 각 숫자를 순회
		for (int number = 2; number <= upperLimit; number++) {
			
			// 해당 숫자가 소수가 아닌 경우 다음 숫자를 순회
			if (isNotPrime[number])
				continue;
			
			// for 반복문을 사용해 해당 소수의 배수를 소수가 아닌 것으로 갱신
			for (int multiple = number * 2; multiple <= upperLimit; multiple += number)
				isNotPrime[multiple] = true;
		}
		
		// for 반복문을 사용해 각 숫자를 순회
		for (int number = 0, count = 0; number <= upperLimit; number++) {
			
			// 해당 숫자가 소수가 아닌 경우 다음 숫자를 순회
			if (isNotPrime[number])
				continue;
			
			// 해당 소수가 입력 받은 소수의 순서와 일치하는 경우 해당 소수를 출력 후 반복문 탈출
			if (++count == targetOrder) {
				out.write(String.valueOf(number));
				break;
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}