package gold4.num02981;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자의 개수를 변수 numCnt에 할당
		int numCnt = Integer.parseInt(in.readLine());
		
		// 각 숫자를 저장할 배열 numbers 초기화
		int[] numbers = new int[numCnt];
		
		// for 반복문을 사용해 각 숫자를 배열 numbers에 저장
		for (int idx = 0; idx < numCnt; idx++)
			numbers[idx] = Integer.parseInt(in.readLine());
		
		// sort() 메서드를 사용해 배열 numbers를 오름차순으로 정렬
		Arrays.sort(numbers);
		
		// 첫 두 수의 차이를 변수 number에 할당
		int number = numbers[1] - numbers[0];
		
		// for 반복문을 사용해 각 숫자들의 차이를 순회
		for (int idx = 2; idx < numbers.length; idx++)
			
			// gcdFinder() 메서드를 실행해 최대공약수를 도출해 변수 number에 재할당
			number = gcdFinder(number, numbers[idx] - numbers[idx - 1]);
		
		// for 반복문을 사용해 최대공약수의 약수를 순회
		for (int divisor = 2; divisor <= number; divisor++) {
			
			// 약수인 경우 해당 숫자 출력
			if (number % divisor == 0)
				out.write(divisor + " ");
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// gcdFinder() 메서드 정의
	public static int gcdFinder(int number1, int number2) {

		// 최대공약수로 나눌 수 및 최대공약수를 저장할 변수 초기화
		int multiple = number1;
		int divisor = number2;
		
		// while 반복문을 사용해 최대공약수를 구할 때까지 순회
		while (true) {
			
			// 나누어 떨어지는 경우 최대공약수를 반환
			if (multiple % divisor == 0) {
				return divisor;
			
			// 나누어 떨어지지 않는 경우 각 변수를 갱신
			} else {
				int temp = multiple;
				multiple = divisor;
				divisor = temp % divisor;
			}
		}
	}
}