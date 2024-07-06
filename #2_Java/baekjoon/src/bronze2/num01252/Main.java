package bronze2.num01252;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
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
		
		// nextToken() 메서드를 사용해 입력 받은 두 이진수를 각 변수에 할당
		BigInteger numberA = new BigInteger(st.nextToken(), 2);
		BigInteger numberB = new BigInteger(st.nextToken(), 2);
		
		// add(), toString(), write() 메서드를 사용해 두 숫자를 더한 결과를 출력
		out.write(numberA.add(numberB).toString(2));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}