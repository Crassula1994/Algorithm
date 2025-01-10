package bronze5.num27434;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 정수를 변수 number에 할당
		int number = Integer.parseInt(in.readLine());
		
		// factorialCalculator(), toString(), write() 메서드를 사용해 팩토리얼을 계산한 결과를 출력
		out.write(factorialCalculator(1, number).toString());
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// factorialCalculator() 메서드 정의
	public static BigInteger factorialCalculator(int start, int end) {
		
		// 0이 입력된 경우 1을 반환
		if (start > end)
			return BigInteger.ONE;
		
		// 범위가 하나의 값인 경우 해당 값을 반환
		if (start == end)
			return BigInteger.valueOf(start);
		
		// 범위의 절반을 계산해 변수 mid에 할당
		int mid = (start + end) / 2;
		
		// factorialCalculator() 메서드를 재귀 호출해 팩토리얼의 절반을 계산하고 이를 각 변수에 할당
		BigInteger firstHalf = factorialCalculator(start, mid);
		BigInteger secondHalf = factorialCalculator(mid + 1, end);
		
		// multiply() 메서드를 사용해 팩토리얼을 계산한 결과를 반환
		return firstHalf.multiply(secondHalf);
	}
}