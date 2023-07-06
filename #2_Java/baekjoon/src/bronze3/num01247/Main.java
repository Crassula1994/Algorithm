package bronze3.num01247;

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

		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < 3; tc++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 정수의 개수를 변수 number에 할당
			int number = Integer.parseInt(in.readLine());
			
			// 정수들의 합을 저장할 BigInteger 객체 sum 초기화
			BigInteger sum = BigInteger.ZERO;
			
			// for 반복문을 사용해 입력 받은 정수를 합산
			for (int n = 0; n < number; n++)
				sum = sum.add(new BigInteger(in.readLine()));
			
			// 해당 정수의 합의 부호를 변수 result에 할당
			String result = (sum.compareTo(BigInteger.ZERO) == 0) ? "0" : (sum.compareTo(BigInteger.ZERO) < 0) ? "-" : "+";

			// write() 메서드를 사용해 정수의 합의 부호를 출력
			out.write(result + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}