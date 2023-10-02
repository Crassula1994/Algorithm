package silver4.num09613;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// 가능한 모든 쌍의 최대공약수(GCD)의 합을 저장할 변수 sum 초기화
			long sum = 0;
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 수의 개수를 변수 number에 할당
			int number = Integer.parseInt(st.nextToken());
			
			// 각 숫자를 저장할 배열 numbers 초기화
			int[] numbers = new int[number];
			
			// for 반복문을 사용해 각 숫자를 배열 numbers에 저장
			for (int idx = 0; idx < numbers.length; idx++)
				numbers[idx] = Integer.parseInt(st.nextToken());
			
			// for 반복문을 사용해 각 숫자를 순회
			for (int i = 0; i < numbers.length; i++) {
				
				// 해당 숫자를 변수 num1에 할당
				int num1 = numbers[i];
				
				// for 반복문을 사용해 다른 숫자를 순회
				for (int j = i + 1; j < numbers.length; j++) {
					
					// 해당 숫자를 변수 num2에 할당
					int num2 = numbers[j];
					
					// gcdCalculator() 메서드를 호출해 최대공약수를 변수 gcd에 할당
					int gcd = gcdCalculator(Math.max(num1, num2), Math.min(num1, num2));
					
					// 최대공약수의 합을 갱신
					sum += gcd;
				}
			}
			
			// write() 메서드를 사용해 가능한 모든 쌍의 최대공약수(GCD)의 합을 출력
			out.write(sum + "\n");
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// gcdCalculator() 메서드 정의
	private static int gcdCalculator(int num1, int num2) {
		
		// 최대공약수를 찾은 경우 최대공약수를 반환
		if (num2 == 0)
			return num1;
		
		// 최대공약수를 찾지 못한 경우 gcdCalculator() 재귀 호출
		return gcdCalculator(num2, num1 % num2);
	}
}