package silver4.num13706;

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
		
		// readLine() 메서드를 사용해 입력 받은 양의 정수를 변수 number에 할당
		BigInteger number = new BigInteger(in.readLine());
		
		// sqrtCalculator() 및 write() 메서드를 사용해 해당 양의 정수의 제곱근을 출력
		out.write(sqrtCalculator(number));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// sqrtCalculator() 메서드 정의
	public static String sqrtCalculator(BigInteger number) {
		
		// bitLength() 및 setBit() 메서드를 사용해 이전 제곱근의 근삿값과 현재 제곱근의 근삿값을 각 변수에 할당
		BigInteger curSqrt = BigInteger.ZERO.setBit(number.bitLength() / 2);
		BigInteger prevSqrt = curSqrt;
		
		// while 반복문을 사용해 제곱근을 찾을 때까지 순회
		while (true) {
			
			/* divide(), add(), shiftRight() 메서드를 사용해 뉴턴-랩슨 방법(Newton-Rapshon Method)을 통한
			새로운 제곱근 근삿값을 변수 sqrt에 할당 */
			BigInteger sqrt = curSqrt.add(number.divide(curSqrt)).shiftRight(1);
			
			// 새로운 제곱근 근삿값이 현재 제곱근 근삿값 또는 이전 제곱근 근삿값과 같은 경우 해당 제곱근 근삿값을 반환
			if (sqrt.equals(curSqrt) || sqrt.equals(prevSqrt))
				return sqrt.toString();
			
			// 현재 및 이전 제곱근의 근삿값을 갱신
			prevSqrt = curSqrt;
			curSqrt = sqrt;
		}
	}
}