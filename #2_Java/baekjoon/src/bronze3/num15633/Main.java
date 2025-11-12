package bronze3.num15633;

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

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 자연수를 변수 number에 할당
		int number = Integer.parseInt(in.readLine());
		
		// 약수의 합을 저장할 변수 divisorSum 초기화
		int divisorSum = 0;
		
		// for 반복문을 사용해 각 약수를 순회
		for (int divisor = 1; divisor * divisor <= number; divisor++) {
			
			// 해당 숫자가 약수가 아닌 경우 다음 숫자를 순회
			if (number % divisor != 0)
				continue;
			
			// 해당 약수와 쌍을 이루는 약수를 계산해 변수 pairDivisor에 할당
			int pairDivisor = number / divisor;
			
			// 약수의 합을 갱신
			divisorSum = (divisor == pairDivisor) ? divisorSum + divisor : divisorSum + pairDivisor + divisor;
		}
		
		// valueOf() 및 write() 메서드를 사용해 해당 값에 5를 곱하고 24를 뺀 값을 출력
		out.write(String.valueOf(divisorSum * 5 - 24));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}