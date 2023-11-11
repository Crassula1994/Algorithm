package silver1.num01850;

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
		
		// nextToken() 및 parseLong() 메서드를 사용해 입력 받은 두 자연수를 이루는 1의 개수를 각 변수에 할당
		long numberA = Long.parseLong(st.nextToken());
		long numberB = Long.parseLong(st.nextToken());
		
		// 최대공약수를 저장할 변수 gcd 초기화
		long gcd;
		
		// A가 B보다 크거나 같은 경우 gcdCalculator() 메서드를 호출해 최대공약수를 변수 gcd에 할당
		if (numberA >= numberB) {
			gcd = gcdCalculator(numberA, numberB);
			
		// B가 A보다 큰 경우
		} else {
			gcd = gcdCalculator(numberB, numberA);
		}
		
		// for 반복문을 사용해 A와 B의 최대공약수를 출력
		for (int n = 0; n < gcd; n++)
			out.write("1");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// gcdCalculator() 메서드 정의
	public static long gcdCalculator(long dividend, long divisor) {

		// 피제수가 0인 경우 제수를 반환
		if (divisor == 0)
			return dividend;
		
		// 피제수가 0이 아닌 경우 gcdCalculator() 메서드를 재귀 호출
		return gcdCalculator(divisor, dividend % divisor);
	}
}