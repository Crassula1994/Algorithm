package bronze1.num11179;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine(), parseInt(), toBinaryString() 메서드를 사용해 입력 받은 정수를 2진법으로 변환하고 변수 binaryNumber에 할당
		String binaryNumber = Integer.toBinaryString(Integer.parseInt(in.readLine()));
		
		// reverse() 및 toString() 메서드를 사용해 2진법으로 나타낸 정수를 뒤집어 변수 reversedBinaryNumber에 할당
		String reversedBinaryNumber = new StringBuilder(binaryNumber).reverse().toString();
		
		// parseInt(), valueOf(), write() 메서드를 사용해 10진법으로 변환한 결과를 출력
		out.write(String.valueOf(Integer.parseInt(reversedBinaryNumber, 2)));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}