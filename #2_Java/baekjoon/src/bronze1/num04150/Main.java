package bronze1.num04150;

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
		
		// 각 피보나치 수를 저장할 배열 fibonacci 초기화
		BigInteger[] fibonacci = new BigInteger[number + 1];
		
		// 0, 1의 피보나치 수를 갱신
		fibonacci[0] = new BigInteger("0");
		fibonacci[1] = new BigInteger("1");
		
		// for 반복문을 사용해 각 피보나치 수를 갱신
		for (int idx = 2; idx < fibonacci.length; idx++)
			fibonacci[idx] = fibonacci[idx - 1].add(fibonacci[idx - 2]);
		
		// toString() 및 write() 메서드를 사용해 해당하는 피보나치 수를 출력
		out.write(fibonacci[number].toString());
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}