package bronze5.num08437;

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
		
		// readLine() 메서드를 사용해 입력 받은 사과의 총 개수 및 클라우디아가 더 가지고 있는 사과의 개수를 각 변수에 할당
		BigInteger totalCount = new BigInteger(in.readLine());
		BigInteger difference = new BigInteger(in.readLine());
		
		// subtract(), divide(), add() 메서드를 사용해 나탈리아와 클라우디아가 가지고 있는 사과의 개수를 계산하고 이를 각 변수에 할당
		BigInteger nataliaCount = totalCount.subtract(difference).divide(new BigInteger("2"));
		BigInteger klaudiaCount = nataliaCount.add(difference);
		
		// toString() 및 write() 메서드를 사용해 클라우디아와 나탈리아가 가진 사과의 개수를 출력
		out.write(klaudiaCount.toString() + "\n" + nataliaCount.toString());
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}