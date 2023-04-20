package bronze5.num02338;

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
		
		// readLine() 메서드를 사용해 입력 받은 두 숫자를 각 변수에 할당
		BigInteger numberA = new BigInteger(in.readLine());
		BigInteger numberB = new BigInteger(in.readLine());		
		
		// add(), subtract(), multiply() 메서드를 사용해 더하기, 빼기, 곱하기 연산을 한 결과를 각 변수에 저장
		BigInteger addResult = numberA.add(numberB);
		BigInteger subtractResult = numberA.subtract(numberB);
		BigInteger multiplyResult = numberA.multiply(numberB);
		
		// write() 메서드를 사용해 각 연산의 결과를 출력
		out.write(addResult + "\n" + subtractResult + "\n" + multiplyResult);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}