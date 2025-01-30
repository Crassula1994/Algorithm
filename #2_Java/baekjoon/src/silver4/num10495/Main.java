package silver4.num10495;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 입력 받은 게임의 숫자를 저장할 변수 gameNumbers 초기화
		String gameNumbers;
		
		// while 반복문을 사용해 각 게임을 순회
		while ((gameNumbers = in.readLine()) != null) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(gameNumbers);
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 숫자의 개수를 변수 numberCnt에 할당
			int numberCnt = Integer.parseInt(st.nextToken());
			
			// 게임의 숫자와 해당 숫자가 승리를 보장하는 숫자가 아닌지 여부를 저장할 각 배열 초기화
			int[] numbers = new int[numberCnt];
			boolean[] isNotLastNumber = new boolean[numberCnt];
			
			// for 반복문을 사용해 입력 받은 게임의 숫자를 배열 numbers에 저장
			for (int idx = 0; idx < numbers.length; idx++)
				numbers[idx] = Integer.parseInt(st.nextToken());
			
			// sort() 메서드를 사용해 입력 받은 게임의 숫자를 오름차순으로 정렬
			Arrays.sort(numbers);
			
			// for 반복문을 사용해 각 숫자 쌍을 순회
			for (int num1 = numbers.length - 1; num1 >= 0; num1--) {
				for (int num2 = num1 - 1; num2 >= 0; num2--) {
					
					// 해당 숫자 쌍의 최대공약수가 1보다 큰 경우
					if (gcdCalculator(numbers[num1], numbers[num2]) > 1) {
						
						// 해당 숫자 쌍의 승리를 보장하는 숫자가 아닌지 여부를 갱신
						isNotLastNumber[num1] = true;
						isNotLastNumber[num2] = true;
					}
				}
				
				// 해당 숫자가 승리를 보장하는 숫자인 경우 해당 숫자를 출력 후 반복문 탈출
				if (!isNotLastNumber[num1]) {
					out.write(numbers[num1] + "\n");
					break;
				}
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// gcdCalculator() 메서드 정의
	public static int gcdCalculator(int num1, int num2) {
		
		// 해당 숫자가 다른 숫자로 나누어 떨어지는 경우 나눈 숫자가 최대공약수이므로 이를 반환
		if (num1 % num2 == 0)
			return num2;
		
		// gcdCalculator() 메서드를 재귀 호출해 최대공약수를 반환
		return gcdCalculator(num2, num1 % num2);
	}
}