package silver4.num31474;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 양갈래 손님의 수를 변수 customerNum에 할당
		int customerNum = Integer.parseInt(in.readLine());
		
		// 경우의 수를 계산하기 위해 필요한 분모와 분자를 저장할 각 변수 초기화
		BigInteger dividend = new BigInteger("1");
		BigInteger divisor = new BigInteger("1");
		
		// for 반복문을 사용해 경우의 수를 계산하기 위해 필요한 분모를 갱신
		for (int n = 1; n <= customerNum / 2; n++)
			divisor = divisor.multiply(new BigInteger(String.valueOf(n)));
		
		// for 반복문을 사용해 경우의 수를 계산하기 위해 필요한 분자를 갱신
		for (int n = 1; n <= customerNum / 2; n++)
			dividend = dividend.multiply(new BigInteger(String.valueOf(combCalculator(n * 2))));
		
		// divide(), toString(), write() 메서드를 사용해 양갈래 손님들이 앉을 수 있는 경우의 수를 출력
		out.write(dividend.divide(divisor).toString());
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ------------------------------------------------------------------------------------------
	
	// combCalculator() 메서드 정의
	public static int combCalculator(int number) {
		
		// 주어진 손님 중 한 쌍의 손님을 뽑는 경우의 수를 반환
		return number * (number - 1) / 2;
	}
}