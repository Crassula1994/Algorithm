package bronze2.num17173;

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
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 배수의 상한 및 자연수의 개수를 각 변수에 할당
		int upperLimit = Integer.parseInt(st.nextToken());
		int numberCnt = Integer.parseInt(st.nextToken());
		
		// 배수의 판정 기준을 저장할 배열 divisors 초기화
		int[] divisors = new int[numberCnt];
		
		// 배수들의 합을 저장할 변수 sum 초기화
		int sum = 0;
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 배수의 판정 기준을 배열 divisors에 저장
		for (int idx = 0; idx < divisors.length; idx++)
			divisors[idx] = Integer.parseInt(st.nextToken());
		
		// for 반복문을 사용해 각 자연수를 순회
		for (int number = divisors[0]; number <= upperLimit; number++) {
			
			// for 반복문을 사용해 각 배수 판정 기준을 순회
			for (int divisor : divisors) {
				
				// 해당 자연수가 배수 판정 기준의 배수인 경우 배수들의 합을 갱신 후 반복문 탈출
				if (number % divisor == 0) {
					sum += number;
					break;
				}
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 배수들의 합을 출력
		out.write(String.valueOf(sum));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}