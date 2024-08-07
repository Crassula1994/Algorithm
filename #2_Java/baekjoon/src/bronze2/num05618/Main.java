package bronze2.num05618;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 자연수의 개수를 변수 numberCnt에 할당
		int numberCnt = Integer.parseInt(in.readLine());
		
		// 주어진 숫자 중 가장 작은 숫자를 저장할 변수 minNumber 초기화
		int minNumber = Integer.MAX_VALUE;
		
		// 각 숫자를 저장할 배열 numbers 초기화
		int[] numbers = new int[numberCnt];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 숫자를 순회
		for (int idx = 0; idx < numbers.length; idx++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 배열 numbers에 저장
			numbers[idx] = Integer.parseInt(st.nextToken());
			
			// min() 메서드를 사용해 주어진 숫자 중 가장 작은 숫자를 갱신
			minNumber = Math.min(numbers[idx], minNumber);
		}
		
		// for 반복문을 사용해 가능한 공약수를 모두 순회
		for (int divisor = 1; divisor <= minNumber; divisor++) {
			
			// 해당 숫자가 공약수인지 여부를 나타낼 변수 isDivisor 초기화
			boolean isDivisor = true;
			
			// for 반복문을 사용해 각 숫자를 순회
			for (int number : numbers) {
				
				// 해당 숫자가 공약수가 아닌 경우 공약수인지 여부를 갱신 후 반복문 탈출
				if (number % divisor != 0) {
					isDivisor = false;
					break;
				}	
			}
			
			// 해당 숫자가 공약수인 경우 해당 숫자를 출력
			if (isDivisor)
				out.write(divisor + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}