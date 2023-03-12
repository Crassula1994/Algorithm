package silver4.num01748;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
		int number = Integer.parseInt(in.readLine());
		
		// 자릿수의 개수를 저장할 변수 cipherCnt 초기화
		int cipherCnt = 0;
		
		// 나누는 10의 배수 및 자릿수를 저장할 각 변수 초기화
		int divisor = 10;
		int cipher = 1;
		
		// while 반복문을 사용해 자릿수의 개수를 구할 때까지 순회
		while (number >= divisor) {

			// 해당 자릿수의 값을 자릿수의 개수에 갱신
			cipherCnt += (divisor - divisor / 10) * cipher;
			
			// 나누는 10의 배수 및 자릿수 갱신
			divisor *= 10;
			cipher++;
		}
		
		// 남은 숫자를 자릿수의 개수에 갱신
		cipherCnt += (number - (divisor / 10 - 1)) * cipher;
		
		// valueOf() 및 write() 메서드를 사용해 자릿수의 개수를 출력
		out.write(String.valueOf(cipherCnt));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}