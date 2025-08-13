package bronze5.num30664;

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
		
		// while 반복문을 사용해 각 복권의 식별 번호를 순회
		while (true) {
			
			// readLine() 메서드를 사용해 복권의 식별 번호를 변수 ticketNumber에 할당
			BigInteger ticketNumber = new BigInteger(in.readLine());
			
			// 모든 복권을 확인한 경우 반복문 탈출
			if (ticketNumber.equals(BigInteger.ZERO))
				break;
			
			// remainder(), equals(), write() 메서드를 사용해 해당 복권의 식별 번호가 42의 배수인지 여부를 출력
			out.write((ticketNumber.remainder(new BigInteger("42")).equals(BigInteger.ZERO)) ? "PREMIADO" : "TENTE NOVAMENTE");
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}