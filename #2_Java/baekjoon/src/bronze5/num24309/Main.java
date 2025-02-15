package bronze5.num24309;

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
		
		// readLine() 메서드를 사용해 입력 받은 자연수를 각 변수에 할당
		BigInteger numberA = new BigInteger(in.readLine());
		BigInteger numberB = new BigInteger(in.readLine());
		BigInteger numberC = new BigInteger(in.readLine());
		
		// subtract(), divide(), toString(), write() 메서드를 사용해 주어진 등식을 만족하는 자연수 x를 출력
		out.write(numberB.subtract(numberC).divide(numberA).toString());
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}